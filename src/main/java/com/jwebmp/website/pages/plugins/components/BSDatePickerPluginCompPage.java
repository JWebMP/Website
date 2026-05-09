package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bsdate-picker")
@NgRoutable(path = "plugins/bootstrap/bsdate-picker")
public class BSDatePickerPluginCompPage extends PluginComponentPage<BSDatePickerPluginCompPage>
{
    public BSDatePickerPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(14));
    }
}
