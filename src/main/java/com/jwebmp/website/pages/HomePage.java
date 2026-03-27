package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.details.WaDetails;
import com.jwebmp.webawesome.components.tree.WaTree;
import com.jwebmp.webawesome.components.tree.WaTreeItem;
import com.jwebmp.webawesome.components.tree.TreeSelectionMode;

@NgComponent("jwebmp-home")
@NgRoutable(path = "home", isDefault = true)
@NgField("activeFile = 'tab-ts';")
@NgMethod("""
        onFileTreeSelect($event: any) {
            const selection = $event?.detail?.selection;
            if (selection && selection.length > 0) {
                const panel = selection[0].getAttribute('data-panel');
                if (panel) { this.activeFile = panel; }
            }
        }""")
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
                "JWebMP lets Java developers build web applications in a single language — with two running modes. "
                + "Add the Angular plugin and the build generates a complete Angular 20 SPA from your annotated Java classes "
                + "— no hand-written TypeScript required. Or run without it for traditional server-side rendering on "
                + "Vert.x 5 with GuicedEE. Either way, your component code stays the same: just Java, all the way down.",
                "l"));

        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.add(buildTag("Java 25+", Variant.Brand));
        tags.add(buildTag("Angular 20", Variant.Danger));
        tags.add(buildTag("SSR", Variant.Warning));
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
                "Rapid Application Development — One Language, Two Modes",
                "Write Java. Generate Angular or render server-side. Ship web apps.",
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
                + "written in Java. In Angular mode the TypeScript is generated for you; in SSR mode there is "
                + "no frontend build at all. Either way, you never hand-write JavaScript or HTML templates.",
                null));

        grid.add(featureCard("Compile-Time Safety",
                "Every HTML element, every CSS property, every event handler is a Java type. Typos and mismatches "
                + "are caught by the compiler, not discovered in the browser at runtime.",
                null));

        grid.add(featureCard("Rapid Development",
                "Add a dependency, annotate a class, build. New components, pages, and routes materialise "
                + "automatically. With the Angular plugin the Maven build generates the entire SPA; "
                + "without it, the same components render server-side on Vert.x — zero configuration either way.",
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

        content.add(richText(
                "With the **Angular plugin** included, JWebMP uses annotations to generate a complete Angular application. "
                + "`@NgComponent` creates a component. `@NgRoutable` assigns a route. `@NgDataService` generates a typed "
                + "data service. The annotation processor produces `.ts` files, routing modules, and `angular.json` "
                + "— a buildable Angular 20 project from your Java source alone. Node.js is required at build time "
                + "for the Angular CLI; the resulting SPA is static and can be served from any host — "
                + "the JWebMP server is entirely optional.",
                "m"));

        // ── Java source inside a closed WaDetails ──
        var javaDetails = new WaDetails<>("Java Source — SalesDashboard.java");
        javaDetails.add(codeBlock(buildSalesDashboardJava()));
        content.add(javaDetails);

        // ── Generated Angular file explorer inside a closed WaDetails ──
        var angularDetails = new WaDetails<>("Generated Angular Project");

        var explorer = new DivSimple<>();
        explorer.addClass("file-explorer");

        // File tree
        var fileTree = new WaTree<>();
        fileTree.setSelection(TreeSelectionMode.Single);
        fileTree.setIndentSize("var(--wa-spacing-small)");
        fileTree.addAttribute("(wa-selection-change)",
                "onFileTreeSelect($event)");

        var srcFolder = treeFolder("src/app/sales-dashboard/", true);

        var firstFile = treeFile("SalesDashboard.ts", "tab-ts");
        firstFile.setSelected(true);
        srcFolder.add(firstFile);
        srcFolder.add(treeFile("SalesDashboard.html", "tab-html"));
        srcFolder.add(treeFile("SampleSalesGrid.ts", "tab-grid"));
        srcFolder.add(treeFile("SampleSalesGrid.html", "tab-grid-html"));
        srcFolder.add(treeFile("SampleRevenueChart.ts", "tab-chart"));
        srcFolder.add(treeFile("SampleRevenueChart.html", "tab-chart-html"));
        fileTree.add(srcFolder);

        var routeFolder = treeFolder("src/app/", false);
        routeFolder.add(treeFile("app.routes.ts", "tab-routes"));
        fileTree.add(routeFolder);

        explorer.add(fileTree);

        // Code canvas — panels shown/hidden by activeFile field
        var codeCanvas = new DivSimple<>();
        codeCanvas.addClass("code-canvas");

        var tsDiv = codeBlock(buildSalesDashboardTs(), PrismLanguage.TypeScript);
        tsDiv.addAttribute("[hidden]", "activeFile !== 'tab-ts'");
        codeCanvas.add(tsDiv);

        var htmlDiv = codeBlock(buildSalesDashboardHtml(), PrismLanguage.Html);
        htmlDiv.addAttribute("[hidden]", "activeFile !== 'tab-html'");
        codeCanvas.add(htmlDiv);

        var gridDiv = codeBlock(buildSampleSalesGridTs(), PrismLanguage.TypeScript);
        gridDiv.addAttribute("[hidden]", "activeFile !== 'tab-grid'");
        codeCanvas.add(gridDiv);

        var gridHtmlDiv = codeBlock(buildSampleSalesGridHtml(), PrismLanguage.Html);
        gridHtmlDiv.addAttribute("[hidden]", "activeFile !== 'tab-grid-html'");
        codeCanvas.add(gridHtmlDiv);

        var chartDiv = codeBlock(buildSampleRevenueChartTs(), PrismLanguage.TypeScript);
        chartDiv.addAttribute("[hidden]", "activeFile !== 'tab-chart'");
        codeCanvas.add(chartDiv);

        var chartHtmlDiv = codeBlock(buildSampleRevenueChartHtml(), PrismLanguage.Html);
        chartHtmlDiv.addAttribute("[hidden]", "activeFile !== 'tab-chart-html'");
        codeCanvas.add(chartHtmlDiv);

        var routesDiv = codeBlock(buildAppRoutesTs(), PrismLanguage.TypeScript);
        routesDiv.addAttribute("[hidden]", "activeFile !== 'tab-routes'");
        codeCanvas.add(routesDiv);

        explorer.add(codeCanvas);

        angularDetails.add(explorer);
        content.add(angularDetails);

        content.add(captionText("Expand the panels above to see the Java source and the generated Angular project. "
                + "One language, full production SPA."));

        // ── LoC / complexity comparison stats ──
        var statsDetails = new WaDetails<>("By the Numbers — Java vs Generated TypeScript");

        var statsGrid = grid(3);

        statsGrid.add(featureCard("Lines of Code",
                "3 Java files — ~80 LoC. The build generates 9 Angular files "
                + "totalling ~330 LoC of TypeScript, HTML, and SCSS. "
                + "That is a 4× amplification ratio you never have to write or maintain.",
                "80 LoC → 330 LoC (4× amplification)"));

        statsGrid.add(featureCard("Estimated AI Tokens",
                "An LLM needs ~350 tokens to produce the Java source. "
                + "Generating the equivalent TypeScript, templates, subscriptions, and "
                + "lifecycle wiring directly would consume ~2,800 tokens — an 8× cost multiplier.",
                "~350 tokens → ~2,800 tokens (8× cost)"));

        statsGrid.add(featureCard("Complexity",
                "The Java side is declarative: annotations, column definitions, and a data list. "
                + "The generated TypeScript includes EventBus subscriptions, signal/computed reactivity, "
                + "lifecycle hooks, resize handlers, and UUID-based listener management — all auto-wired.",
                "Declarative → Imperative (auto-generated)"));

        statsDetails.add(statsGrid);
        content.add(statsDetails);

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
                "In SSR mode, a non-blocking Vert.x 5 event-loop server renders pages, handles AJAX events, "
                + "and serves static resources reactively. Angular-mode SPAs can optionally connect to the same "
                + "server for event-bus or RabbitMQ push updates.",
                null));

        grid.add(featureCard("GuicedEE Runtime",
                "Google Guice dependency injection, SPI-driven service discovery, call-scoped request handling, "
                + "and JPMS module isolation. Included automatically in SSR mode; available as an optional backend "
                + "for Angular SPAs that need server-side services.",
                null));

        grid.add(featureCard("AJAX Event Pipeline",
                "In SSR mode, browser events fire Java handlers on the server. AjaxCall carries the payload; "
                + "AjaxResponse returns DOM updates. 50+ event adapters — click, change, submit, drag, keyboard, "
                + "and more — all without writing any JavaScript.",
                null));

        grid.add(featureCard("Dual Rendering",
                "Every component renders as HTML (toString(true)) for server-side pages or JSON (toString()) "
                + "for AJAX responses — same component tree, two output formats. Angular mode adds a third: "
                + "generated TypeScript components.",
                null));

        content.add(grid);

        var section = buildSection("REACTIVE STACK",
                "Built on Vert.x 5 and GuicedEE",
                "The SSR foundation — non-blocking I/O, dependency injection, and SPI discovery. "
                + "Optional backend for Angular SPAs.",
                true, content);
        section.setID("reactive-stack");
        return section;
    }

    private WaStack buildRealTimeOverview()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(richText(
                "Communication depends on your running mode. **SSR mode** includes 50+ server-driven AJAX events, "
                + "REST endpoints (Jakarta RS), and Vert.x WebSocket broadcasting out of the box. "
                + "**Angular mode** generates typed `@NgDataService` classes and connects to the Vert.x STOMP "
                + "event bus for live data (AG Grid and Charts use this for push updates). For production scale, "
                + "either mode can add RabbitMQ Comms for broker-backed durability. "
                + "Start with request/response. Layer in real-time when you need it.",
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
                + "type-safe Java class. Some plugins work in both modes; others — like AG Grid and AG Charts "
                + "— require the Angular plugin. In Angular mode the build handles npm and Angular CLI "
                + "automatically; in SSR mode there is no frontend toolchain at all.",
                "m"));

        var grid = grid(3);

        grid.add(featureCard("AG Grid & AG Charts",
                "Enterprise data grids and 38+ chart types — configured in Java, rendered in Angular. "
                + "Requires the Angular plugin.",
                "com.jwebmp.plugins:aggrid / agcharts"));

        grid.add(featureCard("WebAwesome",
                "Modern, accessible UI component library with dark mode, responsive layout, and 18+ WaPage sub-components.",
                "com.jwebmp.plugins:web-awesome"));

        grid.add(featureCard("FullCalendar",
                "Drag-and-drop scheduling, resource timelines, and multiple calendar views. "
                + "Requires the Angular plugin.",
                "com.jwebmp.plugins:fullcalendar"));

        grid.add(featureCard("RabbitMQ Comms",
                "Bidirectional messaging with broker-backed durability. In Angular mode, STOMP/WebSocket "
                + "bridge with Angular directives. In SSR mode, server-side Vert.x event-bus integration.",
                "com.jwebmp:jwebmp-rabbitmq"));

        grid.add(featureCard("Font Awesome",
                "6,000+ icons (Free) or 10,000+ (Pro) rendered as SVG with type-safe Java enums.",
                "com.jwebmp.plugins:fontawesome"));

        grid.add(featureCard("Chart.js",
                "Lightweight charts — bar, line, pie, doughnut, radar — for dashboards and reports. "
                + "Requires the Angular plugin.",
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
                "In Angular mode the Maven plugin discovers @NgApp classes, generates TypeScript, installs npm "
                + "dependencies, and runs the Angular CLI build — all inside mvn install. "
                + "In SSR mode there is no frontend build step at all.",
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
                "SSR mode runs on the Vert.x 5 event-loop server — no thread-per-request overhead. "
                + "Angular SPAs are static files that can be served from any host or CDN.",
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

    /**
     * Returns the actual generated HTML for the SalesDashboard component.
     */
    private String buildSalesDashboardHtml()
    {
        return """
                <div>
                \t<sample-sales-grid></sample-sales-grid>
                \t<sample-revenue-chart></sample-revenue-chart>
                </div>""";
    }

    /**
     * Returns the actual generated HTML for the SampleSalesGrid component.
     */
    private String buildSampleSalesGridHtml()
    {
        return """
                <ag-grid-angular #salesGrid
                  (firstDataRendered)="onFirstDataRendered()"
                  (gridReady)="onGridReady($event)"
                  (gridSizeChanged)="onGridSizeChanged()"
                  [columnDefs]="columnDefs"
                  [context]="{ componentParent: this }"
                  [defaultColDef]="defaultColDef"
                  [getRowId]="getRowId"
                  [gridOptions]="options"
                  id="salesGrid"
                  style="width: 100%; height: 500px;">
                </ag-grid-angular>""";
    }

    /**
     * Returns the actual generated HTML for the SampleRevenueChart component.
     */
    private String buildSampleRevenueChartHtml()
    {
        return """
                @if (chartReady() && chartOptions()) {
                \t<ag-charts [options]="chartOptions()"
                \t           id="revenueChart">
                \t</ag-charts>
                }""";
    }

    /**
     * Returns the actual generated TypeScript for the SalesDashboard component.
     */
    private String buildSalesDashboardTs()
    {
        return """
                import {Component} from '@angular/core';
                import {SampleSalesGrid} from
                  '../SampleSalesGrid/SampleSalesGrid';
                import {SampleRevenueChart} from
                  '../SampleRevenueChart/SampleRevenueChart';
                import {inject} from '@angular/core';
                
                @Component({
                  selector: 'sales-dashboard',
                  templateUrl: './SalesDashboard.html',
                  styleUrls: ['./SalesDashboard.scss'],
                  imports: [
                    SampleSalesGrid,
                    SampleRevenueChart,
                  ],
                  standalone: true
                })
                export class SalesDashboard {
                  readonly sampleSalesGrid =
                    inject(SampleSalesGrid);
                  readonly sampleRevenueChart =
                    inject(SampleRevenueChart);
                }""";
    }

    /**
     * Builds the Java source code shown in the comparison.
     * Shows the SalesDashboard (the routing component) and the SampleSalesGrid
     * (the grid definition with columns and data) together, matching the real source.
     */
    private String buildSalesDashboardJava()
    {
        return """
                @NgComponent("sales-dashboard")
                @NgRoutable(path = "dashboard")
                public class SalesDashboard
                    extends DivSimple<SalesDashboard>
                    implements INgComponent<SalesDashboard> {
                
                  public SalesDashboard() {
                    add(new SampleSalesGrid());
                    add(new SampleRevenueChart());
                  }
                }
                
                // ── Grid definition ──
                @NgComponent("sample-sales-grid")
                public class SampleSalesGrid
                    extends AgGrid<SampleSalesGrid> {
                
                  public SampleSalesGrid() {
                    setID("salesGrid");
                    addColumnDef(new AgGridColumnDef<>()
                      .setField("region")
                      .setHeaderName("Region")
                      .setFilter(true).setSortable(true));
                    addColumnDef(new AgGridColumnDef<>()
                      .setField("product")
                      .setHeaderName("Product")
                      .setFilter(true).setSortable(true));
                    addColumnDef(new AgGridColumnDef<>()
                      .setField("units")
                      .setHeaderName("Units Sold")
                      .setSortable(true));
                    addColumnDef(new AgGridColumnDef<>()
                      .setField("revenue")
                      .setHeaderName("Revenue")
                      .setSortable(true));
                    addColumnDef(new AgGridColumnDef<>()
                      .setField("profit")
                      .setHeaderName("Profit")
                      .setSortable(true));
                  }
                
                  @Override
                  public Collection fetchData() {
                    return List.of();
                  }
                }""";
    }

    /**
     * Returns the actual generated TypeScript for the SampleSalesGrid component,
     * trimmed for readability.
     */
    private String buildSampleSalesGridTs()
    {
        return """
                import {OnDestroy, AfterViewInit, ViewChild,
                  HostListener, Component} from '@angular/core';
                import {AgGridAngular} from 'ag-grid-angular';
                import {ColDef, ColGroupDef, GridApi, GridOptions,
                  GetRowIdFunc, GetRowIdParams,
                  RowSelectedEvent} from 'ag-grid-community';
                import {Subscription} from 'rxjs';
                import {v4 as uuidv4} from 'uuid';
                import {EventBusService} from
                  '…/services/EventBusService/EventBusService';
                import {inject} from '@angular/core';
                
                @Component({
                  selector: 'sample-sales-grid',
                  templateUrl: './SampleSalesGrid.html',
                  styleUrls: ['./SampleSalesGrid.scss'],
                  imports: [AgGridAngular],
                  standalone: true
                })
                export class SampleSalesGrid
                    implements OnDestroy, AfterViewInit {
                  readonly eventBusService =
                    inject(EventBusService);
                  readonly subscription?: Subscription;
                  readonly handlerId: string;
                  readonly datasetHandlerId: string;
                  gridApi?: GridApi;
                  columnDefs: (ColDef | ColGroupDef)[] = [
                    {field:'region',  headerName:'Region',
                     sortable:true, filter:true},
                    {field:'product', headerName:'Product',
                     sortable:true, filter:true},
                    {field:'units',   headerName:'Units Sold',
                     sortable:true},
                    {field:'revenue', headerName:'Revenue',
                     sortable:true},
                    {field:'profit',  headerName:'Profit',
                     sortable:true}
                  ];
                  getRowId: GetRowIdFunc =
                    (p: GetRowIdParams) =>
                      String(p.data.region);
                  defaultColDef: ColDef = {
                    sortable: true, filter: true,
                    resizable: true
                  };
                  @ViewChild('salesGrid')
                  salesGrid?: AgGridAngular;
                  options: GridOptions = {};
                  readonly listenerName = 'salesGrid';
                
                  constructor() {
                    this.datasetHandlerId =
                      this.generateHandlerId();
                    this.handlerId =
                      this.generateHandlerId();
                    this.subscription = this.eventBusService
                      .listen(this.listenerName, this.handlerId)
                      .subscribe({
                        next: (message: any) => {
                          // … parse rows and update grid …
                        },
                        error: (e) => console.log(e),
                      });
                  }
                  ngAfterViewInit() {
                    this.eventBusService.send(
                      this.listenerName,
                      { className: this.clazzName,
                        listenerName: this.listenerName },
                      this.listenerName);
                  }
                  onGridReady(params: any): void {
                    this.gridApi = params.api;
                    this.onSizeColumnsToFit();
                  }
                  onSizeColumnsToFit(): void {
                    if (this.gridApi) {
                      setTimeout(() =>
                        this.gridApi?.sizeColumnsToFit(), 0);
                    }
                  }
                  @HostListener('window:resize')
                  onWindowResize(): void {
                    this.onSizeColumnsToFit();
                  }
                  ngOnDestroy() {
                    this.eventBusService.unregisterListener(
                      this.listenerName, this.handlerId);
                  }
                }""";
    }

    /**
     * Returns the actual generated TypeScript for the SampleRevenueChart component,
     * trimmed for readability.
     */
    private String buildSampleRevenueChartTs()
    {
        return """
                import {OnDestroy, AfterViewInit, Component,
                  signal, computed} from '@angular/core';
                import {AgCharts} from 'ag-charts-angular';
                import {Subscription} from 'rxjs';
                import {v4 as uuidv4} from 'uuid';
                import {EventBusService} from
                  '…/services/EventBusService/EventBusService';
                import {inject} from '@angular/core';
                
                @Component({
                  selector: 'sample-revenue-chart',
                  templateUrl: './SampleRevenueChart.html',
                  styles: [`:host { display: block;
                    position: relative;
                    width:100%; height:100% }`],
                  styleUrls: ['./SampleRevenueChart.scss'],
                  imports: [AgCharts],
                  standalone: true
                })
                export class SampleRevenueChart
                    implements OnDestroy, AfterViewInit {
                  readonly eventBusService =
                    inject(EventBusService);
                  readonly chartOptions =
                    signal<any | undefined>(undefined);
                  readonly handlerId: string;
                  private subscriptionOptions?: Subscription;
                  private subscriptionData?: Subscription;
                  chartData: any;
                  readonly chartReady =
                    computed(() => !!this.chartOptions());
                  readonly listenerName = 'revenueChart';
                
                  constructor() {
                    this.handlerId =
                      this.generateHandlerId();
                  }
                  ngAfterViewInit() {
                    this.initializeOptionsListener();
                    this.initializeDataListener();
                    this.fetchOptions();
                    this.fetchDataChannel();
                  }
                  initializeOptionsListener() {
                    this.subscriptionOptions =
                      this.eventBusService
                        .listen(this.listenerName + 'Options',
                               this.handlerId)
                        .subscribe({
                          next: (data) =>
                            this.handleOptionsEvent(data),
                        });
                  }
                  handleOptionsEvent(data: any) {
                    const payload = typeof data === 'string'
                      ? JSON.parse(data) : data;
                    const options = payload?.out?.[0]
                      ?? payload;
                    this.chartOptions.set(options);
                  }
                  // … fetchOptions, data listeners …
                  ngOnDestroy() {
                    this.subscriptionOptions?.unsubscribe();
                    this.subscriptionData?.unsubscribe();
                  }
                }""";
    }

    /**
     * Builds representative TypeScript for the app routes file.
     */
    private String buildAppRoutesTs()
    {
        return """
                import {Routes} from '@angular/router';
                import {SalesDashboard} from
                  './sales-dashboard/SalesDashboard';
                
                export const routes: Routes = [
                  {
                    path: 'dashboard',
                    component: SalesDashboard
                  },
                  {
                    path: '',
                    redirectTo: 'dashboard',
                    pathMatch: 'full'
                  }
                ];""";
    }

    // ── Tree helpers for the file explorer ──

    private WaTreeItem<?> treeFolder(String label, boolean expanded)
    {
        var item = new WaTreeItem<>();
        item.setText(label);
        item.setExpanded(expanded);
        return item;
    }

    private WaTreeItem<?> treeFile(String label, String panelId)
    {
        var item = new WaTreeItem<>();
        item.setText(label);
        item.addAttribute("data-panel", panelId);
        return item;
    }
}
