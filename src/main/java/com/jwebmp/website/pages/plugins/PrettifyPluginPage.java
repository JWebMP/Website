package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-prettify")
@NgRoutable(path = "plugins/prettify")
public class PrettifyPluginPage extends PluginDetailPage<PrettifyPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("Prettify", "CRTP component that renders a &lt;pre&gt; block with syntax highlighting via Google Code Prettify. Supports 35+ languages and multiple themes.", "com.jwebmp.plugins.google.sourceprettify",
                    List.of(
                            new PluginEntry.PropertyInfo("sourceCodeLanguage", "SourceCodeLanguages", "Java", "The programming language for syntax highlighting"),
                            new PluginEntry.PropertyInfo("sourceCodePrettifyTheme", "SourceCodePrettifyThemes", "Default", "The CSS theme for syntax colouring"),
                            new PluginEntry.PropertyInfo("showLineNums", "boolean", "false", "Whether to display line numbers")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic code block", "Display a Java code snippet with default theme.",
                                    "Prettify&lt;?&gt; code = new Prettify&lt;&gt;();\ncode.setSourceCodeLanguage(SourceCodeLanguages.Java);\ncode.setText(\"public class Hello { }\");", "java"),
                            new PluginEntry.ExampleSnippet("Themed with line numbers", "Sons of Obsidian theme with line numbers.",
                                    "Prettify&lt;?&gt; code = new Prettify&lt;&gt;();\ncode.setTheme(SourceCodePrettifyThemes.Sons_Of_Obsidian);\ncode.setShowLineNums(true);\ncode.setText(\"SELECT * FROM users;\");", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("()", "Creates a new Prettify code block with default settings (Java, Default theme)")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setSourceCodeLanguage", "J", "SourceCodeLanguages lang", "Sets the programming language (fluent)"),
                            new PluginEntry.MethodInfo("getSourceCodeLanguage", "SourceCodeLanguages", "", "Returns the current language"),
                            new PluginEntry.MethodInfo("setTheme", "J", "SourceCodePrettifyThemes theme", "Sets the display theme (fluent)"),
                            new PluginEntry.MethodInfo("getSourceCodePrettifyTheme", "SourceCodePrettifyThemes", "", "Returns the current theme"),
                            new PluginEntry.MethodInfo("setShowLineNums", "J", "boolean show", "Enables/disables line numbers (fluent)"),
                            new PluginEntry.MethodInfo("isShowLineNums", "boolean", "", "Returns whether line numbers are shown")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("SourceCodeLanguages", "Enum of 35 supported programming languages for syntax highlighting.", "com.jwebmp.plugins.google.sourceprettify",
                    List.of(
                            new PluginEntry.PropertyInfo("Java / Python / JS", "SourceCodeLanguages", null, "Common languages"),
                            new PluginEntry.PropertyInfo("HTML / CSS / XML / XSL", "SourceCodeLanguages", null, "Markup and styling"),
                            new PluginEntry.PropertyInfo("Sql / Bash / Go / Scala", "SourceCodeLanguages", null, "Other popular languages")
                    ),
                    List.of(), List.of(), List.of(),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("SourceCodePrettifyThemes", "Enum of 6 CSS themes for code highlighting. Each provides a CSSReference for the selected theme.", "com.jwebmp.plugins.google.sourceprettify",
                    List.of(
                            new PluginEntry.PropertyInfo("Default", "SourceCodePrettifyThemes", null, "Standard prettify theme"),
                            new PluginEntry.PropertyInfo("Desert", "SourceCodePrettifyThemes", null, "Warm desert colour scheme"),
                            new PluginEntry.PropertyInfo("Sons_Of_Obsidian", "SourceCodePrettifyThemes", null, "Dark theme with vivid colours"),
                            new PluginEntry.PropertyInfo("Sunburst", "SourceCodePrettifyThemes", null, "Dark background with bright syntax colours")
                    ),
                    List.of(), List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("getCssReference", "CSSReference", "", "Returns the CSS reference for this theme")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("PrettifyPageConfigurator", "Page configurator that auto-registers code-prettify JavaScript and CSS via npm. Implements IPageConfigurator.", "com.jwebmp.plugins.google.sourceprettify",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.prettify;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Configures the page (assets auto-loaded via annotations)"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns true — always enabled when on classpath")
                    ),
                    List.of(), List.of(), List.of())
    );

    public PrettifyPluginPage()
    {
        super(PluginCatalog.getById("prettify").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Java code with Sons of Obsidian", "Display Java source with a dark theme and line numbers.",
                        """
                                Prettify&lt;?&gt; codeBlock = new Prettify&lt;&gt;();
                                codeBlock.setSourceCodeLanguage(SourceCodeLanguages.Java);
                                codeBlock.setTheme(SourceCodePrettifyThemes.Sons_Of_Obsidian);
                                codeBlock.setShowLineNums(true);
                                codeBlock.setText("public class HelloWorld {\\n    public static void main(String[] args) {\\n    }\\n}");""", "java"),
                new PluginEntry.ExampleSnippet("SQL query display", "Render a SQL snippet with the default theme.",
                        """
                                Prettify&lt;?&gt; sql = new Prettify&lt;&gt;();
                                sql.setSourceCodeLanguage(SourceCodeLanguages.Sql);
                                sql.setText("SELECT u.name, COUNT(*) FROM users u GROUP BY u.name;");""", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "Auto-registers code-prettify JS and CSS via @TsDependency, @NgScript, @NgStyleSheet annotations"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "Includes com.jwebmp.plugins.google.sourceprettify in Guice classpath scanning")
        );
    }
}

