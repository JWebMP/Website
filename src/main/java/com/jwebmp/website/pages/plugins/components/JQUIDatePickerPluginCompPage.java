package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryUIPluginPage;
@NgComponent("jwebmp-pcomp-jquidate-picker")
@NgRoutable(path = "plugins/jquery-ui/jquidate-picker")
public class JQUIDatePickerPluginCompPage extends PluginComponentPage<JQUIDatePickerPluginCompPage>
{
    public JQUIDatePickerPluginCompPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIPluginPage.COMPONENTS.get(3));
    }
}
