package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquiresizable")
@NgRoutable(path = "frameworks/jquery-ui/jquiresizable")
public class JQUIResizablePage extends FrameworkComponentPage<JQUIResizablePage>
{
    public JQUIResizablePage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(10));
    }
}
