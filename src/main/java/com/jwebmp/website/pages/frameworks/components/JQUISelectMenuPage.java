package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquiselect-menu")
@NgRoutable(path = "frameworks/jquery-ui/jquiselect-menu")
public class JQUISelectMenuPage extends FrameworkComponentPage<JQUISelectMenuPage>
{
    public JQUISelectMenuPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(12));
    }
}
