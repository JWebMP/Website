package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-aggrid")
@NgRoutable(path = "plugins/aggrid")
public class AgGridPluginPage extends PluginDetailPage<AgGridPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("AgGrid", "Main grid component with CRTP fluent API, WebSocket data binding, and Angular template generation", "com.jwebmp.plugins.aggrid",
                    List.of(
                            new PluginEntry.PropertyInfo("options", "AgGridOptions&lt;?&gt;", "new AgGridOptions&lt;&gt;()", "The grid options object containing all configuration"),
                            new PluginEntry.PropertyInfo("tag", "String", "ag-grid-angular", "The HTML tag rendered for the Angular grid component"),
                            new PluginEntry.PropertyInfo("style.height", "String", "500px", "The height of the grid container"),
                            new PluginEntry.PropertyInfo("style.width", "String", "100%", "The width of the grid container")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Define a Data Grid", "Create a grid with pagination and typed column definitions",
                                    "public class OrderGrid extends AgGrid&lt;OrderGrid&gt; {\n    public OrderGrid() {\n        setHeight(\"600px\")\n            .enablePagination()\n            .enableRowSelection(RowSelectionMode.multiRow);\n\n        addColumnDef(new AgGridColumnDef&lt;&gt;()\n            .setField(\"orderId\")\n            .setHeaderName(\"Order ID\")\n            .setWidth(100));\n\n        addColumnDef(new AgGridColumnDef&lt;&gt;()\n            .setField(\"total\")\n            .setHeaderName(\"Total\")\n            .setFlex(1));\n    }\n\n    @Override\n    public String getRowIdFieldName() {\n        return \"orderId\";\n    }\n\n    @Override\n    public Collection fetchData() {\n        return orderService.findAll();\n    }\n}", "java"),
                            new PluginEntry.ExampleSnippet("Custom Cell Renderer", "Add a custom Angular cell renderer to a column",
                                    "AgGridColumnDef&lt;?&gt; col = new AgGridColumnDef&lt;&gt;(\"status\", \"Status\");\nconfigureCellRenderer(col, new StatusBadgeRenderer());\naddColumnDef(col);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("AgGrid()", "Creates an ag-grid-angular element with default 100% width, 500px height, and context binding")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addColumnDef", "J", "addColumnDef(AgGridColumnDef&lt;?&gt; columnDef)", "Adds a column definition to the grid"),
                            new PluginEntry.MethodInfo("addColumnDefs", "J", "addColumnDefs(List&lt;AgGridColumnDef&lt;?&gt;&gt; columnDefs)", "Adds multiple column definitions"),
                            new PluginEntry.MethodInfo("enablePagination", "J", "enablePagination()", "Enables pagination on the grid"),
                            new PluginEntry.MethodInfo("enableRowSelection", "J", "enableRowSelection(RowSelectionMode selectionMode)", "Enables row selection (singleRow or multiRow)"),
                            new PluginEntry.MethodInfo("setHeight", "J", "setHeight(String height)", "Sets the grid container height (e.g. '600px', '100%')"),
                            new PluginEntry.MethodInfo("setWidth", "J", "setWidth(String width)", "Sets the grid container width"),
                            new PluginEntry.MethodInfo("setTheme", "J", "setTheme(String theme)", "Sets the AG Grid theme CSS class (e.g. 'ag-theme-alpine')"),
                            new PluginEntry.MethodInfo("getOptions", "AgGridOptions&lt;?&gt;", "getOptions()", "Returns the grid options object"),
                            new PluginEntry.MethodInfo("setOptions", "J", "setOptions(AgGridOptions&lt;?&gt; options)", "Sets the grid options"),
                            new PluginEntry.MethodInfo("bindRowData", "J", "bindRowData(String variableName)", "Binds [rowData] to an Angular variable"),
                            new PluginEntry.MethodInfo("bindColumnDefs", "J", "bindColumnDefs(String variableName)", "Binds [columnDefs] to an Angular variable"),
                            new PluginEntry.MethodInfo("bindDefaultColDef", "J", "bindDefaultColDef(String variableName)", "Binds [defaultColDef] to an Angular variable"),
                            new PluginEntry.MethodInfo("configureCellRenderer", "J", "configureCellRenderer(AgGridColumnDef&lt;?&gt; col, ICellRenderer&lt;?&gt; renderer)", "Registers an Angular cell renderer on a column"),
                            new PluginEntry.MethodInfo("createColumnWithCellRenderer", "AgGridColumnDef&lt;?&gt;", "createColumnWithCellRenderer(String field, String header, DefaultCellRenderer&lt;?&gt; renderer)", "Creates and adds a column with a cell renderer"),
                            new PluginEntry.MethodInfo("fetchData", "Collection", "fetchData()", "Abstract — override to provide row data from the server via WebSocket"),
                            new PluginEntry.MethodInfo("getRowIdFieldName", "String", "getRowIdFieldName()", "Abstract — override to return the unique row ID field name")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("gridReady", "Fired when the grid API is available — auto-sizes columns"),
                            new PluginEntry.EventInfo("firstDataRendered", "Fired after the first data render — triggers column fit"),
                            new PluginEntry.EventInfo("gridSizeChanged", "Fired when the grid container resizes"),
                            new PluginEntry.EventInfo("rowSelected", "Fired when a row selection changes")
                    ),
                    List.of(),
                    List.of("INgComponent", "IJsonRepresentation")),

            new PluginEntry.ComponentInfo("AgGridColumnDef", "Column definition controlling field binding, display, sorting, filtering, editing, grouping, and rendering", "com.jwebmp.plugins.aggrid",
                    List.of(
                            new PluginEntry.PropertyInfo("field", "String", "null", "The data field name to bind to"),
                            new PluginEntry.PropertyInfo("headerName", "String", "null", "The column header display text"),
                            new PluginEntry.PropertyInfo("colId", "String", "null", "Unique column identifier"),
                            new PluginEntry.PropertyInfo("width", "Integer", "null", "Fixed column width in pixels"),
                            new PluginEntry.PropertyInfo("minWidth", "Integer", "null", "Minimum column width in pixels"),
                            new PluginEntry.PropertyInfo("maxWidth", "Integer", "null", "Maximum column width in pixels"),
                            new PluginEntry.PropertyInfo("flex", "Integer", "null", "Flex value for responsive sizing"),
                            new PluginEntry.PropertyInfo("sortable", "Boolean", "null", "Whether the column is sortable"),
                            new PluginEntry.PropertyInfo("sort", "String", "null", "Initial sort direction: 'asc' or 'desc'"),
                            new PluginEntry.PropertyInfo("filter", "Object", "null", "Filter type: true, 'agTextColumnFilter', 'agSetColumnFilter', etc."),
                            new PluginEntry.PropertyInfo("resizable", "Boolean", "null", "Whether the column can be resized"),
                            new PluginEntry.PropertyInfo("editable", "Object", "null", "Whether cells are editable (boolean or function)"),
                            new PluginEntry.PropertyInfo("pinned", "String", "null", "Pin column: 'left' or 'right'"),
                            new PluginEntry.PropertyInfo("hide", "Boolean", "null", "Whether the column is hidden"),
                            new PluginEntry.PropertyInfo("checkboxSelection", "Boolean", "null", "Shows selection checkbox in the column"),
                            new PluginEntry.PropertyInfo("headerCheckboxSelection", "Boolean", "null", "Shows select-all checkbox in the header"),
                            new PluginEntry.PropertyInfo("cellRenderer", "ICellRenderer&lt;?&gt;", "null", "Angular cell renderer component"),
                            new PluginEntry.PropertyInfo("cellRendererParams", "Object", "null", "Parameters passed to the cell renderer"),
                            new PluginEntry.PropertyInfo("cellStyle", "Object", "null", "CSS styles for cells (Map or function)"),
                            new PluginEntry.PropertyInfo("cellClass", "String", "null", "CSS class applied to cells"),
                            new PluginEntry.PropertyInfo("headerTooltip", "String", "null", "Tooltip for the column header"),
                            new PluginEntry.PropertyInfo("headerComponent", "DefaultHeaderComponent&lt;?&gt;", "null", "Custom Angular header component"),
                            new PluginEntry.PropertyInfo("wrapHeaderText", "Boolean", "null", "Wraps long header text"),
                            new PluginEntry.PropertyInfo("autoHeaderHeight", "Boolean", "null", "Auto-adjusts header height to content"),
                            new PluginEntry.PropertyInfo("rowGroup", "Boolean", "null", "Enterprise: groups rows by this column"),
                            new PluginEntry.PropertyInfo("rowGroupIndex", "Integer", "null", "Enterprise: grouping order for multi-group"),
                            new PluginEntry.PropertyInfo("aggFunc", "Object", "null", "Aggregation function: 'sum', 'min', 'max', 'avg', 'count', or custom"),
                            new PluginEntry.PropertyInfo("pivot", "Boolean", "null", "Enterprise: enables pivot on this column"),
                            new PluginEntry.PropertyInfo("pivotIndex", "Integer", "null", "Enterprise: pivot ordering"),
                            new PluginEntry.PropertyInfo("enablePivot", "Boolean", "null", "Enterprise: enables pivot UI on this column"),
                            new PluginEntry.PropertyInfo("valueFormatter", "String", "null", "Raw JS function for display formatting"),
                            new PluginEntry.PropertyInfo("valueGetter", "FieldSelector", "null", "Custom value getter (expression or raw JS)"),
                            new PluginEntry.PropertyInfo("valueParser", "String", "null", "Raw JS function to parse edited values"),
                            new PluginEntry.PropertyInfo("valueSetter", "String", "null", "Raw JS function to set edited values"),
                            new PluginEntry.PropertyInfo("children", "List&lt;AgGridColumnDef&lt;?&gt;&gt;", "null", "Child columns for column groups"),
                            new PluginEntry.PropertyInfo("columnGroupShow", "String", "null", "Show in group: 'open', 'closed', or null"),
                            new PluginEntry.PropertyInfo("marryChildren", "Boolean", "null", "Keeps child columns together when reordering"),
                            new PluginEntry.PropertyInfo("suppressMovable", "Boolean", "null", "Prevents column drag-reordering"),
                            new PluginEntry.PropertyInfo("lockPosition", "String", "null", "Locks column position: 'left' or 'right'"),
                            new PluginEntry.PropertyInfo("lockVisible", "Boolean", "null", "Prevents visibility toggle via UI"),
                            new PluginEntry.PropertyInfo("lockPinned", "Boolean", "null", "Prevents pin/unpin via UI"),
                            new PluginEntry.PropertyInfo("suppressSizeToFit", "Boolean", "null", "Excludes from auto-fit sizing"),
                            new PluginEntry.PropertyInfo("colSpan", "Object", "null", "Cell column span (number or function)"),
                            new PluginEntry.PropertyInfo("rowSpan", "Object", "null", "Cell row span (number or function)"),
                            new PluginEntry.PropertyInfo("rowDrag", "Object", "null", "Enables row drag on this column"),
                            new PluginEntry.PropertyInfo("enableCellChangeFlash", "Boolean", "null", "Flashes cells when values change"),
                            new PluginEntry.PropertyInfo("suppressFillHandle", "Boolean", "null", "Disables fill handle for this column"),
                            new PluginEntry.PropertyInfo("chartDataType", "String", "null", "Chart type: 'category', 'series', 'time', 'excluded'"),
                            new PluginEntry.PropertyInfo("suppressKeyboardEvent", "String", "null", "Raw JS function to suppress keyboard events")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Column", "Define a simple sortable, filterable column",
                                    "new AgGridColumnDef&lt;&gt;(\"name\", \"Full Name\")\n    .setSortable(true)\n    .setFilter(true)\n    .setFlex(1);", "java"),
                            new PluginEntry.ExampleSnippet("Editable Column with Formatter", "Create an editable number column with formatting",
                                    "new AgGridColumnDef&lt;&gt;(\"price\", \"Price\")\n    .setEditable(true)\n    .setValueFormatter(\"params =&gt; '$' + params.value.toFixed(2)\")\n    .setWidth(120);", "java"),
                            new PluginEntry.ExampleSnippet("Column Group", "Nest columns under a group header",
                                    "new AgGridColumnDef&lt;&gt;()\n    .setHeaderName(\"Contact Info\")\n    .setChildren(List.of(\n        new AgGridColumnDef&lt;&gt;(\"email\", \"Email\"),\n        new AgGridColumnDef&lt;&gt;(\"phone\", \"Phone\")\n    ))\n    .setMarryChildren(true);", "java"),
                            new PluginEntry.ExampleSnippet("Grouped &amp; Aggregated", "Group by country with sum aggregation",
                                    "new AgGridColumnDef&lt;&gt;(\"country\", \"Country\")\n    .setRowGroup(true)\n    .setRowGroupIndex(0);\n\nnew AgGridColumnDef&lt;&gt;(\"revenue\", \"Revenue\")\n    .setAggFunc(\"sum\")\n    .setValueFormatter(\"params =&gt; '$' + params.value\");", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("AgGridColumnDef()", "Creates an empty column definition"),
                            new PluginEntry.ConstructorInfo("AgGridColumnDef(String field)", "Creates a column with field name (headerName defaults to field)"),
                            new PluginEntry.ConstructorInfo("AgGridColumnDef(String field, String headerName)", "Creates a column with field and display header")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setField", "J", "setField(String field)", "Sets the data field binding"),
                            new PluginEntry.MethodInfo("setHeaderName", "J", "setHeaderName(String headerName)", "Sets the column header text"),
                            new PluginEntry.MethodInfo("setWidth", "J", "setWidth(Integer width)", "Sets fixed width in pixels"),
                            new PluginEntry.MethodInfo("setFlex", "J", "setFlex(Integer flex)", "Sets flex sizing weight"),
                            new PluginEntry.MethodInfo("setMinWidth", "J", "setMinWidth(Integer minWidth)", "Sets minimum width"),
                            new PluginEntry.MethodInfo("setMaxWidth", "J", "setMaxWidth(Integer maxWidth)", "Sets maximum width"),
                            new PluginEntry.MethodInfo("setSortable", "J", "setSortable(Boolean sortable)", "Enables/disables sorting"),
                            new PluginEntry.MethodInfo("setSort", "J", "setSort(String sort)", "Sets initial sort: 'asc' or 'desc'"),
                            new PluginEntry.MethodInfo("setFilter", "J", "setFilter(Object filter)", "Sets filter type (Boolean, String key, or Object)"),
                            new PluginEntry.MethodInfo("useMultiFilter", "J", "useMultiFilter()", "Convenience: uses agMultiColumnFilter"),
                            new PluginEntry.MethodInfo("setFilterParams", "J", "setFilterParams(IFilterParams&lt;?&gt; filterParams)", "Sets filter parameters"),
                            new PluginEntry.MethodInfo("setResizable", "J", "setResizable(Boolean resizable)", "Enables/disables column resizing"),
                            new PluginEntry.MethodInfo("setEditable", "J", "setEditable(Boolean editable)", "Enables/disables cell editing"),
                            new PluginEntry.MethodInfo("setPinned", "J", "setPinned(String pinned)", "Pins column: 'left' or 'right'"),
                            new PluginEntry.MethodInfo("setHide", "J", "setHide(Boolean hide)", "Shows/hides the column"),
                            new PluginEntry.MethodInfo("setCheckboxSelection", "J", "setCheckboxSelection(Boolean checkboxSelection)", "Enables row selection checkbox"),
                            new PluginEntry.MethodInfo("setHeaderCheckboxSelection", "J", "setHeaderCheckboxSelection(Boolean headerCheckboxSelection)", "Enables select-all checkbox in header"),
                            new PluginEntry.MethodInfo("setCellRenderer", "J", "setCellRenderer(ICellRenderer&lt;?&gt; cellRenderer)", "Sets the Angular cell renderer"),
                            new PluginEntry.MethodInfo("setCellStyle", "J", "setCellStyle(Object cellStyle)", "Sets cell CSS styles"),
                            new PluginEntry.MethodInfo("setCellClass", "J", "setCellClass(String cellClass)", "Sets cell CSS class"),
                            new PluginEntry.MethodInfo("setValueFormatter", "J", "setValueFormatter(String valueFormatterRaw)", "Sets raw JS value formatter function"),
                            new PluginEntry.MethodInfo("setValueGetterExpression", "J", "setValueGetterExpression(String expression)", "Sets a string value getter expression"),
                            new PluginEntry.MethodInfo("setValueGetterRaw", "J", "setValueGetterRaw(String rawJsFunction)", "Sets a raw JS value getter function"),
                            new PluginEntry.MethodInfo("setAggFunc", "J", "setAggFunc(String aggFunc)", "Sets aggregation: 'sum', 'min', 'max', 'avg', 'count'"),
                            new PluginEntry.MethodInfo("setRowGroup", "J", "setRowGroup(Boolean rowGroup)", "Enables row grouping on this column"),
                            new PluginEntry.MethodInfo("setRowGroupIndex", "J", "setRowGroupIndex(Integer rowGroupIndex)", "Sets multi-group ordering"),
                            new PluginEntry.MethodInfo("setPivot", "J", "setPivot(Boolean pivot)", "Enables pivot on this column"),
                            new PluginEntry.MethodInfo("setChildren", "J", "setChildren(List&lt;AgGridColumnDef&lt;?&gt;&gt; children)", "Sets child columns for a column group"),
                            new PluginEntry.MethodInfo("setHeaderComponent", "J", "setHeaderComponent(DefaultHeaderComponent&lt;?&gt; headerComponent)", "Sets a custom Angular header component"),
                            new PluginEntry.MethodInfo("setChartDataType", "J", "setChartDataType(ChartDataType chartDataType)", "Sets chart type: CATEGORY, SERIES, TIME, EXCLUDED")
                    ),
                    List.of(), List.of(),
                    List.of("JavaScriptPart")),

            new PluginEntry.ComponentInfo("AgGridOptions", "Grid options using modular @JsonUnwrapped composition — groups options into specialized sub-objects that flatten to a single JSON output", "com.jwebmp.plugins.aggrid",
                    List.of(
                            new PluginEntry.PropertyInfo("animateRows", "Boolean", "null", "Rendering — enables row animation on sort/filter changes"),
                            new PluginEntry.PropertyInfo("cellFlashDuration", "Integer", "null", "Rendering — ms a cell stays in flashed state after value change"),
                            new PluginEntry.PropertyInfo("cellFadeDuration", "Integer", "null", "Rendering — ms for the flash fade-out effect"),
                            new PluginEntry.PropertyInfo("allowShowChangeAfterFilter", "Boolean", "null", "Rendering — allow cells to flash after filtering"),
                            new PluginEntry.PropertyInfo("suppressColumnVirtualisation", "Boolean", "null", "Rendering — disables column virtualisation"),
                            new PluginEntry.PropertyInfo("suppressRowVirtualisation", "Boolean", "null", "Rendering — disables row virtualisation"),
                            new PluginEntry.PropertyInfo("suppressRowHoverHighlight", "Boolean", "null", "Rendering — disables row hover highlighting"),
                            new PluginEntry.PropertyInfo("suppressHorizontalScroll", "Boolean", "null", "Rendering — disables horizontal scrolling"),
                            new PluginEntry.PropertyInfo("suppressTabbing", "Boolean", "null", "Rendering — disables Tab key navigation"),
                            new PluginEntry.PropertyInfo("suppressScrollOnNewData", "Boolean", "null", "Rendering — prevents scroll reset on new data"),
                            new PluginEntry.PropertyInfo("suppressAnimationFrame", "Boolean", "null", "Rendering — disables animation frame rendering"),
                            new PluginEntry.PropertyInfo("pagination", "Boolean", "null", "Pagination — enables/disables pagination"),
                            new PluginEntry.PropertyInfo("paginationPageSize", "Integer", "null", "Pagination — rows per page"),
                            new PluginEntry.PropertyInfo("paginationPageSizeSelector", "Object", "null", "Pagination — page size selector options"),
                            new PluginEntry.PropertyInfo("suppressPaginationPanel", "Boolean", "null", "Pagination — hides the pagination panel"),
                            new PluginEntry.PropertyInfo("suppressColumnMoveAnimation", "Boolean", "null", "Column Mgmt — disables column move animation"),
                            new PluginEntry.PropertyInfo("suppressMenuHide", "Boolean", "null", "Column Mgmt — always shows column menu button"),
                            new PluginEntry.PropertyInfo("suppressMoveWhenColumnDragging", "Boolean", "null", "Column Mgmt — prevents column reorder on drag"),
                            new PluginEntry.PropertyInfo("suppressDragColumnIntoGroup", "Boolean", "null", "Column Mgmt — prevents dragging columns into groups"),
                            new PluginEntry.PropertyInfo("suppressRowClickSelection", "Boolean", "null", "Column Mgmt — disables row selection on click"),
                            new PluginEntry.PropertyInfo("suppressCellClickSelection", "Boolean", "null", "Column Mgmt — disables cell selection on click"),
                            new PluginEntry.PropertyInfo("suppressClipboardPaste", "Boolean", "null", "Column Mgmt — disables clipboard paste"),
                            new PluginEntry.PropertyInfo("suppressCutOnKey", "Boolean", "null", "Column Mgmt — disables Ctrl+X cut"),
                            new PluginEntry.PropertyInfo("headerHeight", "Integer", "null", "Header Sizing — header row height in pixels"),
                            new PluginEntry.PropertyInfo("groupHeaderHeight", "Integer", "null", "Header Sizing — group header row height"),
                            new PluginEntry.PropertyInfo("floatingFiltersHeight", "Integer", "null", "Header Sizing — floating filter row height"),
                            new PluginEntry.PropertyInfo("rowHeight", "Integer", "null", "Header Sizing — data row height"),
                            new PluginEntry.PropertyInfo("pivotHeaderHeight", "Integer", "null", "Header Sizing — pivot header height"),
                            new PluginEntry.PropertyInfo("autoHeaderHeight", "Boolean", "null", "Header Sizing — auto-adjusts header height"),
                            new PluginEntry.PropertyInfo("singleClickEdit", "Boolean", "null", "Editing — enables single-click editing"),
                            new PluginEntry.PropertyInfo("suppressClickEdit", "Boolean", "null", "Editing — disables click-to-edit"),
                            new PluginEntry.PropertyInfo("stopEditingWhenCellsLoseFocus", "Boolean", "null", "Editing — stops editing on cell blur"),
                            new PluginEntry.PropertyInfo("stopEditingWhenGridLosesFocus", "Boolean", "null", "Editing — stops editing when grid loses focus"),
                            new PluginEntry.PropertyInfo("enterMovesDown", "Boolean", "null", "Editing — Enter key moves focus down"),
                            new PluginEntry.PropertyInfo("enterMovesDownAfterEdit", "Boolean", "null", "Editing — Enter moves down after edit completes"),
                            new PluginEntry.PropertyInfo("quickFilterText", "String", "null", "Filtering — text for the quick filter"),
                            new PluginEntry.PropertyInfo("floatingFilter", "Boolean", "null", "Filtering — enables floating filter row"),
                            new PluginEntry.PropertyInfo("caseInsensitiveSort", "Boolean", "null", "Filtering — enables case-insensitive sorting"),
                            new PluginEntry.PropertyInfo("enableRtl", "Boolean", "null", "Filtering — enables right-to-left layout"),
                            new PluginEntry.PropertyInfo("suppressExcelExport", "Boolean", "null", "Export — disables Excel export"),
                            new PluginEntry.PropertyInfo("suppressCsvExport", "Boolean", "null", "Export — disables CSV export"),
                            new PluginEntry.PropertyInfo("columnSeparator", "String", "null", "Export — column separator for CSV"),
                            new PluginEntry.PropertyInfo("rowSelection", "RowSelectionMode", "null", "Selection — singleRow or multiRow"),
                            new PluginEntry.PropertyInfo("rowMultiSelectWithClick", "Boolean", "null", "Selection — select multiple with click"),
                            new PluginEntry.PropertyInfo("suppressRowDeselection", "Boolean", "null", "Selection — prevents deselecting rows"),
                            new PluginEntry.PropertyInfo("suppressMultiSort", "Boolean", "null", "Selection — disables multi-column sort"),
                            new PluginEntry.PropertyInfo("cellSelection", "CellSelectionMode", "null", "Selection — cell or row selection mode"),
                            new PluginEntry.PropertyInfo("enableAdvancedFilter", "Boolean", "null", "Advanced Filter — enables the advanced filter UI"),
                            new PluginEntry.PropertyInfo("rowGroupPanelShow", "String", "null", "Row Grouping — 'always', 'onlyWhenGrouping', or 'never'"),
                            new PluginEntry.PropertyInfo("groupDisplayType", "String", "null", "Row Grouping — 'singleColumn', 'multipleColumns', 'groupRows', 'custom'"),
                            new PluginEntry.PropertyInfo("pivotMode", "Boolean", "null", "Row Pivoting — enables pivot mode"),
                            new PluginEntry.PropertyInfo("pivotPanelShow", "String", "null", "Row Pivoting — 'always', 'onlyWhenPivoting', or 'never'"),
                            new PluginEntry.PropertyInfo("treeData", "Boolean", "null", "Tree Data — enables hierarchical tree data mode"),
                            new PluginEntry.PropertyInfo("serverSideDatasource", "String", "null", "Server-Side — datasource for server-side row model"),
                            new PluginEntry.PropertyInfo("cacheBlockSize", "Integer", "null", "Server-Side — rows per cache block"),
                            new PluginEntry.PropertyInfo("maxBlocksInCache", "Integer", "null", "Server-Side — max blocks retained in cache"),
                            new PluginEntry.PropertyInfo("domLayout", "DomLayoutType", "null", "Layout — 'normal', 'autoHeight', or 'print'"),
                            new PluginEntry.PropertyInfo("editType", "EditType", "null", "Editing — 'fullRow' for full-row editing"),
                            new PluginEntry.PropertyInfo("defaultColDef", "AgGridColumnDef&lt;?&gt;", "null", "Default column definition applied to all columns"),
                            new PluginEntry.PropertyInfo("columnDefs", "List&lt;AgGridColumnDef&lt;?&gt;&gt;", "empty", "Column definitions (used by template, @JsonIgnore)"),
                            new PluginEntry.PropertyInfo("rowData", "Object", "null", "Row data (used by template, @JsonIgnore)"),
                            new PluginEntry.PropertyInfo("rowDataRaw", "String", "null", "Raw Angular expression for [rowData] binding")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Modular Options", "Configure features using the fluent modular API",
                                    "AgGridOptions&lt;?&gt; options = new AgGridOptions&lt;&gt;();\noptions.configureRendering()\n    .setAnimateRows(true)\n    .setCellFlashDuration(500);\noptions.configurePagination()\n    .setPagination(true)\n    .setPaginationPageSize(50);\noptions.configureEditing()\n    .setSingleClickEdit(true)\n    .setStopEditingWhenCellsLoseFocus(true);", "java"),
                            new PluginEntry.ExampleSnippet("Selection &amp; Filtering", "Enable row selection with quick filter",
                                    "AgGridOptions&lt;?&gt; options = new AgGridOptions&lt;&gt;();\noptions.configureSelection()\n    .setRowSelection(RowSelectionMode.multiRow)\n    .setRowMultiSelectWithClick(true);\noptions.configureFiltering()\n    .setQuickFilterText(\"search term\")\n    .setFloatingFilter(true);", "java"),
                            new PluginEntry.ExampleSnippet("Row Grouping &amp; Aggregation", "Configure enterprise row grouping",
                                    "AgGridOptions&lt;?&gt; options = new AgGridOptions&lt;&gt;();\noptions.configureRowGrouping()\n    .setRowGroupPanelShow(\"always\")\n    .setGroupDisplayType(\"multipleColumns\");\noptions.configureRowPivoting()\n    .setPivotMode(true)\n    .setPivotPanelShow(\"always\");", "java"),
                            new PluginEntry.ExampleSnippet("Server-Side Row Model", "Configure server-side data loading",
                                    "AgGridOptions&lt;?&gt; options = new AgGridOptions&lt;&gt;();\noptions.configureServerSideRowModel()\n    .setServerSideDatasource(\"myDatasource\")\n    .setCacheBlockSize(100)\n    .setMaxBlocksInCache(10);", "java"),
                            new PluginEntry.ExampleSnippet("Tree Data", "Enable hierarchical tree data",
                                    "AgGridOptions&lt;?&gt; options = new AgGridOptions&lt;&gt;();\noptions.setTreeData(true);\noptions.setGetDataPathRaw(\"(data) =&gt; data.path\");", "java"),
                            new PluginEntry.ExampleSnippet("Export Configuration", "Suppress specific export types",
                                    "AgGridOptions&lt;?&gt; options = new AgGridOptions&lt;&gt;();\noptions.configureExport()\n    .setSuppressExcelExport(false)\n    .setSuppressCsvExport(false)\n    .setColumnSeparator(\";\");", "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("AgGridOptions()", "Creates grid options with all modular sub-option objects initialized")),
                    List.of(
                            new PluginEntry.MethodInfo("configureRendering", "RenderingOptions", "configureRendering()", "Returns the rendering options for fluent configuration"),
                            new PluginEntry.MethodInfo("configurePagination", "PaginationOptions", "configurePagination()", "Returns the pagination options for fluent configuration"),
                            new PluginEntry.MethodInfo("configureColumnManagement", "ColumnManagementOptions", "configureColumnManagement()", "Returns the column management options"),
                            new PluginEntry.MethodInfo("configureHeaderSizing", "HeaderSizingOptions", "configureHeaderSizing()", "Returns the header sizing options"),
                            new PluginEntry.MethodInfo("configureEditing", "EditingOptions", "configureEditing()", "Returns the editing options"),
                            new PluginEntry.MethodInfo("configureFiltering", "FilteringOptions", "configureFiltering()", "Returns the filtering options"),
                            new PluginEntry.MethodInfo("configureExport", "ExportOptions", "configureExport()", "Returns the export options"),
                            new PluginEntry.MethodInfo("configureSelection", "SelectionOptionsExpanded", "configureSelection()", "Returns the selection options"),
                            new PluginEntry.MethodInfo("configureRowGrouping", "RowGroupingOptions", "configureRowGrouping()", "Returns the row grouping options"),
                            new PluginEntry.MethodInfo("configureRowPivoting", "RowPivotingOptions", "configureRowPivoting()", "Returns the row pivoting options"),
                            new PluginEntry.MethodInfo("configureServerSideRowModel", "ServerSideRowModelOptions", "configureServerSideRowModel()", "Returns server-side row model options"),
                            new PluginEntry.MethodInfo("configureAdvancedFilter", "AdvancedFilterOptions", "configureAdvancedFilter()", "Returns advanced filter options"),
                            new PluginEntry.MethodInfo("configureTreeData", "TreeDataOptions", "configureTreeData()", "Returns tree data options"),
                            new PluginEntry.MethodInfo("configureGridState", "GridStateOptions", "configureGridState()", "Returns grid state options"),
                            new PluginEntry.MethodInfo("setDomLayout", "J", "setDomLayout(DomLayoutType domLayout)", "Sets DOM layout: normal, autoHeight, or print"),
                            new PluginEntry.MethodInfo("setEditType", "J", "setEditType(EditType editType)", "Sets edit type for full-row editing"),
                            new PluginEntry.MethodInfo("setCellSelection", "J", "setCellSelection(CellSelectionMode cellSelection)", "Sets cell selection mode"),
                            new PluginEntry.MethodInfo("setTreeData", "J", "setTreeData(Boolean treeData)", "Enables/disables tree data mode"),
                            new PluginEntry.MethodInfo("setGetDataPathRaw", "J", "setGetDataPathRaw(String getDataPathRawJs)", "Sets the getDataPath JS callback for tree data"),
                            new PluginEntry.MethodInfo("setDefaultColDef", "J", "setDefaultColDef(AgGridColumnDef&lt;?&gt; defaultColDef)", "Sets the default column definition"),
                            new PluginEntry.MethodInfo("setInitialFilterModel", "J", "setInitialFilterModel(Map&lt;String, Object&gt; filterModel)", "Sets the initial filter model via grid state")
                    ),
                    List.of(), List.of(),
                    List.of("JavaScriptPart"))
    );

    public AgGridPluginPage()
    {
        super(PluginCatalog.getById("aggrid").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Define a Data Grid",
                        "Create a grid with pagination, row selection, and typed column definitions.",
                        "public class OrderGrid extends AgGrid<OrderGrid> {\n    public OrderGrid() {\n        setHeight(\"600px\")\n            .enablePagination(25)\n            .enableRowSelection(\"multiple\");\n\n        addColumn(new AgGridColumnDef()\n            .setField(\"orderId\")\n            .setHeaderName(\"Order ID\")\n            .setWidth(100));\n\n        addColumn(new AgGridColumnDef()\n            .setField(\"total\")\n            .setHeaderName(\"Total\")\n            .setCellDataType(\"number\"));\n    }\n}",
                        "java"),
                new PluginEntry.ExampleSnippet("Modular Options Composition",
                        "Configure grid features using the @JsonUnwrapped modular pattern.",
                        "AgGridOptions<?> options = new AgGridOptions<>();\noptions.configureRendering()\n    .setAnimateRows(true)\n    .setCellFlashDuration(500);\noptions.configurePagination()\n    .setPagination(true)\n    .setPaginationPageSize(50);",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "AgGridPageConfigurator auto-registers AllCommunityModule and ag-grid CSS/JS")
        );
    }
}
