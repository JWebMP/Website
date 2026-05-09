package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.CorePluginPage;
@NgComponent("jwebmp-pcomp-input-text-type")
@NgRoutable(path = "plugins/core/input-text-type")
public class InputTextTypePluginCompPage extends PluginComponentPage<InputTextTypePluginCompPage>
{
    public InputTextTypePluginCompPage()
    {
        super("core", "Core", CorePluginPage.COMPONENTS.get(5));
    }
}
