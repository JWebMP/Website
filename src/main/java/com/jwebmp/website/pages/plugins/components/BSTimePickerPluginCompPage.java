package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.BootstrapPluginPage;
@NgComponent("jwebmp-pcomp-bstime-picker")
@NgRoutable(path = "plugins/bootstrap/bstime-picker")
public class BSTimePickerPluginCompPage extends PluginComponentPage<BSTimePickerPluginCompPage>
{
    public BSTimePickerPluginCompPage()
    {
        super("bootstrap", "Bootstrap", BootstrapPluginPage.COMPONENTS.get(32));
    }
}
