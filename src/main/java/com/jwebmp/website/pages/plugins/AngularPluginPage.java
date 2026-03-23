package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-angular")
@NgRoutable(path = "plugins/angular")
public class AngularPluginPage extends PluginDetailPage<AngularPluginPage>
{
    public AngularPluginPage()
    {
        super(PluginCatalog.getById("angular").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("NGApplication", "Base class for @NgApp — defines the Angular application", "com.jwebmp.core.angular"),
                new PluginEntry.ComponentInfo("NgIf", "Angular 17+ @if control-flow component", "com.jwebmp.core.angular.components"),
                new PluginEntry.ComponentInfo("NgFor", "Angular 17+ @for control-flow component", "com.jwebmp.core.angular.components"),
                new PluginEntry.ComponentInfo("RouterLink", "Router link with [routerLink], [queryParams], [state] binding", "com.jwebmp.core.angular.components"),
                new PluginEntry.ComponentInfo("RouterOutlet", "Angular router outlet placeholder", "com.jwebmp.core.angular.components"),
                new PluginEntry.ComponentInfo("TypeScriptCompiler", "Orchestrates .ts code generation from Java annotations", "com.jwebmp.core.angular.compiler"),
                new PluginEntry.ComponentInfo("StompServer", "STOMP/WebSocket bridge at /eventbus", "com.jwebmp.core.angular.websocket")
        );
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Define an Angular App",
                        "Create an Angular 20 application with a boot component and routable page.",
                        "@NgApp(value = \"my-app\", bootComponent = AppComponent.class)\npublic class MyApp extends NGApplication<MyApp> { }\n\n@NgComponent(\"app-root\")\npublic class AppComponent extends DivSimple<AppComponent>\n        implements INgComponent<AppComponent> { }\n\n@NgRoutable(path = \"dashboard\", parent = {AppComponent.class})\n@NgComponent(\"app-dashboard\")\npublic class DashboardPage extends DivSimple<DashboardPage>\n        implements INgComponent<DashboardPage> { }",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("VertxRouterConfigurator", "provides", "Registers SPA routes, /assets/*, and fallback routing for Angular Router"),
                new PluginEntry.SpiDetail("IWebSocketMessageReceiver", "provides", "Built-in receivers for ajax, data, dataSend, AddToWebSocketGroup, RemoveFromWebSocketGroup"),
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Registers Angular-specific Guice bindings and WebSocket infrastructure"),
                new PluginEntry.SpiDetail("AngularScanPackages", "uses", "Discovered to determine which Java packages to scan for Angular annotations"),
                new PluginEntry.SpiDetail("TypescriptIndexPageConfigurator", "uses", "Discovered for cross-plugin asset integration")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("EnvironmentOptions", "class", null, "Java object serialized as TypeScript const environment — app name, API URLs, feature flags"),
                new PluginEntry.ConfigEntry("StompServer heartbeat", "int/int", "10s/50s", "Heartbeat intervals for STOMP WebSocket connection")
        );
    }
}
