package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-sessionstorage")
@NgRoutable(path = "plugins/sessionstorage")
public class SessionStoragePluginPage extends PluginDetailPage<SessionStoragePluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("SessionStoragePageConfigurator", "Page configurator that registers session storage support and sends a WebSocket 'SessionStorage' message on boot.", "com.jwebmp.plugins.security.sessionstorage",
                    List.of(
                            new PluginEntry.PropertyInfo("sessionStorage", "boolean", "true", "Whether session storage support is enabled")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.security.sessionstorage;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Configures the page for session storage"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns whether session storage is enabled"),
                            new PluginEntry.MethodInfo("setSessionStorage", "void", "boolean sessionStorage", "Enables/disables session storage support")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("SessionStorageWSMessageReceiver", "WebSocket message receiver that handles 'SessionStorage' messages for per-tab session group management.", "com.jwebmp.plugins.security.sessionstorage.implementations",
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("messageNames", "Set&lt;String&gt;", "", "Returns {\"SessionStorage\"}"),
                            new PluginEntry.MethodInfo("receiveMessage", "Uni&lt;Void&gt;", "WebSocketMessageReceiver mr", "Processes session storage data and assigns WebSocket groups per tab")
                    ),
                    List.of(), List.of(), List.of())
    );

    public SessionStoragePluginPage()
    {
        super(PluginCatalog.getById("sessionstorage").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Inject tab ID", "Access the browser tab's unique identifier via Guice injection.",
                        """
                                @Inject
                                @Named("sessionstorage")
                                private UUID tabId;
                                
                                // Use tabId to identify the specific browser tab""", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "Registers session storage page configuration and WebSocket boot message"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "Includes com.jwebmp.plugins.security.sessionstorage in Guice scanning"),
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Binds @Named(\"sessionstorage\") UUID and String providers in CallScope"),
                new PluginEntry.SpiDetail("IWebSocketMessageReceiver", "provides", "Handles 'SessionStorage' WebSocket messages for per-tab session management")
        );
    }
}

