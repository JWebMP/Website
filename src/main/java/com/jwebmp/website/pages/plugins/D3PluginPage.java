package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-d3")
@NgRoutable(path = "plugins/d3")
public class D3PluginPage extends PluginDetailPage<D3PluginPage>
{
    public D3PluginPage()
    {
        super(PluginCatalog.getById("d3").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return List.of(); }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples() { return List.of(); }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "D3PageConfigurator auto-registers D3 JS via npm")
        );
    }
}

