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
    public ClientPluginPage()
    {
        super(PluginCatalog.getById("client").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of(
                new PluginEntry.ComponentInfo("AjaxCall", "Request DTO carrying event data from browser to server", "com.jwebmp.client"),
                new PluginEntry.ComponentInfo("AjaxResponse", "Response DTO carrying DOM updates from server to browser", "com.jwebmp.client"),
                new PluginEntry.ComponentInfo("IPageConfigurator", "SPI contract for injecting CSS/JS references and configuring pages", "com.jwebmp.client"),
                new PluginEntry.ComponentInfo("IPage", "Page contract discovered via ServiceLoader for automatic route registration", "com.jwebmp.client"),
                new PluginEntry.ComponentInfo("SiteCallIntercepter", "SPI interceptor for site-wide call processing", "com.jwebmp.client"),
                new PluginEntry.ComponentInfo("AjaxCallIntercepter", "SPI interceptor for AJAX call processing", "com.jwebmp.client"),
                new PluginEntry.ComponentInfo("DataCallIntercepter", "SPI interceptor for data call processing", "com.jwebmp.client")
        );
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
