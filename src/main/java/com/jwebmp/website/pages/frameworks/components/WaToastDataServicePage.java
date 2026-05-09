package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-wa-toast-data-service")
@NgRoutable(path = "frameworks/web-awesome/wa-toast-data-service")
public class WaToastDataServicePage extends FrameworkComponentPage<WaToastDataServicePage>
{
    public WaToastDataServicePage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(77));
    }
}

