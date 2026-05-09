package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.CorePluginPage;
@NgComponent("jwebmp-pcomp-form")
@NgRoutable(path = "plugins/core/form")
public class FormPluginCompPage extends PluginComponentPage<FormPluginCompPage>
{
    public FormPluginCompPage()
    {
        super("core", "Core", CorePluginPage.COMPONENTS.get(4));
    }
}
