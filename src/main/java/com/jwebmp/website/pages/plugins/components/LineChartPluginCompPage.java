package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ChartJsPluginPage;
@NgComponent("jwebmp-pcomp-line-chart")
@NgRoutable(path = "plugins/chartjs/line-chart")
public class LineChartPluginCompPage extends PluginComponentPage<LineChartPluginCompPage>
{
    public LineChartPluginCompPage()
    {
        super("chartjs", "Chart.js", ChartJsPluginPage.COMPONENTS.get(1));
    }
}
