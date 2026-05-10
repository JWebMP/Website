package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-material-design-icons")
@NgRoutable(path = "plugins/material-design-icons")
public class MaterialDesignIconsPluginPage extends PluginDetailPage<MaterialDesignIconsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("MaterialDesignIcon", "CRTP italic-based icon component for Google Material Design Icons. Supports themes, sizes, colours, and inactive state. Implements IIcon.", "com.jwebmp.plugins.materialdesignicons",
                    List.of(
                            new PluginEntry.PropertyInfo("theme", "MaterialDesignIconThemes", "Filled", "Icon theme variant (Filled, Outlined, Rounded, TwoTone, Sharp)"),
                            new PluginEntry.PropertyInfo("icon", "MaterialDesignIcons", null, "The Material Design icon enum value to display"),
                            new PluginEntry.PropertyInfo("size", "MaterialDesignIconSize", "$24", "Icon size (18px, 24px, 36px, or 48px)"),
                            new PluginEntry.PropertyInfo("colour", "MaterialDesignIconColours", "Light", "Colour scheme — Light (md-dark) or Dark (md-light)"),
                            new PluginEntry.PropertyInfo("inactive", "boolean", "false", "Whether the icon renders in inactive/dimmed state")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Default icon", "Create a filled 24px icon.",
                                    "var icon = new MaterialDesignIcon&lt;&gt;(MaterialDesignIcons.home);", "java"),
                            new PluginEntry.ExampleSnippet("Themed icon", "Outlined theme at 48px.",
                                    "var icon = new MaterialDesignIcon&lt;&gt;(\n    MaterialDesignIconThemes.Outlined,\n    MaterialDesignIcons.settings,\n    MaterialDesignIconSize.$48,\n    MaterialDesignIconColours.Dark);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("MaterialDesignIcons icon", "Creates a Filled theme, 24px, Light colour icon"),
                            new PluginEntry.ConstructorInfo("MaterialDesignIconThemes theme, MaterialDesignIcons icon", "Creates icon with specified theme at 24px"),
                            new PluginEntry.ConstructorInfo("MaterialDesignIconThemes theme, MaterialDesignIcons icon, MaterialDesignIconSize size", "Creates icon with theme and size, Light colour"),
                            new PluginEntry.ConstructorInfo("MaterialDesignIconThemes theme, MaterialDesignIcons icon, MaterialDesignIconSize size, MaterialDesignIconColours colour", "Full constructor with all options")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setTheme", "J", "MaterialDesignIconThemes theme", "Sets the icon theme variant"),
                            new PluginEntry.MethodInfo("setIcon", "J", "MaterialDesignIcons icon", "Sets the icon to display"),
                            new PluginEntry.MethodInfo("setSize", "J", "MaterialDesignIconSize size", "Sets the icon size"),
                            new PluginEntry.MethodInfo("setColour", "J", "MaterialDesignIconColours colour", "Sets the colour scheme"),
                            new PluginEntry.MethodInfo("setInactive", "J", "boolean inactive", "Sets inactive/dimmed state"),
                            new PluginEntry.MethodInfo("getClassName", "String", "", "Returns the full CSS class string"),
                            new PluginEntry.MethodInfo("getIconComponent", "IComponentHierarchyBase&lt;?,?&gt;", "", "Returns this component as the icon element")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("MaterialDesignIcons", "Enum of 900+ official Google Material Design icon constants.", "com.jwebmp.plugins.materialdesignicons",
                    List.of(
                            new PluginEntry.PropertyInfo("home / settings / search / menu / info", "MaterialDesignIcons", null, "Common UI icons"),
                            new PluginEntry.PropertyInfo("person / group / account_circle / face", "MaterialDesignIcons", null, "People and account icons"),
                            new PluginEntry.PropertyInfo("email / phone / chat / message / forum", "MaterialDesignIcons", null, "Communication icons"),
                            new PluginEntry.PropertyInfo("file_copy / folder / cloud / attach_file", "MaterialDesignIcons", null, "File management icons"),
                            new PluginEntry.PropertyInfo("play_arrow / pause / stop / skip_next", "MaterialDesignIcons", null, "Media playback icons"),
                            new PluginEntry.PropertyInfo("map / place / navigation / my_location", "MaterialDesignIcons", null, "Maps and location icons"),
                            new PluginEntry.PropertyInfo("check / close / add / remove / edit / delete", "MaterialDesignIcons", null, "Action icons"),
                            new PluginEntry.PropertyInfo("... and 850+ more", "MaterialDesignIcons", null, "See MaterialDesignIcons enum for complete list")
                    ),
                    List.of(), List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the icon name with underscores replaced by underscores (used as text content)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("MaterialDesignIconThemes", "Enum of 5 icon theme variants for Google Material Design Icons.", "com.jwebmp.plugins.materialdesignicons",
                    List.of(
                            new PluginEntry.PropertyInfo("Filled", "MaterialDesignIconThemes", null, "Default filled/solid icon style"),
                            new PluginEntry.PropertyInfo("Outlined", "MaterialDesignIconThemes", null, "Outlined/stroke-only icon style"),
                            new PluginEntry.PropertyInfo("Rounded", "MaterialDesignIconThemes", null, "Rounded corners icon style"),
                            new PluginEntry.PropertyInfo("TwoTone", "MaterialDesignIconThemes", null, "Two-tone icon style with primary and secondary colours"),
                            new PluginEntry.PropertyInfo("Sharp", "MaterialDesignIconThemes", null, "Sharp corners icon style")
                    ),
                    List.of(), List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class with md- prefix (e.g. md-outlined)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("MaterialDesignIconSize", "Enum of 4 icon sizes for Google Material Design Icons.", "com.jwebmp.plugins.materialdesignicons",
                    List.of(
                            new PluginEntry.PropertyInfo("$18", "MaterialDesignIconSize", null, "18px icon size (renders as md-18)"),
                            new PluginEntry.PropertyInfo("$24", "MaterialDesignIconSize", null, "24px icon size — default (renders as md-24)"),
                            new PluginEntry.PropertyInfo("$36", "MaterialDesignIconSize", null, "36px icon size (renders as md-36)"),
                            new PluginEntry.PropertyInfo("$48", "MaterialDesignIconSize", null, "48px icon size (renders as md-48)")
                    ),
                    List.of(), List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class with md- prefix (e.g. md-24)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("MaterialDesignIconColours", "Enum of 2 colour schemes for Google Material Design Icons.", "com.jwebmp.plugins.materialdesignicons",
                    List.of(
                            new PluginEntry.PropertyInfo("Dark", "MaterialDesignIconColours", null, "Dark icon on light background (renders as md-light)"),
                            new PluginEntry.PropertyInfo("Light", "MaterialDesignIconColours", null, "Light icon on dark background (renders as md-dark)")
                    ),
                    List.of(), List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class with md- prefix")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("MaterialDesignIconsPageConfigurator", "Page configurator that auto-registers the Google Material Design Icons CSS. Implements IPageConfigurator.", "com.jwebmp.plugins.materialdesignicons",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether the configurator is active")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.materialdesignicons;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "Page&lt;?&gt;", "Page&lt;?&gt; page", "Registers the Material Design Icons CSS reference"),
                            new PluginEntry.MethodInfo("isEnabled", "boolean", "", "Returns whether the configurator is enabled"),
                            new PluginEntry.MethodInfo("setEnabled", "void", "boolean mustEnable", "Globally enable or disable registration"),
                            new PluginEntry.MethodInfo("getReference", "MaterialDesignIconsCSSReference", "", "Returns the CSS reference object"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns current enabled state")
                    ),
                    List.of(), List.of(), List.of())
    );

    public MaterialDesignIconsPluginPage()
    {
        super(PluginCatalog.getById("material-design-icons").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return COMPONENTS; }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create Material Design icons", "Use MaterialDesignIcon with theme, size, and colour options.",
                        "var icon = new MaterialDesignIcon<>(MaterialDesignIcons.home);\nvar outlined = new MaterialDesignIcon<>(\n    MaterialDesignIconThemes.Outlined,\n    MaterialDesignIcons.settings);", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "MaterialDesignIconsPageConfigurator auto-registers Material Design Icons CSS")
        );
    }
}

