package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-material-icons")
@NgRoutable(path = "plugins/material-icons")
public class MaterialIconsPluginPage extends PluginDetailPage<MaterialIconsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("MDIIcon", "CRTP italic-based icon component for Material Design Icons (Community). Renders mdi- prefixed CSS classes. Implements IIcon.", "com.jwebmp.plugins.materialicons",
                    List.of(
                            new PluginEntry.PropertyInfo("icon", "MDIIcons", null, "The MDI icon enum value to display")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Create an MDI icon", "Display an account icon.",
                                    "var icon = new MDIIcon&lt;&gt;(MDIIcons.account);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("MDIIcons icon", "Creates an italic icon for the given MDI icon"),
                            new PluginEntry.ConstructorInfo("", "Creates an empty icon element")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getClassName", "String", "", "Returns the icon CSS class name"),
                            new PluginEntry.MethodInfo("getIconComponent", "IComponentHierarchyBase&lt;?,?&gt;", "", "Returns this component as the icon element")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("MDIIcons", "Enum of 2,000+ Material Design Community icon constants with mdi- CSS class prefix.", "com.jwebmp.plugins.materialicons",
                    List.of(
                            new PluginEntry.PropertyInfo("account / account_circle / account_box", "MDIIcons", null, "User and account icons"),
                            new PluginEntry.PropertyInfo("home / settings / search / menu", "MDIIcons", null, "Common UI icons"),
                            new PluginEntry.PropertyInfo("email / phone / message / chat", "MDIIcons", null, "Communication icons"),
                            new PluginEntry.PropertyInfo("file / folder / cloud / download / upload", "MDIIcons", null, "File and storage icons"),
                            new PluginEntry.PropertyInfo("play / pause / stop / skip_next / skip_previous", "MDIIcons", null, "Media playback icons"),
                            new PluginEntry.PropertyInfo("map / pin / navigation / compass", "MDIIcons", null, "Location and maps icons"),
                            new PluginEntry.PropertyInfo("... and 1,950+ more", "MDIIcons", null, "See MDIIcons enum for complete list")
                    ),
                    List.of(),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class name with mdi mdi- prefix")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("MaterialIconsPageConfigurator", "Page configurator that auto-registers the materialdesignicons.min.css stylesheet (local or CDN). Implements IPageConfigurator.", "com.jwebmp.plugins.materialicons",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether the Material Icons configurator is active")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.materialicons;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "Page&lt;?&gt;", "Page&lt;?&gt; page", "Registers the MDI CSS reference on the page"),
                            new PluginEntry.MethodInfo("isEnabled", "boolean", "", "Returns whether the configurator is enabled"),
                            new PluginEntry.MethodInfo("setEnabled", "void", "boolean mustEnable", "Globally enable or disable Material Icons registration"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns current enabled state")
                    ),
                    List.of(), List.of(), List.of())
    );

    public MaterialIconsPluginPage()
    {
        super(PluginCatalog.getById("material-icons").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return COMPONENTS; }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create MDI icons", "Use the MDIIcon component with type-safe enum.",
                        "var account = new MDIIcon<>(MDIIcons.account);\nvar settings = new MDIIcon<>(MDIIcons.settings);", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "MaterialIconsPageConfigurator auto-registers MDI CSS")
        );
    }
}

