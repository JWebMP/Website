package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-aggrid-ent")
@NgRoutable(path = "plugins/aggrid-enterprise")
public class AgGridEnterprisePluginPage extends PluginDetailPage<AgGridEnterprisePluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("AgGridEnterpriseOptions", "Enterprise grid options extending AgGridOptions with 8 modular enterprise feature modules — charts, SSRM, aggregation, pivoting, advanced filtering, sidebar/statusbar, range selection, and row grouping", "com.jwebmp.plugins.aggridenterprise",
                    List.of(
                            new PluginEntry.PropertyInfo("charts", "ChartsOptions&lt;?&gt;", "new ChartsOptions&lt;&gt;()", "Integrated Charts — enableCharts, chartThemes, suppressChartToolPanelsButton, chartToolPanelsDef"),
                            new PluginEntry.PropertyInfo("serverSideRowModel", "ServerSideRowModelOptions&lt;?&gt;", "new ServerSideRowModelOptions&lt;&gt;()", "Server-Side Row Model — serverSideDatasource, cacheBlockSize, suppressServerSideInfiniteScroll"),
                            new PluginEntry.PropertyInfo("aggregation", "AggregationOptions&lt;?&gt;", "new AggregationOptions&lt;&gt;()", "Aggregation — aggFuncs, aggregateOnlyChangedColumns, groupAggFiltering"),
                            new PluginEntry.PropertyInfo("pivoting", "PivotingOptions&lt;?&gt;", "new PivotingOptions&lt;&gt;()", "Pivot Mode — pivotMode, pivotRowTotals, processPivotResultColDef"),
                            new PluginEntry.PropertyInfo("advancedFiltering", "AdvancedFilteringOptions&lt;?&gt;", "new AdvancedFilteringOptions&lt;&gt;()", "Advanced Filtering — advanced filter builder and cell selection options"),
                            new PluginEntry.PropertyInfo("sideBarAndStatusBar", "SideBarAndStatusBarOptions&lt;?&gt;", "new SideBarAndStatusBarOptions&lt;&gt;()", "SideBar &amp; StatusBar — sideBar, statusBar, allowDragFromColumnsToolPanel"),
                            new PluginEntry.PropertyInfo("rangeSelection", "RangeSelectionOptions&lt;?&gt;", "new RangeSelectionOptions&lt;&gt;()", "Range Selection — enableRangeSelection"),
                            new PluginEntry.PropertyInfo("defaultColDef", "AgGridEnterpriseColumnDef&lt;?&gt;", "null", "Default column definition — auto-creates AgGridEnterpriseColumnDef when accessed")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Enterprise Modular Options", "Configure enterprise features using modular accessors",
                                    "AgGridEnterpriseOptions&lt;?&gt; options = new AgGridEnterpriseOptions&lt;&gt;();\noptions.configureCharts()\n    .setEnableCharts(true)\n    .setChartThemes(List.of(\"ag-default\", \"ag-material\"));\noptions.configureAggregation()\n    .setAggregateOnlyChangedColumns(true);\noptions.configurePivoting()\n    .setPivotMode(true);", "java"),
                            new PluginEntry.ExampleSnippet("Server-Side Row Model", "Configure SSRM for large datasets",
                                    "AgGridEnterpriseOptions&lt;?&gt; options = new AgGridEnterpriseOptions&lt;&gt;();\noptions.serverSideRowModelOptions()\n    .setServerSideDatasource(\"myDatasource\")\n    .setCacheBlockSize(100);", "java"),
                            new PluginEntry.ExampleSnippet("SideBar &amp; Range Selection", "Enable the sidebar tool panels and range selection",
                                    "AgGridEnterpriseOptions&lt;?&gt; options = new AgGridEnterpriseOptions&lt;&gt;();\noptions.configureSideBarAndStatusBar()\n    .setSideBar(true);\noptions.configureRangeSelection()\n    .setEnableRangeSelection(true);", "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("AgGridEnterpriseOptions()", "Creates enterprise grid options with all 8 modular components initialized")),
                    List.of(
                            new PluginEntry.MethodInfo("configureCharts", "ChartsOptions&lt;?&gt;", "configureCharts()", "Returns the charts options module for fluent configuration"),
                            new PluginEntry.MethodInfo("serverSideRowModelOptions", "ServerSideRowModelOptions&lt;?&gt;", "serverSideRowModelOptions()", "Returns the server-side row model options module"),
                            new PluginEntry.MethodInfo("configureAggregation", "AggregationOptions&lt;?&gt;", "configureAggregation()", "Returns the aggregation options module"),
                            new PluginEntry.MethodInfo("configurePivoting", "PivotingOptions&lt;?&gt;", "configurePivoting()", "Returns the pivoting options module"),
                            new PluginEntry.MethodInfo("configureAdvancedFiltering", "AdvancedFilteringOptions&lt;?&gt;", "configureAdvancedFiltering()", "Returns the advanced filtering options module"),
                            new PluginEntry.MethodInfo("configureSideBarAndStatusBar", "SideBarAndStatusBarOptions&lt;?&gt;", "configureSideBarAndStatusBar()", "Returns the sidebar and statusbar options module"),
                            new PluginEntry.MethodInfo("configureRangeSelection", "RangeSelectionOptions&lt;?&gt;", "configureRangeSelection()", "Returns the range selection options module"),
                            new PluginEntry.MethodInfo("getDefaultColDef", "AgGridEnterpriseColumnDef&lt;?&gt;", "getDefaultColDef()", "Returns the default column def as an enterprise column def (auto-creates if null)")
                    ),
                    List.of(), List.of(),
                    List.of("AgGridOptions")),

            new PluginEntry.ComponentInfo("AgGridEnterpriseColumnDef", "Enterprise column definition extending AgGridColumnDef with aggregation, grouping, pivot, and cell data type properties", "com.jwebmp.plugins.aggridenterprise",
                    List.of(
                            new PluginEntry.PropertyInfo("initialAggFunc", "Object", "null", "Aggregation function applied only when creating a new column"),
                            new PluginEntry.PropertyInfo("enableValue", "Boolean", "null", "Allow aggregation on this column via the GUI"),
                            new PluginEntry.PropertyInfo("enableRowGroup", "Boolean", "null", "Allow row grouping on this column via the GUI"),
                            new PluginEntry.PropertyInfo("cellDataType", "Object", "null", "Cell data type: 'text', 'number', 'boolean', 'date', etc. or false to disable"),
                            new PluginEntry.PropertyInfo("allowedAggFuncs", "List&lt;String&gt;", "null", "Aggregation functions allowed on this column e.g. ['sum', 'avg']"),
                            new PluginEntry.PropertyInfo("defaultAggFunc", "String", "null", "Default aggregation function for this column"),
                            new PluginEntry.PropertyInfo("groupTotalRow", "Object", "null", "Position for group total row: 'top' or 'bottom'"),
                            new PluginEntry.PropertyInfo("grandTotalRow", "Object", "null", "Position for grand total row: 'top', 'bottom', 'pinnedTop', 'pinnedBottom'"),
                            new PluginEntry.PropertyInfo("suppressAggFuncInHeader", "Boolean", "null", "When true, column headers won't include the aggFunc name"),
                            new PluginEntry.PropertyInfo("aggregateOnlyChangedColumns", "Boolean", "null", "Only re-aggregate updated columns on change detection"),
                            new PluginEntry.PropertyInfo("suppressAggFilteredOnly", "Boolean", "null", "Aggregations are not impacted by filtering"),
                            new PluginEntry.PropertyInfo("groupAggFiltering", "Object", "null", "Whether filters apply on aggregated group values"),
                            new PluginEntry.PropertyInfo("groupSuppressBlankHeader", "Boolean", "null", "Display aggregate data at both header and footer levels"),
                            new PluginEntry.PropertyInfo("suppressStickyTotalRow", "Object", "null", "Suppress sticky behaviour of total rows: true, 'grand', or 'group'"),
                            new PluginEntry.PropertyInfo("alwaysAggregateAtRootLevel", "Boolean", "null", "Always calculate root level aggregation value"),
                            new PluginEntry.PropertyInfo("getGroupRowAgg", "String", "null", "Raw JS function for custom group row aggregation")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Enterprise Column with Aggregation", "Create a column with sum aggregation and allowed functions",
                                    "new AgGridEnterpriseColumnDef&lt;&gt;(\"revenue\", \"Revenue\")\n    .setAggFunc(AgGridEnterpriseColumnDef.AggFunc.SUM)\n    .setAllowedAggFuncs(AgGridEnterpriseColumnDef.AggFunc.SUM, AgGridEnterpriseColumnDef.AggFunc.AVG)\n    .setEnableValue(true)\n    .setCellDataType(AgGridEnterpriseColumnDef.CellDataType.NUMBER);", "java"),
                            new PluginEntry.ExampleSnippet("Groupable Column", "Enable row grouping via GUI for a column",
                                    "new AgGridEnterpriseColumnDef&lt;&gt;(\"country\", \"Country\")\n    .setEnableRowGroup(true)\n    .setRowGroup(true)\n    .setRowGroupIndex(0);", "java"),
                            new PluginEntry.ExampleSnippet("Group Total Rows", "Add group and grand total rows",
                                    "new AgGridEnterpriseColumnDef&lt;&gt;(\"amount\", \"Amount\")\n    .setAggFunc(AgGridEnterpriseColumnDef.AggFunc.SUM)\n    .setGroupTotalRow(AgGridEnterpriseColumnDef.GroupTotalRowPosition.BOTTOM)\n    .setGrandTotalRow(AgGridEnterpriseColumnDef.GrandTotalRowPosition.PINNED_BOTTOM);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("AgGridEnterpriseColumnDef()", "Creates an empty enterprise column definition"),
                            new PluginEntry.ConstructorInfo("AgGridEnterpriseColumnDef(String field)", "Creates an enterprise column with field name"),
                            new PluginEntry.ConstructorInfo("AgGridEnterpriseColumnDef(String field, String headerName)", "Creates an enterprise column with field and header")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setAggFunc", "J", "setAggFunc(AggFunc aggFunc)", "Sets the aggregation function using the type-safe enum"),
                            new PluginEntry.MethodInfo("setInitialAggFunc", "J", "setInitialAggFunc(AggFunc initial)", "Sets the initial aggregation function"),
                            new PluginEntry.MethodInfo("setEnableValue", "J", "setEnableValue(Boolean enableValue)", "Enables aggregation via the GUI"),
                            new PluginEntry.MethodInfo("setEnableRowGroup", "J", "setEnableRowGroup(Boolean enableRowGroup)", "Enables row grouping via the GUI"),
                            new PluginEntry.MethodInfo("setCellDataType", "J", "setCellDataType(CellDataType type)", "Sets the built-in cell data type"),
                            new PluginEntry.MethodInfo("disableCellDataTypeInference", "J", "disableCellDataTypeInference()", "Disables automatic cell data type inference"),
                            new PluginEntry.MethodInfo("setAllowedAggFuncs", "J", "setAllowedAggFuncs(AggFunc... funcs)", "Sets allowed aggregation functions using varargs"),
                            new PluginEntry.MethodInfo("setDefaultAggFunc", "J", "setDefaultAggFunc(AggFunc defaultAggFunc)", "Sets the default aggregation function"),
                            new PluginEntry.MethodInfo("setGroupTotalRow", "J", "setGroupTotalRow(GroupTotalRowPosition pos)", "Sets group total row position"),
                            new PluginEntry.MethodInfo("setGrandTotalRow", "J", "setGrandTotalRow(GrandTotalRowPosition pos)", "Sets grand total row position"),
                            new PluginEntry.MethodInfo("setSuppressAggFuncInHeader", "J", "setSuppressAggFuncInHeader(Boolean suppress)", "Suppresses agg function name in header"),
                            new PluginEntry.MethodInfo("setSuppressStickyTotalRow", "J", "setSuppressStickyTotalRow(StickyTotalRowSuppression which)", "Suppresses sticky total row by type"),
                            new PluginEntry.MethodInfo("setGetGroupRowAgg", "J", "setGetGroupRowAgg(String rawJs)", "Sets a raw JS function for custom group row aggregation")
                    ),
                    List.of(), List.of(),
                    List.of("AgGridColumnDef"))
    );

    public AgGridEnterprisePluginPage()
    {
        super(PluginCatalog.getById("aggrid-enterprise").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Enterprise Grid Setup",
                        "Set license key and configure enterprise features.",
                        "// Set license key at startup\nAgGridEnterprisePageConfigurator\n    .setAG_GRID_LICENSE_KEY(\"YOUR_LICENSE_KEY\");\n\n// Server-side row model (millions of rows)\ngridOptions.setRowModelType(RowModelType.SERVER_SIDE)\n    .setServerSideInitialRowCount(1000);\n\n// Row grouping and aggregation\ngridOptions.setRowGroupPanelShow(RowGroupPanelShow.ALWAYS)\n    .addRowGroupColumn(\"region\")\n    .addValueColumn(\"revenue\");",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "AgGridEnterprisePageConfigurator auto-registers AllEnterpriseModule, license key, and enterprise CSS/JS")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("AG_GRID_LICENSE_KEY", "String", null, "AG Grid Enterprise license key — set via AgGridEnterprisePageConfigurator.setAG_GRID_LICENSE_KEY()")
        );
    }
}
