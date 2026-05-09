package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AngularPluginPage;
@NgComponent("jwebmp-pcomp-ngapplication")
@NgRoutable(path = "plugins/angular/ngapplication")
public class NGApplicationPluginCompPage extends PluginComponentPage<NGApplicationPluginCompPage>
{
    public NGApplicationPluginCompPage()
    {
        super("angular", "Angular", AngularPluginPage.COMPONENTS.get(0));
    }
}
