package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WeatherIconsPluginPage;
@NgComponent("jwebmp-pcomp-weather-icons-page-configurator")
@NgRoutable(path = "plugins/weather-icons/weather-icons-page-configurator")
public class WeatherIconsPageConfiguratorPluginCompPage extends PluginComponentPage<WeatherIconsPageConfiguratorPluginCompPage>
{
    public WeatherIconsPageConfiguratorPluginCompPage() { super("weather-icons", "Weather Icons", WeatherIconsPluginPage.COMPONENTS.get(2)); }
}

