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
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("JWebMPVertxServlet", "Main Vert.x route handler for page rendering — serves HTML at configured page URLs", "com.jwebmp.vertx",
                    List.of(
                            new PluginEntry.PropertyInfo("route", "String", "/", "The URL path this handler serves"),
                            new PluginEntry.PropertyInfo("sortOrder", "int", "500", "Handler registration order")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Page Route", "Define a page served by this handler",
                            "@PageConfiguration(url = \"/\")\npublic class HomePage extends Page&lt;HomePage&gt; {\n    public HomePage() {\n        getBody().add(new H1&lt;&gt;().setText(\"Hello\"));\n    }\n}\n// JWebMPVertxServlet renders this page at GET /", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JWebMPVertxServlet()", "Creates the main page rendering route handler")),
                    List.of(
                            new PluginEntry.MethodInfo("handle", "void", "handle(RoutingContext ctx)", "Handles the incoming HTTP request and renders the page"),
                            new PluginEntry.MethodInfo("getRoute", "String", "getRoute()", "Returns the route path this handler is registered to"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the handler sort order")
                    ),
                    List.of(), List.of(),
                    List.of("VertxRouterConfigurator", "IDefaultService")),

            new PluginEntry.ComponentInfo("JWebMPAjaxServlet", "AJAX event handler processing server-side events at /jwajax", "com.jwebmp.vertx",
                    List.of(
                            new PluginEntry.PropertyInfo("route", "String", "/jwajax", "The AJAX endpoint path"),
                            new PluginEntry.PropertyInfo("timeout", "int", "10000", "AJAX request timeout in milliseconds")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("AJAX Event Handler", "Server-side events are automatically routed to /jwajax",
                            "// When a button click event fires:\nbutton.addEvent(new OnClickAdapter(button) {\n    @Override\n    public void onClick(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response) {\n        response.addComponent(new Paragraph&lt;&gt;().setText(\"Clicked!\"));\n    }\n});\n// The browser POSTs to /jwajax, handled by JWebMPAjaxServlet", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JWebMPAjaxServlet()", "Creates the AJAX event route handler")),
                    List.of(
                            new PluginEntry.MethodInfo("handle", "void", "handle(RoutingContext ctx)", "Processes the AJAX event call and returns DOM updates"),
                            new PluginEntry.MethodInfo("getRoute", "String", "getRoute()", "Returns '/jwajax'"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the handler sort order")
                    ),
                    List.of(), List.of(),
                    List.of("VertxRouterConfigurator", "IDefaultService")),

            new PluginEntry.ComponentInfo("JWebMPDataServlet", "Data component handler serving JSON data at /jwdata", "com.jwebmp.vertx",
                    List.of(
                            new PluginEntry.PropertyInfo("route", "String", "/jwdata", "The data endpoint path")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Data Endpoint", "Data components are automatically served at /jwdata",
                            "// Data-bound components automatically refresh via:\n// GET /jwdata?componentId=myComponent\n// JWebMPDataServlet serializes the component to JSON", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JWebMPDataServlet()", "Creates the data component route handler")),
                    List.of(
                            new PluginEntry.MethodInfo("handle", "void", "handle(RoutingContext ctx)", "Serves serialized component data as JSON"),
                            new PluginEntry.MethodInfo("getRoute", "String", "getRoute()", "Returns '/jwdata'"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the handler sort order")
                    ),
                    List.of(), List.of(),
                    List.of("VertxRouterConfigurator", "IDefaultService")),

            new PluginEntry.ComponentInfo("JWebMPCSSServlet", "CSS endpoint serving generated page styles at /jwcss", "com.jwebmp.vertx",
                    List.of(
                            new PluginEntry.PropertyInfo("route", "String", "/jwcss", "The CSS endpoint path")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("CSS Endpoint", "Page CSS is served automatically at /jwcss",
                            "// All CSS generated by page components is served at:\n// GET /jwcss\n// The response Content-Type is text/css", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JWebMPCSSServlet()", "Creates the CSS route handler")),
                    List.of(
                            new PluginEntry.MethodInfo("handle", "void", "handle(RoutingContext ctx)", "Serves the generated CSS for the page"),
                            new PluginEntry.MethodInfo("getRoute", "String", "getRoute()", "Returns '/jwcss'"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the handler sort order")
                    ),
                    List.of(), List.of(),
                    List.of("VertxRouterConfigurator", "IDefaultService")),

            new PluginEntry.ComponentInfo("JWebMPScriptServlet", "Site-loader script handler serving the JavaScript bootstrap at /jwscr", "com.jwebmp.vertx",
                    List.of(
                            new PluginEntry.PropertyInfo("route", "String", "/jwscr", "The script endpoint path")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Script Endpoint", "The site-loader script bootstraps the JWebMP client",
                            "// The site-loader script is automatically injected:\n// <script src=\"/jwscr\"></script>\n// It initializes the JWebMP client framework,\n// registers event handlers, and sets up AJAX communication", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JWebMPScriptServlet()", "Creates the site-loader script route handler")),
                    List.of(
                            new PluginEntry.MethodInfo("handle", "void", "handle(RoutingContext ctx)", "Serves the site-loader JavaScript"),
                            new PluginEntry.MethodInfo("getRoute", "String", "getRoute()", "Returns '/jwscr'"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the handler sort order")
                    ),
                    List.of(), List.of(),
                    List.of("VertxRouterConfigurator", "IDefaultService"))
    );

    public VertxPluginPage()
    {
        super(PluginCatalog.getById("vertx").orElseThrow());
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
