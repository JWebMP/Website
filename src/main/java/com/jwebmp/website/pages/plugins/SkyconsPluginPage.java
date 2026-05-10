package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-skycons")
@NgRoutable(path = "plugins/skycons")
public class SkyconsPluginPage extends PluginDetailPage<SkyconsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("Skycon", "CRTP Canvas-based animated weather icon component. Renders weather glyphs using HTML5 Canvas and requestAnimationFrame.", "com.jwebmp.plugins.skycons",
                    List.of(
                            new PluginEntry.PropertyInfo("icon", "SkyIcon", null, "The weather icon type to display"),
                            new PluginEntry.PropertyInfo("feature", "SkyconFeature", null, "The JS feature that adds this icon to the skycons instance"),
                            new PluginEntry.PropertyInfo("startFeature", "SkyconStartFeature", null, "The JS feature that starts animation playback")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Create a weather icon", "Display a partly cloudy day icon at 60x60.",
                                    "var icon = new Skycon&lt;&gt;(\"weather1\", 60, SkyIcon.Partly_Cloudy_Day);", "java"),
                            new PluginEntry.ExampleSnippet("Rain icon", "Display a rain animation.",
                                    "var rain = new Skycon&lt;&gt;(\"rain1\", 60, SkyIcon.Rain);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("String id, int widthHeight, SkyIcon skycon", "Creates a Canvas icon with the given ID, size, and weather type")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getIcon", "SkyIcon", "", "Returns the current weather icon type"),
                            new PluginEntry.MethodInfo("setIcon", "J", "SkyIcon icon", "Sets the weather icon type (fluent)"),
                            new PluginEntry.MethodInfo("getOptions", "SkyconOptions&lt;?&gt;", "", "Returns the skycon options"),
                            new PluginEntry.MethodInfo("getFeature", "SkyconFeature", "", "Returns the JS feature"),
                            new PluginEntry.MethodInfo("getStartFeature", "SkyconStartFeature", "", "Returns the start animation feature")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("SkyIcon", "Enum of 10 animated weather icon types. Values render as lowercase hyphenated strings (e.g. clear-day, partly-cloudy-night).", "com.jwebmp.plugins.skycons",
                    List.of(
                            new PluginEntry.PropertyInfo("Clear_Day / Clear_Night", "SkyIcon", null, "Clear sky — day and night variants"),
                            new PluginEntry.PropertyInfo("Rain / Snow / Sleet", "SkyIcon", null, "Precipitation icons"),
                            new PluginEntry.PropertyInfo("Wind / Fog / Cloudy", "SkyIcon", null, "Atmospheric conditions"),
                            new PluginEntry.PropertyInfo("Partly_Cloudy_Day / Partly_Cloudy_Night", "SkyIcon", null, "Partial cloud cover — day and night")
                    ),
                    List.of(),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the icon name as lowercase hyphenated string (e.g. clear-day)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("SkyconPageConfigurator", "Page configurator that auto-registers the skycons JavaScript library via npm. Implements IPageConfigurator.", "com.jwebmp.plugins.skycons.configurator",
                    List.of(
                            new PluginEntry.PropertyInfo("colour", "String", "\"black\"", "Global colour for all skycon icons")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.skycons;\n}", "java"),
                            new PluginEntry.ExampleSnippet("Set colour", "Change the global skycon colour.",
                                    "SkyconPageConfigurator.setColour(\"steelblue\");", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Auto-configured — returns the page"),
                            new PluginEntry.MethodInfo("getColour", "String", "", "Returns the global colour setting"),
                            new PluginEntry.MethodInfo("setColour", "void", "String colour", "Sets the global colour for all skycons"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns current enabled state")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("SkyconOptions", "CRTP options class for skycon configuration — colour and resizeClear settings.", "com.jwebmp.plugins.skycons",
                    List.of(
                            new PluginEntry.PropertyInfo("colour", "String", null, "The colour for skycon icons"),
                            new PluginEntry.PropertyInfo("resizeClear", "Boolean", null, "Android resize hack — set to true on Android devices")
                    ),
                    List.of(),
                    List.of(new PluginEntry.ConstructorInfo("", "Creates default options")),
                    List.of(
                            new PluginEntry.MethodInfo("setColour", "J", "String colour", "Sets the colour (fluent)"),
                            new PluginEntry.MethodInfo("setResizeClear", "J", "Boolean resizeClear", "Sets the resize clear flag (fluent)")
                    ),
                    List.of(), List.of(), List.of())
    );

    public SkyconsPluginPage()
    {
        super(PluginCatalog.getById("skycons").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return COMPONENTS; }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create animated weather icons", "Use the Skycon component with the SkyIcon enum.",
                        "var sunny = new Skycon<>(\"sun\", 60, SkyIcon.Clear_Day);\nvar rain = new Skycon<>(\"rain\", 60, SkyIcon.Rain);\nvar snow = new Skycon<>(\"snow\", 60, SkyIcon.Snow);", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "SkyconPageConfigurator auto-registers skycons JS via npm")
        );
    }
}

