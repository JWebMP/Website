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
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("AgChart", "Abstract base AG Charts component — renders ag-charts-angular with WebSocket-driven options and data channels",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("id", "String", null, "Unique chart identifier used for WebSocket listener names"),
                            new PluginEntry.PropertyInfo("chartOptions", "AgChartOptions", null, "Root options object sent to ag-charts-angular [options]")
                    ), null, List.of(
                    new PluginEntry.ConstructorInfo("AgChart(String id)", "Creates a chart bound to the given id")
            ), List.of(
                    new PluginEntry.MethodInfo("getInitialOptions", "Uni&lt;AgChartOptions&gt;", "getInitialOptions(AjaxCall, AjaxResponse)", "Returns the initial chart options reactively"),
                    new PluginEntry.MethodInfo("getInitialData", "Uni&lt;Object&gt;", "getInitialData(AjaxCall, AjaxResponse)", "Returns optional initial data payload reactively")
            ), null, null, null),

            new PluginEntry.ComponentInfo("AgBarChart", "Convenience bar chart with a single bar series",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("xKey", "String", null, "Data key for x-axis values"),
                            new PluginEntry.PropertyInfo("yKey", "String", null, "Data key for y-axis values"),
                            new PluginEntry.PropertyInfo("xName", "String", null, "Display name for x-axis"),
                            new PluginEntry.PropertyInfo("yName", "String", null, "Display name for y-axis"),
                            new PluginEntry.PropertyInfo("data", "List&lt;?&gt;", null, "Optional data attached to the series")
                    ), null, List.of(
                    new PluginEntry.ConstructorInfo("AgBarChart(String id, String xKey, String yKey)", "Creates a bar chart with the given id and axis keys")
            ), List.of(
                    new PluginEntry.MethodInfo("setData", "J", "setData(List&lt;?&gt; data)", "Attach data directly to the series"),
                    new PluginEntry.MethodInfo("setXName", "J", "setXName(String xName)", "Set the x-axis display name"),
                    new PluginEntry.MethodInfo("setYName", "J", "setYName(String yName)", "Set the y-axis display name")
            ), null, null, null),

            new PluginEntry.ComponentInfo("AgLineChart", "Convenience line chart with a single line series",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("xKey", "String", null, "Data key for x-axis values"),
                            new PluginEntry.PropertyInfo("yKey", "String", null, "Data key for y-axis values"),
                            new PluginEntry.PropertyInfo("data", "List&lt;?&gt;", null, "Optional data attached to the series")
                    ), null, List.of(
                    new PluginEntry.ConstructorInfo("AgLineChart(String id, String xKey, String yKey)", "Creates a line chart")
            ), null, null, null, null),

            new PluginEntry.ComponentInfo("AgPieChart", "Convenience pie chart component",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("angleKey", "String", null, "Data key for angle/value"),
                            new PluginEntry.PropertyInfo("legendItemKey", "String", null, "Data key for legend labels")
                    ), null, null, null, null, null, null),

            new PluginEntry.ComponentInfo("AgDonutChart", "Convenience donut chart component",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("angleKey", "String", null, "Data key for angle/value"),
                            new PluginEntry.PropertyInfo("legendItemKey", "String", null, "Data key for legend labels")
                    ), null, null, null, null, null, null),

            new PluginEntry.ComponentInfo("AgAreaChart", "Convenience area chart with a single area series",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("xKey", "String", null, "Data key for x-axis values"),
                            new PluginEntry.PropertyInfo("yKey", "String", null, "Data key for y-axis values")
                    ), null, null, null, null, null, null),

            new PluginEntry.ComponentInfo("AgScatterChart", "Convenience scatter chart component",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("xKey", "String", null, "Data key for x-axis values"),
                            new PluginEntry.PropertyInfo("yKey", "String", null, "Data key for y-axis values")
                    ), null, null, null, null, null, null),

            new PluginEntry.ComponentInfo("AgBubbleChart", "Convenience bubble chart component",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("xKey", "String", null, "Data key for x-axis values"),
                            new PluginEntry.PropertyInfo("yKey", "String", null, "Data key for y-axis values"),
                            new PluginEntry.PropertyInfo("sizeKey", "String", null, "Data key for bubble size")
                    ), null, null, null, null, null, null),

            new PluginEntry.ComponentInfo("AgCombinationChart", "Combination chart supporting multiple series types",
                    "com.jwebmp.plugins.agcharts",
                    List.of(
                            new PluginEntry.PropertyInfo("series", "List&lt;AgSeriesBaseOptions&gt;", null, "Multiple series of different types")
                    ), null, null, null, null, null, null),

            new PluginEntry.ComponentInfo("AgChartOptions", "Root chart options for AG Charts 13.0.0 — aggregates axes, series, legend, tooltip, theme, and 16+ modern features",
                    "com.jwebmp.plugins.agcharts.options",
                    List.of(
                            new PluginEntry.PropertyInfo("axes", "AgAxesOptions", null, "Axis configuration"),
                            new PluginEntry.PropertyInfo("series", "List&lt;AgSeriesBaseOptions&gt;", null, "Series definitions"),
                            new PluginEntry.PropertyInfo("legend", "AgChartLegendOptions", null, "Legend configuration"),
                            new PluginEntry.PropertyInfo("tooltip", "AgChartTooltipOptions", null, "Tooltip configuration"),
                            new PluginEntry.PropertyInfo("theme", "AgChartTheme | String", null, "Theme object or built-in theme name"),
                            new PluginEntry.PropertyInfo("title", "AgChartCaptionOptions", null, "Chart title"),
                            new PluginEntry.PropertyInfo("subtitle", "AgChartCaptionOptions", null, "Chart subtitle"),
                            new PluginEntry.PropertyInfo("width", "Integer", null, "Chart width in pixels"),
                            new PluginEntry.PropertyInfo("height", "Integer", null, "Chart height in pixels"),
                            new PluginEntry.PropertyInfo("animation", "AgChartAnimationOptions", null, "Animation settings"),
                            new PluginEntry.PropertyInfo("zoom", "AgChartZoomOptions", null, "Zoom settings"),
                            new PluginEntry.PropertyInfo("highlight", "AgChartHighlightOptions", null, "Highlight settings")
                    ), null, null, null, null, null, null)
    );

    public AgChartsPluginPage()
    {
        super(PluginCatalog.getById("agcharts").orElseThrow());
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
