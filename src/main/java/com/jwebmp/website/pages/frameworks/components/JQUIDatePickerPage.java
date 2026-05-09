package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
@NgComponent("jwebmp-comp-jquidate-picker")
@NgRoutable(path = "frameworks/jquery-ui/jquidate-picker")
public class JQUIDatePickerPage extends FrameworkComponentPage<JQUIDatePickerPage>
{
    public JQUIDatePickerPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIFrameworkPage.COMPONENTS.get(4));
    }
}
