package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.CorePluginPage;
@NgComponent("jwebmp-pcomp-paragraph")
@NgRoutable(path = "plugins/core/paragraph")
public class ParagraphPluginCompPage extends PluginComponentPage<ParagraphPluginCompPage>
{
    public ParagraphPluginCompPage()
    {
        super("core", "Core", CorePluginPage.COMPONENTS.get(2));
    }
}
