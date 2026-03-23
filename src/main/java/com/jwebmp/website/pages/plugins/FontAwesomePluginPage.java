package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-fontawesome")
@NgRoutable(path = "plugins/fontawesome")
public class FontAwesomePluginPage extends PluginDetailPage<FontAwesomePluginPage>
{
    public FontAwesomePluginPage()
    {
        super(PluginCatalog.getById("fontawesome").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("FontAwesome", "Icon component with style and icon enum selection", "com.jwebmp.plugins.fontawesome5"),
                new PluginEntry.ComponentInfo("FontAwesomeIcons", "Enum of 2,000+ free Solid icons", "com.jwebmp.plugins.fontawesome5"),
                new PluginEntry.ComponentInfo("FontAwesomeBrandIcons", "Enum of brand icons (GitHub, Twitter, etc.)", "com.jwebmp.plugins.fontawesome5"),
                new PluginEntry.ComponentInfo("FontAwesomeLayers", "Layered icon container for combining multiple icons", "com.jwebmp.plugins.fontawesome5"),
                new PluginEntry.ComponentInfo("FontAwesomeLayerCounter", "Counter badge overlaid on icon layers", "com.jwebmp.plugins.fontawesome5")
        );
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Basic Icons",
                        "Create solid and brand icons with animation.",
                        "// Solid icon\nFontAwesome icon = new FontAwesome(\n    FontAwesomeStyles.Solid,\n    FontAwesomeIcons.cog);\n\n// Brand icon\nFontAwesome github = IFontAwesome.createIcon(\n    FontAwesomeBrandIcons.github,\n    FontAwesomeStyles.Brand);\n\n// With animation\nicon.spin().setSize(FontAwesomeSizes.Fa3x);",
                        "java"),
                new PluginEntry.ExampleSnippet("Layered Icons",
                        "Combine multiple icons with layers and counters.",
                        "var layers = new FontAwesomeLayers();\nlayers.add(new FontAwesome(FontAwesomeStyles.Solid, FontAwesomeIcons.envelope));\nlayers.add(new FontAwesomeLayerCounter(\"99+\"));",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "FontAwesomePageConfigurator auto-registers fontawesome-svg-core and Angular FontAwesome module")
        );
    }
}
