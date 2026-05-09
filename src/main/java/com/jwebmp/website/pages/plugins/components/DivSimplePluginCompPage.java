package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.CorePluginPage;
@NgComponent("jwebmp-pcomp-div-simple")
@NgRoutable(path = "plugins/core/div-simple")
public class DivSimplePluginCompPage extends PluginComponentPage<DivSimplePluginCompPage>
{
    public DivSimplePluginCompPage()
    {
        super("core", "Core", CorePluginPage.COMPONENTS.get(1));
    }
}
