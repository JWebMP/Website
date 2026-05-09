package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AngularPluginPage;
@NgComponent("jwebmp-pcomp-router-outlet")
@NgRoutable(path = "plugins/angular/router-outlet")
public class RouterOutletPluginCompPage extends PluginComponentPage<RouterOutletPluginCompPage>
{
    public RouterOutletPluginCompPage()
    {
        super("angular", "Angular", AngularPluginPage.COMPONENTS.get(4));
    }
}
