package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.GlyphiconsPluginPage;
@NgComponent("jwebmp-pcomp-glyphicons")
@NgRoutable(path = "plugins/glyphicons/glyphicons")
public class GlyphiconsPluginCompPage extends PluginComponentPage<GlyphiconsPluginCompPage>
{
    public GlyphiconsPluginCompPage() { super("glyphicons", "Glyphicons", GlyphiconsPluginPage.COMPONENTS.get(1)); }
}

