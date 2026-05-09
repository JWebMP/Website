package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WebAwesomePluginPage;
@NgComponent("jwebmp-pcomp-wa-cluster")
@NgRoutable(path = "plugins/web-awesome/wa-cluster")
public class WaClusterPluginCompPage extends PluginComponentPage<WaClusterPluginCompPage>
{
    public WaClusterPluginCompPage()
    {
        super("web-awesome", "Web Awesome", WebAwesomePluginPage.COMPONENTS.get(3));
    }
}
