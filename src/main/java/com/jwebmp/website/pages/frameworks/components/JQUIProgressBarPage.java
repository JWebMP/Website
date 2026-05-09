package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquiprogress-bar")
@NgRoutable(path = "frameworks/jquery-ui/jquiprogress-bar")
public class JQUIProgressBarPage extends FrameworkComponentPage<JQUIProgressBarPage>
{
    public JQUIProgressBarPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(9));
    }
}
