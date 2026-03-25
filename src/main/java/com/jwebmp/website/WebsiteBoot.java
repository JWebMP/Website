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
import com.jwebmp.plugins.prism.PrismTheme;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.button.WaButton;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.icon.WaIcon;
import com.jwebmp.webawesome.components.select.WaSelect;
import com.jwebmp.webawesome.components.select.WaSelectOption;
import com.jwebmp.webawesome.components.toast.WaToastDataService;
import com.jwebmp.webawesome.components.tooltip.WaTooltip;
import com.jwebmp.webawesome.components.tree.WaTree;
import com.jwebmp.webawesome.components.tree.WaTreeItem;
import com.jwebmp.webawesomepro.components.page.WaPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Top-level boot component for the JWebMP website.
 * <p>
 * The WaPage is the outermost shell.  The banner holds a product navigation
 * bar inspired by the Web Awesome "Awesomeverse" pattern — a wa-cluster of
 * links with icons and tooltips for each DevSuite project.  Header, menu,
 * and navigation live in their normal page slots.  The main content area
 * holds the RouterOutlet for page routing.
 */
@NgComponent("jwebmp-app")
@NgRoutable(path = "")
@NgImportProvider("{provide: LOCALE_ID, useValue: 'en-ZA'}")
@NgBootImportProvider(value = "{ provide: LOCALE_ID, useValue: 'en-ZA' }")
@NgBootImportReference(value = "provideHttpClient", reference = "@angular/common/http")
@NgBootImportProvider("provideHttpClient()")
@NgBootImportReference(value = "LOCALE_ID", reference = "@angular/core")
@NgBootImportReference(value = "localeEnZa", reference = "@angular/common/locales/en-ZA", direct = true)
@NgImportReference(value = "localeEnZa", reference = "@angular/common/locales/en-ZA", direct = true, wrapValueInBraces = false)
@NgImportReference(value = "signal", reference = "@angular/core")
@NgImportReference(value = "DOCUMENT", reference = "@angular/common")
@NgImportReference(value = "Router, NavigationEnd", reference = "@angular/router")
@NgImportReference(value = "filter", reference = "rxjs/operators")
@NgComponentReference(WaToastDataService.class)
public class WebsiteBoot extends DivSimple<WebsiteBoot> implements INgComponent<WebsiteBoot> {
    public WebsiteBoot() {
        setTag("ng-container");
        addStyle("width:100%");
        addStyle("height:100%");
        //addClass("wa-dark");

        // ── WaPage is the top-level shell ──
        WaPage<?> page = new WaPage<>();
        page.addStyle("width:100%");
        page.addStyle("height:100%");
        page.getMain().setPageSize(PageSize.ExtraSmall);

        // ── Banner: product navigation bar ──
        var banner = page.getHeader();

        DivSimple<?> navWrapper = new DivSimple<>();
        navWrapper.addClass("wrapper-nav-products");

        DivSimple<?> nav = new DivSimple<>();
        nav.setTag("nav");
        nav.addClass("nav-products");
        nav.addClass("nav-products-full");
        nav.addAttribute("aria-label", "DevSuite Products");

        // Primary product links
        DivSimple<?> primary = new DivSimple<>();
        primary.addClass("nav-products-primary");
        primary.addClass("wa-split");
        primary.addClass("wa-align-items-stretch");

        DivSimple<?> cluster = new DivSimple<>();
        cluster.addClass("wa-cluster");
        cluster.addClass("wa-align-items-stretch");
        cluster.addClass("wa-gap-0");

        // JWebMP — active product
        Link<?> jwebmpLink = new Link<>();
        jwebmpLink.setTag("a");
        jwebmpLink.addAttribute("routerLink", "/home");
        jwebmpLink.addClass("product");
        jwebmpLink.addClass("product-jwebmp");
        jwebmpLink.addClass("product-active");
        jwebmpLink.addClass("appearance-plain");
        jwebmpLink.addAttribute("aria-label", "JWebMP");
        var jwebmpLogo = new DivSimple<>();
        jwebmpLogo.setTag("span");
        jwebmpLogo.addClass("logo-jwebmp-svg");
        jwebmpLink.add(jwebmpLogo);
        jwebmpLink.setText("JWebMP");
        jwebmpLink.setRenderTextBeforeChildren(false);
        cluster.add(jwebmpLink);

        // GuicedEE
        Link<?> guicedeeLink = new Link<>();
        guicedeeLink.setTag("a");
        guicedeeLink.addAttribute("href", "https://guicedee.com");
        guicedeeLink.addAttribute("target", "_blank");
        guicedeeLink.addClass("product");
        guicedeeLink.addClass("product-guicedee");
        guicedeeLink.addClass("appearance-plain");
        guicedeeLink.setID("product-guicedee");
        guicedeeLink.add(new WaIcon<>("cubes").addClass("logo-icon").addClass("logo-guicedee"));
        cluster.add(guicedeeLink);
        WaTooltip<?> guicedeeTip = new WaTooltip<>();
        guicedeeTip.setForId("product-guicedee");
        guicedeeTip.setText("GuicedEE");
        cluster.add(guicedeeTip);

        // Entity Assist
        Link<?> entityLink = new Link<>();
        entityLink.setTag("a");
        entityLink.addAttribute("href", "https://entityassist.com");
        entityLink.addAttribute("target", "_blank");
        entityLink.addClass("product");
        entityLink.addClass("product-entity-assist");
        entityLink.addClass("appearance-plain");
        entityLink.setID("product-entity-assist");
        entityLink.add(new WaIcon<>("database").addClass("logo-icon").addClass("logo-entity-assist"));
        cluster.add(entityLink);
        WaTooltip<?> entityTip = new WaTooltip<>();
        entityTip.setForId("product-entity-assist");
        entityTip.setText("Entity Assist");
        cluster.add(entityTip);

        // Activity Master
        Link<?> activityLink = new Link<>();
        activityLink.setTag("a");
        activityLink.addAttribute("href", "https://github.com/Activity-Master/");
        activityLink.addAttribute("target", "_blank");
        activityLink.addClass("product");
        activityLink.addClass("product-activity-master");
        activityLink.addClass("appearance-plain");
        activityLink.setID("product-activity-master");
        activityLink.add(new WaIcon<>("tasks").addClass("logo-icon").addClass("logo-activity-master"));
        cluster.add(activityLink);
        WaTooltip<?> activityTip = new WaTooltip<>();
        activityTip.setForId("product-activity-master");
        activityTip.setText("Activity Master");
        cluster.add(activityTip);

        primary.add(cluster);

        // Secondary links (GitHub, Blog)
        DivSimple<?> secondary = new DivSimple<>();
        secondary.addClass("nav-products-secondary");
        secondary.addClass("wa-cluster");
        secondary.addClass("wa-gap-2xs");

        WaButton<?> githubBtn = new WaButton<>();
        githubBtn.setAppearance(Appearance.Plain);
        githubBtn.setVariant(Variant.Brand);
        githubBtn.setAsLink("https://github.com/GedMarc/JWebMP", "_blank", null);
        githubBtn.addClass("pseudo-product");
        githubBtn.addClass("product-github");
        githubBtn.setID("product-github");
        githubBtn.add(new WaIcon<>("github").addAttribute("family", "brands")
                                            .addAttribute("label", "GitHub"));
        secondary.add(githubBtn);
        WaTooltip<?> githubTip = new WaTooltip<>();
        githubTip.setForId("product-github");
        githubTip.setText("GitHub");
        secondary.add(githubTip);

        WaButton<?> starBtn = new WaButton<>();
        starBtn.setAppearance(Appearance.Plain);
        starBtn.setVariant(Variant.Brand);
        starBtn.setAsLink("https://github.com/GedMarc/JWebMP/stargazers", "_blank", null);
        starBtn.addClass("pseudo-product");
        starBtn.addClass("product-star");
        starBtn.setID("product-star");
        starBtn.add(new WaIcon<>("star").addAttribute("label", "Star this Repository"));
        secondary.add(starBtn);
        WaTooltip<?> starTip = new WaTooltip<>();
        starTip.setForId("product-star");
        starTip.setText("Star this Repository");
        secondary.add(starTip);

        WaButton<?> docsBtn = new WaButton<>();
        docsBtn.setAppearance(Appearance.Plain);
        docsBtn.setVariant(Variant.Brand);
        docsBtn.setAsLink("https://github.com/GuicedEE/ai-rules", "_blank", null);
        docsBtn.addClass("pseudo-product");
        docsBtn.addClass("product-docs");
        docsBtn.setID("product-docs");
        docsBtn.add(new WaIcon<>("brain-circuit").addAttribute("label", "AI Skills Repository"));
        secondary.add(docsBtn);
        WaTooltip<?> docsTip = new WaTooltip<>();
        docsTip.setForId("product-docs");
        docsTip.setText("AI Skills Repository");
        secondary.add(docsTip);

        // Theme toggle (dark ↔ light)
        WaButton<?> themeBtn = new WaButton<>();
        themeBtn.setAppearance(Appearance.Plain);
        themeBtn.setVariant(Variant.Brand);
        themeBtn.addAttribute("(click)", "toggleDarkMode()");
        themeBtn.addClass("pseudo-product");
        themeBtn.addClass("product-theme");
        themeBtn.setID("product-theme");
        var themeIcon = new WaIcon<>();
        themeIcon.addAttribute("[name]", "darkMode() ? 'sun-bright' : 'moon'");
        themeIcon.addAttribute("label", "Toggle Theme");
        themeBtn.add(themeIcon);
        secondary.add(themeBtn);
        WaTooltip<?> themeTip = new WaTooltip<>();
        themeTip.setForId("product-theme");
        themeTip.setText("Toggle Theme");
        secondary.add(themeTip);

        // Prism syntax theme selector
        var prismSelect = new WaSelect<>();
        prismSelect.setSize(com.jwebmp.webawesome.components.Size.Small);
        prismSelect.setValue("prism-okaidia");
        prismSelect.setLabel("Code Theme");
        prismSelect.setPlaceholder("Code Theme");
        prismSelect.addAttribute("(wa-change)", "changePrismTheme($event)");
        prismSelect.bind("prismTheme");
        prismSelect.addStyle("min-width", "10rem");
        prismSelect.addClass("pseudo-product");

        for (var theme : PrismTheme.values()) {
            // Skip community themes not in the standard prismjs package
            if (theme == PrismTheme.OneDark || theme == PrismTheme.OneLight) continue;
            var opt = new WaSelectOption<>();
            opt.setValue(theme.getCssFileName());
            opt.setText(theme.name().replaceAll("([a-z])([A-Z])", "$1 $2"));
            prismSelect.add(opt);
        }
        secondary.add(prismSelect);

        primary.add(secondary);
        nav.add(primary);
        navWrapper.add(nav);
        banner.add(navWrapper);

        // ── Menu: WaTree navigation with sub-items ──
        var menu = page.getMenu();
        WaTree<?> menuTree = new WaTree<>();
        menuTree.setIndentSize("2px");
        menuTree.setIndentGuideColor("var(--wa-color-neutral-300)");

        // Home
        var homeItem = createRouterTreeItem("/home", "Home", "house");
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
        var pluginsItem = createRouterTreeItem("/plugins", "Plugins", "puzzle-piece");

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
        var rtItem = createRouterTreeItem("/real-time", "Data", "bolt");
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

        // ── Navigation Toggle (burger button, slot="navigation-toggle") ──
        var navToggle = page.getNavigationToggle();
        WaButton<?> burgerBtn = new WaButton<>();
        burgerBtn.setAppearance(Appearance.Plain);
        burgerBtn.setVariant(Variant.Neutral);
        burgerBtn.addAttribute("aria-label", "Toggle navigation menu");
        burgerBtn.add(new WaIcon<>("bars"));
        navToggle.add(burgerBtn);

        // ── Navigation Toggle Icon (slot="navigation-toggle-icon") ──
        var navToggleIcon = page.getNavigationToggleIcon();
        navToggleIcon.add(new WaIcon<>("bars"));

        // ── Navigation Header (branding inside the drawer, slot="navigation-header") ──
        var navHeader = page.getNavigationHeader();
        Link<?> drawerLogo = new Link<>();
        drawerLogo.setTag("a");
        drawerLogo.addAttribute("routerLink", "/home");
        drawerLogo.addAttribute("aria-label", "JWebMP Home");
        drawerLogo.addClass("appearance-plain");
        var drawerLogoSpan = new DivSimple<>();
        drawerLogoSpan.setTag("span");
        drawerLogoSpan.addClass("logo-jwebmp-svg");
        drawerLogo.add(drawerLogoSpan);
        navHeader.add(drawerLogo);

        // ── Burger Menu Navigation (drawer contents, slot="navigation") ──
        var burgerMenuNavigation = page.getNavigation();
        WaTree<?> navTree = new WaTree<>();
        navTree.setIndentSize("2px");
        navTree.setIndentGuideColor("var(--wa-color-neutral-300)");

        navTree.add(createRouterTreeItem("/home", "Home", "house"));

        var navGs = createRouterTreeItem("/getting-started", "Getting Started", "rocket");
        navGs.add(createRouterTreeItem("/getting-started/prerequisites", "Prerequisites", null));
        navGs.add(createRouterTreeItem("/getting-started/maven-project", "Maven Project", null));
        navGs.add(createRouterTreeItem("/getting-started/module-descriptor", "Module Descriptor", null));
        navGs.add(createRouterTreeItem("/getting-started/bootstrap", "Bootstrap", null));
        navGs.add(createRouterTreeItem("/getting-started/application", "Application", null));
        navGs.add(createRouterTreeItem("/getting-started/first-component", "First Component", null));
        navGs.add(createRouterTreeItem("/getting-started/build-and-run", "Build & Run", null));
        navGs.add(createRouterTreeItem("/getting-started/whats-happening", "What's Happening", null));
        navGs.add(createRouterTreeItem("/getting-started/next-steps", "Next Steps", null));
        navTree.add(navGs);

        var navArch = createRouterTreeItem("/architecture", "Architecture", "sitemap");
        navArch.add(createRouterTreeItem("/architecture/stack", "Stack Diagram", null));
        navArch.add(createRouterTreeItem("/architecture/build-pipeline", "Build Pipeline", null));
        navArch.add(createRouterTreeItem("/architecture/runtime", "Runtime", null));
        navArch.add(createRouterTreeItem("/architecture/data-flow", "Data Flow", null));
        navArch.add(createRouterTreeItem("/architecture/module-graph", "Module Graph", null));
        navTree.add(navArch);

        var navPlugins = createRouterTreeItem("/plugins", "Plugins", "puzzle-piece");
        navPlugins.add(createRouterTreeItem("/plugins/core", "JWebMP Core", null));
        navPlugins.add(createRouterTreeItem("/plugins/client", "JWebMP Client", null));
        navPlugins.add(createRouterTreeItem("/plugins/web-awesome", "WebAwesome", null));
        navPlugins.add(createRouterTreeItem("/plugins/web-awesome-pro", "WebAwesome Pro", null));
        navPlugins.add(createRouterTreeItem("/plugins/angular", "Angular Plugin", null));
        navPlugins.add(createRouterTreeItem("/plugins/angular-maven-plugin", "Angular Maven Plugin", null));
        navPlugins.add(createRouterTreeItem("/plugins/typescript-client", "TypeScript Client", null));
        navPlugins.add(createRouterTreeItem("/plugins/aggrid", "AG Grid", null));
        navPlugins.add(createRouterTreeItem("/plugins/aggrid-enterprise", "AG Grid Enterprise", null));
        navPlugins.add(createRouterTreeItem("/plugins/agcharts", "AG Charts", null));
        navPlugins.add(createRouterTreeItem("/plugins/agcharts-enterprise", "AG Charts Enterprise", null));
        navPlugins.add(createRouterTreeItem("/plugins/chartjs", "Chart.js", null));
        navPlugins.add(createRouterTreeItem("/plugins/fullcalendar", "FullCalendar", null));
        navPlugins.add(createRouterTreeItem("/plugins/fullcalendar-pro", "FullCalendar Pro", null));
        navPlugins.add(createRouterTreeItem("/plugins/fontawesome", "Font Awesome", null));
        navPlugins.add(createRouterTreeItem("/plugins/fontawesome-pro", "Font Awesome Pro", null));
        navPlugins.add(createRouterTreeItem("/plugins/easing", "Easing Effects", null));
        navPlugins.add(createRouterTreeItem("/plugins/rabbitmq", "RabbitMQ Comms", null));
        navPlugins.add(createRouterTreeItem("/plugins/vertx", "JWebMP Vert.x", null));
        navTree.add(navPlugins);

        var navCap = createRouterTreeItem("/capabilities", "Capabilities", "star");
        navCap.add(createRouterTreeItem("/capabilities/rendering", "Rendering", null));
        navCap.add(createRouterTreeItem("/capabilities/angular-generation", "Angular Generation", null));
        navCap.add(createRouterTreeItem("/capabilities/event-system", "Event System", null));
        navCap.add(createRouterTreeItem("/capabilities/real-time-messaging", "Real-Time Messaging", null));
        navCap.add(createRouterTreeItem("/capabilities/plugin-model", "Plugin Model", null));
        navCap.add(createRouterTreeItem("/capabilities/spi-extensibility", "SPI Extensibility", null));
        navTree.add(navCap);

        var navRt = createRouterTreeItem("/real-time", "Data", "bolt");
        navRt.add(createRouterTreeItem("/real-time/communication-layers", "Communication Layers", null));
        navRt.add(createRouterTreeItem("/real-time/rest-and-ajax", "REST & AJAX", null));
        navRt.add(createRouterTreeItem("/real-time/data-services", "Data Services", null));
        navRt.add(createRouterTreeItem("/real-time/vertx-event-bus", "Vert.x Event Bus", null));
        navRt.add(createRouterTreeItem("/real-time/vertx-code-samples", "Vert.x Code Samples", null));
        navRt.add(createRouterTreeItem("/real-time/rabbitmq", "RabbitMQ", null));
        navRt.add(createRouterTreeItem("/real-time/rabbitmq-code-samples", "RabbitMQ Code Samples", null));
        navRt.add(createRouterTreeItem("/real-time/choosing-a-pattern", "Choosing a Pattern", null));
        navRt.add(createRouterTreeItem("/real-time/use-cases", "Use Cases", null));
        navTree.add(navRt);

        navTree.add(createRouterTreeItem("/github", "GitHub", "code-branch"));
        burgerMenuNavigation.add(navTree);

        // ── Navigation Footer (external links inside the drawer, slot="navigation-footer") ──
        var navFooter = page.getNavigationFooter();
        Link<?> navGithubLink = new Link<>();
        navGithubLink.setTag("a");
        navGithubLink.addAttribute("href", "https://github.com/GedMarc/JWebMP");
        navGithubLink.addAttribute("target", "_blank");
        navGithubLink.add(new WaIcon<>("github").addAttribute("family", "brands"));
        navGithubLink.setText("GitHub");
        navFooter.add(navGithubLink);

        Link<?> navGuicedeeLink = new Link<>();
        navGuicedeeLink.setTag("a");
        navGuicedeeLink.addAttribute("href", "https://guicedee.com");
        navGuicedeeLink.addAttribute("target", "_blank");
        navGuicedeeLink.add(new WaIcon<>("cubes"));
        navGuicedeeLink.setText("GuicedEE");
        navFooter.add(navGuicedeeLink);

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

        WaTreeItem<?> item = new WaTreeItem<>();
        Link<?> link = new Link<>("#");
        item.add(link);
        link.addAttribute("routerLink", path);
        link.setRenderTextBeforeChildren(false);
        if (icon != null)
        {
            WaIcon<?> waIcon = new WaIcon<>(icon).addClass("wa-gap-1").addStyle("color: var(--wa-color-brand-on-normal)");
            link.add(waIcon);
        }
        link.setText("&nbsp;"+ text);
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

    @Override
    public List<String> fields() {
        var f = new ArrayList<>(INgComponent.super.fields());
        f.add("private router: Router = inject(Router);");
        f.add("private _asideNavigating = false;");
        f.add("private document = inject(DOCUMENT);");
        f.add("darkMode = signal(true);");
        f.add("prismTheme = 'prism-okaidia';");
        f.add("private _prismThemeCache: Record<string, string> = {};");
        f.add("""
                private asideRoutes: Record<string, string> = {
                    'home': 'home'
                };""");
        return f;
    }

    @Override
    public List<String> methods() {
        var m = new ArrayList<>(INgComponent.super.methods());
        m.add("""
                toggleDarkMode() {
                    const isDark = !this.darkMode();
                    this.darkMode.set(isDark);
                    this.document.body.classList.toggle('wa-dark', isDark);
                    localStorage.setItem('jwebmp-theme', isDark ? 'dark' : 'light');
                }""");
        m.add("""
                changePrismTheme($event: any) {
                    const theme = $event?.target?.value || this.prismTheme;
                    this.prismTheme = theme;
                    localStorage.setItem('jwebmp-prism-theme', theme);
                    
                    const applyThemeCss = (css: string) => {
                        let style = this.document.getElementById('prism-theme-override') as HTMLStyleElement;
                        if (!style) {
                            style = this.document.createElement('style') as HTMLStyleElement;
                            style.id = 'prism-theme-override';
                            this.document.head.appendChild(style);
                        }
                        style.textContent = css;
                    };
                    
                    if (this._prismThemeCache[theme]) {
                        applyThemeCss(this._prismThemeCache[theme]);
                        return;
                    }
                    
                    const url = `https://cdn.jsdelivr.net/npm/prismjs@1/themes/${theme}.min.css`;
                    fetch(url)
                        .then(r => r.ok ? r.text() : Promise.reject('Failed to load theme'))
                        .then(css => {
                            this._prismThemeCache[theme] = css;
                            applyThemeCss(css);
                        })
                        .catch(err => console.warn('Could not load Prism theme:', theme, err));
                }""");
        return m;
    }

    @Override
    public List<String> onInit() {
        var init = new ArrayList<>(INgComponent.super.onInit());
        init.add("""
                const savedTheme = localStorage.getItem('jwebmp-theme');
                const prefersDark = savedTheme ? savedTheme === 'dark' : true;
                this.darkMode.set(prefersDark);
                this.document.body.classList.toggle('wa-dark', prefersDark);""");
        init.add("""
                const savedPrismTheme = localStorage.getItem('jwebmp-prism-theme');
                if (savedPrismTheme) {
                    this.prismTheme = savedPrismTheme;
                    this.changePrismTheme(null);
                }""");
        init.add("""
                this.router.events.pipe(filter(e => e instanceof NavigationEnd)).subscribe((e: any) => {
                    if (this._asideNavigating) return;
                    const url = (e as NavigationEnd).urlAfterRedirects || (e as NavigationEnd).url;
                    const primaryPath = url.split('?')[0].split('#')[0].replace(/^\\//, '').split('/')[0];
                    const asidePath = this.asideRoutes[primaryPath];
                    const currentAside = this.router.parseUrl(url).root.children['aside'];
                    if (asidePath && !currentAside) {
                        this._asideNavigating = true;
                        this.router.navigate([{outlets: {aside: [asidePath]}}], {skipLocationChange: true})
                            .finally(() => this._asideNavigating = false);
                    } else if (!asidePath && currentAside) {
                        this._asideNavigating = true;
                        this.router.navigate([{outlets: {aside: null}}], {skipLocationChange: true})
                            .finally(() => this._asideNavigating = false);
                    }
                });""");
        return init;
    }

}
