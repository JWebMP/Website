package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquisortable")
@NgRoutable(path = "frameworks/jquery-ui/jquisortable")
public class JQUISortablePage extends FrameworkComponentPage<JQUISortablePage>
{
    public JQUISortablePage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(14));
    }
}
