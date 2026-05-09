package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;

@NgComponent("jwebmp-architecture")
@NgRoutable(path = "architecture")
public class ArchitecturePage extends WebsitePage<ArchitecturePage> implements INgComponent<ArchitecturePage>
{
    public ArchitecturePage()
    {
        var layout = new WaStack<>();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // ── Overview ──
        layout.add(buildOverview());

        // ── Stack Diagram ──
        layout.add(buildStackDiagram());

        // ── Build Pipeline ──
        layout.add(buildBuildPipeline());

        // ── Runtime ──
        layout.add(buildRuntime());

        // ── Data Flow ──
        layout.add(buildDataFlow());

        // ── Module Graph ──
        layout.add(buildModuleGraph());

        // ── CTA ──
        layout.add(buildCallToAction());
    }

    private WaStack buildOverview()
    {
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);
        content.add(bodyText(
                "JWebMP is a layered architecture where each layer has a single responsibility. "
                + "The foundation is GuicedEE (dependency injection, SPI discovery, Vert.x lifecycle). "
                + "JWebMP Core adds the HTML/CSS/JS component model. Plugins extend it with specific "
                + "component libraries. The Angular layer generates the frontend. At runtime, Vert.x "
                + "serves everything reactively.",
                "m"));

        content.add(mermaidDiagram(
                """
                        graph LR
                          APP["🚀 Your App<br/><i>@NgComponent, @NgRoutable</i>"]
                          PLUGINS["🧩 Plugins<br/><i>WebAwesome, AG Grid, Charts</i>"]
                          CORE["⚙️ JWebMP Core<br/><i>HTML/CSS/JS, Angular Gen</i>"]
                          FOUNDATION["🏗️ GuicedEE<br/><i>Guice DI, SPI, Vert.x 5</i>"]

                          APP ==> PLUGINS ==> CORE ==> FOUNDATION

                          style APP fill:#312e81,stroke:#818cf8,stroke-width:2px,color:#e2e8f0
                          style PLUGINS fill:#1e3a5f,stroke:#60a5fa,stroke-width:2px,color:#e2e8f0
                          style CORE fill:#1a3330,stroke:#34d399,stroke-width:2px,color:#e2e8f0
                          style FOUNDATION fill:#3b1a1a,stroke:#f87171,stroke-width:2px,color:#e2e8f0
                        """));

