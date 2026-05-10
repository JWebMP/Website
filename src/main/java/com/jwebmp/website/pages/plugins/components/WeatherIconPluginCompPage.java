package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WeatherIconsPluginPage;
@NgComponent("jwebmp-pcomp-weather-icon")
@NgRoutable(path = "plugins/weather-icons/weather-icon")
public class WeatherIconPluginCompPage extends PluginComponentPage<WeatherIconPluginCompPage>
{
    public WeatherIconPluginCompPage() { super("weather-icons", "Weather Icons", WeatherIconsPluginPage.COMPONENTS.get(1)); }
}

