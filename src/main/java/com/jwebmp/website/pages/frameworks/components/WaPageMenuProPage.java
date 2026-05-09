package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-pro-wa-page-menu")
@NgRoutable(path = "frameworks/web-awesome/wa-page-menu")
public class WaPageMenuProPage extends FrameworkComponentPage<WaPageMenuProPage>
{
    public WaPageMenuProPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(15));
    }
}

