package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-chart")
@NgRoutable(path = "plugins/agcharts/ag-chart")
public class AgChartPluginCompPage extends PluginComponentPage<AgChartPluginCompPage>
{
    public AgChartPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(0));
    }
}

