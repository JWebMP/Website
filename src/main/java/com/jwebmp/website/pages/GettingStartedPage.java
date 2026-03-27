package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.details.DetailsAppearance;
import com.jwebmp.webawesome.components.details.WaDetails;
import com.jwebmp.webawesome.components.tag.WaTag;

@NgComponent("jwebmp-getting-started")
@NgRoutable(path = "getting-started")
public class GettingStartedPage extends WebsitePage<GettingStartedPage> implements INgComponent<GettingStartedPage>
{
    public GettingStartedPage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Intro only — steps are now individual sub-pages
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "This guide walks you through creating a JWebMP application from scratch. "
                + "JWebMP supports two running modes — choose the one that fits your project:",
                "m"));

        // ── Prerequisites as linked pills ──
        var prereqLabel = captionText("Prerequisites");
        content.add(prereqLabel);

        var prereqs = new WaCluster<>();
        prereqs.setGap(PageSize.Small);
        prereqs.add(prereqPill("Java 25+", "https://adoptium.net", Variant.Brand));
        prereqs.add(prereqPill("Maven 3.9+", "https://maven.apache.org", Variant.Neutral));
        prereqs.add(prereqPill("Node.js 22+ (Angular mode)", "https://nodejs.org", Variant.Warning));
        content.add(prereqs);

        // ── Entry Points ──
        var entryStack = new WaStack();
        entryStack.setGap(PageSize.Medium);

        var angularDetails = new WaDetails<>();
        angularDetails.setSummary("Angular Mode (Client-Side SPA)");
        //angularDetails.setAppearance(DetailsAppearance.Outlined.toString());
        angularDetails.addStyle("--border-color", "var(--wa-color-brand-600)");
        angularDetails.setSpacing("var(--wa-spacing-large)");
        var angularContent = new WaStack();
        angularContent.setGap(PageSize.Small);
        angularContent.add(bodyText(
                "Include the Angular plugin and run the Maven angular plugin command to generate "
                + "a complete Angular 20 single-page application into the target directory. "
                + "Node.js is required at build time for the Angular CLI. The resulting SPA is static "
                + "and can be served from any host or CDN — the JWebMP server is entirely optional.",
                "m"));
        angularContent.add(codeBlock(
                """
                        @NgApp(value = "my-app", bootComponent = MyHomePage.class)
                        public class MyApplication extends NGApplication<MyApplication> {
                            public MyApplication() {
                                getOptions().setTitle("My App");
                            }
                        }""", PrismLanguage.Java));
        angularDetails.add(angularContent);
        entryStack.add(angularDetails);

        var ssrDetails = new WaDetails<>();
        ssrDetails.setSummary("SSR Mode (Server-Side Rendered)");
        //ssrDetails.setAppearance(DetailsAppearance.Outlined.toString());
        ssrDetails.addStyle("--border-color", "var(--wa-color-brand-600)");
        ssrDetails.setSpacing("var(--wa-spacing-large)");
        var ssrContent = new WaStack();
        ssrContent.setGap(PageSize.Small);
        ssrContent.add(bodyText(
                "Without the Angular plugin, components render server-side on Vert.x 5 with GuicedEE. "
                + "No Node.js, no frontend build step — just a static void main that calls "
                + "IGuiceContext.instance().inject(). Running the server alongside as a BFF or backend "
                + "gives you clean integration with GuicedEE services for REST, authentication, "
                + "WebSockets, persistence, and reactive workflows out of the box.",
                "m"));
        ssrContent.add(codeBlock(
                """
                        public class MyPageConfigurator
                                implements IPageConfigurator<MyPageConfigurator> {
                            @Override
                            public IPage<?> configure(IPage<?> page) {
                                // configure page components
                                return page;
                            }
                        }""", PrismLanguage.Java));
        ssrContent.add(codeBlock(
                """
                        public final class Boot {
                            public static void main(String[] args) {
                                System.setProperty("HTTP_ENABLED", "true");
                                IGuiceContext.instance().inject();
                            }
                        }""", PrismLanguage.Java));
        ssrDetails.add(ssrContent);
        entryStack.add(ssrDetails);

        content.add(entryStack);

        content.add(bodyText(
                "The Maven project, module descriptor, and your first component are identical for both modes. "
                + "The guide then branches for Bootstrap, Build, and Run. "
                + "Use the menu tree to navigate each step.",
                "m"));

        layout.add(buildSection("QUICK START",
                "Getting Started with JWebMP",
                "Choose your mode. Follow the steps. Ship your app.",
                false, content));
    }

    private Link<?> prereqPill(String label, String url, Variant variant)
    {
        var link = new Link<>();
        link.setTag("a");
        link.addAttribute("href", url);
        link.addAttribute("target", "_blank");
        link.addAttribute("rel", "noopener noreferrer");
        link.addStyle("text-decoration:none");

        var tag = new WaTag<>();
        tag.setText(escapeAngular(label));
        tag.setVariant(variant);
        tag.setPill(true);
        link.add(tag);

        return link;
    }
}
