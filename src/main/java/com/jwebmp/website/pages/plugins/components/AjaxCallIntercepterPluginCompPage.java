package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ClientPluginPage;
@NgComponent("jwebmp-pcomp-ajax-call-intercepter")
@NgRoutable(path = "plugins/client/ajax-call-intercepter")
public class AjaxCallIntercepterPluginCompPage extends PluginComponentPage<AjaxCallIntercepterPluginCompPage>
{
    public AjaxCallIntercepterPluginCompPage()
    {
        super("client", "Client", ClientPluginPage.COMPONENTS.get(5));
    }
}
