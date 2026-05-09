package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AgChartsEnterprisePluginPage;
@NgComponent("jwebmp-pcomp-ag-chord-series-options")
@NgRoutable(path = "plugins/agcharts-enterprise/ag-chord-series-options")
public class AgChordSeriesPluginCompPage extends PluginComponentPage<AgChordSeriesPluginCompPage>
{
    public AgChordSeriesPluginCompPage()
    {
        super("agcharts-enterprise", "AG Charts Enterprise", AgChartsEnterprisePluginPage.COMPONENTS.get(15));
    }
}

