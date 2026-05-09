package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.CorePluginPage;
@NgComponent("jwebmp-pcomp-page")
@NgRoutable(path = "plugins/core/page")
public class PagePluginCompPage extends PluginComponentPage<PagePluginCompPage>
{
    public PagePluginCompPage()
    {
        super("core", "Core", CorePluginPage.COMPONENTS.get(0));
    }
}
