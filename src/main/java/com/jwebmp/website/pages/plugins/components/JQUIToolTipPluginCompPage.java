package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryUIPluginPage;
@NgComponent("jwebmp-pcomp-jquitool-tip")
@NgRoutable(path = "plugins/jquery-ui/jquitool-tip")
public class JQUIToolTipPluginCompPage extends PluginComponentPage<JQUIToolTipPluginCompPage>
{
    public JQUIToolTipPluginCompPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIPluginPage.COMPONENTS.get(10));
    }
}
