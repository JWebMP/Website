package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AngularPluginPage;
@NgComponent("jwebmp-pcomp-stomp-server")
@NgRoutable(path = "plugins/angular/stomp-server")
public class StompServerPluginCompPage extends PluginComponentPage<StompServerPluginCompPage>
{
    public StompServerPluginCompPage()
    {
        super("angular", "Angular", AngularPluginPage.COMPONENTS.get(6));
    }
}
