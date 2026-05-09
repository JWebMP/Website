package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WavesEffectPluginPage;
@NgComponent("jwebmp-pcomp-waves-apply-to-selector-feature")
@NgRoutable(path = "plugins/waves/waves-apply-to-selector-feature")
public class WavesApplyToSelectorFeaturePluginCompPage extends PluginComponentPage<WavesApplyToSelectorFeaturePluginCompPage>
{
    public WavesApplyToSelectorFeaturePluginCompPage()
    {
        super("waves", "Waves Effect", WavesEffectPluginPage.COMPONENTS.get(3));
    }
}

