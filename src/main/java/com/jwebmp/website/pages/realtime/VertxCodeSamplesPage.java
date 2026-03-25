package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-vertx-code")
@NgRoutable(path = "real-time/vertx-code-samples")
public class VertxCodeSamplesPage extends WebsitePage<VertxCodeSamplesPage> implements INgComponent<VertxCodeSamplesPage> {
    public VertxCodeSamplesPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(codeBlockWithTitle("Server: publish via Vert.x event bus", "// Publish to all browsers listening on \"dashboard\"\nStompEventBusPublisher.publish(vertx, \"dashboard\", jsonPayload);\n\n// Or via IGuicedWebSocket (injected)\n@Inject IGuicedWebSocket webSocket;\nwebSocket.broadcastMessage(\"dashboard\", jsonPayload);"));
        content.add(codeBlockWithTitle("Server: custom WebSocket receiver", "public class MyDataReceiver\n    implements IWebSocketMessageReceiver<MyResponse, MyDataReceiver> {\n\n    @Override\n    public String getMessageDirector() { return \"myData\"; }\n\n    @Override\n    public Uni<MyResponse> receiveMessage(WebSocketMessageReceiver<?> msg) {\n        return Uni.createFrom().item(new MyResponse(data));\n    }\n}"));
        content.add(codeBlockWithTitle("Client: listen in Angular (TypeScript)", "// EventBusService is auto-generated and auto-injected\nthis.eventBusService.listen('dashboard', listenerId)\n    .subscribe(data => {\n        this.dashboardData = data;\n    });", PrismLanguage.TypeScript));
        layout.add(buildSection(null, "Vert.x Event Bus — Code", "Publish from Java. Listen in Angular. No broker.", true, content));
        getMain().add(layout);
    }
}

