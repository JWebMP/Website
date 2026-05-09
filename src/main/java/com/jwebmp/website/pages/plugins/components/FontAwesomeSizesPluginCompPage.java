package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomePluginPage;
@NgComponent("jwebmp-pcomp-font-awesome-sizes")
@NgRoutable(path = "plugins/fontawesome/font-awesome-sizes")
public class FontAwesomeSizesPluginCompPage extends PluginComponentPage<FontAwesomeSizesPluginCompPage>
{
    public FontAwesomeSizesPluginCompPage()
    {
        super("fontawesome", "Font Awesome", FontAwesomePluginPage.COMPONENTS.get(8));
    }
}

