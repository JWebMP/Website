package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryUIPluginPage;
@NgComponent("jwebmp-pcomp-jquitabs")
@NgRoutable(path = "plugins/jquery-ui/jquitabs")
public class JQUITabsPluginCompPage extends PluginComponentPage<JQUITabsPluginCompPage>
{
    public JQUITabsPluginCompPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIPluginPage.COMPONENTS.get(9));
    }
}
