package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ChartJsPluginPage;
@NgComponent("jwebmp-pcomp-radar-chart")
@NgRoutable(path = "plugins/chartjs/radar-chart")
public class RadarChartPluginCompPage extends PluginComponentPage<RadarChartPluginCompPage>
{
    public RadarChartPluginCompPage()
    {
        super("chartjs", "Chart.js", ChartJsPluginPage.COMPONENTS.get(4));
    }
}
