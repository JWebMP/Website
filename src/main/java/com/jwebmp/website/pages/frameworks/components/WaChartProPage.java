package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeProFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-chart")
@NgRoutable(path = "frameworks/web-awesome-pro/wa-chart")
public class WaChartProPage extends FrameworkComponentPage<WaChartProPage>
{
    public WaChartProPage()
    {
        super("web-awesome-pro", "Web Awesome Pro", WebAwesomeProFrameworkPage.COMPONENTS.get(2));
    }
}

