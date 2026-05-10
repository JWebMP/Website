package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-weather-icons")
@NgRoutable(path = "plugins/weather-icons")
public class WeatherIconsPluginPage extends PluginDetailPage<WeatherIconsPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("WeatherIcons", "CRTP italic-based icon component for Weather Icons. Implements IIcon.", "com.jwebmp.plugins.weathericons",
                    List.of(
                            new PluginEntry.PropertyInfo("icon", "WeatherIcon", null, "The weather icon enum value to display")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Sunny day", "Display a day sunny icon.",
                                    "var icon = new WeatherIcons&lt;&gt;(WeatherIcon.day_sunny);", "java"),
                            new PluginEntry.ExampleSnippet("Night clear", "Display a clear night icon.",
                                    "var icon = new WeatherIcons&lt;&gt;(WeatherIcon.night_clear);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("WeatherIcon icon", "Creates an italic icon for the given weather icon")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getClassName", "String", "", "Returns the icon CSS class name"),
                            new PluginEntry.MethodInfo("getIconComponent", "IComponentHierarchyBase&lt;?,?&gt;", "", "Returns this component as the icon element")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WeatherIcon", "Enum of 222 weather themed icon constants with wi- CSS class prefix. Organized into day conditions, night conditions, general weather, moon phases, time, wind direction, wind Beaufort scale, and compass directions.", "com.jwebmp.plugins.weathericons",
                    List.of(
                            new PluginEntry.PropertyInfo("day_sunny / day_cloudy / day_rain / day_snow / day_thunderstorm", "WeatherIcon", null, "Daytime weather conditions (22 icons)"),
                            new PluginEntry.PropertyInfo("night_clear / night_cloudy / night_rain / night_snow", "WeatherIcon", null, "Nighttime weather conditions (26 icons)"),
                            new PluginEntry.PropertyInfo("cloud / cloudy / fog / rain / snow / hail / lightning", "WeatherIcon", null, "General weather conditions (18 icons)"),
                            new PluginEntry.PropertyInfo("earthquake / fire / flood / tornado / hurricane / tsunami / volcano", "WeatherIcon", null, "Natural disaster icons"),
                            new PluginEntry.PropertyInfo("moon_new / moon_full / moon_first_quarter / moon_waxing_crescent_1..6", "WeatherIcon", null, "Moon phases — 28 standard + 28 alt variants"),
                            new PluginEntry.PropertyInfo("thermometer / barometer / humidity / celsius / fahrenheit", "WeatherIcon", null, "Measurement and temperature"),
                            new PluginEntry.PropertyInfo("sunrise / sunset / moonrise / moonset / horizon", "WeatherIcon", null, "Celestial events"),
                            new PluginEntry.PropertyInfo("time_1 through time_12", "WeatherIcon", null, "Clock face icons (12 icons)"),
                            new PluginEntry.PropertyInfo("wind_beaufort_0 through wind_beaufort_12", "WeatherIcon", null, "Beaufort wind scale (13 icons)"),
                            new PluginEntry.PropertyInfo("towards_n / towards_ne / towards_e / towards_se / towards_s ...", "WeatherIcon", null, "Wind towards compass direction (16 icons)"),
                            new PluginEntry.PropertyInfo("from_n / from_ne / from_e / from_se / from_s ...", "WeatherIcon", null, "Wind from compass direction (16 icons)"),
                            new PluginEntry.PropertyInfo("towards_0_deg / towards_45_deg / towards_90_deg ...", "WeatherIcon", null, "Wind towards degree direction (16 icons)"),
                            new PluginEntry.PropertyInfo("from_0_deg / from_45_deg / from_90_deg ...", "WeatherIcon", null, "Wind from degree direction (16 icons)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("CSS class output", "Icons render as wi-{name} CSS class.",
                                    "// WeatherIcon.day_sunny.toString() returns \"wi-day-sunny\"", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class name with wi- prefix (e.g. wi-day-sunny)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WeatherIconsPageConfigurator", "Page configurator that auto-registers the weather-icons.min.css stylesheet. Implements IPageConfigurator.", "com.jwebmp.plugins.weathericons",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether the Weather Icons configurator is active")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.weathericons;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "Page&lt;?&gt;", "Page&lt;?&gt; page", "Registers the Weather Icons CSS reference on the page"),
                            new PluginEntry.MethodInfo("isEnabled", "boolean", "", "Returns whether the configurator is enabled"),
                            new PluginEntry.MethodInfo("setEnabled", "void", "boolean mustEnable", "Globally enable or disable Weather Icons registration"),
                            new PluginEntry.MethodInfo("getReference", "CSSReference", "", "Returns the CSS reference object"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns current enabled state")
                    ),
                    List.of(), List.of(), List.of())
    );

    public WeatherIconsPluginPage()
    {
        super(PluginCatalog.getById("weather-icons").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return COMPONENTS; }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create Weather icons", "Use the WeatherIcons component with type-safe enum.",
                        "var sunny = new WeatherIcons<>(WeatherIcon.day_sunny);\nvar rain = new WeatherIcons<>(WeatherIcon.rain);\nvar wind = new WeatherIcons<>(WeatherIcon.towards_n);", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "WeatherIconsPageConfigurator auto-registers Weather Icons CSS")
        );
    }
}

