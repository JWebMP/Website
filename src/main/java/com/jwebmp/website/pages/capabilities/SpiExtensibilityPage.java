package com.jwebmp.website.pages.capabilities;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-cap-spi")
@NgRoutable(path = "capabilities/spi-extensibility")
public class SpiExtensibilityPage extends WebsitePage<SpiExtensibilityPage> implements INgComponent<SpiExtensibilityPage> {
    public SpiExtensibilityPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP is designed around SPI contracts. Every extension point — pages, configurators, "
                        + "events, render hooks, interceptors — is a ServiceLoader interface. Register your "
                        + "implementation in module-info.java or META-INF/services, and the framework picks it up "
                        + "at startup. No reflection hacks, no classpath scanning.",
                "m"));

        content.add(codeBlockWithTitle("Extend with a Page Configurator",
                """
                        public class AnalyticsConfigurator
                                implements IPageConfigurator<AnalyticsConfigurator> {
                        
                            @Override
                            public IPage<?> configure(IPage<?> page) {
                                page.addJavaScriptReference(
                                    new JavascriptReference("analytics", 1.0, "analytics.js"));
                                return page;
                            }
                        
                            @Override
                            public Integer sortOrder() { return 500; }
                        }"""));

        content.add(codeBlockWithTitle("Register in module-info.java",
                "provides IPageConfigurator with AnalyticsConfigurator;"));

        layout.add(buildSection("EXTENSIBILITY", "SPI-Driven Extension Points", "Implement an interface. Register it. Done.", false, content));
        getMain().add(layout);
    }
}

