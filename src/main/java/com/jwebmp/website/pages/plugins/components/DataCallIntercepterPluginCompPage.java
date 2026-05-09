package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.ClientPluginPage;
@NgComponent("jwebmp-pcomp-data-call-intercepter")
@NgRoutable(path = "plugins/client/data-call-intercepter")
public class DataCallIntercepterPluginCompPage extends PluginComponentPage<DataCallIntercepterPluginCompPage>
{
    public DataCallIntercepterPluginCompPage()
    {
        super("client", "Client", ClientPluginPage.COMPONENTS.get(6));
    }
}
