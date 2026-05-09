package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-jquery")
@NgRoutable(path = "plugins/jquery")
public class JQueryPluginPage extends PluginDetailPage<JQueryPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("JQueryPageConfigurator", "Auto-registers jQuery 4.0.0 and jQuery Migrate 4.0.2 as global scripts in the Angular build", "com.jwebmp.plugins.jquery",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether the jQuery configurator is active"),
                            new PluginEntry.PropertyInfo("sortOrder", "int", "100", "Execution priority (runs early to ensure jQuery is available)"),
                            new PluginEntry.PropertyInfo("jqueryVersion", "String", "4.0.0", "The jQuery version being registered"),
                            new PluginEntry.PropertyInfo("migrateVersion", "String", "4.0.2", "The jQuery Migrate version being registered")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Enable jQuery", "jQuery is auto-registered via module requirement",
                            "// module-info.java\nmodule com.myapp {\n    requires com.jwebmp.plugins.jquery;\n}\n// JQueryPageConfigurator auto-registers:\n// jquery-4.0.0.min.js and jquery-migrate-4.0.2.min.js\n// as global scripts in angular.json", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQueryPageConfigurator()", "Creates the jQuery page configurator")),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage", "configure(IPage&lt;?&gt; page)", "Registers jQuery JS references on the page"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the sort order (100)"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "enabled()", "Returns whether the configurator is active")
                    ),
                    List.of(), List.of(),
                    List.of("IPageConfigurator")),

            new PluginEntry.ComponentInfo("JQueryInclusionModule", "Guice module scan inclusion ensuring the jQuery plugin is included in classpath scanning", "com.jwebmp.plugins.jquery",
                    List.of(),
                    List.of(new PluginEntry.ExampleSnippet("Auto-registration", "Module inclusion is automatic via SPI",
                            "// No code needed — JQueryInclusionModule is discovered\n// via ServiceLoader and includes the jQuery module\n// in Guice classpath scanning automatically.", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQueryInclusionModule()", "Creates the module inclusion provider")),
                    List.of(
                            new PluginEntry.MethodInfo("includeModules", "Set&lt;String&gt;", "includeModules()", "Returns the module names to include in scanning")
                    ),
                    List.of(), List.of(),
                    List.of("IGuiceScanModuleInclusions"))
    );

    public JQueryPluginPage()
    {
        super(PluginCatalog.getById("jquery").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Add jQuery to your project",
                        "Simply add the module requirement and jQuery is globally available.",
                        "// module-info.java\nmodule com.myapp {\n    requires com.jwebmp.plugins.jquery;\n}\n\n// jQuery ($) is now available in the browser",
                        "java"),
                new PluginEntry.ExampleSnippet("Maven dependency",
                        "Add the jQuery plugin to your pom.xml.",
                        "<dependency>\n  <groupId>com.jwebmp.plugins</groupId>\n  <artifactId>jquery</artifactId>\n</dependency>",
                        "xml")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "JQueryPageConfigurator auto-registers jQuery 4.0.0 and jQuery Migrate 4.0.2 as global scripts"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "JQueryInclusionModule includes the jQuery module in Guice classpath scanning")
        );
    }
}
