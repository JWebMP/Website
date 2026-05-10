package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-easy-pie-chart")
@NgRoutable(path = "plugins/easy-pie-chart")
public class EasyPieChartPluginPage extends PluginDetailPage<EasyPieChartPluginPage>
{
    public EasyPieChartPluginPage()
    {
        super(PluginCatalog.getById("easy-pie-chart").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return List.of(); }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create a pie chart", "Use EasyPieChart to display a single-value animated pie.",
                        "var chart = new EasyPieChart<>();\nchart.getOptions().setBarColor(\"#ef1e25\");", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "EasyPieChartPageConfigurator auto-registers Easy Pie Chart JS via npm")
        );
    }
}

