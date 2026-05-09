package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-datatables")
@NgRoutable(path = "plugins/datatables")
public class DataTablesPluginPage extends PluginDetailPage<DataTablesPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("DataTable",
                    "Core DataTable component — wraps an HTML table with DataTables.net initialization, JSON-serializable options, and Angular integration",
                    "com.jwebmp.plugins.datatable",
                    List.of(
                            new PluginEntry.PropertyInfo("options", "DataTableOptions&lt;?&gt;", "new DataTableOptions&lt;&gt;()", "The grid options object containing all configuration"),
                            new PluginEntry.PropertyInfo("headerGroup", "TableHeaderGroup&lt;?&gt;", "null", "The table header group element"),
                            new PluginEntry.PropertyInfo("bodyGroup", "TableBodyGroup&lt;?&gt;", "null", "The table body group element"),
                            new PluginEntry.PropertyInfo("footerGroup", "TableFooterGroup&lt;?&gt;", "null", "The table footer group element"),
                            new PluginEntry.PropertyInfo("captionGroup", "TableCaption&lt;?&gt;", "null", "The table caption element")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic DataTable", "Create a sortable, searchable table",
                                    "DataTable&lt;?&gt; table = new DataTable&lt;&gt;();\ntable.getOptions()\n     .setPaging(true)\n     .setSearching(true)\n     .setOrdering(true)\n     .setInfo(true);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("DataTable()", "Creates a DataTable with default options")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "DataTableOptions&lt;?&gt;", "getOptions()", "Returns the DataTable options object"),
                            new PluginEntry.MethodInfo("addColumn", "J", "addColumn(DataTableColumnOptions&lt;?&gt; column)", "Adds a column definition"),
                            new PluginEntry.MethodInfo("getHeaderGroup", "TableHeaderGroup&lt;?&gt;", "getHeaderGroup()", "Returns the table header group"),
                            new PluginEntry.MethodInfo("getBodyGroup", "TableBodyGroup&lt;?&gt;", "getBodyGroup()", "Returns the table body group"),
                            new PluginEntry.MethodInfo("getFooterGroup", "TableFooterGroup&lt;?&gt;", "getFooterGroup()", "Returns the table footer group")
                    ),
                    List.of(), List.of(),
                    List.of("Table", "JavaScriptPart")),
            new PluginEntry.ComponentInfo("DataTablePageConfigurator",
                    "Auto-registers DataTables.net NPM dependencies (datatables.net, jszip, pdfmake)",
                    "com.jwebmp.plugins.datatable",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("DataTableOptions",
                    "Type-safe options class covering all DataTables configuration — paging, ordering, searching, AJAX, DOM layout, scrolling, state saving, and extensions",
                    "com.jwebmp.plugins.datatable.options",
                    List.of(
                            new PluginEntry.PropertyInfo("paging", "Boolean", "null", "Enable or disable table pagination"),
                            new PluginEntry.PropertyInfo("pageLength", "Integer", "null", "Number of rows per page (default 10)"),
                            new PluginEntry.PropertyInfo("pagingType", "DataTablesPagingTypes", "null", "Pagination button style: numbers, simple, simple_numbers, full, full_numbers, first_last_numbers"),
                            new PluginEntry.PropertyInfo("lengthChange", "Boolean", "null", "Allow end user to change page length"),
                            new PluginEntry.PropertyInfo("lengthMenu", "Set&lt;Integer&gt;", "null", "Page length options shown in dropdown (default [10,25,50,100])"),
                            new PluginEntry.PropertyInfo("ordering", "Boolean", "null", "Enable or disable column ordering/sorting"),
                            new PluginEntry.PropertyInfo("orderMulti", "Boolean", "null", "Allow shift-click multi-column ordering"),
                            new PluginEntry.PropertyInfo("orderCellsTop", "Boolean", "null", "Use top header cell for ordering listener"),
                            new PluginEntry.PropertyInfo("orderClasses", "Boolean", "null", "Highlight columns used for ordering"),
                            new PluginEntry.PropertyInfo("orderFixed", "Boolean", "null", "Fixed ordering always applied to the table"),
                            new PluginEntry.PropertyInfo("searching", "Boolean", "null", "Enable or disable search/filtering"),
                            new PluginEntry.PropertyInfo("search", "DataTablesSearchOptions&lt;?&gt;", "null", "Initial search configuration (caseInsensitive, regex, smart)"),
                            new PluginEntry.PropertyInfo("searchDelay", "Integer", "null", "Throttle frequency for search in ms"),
                            new PluginEntry.PropertyInfo("info", "Boolean", "null", "Show table information display"),
                            new PluginEntry.PropertyInfo("processing", "Boolean", "null", "Show processing indicator during operations"),
                            new PluginEntry.PropertyInfo("serverSide", "Boolean", "null", "Enable server-side processing mode"),
                            new PluginEntry.PropertyInfo("ajax", "DataTablesAjaxOptions&lt;?&gt;", "null", "AJAX data source configuration (url, type, data function)"),
                            new PluginEntry.PropertyInfo("data", "String", "null", "Data to use as table display data (raw JSON)"),
                            new PluginEntry.PropertyInfo("columns", "List&lt;DataTableColumnOptions&lt;?&gt;&gt;", "null", "Column definitions list"),
                            new PluginEntry.PropertyInfo("autoWidth", "Boolean", "null", "Smart column width calculation"),
                            new PluginEntry.PropertyInfo("deferRender", "Boolean", "null", "Deferred rendering for faster init"),
                            new PluginEntry.PropertyInfo("scrollX", "Boolean", "null", "Enable horizontal scrolling"),
                            new PluginEntry.PropertyInfo("scrollY", "MeasurementCSSImpl", "null", "Vertical scrolling height"),
                            new PluginEntry.PropertyInfo("scrollCollapse", "Boolean", "null", "Allow table to reduce height with fewer rows"),
                            new PluginEntry.PropertyInfo("stateSave", "Boolean", "null", "Restore table state on page reload"),
                            new PluginEntry.PropertyInfo("stateDuration", "Integer", "null", "Saved state validity in seconds (-1 for sessionStorage)"),
                            new PluginEntry.PropertyInfo("rowId", "String", "null", "Data property for tr element DOM ID"),
                            new PluginEntry.PropertyInfo("destroy", "Boolean", "null", "Destroy and reinitialise the table"),
                            new PluginEntry.PropertyInfo("retrieve", "Boolean", "null", "Retrieve existing DataTables instance"),
                            new PluginEntry.PropertyInfo("tabIndex", "Integer", "null", "Tab index for keyboard navigation"),
                            new PluginEntry.PropertyInfo("renderer", "DataTableThemes", "null", "Display renderer theme (e.g. bootstrap)"),
                            new PluginEntry.PropertyInfo("responsive", "DataTablesResponsiveOptions&lt;?&gt;", "null", "Responsive extension configuration"),
                            new PluginEntry.PropertyInfo("buttons", "Set&lt;DataTablesButtonButtonsOptions&lt;?&gt;&gt;", "null", "Buttons extension (export, copy, print)"),
                            new PluginEntry.PropertyInfo("colReorder", "DataTableColReOrderOptions&lt;?&gt;", "null", "Column reordering extension"),
                            new PluginEntry.PropertyInfo("fixedColumns", "DataTableFixedColumnsOptions&lt;?&gt;", "null", "Fixed columns extension"),
                            new PluginEntry.PropertyInfo("fixedHeader", "DataTableFixedHeaderOptions&lt;?&gt;", "null", "Fixed header extension"),
                            new PluginEntry.PropertyInfo("keys", "DataTableKeyTableOptions&lt;?&gt;", "null", "KeyTable extension (spreadsheet navigation)"),
                            new PluginEntry.PropertyInfo("rowGroup", "DataTablesRowGroupOptions&lt;?&gt;", "null", "Row grouping extension"),
                            new PluginEntry.PropertyInfo("rowReorder", "DataTablesRowReorder&lt;?&gt;", "null", "Row reorder extension"),
                            new PluginEntry.PropertyInfo("scroller", "DataTablesScrollerOptions&lt;?&gt;", "null", "Virtual scrolling extension"),
                            new PluginEntry.PropertyInfo("select", "DataTablesSelectOptions&lt;?&gt;", "null", "Row/cell selection extension"),
                            new PluginEntry.PropertyInfo("autoFill", "DataTableAutoFillOptions&lt;?&gt;", "null", "AutoFill extension"),
                            new PluginEntry.PropertyInfo("searchPanes", "DataTablesSearchPanesOptions", "null", "SearchPanes extension for multi-value filtering")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Paging &amp; Ordering", "Enable paging with custom page length",
                                    "DataTableOptions&lt;?&gt; opts = new DataTableOptions&lt;&gt;();\nopts.setPaging(true)\n    .setPageLength(25)\n    .setPagingType(DataTablesPagingTypes.full_numbers)\n    .setOrdering(true)\n    .setOrderMulti(true);", "java"),
                            new PluginEntry.ExampleSnippet("Server-Side Processing", "Configure AJAX server-side data loading",
                                    "DataTableOptions&lt;?&gt; opts = new DataTableOptions&lt;&gt;();\nopts.setServerSide(true)\n    .setProcessing(true)\n    .setSearchDelay(400);", "java"),
                            new PluginEntry.ExampleSnippet("Scrolling &amp; State Save", "Enable scrolling with state persistence",
                                    "DataTableOptions&lt;?&gt; opts = new DataTableOptions&lt;&gt;();\nopts.setScrollX(true)\n    .setScrollCollapse(true)\n    .setStateSave(true)\n    .setStateDuration(3600);", "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("DataTableOptions()", "Creates DataTable options with no defaults set")),
                    List.of(
                            new PluginEntry.MethodInfo("setPaging", "J", "setPaging(Boolean paging)", "Enable/disable pagination"),
                            new PluginEntry.MethodInfo("setPageLength", "J", "setPageLength(Integer pageLength)", "Set rows per page"),
                            new PluginEntry.MethodInfo("setPagingType", "J", "setPagingType(DataTablesPagingTypes pagingType)", "Set pagination button style"),
                            new PluginEntry.MethodInfo("setLengthChange", "J", "setLengthChange(Boolean lengthChange)", "Enable/disable page length selector"),
                            new PluginEntry.MethodInfo("setLengthMenu", "J", "setLengthMenu(Set&lt;Integer&gt; lengthMenu)", "Set page length options"),
                            new PluginEntry.MethodInfo("setOrdering", "J", "setOrdering(Boolean ordering)", "Enable/disable column ordering"),
                            new PluginEntry.MethodInfo("setOrderMulti", "J", "setOrderMulti(Boolean orderMulti)", "Enable/disable multi-column ordering"),
                            new PluginEntry.MethodInfo("setSearching", "J", "setSearching(Boolean searching)", "Enable/disable searching"),
                            new PluginEntry.MethodInfo("setSearchDelay", "J", "setSearchDelay(Integer searchDelay)", "Set search throttle in ms"),
                            new PluginEntry.MethodInfo("setInfo", "J", "setInfo(Boolean info)", "Enable/disable info display"),
                            new PluginEntry.MethodInfo("setProcessing", "J", "setProcessing(Boolean processing)", "Enable/disable processing indicator"),
                            new PluginEntry.MethodInfo("setServerSide", "J", "setServerSide(Boolean serverSide)", "Enable/disable server-side mode"),
                            new PluginEntry.MethodInfo("setAutoWidth", "J", "setAutoWidth(Boolean autoWidth)", "Enable/disable smart column width"),
                            new PluginEntry.MethodInfo("setDeferRender", "J", "setDeferRender(Boolean deferRender)", "Enable/disable deferred rendering"),
                            new PluginEntry.MethodInfo("setScrollX", "J", "setScrollX(Boolean scrollX)", "Enable/disable horizontal scrolling"),
                            new PluginEntry.MethodInfo("setScrollY", "J", "setScrollY(MeasurementCSSImpl scrollY)", "Set vertical scroll height"),
                            new PluginEntry.MethodInfo("setScrollCollapse", "J", "setScrollCollapse(Boolean scrollCollapse)", "Allow table height to collapse"),
                            new PluginEntry.MethodInfo("setStateSave", "J", "setStateSave(Boolean stateSave)", "Enable/disable state saving"),
                            new PluginEntry.MethodInfo("setStateDuration", "J", "setStateDuration(Integer stateDuration)", "Set state validity duration (seconds)"),
                            new PluginEntry.MethodInfo("setRowId", "J", "setRowId(String rowId)", "Set data property for row IDs"),
                            new PluginEntry.MethodInfo("setDestroy", "J", "setDestroy(Boolean destroy)", "Destroy and reinitialise table"),
                            new PluginEntry.MethodInfo("setRetrieve", "J", "setRetrieve(Boolean retrieve)", "Retrieve existing instance"),
                            new PluginEntry.MethodInfo("setRenderer", "J", "setRenderer(DataTableThemes renderer)", "Set display renderer theme"),
                            new PluginEntry.MethodInfo("setInitComplete", "J", "setInitComplete(JavascriptLiteralFunction&lt;?&gt; initComplete)", "Set initialization complete callback"),
                            new PluginEntry.MethodInfo("getSearchPanes", "DataTablesSearchPanesOptions", "getSearchPanes()", "Get search panes options (lazy-creates)")
                    ),
                    List.of(), List.of(),
                    List.of("JavaScriptPart")),
            new PluginEntry.ComponentInfo("DataTableColumnOptions",
                    "Per-column configuration — data source, title, type, sortable, searchable, visible, width, render functions, and cell type",
                    "com.jwebmp.plugins.datatable.options",
                    List.of(
                            new PluginEntry.PropertyInfo("name", "String", "null", "Column name identifier"),
                            new PluginEntry.PropertyInfo("targets", "Integer", "null", "Column index for columnDefs targeting"),
                            new PluginEntry.PropertyInfo("cellType", "ComponentTypes", "null", "Cell type: TD or TH"),
                            new PluginEntry.PropertyInfo("className", "String", "null", "CSS class applied to all cells in the column"),
                            new PluginEntry.PropertyInfo("data", "String", "null", "Data source property for the column"),
                            new PluginEntry.PropertyInfo("title", "String", "null", "Column header title text"),
                            new PluginEntry.PropertyInfo("type", "String", "null", "Data type for sorting (num, date, string, etc.)"),
                            new PluginEntry.PropertyInfo("defaultContent", "String", "null", "Default content when data is null"),
                            new PluginEntry.PropertyInfo("orderable", "DataTablesSortables", "null", "Enable/disable ordering on this column"),
                            new PluginEntry.PropertyInfo("searchable", "Boolean", "null", "Include column in searching"),
                            new PluginEntry.PropertyInfo("visible", "Boolean", "null", "Column visibility"),
                            new PluginEntry.PropertyInfo("width", "String", "null", "Column width (CSS value)"),
                            new PluginEntry.PropertyInfo("responsivePriority", "Integer", "null", "Priority for responsive column hiding"),
                            new PluginEntry.PropertyInfo("render", "String", "null", "Render function for cell content (raw JS)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Column", "Define a simple data-bound column",
                                    "DataTableColumnOptions&lt;?&gt; col = new DataTableColumnOptions&lt;&gt;(opts);\ncol.setData(\"name\")\n   .setTitle(\"Full Name\")\n   .setOrderable(DataTablesSortables.True)\n   .setSearchable(true)\n   .setWidth(\"200px\");", "java"),
                            new PluginEntry.ExampleSnippet("Hidden ID Column", "A hidden column for row identification",
                                    "DataTableColumnOptions&lt;?&gt; col = new DataTableColumnOptions&lt;&gt;(opts);\ncol.setData(\"id\")\n   .setTitle(\"ID\")\n   .setVisible(false);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("DataTableColumnOptions(DataTableOptions&lt;?&gt; tableOptions)", "Creates a column definition linked to table options")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setName", "J", "setName(String name)", "Sets the column name"),
                            new PluginEntry.MethodInfo("setTargets", "J", "setTargets(Integer targets)", "Sets the column index target"),
                            new PluginEntry.MethodInfo("setCellType", "J", "setCellType(ComponentTypes cellType)", "Sets cell type (TD/TH)"),
                            new PluginEntry.MethodInfo("setClassName", "J", "setClassName(String className)", "Sets CSS class for cells"),
                            new PluginEntry.MethodInfo("setData", "J", "setData(String data)", "Sets data source property"),
                            new PluginEntry.MethodInfo("setTitle", "J", "setTitle(String title)", "Sets column header title"),
                            new PluginEntry.MethodInfo("setType", "J", "setType(String type)", "Sets data type for sorting"),
                            new PluginEntry.MethodInfo("setDefaultContent", "J", "setDefaultContent(String defaultContent)", "Sets default content for null values"),
                            new PluginEntry.MethodInfo("setOrderable", "J", "setOrderable(DataTablesSortables orderable)", "Enable/disable column ordering"),
                            new PluginEntry.MethodInfo("setSearchable", "J", "setSearchable(Boolean searchable)", "Enable/disable column searching"),
                            new PluginEntry.MethodInfo("setVisible", "J", "setVisible(Boolean visible)", "Show/hide the column"),
                            new PluginEntry.MethodInfo("setWidth", "J", "setWidth(String width)", "Sets column width"),
                            new PluginEntry.MethodInfo("setResponsivePriority", "J", "setResponsivePriority(Integer responsivePriority)", "Sets responsive hide priority")
                    ),
                    List.of(), List.of(),
                    List.of("JavaScriptPart")),
            new PluginEntry.ComponentInfo("DataTablesResponsiveOptions",
                    "Responsive extension options — breakpoints, detail rendering, column priority for automatic column hiding on smaller screens",
                    "com.jwebmp.plugins.datatable.options.responsive",
                    List.of(
                            new PluginEntry.PropertyInfo("details", "Object", "null", "Child row detail rendering configuration"),
                            new PluginEntry.PropertyInfo("breakpoints", "List", "null", "Responsive breakpoint definitions"),
                            new PluginEntry.PropertyInfo("orthogonal", "String", "null", "Data type to use for responsive display")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Enable Responsive", "Enable responsive with default settings",
                                    "DataTableOptions&lt;?&gt; opts = new DataTableOptions&lt;&gt;();\nopts.setResponsive(new DataTablesResponsiveOptions&lt;&gt;());", "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("DataTablesResponsiveOptions()", "Creates responsive options with defaults")),
                    List.of(), List.of(), List.of(),
                    List.of("JavaScriptPart")),
            new PluginEntry.ComponentInfo("DataTablesButtonsOptions",
                    "Buttons extension options — export types (Copy, Excel, PDF, CSV, Print), DOM placement, and custom button definitions",
                    "com.jwebmp.plugins.datatable.options.buttons",
                    List.of(
                            new PluginEntry.PropertyInfo("extend", "String", "null", "Built-in button type to extend (copy, excel, pdf, csv, print)"),
                            new PluginEntry.PropertyInfo("text", "String", "null", "Button display text"),
                            new PluginEntry.PropertyInfo("className", "String", "null", "CSS class for the button"),
                            new PluginEntry.PropertyInfo("action", "String", "null", "Raw JS action function"),
                            new PluginEntry.PropertyInfo("titleAttr", "String", "null", "Title attribute for accessibility"),
                            new PluginEntry.PropertyInfo("exportOptions", "Object", "null", "Export configuration options")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Add Export Buttons", "Add PDF and Excel export buttons",
                                    "DataTableOptions&lt;?&gt; opts = new DataTableOptions&lt;&gt;();\nopts.getButtons().add(DataTableButtons.Copy);\nopts.getButtons().add(DataTableButtons.Excel);\nopts.getButtons().add(DataTableButtons.Pdf);\nopts.getButtons().add(DataTableButtons.Csv);", "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("DataTablesButtonButtonsOptions()", "Creates a button option")),
                    List.of(), List.of(), List.of(),
                    List.of("JavaScriptPart"))
    );

    public DataTablesPluginPage()
    {
        super(PluginCatalog.getById("datatables").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return COMPONENTS;
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Basic DataTable",
                        "Create a sortable, searchable table with pagination.",
                        "DataTable<?> table = new DataTable<>(\"users\");\ntable.getOptions()\n     .setPaging(true)\n     .setSearching(true)\n     .setOrdering(true)\n     .setInfo(true);",
                        "java"),
                new PluginEntry.ExampleSnippet("Export Buttons",
                        "Add PDF, Excel, and CSV export buttons.",
                        "table.getOptions().getButtons().add(DataTableButtons.Copy);\ntable.getOptions().getButtons().add(DataTableButtons.Excel);\ntable.getOptions().getButtons().add(DataTableButtons.Pdf);\ntable.getOptions().getButtons().add(DataTableButtons.Csv);",
                        "java"),
                new PluginEntry.ExampleSnippet("Server-side Processing",
                        "Enable AJAX with server-side search/sort/page.",
                        "table.getOptions().setServerSide(true);\ntable.getOptions().getAjax()\n     .setUrl(\"/api/users\")\n     .setType(\"POST\");",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides",
                        "DataTablePageConfigurator auto-registers datatables.net, jszip, and pdfmake NPM dependencies"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides",
                        "DataTablesInclusionModule ensures the DataTables module is included in Guice classpath scanning")
        );
    }
}

