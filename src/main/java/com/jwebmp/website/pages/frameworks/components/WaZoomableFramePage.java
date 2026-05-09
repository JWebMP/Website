package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
@NgComponent("jwebmp-comp-wa-zoomable-frame")
@NgRoutable(path = "frameworks/web-awesome/wa-zoomable-frame")
public class WaZoomableFramePage extends FrameworkComponentPage<WaZoomableFramePage>
{
    public WaZoomableFramePage()
    {
        super("web-awesome", "Web Awesome", WebAwesomeFrameworkPage.COMPONENTS.get(69));
    }
}

