package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-rabbitmq")
@NgRoutable(path = "plugins/rabbitmq")
public class RabbitMQPluginPage extends PluginDetailPage<RabbitMQPluginPage>
{
    public RabbitMQPluginPage()
    {
        super(PluginCatalog.getById("rabbitmq").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Module Setup",
                        "Configure RabbitMQ in your module-info.java.",
                        "// module-info.java\nmodule com.myapp {\n    requires com.jwebmp.rabbit;\n    requires com.guicedee.rabbit;\n}\n\n// Environment variables:\n// RABBITMQ_HOST=localhost\n// RABBITMQ_PORT=5672\n// RABBITMQ_WEB_STOMP_PORT=15674",
                        "java"),
                new PluginEntry.ExampleSnippet("Angular Directive Usage",
                        "Subscribe to RabbitMQ groups from Angular templates.",
                        "<!-- Auto-subscribe to groups when component is rendered -->\n<div [data-rabbit-groups]=\"['notifications', 'updates']\">\n  Real-time content here\n</div>",
                        "html")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "RabbitMQPageConfigurator registers STOMP client scripts and Angular directive"),
                new PluginEntry.SpiDetail("IGuiceModule", "provides", "Registers RabbitMQ Vert.x client and exchange management bindings"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "Ensures RabbitMQ packages are included in Guice scanning")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("RABBITMQ_HOST", "String", "localhost", "RabbitMQ server hostname"),
                new PluginEntry.ConfigEntry("RABBITMQ_PORT", "int", "5672", "RabbitMQ AMQP port"),
                new PluginEntry.ConfigEntry("RABBITMQ_WEB_STOMP_PORT", "int", "15674", "RabbitMQ Web STOMP port for browser connections"),
                new PluginEntry.ConfigEntry("RABBITMQ_USERNAME", "String", "guest", "RabbitMQ authentication username"),
                new PluginEntry.ConfigEntry("RABBITMQ_PASSWORD", "String", "guest", "RabbitMQ authentication password")
        );
    }
}
