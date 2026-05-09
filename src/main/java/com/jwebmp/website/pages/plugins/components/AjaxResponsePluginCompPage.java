package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ClientPluginPage;
@NgComponent("jwebmp-pcomp-ajax-response")
@NgRoutable(path = "plugins/client/ajax-response")
public class AjaxResponsePluginCompPage extends PluginComponentPage<AjaxResponsePluginCompPage>
{
    public AjaxResponsePluginCompPage()
    {
        super("client", "Client", ClientPluginPage.COMPONENTS.get(1));
    }
}
