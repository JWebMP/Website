package com.jwebmp.website.pages.about;

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
import com.jwebmp.website.pages.WebsitePage;

/**
 * About JWebMP page — detailed information about the framework.
 * <p>
 * Contains the in-depth content about the annotation-driven approach,
 * reactive stack, real-time communication, developer experience,
 * and production readiness.
 */
@NgComponent("jwebmp-about")
@NgRoutable(path = "about")
@NgField("activeFile = 'tab-ts';")
@NgMethod("""
        onFileTreeSelect($event: any) {
            const selection = $event?.detail?.selection;
            if (selection && selection.length > 0) {
                const panel = selection[0].getAttribute('data-panel');
                if (panel) { this.activeFile = panel; }
            }
        }""")
public class AboutPage extends WebsitePage<AboutPage> implements INgComponent<AboutPage>
{
    public AboutPage()
    {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        layout.add(buildIntro());
        layout.add(buildAnnotationDriven());
        layout.add(buildReactiveStack());
        layout.add(buildRealTimeOverview());
        layout.add(buildDeveloperExperience());
        layout.add(buildProductionReady());
        layout.add(buildCallToAction());

        getMain().add(layout);
    }

    // ────────────────────────────────────────────────────────

    private WaStack buildIntro()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP lets you build complete web applications in pure Java. "
                + "Add the Angular plugin and the build generates a full Angular 21 SPA from annotated classes "
                + "— no hand-written TypeScript. Or run in hosted mode on Vert.x 5 with GuicedEE backend services.",
                "l"));

        content.add(bodyText(
                "Either way, your component code stays the same: just Java, all the way down.",
                "l"));

        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.add(buildTag("Java 25+", Variant.Brand));
        tags.add(buildTag("Angular 21", Variant.Danger));
        tags.add(buildTag("Vert.x 5", Variant.Warning));
        tags.add(buildTag("JPMS", Variant.Success));
        tags.add(buildTag("Apache 2.0", Variant.Neutral));
        content.add(tags);

        var grid = grid(3);

        grid.add(featureCard("Single Language, Full Stack",
                "Backend services, frontend components, data models, and routing — all in Java. "
                + "No JavaScript. No HTML templates. The framework handles the rest.",
                null));

        grid.add(featureCard("Compile-Time Safety",
                "Every HTML element, CSS property, and event handler is a Java type. "
                + "Catch errors in your IDE, not in the browser.",
                null));

        grid.add(featureCard("Rapid Development",
                "Add a dependency, annotate a class, build. Components, pages, and routes appear automatically. "
                + "One command to ship a standalone SPA or a hosted app.",
                null));

        content.add(grid);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Get Started", "/getting-started", Variant.Brand, null));
        ctas.add(buildCta("Browse Plugins", "/plugins", Variant.Neutral, Appearance.Outlined));
        content.add(ctas);

        var section = buildSection("ABOUT JWEBMP",
                "One Language to Build It All",
                "Java developers should not need to learn a second ecosystem to ship a web application.",
                false, content);
        section.setID("about-intro");
        return section;
    }

    private WaStack buildAnnotationDriven()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(richText(
                "With the **Angular plugin**, JWebMP turns annotations into a complete Angular application. "
                + "`@NgComponent` creates a component. `@NgRoutable` assigns a route. `@NgDataService` generates a typed "
                + "data service. The build produces `.ts` files, routing modules, and `angular.json` "
                + "— a production-ready Angular 21 project from Java source alone.",
                "m"));

        var buildNote = captionText(
                "Node.js is required at build time for the Angular CLI. "
                + "The resulting SPA is static and can be served from any host — the JWebMP server is entirely optional.");
        buildNote.setWaColorText("quiet");
        content.add(buildNote);

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
                + "That is a 4\u00D7 amplification ratio you never have to write or maintain.",
                "80 LoC \u2192 330 LoC (4\u00D7 amplification)"));

        statsGrid.add(featureCard("Estimated AI Tokens",
                "An LLM needs ~350 tokens to produce the Java source. "
                + "Generating the equivalent TypeScript, templates, subscriptions, and "
                + "lifecycle wiring directly would consume ~2,800 tokens — an 8\u00D7 cost multiplier.",
                "~350 tokens \u2192 ~2,800 tokens (8\u00D7 cost)"));

        statsGrid.add(featureCard("Complexity",
                "The Java side is declarative: annotations, column definitions, and a data list. "
                + "The generated TypeScript includes EventBus subscriptions, signal/computed reactivity, "
                + "lifecycle hooks, resize handlers, and UUID-based listener management — all auto-wired.",
                "Declarative \u2192 Imperative (auto-generated)"));

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
                "Non-blocking event-loop server that renders pages, handles AJAX events, and serves resources. "
                + "Angular SPAs can connect for push updates via event bus or RabbitMQ.",
                "Event-loop I/O"));

        grid.add(featureCard("GuicedEE Runtime",
                "Google Guice dependency injection with SPI discovery, call-scoped requests, and JPMS isolation. "
                + "Included in hosted mode; optional backend for Angular SPAs.",
                "DI + SPI + JPMS"));

        grid.add(featureCard("AJAX Event Pipeline",
                "Browser events fire Java handlers on the server. 50+ event adapters "
                + "— click, change, submit, drag, keyboard — all without writing any JavaScript.",
                "50+ event adapters"));

        grid.add(featureCard("Dual Rendering",
                "Same component tree, two output formats. HTML for server-side pages, JSON for AJAX responses. "
                + "Angular mode adds a third: generated TypeScript.",
                "Hosted + SPA + AJAX"));

        content.add(grid);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Explore Architecture", "/architecture", Variant.Brand, null));
        content.add(ctas);

        var section = buildSection("REACTIVE STACK",
                "Built on Vert.x 5 and GuicedEE",
                "Non-blocking I/O, dependency injection, and SPI discovery. Optional backend for Angular SPAs.",
                true, content);
        section.setID("reactive-stack");
        return section;
    }

    private WaStack buildRealTimeOverview()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(richText(
                "**Hosted mode** gives you 50+ server-driven AJAX events, REST endpoints, and Vert.x WebSocket broadcasting "
                + "out of the box. **Angular mode** generates typed `@NgDataService` classes and connects to the "
                + "Vert.x STOMP event bus for live data. Need durability? Add RabbitMQ Comms for broker-backed messaging.",
                "m"));

        var commNote = captionText(
                "Start with request/response. Layer in push updates when your application needs them.");
        commNote.setWaColorText("quiet");
        content.add(commNote);

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

    private WaStack buildDeveloperExperience()
    {
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(2);

        grid.add(featureCard("Fluent API",
                "Chainable builders on every component. "
                + "Set appearance, add children, configure options — all in one readable expression.",
                "CRTP generics"));

        grid.add(featureCard("SPI Extensibility",
                "Extend the framework by implementing an interface and registering via ServiceLoader "
                + "or module-info.java. Page configurators, event hooks, and render ordering are all pluggable.",
                "ServiceLoader + module-info"));

        grid.add(featureCard("Maven Build Integration",
                "The Maven plugin discovers components, generates TypeScript, installs npm, and runs the Angular CLI "
                + "— all inside mvn install. Hosted mode has no frontend build step at all.",
                "mvn install — done"));

        grid.add(featureCard("IDE-Friendly",
                "Concrete Java classes with full autocomplete, refactoring, find-usages, and go-to-definition. "
                + "Works out of the box in IntelliJ, Eclipse, or VS Code.",
                "Zero IDE plugins"));

        content.add(grid);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Getting Started Guide", "/getting-started", Variant.Brand, null));
        content.add(ctas);

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
                "Explicit module-info.java with declared exports, requires, and provides. "
                + "JLink-ready for minimal container images.",
                "module-info.java"));

        grid.add(featureCard("Reactive Non-Blocking",
                "Hosted mode runs on the Vert.x 5 event loop — no thread-per-request overhead. "
                + "Angular SPAs are static files served from any host or CDN.",
                "Event-loop server"));

        grid.add(featureCard("Apache 2.0 Open Source",
                "Permissive licensing. Fork it, extend it, ship it. "
                + "Active development with snapshot builds on Maven Central.",
                "Apache-2.0 license"));

        content.add(grid);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("View on GitHub", "/github", Variant.Brand, null));
        content.add(ctas);

        var section = buildSection("PRODUCTION READY",
                "Ship with Confidence",
                "Modular, reactive, and open source — ready for production workloads.",
                true, content);
        section.setID("production-ready");
        return section;
    }


    // ── Code sample strings ──────────────────────────────

    private String buildSalesDashboardHtml()
    {
        return """
                <div>
                \t<sample-sales-grid></sample-sales-grid>
                \t<sample-revenue-chart></sample-revenue-chart>
                </div>""";
    }

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

    private String buildSampleRevenueChartHtml()
    {
        return """
                @if (chartReady() && chartOptions()) {
                \t<ag-charts [options]="chartOptions()"
                \t           id="revenueChart">
                \t</ag-charts>
                }""";
    }

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
                
                // \u2500\u2500 Grid definition \u2500\u2500
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
                  '\u2026/services/EventBusService/EventBusService';
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
                          // \u2026 parse rows and update grid \u2026
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

    private String buildSampleRevenueChartTs()
    {
        return """
                import {OnDestroy, AfterViewInit, Component,
                  signal, computed} from '@angular/core';
                import {AgCharts} from 'ag-charts-angular';
                import {Subscription} from 'rxjs';
                import {v4 as uuidv4} from 'uuid';
                import {EventBusService} from
                  '\u2026/services/EventBusService/EventBusService';
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
                  // \u2026 fetchOptions, data listeners \u2026
                  ngOnDestroy() {
                    this.subscriptionOptions?.unsubscribe();
                    this.subscriptionData?.unsubscribe();
                  }
                }""";
    }

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

