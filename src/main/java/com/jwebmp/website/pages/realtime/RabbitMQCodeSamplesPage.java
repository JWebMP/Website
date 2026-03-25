package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-rabbitmq-code")
@NgRoutable(path = "real-time/rabbitmq-code-samples")
public class RabbitMQCodeSamplesPage extends WebsitePage<RabbitMQCodeSamplesPage> implements INgComponent<RabbitMQCodeSamplesPage> {
    public RabbitMQCodeSamplesPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(codeBlockWithTitle("Server: publish to a RabbitMQ group", "@Inject\nprivate RabbitPublishToGroup publisher;\n\npublisher.publish(\"dashboard-updates\", jsonPayload);\npublisher.publish(\"user-\" + userId, notification);"));
        content.add(codeBlockWithTitle("Client: declarative subscription (Java component)", "var dashboard = new DivSimple<>();\ndashboard.addAttribute(\"[data-rabbit-groups]\", \"'live-feed'\");\nadd(dashboard);"));
        content.add(codeBlockWithTitle("Setup: Maven + environment + module-info", "<!-- pom.xml -->\n<dependency>\n    <groupId>com.jwebmp</groupId>\n    <artifactId>jwebmp-rabbitmq</artifactId>\n</dependency>\n\n# Environment\nRABBITMQ_HOST=localhost\nRABBITMQ_PORT=5672\nRABBITMQ_WEB_STOMP_PORT=15674\n\n// module-info.java\nrequires com.jwebmp.rabbit;\nrequires com.guicedee.rabbit;", PrismLanguage.Xml));
        layout.add(buildSection(null, "RabbitMQ Comms — Code", "@Inject, .publish(), done. Or use the Angular directive.", true, content));
        getMain().add(layout);
    }
}

