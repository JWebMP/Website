package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ChartJsPluginPage;
@NgComponent("jwebmp-pcomp-bar-chart")
@NgRoutable(path = "plugins/chartjs/bar-chart")
public class BarChartPluginCompPage extends PluginComponentPage<BarChartPluginCompPage>
{
    public BarChartPluginCompPage()
    {
        super("chartjs", "Chart.js", ChartJsPluginPage.COMPONENTS.get(0));
    }
}
