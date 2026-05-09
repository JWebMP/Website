package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-wa-animated-image")
@NgRoutable(path = "frameworks/web-awesome/wa-animated-image")
public class WaAnimatedImagePage extends FrameworkComponentPage<WaAnimatedImagePage>
{
    public WaAnimatedImagePage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(66));
    }
}

