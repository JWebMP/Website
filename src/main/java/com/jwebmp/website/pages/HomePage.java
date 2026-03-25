package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;

@NgComponent("jwebmp-home")
@NgRoutable(path = "home", isDefault = true)
public class HomePage extends WebsitePage<HomePage> implements INgComponent<HomePage>
{
    public HomePage()
    {
        // ── Main content — aside is routed via the named "aside" outlet ──
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        layout.add(buildHero());
        layout.add(buildWhyJWebMP());
        layout.add(buildAnnotationDriven());
        layout.add(buildReactiveStack());
        layout.add(buildRealTimeOverview());
        layout.add(buildComponentEcosystem());
        layout.add(buildDeveloperExperience());
        layout.add(buildProductionReady());

        getMain().add(layout);
    }

    // ────────────────────────────────────────────────────────

    private WaStack buildHero()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP lets Java developers build complete, reactive web applications — frontend and backend — "
                + "in a single language. Write annotated Java classes; get a production-ready Angular 20 SPA served "
                + "on a Vert.x 5 reactive server. No context-switching. No hand-written TypeScript. "
                + "Just Java, all the way down.",
                "l"));

        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.add(buildTag("Java 25+", Variant.Brand));
        tags.add(buildTag("Angular 20", Variant.Danger));
        tags.add(buildTag("Vert.x 5", Variant.Warning));
        tags.add(buildTag("JPMS", Variant.Success));
        tags.add(buildTag("Reactive", Variant.Neutral));
        content.add(tags);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Get Started", "/getting-started", Variant.Brand, null));
        ctas.add(buildCta("See the Architecture", "/architecture", Variant.Neutral, Appearance.Outlined));
        ctas.add(buildCta("Browse Plugins", "/plugins", Variant.Neutral, Appearance.Outlined));
        content.add(ctas);

        var section = buildSection("FULL-STACK JAVA WEB FRAMEWORK",
                "Rapid Application Development — One Language, Both Ends",
                "Write Java. Generate Angular. Ship reactive web apps.",
                false, content);
        section.setID("hero");
        return section;
    }

    private WaStack buildWhyJWebMP()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(3);

        grid.add(featureCard("Single Language, Full Stack",
                "Your backend services, your frontend components, your data models, and your routing — all "
                + "written in Java. No JavaScript, no TypeScript, no HTML templates to maintain separately.",
                null));

        grid.add(featureCard("Compile-Time Safety",
                "Every HTML element, every CSS property, every event handler is a Java type. Typos and mismatches "
                + "are caught by the compiler, not discovered in the browser at runtime.",
                null));

        grid.add(featureCard("Rapid Development",
                "Add a dependency, annotate a class, build. New components, pages, and routes materialise "
                + "automatically. The Maven plugin generates the entire Angular project for you.",
                null));

        content.add(grid);

        var section = buildSection("WHY JWEBMP",
                "One Language to Build It All",
                "Java developers should not need to learn a second ecosystem to ship a web application.",
                true, content);
        section.setID("why-jwebmp");
        return section;
    }

    private WaStack buildAnnotationDriven()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP uses annotations to describe your Angular application. @NgComponent creates a component. "
                + "@NgRoutable assigns a route. @NgDataService generates a typed data service. The annotation "
                + "processor produces the .ts files, routing modules, and angular.json — a complete, buildable "
                + "Angular 20 project from your Java source alone.",
                "m"));

        content.add(codeBlockWithTitle("A complete routed page — in Java",
                """
                        @NgComponent("sales-dashboard")
                        @NgRoutable(path = "dashboard")
                        public class SalesDashboard extends DivSimple<SalesDashboard>
                            implements INgComponent<SalesDashboard> {
                        
                            public SalesDashboard() {
                                var grid = new AGGrid<>(SalesRow.class);
                                grid.addColumn("region", "Region");
                                grid.addColumn("revenue", "Revenue");
                                add(grid);
                        
                                var chart = new AGBarChart();
                                chart.getData().addSeries("revenue");
                                add(chart);
                            }
                        }"""));

        content.add(captionText("This generates an Angular component, a route at /dashboard, "
                + "and wires AG Grid + AG Charts — all from a single Java class."));

        var section = buildSection("ANNOTATION-DRIVEN",
                "Java Annotations Become Angular Applications",
                "@NgComponent + @NgRoutable + build = production SPA.",
                false, content);
        section.setID("annotation-driven");
        return section;
    }

    private WaStack buildReactiveStack()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(2);

        grid.add(featureCard("Vert.x 5 Server",
                "Non-blocking, event-loop HTTP server. Pages, AJAX events, CSS, and scripts are served "
                + "reactively. WebSocket broadcasting rides the Vert.x event bus.",
                null));

        grid.add(featureCard("GuicedEE Runtime",
                "Google Guice dependency injection, SPI-driven service discovery, call-scoped request handling, "
                + "and JPMS module isolation — the same foundation as GuicedEE.",
                null));

        grid.add(featureCard("AJAX Event Pipeline",
                "Browser events fire Java handlers on the server. AjaxCall carries the payload; AjaxResponse "
                + "returns DOM updates. 50+ event adapters — click, change, submit, drag, keyboard, and more.",
                null));

        grid.add(featureCard("Dual Rendering",
                "Every component renders as HTML (toString(true)) for server-side pages or JSON (toString()) "
                + "for AJAX responses — same component tree, two output formats.",
                null));

        content.add(grid);

        var section = buildSection("REACTIVE STACK",
                "Built on Vert.x 5 and GuicedEE",
                "Non-blocking I/O, dependency injection, and SPI discovery — reactive from the ground up.",
                true, content);
        section.setID("reactive-stack");
        return section;
    }

    private WaStack buildRealTimeOverview()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP supports REST endpoints (Jakarta RS), 50+ server-driven AJAX events, and typed "
                + "@NgDataService classes out of the box — no WebSocket infrastructure required. When you "
                + "need push updates, the built-in Vert.x STOMP event bus is already there (AG Grid "
                + "and Chart.js use it for live data). For production scale, add RabbitMQ Comms for "
                + "broker-backed durability. Start with request/response. Layer in real-time when you need it.",
                "m"));

        content.add(codeBlockWithTitle("REST endpoint — always available",
                "@Path(\"/api/sales\") @GET\n"
                + "public List<SalesRow> getSales() { return service.findAll(); }"));

        content.add(codeBlockWithTitle("Push updates — opt-in when ready",
                "StompEventBusPublisher.publish(vertx, \"dashboard\", jsonPayload);\n"
                + "// or: publisher.publish(\"user-\" + userId, payload); // RabbitMQ"));

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Communication Patterns", "/real-time", Variant.Brand, null));
        content.add(ctas);

        var section = buildSection("CLIENT-SERVER COMMUNICATION",
                "REST, AJAX, Data Services, and Real-Time",
                "Request/response first. Push updates when you need them.",
                false, content);
        section.setID("real-time-overview");
        return section;
    }

    private WaStack buildComponentEcosystem()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Every plugin is a JPMS module. Add the Maven dependency, and the component is available as a "
                + "type-safe Java class. The annotation processor generates the Angular integration automatically. "
                + "No npm install, no Angular module registration — just Java.",
                "m"));

        var grid = grid(3);

        grid.add(featureCard("AG Grid & AG Charts",
                "Enterprise data grids and 38+ chart types — configured in Java, rendered in Angular.",
                "com.jwebmp.plugins:aggrid / agcharts"));

        grid.add(featureCard("WebAwesome",
                "Modern, accessible UI component library with dark mode, responsive layout, and 18+ WaPage sub-components.",
                "com.jwebmp.plugins:web-awesome"));

        grid.add(featureCard("FullCalendar",
                "Drag-and-drop scheduling, resource timelines, and multiple calendar views.",
                "com.jwebmp.plugins:fullcalendar"));

        grid.add(featureCard("RabbitMQ Comms",
                "Bidirectional messaging — WebSocket/STOMP bridge with Angular directives and session-aware channels.",
                "com.jwebmp:jwebmp-rabbitmq"));

        grid.add(featureCard("Font Awesome",
                "6,000+ icons (Free) or 10,000+ (Pro) rendered as SVG with type-safe Java enums.",
                "com.jwebmp.plugins:fontawesome"));

        grid.add(featureCard("Chart.js",
                "Lightweight charts — bar, line, pie, doughnut, radar — for dashboards and reports.",
                "com.jwebmp.plugins:chartjs"));

        content.add(grid);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Full Plugin Catalog", "/plugins", Variant.Brand, null));
        content.add(ctas);

        var section = buildSection("20+ PLUGINS",
                "Production-Ready Component Library",
                "Grids, charts, calendars, icons, messaging — all type-safe, all Java, all JPMS.",
                true, content);
        section.setID("component-ecosystem");
        return section;
    }

    private WaStack buildDeveloperExperience()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(2);

        grid.add(featureCard("CRTP Fluent API",
                "Every component uses Curiously Recurring Template Pattern generics for fluent, "
                + "chainable builders: card.setAppearance(Outlined).add(heading).add(body).",
                null));

        grid.add(featureCard("SPI Extensibility",
                "IPageConfigurator, IEventConfigurator, render-ordering hooks — extend the framework "
                + "by implementing an interface and registering via ServiceLoader or module-info.java.",
                null));

        grid.add(featureCard("Maven Build Integration",
                "The Angular Maven Plugin discovers @NgApp classes, generates TypeScript, installs npm "
                + "dependencies, and runs the Angular CLI build — all inside mvn install.",
                null));

        grid.add(featureCard("IDE-Friendly",
                "Every component is a concrete Java class. Full autocomplete, refactoring, "
                + "find-usages, and go-to-definition in IntelliJ, Eclipse, or VS Code.",
                null));

        content.add(grid);

        var section = buildSection("DEVELOPER EXPERIENCE",
                "Built for Java Engineers",
                "Fluent APIs, compile-time checks, Maven integration, and full IDE support.",
                false, content);
        section.setID("developer-experience");
        return section;
    }

    private WaStack buildProductionReady()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(3);

        grid.add(featureCard("JPMS Modular",
                "Every module has an explicit module-info.java with declared exports, requires, and provides. "
                + "JLink-ready for minimal container images.",
                null));

        grid.add(featureCard("Reactive Non-Blocking",
                "Vert.x 5 event-loop server. No thread-per-request overhead. "
                + "Scales to thousands of concurrent connections.",
                null));

        grid.add(featureCard("Apache 2.0 Open Source",
                "Permissive licensing. Fork it, extend it, ship it. "
                + "Active development with snapshot builds on Maven Central.",
                null));

        content.add(grid);

        var prodSection = buildSection("PRODUCTION READY",
                "Ship with Confidence",
                "Modular, reactive, and open source — ready for production workloads.",
                true, content);
        prodSection.setID("production-ready");

        // Call to Action appended into the same stack
        var ctaContent = new WaStack();
        ctaContent.setGap(PageSize.Medium);

        ctaContent.add(bodyText(
                "Stop context-switching between Java and TypeScript. Build your entire web application "
                + "in the language you already know. JWebMP handles the rest.",
                "l"));

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Get Started", "/getting-started", Variant.Brand, null));
        ctas.add(buildCta("View on GitHub", "/github", Variant.Neutral, Appearance.Outlined));
        ctaContent.add(ctas);

        prodSection.add(buildSection(null,
                "Ready to Build?",
                "From zero to production Angular app — entirely in Java.",
                false, ctaContent));

        return prodSection;
    }
}
