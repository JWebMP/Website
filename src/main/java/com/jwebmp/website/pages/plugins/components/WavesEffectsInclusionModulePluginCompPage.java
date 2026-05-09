package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WavesEffectPluginPage;
@NgComponent("jwebmp-pcomp-waves-effects-inclusion-module")
@NgRoutable(path = "plugins/waves/waves-effects-inclusion-module")
public class WavesEffectsInclusionModulePluginCompPage extends PluginComponentPage<WavesEffectsInclusionModulePluginCompPage>
{
    public WavesEffectsInclusionModulePluginCompPage()
    {
        super("waves", "Waves Effect", WavesEffectPluginPage.COMPONENTS.get(4));
    }
}