        var section = buildSection("ARCHITECTURE",
                "How JWebMP Works",
                "A layered, modular architecture — each layer does one thing well.",
                false, content);
        section.setID("architecture");
        return section;
    }

    private WaStack buildStackDiagram()
    {
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "The JWebMP stack is four layers deep. Your application sits at the top; everything "
                + "below is framework infrastructure.",
                "m"));

        content.add(mermaidDiagramWithTitle("The JWebMP Stack",
                """
                        graph LR
                          subgraph APP["YOUR APPLICATION"]
                            a1["@NgComponent<br/>@NgRoutable<br/>@NgDataService"]
                          end
                          subgraph PLUGINS["PLUGINS"]
                            p1["WebAwesome · AG Grid<br/>Charts · RabbitMQ<br/>Font Awesome · Calendar"]
                          end
                          subgraph CORE["JWEBMP CORE"]
                            c1["HTML Elements · CSS Builder<br/>Events · AJAX Pipeline<br/>Angular Generator · TS Compiler"]
                          end
                          subgraph FOUNDATION["GUICEDEE"]
                            f1["Guice DI · SPI Discovery<br/>JPMS · Vert.x 5 HTTP<br/>Event Bus · Call Scopes"]
                          end
                          APP ==> PLUGINS ==> CORE ==> FOUNDATION

                          style APP fill:#312e81,stroke:#818cf8,stroke-width:2px,color:#e2e8f0
                          style PLUGINS fill:#1e3a5f,stroke:#60a5fa,stroke-width:2px,color:#e2e8f0
                          style CORE fill:#1a3330,stroke:#34d399,stroke-width:2px,color:#e2e8f0
                          style FOUNDATION fill:#3b1a1a,stroke:#f87171,stroke-width:2px,color:#e2e8f0
                        """));

        var section = buildSection("STACK",
                "Four-Layer Architecture",
                "Your app → Plugins → JWebMP Core → GuicedEE Foundation.",
                true, content);
        section.setID("stack");
        return section;
    }

    private WaStack buildBuildPipeline()
    {
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);

        content.add(richText(
                "At build time, the Angular Maven Plugin scans your classpath for `@NgApp`-annotated classes. "
                + "It invokes the TypeScript Compiler which walks every `@NgComponent`, `@NgDirective`, "
                + "`@NgDataService`, and `@NgRoutable` class. For each, it generates a `.ts` file, registers "
                + "it in the Angular module, and adds its route to the router config. The result is a complete "
                + "Angular 21 project that the Angular CLI builds into a production `dist/` directory.",
                "m"));

        content.add(mermaidDiagramWithTitle("Build Flow",
                """
                        graph LR
                          MVN["mvn install"] --> COMPILE["javac"]
                          COMPILE --> PLUGIN["Angular Maven Plugin"]

                          subgraph CODEGEN["Code Generation"]
                            direction TB
                            DISCOVER["Discover @NgApp"]
                            TSCOMPILE["Generate .ts files"]
                            MODPROC["Build module tree"]
                            COMPPROC["Emit components"]
                            DISCOVER --> TSCOMPILE --> MODPROC --> COMPPROC
                          end

                          subgraph SCAFFOLD["Project Scaffold"]
                            direction TB
                            DEPMGR["Write package.json"]
                            APPSETUP["Write angular.json"]
                          end

                          PLUGIN --> CODEGEN
                          PLUGIN --> SCAFFOLD
                          CODEGEN --> NGBUILD["ng build --prod"]
                          SCAFFOLD --> NGBUILD
                          NGBUILD --> PACKAGE["dist/ → JAR"]

                          style CODEGEN fill:#1e3a5f,stroke:#60a5fa,stroke-width:2px,color:#e2e8f0
                          style SCAFFOLD fill:#1a3330,stroke:#34d399,stroke-width:2px,color:#e2e8f0
                          style PACKAGE fill:#312e81,stroke:#818cf8,stroke-width:2px,color:#e2e8f0
                        """));

        var section = buildSection("BUILD",
                "Build-Time Code Generation",
                "Java compiles → TypeScript generates → Angular builds → JAR packages.",
                false, content);
        section.setID("build-pipeline");
        return section;
    }

    private WaStack buildRuntime()
    {
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);
        var grid = grid(2);

        grid.add(featureCard("Boot → Inject → Serve",
                "Boot.main() sets system properties and calls IGuiceContext.inject(). "
                + "Guice scans modules, discovers SPI implementations, binds services, "
                + "and starts the Vert.x HTTP server — all from a single line.", null));
        grid.add(featureCard("Vert.x Routes",
                "JWebMPVertx registers routes automatically: GET / for pages, POST /jwajax "
                + "for AJAX events, GET /jwdata for data components, GET /jwcss for CSS, "
                + "and /eventbus for STOMP WebSocket.", null));
        grid.add(featureCard("Call Scopes",
                "Every HTTP request enters a Guice CallScope. RoutingContext, request, response, "
                + "and session data are available via injection anywhere in the call chain.", null));
        grid.add(featureCard("SPA Fallback",
                "Static assets are served from the Angular dist/ directory. Unmatched routes "
                + "fall back to index.html for Angular Router client-side navigation.", null));

        content.add(grid);
        var section = buildSection("RUNTIME",
                "Reactive Server Architecture",
                "Vert.x event loop, Guice DI, call scopes, and SPA hosting.",
                true, content);
        section.setID("runtime");
        return section;
    }

    private WaStack buildDataFlow()
    {
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP supports three communication patterns: HTTP for page delivery, "
                + "AJAX for event-driven DOM updates, and WebSocket (STOMP) for real-time "
                + "push messaging via Vert.x Event Bus and RabbitMQ.",
                "m"));

        content.add(mermaidDiagramWithTitle("Request-Response Flow",
                """
                        sequenceDiagram
                          participant B as 🌐 Browser
                          participant V as ⚡ Vert.x Server
                          participant H as ☕ Java Handler

                          rect rgba(99, 102, 241, 0.1)
                          Note over B,V: Page Delivery
                          B->>V: GET /dashboard
                          V-->>B: index.html + dist/ assets
                          end

                          rect rgba(52, 211, 153, 0.1)
                          Note over B,H: AJAX Event Cycle
                          B->>V: POST /jwajax
                          V->>H: deserialize AjaxCall
                          H->>H: intercept → fireEvent()
                          H-->>V: AjaxResponse
                          V-->>B: DOM update instructions
                          end

                          rect rgba(248, 113, 113, 0.1)
                          Note over B,H: Real-Time Push
                          B->>V: WS /eventbus STOMP
                          V->>H: RabbitMQ exchange
                          V-->>B: STOMP message push
                          end
                        """));

        var section = buildSection("DATA FLOW",
                "Request, Event, and Message Paths",
                "HTTP for pages, AJAX for events, WebSocket for real-time.",
                false, content);
        section.setID("data-flow");
        return section;
    }

    private WaStack buildModuleGraph()
    {
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);

        content.add(richText(
                "Every JWebMP module declares its dependencies explicitly in `module-info.java`. "
                + "The JPMS module graph ensures clean boundaries — no classpath hell, no hidden "
                + "dependencies, no runtime surprises.",
                "m"));

        content.add(mermaidDiagramWithTitle("Core Module Dependencies",
                """
                        graph LR
                          CORE["com.jwebmp.core"]

                          subgraph JWEBMP["JWebMP Layer"]
                            CLIENT["com.jwebmp.client"]
                          end

                          subgraph GUICEDEE["GuicedEE Layer"]
                            GUICEE["com.guicedee.client"]
                            VERTX["com.guicedee.vertx"]
                          end

                          subgraph RUNTIME["Runtime"]
                            VXC["io.vertx.core"]
                            VXW["io.vertx.web"]
                            GUICE["com.google.guice"]
                            JACKSON["com.fasterxml.jackson"]
                          end

                          subgraph SPECS["Jakarta Specs"]
                            JAKARTA["jakarta.validation"]
                            COMMONS["org.apache.commons"]
                          end

                          CORE ==> CLIENT
                          CORE ==> GUICEE
                          CORE ==> VERTX
                          GUICEE --> GUICE
                          VERTX --> VXC
                          VERTX --> VXW
                          CORE -.-> JACKSON
                          CORE -.-> JAKARTA
                          CORE -.-> COMMONS

                          style JWEBMP fill:#312e81,stroke:#818cf8,stroke-width:2px,color:#e2e8f0
                          style GUICEDEE fill:#1e3a5f,stroke:#60a5fa,stroke-width:2px,color:#e2e8f0
                          style RUNTIME fill:#1a3330,stroke:#34d399,stroke-width:2px,color:#e2e8f0
                          style SPECS fill:#3b1a1a,stroke:#f87171,stroke-width:2px,color:#e2e8f0
                        """));

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Browse All Plugins", "/plugins", Variant.Brand, null));
        ctas.add(buildCta("View Capabilities", "/capabilities", Variant.Neutral, Appearance.Outlined));
        content.add(ctas);

        var section = buildSection("MODULES",
                "JPMS Module Graph",
                "Explicit requires, explicit exports — no surprises.",
                true, content);
        section.setID("module-graph");
        return section;
    }
}
