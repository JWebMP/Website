package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WavesEffectPluginPage;
@NgComponent("jwebmp-pcomp-waves-effects")
@NgRoutable(path = "plugins/waves/waves-effects")
public class WavesEffectsPluginCompPage extends PluginComponentPage<WavesEffectsPluginCompPage>
{
    public WavesEffectsPluginCompPage()
    {
        super("waves", "Waves Effect", WavesEffectPluginPage.COMPONENTS.get(1));
    }
}

