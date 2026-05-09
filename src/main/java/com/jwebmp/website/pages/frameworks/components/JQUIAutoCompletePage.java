package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquiauto-complete")
@NgRoutable(path = "frameworks/jquery-ui/jquiauto-complete")
public class JQUIAutoCompletePage extends FrameworkComponentPage<JQUIAutoCompletePage>
{
    public JQUIAutoCompletePage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(1));
    }
}
