package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-application")
@NgRoutable(path = "getting-started/application")
public class ApplicationPage extends WebsitePage<ApplicationPage> implements INgComponent<ApplicationPage> {
    public ApplicationPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "This step applies to Angular mode only. @NgApp tells the generator the application "
                        + "name and root component. SSR mode does not need an application class — the "
                        + "Vert.x server discovers pages and components via SPI automatically.",
                "m"));

        content.add(codeBlockWithTitle("MyApplication.java — Angular mode only",
                """
                        @NgApp(value = "my-app", bootComponent = MyHomePage.class)
                        public class MyApplication extends NGApplication<MyApplication> {
                            public MyApplication() {
                                getOptions().setTitle("My App");
                            }
                        }"""));

        layout.add(buildSection("STEP 4",
                "Define the Application",
                "@NgApp names your app and sets the root component. Angular mode only.",
                true, content));
        getMain().add(layout);
    }
}

