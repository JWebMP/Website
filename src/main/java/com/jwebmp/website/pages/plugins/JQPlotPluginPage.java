package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-jqplot")
@NgRoutable(path = "plugins/jqplot")
public class JQPlotPluginPage extends PluginDetailPage<JQPlotPluginPage>
{
    public JQPlotPluginPage()
    {
        super(PluginCatalog.getById("jqplot").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return List.of(); }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create a line graph", "Use JQPlotLineGraph to create a line chart.",
                        "var graph = new JQPlotLineGraph<>();", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "JQPlotPageConfigurator auto-registers jqPlot JS/CSS via npm")
        );
    }
}

