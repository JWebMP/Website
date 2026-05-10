package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-c3")
@NgRoutable(path = "plugins/c3")
public class C3PluginPage extends PluginDetailPage<C3PluginPage>
{
    public C3PluginPage()
    {
        super(PluginCatalog.getById("c3").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return List.of(); }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create a C3 chart", "Use the C3 component with data columns.",
                        "var chart = new C3<>();\nchart.getOptions().getData().getColumns().add(new C3ColumnData());", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "C3PageConfigurator auto-registers C3 JS/CSS via npm")
        );
    }
}

