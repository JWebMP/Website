package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.components.modules.RouterModuleConfig;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AngularPluginPage;
@NgComponent("jwebmp-pcomp-router-link")
@NgRoutable(path = "plugins/angular/router-link")
@NgComponentReference(RouterModuleConfig.class)
public class RouterLinkPluginCompPage extends PluginComponentPage<RouterLinkPluginCompPage>
{
    public RouterLinkPluginCompPage()
    {
        super("angular", "Angular", AngularPluginPage.COMPONENTS.get(3));
    }
}
