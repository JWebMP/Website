package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WavesEffectPluginPage;
@NgComponent("jwebmp-pcomp-waves-effect-page-configurator")
@NgRoutable(path = "plugins/waves/waves-effect-page-configurator")
public class WavesEffectPageConfiguratorPluginCompPage extends PluginComponentPage<WavesEffectPageConfiguratorPluginCompPage>
{
    public WavesEffectPageConfiguratorPluginCompPage()
    {
        super("waves", "Waves Effect", WavesEffectPluginPage.COMPONENTS.get(0));
    }
}

