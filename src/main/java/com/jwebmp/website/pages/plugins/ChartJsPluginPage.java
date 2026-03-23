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
        return List.of(
                new PluginEntry.ComponentInfo("BarChart", "Chart.js bar chart with typed dataset API", "com.jwebmp.plugins.chartjs"),
                new PluginEntry.ComponentInfo("LineChart", "Chart.js line chart with point styles and fill", "com.jwebmp.plugins.chartjs"),
                new PluginEntry.ComponentInfo("PieChart", "Chart.js pie chart with segment customization", "com.jwebmp.plugins.chartjs"),
                new PluginEntry.ComponentInfo("DoughnutChart", "Chart.js doughnut chart", "com.jwebmp.plugins.chartjs"),
                new PluginEntry.ComponentInfo("RadarChart", "Chart.js radar chart for multi-axis comparison", "com.jwebmp.plugins.chartjs")
        );
    }
}
