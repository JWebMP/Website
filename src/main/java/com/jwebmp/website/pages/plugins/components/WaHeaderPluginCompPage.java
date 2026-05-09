package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WebAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-wa-header")
@NgRoutable(path = "plugins/web-awesome-pro/wa-header")
public class WaHeaderPluginCompPage extends PluginComponentPage<WaHeaderPluginCompPage>
{
    public WaHeaderPluginCompPage()
    {
        super("web-awesome-pro", "Web Awesome Pro", WebAwesomeProPluginPage.COMPONENTS.get(2));
    }
}
