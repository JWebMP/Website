package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.EasingPluginPage;
@NgComponent("jwebmp-pcomp-jqeasing-effects")
@NgRoutable(path = "plugins/easing/jqeasing-effects")
public class JQEasingEffectsPluginCompPage extends PluginComponentPage<JQEasingEffectsPluginCompPage>
{
    public JQEasingEffectsPluginCompPage()
    {
        super("easing", "Easing", EasingPluginPage.COMPONENTS.get(0));
    }
}
