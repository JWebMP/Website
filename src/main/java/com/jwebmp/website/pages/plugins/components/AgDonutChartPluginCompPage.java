package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-donut-chart")
@NgRoutable(path = "plugins/agcharts/ag-donut-chart")
public class AgDonutChartPluginCompPage extends PluginComponentPage<AgDonutChartPluginCompPage>
{
    public AgDonutChartPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(4));
    }
}

