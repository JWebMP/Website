package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-waypoints")
@NgRoutable(path = "plugins/waypoints")
public class WayPointsPluginPage extends PluginDetailPage<WayPointsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("WayPointsPageConfigurator", "Page configurator that auto-registers the Waypoints JavaScript library via npm. Implements IPageConfigurator.", "com.jwebmp.plugins.waypoints",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.waypoints;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Configures the page (assets auto-loaded via annotations)"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns true — always enabled when on classpath")
                    ),
                    List.of(), List.of(), List.of())
    );

    public WayPointsPluginPage()
    {
        super(PluginCatalog.getById("waypoints").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Auto-include Waypoints", "Simply add the Maven dependency and the Waypoints JS library is automatically included in your Angular build.",
                        """
                                // No Java code needed — Waypoints JS is auto-registered.
                                // Use waypoints in your Angular/TypeScript code:
                                // var waypoint = new Waypoint({
                                //   element: document.getElementById('thing'),
                                //   handler: function(direction) { console.log('Scrolled to thing!'); }
                                // });""", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "Auto-registers Waypoints JS via @TsDependency and @NgScript annotations"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "Includes com.jwebmp.plugins.waypoints in Guice classpath scanning")
        );
    }
}

