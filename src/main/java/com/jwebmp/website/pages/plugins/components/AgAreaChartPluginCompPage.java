package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsPluginPage;
@NgComponent("jwebmp-pcomp-ag-area-chart")
@NgRoutable(path = "plugins/agcharts/ag-area-chart")
public class AgAreaChartPluginCompPage extends PluginComponentPage<AgAreaChartPluginCompPage>
{
    public AgAreaChartPluginCompPage()
    {
        super("agcharts", "AG Charts", AgChartsPluginPage.COMPONENTS.get(5));
    }
}

