package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-agcharts")
@NgRoutable(path = "plugins/agcharts")
public class AgChartsPluginPage extends PluginDetailPage<AgChartsPluginPage>
{
    public AgChartsPluginPage()
    {
        super(PluginCatalog.getById("agcharts").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Line Chart",
                        "Create a line chart with axes and series.",
                        "@NgComponent\npublic class SalesChart implements INgComponent<SalesChart> {\n    public AgChartOptions<SalesChart> getOptions() {\n        return new AgChartOptions<>(this)\n            .setSeries(List.of(\n                new AgLineSeriesOptions<>()\n                    .setXKey(\"month\")\n                    .setYKey(\"sales\")\n                    .setYName(\"Sales\")\n            ))\n            .setAxes(List.of(\n                new AgCategoryAxisOptions<>()\n                    .setPosition(AgCartesianAxisPosition.BOTTOM),\n                new AgNumberAxisOptions<>()\n                    .setPosition(AgCartesianAxisPosition.LEFT)\n            ));\n    }\n}",
                        "java"),
                new PluginEntry.ExampleSnippet("Pie Chart",
                        "Create a pie chart with themed colors.",
                        "var chart = new AgPieChart<>();\nchart.getOptions()\n    .setSeries(List.of(\n        new AgPieSeriesOptions<>()\n            .setAngleKey(\"value\")\n            .setLegendItemKey(\"label\")\n    ));",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "AgChartsPageConfigurator auto-registers ag-charts-community and Angular integration")
        );
    }
}
