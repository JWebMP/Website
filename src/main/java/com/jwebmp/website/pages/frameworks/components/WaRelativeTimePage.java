package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-wa-relative-time")
@NgRoutable(path = "frameworks/web-awesome/wa-relative-time")
public class WaRelativeTimePage extends FrameworkComponentPage<WaRelativeTimePage>
{
    public WaRelativeTimePage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(85));
    }
}

