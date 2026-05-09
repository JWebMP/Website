package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AngularPluginPage;
@NgComponent("jwebmp-pcomp-ng-for")
@NgRoutable(path = "plugins/angular/ng-for")
public class NgForPluginCompPage extends PluginComponentPage<NgForPluginCompPage>
{
    public NgForPluginCompPage()
    {
        super("angular", "Angular", AngularPluginPage.COMPONENTS.get(2));
    }
}
