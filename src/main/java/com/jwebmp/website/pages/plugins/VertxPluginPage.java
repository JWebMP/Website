package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-vertx")
@NgRoutable(path = "plugins/vertx")
public class VertxPluginPage extends PluginDetailPage<VertxPluginPage>
{
    public VertxPluginPage()
    {
        super(PluginCatalog.getById("vertx").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("JWebMPVertxServlet", "Main Vert.x route handler for page rendering", "com.jwebmp.vertx"),
                new PluginEntry.ComponentInfo("JWebMPAjaxServlet", "AJAX event handler at /jwajax", "com.jwebmp.vertx"),
                new PluginEntry.ComponentInfo("JWebMPDataServlet", "Data component handler at /jwdata", "com.jwebmp.vertx"),
                new PluginEntry.ComponentInfo("JWebMPCSSServlet", "CSS endpoint at /jwcss", "com.jwebmp.vertx"),
                new PluginEntry.ComponentInfo("JWebMPScriptServlet", "Site-loader script handler", "com.jwebmp.vertx")
        );
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Page Route Configuration",
                        "Define a page that is automatically served by Vert.x.",
                        "@PageConfiguration(url = \"/\")\npublic class HomePage extends Page<HomePage> {\n    public HomePage() {\n        getBody().add(\n            new H1<>().setText(\"Hello from JWebMP\")\n        );\n    }\n}",
                        "java"),
                new PluginEntry.ExampleSnippet("Start the Server",
                        "Bootstrap the Vert.x server with Guice.",
                        "IGuiceContext.instance().inject();\n// Routes auto-registered:\n// GET /       -> Page rendering\n// POST /jwajax -> AJAX events\n// GET /jwdata  -> Data components\n// GET /jwcss   -> Page CSS",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Registers Vert.x HTTP server, route handlers, and call-scope bindings"),
                new PluginEntry.SpiDetail("VertxHttpServerConfigurator", "provides", "Configures Vert.x HttpServerOptions — port, SSL, compression, etc."),
                new PluginEntry.SpiDetail("VertxRouterConfigurator", "uses", "Extension point for additional Vert.x route registration")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("HTTP_PORT", "int", "6500", "Vert.x HTTP server port"),
                new PluginEntry.ConfigEntry("AJAX_TIMEOUT", "int", "10000", "AJAX request timeout in milliseconds")
        );
    }
}
