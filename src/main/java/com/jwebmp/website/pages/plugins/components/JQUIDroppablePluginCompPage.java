package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryUIPluginPage;
@NgComponent("jwebmp-pcomp-jquidroppable")
@NgRoutable(path = "plugins/jquery-ui/jquidroppable")
public class JQUIDroppablePluginCompPage extends PluginComponentPage<JQUIDroppablePluginCompPage>
{
    public JQUIDroppablePluginCompPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIPluginPage.COMPONENTS.get(6));
    }
}
