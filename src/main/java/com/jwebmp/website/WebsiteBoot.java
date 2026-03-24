package com.jwebmp.website;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportProvider;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportProvider;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.services.RouterOutlet;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.webawesome.components.icon.WaIcon;
import com.jwebmp.webawesome.components.tabgroup.WaTab;
import com.jwebmp.webawesome.components.tabgroup.WaTabGroup;
import com.jwebmp.webawesome.components.toast.WaToastDataService;
import com.jwebmp.webawesome.components.tree.WaTree;
import com.jwebmp.webawesome.components.tree.WaTreeItem;
import com.jwebmp.webawesomepro.components.page.WaPage;

import java.util.List;

/**
 * Top-level boot component for the JWebMP website.
 * <p>
 * The WaPage is the outermost shell.  The banner holds a WaTabGroup
 * for project switching.  Header, menu, and navigation live in their
 * normal page slots.  The main content area holds the tab panels —
 * the active "JWebMP" panel contains the RouterOutlet for page routing.
 */
@NgComponent("jwebmp-app")
@NgRoutable(path = "", redirectTo = "home", pathMatch = "full", ignoreComponent = true)
@NgImportProvider("{provide: LOCALE_ID, useValue: 'en-ZA'}")
@NgBootImportProvider(value = "{ provide: LOCALE_ID, useValue: 'en-ZA' }")
@NgBootImportReference(value = "provideHttpClient", reference = "@angular/common/http")
@NgBootImportProvider("provideHttpClient()")
@NgBootImportReference(value = "LOCALE_ID", reference = "@angular/core")
@NgBootImportReference(value = "localeEnZa", reference = "@angular/common/locales/en-ZA", direct = true)
@NgImportReference(value = "localeEnZa", reference = "@angular/common/locales/en-ZA", direct = true, wrapValueInBraces = false)
@NgComponentReference(WaToastDataService.class)
public class WebsiteBoot extends DivSimple<WebsiteBoot> implements INgComponent<WebsiteBoot> {
    public WebsiteBoot() {
        addStyle("width:100%");
        addStyle("height:100%");
        addClass("wa-dark");

        // ── WaPage is the top-level shell ──
        WaPage<?> page = new WaPage<>();
        page.setNavOpen(true);
        page.addStyle("width:100%");
        page.addStyle("height:100%");

        // ── Banner: project-switcher tabs ──
        var banner = page.getBanner();
        WaTabGroup<?> tabs = new WaTabGroup<>();
        tabs.add(new WaTab<>().setPanel("jwebmp").addClass("wa-brand-green").add(new WaIcon<>("code")).add("JWebMP"));
        tabs.add(new WaTab<>().setPanel("guicedee").addClass("wa-brand-pink").add(new WaIcon<>("cubes")).add("GuicedEE"));
        tabs.add(new WaTab<>().setPanel("entityassist").addClass("wa-brand-blue").add(new WaIcon<>("database")).add("Entity Assist"));
        tabs.add(new WaTab<>().setPanel("activitymaster").addClass("wa-brand-yellow").add(new WaIcon<>("tasks")).add("Activity Master"));

       // tabs.add(new WaTabPanel<>().setName("jwebmp").add(new RouterOutlet()));
       /* tabs.add(new WaTabPanel<>().setName("guicedee").addStyle("height:100%").add("GuicedEE — coming soon."));
        tabs.add(new WaTabPanel<>().setName("entityassist").addStyle("height:100%").add("Entity Assist — coming soon."));
        tabs.add(new WaTabPanel<>().setName("activitymaster").addStyle("height:100%").add("Activity Master — coming soon."));*/

        tabs.addAttribute("active","jwebmp");
        banner.add(tabs);

        // ── Header ──
        var header = page.getHeader();
        header.add("JWebMP");

        // ── Menu: WaTree navigation with sub-items ──
        var menu = page.getMenu();
        WaTree<?> menuTree = new WaTree<>();

        // Home
        var homeItem = createRouterTreeItem("/home", "Home", "house");
        homeItem.add(createRouterTreeItem("/home/why-jwebmp", "Why JWebMP", null));
        homeItem.add(createRouterTreeItem("/home/annotation-driven", "Annotation-Driven", null));
        homeItem.add(createRouterTreeItem("/home/reactive-stack", "Reactive Stack", null));
        homeItem.add(createRouterTreeItem("/home/real-time-overview", "Real-Time Overview", null));
        homeItem.add(createRouterTreeItem("/home/component-ecosystem", "Component Ecosystem", null));
        homeItem.add(createRouterTreeItem("/home/developer-experience", "Developer Experience", null));
        homeItem.add(createRouterTreeItem("/home/production-ready", "Production Ready", null));
        homeItem.setExpanded(true);
        menuTree.add(homeItem);

        // Getting Started
        var gsItem = createRouterTreeItem("/getting-started", "Getting Started", "rocket");
        gsItem.add(createRouterTreeItem("/getting-started/prerequisites", "Prerequisites", null));
        gsItem.add(createRouterTreeItem("/getting-started/maven-project", "Maven Project", null));
        gsItem.add(createRouterTreeItem("/getting-started/module-descriptor", "Module Descriptor", null));
        gsItem.add(createRouterTreeItem("/getting-started/bootstrap", "Bootstrap", null));
        gsItem.add(createRouterTreeItem("/getting-started/application", "Application", null));
        gsItem.add(createRouterTreeItem("/getting-started/first-component", "First Component", null));
        gsItem.add(createRouterTreeItem("/getting-started/build-and-run", "Build & Run", null));
        gsItem.add(createRouterTreeItem("/getting-started/whats-happening", "What's Happening", null));
        gsItem.add(createRouterTreeItem("/getting-started/next-steps", "Next Steps", null));
        menuTree.add(gsItem);

        // Architecture
        var archItem = createRouterTreeItem("/architecture", "Architecture", "sitemap");
        archItem.add(createRouterTreeItem("/architecture/stack", "Stack Diagram", null));
        archItem.add(createRouterTreeItem("/architecture/build-pipeline", "Build Pipeline", null));
        archItem.add(createRouterTreeItem("/architecture/runtime", "Runtime", null));
        archItem.add(createRouterTreeItem("/architecture/data-flow", "Data Flow", null));
        archItem.add(createRouterTreeItem("/architecture/module-graph", "Module Graph", null));
        menuTree.add(archItem);

        // Plugins & Components — category tree
        var pluginsItem = createRouterTreeItem("/plugins", "Plugins & Components", "puzzle-piece");

        // Rendering & UI
        var catRendering = createRouterTreeItem("/plugins", "Rendering & UI", null);
        catRendering.add(createRouterTreeItem("/plugins/core", "JWebMP Core", null));
        catRendering.add(createRouterTreeItem("/plugins/client", "JWebMP Client", null));
        catRendering.add(createRouterTreeItem("/plugins/web-awesome", "WebAwesome", null));
        catRendering.add(createRouterTreeItem("/plugins/web-awesome-pro", "WebAwesome Pro", null));
        pluginsItem.add(catRendering);

        // Angular Generation
        var catAngular = createRouterTreeItem("/plugins", "Angular Generation", null);
        catAngular.add(createRouterTreeItem("/plugins/angular", "Angular Plugin", null));
        catAngular.add(createRouterTreeItem("/plugins/angular-maven-plugin", "Angular Maven Plugin", null));
        catAngular.add(createRouterTreeItem("/plugins/typescript-client", "TypeScript Client", null));
        pluginsItem.add(catAngular);

        // Data & Grids
        var catData = createRouterTreeItem("/plugins", "Data & Grids", null);
        catData.add(createRouterTreeItem("/plugins/aggrid", "AG Grid", null));
        catData.add(createRouterTreeItem("/plugins/aggrid-enterprise", "AG Grid Enterprise", null));
        pluginsItem.add(catData);

        // Charts & Visualisation
        var catCharts = createRouterTreeItem("/plugins", "Charts & Visualisation", null);
        catCharts.add(createRouterTreeItem("/plugins/agcharts", "AG Charts", null));
        catCharts.add(createRouterTreeItem("/plugins/agcharts-enterprise", "AG Charts Enterprise", null));
        catCharts.add(createRouterTreeItem("/plugins/chartjs", "Chart.js", null));
        pluginsItem.add(catCharts);

        // Scheduling
        var catScheduling = createRouterTreeItem("/plugins", "Scheduling", null);
        catScheduling.add(createRouterTreeItem("/plugins/fullcalendar", "FullCalendar", null));
        catScheduling.add(createRouterTreeItem("/plugins/fullcalendar-pro", "FullCalendar Pro", null));
        pluginsItem.add(catScheduling);

        // Icons
        var catIcons = createRouterTreeItem("/plugins", "Icons", null);
        catIcons.add(createRouterTreeItem("/plugins/fontawesome", "Font Awesome", null));
        catIcons.add(createRouterTreeItem("/plugins/fontawesome-pro", "Font Awesome Pro", null));
        pluginsItem.add(catIcons);

        // Animation
        var catAnimation = createRouterTreeItem("/plugins", "Animation", null);
        catAnimation.add(createRouterTreeItem("/plugins/easing", "Easing Effects", null));
        pluginsItem.add(catAnimation);

        // Real-Time Messaging
        var catMessaging = createRouterTreeItem("/plugins", "Real-Time Messaging", null);
        catMessaging.add(createRouterTreeItem("/plugins/rabbitmq", "RabbitMQ Comms", null));
        pluginsItem.add(catMessaging);

        // Runtime & Server
        var catRuntime = createRouterTreeItem("/plugins", "Runtime & Server", null);
        catRuntime.add(createRouterTreeItem("/plugins/vertx", "JWebMP Vert.x", null));
        pluginsItem.add(catRuntime);

        menuTree.add(pluginsItem);

        // Capabilities
        var capItem = createRouterTreeItem("/capabilities", "Capabilities", "star");
        capItem.add(createRouterTreeItem("/capabilities/rendering", "Rendering", null));
        capItem.add(createRouterTreeItem("/capabilities/angular-generation", "Angular Generation", null));
        capItem.add(createRouterTreeItem("/capabilities/event-system", "Event System", null));
        capItem.add(createRouterTreeItem("/capabilities/real-time-messaging", "Real-Time Messaging", null));
        capItem.add(createRouterTreeItem("/capabilities/plugin-model", "Plugin Model", null));
        capItem.add(createRouterTreeItem("/capabilities/spi-extensibility", "SPI Extensibility", null));
        menuTree.add(capItem);

        // Real-Time
        var rtItem = createRouterTreeItem("/real-time", "REST, AJAX & Real-Time", "bolt");
        rtItem.add(createRouterTreeItem("/real-time/communication-layers", "Communication Layers", null));
        rtItem.add(createRouterTreeItem("/real-time/rest-and-ajax", "REST & AJAX", null));
        rtItem.add(createRouterTreeItem("/real-time/data-services", "Data Services", null));
        rtItem.add(createRouterTreeItem("/real-time/vertx-event-bus", "Vert.x Event Bus", null));
        rtItem.add(createRouterTreeItem("/real-time/vertx-code-samples", "Vert.x Code Samples", null));
        rtItem.add(createRouterTreeItem("/real-time/rabbitmq", "RabbitMQ", null));
        rtItem.add(createRouterTreeItem("/real-time/rabbitmq-code-samples", "RabbitMQ Code Samples", null));
        rtItem.add(createRouterTreeItem("/real-time/choosing-a-pattern", "Choosing a Pattern", null));
        rtItem.add(createRouterTreeItem("/real-time/use-cases", "Use Cases", null));
        menuTree.add(rtItem);

        // GitHub (no sub-items)
        menuTree.add(createRouterTreeItem("/github", "GitHub", "code-branch"));
        menu.add(menuTree);

        page.getMain().add(new RouterOutlet());
        page.getAside().add(new RouterOutlet("aside"));

        add(page);
    }

    private static WaTreeItem<?> createRouterTreeItem(String path, String text, String icon)
    {
        if (!path.startsWith("/"))
        {
            path = "/" + path;
        }
        Link<?> link = new Link<>();
        link.setTag("a");
        link.addAttribute("routerLink", path);
        link.setText(text);

        WaTreeItem<?> item = new WaTreeItem<>();
        if (icon != null)
        {
            item.add(new WaIcon<>(icon));
        }
        item.add(link);
        return item;
    }

    @Override
    public List<String> host() {
        return List.of("""
                {
                    '[style.width]': '"100%"',
                    '[style.height]': '"100%"',
                  }
                """);
    }

    @Override
    public List<String> providers() {
        var p = INgComponent.super.providers();
        p.add("provideLocaleData(localeEnZa, 'en-ZA'");
        return p;
    }

}
