package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-themify-icons")
@NgRoutable(path = "plugins/themify-icons")
public class ThemifyIconsPluginPage extends PluginDetailPage<ThemifyIconsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("ThemifyIcon", "CRTP span-based icon component that renders a Themify icon via CSS class. Implements IIcon.", "com.jwebmp.plugins.themify.icons",
                    List.of(
                            new PluginEntry.PropertyInfo("icon", "ThemifyIcons", null, "The Themify icon enum value to display")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Create a Themify icon", "Display a home icon.",
                                    "var icon = new ThemifyIcon&lt;&gt;(ThemifyIcons.home);", "java"),
                            new PluginEntry.ExampleSnippet("Social icon", "Display a GitHub icon.",
                                    "var icon = new ThemifyIcon&lt;&gt;(ThemifyIcons.github);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("ThemifyIcons icon", "Creates a span icon for the given Themify icon"),
                            new PluginEntry.ConstructorInfo("", "Creates an empty span with no icon")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getClassName", "String", "", "Returns the icon CSS class name"),
                            new PluginEntry.MethodInfo("getIconComponent", "IComponentHierarchyBase&lt;?,?&gt;", "", "Returns this component as the icon element")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("ThemifyIcons", "Enum of 320+ icon constants with ti- CSS class prefix. Categories include arrows, UI controls, media, text editing, layouts, and social/brand icons.", "com.jwebmp.plugins.themify.icons",
                    List.of(
                            new PluginEntry.PropertyInfo("arrow_up / arrow_down / arrow_left / arrow_right", "ThemifyIcons", null, "Directional arrows"),
                            new PluginEntry.PropertyInfo("angle_up / angle_down / angle_left / angle_right", "ThemifyIcons", null, "Angle chevrons"),
                            new PluginEntry.PropertyInfo("home / user / search / settings / email / star", "ThemifyIcons", null, "Common UI icons"),
                            new PluginEntry.PropertyInfo("heart / bookmark / flag / eye / lock / unlock", "ThemifyIcons", null, "Status and feedback icons"),
                            new PluginEntry.PropertyInfo("pencil / brush / palette / paint_roller / eraser", "ThemifyIcons", null, "Editing and design tools"),
                            new PluginEntry.PropertyInfo("desktop / tablet / mobile / server / cloud", "ThemifyIcons", null, "Device and infrastructure icons"),
                            new PluginEntry.PropertyInfo("control_play / control_pause / control_stop", "ThemifyIcons", null, "Media playback controls"),
                            new PluginEntry.PropertyInfo("layout_grid2 / layout_grid3 / layout_grid4", "ThemifyIcons", null, "Layout grid variants"),
                            new PluginEntry.PropertyInfo("github / facebook / twitter / linkedin / youtube", "ThemifyIcons", null, "Social and brand icons"),
                            new PluginEntry.PropertyInfo("shopping_cart / credit_card / wallet / money", "ThemifyIcons", null, "Commerce icons"),
                            new PluginEntry.PropertyInfo("... and 270+ more", "ThemifyIcons", null, "See ThemifyIcons enum for complete list")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Use enum value", "Icons render as CSS class ti-{name} with underscores replaced by dashes.",
                                    "// ThemifyIcons.arrow_right.toString() returns \"ti-arrow-right\"", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class name with ti- prefix (e.g. ti-arrow-right)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("ThemifyIconsPageConfigurator", "Page configurator that auto-registers the themify-icons.min.css stylesheet. Implements IPageConfigurator.", "com.jwebmp.plugins.themify.icons",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether the Themify Icons configurator is active")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.themify.icons;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "Page&lt;?&gt;", "Page&lt;?&gt; page", "Registers the Themify Icons CSS reference on the page"),
                            new PluginEntry.MethodInfo("isEnabled", "boolean", "", "Returns whether the configurator is enabled"),
                            new PluginEntry.MethodInfo("setEnabled", "void", "boolean mustEnable", "Globally enable or disable Themify Icons registration"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns current enabled state")
                    ),
                    List.of(), List.of(), List.of())
    );

    public ThemifyIconsPluginPage()
    {
        super(PluginCatalog.getById("themify-icons").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return COMPONENTS; }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create Themify icons", "Use the ThemifyIcon component with type-safe enum.",
                        "var home = new ThemifyIcon<>(ThemifyIcons.home);\nvar search = new ThemifyIcon<>(ThemifyIcons.search);\nvar github = new ThemifyIcon<>(ThemifyIcons.github);", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "ThemifyIconsPageConfigurator auto-registers themify-icons CSS")
        );
    }
}

