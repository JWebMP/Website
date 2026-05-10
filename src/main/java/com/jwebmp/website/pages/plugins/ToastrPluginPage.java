package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-toastr")
@NgRoutable(path = "plugins/toastr")
public class ToastrPluginPage extends PluginDetailPage<ToastrPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("ToastrFeature", "Main toast feature component — creates non-blocking notification toasts with configurable type, title, message, and options. Extends Feature with CRTP fluent API.", "com.jwebmp.plugins.toastr",
                    List.of(
                            new PluginEntry.PropertyInfo("type", "ToastrType", "Info", "The toast type (Info, Success, Warning, Error)"),
                            new PluginEntry.PropertyInfo("title", "String", "null", "The toast title text"),
                            new PluginEntry.PropertyInfo("message", "String", "null", "The toast message text")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Simple message toast", "Show an info toast with just a message.",
                                    "addFeature(new ToastrFeature&lt;&gt;(\"Hello World\"));", "java"),
                            new PluginEntry.ExampleSnippet("Toast with title and type", "Show a success toast with title and message.",
                                    "addFeature(new ToastrFeature&lt;&gt;(ToastrType.Success, \"Done!\", \"Your changes have been saved.\"));", "java"),
                            new PluginEntry.ExampleSnippet("Customized toast", "Configure toast options for positioning and behavior.",
                                    "var toast = new ToastrFeature&lt;&gt;(ToastrType.Warning, \"Alert\", \"Check this\");\ntoast.getOptions()\n     .setPositionClass(ToastrPosition.Toast_Top_Center)\n     .setCloseButton(true)\n     .setProgressBar(true)\n     .setTimeOut(3000);\naddFeature(toast);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("", "Creates a default toastr feature"),
                            new PluginEntry.ConstructorInfo("String message", "Creates a toast with the given message"),
                            new PluginEntry.ConstructorInfo("String title, String message", "Creates a toast with title and message"),
                            new PluginEntry.ConstructorInfo("ToastrType type, String title, String message", "Creates a toast with type, title, and message")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setType", "J", "ToastrType type", "Sets the toast type (fluent)"),
                            new PluginEntry.MethodInfo("setTitle", "J", "String title", "Sets the toast title (fluent)"),
                            new PluginEntry.MethodInfo("setMessage", "J", "String message", "Sets the toast message (fluent)"),
                            new PluginEntry.MethodInfo("getType", "ToastrType", "", "Returns the toast type (defaults to Info)"),
                            new PluginEntry.MethodInfo("getTitle", "String", "", "Returns the toast title"),
                            new PluginEntry.MethodInfo("getMessage", "String", "", "Returns the toast message"),
                            new PluginEntry.MethodInfo("getOptions", "ToastrOptions&lt;?&gt;", "", "Returns the toast options for configuration")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("ToastrOptions", "CRTP options class for toast configuration — positioning, timing, animations, and behavior. All setters return J for fluent chaining.", "com.jwebmp.plugins.toastr",
                    List.of(
                            new PluginEntry.PropertyInfo("closeButton", "Boolean", "false", "Show a close button on the toast"),
                            new PluginEntry.PropertyInfo("debug", "Boolean", "false", "Enable debug mode"),
                            new PluginEntry.PropertyInfo("newestOnTop", "Boolean", "true", "Show newest toasts on top"),
                            new PluginEntry.PropertyInfo("progressBar", "Boolean", "false", "Show countdown progress bar"),
                            new PluginEntry.PropertyInfo("positionClass", "ToastrPosition", "Toast_Top_Right", "Screen position for toasts"),
                            new PluginEntry.PropertyInfo("preventDuplicates", "Boolean", "false", "Prevent duplicate toast messages"),
                            new PluginEntry.PropertyInfo("showDuration", "Integer", "300", "Duration of the show animation (ms)"),
                            new PluginEntry.PropertyInfo("hideDuration", "Integer", "1000", "Duration of the hide animation (ms)"),
                            new PluginEntry.PropertyInfo("timeOut", "Integer", "5000", "How long the toast stays visible (ms)"),
                            new PluginEntry.PropertyInfo("extendedTimeOut", "Integer", "1000", "Extra time on hover (ms)"),
                            new PluginEntry.PropertyInfo("showEasing", "JQEasingEffects", "swing", "Easing effect for show animation"),
                            new PluginEntry.PropertyInfo("hideEasing", "JQEasingEffects", "linear", "Easing effect for hide animation"),
                            new PluginEntry.PropertyInfo("showMethod", "JQEasingEffects", "fadeIn", "Animation method for showing"),
                            new PluginEntry.PropertyInfo("hideMethod", "JQEasingEffects", "fadeOut", "Animation method for hiding"),
                            new PluginEntry.PropertyInfo("escapeHtml", "Boolean", "false", "Escape HTML in title and message")
                    ),
                    List.of(),
                    List.of(new PluginEntry.ConstructorInfo("", "Creates default toast options")),
                    List.of(),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("ToastrType", "Enum of 4 toast notification types with distinct visual styling.", "com.jwebmp.plugins.toastr",
                    List.of(
                            new PluginEntry.PropertyInfo("Info", "ToastrType", null, "Information toast (blue)"),
                            new PluginEntry.PropertyInfo("Success", "ToastrType", null, "Success toast (green)"),
                            new PluginEntry.PropertyInfo("Warning", "ToastrType", null, "Warning toast (yellow/orange)"),
                            new PluginEntry.PropertyInfo("Error", "ToastrType", null, "Error toast (red)")
                    ),
                    List.of(), List.of(), List.of(),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("ToastrPosition", "Enum of 8 screen positions for toast placement.", "com.jwebmp.plugins.toastr",
                    List.of(
                            new PluginEntry.PropertyInfo("Toast_Top_Right", "ToastrPosition", null, "Top right corner (default)"),
                            new PluginEntry.PropertyInfo("Toast_Top_Left", "ToastrPosition", null, "Top left corner"),
                            new PluginEntry.PropertyInfo("Toast_Top_Center", "ToastrPosition", null, "Top center"),
                            new PluginEntry.PropertyInfo("Toast_Top_Full_Width", "ToastrPosition", null, "Top full width bar"),
                            new PluginEntry.PropertyInfo("Toast_Bottom_Right", "ToastrPosition", null, "Bottom right corner"),
                            new PluginEntry.PropertyInfo("Toast_Bottom_Left", "ToastrPosition", null, "Bottom left corner"),
                            new PluginEntry.PropertyInfo("Toast_Bottom_Center", "ToastrPosition", null, "Bottom center"),
                            new PluginEntry.PropertyInfo("Toast_Bottom_Full_Width", "ToastrPosition", null, "Bottom full width bar")
                    ),
                    List.of(), List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "", "Returns the CSS class name (e.g. toast-top-right)")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("ToastrPageConfigurator", "Auto-configuration that registers toastr npm package, JS script, and CSS stylesheet via Angular build annotations.", "com.jwebmp.plugins.toastr",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.toastr;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Auto-configured — returns the page"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns true (always enabled)")
                    ),
                    List.of(), List.of(), List.of())
    );

    public ToastrPluginPage()
    {
        super(PluginCatalog.getById("toastr").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents() { return COMPONENTS; }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Simple toast notification", "Show different types of toast messages.",
                        "// Info toast\naddFeature(new ToastrFeature<>(\"Hello World\"));\n\n// Success toast\naddFeature(new ToastrFeature<>(ToastrType.Success, \"Done!\", \"Saved.\"));\n\n// Error toast with options\nvar toast = new ToastrFeature<>(ToastrType.Error, \"Error\", \"Something failed.\");\ntoast.getOptions().setCloseButton(true).setProgressBar(true);\naddFeature(toast);", "java"),
                new PluginEntry.ExampleSnippet("Customized positioning and timing", "Configure toast position, duration, and animation.",
                        "var toast = new ToastrFeature<>(ToastrType.Warning, \"Alert\", \"Attention needed\");\ntoast.getOptions()\n     .setPositionClass(ToastrPosition.Toast_Bottom_Center)\n     .setTimeOut(10000)\n     .setShowEasing(JQEasingEffects.easeInOutQuad)\n     .setHideEasing(JQEasingEffects.easeOutBounce)\n     .setNewestOnTop(false)\n     .setPreventDuplicates(true);", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "ToastrPageConfigurator auto-registers toastr JS/CSS via npm with @TsDependency, @NgScript, and @NgStyleSheet"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "ToastrInclusionsModule registers the toastr module for Guice classpath scanning")
        );
    }
}

