package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryUIPluginPage;
@NgComponent("jwebmp-pcomp-jquislider")
@NgRoutable(path = "plugins/jquery-ui/jquislider")
public class JQUISliderPluginCompPage extends PluginComponentPage<JQUISliderPluginCompPage>
{
    public JQUISliderPluginCompPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIPluginPage.COMPONENTS.get(7));
    }
}
