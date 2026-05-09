package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomePluginPage;
@NgComponent("jwebmp-pcomp-font-awesome-icons")
@NgRoutable(path = "plugins/fontawesome/font-awesome-icons")
public class FontAwesomeIconsPluginCompPage extends PluginComponentPage<FontAwesomeIconsPluginCompPage>
{
    public FontAwesomeIconsPluginCompPage()
    {
        super("fontawesome", "Font Awesome", FontAwesomePluginPage.COMPONENTS.get(5));
    }
}
