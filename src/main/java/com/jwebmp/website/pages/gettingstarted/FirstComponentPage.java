package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-first-component")
@NgRoutable(path = "getting-started/first-component")
public class FirstComponentPage extends WebsitePage<FirstComponentPage> implements INgComponent<FirstComponentPage> {
    public FirstComponentPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "Create your first page component. @NgComponent gives it an Angular selector. "
                        + "@NgRoutable assigns its URL. The constructor builds the component tree in Java.",
                "m"));

        content.add(codeBlockWithTitle("MyHomePage.java",
                """
                        @NgComponent("my-home")
                        @NgRoutable(path = "")
                        public class MyHomePage extends DivSimple<MyHomePage>
                                implements INgComponent<MyHomePage> {
                        
                            public MyHomePage() {
                                var card = new WaCard<>();
                                card.add("Welcome to JWebMP!");
                                add(card);
                        
                                var button = new WaButton<>("Click Me", Variant.Brand);
                                add(button);
                            }
                        }"""));

        layout.add(buildSection("STEP 5",
                "Your First Component",
                "Java class in, Angular component out.",
                false, content));
        getMain().add(layout);
    }
}

