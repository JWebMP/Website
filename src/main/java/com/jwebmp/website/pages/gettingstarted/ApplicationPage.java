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
                "Define your Angular application with @NgApp. This tells the generator the "
                        + "app name and root component.",
                "m"));

        content.add(codeBlockWithTitle("MyApplication.java",
                """
                        @NgApp(value = "my-app", bootComponent = MyHomePage.class)
                        public class MyApplication extends NGApplication<MyApplication> {
                            public MyApplication() {
                                getOptions().setTitle("My App");
                            }
                        }"""));

        layout.add(buildSection("STEP 4",
                "Define the Application",
                "@NgApp names your app and sets the root component.",
                true, content));
        getMain().add(layout);
    }
}

