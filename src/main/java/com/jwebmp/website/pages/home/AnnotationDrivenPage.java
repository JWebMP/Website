package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-annotation-driven")
@NgRoutable(path = "home/annotation-driven")
public class AnnotationDrivenPage extends WebsitePage<AnnotationDrivenPage> implements INgComponent<AnnotationDrivenPage> {
    public AnnotationDrivenPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP uses annotations to describe your Angular application. @NgComponent creates a component. "
                        + "@NgRoutable assigns a route. @NgDataService generates a typed data service. The annotation "
                        + "processor produces the .ts files, routing modules, and angular.json — a complete, buildable "
                        + "Angular 20 project from your Java source alone.",
                "m"));

        content.add(codeBlockWithTitle("A complete routed page — in Java",
                "@NgComponent(\"sales-dashboard\")\n"
                        + "@NgRoutable(path = \"dashboard\")\n"
                        + "public class SalesDashboard extends DivSimple<SalesDashboard>\n"
                        + "    implements INgComponent<SalesDashboard> {\n"
                        + "\n"
                        + "    public SalesDashboard() {\n"
                        + "        var grid = new AGGrid<>(SalesRow.class);\n"
                        + "        grid.addColumn(\"region\", \"Region\");\n"
                        + "        grid.addColumn(\"revenue\", \"Revenue\");\n"
                        + "        add(grid);\n"
                        + "\n"
                        + "        var chart = new AGBarChart();\n"
                        + "        chart.getData().addSeries(\"revenue\");\n"
                        + "        add(chart);\n"
                        + "    }\n"
                        + "}"));

        content.add(captionText("This generates an Angular component, a route at /dashboard, "
                + "and wires AG Grid + AG Charts — all from a single Java class."));

        layout.add(buildSection("ANNOTATION-DRIVEN",
                "Java Annotations Become Angular Applications",
                "@NgComponent + @NgRoutable + build = production SPA.",
                false, content));

        getMain().add(layout);
    }
}

