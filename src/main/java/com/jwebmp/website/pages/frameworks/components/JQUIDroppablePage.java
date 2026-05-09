package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquidroppable")
@NgRoutable(path = "frameworks/jquery-ui/jquidroppable")
public class JQUIDroppablePage extends FrameworkComponentPage<JQUIDroppablePage>
{
    public JQUIDroppablePage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(7));
    }
}
