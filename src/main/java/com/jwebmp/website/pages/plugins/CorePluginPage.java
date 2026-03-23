package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-core")
@NgRoutable(path = "plugins/core")
public class CorePluginPage extends PluginDetailPage<CorePluginPage>
{
    public CorePluginPage()
    {
        super(PluginCatalog.getById("core").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("Page", "Top-level HTML page container with head, body, CSS/JS queues", "com.jwebmp.core.base.html"),
                new PluginEntry.ComponentInfo("DivSimple", "Simplified div for quick component authoring", "com.jwebmp.core.base.html"),
                new PluginEntry.ComponentInfo("Paragraph", "HTML paragraph element", "com.jwebmp.core.base.html"),
                new PluginEntry.ComponentInfo("Table", "HTML table with typed header, body, and footer sections", "com.jwebmp.core.base.html"),
                new PluginEntry.ComponentInfo("Form", "HTML form with typed input bindings", "com.jwebmp.core.base.html"),
                new PluginEntry.ComponentInfo("InputTextType", "Typed text input element", "com.jwebmp.core.base.html.inputs"),
                new PluginEntry.ComponentInfo("Feature", "Wraps JS libraries with typed options and CSS/JS references", "com.jwebmp.core.base")
        );
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Create a Page with Components",
                        "Build a full HTML page with nested div, heading, and paragraph.",
                        "Page<?> page = new Page<>();\nDiv<?, ?, ?> container = new Div<>();\ncontainer.add(new H1<>().setText(\"Hello\"));\ncontainer.add(new Paragraph<>().setText(\"Welcome to JWebMP\"));\npage.getBody().add(container);\nString html = page.toString(true);",
                        "java"),
                new PluginEntry.ExampleSnippet("Server-Driven Click Event",
                        "Attach a server-side click handler that runs Java code when the button is clicked.",
                        "var button = new Button<>().setText(\"Click Me\");\nbutton.addEvent(new OnClickAdapter(button) {\n    @Override\n    public void onClick(AjaxCall<?> call, AjaxResponse<?> response) {\n        response.addComponent(new Paragraph<>()\n            .setText(\"Button was clicked!\"));\n    }\n});",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "uses", "Discovered at startup to inject CSS/JS references and configure the page before rendering"),
                new PluginEntry.SpiDetail("IPage", "uses", "Page implementations discovered via ServiceLoader for automatic route registration"),
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Registers core Guice bindings for component model, event system, and rendering pipeline"),
                new PluginEntry.SpiDetail("IOnComponentConfigured", "provides", "Callback fired after each component is configured, enabling post-processing hooks"),
                new PluginEntry.SpiDetail("ScriptProvider", "uses", "Provides dynamic JavaScript fragments injected into the page at render time")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("Page.setTiny(boolean)", "boolean", "false", "Enable minified HTML output — removes whitespace and comments"),
                new PluginEntry.ConfigEntry("Page.setRunningLocalhost(boolean)", "boolean", "true", "Controls whether to serve from localhost or remote address")
        );
    }
}
