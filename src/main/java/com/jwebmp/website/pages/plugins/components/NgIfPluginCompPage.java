package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AngularPluginPage;
@NgComponent("jwebmp-pcomp-ng-if")
@NgRoutable(path = "plugins/angular/ng-if")
public class NgIfPluginCompPage extends PluginComponentPage<NgIfPluginCompPage>
{
    public NgIfPluginCompPage()
    {
        super("angular", "Angular", AngularPluginPage.COMPONENTS.get(1));
    }
}
