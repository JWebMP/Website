package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-client")
@NgRoutable(path = "plugins/client")
public class ClientPluginPage extends PluginDetailPage<ClientPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("AjaxCall", "Request DTO carrying event data, component ID, and parameters from browser to server", "com.jwebmp.client",
                    List.of(
                            new PluginEntry.PropertyInfo("componentId", "String", "null", "The ID of the component that triggered the event"),
                            new PluginEntry.PropertyInfo("eventType", "String", "null", "The type of event (click, change, keyup, etc.)"),
                            new PluginEntry.PropertyInfo("parameters", "Map&lt;String, String&gt;", "empty", "Key-value parameters sent with the call"),
                            new PluginEntry.PropertyInfo("datetime", "Date", "null", "Timestamp of the event"),
                            new PluginEntry.PropertyInfo("value", "String", "null", "The input value at the time of the event")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Access AjaxCall Data", "Read event data in an event handler",
                            "button.addEvent(new OnClickAdapter(button) {\n    @Override\n    public void onClick(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response) {\n        String id = call.getComponentId();\n        String value = call.getValue();\n    }\n});", "java")),
                    List.of(new PluginEntry.ConstructorInfo("AjaxCall()", "Creates an empty AjaxCall DTO")),
                    List.of(
                            new PluginEntry.MethodInfo("getComponentId", "String", "getComponentId()", "Returns the triggering component ID"),
                            new PluginEntry.MethodInfo("getEventType", "String", "getEventType()", "Returns the event type"),
                            new PluginEntry.MethodInfo("getParameters", "Map", "getParameters()", "Returns the call parameters"),
                            new PluginEntry.MethodInfo("getValue", "String", "getValue()", "Returns the input value")
                    ),
                    List.of(), List.of(),
                    List.of("IJsonRepresentation")),

            new PluginEntry.ComponentInfo("AjaxResponse", "Response DTO carrying DOM updates, reactions, and component additions from server to browser", "com.jwebmp.client",
                    List.of(
                            new PluginEntry.PropertyInfo("components", "List&lt;IComponentHierarchyBase&gt;", "empty", "Components to add/update in the DOM"),
                            new PluginEntry.PropertyInfo("reactions", "List&lt;AjaxResponseReaction&gt;", "empty", "Client-side reactions (redirect, alert, etc.)"),
                            new PluginEntry.PropertyInfo("events", "List&lt;Event&gt;", "empty", "Events to register on the client"),
                            new PluginEntry.PropertyInfo("features", "List&lt;Feature&gt;", "empty", "JavaScript features to execute")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Build AjaxResponse", "Add components and reactions to a response",
                            "@Override\npublic void onClick(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response) {\n    response.addComponent(new Paragraph&lt;&gt;().setText(\"Updated!\"));\n    response.addReaction(new AjaxResponseReaction(\"alert\", \"Done!\"));\n}", "java")),
                    List.of(new PluginEntry.ConstructorInfo("AjaxResponse()", "Creates an empty AjaxResponse DTO")),
                    List.of(
                            new PluginEntry.MethodInfo("addComponent", "AjaxResponse", "addComponent(IComponentHierarchyBase component)", "Adds a component to the response"),
                            new PluginEntry.MethodInfo("addReaction", "AjaxResponse", "addReaction(AjaxResponseReaction reaction)", "Adds a client-side reaction"),
                            new PluginEntry.MethodInfo("getComponents", "List", "getComponents()", "Returns the response components"),
                            new PluginEntry.MethodInfo("getReactions", "List", "getReactions()", "Returns the response reactions")
                    ),
                    List.of(), List.of(),
                    List.of("IJsonRepresentation")),

            new PluginEntry.ComponentInfo("IPageConfigurator", "SPI contract for injecting CSS/JS references and configuring pages before rendering", "com.jwebmp.client",
                    List.of(
                            new PluginEntry.PropertyInfo("enabled", "boolean", "true", "Whether this configurator is active"),
                            new PluginEntry.PropertyInfo("sortOrder", "int", "500", "Execution order among configurators (lower runs first)")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Custom Page Configurator", "Inject custom CSS into every page",
                            "public class MyConfigurator implements IPageConfigurator&lt;MyConfigurator&gt; {\n    @Override\n    public IPage&lt;?&gt; configure(IPage&lt;?&gt; page) {\n        page.getBody().addCssReference(new CSSReference(\"custom\", \"custom.css\"));\n        return page;\n    }\n    @Override\n    public Integer sortOrder() { return 100; }\n}", "java")),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage", "configure(IPage&lt;?&gt; page)", "Configures the page before rendering"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the execution order"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "enabled()", "Returns whether this configurator is active")
                    ),
                    List.of(), List.of(),
                    List.of("IDefaultService")),

            new PluginEntry.ComponentInfo("IPage", "Page contract discovered via ServiceLoader for automatic route registration", "com.jwebmp.client",
                    List.of(
                            new PluginEntry.PropertyInfo("url", "String", "null", "The page URL path from @PageConfiguration"),
                            new PluginEntry.PropertyInfo("title", "String", "null", "The page title")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Create a Page", "Define a routable page",
                            "@PageConfiguration(url = \"/dashboard\")\npublic class DashboardPage extends Page&lt;DashboardPage&gt; {\n    public DashboardPage() {\n        getBody().add(new H1&lt;&gt;().setText(\"Dashboard\"));\n    }\n}", "java")),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("getBody", "Body", "getBody()", "Returns the page body element"),
                            new PluginEntry.MethodInfo("getHead", "Head", "getHead()", "Returns the page head element"),
                            new PluginEntry.MethodInfo("getOptions", "PageOptions", "getOptions()", "Returns the page options")
                    ),
                    List.of(), List.of(),
                    List.of("IComponentHierarchyBase")),

            new PluginEntry.ComponentInfo("SiteCallIntercepter", "SPI interceptor for processing all site-wide calls with CRTP and sort-ordering", "com.jwebmp.client",
                    List.of(
                            new PluginEntry.PropertyInfo("sortOrder", "int", "500", "Execution order among interceptors")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Site Interceptor", "Log all incoming site calls",
                            "public class LoggingInterceptor implements SiteCallIntercepter&lt;LoggingInterceptor&gt; {\n    @Override\n    public void intercept(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response) {\n        log.info(\"Call from: \" + call.getComponentId());\n    }\n}", "java")),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("intercept", "void", "intercept(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response)", "Intercepts and processes a site call"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the execution order")
                    ),
                    List.of(), List.of(),
                    List.of("IDefaultService")),

            new PluginEntry.ComponentInfo("AjaxCallIntercepter", "SPI interceptor for processing AJAX event calls with CRTP and sort-ordering", "com.jwebmp.client",
                    List.of(
                            new PluginEntry.PropertyInfo("sortOrder", "int", "500", "Execution order among interceptors")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("AJAX Interceptor", "Validate authentication on AJAX calls",
                            "public class AuthInterceptor implements AjaxCallIntercepter&lt;AuthInterceptor&gt; {\n    @Override\n    public void intercept(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response) {\n        if (!isAuthenticated()) {\n            response.addReaction(new AjaxResponseReaction(\"redirect\", \"/login\"));\n        }\n    }\n}", "java")),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("intercept", "void", "intercept(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response)", "Intercepts and processes an AJAX call"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the execution order")
                    ),
                    List.of(), List.of(),
                    List.of("IDefaultService")),

            new PluginEntry.ComponentInfo("DataCallIntercepter", "SPI interceptor for processing data component calls with CRTP and sort-ordering", "com.jwebmp.client",
                    List.of(
                            new PluginEntry.PropertyInfo("sortOrder", "int", "500", "Execution order among interceptors")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Data Interceptor", "Add caching headers to data responses",
                            "public class CacheInterceptor implements DataCallIntercepter&lt;CacheInterceptor&gt; {\n    @Override\n    public void intercept(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response) {\n        // Add cache control logic\n    }\n}", "java")),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("intercept", "void", "intercept(AjaxCall&lt;?&gt; call, AjaxResponse&lt;?&gt; response)", "Intercepts and processes a data call"),
                            new PluginEntry.MethodInfo("sortOrder", "Integer", "sortOrder()", "Returns the execution order")
                    ),
                    List.of(), List.of(),
                    List.of("IDefaultService"))
    );

    public ClientPluginPage()
    {
        super(PluginCatalog.getById("client").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Implement a Page Configurator",
                        "Create a page configurator that injects CSS/JS references before rendering.",
                        "public class MyPageConfigurator\n        implements IPageConfigurator<MyPageConfigurator> {\n    @Override\n    public IPage<?> configure(IPage<?> page) {\n        // add CSS/JS references, configure body children\n        return page;\n    }\n    @Override\n    public Integer sortOrder() { return 500; }\n}",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "uses", "Discovered at startup to inject CSS/JS references and configure page lifecycle"),
                new PluginEntry.SpiDetail("IPage", "uses", "Page implementations discovered via ServiceLoader for route registration"),
                new PluginEntry.SpiDetail("SiteCallIntercepter", "uses", "Interceptor for processing all site calls with CRTP and sort-ordering"),
                new PluginEntry.SpiDetail("AjaxCallIntercepter", "uses", "Interceptor for processing AJAX calls with CRTP and sort-ordering"),
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Registers client Guice bindings for call pipeline and interceptors")
        );
    }
}
