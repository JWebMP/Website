package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryUIPluginPage;
@NgComponent("jwebmp-pcomp-jquiauto-complete")
@NgRoutable(path = "plugins/jquery-ui/jquiauto-complete")
public class JQUIAutoCompletePluginCompPage extends PluginComponentPage<JQUIAutoCompletePluginCompPage>
{
    public JQUIAutoCompletePluginCompPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIPluginPage.COMPONENTS.get(1));
    }
}
