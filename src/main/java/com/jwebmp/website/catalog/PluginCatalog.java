package com.jwebmp.website.catalog;

import java.util.*;

public final class PluginCatalog
{
    public static final String CAT_RENDERING = "Rendering & UI";
    public static final String CAT_ANGULAR = "Angular Generation";
    public static final String CAT_DATA = "Data & Grids";
    public static final String CAT_CHARTS = "Charts & Visualisation";
    public static final String CAT_SCHEDULING = "Scheduling";
    public static final String CAT_ICONS = "Icons";
    public static final String CAT_ANIMATION = "Animation";
    public static final String CAT_LIBRARIES = "Libraries";
    public static final String CAT_MESSAGING = "Real-Time Messaging";
    public static final String CAT_RUNTIME = "Runtime & Server";

    private static final List<String> COMMON_PREREQS = List.of(
            "Java 25 LTS", "Maven 3.9+", "Node.js 18+", "Angular 21+"
    );

    private static final List<String> COMMON_BADGES = List.of(
            "Java 25+", "JPMS Modular", "Angular 21", "TypeScript 5"
    );

    private static final List<PluginEntry> PLUGINS = Collections.unmodifiableList(buildStaticPlugins());

    private PluginCatalog()
    {
    }

    public static List<PluginEntry> getPlugins()
    {
        return PLUGINS;
    }

    public static List<String> getCategories()
    {
        return PLUGINS.stream()
                      .map(PluginEntry::getCategory)
                      .distinct()
                      .toList();
    }

    public static List<PluginEntry> getByCategory(String category)
    {
        return PLUGINS.stream()
                      .filter(p -> p.getCategory().equals(category))
                      .toList();
    }

    public static Optional<PluginEntry> getById(String id)
    {
        return PLUGINS.stream()
                      .filter(p -> p.getId().equals(id))
                      .findFirst();
    }

    public static List<PluginEntry> getFrameworks()
    {
        return PLUGINS.stream()
                      .filter(PluginEntry::isFramework)
                      .toList();
    }

    public static List<PluginEntry> getNonFrameworkPlugins()
    {
        return PLUGINS.stream()
                      .filter(p -> !p.isFramework())
                      .toList();
    }

    public static List<String> getNonFrameworkCategories()
    {
        return PLUGINS.stream()
                      .filter(p -> !p.isFramework())
                      .map(PluginEntry::getCategory)
                      .distinct()
                      .toList();
    }

    public static List<PluginEntry> getNonFrameworkByCategory(String category)
    {
        return PLUGINS.stream()
                      .filter(p -> !p.isFramework() && p.getCategory().equals(category))
                      .toList();
    }

    // ══════════════════════════════════════════════════
    //  Plugin definitions
    // ══════════════════════════════════════════════════

    private static List<PluginEntry> buildStaticPlugins()
    {
        List<PluginEntry> plugins = new ArrayList<>();

        // ── Rendering & UI ────────────────────────────
        plugins.add(buildCore());
        plugins.add(buildClient());
        plugins.add(buildWebAwesome());
        plugins.add(buildWebAwesomePro());
        plugins.add(buildBootstrap());
        plugins.add(buildAngularMaterial());

        // ── Angular Generation ────────────────────────
        plugins.add(buildAngular());
        plugins.add(buildAngularMavenPlugin());
        plugins.add(buildTypeScriptClient());

        // ── Data & Grids ──────────────────────────────
        plugins.add(buildAgGrid());
        plugins.add(buildAgGridEnterprise());
        plugins.add(buildDataTables());

        // ── Charts & Visualisation ────────────────────
        plugins.add(buildAgCharts());
        plugins.add(buildAgChartsEnterprise());
        plugins.add(buildChartJs());

        // ── Scheduling ────────────────────────────────
        plugins.add(buildFullCalendar());
        plugins.add(buildFullCalendarPro());

        // ── Icons ─────────────────────────────────────
        plugins.add(buildFontAwesome());
        plugins.add(buildFontAwesomePro());

        // ── Animation ─────────────────────────────────
        plugins.add(buildEasing());
        plugins.add(buildWavesEffect());

        // ── Libraries ────────────────────────────────
        plugins.add(buildJQuery());
        plugins.add(buildJQueryUI());
        plugins.add(buildGlobalize());

        // ── Real-Time Messaging ───────────────────────
        plugins.add(buildRabbitMQ());

        // ── Runtime & Server ──────────────────────────
        plugins.add(buildVertx());

        return plugins;
    }

    // ── Rendering & UI ────────────────────────────────

