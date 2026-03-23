package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;

@NgComponent("jwebmp-home")
@NgRoutable(path = "home")
public class HomePage extends WebsitePage<HomePage> implements INgComponent<HomePage>
{
    public HomePage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Hero only — sub-sections are now individual pages
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP lets Java developers build complete, reactive web applications — frontend and backend — "
                + "in a single language. Write annotated Java classes; get a production-ready Angular 20 SPA served "
                + "on a Vert.x 5 reactive server. No context-switching. No hand-written TypeScript. "
                + "Just Java, all the way down.",
                "l"));

        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.add(buildTag("Java 25+", Variant.Brand));
        tags.add(buildTag("Angular 20", Variant.Danger));
        tags.add(buildTag("Vert.x 5", Variant.Warning));
        tags.add(buildTag("JPMS", Variant.Success));
        tags.add(buildTag("Reactive", Variant.Neutral));
        content.add(tags);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Get Started", "/getting-started", Variant.Brand, null));
        ctas.add(buildCta("See the Architecture", "/architecture", Variant.Neutral, Appearance.Outlined));
        ctas.add(buildCta("Browse Plugins", "/plugins", Variant.Neutral, Appearance.Outlined));
        content.add(ctas);

        layout.add(buildSection("FULL-STACK JAVA WEB FRAMEWORK",
                "Rapid Application Development — One Language, Both Ends",
                "Write Java. Generate Angular. Ship reactive web apps.",
                false, content));
    }
}
