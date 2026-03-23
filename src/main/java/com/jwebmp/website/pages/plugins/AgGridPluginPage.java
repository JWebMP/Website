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
    public AgGridPluginPage()
    {
        super(PluginCatalog.getById("aggrid").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("AgGrid", "Main grid component with CRTP fluent API", "com.jwebmp.plugins.aggrid"),
                new PluginEntry.ComponentInfo("AgGridColumnDef", "Column definition with field, header, width, cellRenderer, cellDataType", "com.jwebmp.plugins.aggrid"),
                new PluginEntry.ComponentInfo("AgGridOptions", "Grid options with @JsonUnwrapped modular pattern", "com.jwebmp.plugins.aggrid")
        );
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
