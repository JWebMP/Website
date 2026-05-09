package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.WavesEffectPluginPage;
@NgComponent("jwebmp-pcomp-waves-attach-feature")
@NgRoutable(path = "plugins/waves/waves-attach-feature")
public class WavesAttachFeaturePluginCompPage extends PluginComponentPage<WavesAttachFeaturePluginCompPage>
{
    public WavesAttachFeaturePluginCompPage()
    {
        super("waves", "Waves Effect", WavesEffectPluginPage.COMPONENTS.get(2));
    }
}

