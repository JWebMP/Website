package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-bar-chart")
@NgRoutable(path = "plugins/agcharts/ag-bar-chart")
public class AgBarChartPluginCompPage extends PluginComponentPage<AgBarChartPluginCompPage>
{
    public AgBarChartPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(1));
    }
}

