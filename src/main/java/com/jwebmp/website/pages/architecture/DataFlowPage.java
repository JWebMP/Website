package com.jwebmp.website.pages.architecture;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-arch-dataflow")
@NgRoutable(path = "architecture/data-flow")
public class DataFlowPage extends WebsitePage<DataFlowPage> implements INgComponent<DataFlowPage> {
    public DataFlowPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(mermaidDiagramWithTitle("Request-Response Flow",
                """
                        sequenceDiagram
                          participant Browser
                          participant Vertx as Vert.x Server
                          participant Handler as Java Handler

                          Browser->>Vertx: GET /dashboard
                          Vertx->>Browser: index.html + dist/ (StaticHandler)

                          Browser->>Vertx: POST /jwajax (AjaxCall JSON)
                          Vertx->>Handler: deserialize
                          Handler->>Handler: intercept chain
                          Handler->>Handler: fireEvent()
                          Handler->>Vertx: AjaxResponse
                          Vertx->>Browser: DOM updates JSON

                          Browser->>Vertx: WS /eventbus (STOMP subscribe)
                          Vertx->>Handler: RabbitMQ exchange
                          Vertx->>Browser: STOMP message
                        """));

        layout.add(buildSection("DATA FLOW", "Request, Event, and Message Paths",
                "HTTP for pages, AJAX for events, WebSocket for real-time.", false, content));
        getMain().add(layout);
    }
}

