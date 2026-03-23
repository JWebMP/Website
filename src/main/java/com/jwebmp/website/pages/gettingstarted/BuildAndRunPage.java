package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-build-run")
@NgRoutable(path = "getting-started/build-and-run")
public class BuildAndRunPage extends WebsitePage<BuildAndRunPage> implements INgComponent<BuildAndRunPage> {
    public BuildAndRunPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Build with Maven. The Angular Maven Plugin generates the TypeScript project, "
                        + "installs npm dependencies, and runs ng build. Then start your app.",
                "m"));

        content.add(codeBlockWithTitle("Terminal",
                "mvn clean install\n"
                        + "java -jar target/my-app.jar\n"
                        + "\n"
                        + "# Open http://localhost:8080"));

        content.add(bodyText(
                "Your browser shows a WebAwesome card with a button — served from a reactive "
                        + "Vert.x server, rendered by Angular 20, generated entirely from Java.",
                "m"));

        layout.add(buildSection("STEP 6",
                "Build and Run",
                "mvn install → java -jar → open browser.",
                true, content));
        getMain().add(layout);
    }
}

