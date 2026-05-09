package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ChartJsPluginPage;
@NgComponent("jwebmp-pcomp-pie-chart")
@NgRoutable(path = "plugins/chartjs/pie-chart")
public class PieChartPluginCompPage extends PluginComponentPage<PieChartPluginCompPage>
{
    public PieChartPluginCompPage()
    {
        super("chartjs", "Chart.js", ChartJsPluginPage.COMPONENTS.get(2));
    }
}
