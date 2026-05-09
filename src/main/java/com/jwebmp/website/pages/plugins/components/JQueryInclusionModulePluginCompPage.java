package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryPluginPage;
@NgComponent("jwebmp-pcomp-jquery-inclusion-module")
@NgRoutable(path = "plugins/jquery/jquery-inclusion-module")
public class JQueryInclusionModulePluginCompPage extends PluginComponentPage<JQueryInclusionModulePluginCompPage>
{
    public JQueryInclusionModulePluginCompPage()
    {
        super("jquery", "jQuery", JQueryPluginPage.COMPONENTS.get(1));
    }
}
