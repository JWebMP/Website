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
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("JQEasingEffects", "Enum of 36 easing timing functions for smooth animation transitions — linear, swing, Quad, Cubic, Quart, Quint, Expo, Sine, Circ, Elastic, Back, and Bounce families.", "com.jwebmp.plugins.easingeffects",
                    List.of(
                            new PluginEntry.PropertyInfo("linear", "JQEasingEffects", null, "Constant speed — no acceleration or deceleration"),
                            new PluginEntry.PropertyInfo("slide", "JQEasingEffects", null, "Slide transition effect"),
                            new PluginEntry.PropertyInfo("swing", "JQEasingEffects", null, "Default jQuery easing — slight acceleration and deceleration"),
                            new PluginEntry.PropertyInfo("fadeIn", "JQEasingEffects", null, "Fade-in transition effect"),
                            new PluginEntry.PropertyInfo("fadeOut", "JQEasingEffects", null, "Fade-out transition effect"),
                            new PluginEntry.PropertyInfo("easeInQuad", "JQEasingEffects", null, "Accelerate from zero velocity (quadratic)"),
                            new PluginEntry.PropertyInfo("easeOutQuad", "JQEasingEffects", null, "Decelerate to zero velocity (quadratic)"),
                            new PluginEntry.PropertyInfo("easeInOutQuad", "JQEasingEffects", null, "Accelerate then decelerate (quadratic)"),
                            new PluginEntry.PropertyInfo("easeInCubic", "JQEasingEffects", null, "Accelerate from zero velocity (cubic)"),
                            new PluginEntry.PropertyInfo("easeOutCubic", "JQEasingEffects", null, "Decelerate to zero velocity (cubic)"),
                            new PluginEntry.PropertyInfo("easeInOutCubic", "JQEasingEffects", null, "Accelerate then decelerate (cubic)"),
                            new PluginEntry.PropertyInfo("easeInQuart", "JQEasingEffects", null, "Accelerate from zero velocity (quartic)"),
                            new PluginEntry.PropertyInfo("easeOutQuart", "JQEasingEffects", null, "Decelerate to zero velocity (quartic)"),
                            new PluginEntry.PropertyInfo("easeInOutQuart", "JQEasingEffects", null, "Accelerate then decelerate (quartic)"),
                            new PluginEntry.PropertyInfo("easeInQuint", "JQEasingEffects", null, "Accelerate from zero velocity (quintic)"),
                            new PluginEntry.PropertyInfo("easeOutQuint", "JQEasingEffects", null, "Decelerate to zero velocity (quintic)"),
                            new PluginEntry.PropertyInfo("easeInOutQuint", "JQEasingEffects", null, "Accelerate then decelerate (quintic)"),
                            new PluginEntry.PropertyInfo("easeInExpo", "JQEasingEffects", null, "Accelerate from zero velocity (exponential)"),
                            new PluginEntry.PropertyInfo("easeOutExpo", "JQEasingEffects", null, "Decelerate to zero velocity (exponential)"),
                            new PluginEntry.PropertyInfo("easeInOutExpo", "JQEasingEffects", null, "Accelerate then decelerate (exponential)"),
                            new PluginEntry.PropertyInfo("easeInSine", "JQEasingEffects", null, "Accelerate from zero velocity (sinusoidal)"),
                            new PluginEntry.PropertyInfo("easeOutSine", "JQEasingEffects", null, "Decelerate to zero velocity (sinusoidal)"),
                            new PluginEntry.PropertyInfo("easeInOutSine", "JQEasingEffects", null, "Accelerate then decelerate (sinusoidal)"),
                            new PluginEntry.PropertyInfo("easeInCirc", "JQEasingEffects", null, "Accelerate from zero velocity (circular)"),
                            new PluginEntry.PropertyInfo("easeOutCirc", "JQEasingEffects", null, "Decelerate to zero velocity (circular)"),
                            new PluginEntry.PropertyInfo("easeInOutCirc", "JQEasingEffects", null, "Accelerate then decelerate (circular)"),
                            new PluginEntry.PropertyInfo("easeInElastic", "JQEasingEffects", null, "Elastic spring effect on acceleration"),
                            new PluginEntry.PropertyInfo("easeOutElastic", "JQEasingEffects", null, "Elastic spring effect on deceleration"),
                            new PluginEntry.PropertyInfo("easeInOutElastic", "JQEasingEffects", null, "Elastic spring effect on both acceleration and deceleration"),
                            new PluginEntry.PropertyInfo("easeInBack", "JQEasingEffects", null, "Overshoot slightly then accelerate — pull-back effect"),
                            new PluginEntry.PropertyInfo("easeOutBack", "JQEasingEffects", null, "Decelerate with slight overshoot at the end"),
                            new PluginEntry.PropertyInfo("easeInOutBack", "JQEasingEffects", null, "Overshoot on both acceleration and deceleration"),
                            new PluginEntry.PropertyInfo("easeInBounce", "JQEasingEffects", null, "Bounce effect on acceleration"),
                            new PluginEntry.PropertyInfo("easeOutBounce", "JQEasingEffects", null, "Bounce effect on deceleration"),
                            new PluginEntry.PropertyInfo("easeInOutBounce", "JQEasingEffects", null, "Bounce effect on both acceleration and deceleration"),
                            new PluginEntry.PropertyInfo("Unset", "JQEasingEffects", null, "Marks the easing as not set / default")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Use easing in animation", "Apply an easing function to a jQuery UI component.",
                                    "accordion.getOptions().getAnimate()\n    .setEasing(JQEasingEffects.easeInOutQuad);", "java"),
                            new PluginEntry.ExampleSnippet("Bounce effect", "Apply a bounce easing for playful animations.",
                                    "accordion.getOptions().getAnimate()\n    .setEasing(JQEasingEffects.easeOutBounce);", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the easing function name as a string for CSS/JS usage")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("JQEasingPageConfigurator", "Page configurator that auto-registers the browser-easing.js script for Angular integration. Implements IPageConfigurator.", "com.jwebmp.plugins.easingeffects",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether the easing effects configurator is active")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Disable easing", "Globally disable easing script registration.",
                                    "JQEasingPageConfigurator.setEnabled(false);", "java"),
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.easingeffects;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Configures the page — no additional setup required beyond script registration"),
                            new PluginEntry.MethodInfo("isEnabled", "boolean", "", "Returns whether the easing configurator is enabled"),
                            new PluginEntry.MethodInfo("setEnabled", "void", "boolean mustEnable", "Globally enable or disable easing effects registration"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns current enabled state for IPageConfigurator contract")
                    ),
                    List.of(), List.of(), List.of())
    );

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
        return COMPONENTS;
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "EasingPageConfigurator auto-registers browser-easing.js for Angular integration")
        );
    }
}
