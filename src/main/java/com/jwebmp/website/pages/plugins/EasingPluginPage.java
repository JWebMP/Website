package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-easing")
@NgRoutable(path = "plugins/easing")
public class EasingPluginPage extends PluginDetailPage<EasingPluginPage>
{
    public EasingPluginPage()
    {
        super(PluginCatalog.getById("easing").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Apply Easing Effects",
                        "Use type-safe easing enum for animation timing functions.",
                        "// Use easing effect enum\nString easing = JQEasingEffects.easeInOutQuad.toString();\n\n// Apply to element animation\nmyComponent.setAttribute(\"data-easing\", easing);\n\n// Available easings include:\n// easeInQuad, easeOutQuad, easeInOutQuad\n// easeInCubic, easeOutCubic, easeInOutCubic\n// easeInElastic, easeOutBounce, and 24 more...",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("JQEasingEffects", "Enum of 33 easing timing functions — Quad, Cubic, Elastic, Bounce, etc.", "com.jwebmp.plugins.easingeffects")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "EasingPageConfigurator auto-registers browser-easing.js for Angular integration")
        );
    }
}
