package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-waves")
@NgRoutable(path = "plugins/waves")
public class WavesEffectPluginPage extends PluginDetailPage<WavesEffectPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("WavesEffectPageConfigurator",
                    "Page configurator that auto-registers node-waves JS and SCSS stylesheet for material ripple click effects. Implements IPageConfigurator.",
                    "com.jwebmp.plugins.waveseffect",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.waveseffect;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Configures the page — registers Waves.js script and SCSS stylesheet"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns whether the Waves effect configurator is active")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WavesEffects",
                    "Enum of 6 CSS class variants for wave ripple styling. Values render as lowercase dash-separated CSS classes (e.g. Waves_Light becomes waves-light).",
                    "com.jwebmp.plugins.waveseffect",
                    List.of(
                            new PluginEntry.PropertyInfo("Waves_Effect", "WavesEffects", null, "Base ripple effect — required on all wave-enabled elements (renders as waves-effect)"),
                            new PluginEntry.PropertyInfo("Waves_Light", "WavesEffects", null, "Light-colored ripple — use on dark backgrounds (renders as waves-light)"),
                            new PluginEntry.PropertyInfo("Waves_Circle", "WavesEffects", null, "Circular ripple — spreads in a circle from the click point (renders as waves-circle)"),
                            new PluginEntry.PropertyInfo("Waves_Button", "WavesEffects", null, "Button-optimized ripple with contained overflow (renders as waves-button)"),
                            new PluginEntry.PropertyInfo("Waves_Float", "WavesEffects", null, "Floating action button ripple with elevation shadow (renders as waves-float)"),
                            new PluginEntry.PropertyInfo("Waves_Block", "WavesEffects", null, "Block-level ripple that fills the entire element area (renders as waves-block)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Apply wave classes", "Combine multiple wave effects.",
                                    "// Use with WavesApplyToSelectorFeature\nnew WavesApplyToSelectorFeature(\".btn\",\n    WavesEffects.Waves_Effect,\n    WavesEffects.Waves_Light);", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class name in lowercase dash-separated format (e.g. waves-light)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WavesAttachFeature",
                    "Feature that calls Waves.init() to initialize the ripple click effect on the attached component. Extends Feature.",
                    "com.jwebmp.plugins.waveseffect",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Initialize Waves", "Attach ripple effect initialization to a button.",
                                    "var button = new WaButton&lt;&gt;(\"Click Me\");\nbutton.addFeature(new WavesAttachFeature(button));", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("ComponentHierarchyBase component", "Creates a new WavesAttachFeature and binds it to the given component")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("assignFunctionsToComponent", "void", "", "Adds the Waves.init() JavaScript query to the component")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WavesApplyToSelectorFeature",
                    "Feature that applies Waves.attach(selector, classes) to target elements by CSS selector with specified effect variants. Extends Feature.",
                    "com.jwebmp.plugins.waveseffect",
                    List.of(
                            new PluginEntry.PropertyInfo("selector", "String", null, "CSS selector targeting elements to apply wave effects to"),
                            new PluginEntry.PropertyInfo("classes", "Set&lt;WavesEffects&gt;", null, "Set of WavesEffects CSS class variants to apply")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Apply to all buttons", "Apply light circular ripple to all .btn elements.",
                                    "var feature = new WavesApplyToSelectorFeature(\".btn\",\n    WavesEffects.Waves_Light, WavesEffects.Waves_Circle);\npage.getBody().addFeature(feature);", "java"),
                            new PluginEntry.ExampleSnippet("Apply to FABs", "Apply floating action button ripple.",
                                    "var feature = new WavesApplyToSelectorFeature(\".fab\",\n    WavesEffects.Waves_Effect, WavesEffects.Waves_Float);\npage.getBody().addFeature(feature);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("String selector, WavesEffects... classes", "Creates a feature that attaches wave effects to elements matching the CSS selector")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getSelector", "String", "", "Returns the CSS selector"),
                            new PluginEntry.MethodInfo("setSelector", "void", "String selector", "Sets the CSS selector"),
                            new PluginEntry.MethodInfo("getClasses", "Set&lt;WavesEffects&gt;", "", "Returns the set of wave effect classes"),
                            new PluginEntry.MethodInfo("setClasses", "void", "Set&lt;WavesEffects&gt; classes", "Sets the wave effect classes"),
                            new PluginEntry.MethodInfo("assignFunctionsToComponent", "void", "", "Generates Waves.attach(selector, [classes]) JavaScript")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WavesEffectsInclusionModule",
                    "Guice module scan inclusion — ensures the Waves Effect plugin module is included in classpath scanning. Implements IGuiceScanModuleInclusions.",
                    "com.jwebmp.plugins.waveseffect.implementations",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of())
    );

    public WavesEffectPluginPage()
    {
        super(PluginCatalog.getById("waves").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return COMPONENTS;
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Initialize Waves on a component",
                        "Attach ripple effect to a button.",
                        "var button = new WaButton<>(\"Click Me\");\nbutton.addFeature(new WavesAttachFeature(button));",
                        "java"),
                new PluginEntry.ExampleSnippet("Apply to CSS selector",
                        "Apply light wave effect to all elements matching a selector.",
                        "var feature = new WavesApplyToSelectorFeature(\".btn\",\n    WavesEffects.Waves_Light, WavesEffects.Waves_Circle);\npage.getBody().addFeature(feature);",
                        "java"),
                new PluginEntry.ExampleSnippet("Module requirement",
                        "Add to your module-info.java.",
                        "module com.myapp {\n    requires com.jwebmp.plugins.waveseffect;\n}",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides",
                        "WavesEffectPageConfigurator auto-registers node-waves JS and SCSS files"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides",
                        "WavesEffectsInclusionModule ensures the Waves module is included in Guice classpath scanning")
        );
    }
}

