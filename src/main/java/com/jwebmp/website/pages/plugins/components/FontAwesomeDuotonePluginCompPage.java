package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FontAwesomeProPluginPage;
@NgComponent("jwebmp-pcomp-font-awesome-duotone")
@NgRoutable(path = "plugins/fontawesome-pro/font-awesome-duotone")
public class FontAwesomeDuotonePluginCompPage extends PluginComponentPage<FontAwesomeDuotonePluginCompPage>
{
    public FontAwesomeDuotonePluginCompPage()
    {
        super("fontawesome-pro", "Font Awesome Pro", FontAwesomeProPluginPage.COMPONENTS.get(0));
    }
}

