package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-globalize")
@NgRoutable(path = "plugins/globalize")
public class GlobalizePluginPage extends PluginDetailPage<GlobalizePluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("GlobalizePageConfigurator",
                    "Auto-registers Globalize runtime scripts (currency, date, message, number, plural, relative-time, unit) for i18n/l10n support",
                    "com.jwebmp.plugins.globalize.cultures",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether the Globalize configurator is active"),
                            new PluginEntry.PropertyInfo("sortOrder", "int", "150", "Execution priority among page configurators")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Enable Globalize", "Globalize is auto-enabled via module-info",
                            "// module-info.java\nmodule com.myapp {\n    requires com.jwebmp.plugins.globalize.cultures;\n}\n// GlobalizePageConfigurator auto-registers:\n// globalize.js, globalize-currency.js, globalize-date.js,\n// globalize-message.js, globalize-number.js,\n// globalize-plural.js, globalize-relative-time.js", "java")),
                    List.of(new PluginEntry.ConstructorInfo("GlobalizePageConfigurator()", "Creates the Globalize page configurator")),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage", "configure(IPage&lt;?&gt; page)", "Registers all Globalize JS references on the page"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the sort order (150)"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "enabled()", "Returns whether the configurator is active")
                    ),
                    List.of(), List.of(),
                    List.of("IPageConfigurator")),

            new PluginEntry.ComponentInfo("GlobalizeCultures",
                    "Type-safe enum of 350+ Unicode CLDR culture codes with automatic underscore-to-dash conversion for BCP 47 compliance",
                    "com.jwebmp.plugins.globalize.cultures",
                    List.of(
                            new PluginEntry.PropertyInfo("name", "String", "null", "The culture code with underscores (e.g. en_US)"),
                            new PluginEntry.PropertyInfo("displayName", "String", "null", "Human-readable locale display name")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Culture Tag", "Convert enum to BCP 47 locale tag",
                                    "GlobalizeCultures culture = GlobalizeCultures.en_US;\nString tag = culture.toString(); // \"en-US\"\n\nGlobalizeCultures french = GlobalizeCultures.fr_FR;\nString frTag = french.toString(); // \"fr-FR\"", "java"),
                            new PluginEntry.ExampleSnippet("All Cultures", "Iterate over available cultures",
                                    "for (GlobalizeCultures c : GlobalizeCultures.values()) {\n    System.out.println(c.toString());\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("toString", "String", "toString()", "Returns the BCP 47 tag with dashes instead of underscores"),
                            new PluginEntry.MethodInfo("values", "GlobalizeCultures[]", "values()", "Returns all available culture codes"),
                            new PluginEntry.MethodInfo("valueOf", "GlobalizeCultures", "valueOf(String name)", "Returns the enum constant for the given name")
                    ),
                    List.of(), List.of(),
                    List.of("Enum")),

            new PluginEntry.ComponentInfo("GlobalizeModuleInclusions",
                    "Guice module scan inclusion ensuring the Globalize plugin is included in classpath scanning",
                    "com.jwebmp.plugins.globalize.cultures.implementations",
                    List.of(),
                    List.of(new PluginEntry.ExampleSnippet("Auto-registration", "Module inclusion is automatic via SPI",
                            "// No code needed — GlobalizeModuleInclusions is discovered\n// via ServiceLoader and includes the Globalize module\n// in Guice classpath scanning automatically.", "java")),
                    List.of(new PluginEntry.ConstructorInfo("GlobalizeModuleInclusions()", "Creates the module inclusion provider")),
                    List.of(
                            new PluginEntry.MethodInfo("includeModules", "Set&lt;String&gt;", "includeModules()", "Returns the module names to include in scanning")
                    ),
                    List.of(), List.of(),
                    List.of("IGuiceScanModuleInclusions"))
    );

    public GlobalizePluginPage()
    {
        super(PluginCatalog.getById("globalize").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Use a culture tag",
                        "Convert enum values to standard BCP 47 locale tags.",
                        "GlobalizeCultures culture = GlobalizeCultures.en_US;\nString tag = culture.toString(); // \"en-US\"",
                        "java"),
                new PluginEntry.ExampleSnippet("Module requirement",
                        "Add to your module-info.java to include Globalize support.",
                        "module com.myapp {\n    requires com.jwebmp.plugins.globalize.cultures;\n}",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides",
                        "GlobalizePageConfigurator auto-registers Globalize runtime JS files for currency, date, message, number, plural, relative-time, and unit formatting"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides",
                        "GlobalizeModuleInclusions ensures the Globalize module is included in Guice classpath scanning")
        );
    }
}
