package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquicheck-box-group")
@NgRoutable(path = "frameworks/jquery-ui/jquicheck-box-group")
public class JQUICheckBoxGroupPage extends FrameworkComponentPage<JQUICheckBoxGroupPage>
{
    public JQUICheckBoxGroupPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(3));
    }
}
