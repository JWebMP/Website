package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeProFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-polar-area-chart")
@NgRoutable(path = "frameworks/web-awesome-pro/wa-polar-area-chart")
public class WaPolarAreaChartProPage extends FrameworkComponentPage<WaPolarAreaChartProPage>
{
    public WaPolarAreaChartProPage()
    {
        super("web-awesome-pro", "Web Awesome Pro", WebAwesomeProFrameworkPage.COMPONENTS.get(10));
    }
}

