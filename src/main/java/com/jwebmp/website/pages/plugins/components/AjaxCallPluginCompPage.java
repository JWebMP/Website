package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ClientPluginPage;
@NgComponent("jwebmp-pcomp-ajax-call")
@NgRoutable(path = "plugins/client/ajax-call")
public class AjaxCallPluginCompPage extends PluginComponentPage<AjaxCallPluginCompPage>
{
    public AjaxCallPluginCompPage()
    {
        super("client", "Client", ClientPluginPage.COMPONENTS.get(0));
    }
}
