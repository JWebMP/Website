package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-data-services")
@NgRoutable(path = "real-time/data-services")
public class DataServicesPage extends WebsitePage<DataServicesPage> implements INgComponent<DataServicesPage> {
    public DataServicesPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(richText("`@NgDataService` generates a typed Angular service that communicates with the server via the `EventBusService`. Define a Java class, annotate it, and implement `getData()` — the framework generates the TypeScript service, registers a listener, and handles serialization. The Angular component receives an `Observable` of your data type.", "m"));

        content.add(codeBlockWithTitle("@NgDataService — typed server-to-client data",
                "@NgDataService(value = \"SalesDashboardService\",\n    listenerName = \"salesDashboard\")\npublic class SalesDashboardDataService\n        implements INgDataService<SalesDashboardDataService> {\n\n    @Override\n    public DynamicData getData(AjaxCall<?> call, AjaxResponse<?> response) {\n        var data = new DynamicData();\n        data.put(\"rows\", salesService.findAll());\n        return data;\n    }\n}"));

        content.add(richText("Data services can operate over the AJAX pipeline or the WebSocket event bus. When the event bus is available, the generated service listens for push updates automatically. When it is not, data is fetched on component creation.", "m"));

        layout.add(buildSection("DATA SERVICES", "Typed Angular Services from Java", "`@NgDataService` generates observable data services — request or push.", true, content));
        getMain().add(layout);
    }
}

