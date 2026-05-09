package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-chartjs")
@NgRoutable(path = "plugins/chartjs")
public class ChartJsPluginPage extends PluginDetailPage<ChartJsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("BarChart", "Chart.js bar chart with typed dataset API and configurable axes", "com.jwebmp.plugins.chartjs",
                    List.of(
                            new PluginEntry.PropertyInfo("type", "String", "bar", "The chart type identifier"),
                            new PluginEntry.PropertyInfo("responsive", "boolean", "true", "Automatically resizes to container"),
                            new PluginEntry.PropertyInfo("maintainAspectRatio", "boolean", "true", "Maintains width/height ratio on resize"),
                            new PluginEntry.PropertyInfo("indexAxis", "String", "x", "Axis for index: x for vertical bars, y for horizontal")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Bar Chart", "Create a bar chart with coloured datasets",
                            "BarDataset dataset = new BarDataset()\n    .setLabel(\"Sales\")\n    .setData(65, 59, 80, 81, 56)\n    .addBackgroundColors(Color.RED, Color.GREEN, Color.BLUE)\n    .setBorderWidth(2);\nBarData data = new BarData()\n    .addLabels(\"Mon\", \"Tue\", \"Wed\", \"Thu\", \"Fri\")\n    .addDataset(dataset);\nString json = new BarChart(data).toJson();", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BarChart(BarData data)", "Creates a bar chart with the given data")),
                    List.of(
                            new PluginEntry.MethodInfo("setData", "BarChart", "setData(BarData data)", "Sets the chart data"),
                            new PluginEntry.MethodInfo("setOptions", "BarChart", "setOptions(BarOptions options)", "Sets the chart options"),
                            new PluginEntry.MethodInfo("getOptions", "BarOptions", "getOptions()", "Returns the chart options"),
                            new PluginEntry.MethodInfo("toJson", "String", "toJson()", "Serializes the chart to JSON")
                    ),
                    List.of(), List.of(),
                    List.of("IJsonRepresentation")),

            new PluginEntry.ComponentInfo("LineChart", "Chart.js line chart with point styles, fill, and tension", "com.jwebmp.plugins.chartjs",
                    List.of(
                            new PluginEntry.PropertyInfo("type", "String", "line", "The chart type identifier"),
                            new PluginEntry.PropertyInfo("responsive", "boolean", "true", "Automatically resizes to container"),
                            new PluginEntry.PropertyInfo("fill", "boolean", "false", "Fills area under the line"),
                            new PluginEntry.PropertyInfo("tension", "double", "0.0", "Bezier curve tension (0=straight, 1=curved)")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Line Chart", "Create a line chart with filled area",
                            "LineDataset dataset = new LineDataset()\n    .setLabel(\"Revenue\")\n    .setData(12, 19, 3, 5, 2, 3)\n    .setFill(true)\n    .setTension(0.4)\n    .setBorderColor(Color.BLUE);\nLineData data = new LineData()\n    .addLabels(\"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\", \"Jun\")\n    .addDataset(dataset);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("LineChart(LineData data)", "Creates a line chart with the given data")),
                    List.of(
                            new PluginEntry.MethodInfo("setData", "LineChart", "setData(LineData data)", "Sets the chart data"),
                            new PluginEntry.MethodInfo("setOptions", "LineChart", "setOptions(LineOptions options)", "Sets the chart options"),
                            new PluginEntry.MethodInfo("getOptions", "LineOptions", "getOptions()", "Returns the chart options"),
                            new PluginEntry.MethodInfo("toJson", "String", "toJson()", "Serializes the chart to JSON")
                    ),
                    List.of(), List.of(),
                    List.of("IJsonRepresentation")),

            new PluginEntry.ComponentInfo("PieChart", "Chart.js pie chart with segment customization and legend", "com.jwebmp.plugins.chartjs",
                    List.of(
                            new PluginEntry.PropertyInfo("type", "String", "pie", "The chart type identifier"),
                            new PluginEntry.PropertyInfo("responsive", "boolean", "true", "Automatically resizes to container"),
                            new PluginEntry.PropertyInfo("cutout", "String", "0", "Inner radius cutout (0 for full pie)")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Pie Chart", "Create a pie chart with coloured segments",
                            "PieDataset dataset = new PieDataset()\n    .setData(300, 50, 100)\n    .addBackgroundColors(Color.RED, Color.BLUE, Color.YELLOW);\nPieData data = new PieData()\n    .addLabels(\"Red\", \"Blue\", \"Yellow\")\n    .addDataset(dataset);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("PieChart(PieData data)", "Creates a pie chart with the given data")),
                    List.of(
                            new PluginEntry.MethodInfo("setData", "PieChart", "setData(PieData data)", "Sets the chart data"),
                            new PluginEntry.MethodInfo("setOptions", "PieChart", "setOptions(PieOptions options)", "Sets the chart options"),
                            new PluginEntry.MethodInfo("toJson", "String", "toJson()", "Serializes the chart to JSON")
                    ),
                    List.of(), List.of(),
                    List.of("IJsonRepresentation")),

            new PluginEntry.ComponentInfo("DoughnutChart", "Chart.js doughnut chart with configurable cutout radius", "com.jwebmp.plugins.chartjs",
                    List.of(
                            new PluginEntry.PropertyInfo("type", "String", "doughnut", "The chart type identifier"),
                            new PluginEntry.PropertyInfo("responsive", "boolean", "true", "Automatically resizes to container"),
                            new PluginEntry.PropertyInfo("cutout", "String", "50%", "Inner radius cutout percentage")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Doughnut Chart", "Create a doughnut chart",
                            "DoughnutDataset dataset = new DoughnutDataset()\n    .setData(40, 30, 20, 10)\n    .addBackgroundColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);\nDoughnutData data = new DoughnutData()\n    .addLabels(\"Q1\", \"Q2\", \"Q3\", \"Q4\")\n    .addDataset(dataset);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("DoughnutChart(DoughnutData data)", "Creates a doughnut chart with the given data")),
                    List.of(
                            new PluginEntry.MethodInfo("setData", "DoughnutChart", "setData(DoughnutData data)", "Sets the chart data"),
                            new PluginEntry.MethodInfo("setOptions", "DoughnutChart", "setOptions(DoughnutOptions options)", "Sets the chart options"),
                            new PluginEntry.MethodInfo("toJson", "String", "toJson()", "Serializes the chart to JSON")
                    ),
                    List.of(), List.of(),
                    List.of("IJsonRepresentation")),

            new PluginEntry.ComponentInfo("RadarChart", "Chart.js radar chart for multi-axis data comparison", "com.jwebmp.plugins.chartjs",
                    List.of(
                            new PluginEntry.PropertyInfo("type", "String", "radar", "The chart type identifier"),
                            new PluginEntry.PropertyInfo("responsive", "boolean", "true", "Automatically resizes to container"),
                            new PluginEntry.PropertyInfo("fill", "boolean", "false", "Fills the radar area")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Radar Chart", "Create a radar chart comparing two datasets",
                            "RadarDataset ds1 = new RadarDataset()\n    .setLabel(\"Team A\").setData(65, 59, 90, 81, 56);\nRadarDataset ds2 = new RadarDataset()\n    .setLabel(\"Team B\").setData(28, 48, 40, 19, 96);\nRadarData data = new RadarData()\n    .addLabels(\"Speed\", \"Power\", \"Skill\", \"Stamina\", \"Luck\")\n    .addDataset(ds1).addDataset(ds2);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("RadarChart(RadarData data)", "Creates a radar chart with the given data")),
                    List.of(
                            new PluginEntry.MethodInfo("setData", "RadarChart", "setData(RadarData data)", "Sets the chart data"),
                            new PluginEntry.MethodInfo("setOptions", "RadarChart", "setOptions(RadarOptions options)", "Sets the chart options"),
                            new PluginEntry.MethodInfo("toJson", "String", "toJson()", "Serializes the chart to JSON")
                    ),
                    List.of(), List.of(),
                    List.of("IJsonRepresentation"))
    );

    public ChartJsPluginPage()
    {
        super(PluginCatalog.getById("chartjs").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Bar Chart",
                        "Create a bar chart with colored datasets.",
                        "BarDataset dataset = new BarDataset()\n    .setLabel(\"Monthly Sales\")\n    .setData(65, 59, 80, 81, 56, 55, 40)\n    .addBackgroundColors(Color.RED, Color.GREEN,\n        Color.BLUE, Color.YELLOW)\n    .setBorderWidth(2);\n\nBarData data = new BarData()\n    .addLabels(\"Mon\", \"Tue\", \"Wed\", \"Thu\",\n        \"Fri\", \"Sat\", \"Sun\")\n    .addDataset(dataset);\n\nString json = new BarChart(data).toJson();",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return COMPONENTS;
    }
}
