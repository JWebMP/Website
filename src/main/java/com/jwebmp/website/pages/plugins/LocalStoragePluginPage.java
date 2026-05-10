package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-localstorage")
@NgRoutable(path = "plugins/localstorage")
public class LocalStoragePluginPage extends PluginDetailPage<LocalStoragePluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("LocalStoragePageConfigurator", "Page configurator that registers local storage support and sends a WebSocket 'LocalStorage' message on boot.", "com.jwebmp.plugins.security.localstorage",
                    List.of(
                            new PluginEntry.PropertyInfo("localStorage", "boolean", "true", "Whether local storage support is enabled")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Module requirement", "Add to your module-info.java.",
                                    "module com.myapp {\n    requires com.jwebmp.plugins.security.localstorage;\n}", "java")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("configure", "IPage&lt;?&gt;", "IPage&lt;?&gt; page", "Configures the page for local storage"),
                            new PluginEntry.MethodInfo("enabled", "boolean", "", "Returns whether local storage is enabled"),
                            new PluginEntry.MethodInfo("setLocalStorage", "void", "boolean localStorage", "Enables/disables local storage support")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("LocalStorageInterceptor", "Ajax call interceptor that reads/writes local storage UUID for device identification.", "com.jwebmp.plugins.security.localstorage.implementations",
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("intercept", "void", "AjaxCall call, AjaxResponse response", "Intercepts Ajax calls to manage local storage device ID")
                    ),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("LocalStorageWSMessageReceiver", "WebSocket message receiver that handles 'LocalStorage' messages for session group management.", "com.jwebmp.plugins.security.localstorage.implementations",
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("messageNames", "Set&lt;String&gt;", "", "Returns {\"LocalStorage\"}"),
                            new PluginEntry.MethodInfo("receiveMessage", "Uni&lt;Void&gt;", "WebSocketMessageReceiver mr", "Processes local storage data and assigns WebSocket groups")
                    ),
                    List.of(), List.of(), List.of())
    );

    public LocalStoragePluginPage()
    {
        super(PluginCatalog.getById("localstorage").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Inject device ID", "Access the browser's unique device identifier via Guice injection.",
                        """
                                @Inject
                                @Named("localstorage")
                                private UUID deviceId;
                                
                                // Use deviceId to identify the browser/device""", "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "Registers local storage page configuration and WebSocket boot message"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "Includes com.jwebmp.plugins.security.localstorage in Guice scanning"),
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Binds @Named(\"localstorage\") UUID and String providers in CallScope"),
                new PluginEntry.SpiDetail("IWebSocketMessageReceiver", "provides", "Handles 'LocalStorage' WebSocket messages for session management"),
                new PluginEntry.SpiDetail("AjaxCallIntercepter", "provides", "Intercepts Ajax calls to read/write local storage device identifiers")
        );
    }
}

