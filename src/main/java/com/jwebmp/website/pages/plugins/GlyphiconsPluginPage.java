package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-glyphicons")
@NgRoutable(path = "plugins/glyphicons")
public class GlyphiconsPluginPage extends PluginDetailPage<GlyphiconsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("Glyphicon", "CRTP span-based icon component that renders a Glyphicon via CSS class. Implements IIcon.", "com.jwebmp.plugins.glyphicons",
                    List.of(
                            new PluginEntry.PropertyInfo("icon", "Glyphicons", null, "The Glyphicons enum value to display")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Create a Glyphicon", "Display a home icon.",
                                    "var icon = new Glyphicon&lt;&gt;(Glyphicons.home);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("Glyphicons icon", "Creates a span icon for the given Glyphicon")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setIcon", "J", "Glyphicons icon", "Sets the icon (fluent, returns J)"),
                            new PluginEntry.MethodInfo("getIcon", "Glyphicons", "", "Returns the current icon"),
                            new PluginEntry.MethodInfo("getClassName", "String", "", "Returns the CSS class string"),
                            new PluginEntry.MethodInfo("getIconComponent", "IComponentHierarchyBase&lt;?,?&gt;", "", "Returns this component")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("Glyphicons", "Enum of 250+ Bootstrap 3 Glyphicons Halflings icon constants with glyphicon glyphicon- CSS class prefix.", "com.jwebmp.plugins.glyphicons",
                    List.of(
                            new PluginEntry.PropertyInfo("asterisk / plus / minus / ok / remove", "Glyphicons", null, "Common action icons"),
                            new PluginEntry.PropertyInfo("home / search / user / star / heart", "Glyphicons", null, "Common UI icons"),
                            new PluginEntry.PropertyInfo("envelope / pencil / print / comment", "Glyphicons", null, "Communication icons"),
                            new PluginEntry.PropertyInfo("play / pause / stop / forward / backward", "Glyphicons", null, "Media playback icons"),
                            new PluginEntry.PropertyInfo("cloud / download / upload / file / folder_open", "Glyphicons", null, "File and cloud icons"),
                            new PluginEntry.PropertyInfo("lock / flag / headphones / globe / wrench", "Glyphicons", null, "Miscellaneous icons"),
                            new PluginEntry.PropertyInfo("... and 200+ more", "Glyphicons", null, "See Glyphicons enum for complete list")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("CSS class output", "Icons render as glyphicon glyphicon-{name}.",
                                    "// Glyphicons.home.toString() returns \"glyphicon glyphicon-home\"", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class with glyphicon glyphicon- prefix")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("GlyphiconsPageConfigurator", "Page configurator that auto-registers Glyphicons CSS via npm &#64;TsDependency and &#64;NgStyleSheet. Implements IPageConfigurator.", "com.jwebmp.plugins.glyphicons",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.glyphicons;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Returns page (CSS auto-registered via annotations)"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns true")
                    ),
                    List.of(), List.of(), List.of())
    );

    public GlyphiconsPluginPage()
    {
        super(PluginCatalog.getById("glyphicons").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return COMPONENTS; }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create Glyphicons", "Use the Glyphicon component with type-safe enum.",
                        "var home = new Glyphicon<>(Glyphicons.home);\nvar search = new Glyphicon<>(Glyphicons.search);", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "GlyphiconsPageConfigurator auto-registers Glyphicons CSS via npm")
        );
    }
}

