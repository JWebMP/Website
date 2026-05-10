package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-plus-as-tab")
@NgRoutable(path = "plugins/plus-as-tab")
public class PlusAsTabPluginPage extends PluginDetailPage<PlusAsTabPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("PlusAsTabFeature", "Feature that configures a key to act as the tab key, automatically moving focus to the next input field.", "com.jwebmp.plugins.plusastab",
                    List.of(
                            new PluginEntry.PropertyInfo("key", "Integer", "13", "The key code that acts as tab (default: Enter/13)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Custom key", "Set the numpad plus key (107) as tab.",
                                    "var feature = new PlusAsTabFeature(myComponent);\nfeature.setKey(107);", "java"),
                            new PluginEntry.ExampleSnippet("Enable on component", "Mark a component for plus-as-tab.",
                                    "PlusAsTabFeature.setFromComponent(myForm);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("IComponentHierarchyBase component", "Creates a PlusAsTab feature for the given component")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setKey", "PlusAsTabFeature", "Integer key", "Sets the key code that acts as tab"),
                            new PluginEntry.MethodInfo("getKey", "Integer", "", "Returns the current key code"),
                            new PluginEntry.MethodInfo("setFromComponent", "T", "T component", "Static — enables plus-as-tab on component via data attribute"),
                            new PluginEntry.MethodInfo("setNotOnComponent", "T", "T component", "Static — disables plus-as-tab on component via data attribute")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("PlusAsTabPageConfigurator", "Page configurator that auto-registers the PlusAsTab JavaScript libraries and enables plus-as-tab on the page body.", "com.jwebmp.plugins.plusastab",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.plusastab;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("setOnComponent", "void", "IComponentHierarchyBase component", "Static — enables plus-as-tab on a component"),
                            new PluginEntry.MethodInfo("setSkipComponent", "void", "IComponentHierarchyBase component", "Static — disables plus-as-tab on a component"),
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Configures the page — enables plus-as-tab on body"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns true — always enabled when on classpath")
                    ),
                    List.of(), List.of(), List.of())
    );

    public PlusAsTabPluginPage()
    {
        super(PluginCatalog.getById("plus-as-tab").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Enter-friendly form", "Make a form navigate fields with the Enter key.",
                        """
                                // Plus-as-tab is auto-enabled on page body.
                                // To skip a specific field:
                                PlusAsTabPageConfigurator.setSkipComponent(submitButton);
                                
                                // To use a custom key (e.g. numpad +):
                                var feature = new PlusAsTabFeature(myForm);
                                feature.setKey(107);""", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "Auto-registers PlusAsTab JS libraries and enables on page body"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "Includes com.jwebmp.plugins.plusastab in Guice classpath scanning")
        );
    }
}

