package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ClientPluginPage;
@NgComponent("jwebmp-pcomp-site-call-intercepter")
@NgRoutable(path = "plugins/client/site-call-intercepter")
public class SiteCallIntercepterPluginCompPage extends PluginComponentPage<SiteCallIntercepterPluginCompPage>
{
    public SiteCallIntercepterPluginCompPage()
    {
        super("client", "Client", ClientPluginPage.COMPONENTS.get(4));
    }
}