    private static PluginEntry buildCore()
    {
        return PluginEntry.builder("core", "JWebMP Core", CAT_RENDERING, "com.jwebmp.core", "core")
                          .description(
                                  "Strongly-typed HTML/CSS/JS component model — the entire HTML5 element set as Java classes with CRTP fluent APIs, "
                                  + "50+ server-driven event adapters, typed CSS builder, dual-mode rendering (HTML and JSON), and SPI-driven extensibility. "
                                  + "Every component serves dual purposes: toString(true) renders as full HTML with all CSS/JS, toString() renders as JSON for AJAX/API payloads.")
                          .upstreamName("JWebMP")
                          .upstreamVersion("2.0.0-SNAPSHOT")
                          .upstreamUrl("https://jwebmp.com/")
                          .jpmsModule("com.jwebmp.core")
                          .readmePath("core/README.md")
                          .sourceUrl("https://github.com/JWebMP/Core")
                          .techBadges(List.of("Java 25+", "Guice 7", "Vert.x 5", "Maven 4", "JPMS Modular"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+"))
                          .features(List.of(
                                  "Complete HTML5 element library — every element (Div, Span, Table, Form, Input, Select, Canvas, Video, Article, Section, ...) as typed Java class with CRTP fluent API",
                                  "Dual rendering modes — toString(true) for full HTML with CSS/JS, toString() for JSON serialization",
                                  "Typed input elements — InputTextType, InputEmailType, InputNumberType, InputDateType, InputFileType, InputCheckBoxType, InputRadioType, and 15 more",
                                  "Typed CSS builder — annotation-driven CSS via @CSS across 14 sub-packages: backgrounds, borders, colours, fonts, margins, padding, displays, lists, tables, text, outline, measurement, height/width, image",
                                  "50+ server-driven event adapters — OnClickAdapter, OnChangeAdapter, OnSubmitAdapter, OnDragAdapter, OnKeyDownAdapter, OnMouseEnterAdapter, and more",
                                  "Page configurators — IPageConfigurator SPI for injecting CSS links, JS references, dynamic scripts before rendering",
                                  "AJAX pipeline — AjaxCall/AjaxResponse carry event payloads and DOM update instructions between browser and server",
                                  "Feature system — Feature wraps JavaScript libraries with typed options, CSS/JS references, and automatic dependency ordering",
                                  "Content Security Policy builder for CSP headers",
                                  "11-layer deep CRTP component hierarchy: ComponentBase through ComponentEventBase",
                                  "SPI-driven extension via ServiceLoader"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.core</groupId>
                                            <artifactId>core</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.core:jwebmp-core:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          Page<?> page = new Page<>();
                                          Div<?, ?, ?> container = new Div<>();
                                          container.add(new Paragraph<>().setText("Welcome to JWebMP"));
                                          page.getBody().add(container);
                                          
                                          String html = page.toString(true);  // full HTML + queued CSS/JS
                                          String json = page.toString();      // JSON representation""")
                          .spiProvides(List.of(
                                  "IGuiceScanModuleInclusions", "IGuiceModule", "IGuicePreStartup",
                                  "IGuicePostStartup", "IOnComponentConfigured"
                          ))
                          .spiUses(List.of(
                                  "IPageConfigurator", "IPage", "IOnClickService", "IOnChangeService",
                                  "IOnSubmitService", "ScriptProvider"
                          ))
                          .build();
    }

    private static PluginEntry buildClient()
    {
        return PluginEntry.builder("client", "JWebMP Client", CAT_RENDERING, "com.jwebmp", "jwebmp-client")
                          .description(
                                  "Client SPI contracts — AjaxCall/AjaxResponse pipeline, IPage/IPageConfigurator contracts, "
                                  + "component model interfaces, call interceptor SPIs, and render-ordering hooks that all modules build on. "
                                  + "Every interface serves dual purposes: compile-time contracts for type safety and runtime SPI discovery via ServiceLoader.")
                          .upstreamName("JWebMP")
                          .upstreamVersion("2.0.0-SNAPSHOT")
                          .upstreamUrl("https://jwebmp.com/")
                          .jpmsModule("com.jwebmp.client")
                          .readmePath("client/README.md")
                          .sourceUrl("https://github.com/JWebMP/Client")
                          .techBadges(List.of("Java 25+", "Guice 7", "Vert.x 5", "Maven 4", "JPMS Modular"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+"))
                          .features(List.of(
                                  "AJAX pipeline DTOs — AjaxCall and AjaxResponse are CallScope-scoped, JSON-serializable objects",
                                  "Three interceptor SPIs — SiteCallIntercepter, AjaxCallIntercepter, DataCallIntercepter with CRTP and sort-ordering",
                                  "Page contracts — IPage, IPageConfigurator, IBody, IHead, IHtml define the full page lifecycle",
                                  "Component model interfaces — IComponentHierarchyBase, IComponentHTMLBase, IComponentStyleBase, and 8 more",
                                  "Databind hooks — IOnDataBind, IOnComponentAdded, IOnComponentHtmlRender, IAfterRenderComplete, IClientVariableWatcher",
                                  "Render-ordering SPIs — RenderBeforeLinks, RenderAfterLinks, RenderBeforeScripts, RenderAfterScripts, and more",
                                  "User-agent detection — UADetector parser bound as Guice singleton",
                                  "Plugin metadata annotations — @ComponentInformation, @PluginInformation, @PageConfiguration",
                                  "CSS/JS reference types — CSSReference and JavascriptReference with version metadata",
                                  "HTML child-constraint interfaces — GlobalChildren, FormChildren, and marker interfaces for compile-time safety"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp</groupId>
                                            <artifactId>jwebmp-client</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp:jwebmp-client:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          public class MyPageConfigurator
                                                  implements IPageConfigurator<MyPageConfigurator> {
                                              @Override
                                              public IPage<?> configure(IPage<?> page) {
                                                  // add CSS/JS references, configure body children
                                                  return page;
                                              }
                                              @Override
                                              public Integer sortOrder() { return 100; }
                                          }""")
                          .spiProvides(List.of("IGuiceScanModuleInclusions", "IGuiceModule"))
                          .spiUses(List.of(
                                  "SiteCallIntercepter", "AjaxCallIntercepter", "DataCallIntercepter",
                                  "IPageConfigurator", "IPage", "ScriptProvider"
                          ))
                          .build();
    }

    private static PluginEntry buildWebAwesome()
    {
        return PluginEntry.builder("web-awesome", "WebAwesome", CAT_RENDERING, "com.jwebmp.plugins", "web-awesome")
                          .framework(true)
                          .description(
                                  "Modern, accessible web component library — buttons, cards, tabs, dialogs, grids, stacks, inputs, "
                                  + "overlays, and layout primitives, all wrapped as type-safe CRTP Java builders with dark-mode theming. "
                                  + "WebAwesomePageConfigurator injects the CSS/JS bundles and angular-awesome loader module automatically.")
                          .upstreamName("WebAwesome")
                          .upstreamVersion("1.0")
                          .upstreamUrl("https://webawesome.com/")
                          .jpmsModule("com.jwebmp.webawesome")
                          .readmePath("plugins/webawesome/README.md")
                          .sourceUrl("https://github.com/JWebMP/WebAwesome")
                          .techBadges(COMMON_BADGES)
                          .prerequisites(COMMON_PREREQS)
                          .features(List.of(
                                  "Component parity — Wa* wrappers mirror WebAwesome web components (buttons, inputs, overlays, layout primitives)",
                                  "CRTP fluent setters for Variant, Appearance, Placement, and Size attributes",
                                  "Java-native hydration — WebAwesomePageConfigurator injects CSS/JS bundles and body theme classes",
                                  "Dark-mode theming support with configurable theme paths",
                                  "TypescriptIndexPageConfigurator exported for cross-plugin asset reuse",
                                  "Layout components: WaGrid, WaStack, WaCluster for responsive layouts",
                                  "Card, Tag, Button, Divider, Text components with appearance variants",
                                  "Modular extensibility — single Maven module exports all component packages"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>web-awesome</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:web-awesome:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          var card = new WaCard<>();
                                          card.setAppearance(Appearance.Outlined);
                                          
                                          var button = new WaButton<>("Click Me", Variant.Brand);
                                          button.setAppearance(Appearance.Filled);
                                          
                                          var stack = new WaStack<>();
                                          stack.setGap(PageSize.Medium);
                                          stack.add(card);
                                          stack.add(button);""")
                          .spiProvides(List.of("IPageConfigurator", "TypescriptIndexPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildWebAwesomePro()
    {
        return PluginEntry.builder("web-awesome-pro", "WebAwesome Pro", CAT_RENDERING, "com.jwebmp.plugins", "web-awesome-pro")
                          .framework(true)
                          .description(
                                  "Premium WebAwesome plugin — WaPage layout system with 18 sub-components (banner, header, navigation, "
                                  + "main, aside, footer, menu, dialog wrappers) for full application shell composition. "
                                  + "Includes Angular directive wrappers, slot projection with semantic HTML, and property binding support.")
                          .upstreamName("WebAwesome")
                          .upstreamVersion("1.0")
                          .upstreamUrl("https://webawesome.com/")
                          .jpmsModule("com.jwebmp.webawesomepro")
                          .readmePath("plugins/webawesome-pro/README.md")
                          .sourceUrl("https://github.com/JWebMP/WebAwesomePro")
                          .techBadges(COMMON_BADGES)
                          .prerequisites(COMMON_PREREQS)
                          .features(List.of(
                                  "WaPage component with 18 sub-components for full application shell composition",
                                  "11 layout containers — Banner, Header, Navigation, Main, Aside, Footer, and more",
                                  "7 control components — SkipToContent, Menu, Toggle, DialogWrapper, and more",
                                  "Angular directive wrappers via angular-awesome library",
                                  "Slot projection with semantic HTML (18 slots)",
                                  "Property binding support (12 binding methods)",
                                  "CRTP fluent API for method chaining",
                                  "@NgImportReference and @NgImportModule annotation integration",
                                  "Comprehensive JUnit 5 test suite (13 tests)"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>web-awesome-pro</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:web-awesome-pro:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          var page = new WaPage();
                                          page.getHeader().add(new WaText<>().setText("My App"));
                                          page.getNavigation().add(menuItems);
                                          page.getMain().add(content);
                                          page.getFooter().add(footerContent);""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildBootstrap()
    {
        return PluginEntry.builder("bootstrap", "Bootstrap", CAT_RENDERING, "com.jwebmp.plugins", "bootstrap")
                          .framework(true)
                          .description(
                                  "Bootstrap 5.3.8 — the most popular responsive CSS framework with 40+ type-safe Java component wrappers. "
                                  + "Cards, modals, navbars, forms, carousels, accordions, toasts, alerts, dropdowns, and more with CRTP fluent APIs, "
                                  + "SCSS theming, Popper.js positioning, and ng-bootstrap 20 Angular integration.")
                          .upstreamName("Bootstrap")
                          .upstreamVersion("5.3.8")
                          .upstreamUrl("https://getbootstrap.com/")
                          .jpmsModule("com.jwebmp.plugins.bootstrap")
                          .readmePath("plugins/bootstrap/README.md")
                          .docsUrl("https://getbootstrap.com/docs/")
                          .sourceUrl("https://github.com/JWebMP/JWebMP")
                          .techBadges(List.of("Java 25+", "Bootstrap 5.3.8", "ng-bootstrap 20", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "bootstrap", "^5.3.8",
                                  "@ng-bootstrap/ng-bootstrap", "^20.0.0",
                                  "@popperjs/core", "*",
                                  "@angular/localize", "^21.0.0"
                          ))
                          .features(List.of(
                                  "40+ components — Cards, modals, navbars, accordions, carousels, toasts, alerts, badges, buttons, and more",
                                  "SCSS theming — Bootstrap SCSS loaded for full theme customization",
                                  "ng-bootstrap 20 — Angular-native Bootstrap components",
                                  "Responsive grid — Container, row, and column layout system",
                                  "Form controls — Input groups, form groups, validation styles, date/time pickers",
                                  "Navigation — Navbar, navs, tabs, breadcrumbs, pagination",
                                  "Modals — Show/hide/shown/hidden event lifecycle",
                                  "Carousel — Slide shows with events, features, and options",
                                  "Dropdown — Toggleable menus with events and positioning via Popper.js",
                                  "Button groups — Checkbox, radio, switch, and toolbar variants",
                                  "Cards — Flexible content containers with themed layouts",
                                  "Toasts — Lightweight notification components with events",
                                  "Auto component detection — IOnComponentAdded SPI auto-applies Bootstrap classes",
                                  "CRTP fluent API for component configuration",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>bootstrap</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:bootstrap:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Card component
                                          BSCard<?> card = new BSCard<>();
                                          card.addCardHeader("Header");
                                          card.addCardBody("Content");
                                          card.addCardFooter("Footer");
                                          
                                          // Modal with events
                                          BSModal<?> modal = new BSModal<>();
                                          modal.addTitle("Confirm");
                                          modal.addModalBody("Are you sure?");
                                          modal.addDismissButton("Cancel");
                                          modal.addPrimaryButton("OK");""")
                          .spiProvides(List.of("IPageConfigurator", "IGuiceScanModuleInclusions", "IOnComponentAdded", "IOnComponentConfigured"))
                          .build();
    }

    private static PluginEntry buildAngularMaterial()
    {
        return PluginEntry.builder("angular-material", "Angular Material", CAT_RENDERING, "com.jwebmp.plugins", "angular-material")
                          .framework(true)
                          .description(
                                  "Angular Material 19.1.4 — Google's official Material Design component library for Angular with 30+ type-safe Java wrappers. "
                                  + "Accordion, autocomplete, buttons, checkboxes, chips, dialogs, form fields, icons, progress bars, selects, and tables "
                                  + "with CRTP fluent APIs, Roboto font injection, Material Icons, and prebuilt Azure Blue theme.")
                          .upstreamName("Angular Material")
                          .upstreamVersion("19.1.4")
                          .upstreamUrl("https://material.angular.io/")
                          .jpmsModule("com.jwebmp.core.angular.angular")
                          .readmePath("plugins/angular-material/README.md")
                          .docsUrl("https://material.angular.io/components/categories")
                          .sourceUrl("https://github.com/JWebMP/AngularMaterial")
                          .techBadges(List.of("Java 25+", "Angular Material 19.1.4", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "@angular/material", "^19.1.4",
                                  "@angular/animations", "^19.0.1"
                          ))
                          .features(List.of(
                                  "30+ Material Design components — Accordion, Autocomplete, Button, Checkbox, Chips, Dialog, Form Field, Icon, Progress Bar, Select, Table",
                                  "Prebuilt themes — Azure Blue theme auto-loaded via @NgStyleSheet",
                                  "Material Icons — Google Material Icons font auto-injected",
                                  "Roboto font — auto-injected via page configurator",
                                  "Accordion — expansion panels with display modes, toggle positions, and action rows",
                                  "Form fields — mat-form-field wrappers with label, hint, error, prefix/suffix support",
                                  "Autocomplete — type-ahead suggestions with filtering",
                                  "Chips — input chips with autocomplete and grid layout",
                                  "Dialog — modal dialogs with typed data passing",
                                  "Table — mat-table with sorting, pagination, and data sources",
                                  "Select — single and multi-select dropdowns",
                                  "Progress bars — determinate, indeterminate, buffer, and query modes with color variants",
                                  "CRTP fluent API for component configuration",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>angular-material</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:angular-material:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Accordion with expansion panels
                                          var accordion = new MatAccordion<>();
                                          var panel = new MatAccordionPanel<>();
                                          panel.getHeader().getTitle().setText("Section 1");
                                          panel.getContent().add(new Paragraph<>().setText("Content"));
                                          accordion.add(panel);
                                          
                                          // Button with icon
                                          var button = new MatButton<>();
                                          button.add(new MatIcon<>("home"));
                                          button.setText("Home");""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    // ── Angular Generation ────────────────────────────

    private static PluginEntry buildAngular()
    {
        return PluginEntry.builder("angular", "Angular Plugin", CAT_ANGULAR, "com.jwebmp.plugins", "angular")
                          .description(
                                  "Generates complete Angular 21 TypeScript projects from Java annotations — components, routing, modules, "
                                  + "environment config, STOMP/WebSocket bridge — and serves the SPA via Vert.x with fallback routing. "
                                  + "Annotate your Java classes with @NgApp, @NgComponent, @NgRoutable, @NgDataService — the compiler produces "
                                  + ".ts files, angular.json, package.json, tsconfig.json, routing modules, and environment config.")
                          .upstreamName("Angular")
                          .upstreamVersion("20")
                          .upstreamUrl("https://angular.dev/")
                          .jpmsModule("com.jwebmp.core.angular")
                          .readmePath("plugins/angular/README.md")
                          .sourceUrl("https://github.com/JWebMP/Angular")
                          .techBadges(List.of("Java 25+", "Angular 21", "Vert.x 5", "STOMP/WebSocket", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of())
                          .features(List.of(
                                  "TypeScript code generation — TypeScriptCompiler orchestrates ComponentProcessor, AngularModuleProcessor, AssetManager, DependencyManager, and CodeValidator",
                                  "SPA hosting via Vert.x — serves dist/ with StaticHandler, /assets/* mount, SPA fallback for Angular Router",
                                  "STOMP/WebSocket bridge — StompServer at /eventbus with v10/v11/v12.stomp sub-protocols, 10s/50s heartbeats",
                                  "Reactive message processing — inbound STOMP messages dispatched to IWebSocketMessageReceiver listeners",
                                  "Built-in WebSocket receivers — ajax, data, dataSend, AddToWebSocketGroup, RemoveFromWebSocketGroup actions",
                                  "Angular control-flow components — NgIf, NgIfElse, NgFor, NgForEmpty, NgLet for Angular 17+ template syntax",
                                  "Routing — AngularRoutingModule scans @NgRoutable classes, builds DefinedRoute tree, generates RouterModule.forRoot(routes)",
                                  "Environment module — generates TypeScript const environment from Java EnvironmentOptions",
                                  "Angular project scaffolding — generates angular.json, package.json, tsconfig.json, app.config.json",
                                  "RouterLink component with [routerLink], [queryParams], [state] binding",
                                  "WebSocket group management — WebSocketGroupsDirective for declarative group subscription",
                                  "NPM resource locator — discovers and serves bundled node_modules resources from classpath"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>angular</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:angular:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          @NgApp(value = "my-app", bootComponent = AppComponent.class)
                                          public class MyApp extends NGApplication<MyApp> { }
                                          
                                          @NgComponent("app-root")
                                          public class AppComponent extends DivSimple<AppComponent>
                                                  implements INgComponent<AppComponent> { }
                                          
                                          @NgRoutable(path = "dashboard", parent = {AppComponent.class})
                                          @NgComponent("app-dashboard")
                                          public class DashboardPage extends DivSimple<DashboardPage>
                                                  implements INgComponent<DashboardPage> { }""")
                          .spiProvides(List.of(
                                  "IGuiceScanModuleInclusions", "IGuiceConfigurator", "IGuicePreStartup",
                                  "IGuiceModule", "VertxRouterConfigurator", "VertxHttpServerOptionsConfigurator",
                                  "IGuicePostStartup", "IOnComponentConfigured", "IOnClickService",
                                  "IWebSocketMessageReceiver"
                          ))
                          .spiUses(List.of(
                                  "AngularScanPackages", "RenderedAssets", "NpmrcConfigurator",
                                  "WebSocketGroupAdd", "TypescriptIndexPageConfigurator",
                                  "IPageConfigurator", "IWebSocketAuthDataProvider"
                          ))
                          .build();
    }

    private static PluginEntry buildAngularMavenPlugin()
    {
        return PluginEntry.builder("angular-maven-plugin", "Angular Maven Plugin", CAT_ANGULAR, "com.jwebmp.plugins", "angular-maven-plugin")
                          .description(
                                  "Maven build plugin that drives the full Angular build lifecycle — discovers @NgApp classes, generates .ts sources, "
                                  + "installs npm dependencies, provisions Node.js and the Angular CLI, executes the production build, and optionally "
                                  + "produces a Docker image with nginx. Uses a flat URLClassLoader with parent-first delegation for reliable "
                                  + "classpath resolution in the Maven plugin context.")
                          .upstreamName("Maven / Angular CLI")
                          .upstreamVersion("3.9.6+ / 20")
                          .upstreamUrl("https://angular.dev/tools/cli")
                          .jpmsModule("com.jwebmp.plugins.angular.maven")
                          .readmePath("plugins/angular-maven-plugin/README.md")
                          .sourceUrl("https://github.com/JWebMP/Angular")
                          .techBadges(List.of("Java 25+", "Maven Plugin", "Angular CLI", "Docker", "JPMS Modular"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9.6+", "Docker (optional, for image generation)"))
                          .features(List.of(
                                  "Maven goal jwebmp-angular:build — compiles TypeScript for every @NgApp on classpath (default phase: install)",
                                  "Flat URLClassLoader with parent-first delegation and automatic classpath deduplication",
                                  "Configurable classpath scope — runtime (default), compile, test, packaged/package/artifact",
                                  "Explicit app selection via <appClasses> or auto-discovery of all @NgApp implementations",
                                  "Optional npm install with --force flag support",
                                  "Optional Node.js/npm toolchain provisioning with configurable version (default 20.18.1)",
                                  "Optional Angular CLI provisioning with configurable version",
                                  "Optional production build execution (ng build)",
                                  "Docker image generation — auto-generates Dockerfile and nginx.conf, or uses custom files",
                                  "Nginx HTTPS support with TLS certificates, HTTP-to-HTTPS redirect, and custom server directives",
                                  "Configurable Docker base image (default nginx:alpine), image name, and build arguments",
                                  "Configurable output directory via outputDirectory parameter",
                                  "Skip support via <skip>true</skip> or -Djwebmp.angular.skip=true"
                          ))
                          .mavenSnippet(
                                  """
                                          <plugin>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>angular-maven-plugin</artifactId>
                                            <version>2.0.0-SNAPSHOT</version>
                                            <executions>
                                              <execution>
                                                <goals><goal>build</goal></goals>
                                              </execution>
                                            </executions>
                                          </plugin>""")
                          .quickStartCode(
                                  """
                                          <!-- In your pom.xml <build><plugins> section -->
                                          <plugin>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>angular-maven-plugin</artifactId>
                                            <configuration>
                                              <installDependencies>true</installDependencies>
                                              <ensureToolchain>true</ensureToolchain>
                                              <buildAngular>true</buildAngular>
                                              <!-- Optional: build a Docker image -->
                                              <buildDockerImage>true</buildDockerImage>
                                            </configuration>
                                          </plugin>""")
                          .quickStartLanguage("xml")
                          .build();
    }

    private static PluginEntry buildTypeScriptClient()
    {
        return PluginEntry.builder("typescript-client", "TypeScript Client Annotations", CAT_ANGULAR, "com.jwebmp.plugins", "typescript-client")
                          .description(
                                  "Annotation library for describing Angular metadata in Java — @NgComponent, @NgDataService, @NgDirective, "
                                  + "@NgRoutable, @NgField, @NgSignal, lifecycle hooks, import management, and boot-module configuration. "
                                  + "The generator produces ready-to-compile .ts files, Angular modules, routing configs, and STOMP-backed event-bus services.")
                          .upstreamName("Angular / TypeScript")
                          .upstreamVersion("20 / 5")
                          .upstreamUrl("https://angular.dev/")
                          .jpmsModule("com.jwebmp.core.base.angular.client")
                          .readmePath("plugins/tsclient/README.md")
                          .sourceUrl("https://github.com/JWebMP/TypescriptClient")
                          .techBadges(List.of("Java 25+", "Maven 4", "JPMS Modular"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+"))
                          .features(List.of(
                                  "Ng* annotation family — @NgApp, @NgComponent, @NgModule, @NgDirective, @NgDataService, @NgDataType, @NgServiceProvider, @NgProvider, @NgValidator, @NgSchema",
                                  "Component metadata — @NgInput, @NgOutput, @NgComponentTagAttribute for Angular I/O",
                                  "Lifecycle hooks — @NgOnInit, @NgOnDestroy, @NgAfterViewInit, @NgAfterViewChecked, @NgAfterContentInit",
                                  "Structural code generation — @NgField, @NgMethod, @NgConstructorParameter, @NgConstructorBody, @NgInterface, @NgSignal, @NgSignalComputed, @NgSignalEffect",
                                  "Import management — @NgImportReference, @NgImportModule, @NgImportProvider, @NgComponentReference",
                                  "Global annotations — @NgGlobalField, @NgGlobalConstructorParameter for cross-cutting concerns",
                                  "Routing — @NgRoutable (path, redirectTo, pathMatch, parent, sortOrder) and @NgRouteData",
                                  "Boot-module annotations — @NgBootDeclaration, @NgBootModuleImport, @NgBootImportReference, @NgBootEntryComponent",
                                  "Angular CLI config — @NgAsset, @NgScript, @NgStyleSheet, @NgPolyfill for angular.json integration",
                                  "TypeScript dependencies — @TsDependency, @TsDevDependency, @NgSourceDirectoryReference",
                                  "Built-in EventBusService — STOMP over WebSocket with auto-reconnect and RxJS observables",
                                  "Java to TypeScript field mapping — introspects generics, enums, dates, optionals with jakarta.validation awareness"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>typescript-client</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:typescript-client:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          @NgComponent("my-widget")
                                          public class MyWidget extends DivSimple<MyWidget>
                                                  implements INgComponent<MyWidget> {
                                          
                                              @NgField("title = 'Hello World'")
                                              String title;
                                          
                                              @NgOnInit
                                              public void onInit() {
                                                  add(new Paragraph<>().setText("{{ title }}"));
                                              }
                                          }""")
                          .spiProvides(List.of(
                                  "IGuiceScanModuleInclusions", "IGuiceModule", "IGuiceConfigurator", "IGuicePostStartup"
                          ))
                          .spiUses(List.of(
                                  "OnGetAllConstructorParameters", "OnGetAllConstructorBodies",
                                  "OnGetAllFields", "OnGetAllImports", "OnGetAllMethods", "OnGetAllModuleImports"
                          ))
                          .build();
    }

    // ── Data & Grids ──────────────────────────────────

    private static PluginEntry buildAgGrid()
    {
        return PluginEntry.builder("aggrid", "AG Grid", CAT_DATA, "com.jwebmp.plugins", "aggrid")
                          .description(
                                  "Feature-rich data grid (AG Grid 35.0.0) — server-driven configuration, column definitions, row models, "
                                  + "filtering, sorting, pagination, and real-time updates, all as type-safe Java with Angular integration. "
                                  + "Supports client-side and server-side row models with CRTP fluent builders.")
                          .upstreamName("AG Grid")
                          .upstreamVersion("35.0.0")
                          .upstreamUrl("https://www.ag-grid.com/")
                          .jpmsModule("com.jwebmp.plugins.aggrid")
                          .readmePath("plugins/aggrid/README.md")
                          .docsUrl("https://www.ag-grid.com/documentation/")
                          .sourceUrl("https://github.com/JWebMP/AgGrid")
                          .techBadges(List.of("Java 25+", "AG Grid 35.0.0", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "ag-grid-community", "^35.0.0",
                                  "ag-grid-angular", "^35.0.0"
                          ))
                          .features(List.of(
                                  "Server-driven configuration — define grids entirely in Java with CRTP fluent API",
                                  "Type-safe column definitions — AgGridColumnDef with field, header, width, cellRenderer, cellDataType",
                                  "Row selection — single and multiple selection modes",
                                  "Pagination — built-in pagination with configurable page sizes",
                                  "Filtering and sorting — client-side and server-side with multi-column support",
                                  "Cell renderers — custom cell rendering with Java-based ICellRenderer implementations",
                                  "Event handling — row selection, cell clicks, custom events with type-safe handlers",
                                  "Real-time updates — WebSocket integration for live data streaming",
                                  "Module registry — AllCommunityModule auto-registered via PageConfigurator",
                                  "Angular 21 integration — auto-generated components with change detection",
                                  "Reactive data binding — built on Vert.x 5 for non-blocking operations",
                                  "JSON serialization — automatic Jackson serialization for Angular binding"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>aggrid</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:aggrid:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          public class OrderGrid extends AgGrid<OrderGrid> {
                                              public OrderGrid() {
                                                  setHeight("600px")
                                                      .enablePagination(25)
                                                      .enableRowSelection("multiple");
                                          
                                                  addColumn(new AgGridColumnDef()
                                                      .setField("orderId")
                                                      .setHeaderName("Order ID")
                                                      .setWidth(100));
                                          
                                                  addColumn(new AgGridColumnDef()
                                                      .setField("status")
                                                      .setHeaderName("Status")
                                                      .setCellRenderer(StatusBadgeRenderer.class));
                                              }
                                          }""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildAgGridEnterprise()
    {
        return PluginEntry.builder("aggrid-enterprise", "AG Grid Enterprise", CAT_DATA, "com.jwebmp.plugins", "aggrid-enterprise")
                          .description(
                                  "Enterprise grid features — integrated charting, row grouping, server-side row model, pivot tables, "
                                  + "range selection, clipboard, Excel export, and status bar, extending the community AG Grid plugin. "
                                  + "8 focused feature modules with @JsonUnwrapped pattern for strongly-typed options.")
                          .upstreamName("AG Grid Enterprise")
                          .upstreamVersion("35.0.0")
                          .upstreamUrl("https://www.ag-grid.com/")
                          .jpmsModule("com.jwebmp.plugins.aggridenterprise")
                          .readmePath("plugins/aggrid-enterprise/README.md")
                          .docsUrl("https://www.ag-grid.com/documentation/")
                          .sourceUrl("https://github.com/JWebMP/AgGridEnterprise")
                          .techBadges(List.of("Java 25+", "AG Grid Enterprise 35.0.0", "AG Charts 13.0.0", "Angular 21", "JPMS Modular", "License Required"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "ag-grid-enterprise", "^35.0.0",
                                  "ag-charts-enterprise", "^13.0.0"
                          ))
                          .requiresLicense(true)
                          .licenseNote("AG Grid Enterprise requires a commercial license. 30-day evaluation available from ag-grid.com/license-pricing/")
                          .features(List.of(
                                  "Integrated charts — render charts directly from grid data with configurable themes",
                                  "Server-side row model — lazy-load millions of rows with backend pagination",
                                  "Row grouping — group by multiple columns, custom hierarchies, expandable groups",
                                  "Pivot tables — row and column pivots with value aggregation",
                                  "Range selection — select and copy cell ranges, Excel-like behavior",
                                  "Excel export — export with styles, formulas, and formatting",
                                  "Side bar — columns and filters panels with user toggle",
                                  "Status bar — row count, selection count, aggregation metrics",
                                  "Advanced filtering — filter builder UI with complex expressions",
                                  "Row numbers — official AG Grid row numbering with helper method",
                                  "AllEnterpriseModule auto-registered via PageConfigurator",
                                  "8 focused feature modules with @JsonUnwrapped pattern"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>aggrid-enterprise</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:aggrid-enterprise:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Set license key at startup
                                          AgGridEnterprisePageConfigurator
                                              .setAG_GRID_LICENSE_KEY("YOUR_LICENSE_KEY");
                                          
                                          // Server-side row model (millions of rows)
                                          gridOptions.setRowModelType(RowModelType.SERVER_SIDE)
                                              .setServerSideInitialRowCount(1000);
                                          
                                          // Row grouping and aggregation
                                          gridOptions.setRowGroupPanelShow(RowGroupPanelShow.ALWAYS)
                                              .addRowGroupColumn("region")
                                              .addValueColumn("revenue");""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildDataTables()
    {
        return PluginEntry.builder("datatables", "DataTables", CAT_DATA, "com.jwebmp.plugins", "data-tables")
                          .description(
                                  "DataTables.net 2.3.8 — advanced interactive HTML tables with multi-column sorting, filtering, "
                                  + "pagination, AJAX server-side processing, responsive layouts, export buttons (PDF/Excel/CSV), "
                                  + "search panes, row grouping, virtual scrolling, and dozens of extensions with type-safe Java options.")
                          .upstreamName("DataTables.net")
                          .upstreamVersion("2.3.8")
                          .upstreamUrl("https://www.datatables.net/")
                          .jpmsModule("com.jwebmp.plugins.datatable")
                          .readmePath("plugins/datatables/README.md")
                          .docsUrl("https://datatables.net/manual/")
                          .sourceUrl("https://github.com/JWebMP/JWebMP")
                          .techBadges(List.of("Java 25+", "DataTables 2.3.8", "jQuery 4.0.0", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "datatables.net", "^2.3.8",
                                  "datatables.net-dt", "^2.3.8",
                                  "jszip", "^3.10.1",
                                  "pdfmake", "^0.3.7"
                          ))
                          .features(List.of(
                                  "Multi-column sorting with custom sort types",
                                  "Global and per-column filtering",
                                  "Multiple pagination types (simple, full, numbers)",
                                  "AJAX server-side processing with search DTOs",
                                  "Responsive — auto-collapse columns on small screens",
                                  "Buttons — export to PDF, Excel, CSV, copy, print",
                                  "AutoFill — Excel-like click-and-drag cell filling",
                                  "ColReorder — drag-and-drop column reordering",
                                  "FixedColumns/FixedHeader — freeze columns and headers",
                                  "KeyTable — keyboard navigation between cells",
                                  "RowGroup — automatic grouping by column value",
                                  "RowReorder — drag-and-drop row reordering",
                                  "Scroller — virtual scrolling for large datasets",
                                  "SearchPanes — faceted search panels",
                                  "Select — row/column/cell selection",
                                  "Type-safe options — all as JSON-serializable Java classes",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>data-tables</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:data-tables:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          DataTable<?> table = new DataTable<>("myTable");
                                          table.getOptions()
                                               .setPaging(true)
                                               .setSearching(true)
                                               .setOrdering(true);
                                          
                                          // Add export buttons
                                          table.getOptions().getButtons()
                                               .add(DataTableButtons.Excel);
                                          table.getOptions().getButtons()
                                               .add(DataTableButtons.Pdf);""")
                          .spiProvides(List.of("IPageConfigurator", "IGuiceScanModuleInclusions"))
                          .build();
    }

    // ── Charts & Visualisation ────────────────────────

    private static PluginEntry buildAgCharts()
    {
        return PluginEntry.builder("agcharts", "AG Charts", CAT_CHARTS, "com.jwebmp.plugins", "agcharts")
                          .description(
                                  "Enterprise charting (AG Charts 13.1.0) — 38 chart types with CRTP fluent API, reactive data binding, "
                                  + "server-side configuration, and full TypeScript generation for Angular 21. "
                                  + "Covers line, bar, area, scatter, bubble, pie, donut, histogram, and all cartesian/polar variants.")
                          .upstreamName("AG Charts")
                          .upstreamVersion("13.1.0")
                          .upstreamUrl("https://charts.ag-grid.com/")
                          .jpmsModule("com.jwebmp.plugins.agcharts")
                          .readmePath("plugins/agcharts/README.md")
                          .docsUrl("https://charts.ag-grid.com/javascript/")
                          .sourceUrl("https://github.com/JWebMP/AgCharts")
                          .techBadges(List.of("Java 25+", "AG Charts 13.1.0", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "ag-charts-community", "^13.1.0",
                                  "ag-charts-angular", "^13.1.0"
                          ))
                          .features(List.of(
                                  "Complete AG Charts 13.1.0 API — all 38 official chart options implemented with type-safe Java models",
                                  "CRTP fluent builders — type-safe, self-referencing setters for intuitive chart configuration",
                                  "Multiple chart types — Line, Bar, Area, Scatter, Bubble, Pie, Donut, Histogram, and more",
                                  "Advanced axes — Number, Time, Log, Category, Grouped Category, Ordinal Time",
                                  "Rich interactions — tooltips, legends, zoom, pan, highlighting, animations, context menus",
                                  "Theming support — Material, Polychrome, Vivid, Solar built-in themes plus custom theme API",
                                  "Gradient legends for heatmaps and continuous color scales",
                                  "Navigator component — mini-chart navigator for large datasets with zoom controls",
                                  "Overlays and annotations — custom overlays, chart annotations, and watermarks",
                                  "Reactive data binding — real-time chart updates via Angular observables",
                                  "TypeScript type generation — automatic from Java models",
                                  "Server-side configuration — define charts in Java, render client-side"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>agcharts</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:agcharts:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          @NgComponent
                                          public class SalesChart implements INgComponent<SalesChart> {
                                              public AgChartOptions<SalesChart> getOptions() {
                                                  return new AgChartOptions<>(this)
                                                      .setSeries(List.of(
                                                          new AgLineSeriesOptions<>()
                                                              .setXKey("month")
                                                              .setYKey("sales")
                                                              .setYName("Sales")
                                                      ))
                                                      .setAxes(List.of(
                                                          new AgCategoryAxisOptions<>()
                                                              .setPosition(AgCartesianAxisPosition.BOTTOM),
                                                          new AgNumberAxisOptions<>()
                                                              .setPosition(AgCartesianAxisPosition.LEFT)
                                                      ));
                                              }
                                          }""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildAgChartsEnterprise()
    {
        return PluginEntry.builder("agcharts-enterprise", "AG Charts Enterprise", CAT_CHARTS, "com.jwebmp.plugins", "agcharts-enterprise")
                          .description(
                                  "Advanced chart types — gauges, heatmaps, polar charts, hierarchical visualisations, and financial "
                                  + "instruments extending the community AG Charts plugin. Includes radial/linear gauges, candlestick, "
                                  + "OHLC, waterfall, treemap, sunburst, sankey, and chord diagrams.")
                          .upstreamName("AG Charts Enterprise")
                          .upstreamVersion("13.1.0")
                          .upstreamUrl("https://charts.ag-grid.com/javascript/license/")
                          .jpmsModule("com.jwebmp.plugins.agchartsenterprise")
                          .readmePath("plugins/agcharts-enterprise/README.md")
                          .docsUrl("https://charts.ag-grid.com/javascript/")
                          .sourceUrl("https://github.com/JWebMP/AgChartsEnterprise")
                          .techBadges(List.of("Java 25+", "AG Charts Enterprise 13.1.0", "Angular 21", "JPMS Modular", "License Required"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "ag-charts-enterprise", "^13.1.0"
                          ))
                          .requiresLicense(true)
                          .licenseNote("AG Charts Enterprise requires a commercial license. 30-day evaluation available from ag-grid.com/license-pricing/")
                          .features(List.of(
                                  "Financial charts — Candlestick, OHLC, Waterfall, Box Plot, Histogram",
                                  "Gauges — Radial and Linear gauges with segmentation, targets, and scales",
                                  "Polar charts — Radial Column, Radial Bar, Nightingale, Radar (Line and Area)",
                                  "Heatmaps — color-coded grid visualizations with gradient scales",
                                  "Hierarchical charts — Treemap, Sunburst, Sankey, Chord",
                                  "Specialized visualizations — Funnel charts, Range Area, Range Bar",
                                  "CRTP fluent builders for all enterprise chart options",
                                  "Advanced styling — custom colors, gradients, fills, and patterns",
                                  "Interactive features — tooltips, legends, zoom, pan, highlighting"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>agcharts-enterprise</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:agcharts-enterprise:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Set license key
                                          AgChartsEnterprisePageConfigurator
                                              .setAG_CHARTS_LICENSE_KEY("YOUR_KEY");
                                          
                                          @NgComponent
                                          public class DashboardGauge
                                                  implements INgComponent<DashboardGauge> {
                                              public AgRadialGaugeOptions<DashboardGauge> gauge() {
                                                  return new AgRadialGaugeOptions<>(this)
                                                      .setValue(75.0)
                                                      .setScale(new AgGaugeScale()
                                                          .setMin(0).setMax(100));
                                              }
                                          }""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildChartJs()
    {
        return PluginEntry.builder("chartjs", "Chart.js", CAT_CHARTS, "com.jwebmp.plugins", "chartjs")
                          .description(
                                  "Lightweight charting with Chart.js — bar, line, pie, doughnut, radar, and polar area charts "
                                  + "configured entirely in Java with JSON output. Based on the Chart.java library for seamless "
                                  + "integration between Java backend and Chart.js frontend.")
                          .upstreamName("Chart.js")
                          .upstreamVersion("2.x")
                          .upstreamUrl("https://www.chartjs.org/")
                          .jpmsModule("com.jwebmp.plugins.chartjs")
                          .readmePath("plugins/chartjs/README.md")
                          .docsUrl("https://www.chartjs.org/docs/")
                          .sourceUrl("https://github.com/JWebMP/ChartJS")
                          .techBadges(List.of("Java 25+", "Chart.js", "JPMS Modular"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+"))
                          .features(List.of(
                                  "Bar charts with configurable datasets, colors, and border widths",
                                  "Line charts with point styles, tension, and fill options",
                                  "Pie and doughnut charts with segment customization",
                                  "Radar charts for multi-axis data comparison",
                                  "Polar area charts with angular scales",
                                  "Color API for type-safe color definitions",
                                  "Java to JSON serialization — toJson() for direct Chart.js consumption",
                                  "Lightweight — minimal dependencies compared to enterprise charting"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>chartjs</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:chartjs:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          BarDataset dataset = new BarDataset()
                                              .setLabel("Monthly Sales")
                                              .setData(65, 59, 80, 81, 56, 55, 40)
                                              .addBackgroundColors(Color.RED, Color.GREEN,
                                                  Color.BLUE, Color.YELLOW)
                                              .setBorderWidth(2);
                                          
                                          BarData data = new BarData()
                                              .addLabels("Mon", "Tue", "Wed", "Thu",
                                                  "Fri", "Sat", "Sun")
                                              .addDataset(dataset);
                                          
                                          String json = new BarChart(data).toJson();""")
                          .build();
    }

    // ── Scheduling ────────────────────────────────────

    private static PluginEntry buildFullCalendar()
    {
        return PluginEntry.builder("fullcalendar", "FullCalendar", CAT_SCHEDULING, "com.jwebmp.plugins", "fullcalendar")
                          .description(
                                  "Full-featured calendar (FullCalendar 6.1.19) — drag-and-drop scheduling, multiple views, "
                                  + "timezone support, and server-driven event management with Angular integration. "
                                  + "Supports DayGrid, TimeGrid, List views, recurring events, localization for 50+ locales, "
                                  + "and Bootstrap 5 theming.")
                          .upstreamName("FullCalendar")
                          .upstreamVersion("6.1.19")
                          .upstreamUrl("https://fullcalendar.io/")
                          .jpmsModule("com.jwebmp.plugins.fullcalendar")
                          .readmePath("plugins/fullcalendar/README.md")
                          .docsUrl("https://fullcalendar.io/docs")
                          .sourceUrl("https://github.com/JWebMP/FullCalendar")
                          .techBadges(List.of("Java 25+", "FullCalendar 6.1.19", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "@fullcalendar/angular", "^6.1.19",
                                  "@fullcalendar/daygrid", "^6.1.19",
                                  "@fullcalendar/timegrid", "^6.1.19",
                                  "@fullcalendar/list", "^6.1.19",
                                  "@fullcalendar/interaction", "^6.1.19",
                                  "@fullcalendar/bootstrap5", "^6.1.19",
                                  "@fullcalendar/luxon2", "^6.1.19",
                                  "@fullcalendar/moment-timezone", "^6.1.19"
                          ))
                          .features(List.of(
                                  "Full calendar views — Day, Week, Month, List, and custom views",
                                  "Drag and drop events — interactive event creation, editing, and rescheduling",
                                  "Multiple calendar types — DayGrid, TimeGrid, List",
                                  "Full IANA timezone support via Moment Timezone",
                                  "Localization — multi-language support with 50+ locales",
                                  "Event sources — JSON feeds, functions, Google Calendar integration",
                                  "Recurring events with RRule support",
                                  "Bootstrap 5 theme integration",
                                  "Mobile adaptive — responsive design with touch support",
                                  "Type-safe Java API — CRTP fluent API for calendar configuration",
                                  "Server-driven config — configure calendar entirely from Java backend",
                                  "Automatic Jackson serialization for Angular binding"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>full-calendar</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:full-calendar:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          FullCalendarOptions options = new FullCalendarOptions()
                                              .setInitialView("dayGridMonth")
                                              .setLocale("en")
                                              .setTimeZone("UTC")
                                              .setEditable(true)
                                              .setHeaderToolbar(new Toolbar()
                                                  .setLeft("prev,next today")
                                                  .setCenter("title")
                                                  .setRight("dayGridMonth,timeGridWeek,listWeek"))
                                              .addEvent(new Event()
                                                  .setTitle("Team Meeting")
                                                  .setStart("2026-03-24T10:00:00")
                                                  .setEnd("2026-03-24T11:00:00"));""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildFullCalendarPro()
    {
        return PluginEntry.builder("fullcalendar-pro", "FullCalendar Pro", CAT_SCHEDULING, "com.jwebmp.plugins", "fullcalendar-pro")
                          .description(
                                  "Premium calendar features — resource timeline, resource day/time grids, adaptive mobile views, "
                                  + "and enterprise scheduling extending the community FullCalendar plugin. "
                                  + "Schedule events across multiple resources (rooms, people, equipment) with horizontal timeline views.")
                          .upstreamName("FullCalendar Pro")
                          .upstreamVersion("6.1.19")
                          .upstreamUrl("https://fullcalendar.io/")
                          .jpmsModule("com.jwebmp.plugins.fullcalendarpro")
                          .readmePath("plugins/fullcalendar-pro/README.md")
                          .docsUrl("https://fullcalendar.io/docs/premium")
                          .sourceUrl("https://github.com/JWebMP/FullCalendarPro")
                          .techBadges(List.of("Java 25+", "FullCalendar Pro 6.1.19", "Angular 21", "JPMS Modular", "License Required"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+", "Node.js 18+", "Angular 21+", "FullCalendar Pro License"))
                          .npmDependencies(Map.of(
                                  "@fullcalendar/resource-timegrid", "^6.1.19",
                                  "@fullcalendar/resource-timeline", "^6.1.19",
                                  "@fullcalendar/resource-daygrid", "^6.1.19",
                                  "@fullcalendar/adaptive", "^6.1.19"
                          ))
                          .requiresLicense(true)
                          .licenseNote("FullCalendar Pro requires an active premium subscription. Get your license at fullcalendar.io/pricing")
                          .features(List.of(
                                  "Resource scheduling — schedule events across rooms, people, and equipment",
                                  "Timeline views — horizontal timeline for resource scheduling and planning",
                                  "Resource DayGrid — day/week/month grid views with resource grouping",
                                  "Resource TimeGrid — time-based grid views with resource columns",
                                  "Adaptive mobile views — responsive calendar views optimized for mobile",
                                  "Vertical resource view — display resources as vertical columns",
                                  "Extends community FullCalendar — all standard features included",
                                  "Type-safe Java API — CRTP fluent API for resource configuration"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>full-calendar-pro</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:full-calendar-pro:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          FullCalendarOptions options = new FullCalendarOptions()
                                              .setInitialView("resourceTimelineDay")
                                              .setResourceAreaHeaderContent("Resources")
                                              .setResources(List.of(
                                                  new Resource().setId("r1").setTitle("Room A"),
                                                  new Resource().setId("r2").setTitle("Room B")
                                              ))
                                              .addEvent(new Event()
                                                  .setTitle("Booking")
                                                  .setResourceId("r1")
                                                  .setStart("2026-03-24T09:00")
                                                  .setEnd("2026-03-24T12:00"));""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    // ── Icons ─────────────────────────────────────────

    private static PluginEntry buildFontAwesome()
    {
        return PluginEntry.builder("fontawesome", "Font Awesome", CAT_ICONS, "com.jwebmp.plugins", "fontawesome")
                          .description(
                                  "Font Awesome Free 7.2.0 — scalable vector icons (Solid and Brands sets) rendered via SVG "
                                  + "with Angular FontAwesome integration and type-safe Java enum API. "
                                  + "2,000+ free icons with transformations, layering, masking, and animation effects.")
                          .upstreamName("Font Awesome")
                          .upstreamVersion("7.2.0")
                          .upstreamUrl("https://fontawesome.com/")
                          .jpmsModule("com.jwebmp.plugins.fontawesome5")
                          .readmePath("plugins/fontawesome/README.md")
                          .docsUrl("https://fontawesome.com/docs")
                          .sourceUrl("https://github.com/JWebMP/FontAwesome")
                          .techBadges(List.of("Java 25+", "Font Awesome 7.2.0", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "@fortawesome/fontawesome-svg-core", "^7.2.0",
                                  "@fortawesome/free-solid-svg-icons", "^7.2.0",
                                  "@fortawesome/free-brands-svg-icons", "^6.2.2",
                                  "@fortawesome/angular-fontawesome", "^4.0.0"
                          ))
                          .features(List.of(
                                  "2,000+ free icons — Font Awesome Free Solid and Brands icon sets",
                                  "Type-safe Java enum API — FontAwesomeIcons and FontAwesomeBrandIcons with compile-time safety",
                                  "Multiple icon styles — Solid and Brand styles included",
                                  "SVG or Web Font rendering — choose between SVG core or classic CSS web fonts",
                                  "Icon transformations — rotate, flip, scale, position with fluent API",
                                  "Layering and masking — combine multiple icons with layers and masks",
                                  "Animation effects — built-in spin, pulse, and custom animations",
                                  "Sizing options — preset sizes from xs to 10x, or custom sizing",
                                  "Angular FontAwesome module integration",
                                  "CRTP fluent API for icon configuration",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>font-awesome</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:font-awesome:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Solid icon
                                          FontAwesome icon = new FontAwesome(
                                              FontAwesomeStyles.Solid,
                                              FontAwesomeIcons.cog);
                                          
                                          // Brand icon
                                          FontAwesome github = IFontAwesome.createIcon(
                                              FontAwesomeBrandIcons.github,
                                              FontAwesomeStyles.Brand);
                                          
                                          // With animation
                                          icon.spin().setSize(FontAwesomeSizes.Fa3x);""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildFontAwesomePro()
    {
        return PluginEntry.builder("fontawesome-pro", "Font Awesome Pro", CAT_ICONS, "com.jwebmp.plugins", "fontawesome-pro")
                          .description(
                                  "Font Awesome Pro 7.2.0 — 10,000+ premium icons across Regular, Light, Duotone, and Thin styles "
                                  + "extending the community Font Awesome plugin. Requires an active Font Awesome Pro subscription.")
                          .upstreamName("Font Awesome Pro")
                          .upstreamVersion("7.2.0")
                          .upstreamUrl("https://fontawesome.com/")
                          .jpmsModule("com.jwebmp.plugins.fontawesome5pro")
                          .readmePath("plugins/fontawesome-pro/README.md")
                          .docsUrl("https://fontawesome.com/docs")
                          .sourceUrl("https://github.com/JWebMP/FontAwesomePro")
                          .techBadges(List.of("Java 25+", "Font Awesome Pro 7.2.0", "Angular 21", "JPMS Modular", "License Required"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+", "Node.js 18+", "Angular 21+", "Font Awesome Pro License"))
                          .npmDependencies(Map.of(
                                  "@fortawesome/pro-solid-svg-icons", "^7.2.0",
                                  "@fortawesome/pro-regular-svg-icons", "^7.2.0",
                                  "@fortawesome/pro-light-svg-icons", "^7.2.0",
                                  "@fortawesome/pro-duotone-svg-icons", "^7.2.0",
                                  "@fortawesome/pro-thin-svg-icons", "^7.2.0"
                          ))
                          .requiresLicense(true)
                          .licenseNote("Font Awesome Pro requires an active subscription. Get your license at fontawesome.com/plans")
                          .features(List.of(
                                  "10,000+ premium icons — complete Font Awesome Pro library",
                                  "Pro-exclusive styles — Regular, Light, Duotone, Thin",
                                  "Extends Font Awesome Free — Solid and Brand styles included",
                                  "Type-safe Java enum API with compile-time safety",
                                  "SVG or Web Font rendering",
                                  "Icon transformations — rotate, flip, scale, position",
                                  "Layering and masking — combine multiple icons",
                                  "Animation effects — spin, pulse, custom animations",
                                  "Sizing from xs to 10x",
                                  "Angular FontAwesome module integration",
                                  "CRTP fluent API for icon configuration",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>font-awesome-pro</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:font-awesome-pro:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Pro Regular icon
                                          FontAwesome icon = IFontAwesome.createIcon(
                                              FontAwesomeIcons.user,
                                              FontAwesomeStyles.Regular);
                                          
                                          // Pro Light icon
                                          FontAwesome light = IFontAwesome.createIcon(
                                              FontAwesomeIcons.heart,
                                              FontAwesomeStyles.Light);
                                          
                                          // Pro Duotone icon
                                          FontAwesome duo = IFontAwesome.createIcon(
                                              FontAwesomeIcons.bell,
                                              FontAwesomeStyles.Duotone);""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    // ── Libraries ─────────────────────────────────────

    private static PluginEntry buildJQuery()
    {
        return PluginEntry.builder("jquery", "jQuery", CAT_LIBRARIES, "com.jwebmp.plugins", "jquery")
                          .description(
                                  "jQuery 4.0.0 integration — provides jQuery and jQuery Migrate as global scripts for plugins "
                                  + "and components that depend on jQuery APIs. Auto-injected into the Angular build with correct "
                                  + "load ordering via PageConfigurator and @NgScript annotations.")
                          .upstreamName("jQuery")
                          .upstreamVersion("4.0.0")
                          .upstreamUrl("https://jquery.com/")
                          .jpmsModule("com.jwebmp.plugins.jquery")
                          .readmePath("plugins/jquery/README.md")
                          .docsUrl("https://api.jquery.com/")
                          .sourceUrl("https://github.com/JWebMP/JWebMP")
                          .techBadges(List.of("Java 25+", "jQuery 4.0.0", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "jquery", "^4.0.0",
                                  "jquery-migrate", "^4.0.2",
                                  "@types/jquery", "*"
                          ))
                          .features(List.of(
                                  "jQuery 4.0.0 — latest major release with modern browser support",
                                  "jQuery Migrate 4.0.2 — backward compatibility layer for legacy jQuery plugins",
                                  "TypeScript types — full @types/jquery for IDE autocomplete and type safety",
                                  "Automatic script loading — jQuery and Migrate auto-injected via Angular build",
                                  "Script ordering — sort-ordered @NgScript annotations ensure correct load sequence",
                                  "Zero configuration — auto-registered via ServiceLoader SPI",
                                  "JPMS module — proper Java module with explicit dependencies"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>jquery</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:jquery:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // module-info.java
                                          module com.myapp {
                                              requires com.jwebmp.plugins.jquery;
                                          }
                                          
                                          // jQuery is automatically available as a global script.
                                          // $ and jQuery are accessible in the browser.
                                          // No additional Java configuration needed.""")
                          .spiProvides(List.of("IPageConfigurator", "IGuiceScanModuleInclusions"))
                          .build();
    }

    private static PluginEntry buildJQueryUI()
    {
        return PluginEntry.builder("jquery-ui", "jQuery UI", CAT_LIBRARIES, "com.jwebmp.plugins", "jquery-ui")
                          .framework(true)
                          .description(
                                  "jQuery UI 1.14.2 — curated set of user interface interactions, effects, widgets, and themes built on jQuery. "
                                  + "Provides type-safe Java wrappers for 20+ widgets including Accordion, Autocomplete, Datepicker, Dialog, "
                                  + "Draggable, Droppable, Slider, Sortable, Tabs, and Tooltips with JSON-serializable options.")
                          .upstreamName("jQuery UI")
                          .upstreamVersion("1.14.2")
                          .upstreamUrl("https://jqueryui.com/")
                          .jpmsModule("com.jwebmp.plugins.jqueryui")
                          .readmePath("plugins/jquery-ui/README.md")
                          .docsUrl("https://api.jqueryui.com/")
                          .sourceUrl("https://github.com/JWebMP/JWebMP")
                          .techBadges(List.of("Java 25+", "jQuery UI 1.14.2", "jQuery 4.0.0", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "jquery-ui", "^1.14.2"
                          ))
                          .features(List.of(
                                  "Accordion — collapsible content panels with animation and easing options",
                                  "Autocomplete — suggestions with AJAX server-side data support",
                                  "Button — enhanced buttons and button sets with icons",
                                  "Datepicker — full-featured date selection with localization",
                                  "Dialog — modal and modeless dialog boxes with positioning",
                                  "Draggable — make elements draggable with containment and grid snapping",
                                  "Droppable — define drop targets with accept filtering",
                                  "Menu — themeable menu with keyboard navigation",
                                  "Progress Bar — determinate and indeterminate progress indicators",
                                  "Resizable — make elements resizable with handles and constraints",
                                  "Selectable — lasso-selection for element groups",
                                  "Select Menu — styled dropdown replacement",
                                  "Slider — range and value sliders with steps",
                                  "Sortable — reorderable lists with drag-and-drop",
                                  "Spinner — numeric input with increment/decrement buttons",
                                  "Tabs — tabbed content panels",
                                  "Tooltips — configurable tooltips with positioning options",
                                  "Type-safe options — all widget options as JSON-serializable Java classes",
                                  "CRTP fluent API for widget configuration",
                                  "jQuery UI base theme auto-loaded via CSS",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>jquery-ui</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:jquery-ui:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Accordion with animation
                                          JQUIAccordion accordion = new JQUIAccordion();
                                          accordion.addAccordianTab(tab1);
                                          accordion.addAccordianTab(tab2);
                                          accordion.getOptions().setCollapsible(true);
                                          accordion.getOptions().getAnimate()
                                              .setEasing(JQEasingEffects.easeInBack);
                                          
                                          // Autocomplete with AJAX
                                          JQUIAutoComplete ac = new JQUIAutoComplete("search");
                                          ac.getOptions().setAjax(true, ac);""")
                          .spiProvides(List.of("IPageConfigurator", "IGuiceScanModuleInclusions", "IGuiceScanModuleExclusions"))
                          .build();
    }

    private static PluginEntry buildGlobalize()
    {
        return PluginEntry.builder("globalize", "Globalize", CAT_LIBRARIES, "com.jwebmp.plugins", "globalize")
                          .description(
                                  "Internationalization and localization using Globalize.js and Unicode CLDR data. "
                                  + "Provides 350+ culture definitions for number formatting, date patterns, currency, "
                                  + "plural rules, and relative time. Required dependency for jQuery UI locale-aware widgets.")
                          .upstreamName("Globalize.js")
                          .upstreamVersion("1.2.2")
                          .upstreamUrl("https://github.com/globalizejs/globalize")
                          .jpmsModule("com.jwebmp.plugins.globalize.cultures")
                          .readmePath("plugins/globalize/README.md")
                          .docsUrl("https://github.com/globalizejs/globalize/wiki")
                          .sourceUrl("https://github.com/JWebMP/JWebMP")
                          .techBadges(List.of("Java 25+", "Globalize 1.2.2", "Unicode CLDR", "Angular 21", "TypeScript 5", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "globalize", "*"
                          ))
                          .features(List.of(
                                  "350+ Unicode CLDR culture definitions",
                                  "Number formatting and parsing per locale",
                                  "Date and time formatting and parsing",
                                  "Currency formatting",
                                  "Plural rule support",
                                  "Relative time formatting",
                                  "Unit formatting",
                                  "Message formatting with ICU syntax",
                                  "Type-safe GlobalizeCultures enum for all locales",
                                  "Required by jQuery UI for Datepicker/Spinner localization",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>globalize</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:globalize:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Automatically loaded as a jQuery UI dependency.
                                          // To reference a culture programmatically:
                                          GlobalizeCultures culture = GlobalizeCultures.en_US;
                                          String tag = culture.toString(); // "en-US\"""")
                          .spiProvides(List.of("IPageConfigurator", "IGuiceScanModuleInclusions"))
                          .build();
    }

    // ── Animation ─────────────────────────────────────

    private static PluginEntry buildEasing()
    {
        return PluginEntry.builder("easing", "Easing Effects", CAT_ANIMATION, "com.jwebmp.plugins", "easing-effects")
                          .description(
                                  "33 easing timing functions from easings.net — smooth, natural CSS/JS animations "
                                  + "with a type-safe Java enum API. Covers Quad, Cubic, Quart, Quint, Expo, Sine, "
                                  + "Circ, Elastic, Back, and Bounce families with In/Out/InOut variants plus Linear and Swing.")
                          .upstreamName("Easing / easings.net")
                          .upstreamVersion("1.4.1")
                          .upstreamUrl("https://easings.net/")
                          .jpmsModule("com.jwebmp.plugins.easingeffects")
                          .readmePath("plugins/easing/README.md")
                          .sourceUrl("https://github.com/JWebMP/Easing")
                          .techBadges(List.of("Java 25+", "Easing 1.4.1", "Angular 21", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "easing", "*"
                          ))
                          .features(List.of(
                                  "33 easing timing functions — complete library from easings.net",
                                  "Type-safe Java enum API — JQEasingEffects with compile-time safety and IDE autocomplete",
                                  "Animation categories — Quad, Cubic, Quart, Quint, Expo, Sine, Circ, Elastic, Back, Bounce",
                                  "In/Out/InOut variants — each timing function includes ease-in, ease-out, and ease-in-out",
                                  "Linear and Swing — classic timing functions for simple animations",
                                  "Angular 21 integration — auto-loaded via PageConfigurator with browser-easing.js",
                                  "Zero configuration — auto-registered via ServiceLoader SPI",
                                  "CRTP fluent API for animation configuration"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>easing-effects</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:easing-effects:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Use easing effect enum
                                          String easing = JQEasingEffects.easeInOutQuad.toString();
                                          
                                          // Apply to element animation
                                          myComponent.setAttribute("data-easing", easing);
                                          
                                          // Available easings include:
                                          // easeInQuad, easeOutQuad, easeInOutQuad
                                          // easeInCubic, easeOutCubic, easeInOutCubic
                                          // easeInElastic, easeOutBounce, and 24 more...""")
                          .spiProvides(List.of("IPageConfigurator"))
                          .build();
    }

    private static PluginEntry buildWavesEffect()
    {
        return PluginEntry.builder("waves", "Waves Effect", CAT_ANIMATION, "com.jwebmp.plugins", "waveseffect")
                          .description(
                                  "Material-design inspired click/tap ripple effect using Waves.js — adds beautiful ripple animations "
                                  + "to buttons and interactive elements with multiple style variants (Light, Circle, Button, Float, Block).")
                          .upstreamName("Waves.js")
                          .upstreamVersion("0.7.6")
                          .upstreamUrl("https://github.com/fians/Waves")
                          .jpmsModule("com.jwebmp.plugins.waveseffect")
                          .readmePath("plugins/waves-effect/README.md")
                          .docsUrl("https://fians.github.io/Waves/")
                          .sourceUrl("https://github.com/JWebMP/JWebMP")
                          .techBadges(List.of("Java 25+", "Waves 0.7.6", "Angular 21", "JPMS Modular"))
                          .prerequisites(COMMON_PREREQS)
                          .npmDependencies(Map.of(
                                  "node-waves", "^0.7.6"
                          ))
                          .features(List.of(
                                  "Material ripple effect — Google Material Design inspired click/tap animations",
                                  "Multiple effect styles — Light, Circle, Button, Float, Block variants",
                                  "CSS selector targeting — apply waves to any DOM elements via selector",
                                  "Auto-initialization — Waves.init() called automatically via feature",
                                  "SCSS styles included — full Waves stylesheet auto-registered",
                                  "Type-safe enum — WavesEffects enum for all effect variants",
                                  "Zero configuration — auto-registered via ServiceLoader SPI"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp.plugins</groupId>
                                            <artifactId>waveseffect</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp.plugins:waveseffect:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // Attach waves to a component
                                          var button = new WaButton<>("Click Me");
                                          button.addFeature(new WavesAttachFeature(button));
                                          
                                          // Apply via CSS selector with effect variant
                                          var feature = new WavesApplyToSelectorFeature(".btn",
                                              WavesEffects.Waves_Light);
                                          page.getBody().addFeature(feature);""")
                          .spiProvides(List.of("IPageConfigurator", "IGuiceScanModuleInclusions"))
                          .build();
    }

    // ── Real-Time Messaging ───────────────────────────

    private static PluginEntry buildRabbitMQ()
    {
        return PluginEntry.builder("rabbitmq", "RabbitMQ Comms", CAT_MESSAGING, "com.jwebmp", "jwebmp-rabbitmq")
                          .description(
                                  "Bidirectional browser-to-server messaging via RabbitMQ — WebSocket/STOMP bridge, group-based pub/sub, "
                                  + "Angular directive integration, session-aware channels, automatic reconnection, and SockJS fallback. "
                                  + "Connects Angular browser clients to RabbitMQ message broker for real-time push notifications and live updates.")
                          .upstreamName("RabbitMQ / STOMP.js / SockJS")
                          .upstreamVersion("3.x")
                          .upstreamUrl("https://www.rabbitmq.com/")
                          .jpmsModule("com.jwebmp.rabbit")
                          .readmePath("rabbitcomms/README.md")
                          .sourceUrl("https://github.com/JWebMP/RabbitMQ")
                          .techBadges(List.of("Java 25+", "RabbitMQ 3.x", "Vert.x 5", "STOMP", "WebSocket", "Angular 21", "JPMS Modular"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+", "Node.js 18+", "Angular 21+", "RabbitMQ Server"))
                          .features(List.of(
                                  "Real-time browser communication — WebSocket-based bidirectional messaging",
                                  "STOMP protocol — industry-standard STOMP over WebSocket with heartbeat support",
                                  "Group-based pub/sub — dynamic subscription management with RabbitMQ fanout exchanges",
                                  "Angular directive integration — [data-rabbit-groups] attribute for automatic group subscription",
                                  "Automatic exchange management — server-side declaration and lifecycle via Vert.x RabbitMQ client",
                                  "Session-aware messaging — automatic subscription to session-specific groups",
                                  "Connection resilience — automatic reconnection with configurable delays and state observables",
                                  "Server-side WebSocket hooks — onAddToGroup, onRemoveFromGroup, onPublish lifecycle events",
                                  "TypeScript client generation — fully typed Angular provider and directive",
                                  "SockJS fallback — graceful degradation for proxies without native WebSocket"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp</groupId>
                                            <artifactId>jwebmp-rabbitmq</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp:jwebmp-rabbitmq:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          // module-info.java
                                          module com.myapp {
                                              requires com.jwebmp.rabbit;
                                              requires com.guicedee.rabbit;
                                          }

                                          // Environment variables:
                                          // RABBITMQ_HOST=localhost
                                          // RABBITMQ_PORT=5672
                                          // RABBITMQ_WEB_STOMP_PORT=15674
                                          
                                          // Enable RabbitMQ Web STOMP plugin:
                                          // rabbitmq-plugins enable rabbitmq_web_stomp""")
                          .spiProvides(List.of("IPageConfigurator", "IGuiceModule", "IGuiceScanModuleInclusions"))
                          .build();
    }

    // ── Runtime & Server ──────────────────────────────

    private static PluginEntry buildVertx()
    {
        return PluginEntry.builder("vertx", "JWebMP Vert.x", CAT_RUNTIME, "com.jwebmp", "jwebmp-vertx")
                          .description(
                                  "Vert.x 5 HTTP connector — automatic page routing, reactive AJAX pipeline, CSS/JS endpoints, "
                                  + "WebSocket broadcasting via event bus, user-agent detection, and call-scope integration. "
                                  + "Registers HTTP routes for page rendering, CSS delivery, AJAX event handling, data components, "
                                  + "and internal scripts — all inside the GuicedEE call-scope model.")
                          .upstreamName("Eclipse Vert.x")
                          .upstreamVersion("5")
                          .upstreamUrl("https://vertx.io/")
                          .jpmsModule("com.jwebmp.vertx")
                          .readmePath("vertx/README.md")
                          .sourceUrl("https://github.com/JWebMP/VertX")
                          .techBadges(List.of("Java 25+", "Vert.x 5", "Guice 7", "Maven 4", "JPMS Modular"))
                          .prerequisites(List.of("Java 25 LTS", "Maven 3.9+"))
                          .features(List.of(
                                  "Automatic page routing — @PageConfiguration classes discovered at startup and served as Vert.x routes",
                                  "Reactive AJAX pipeline — request, deserialize, intercept, fireEvent(), JSON response with 10s timeout",
                                  "Data component servlet — serves IDataComponent.renderData() as JSON",
                                  "CSS endpoint — renders page-level CSS on demand at /jwcss",
                                  "Site-loader script — template-driven JS bootstrap with server address, page class, user-agent placeholders",
                                  "WebSocket broadcasting — IGuicedWebSocket bridged to Vert.x event bus (direct or STOMP prefix)",
                                  "User-agent detection — ReadableUserAgent per call-scope via UADetector",
                                  "Call-scope integration — every handler enters CallScope with RoutingContext, request, response, streamId",
                                  "Jackson configuration — DatabindCodec aligned with GuicedEE JSON conventions"
                          ))
                          .mavenSnippet(
                                  """
                                          <dependency>
                                            <groupId>com.jwebmp</groupId>
                                            <artifactId>jwebmp-vertx</artifactId>
                                          </dependency>""")
                          .gradleSnippet("implementation(\"com.jwebmp:jwebmp-vertx:2.0.0-SNAPSHOT\")")
                          .quickStartCode(
                                  """
                                          @PageConfiguration(url = "/")
                                          public class HomePage extends Page<HomePage> {
                                              public HomePage() {
                                                  getBody().add(
                                                      new H1<>().setText("Hello from JWebMP")
                                                  );
                                              }
                                          }
                                          
                                          // Start the server
                                          IGuiceContext.instance().inject();
                                          // Routes auto-registered:
                                          // GET /      → HomePage
                                          // POST /jwajax → AJAX events
                                          // GET /jwdata  → data components
                                          // GET /jwcss   → page CSS""")
                          .spiProvides(List.of("IGuiceModule", "VertxHttpServerConfigurator"))
                          .build();
    }
}
