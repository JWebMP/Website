package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquidraggable")
@NgRoutable(path = "frameworks/jquery-ui/jquidraggable")
public class JQUIDraggablePage extends FrameworkComponentPage<JQUIDraggablePage>
{
    public JQUIDraggablePage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(6));
    }
}
