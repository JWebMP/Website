package com.jwebmp.website;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportProvider;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportProvider;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.components.NgIf;
import com.jwebmp.core.base.angular.services.RouterOutlet;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.plugins.markdown.Markdown;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.badge.WaBadge;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.button.WaButton;
import com.jwebmp.webawesome.components.icon.WaIcon;
import com.jwebmp.webawesome.components.page.WaPage;
import com.jwebmp.webawesome.components.popover.WaPopover;
import com.jwebmp.webawesome.components.popover.WaPopoverPlacements;
import com.jwebmp.webawesome.components.toast.WaToastDataService;
import com.jwebmp.webawesome.components.tooltip.WaTooltip;
import com.jwebmp.webawesome.components.tree.WaTree;
import com.jwebmp.webawesome.components.tree.WaTreeItem;
import com.jwebmp.webawesome.components.waswitch.WaSwitch;

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
@NgImportReference(value = "Router, NavigationStart, NavigationEnd", reference = "@angular/router")
@NgImportReference(value = "filter", reference = "rxjs/operators")
@NgComponentReference(WaToastDataService.class)
public class WebsiteBoot extends DivSimple<WebsiteBoot> implements INgComponent<WebsiteBoot> {
    public WebsiteBoot() {
        setTag("ng-container");
        addStyle("width:100%");
        addStyle("height:100%");
        // ── WaPage is the top-level shell ──
        WaPage<?> page = new WaPage<>();
        page.addStyle("width:100%");
        page.addStyle("height:100%");

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
        jwebmpLogo.setTag("i");
        jwebmpLogo.addClass("fak");
        jwebmpLogo.addClass("fa-jwebmp-logo-green");
        jwebmpLogo.addClass("logo-icon");
        jwebmpLogo.addClass("logo-jwebmp");
        jwebmpLink.add(jwebmpLogo);
        var jwebmpText = new DivSimple<>();
        jwebmpText.setTag("span");
        jwebmpText.addClass("logo-jwebmp-text");
        jwebmpLink.add(jwebmpText);

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

        var guicedeeLogo = new DivSimple<>();
        guicedeeLogo.setTag("i");
        guicedeeLogo.addClass("fak");
        guicedeeLogo.addClass("fa-guicedee-logo");
        guicedeeLogo.addClass("logo-icon");
        guicedeeLogo.addClass("logo-guicedee");
        guicedeeLink.add(guicedeeLogo);
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
        var entityLogo = new DivSimple<>();
        entityLogo.setTag("i");
        entityLogo.addClass("fak");
        entityLogo.addClass("fa-entityassist-logo");
        entityLogo.addClass("logo-icon");
        entityLogo.addClass("logo-entity-assist");
        entityLink.add(entityLogo);
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
        var activityLogo = new DivSimple<>();
        activityLogo.setTag("i");
        activityLogo.addClass("fak");
        activityLogo.addClass("fa-activitymaster-logo");
        activityLogo.addClass("logo-icon");
        activityLogo.addClass("logo-activity-master");
        activityLink.add(activityLogo);
        cluster.add(activityLink);
        WaTooltip<?> activityTip = new WaTooltip<>();
        activityTip.setForId("product-activity-master");
        activityTip.setText("Activity Master");
        cluster.add(activityTip);

        WaBadge<?> versionBadge = new WaBadge<>();
        versionBadge.addClass("version-badge");
        versionBadge.setVariant(Variant.Brand);
        versionBadge.setPill(true);
        versionBadge.setFontSize("var(--wa-font-size-2xs)");
        versionBadge.addStyle("color: var(--wa-color-brand-on-normal)");
        versionBadge.addStyle("background-color: var(--wa-color-brand-normal)");
        versionBadge.addStyle("cursor: pointer");
        versionBadge.setText("2.0.0-SNAPSHOT");
        versionBadge.setID("snapshot-badge");
        cluster.add(versionBadge);

        // ── Snapshot badge popover with Maven/Gradle repository instructions ──
        WaPopover<?> snapshotPopover = new WaPopover<>();
        snapshotPopover.setForElement(versionBadge);
        snapshotPopover.setPlacement(WaPopoverPlacements.Bottom);
        snapshotPopover.setMaxWidth("32rem");
        snapshotPopover.addStyle("--border-color:var(--wa-color-brand-normal)");
        snapshotPopover.addStyle("--border-width:var(--wa-border-width-s)");
        snapshotPopover.addStyle("--border-radius:var(--wa-border-radius-l)");
        snapshotPopover.addStyle("--arrow-color:var(--wa-color-brand-normal)");

        DivSimple<?> popoverContent = new DivSimple<>();
        popoverContent.addStyle("padding: var(--wa-spacing-medium)");

        var popoverTitle = new DivSimple<>();
        popoverTitle.setTag("strong");
        popoverTitle.setText("Snapshot Repository Setup");
        popoverTitle.addStyle("display:block;margin-bottom:var(--wa-spacing-small);font-size:var(--wa-font-size-m)");
        popoverContent.add(popoverTitle);

        var popoverDesc = new DivSimple<>();
        popoverDesc.setTag("p");
        popoverDesc.addStyle("margin:0 0 var(--wa-spacing-small) 0;font-size:var(--wa-font-size-s);color:var(--wa-color-neutral-700)");
        popoverDesc.addAttribute("[innerText]", "useGradle ? 'Add to your build.gradle:' : 'Add to your pom.xml:'");
        popoverContent.add(popoverDesc);

        var mavenMd = new Markdown<>("""
                ```xml
                <repository>
                    <id>guicedee-github</id>
                    <url>https://maven.pkg.github.com/GuicedEE/*</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
                ```""");
        mavenMd.setClipboard(true);
        mavenMd.addClass("aside-snippet-code");
        mavenMd.addClass("wa-body-xs");
        var mavenIf = new NgIf("!useGradle");
        mavenIf.add(mavenMd);
        popoverContent.add(mavenIf);

        var gradleMd = new Markdown<>("""
                ```groovy
                repositories {
                    maven {
                        url = uri("https://maven.pkg.github.com/GuicedEE/*")
                        credentials {
                            username = project.findProperty("gpr.user")
                                ?: System.getenv("GITHUB_USER")
                            password = project.findProperty("gpr.token")
                                ?: System.getenv("GITHUB_TOKEN")
                        }
                    }
                }
                ```""");
        gradleMd.setClipboard(true);
        gradleMd.addClass("aside-snippet-code");
        gradleMd.addClass("wa-body-xs");
        var gradleIf = new NgIf("useGradle");
        gradleIf.add(gradleMd);
        popoverContent.add(gradleIf);

        var authNote = new DivSimple<>();
        authNote.setTag("p");
        authNote.addStyle("margin:var(--wa-spacing-small) 0 0 0;font-size:var(--wa-font-size-2xs);color:var(--wa-color-neutral-600)");
        authNote.setText("&#x1F511; GitHub Packages requires authentication — use a personal access token with <code>read:packages</code> scope.");
        popoverContent.add(authNote);

        snapshotPopover.add(popoverContent);
        cluster.add(snapshotPopover);

        primary.add(cluster);

        // Secondary links (GitHub, Blog)
        DivSimple<?> secondary = new DivSimple<>();
        secondary.addClass("nav-products-secondary");
        secondary.addClass("wa-cluster");
        secondary.addClass("wa-gap-2xs");

        // Maven / Gradle toggle switch
        DivSimple<?> buildToolToggle = new DivSimple<>();
        buildToolToggle.addClass("wa-cluster");
        buildToolToggle.addClass("wa-gap-2xs");
        buildToolToggle.addClass("wa-align-items-center");
        buildToolToggle.addStyle("font-size:var(--wa-font-size-xs);color:var(--wa-color-text-quiet)");

        var mavenLabel = new DivSimple<>();
        mavenLabel.setTag("span");
        mavenLabel.setText("Maven");
        buildToolToggle.add(mavenLabel);

        WaSwitch<?> buildToolSwitch = new WaSwitch<>();
        buildToolSwitch.setSize(com.jwebmp.webawesome.components.Size.Small);
        buildToolSwitch.setName("useGradle");
        buildToolSwitch.bind("useGradle");
        buildToolSwitch.addAttribute("(ngModelChange)", "onBuildToolChange($event)");
        buildToolToggle.add(buildToolSwitch);

        var gradleLabel = new DivSimple<>();
        gradleLabel.setTag("span");
        gradleLabel.setText("Gradle");
        buildToolToggle.add(gradleLabel);

        secondary.add(buildToolToggle);

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

        // Prism syntax theme selector (dropdown triggered by icon button)
       /* var prismDropdown = new WaDropDown<>();
        prismDropdown.addClass("pseudo-product");
        prismDropdown.setSelectEvent("changePrismTheme($event)");

        var prismBtn = new WaButton<>();
        prismBtn.setAppearance(Appearance.Plain);
        prismBtn.setVariant(Variant.Brand);
        prismBtn.setID("product-code-theme");
        prismBtn.add(new WaIcon<>("code").addAttribute("label", "Code Theme"));
        prismDropdown.setButton(prismBtn);

        for (var theme : PrismTheme.values()) {
            // Skip community themes not in the standard prismjs package
            if (theme == PrismTheme.OneDark || theme == PrismTheme.OneLight) continue;
            prismDropdown.addItem(
                    theme.name().replaceAll("([a-z])([A-Z])", "$1 $2"),
                    theme.getCssFileName()
            );
        }
        secondary.add(prismDropdown);

        WaTooltip<?> prismTip = new WaTooltip<>();
        prismTip.setForId("product-code-theme");
        prismTip.setText("Code Theme");
        secondary.add(prismTip);

        */

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

        // About
        menuTree.add(createRouterTreeItem("/about", "About", "circle-info"));

        // Getting Started
        var gsItem = createRouterTreeItem("/getting-started", "Getting Started", "rocket");
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
        drawerLogoSpan.setTag("i");
        drawerLogoSpan.addClass("fak");
        drawerLogoSpan.addClass("fa-jwebmp-logo-green");
        drawerLogoSpan.addClass("logo-icon");
        drawerLogoSpan.addClass("logo-jwebmp");
        drawerLogo.add(drawerLogoSpan);
        navHeader.add(drawerLogo);

        // ── Burger Menu Navigation (drawer contents, slot="navigation") ──
        var burgerMenuNavigation = page.getNavigation();
        WaTree<?> navTree = new WaTree<>();
        navTree.setIndentSize("2px");
        navTree.setIndentGuideColor("var(--wa-color-neutral-300)");

        navTree.add(createRouterTreeItem("/home", "Home", "house"));
        navTree.add(createRouterTreeItem("/about", "About", "circle-info"));

        var navGs = createRouterTreeItem("/getting-started", "Getting Started", "rocket");
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
        f.add("prismTheme = 'prism-solarizedlight';");
        f.add("useGradle = false;");
        f.add("private _prismThemeCache: Record<string, string> = {};");
        f.add("""
                private asideRoutes: Record<string, string> = {
                    '': 'home',
                    'home': 'home',
                    'about': 'about',
                    'getting-started': 'getting-started'
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
                    const theme = $event?.detail?.item?.value || this.prismTheme;
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
        m.add("""
                onBuildToolChange(value: boolean) {
                    this.useGradle = value;
                    localStorage.setItem('jwebmp-build-tool', value ? 'gradle' : 'maven');
                    window.dispatchEvent(new CustomEvent('jwebmp-build-tool-change', { detail: value }));
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
                const savedBuildTool = localStorage.getItem('jwebmp-build-tool');
                if (savedBuildTool) {
                    this.useGradle = savedBuildTool === 'gradle';
                }""");
        init.add("""
                this.router.events.pipe(filter(e => e instanceof NavigationEnd)).subscribe((e: any) => {
                    if (this._asideNavigating) return;
                    const navEnd = e as NavigationEnd;
                    const parsedUrl = this.router.parseUrl(navEnd.urlAfterRedirects);
                    const primarySegments = parsedUrl.root.children['primary']?.segments || [];
                    const primaryPath = primarySegments.length > 0 ? primarySegments[0].path : '';
                    const asidePath = this.asideRoutes[primaryPath];
                    const currentAside = parsedUrl.root.children['aside'];
                    const currentAsidePath = currentAside?.segments?.map((s: any) => s.path).join('/') || null;
                    
                    if (asidePath && currentAsidePath !== asidePath) {
                        this._asideNavigating = true;
                        const tree = this.router.createUrlTree([{outlets: {aside: [asidePath]}}], {relativeTo: null as any});
                        tree.root.children['primary'] = parsedUrl.root.children['primary'];
                        tree.queryParams = parsedUrl.queryParams;
                        tree.fragment = parsedUrl.fragment;
                        this.router.navigateByUrl(tree, {replaceUrl: true})
                            .then(() => this._asideNavigating = false)
                            .catch(() => this._asideNavigating = false);
                    } else if (!asidePath && currentAside) {
                        this._asideNavigating = true;
                        delete parsedUrl.root.children['aside'];
                        this.router.navigateByUrl(parsedUrl, {replaceUrl: true})
                            .then(() => this._asideNavigating = false)
                            .catch(() => this._asideNavigating = false);
                    }
                });""");
        return init;
    }

}
