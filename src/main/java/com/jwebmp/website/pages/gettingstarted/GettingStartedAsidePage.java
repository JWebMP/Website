package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.markdown.Markdown;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.text.WaText;

/**
 * Aside component for the Getting Started page.
 * <p>
 * Displays compact code snippets for the Maven BOM import,
 * plugin dependency, and module descriptor in the named "aside" router-outlet.
 */
@NgComponent("jwebmp-getting-started-aside")
@NgRoutable(path = "getting-started", outlet = "aside")
public class GettingStartedAsidePage extends DivSimple<GettingStartedAsidePage> implements INgComponent<GettingStartedAsidePage>
{
    public GettingStartedAsidePage()
    {
        setTag("aside");
        addClass("getting-started-aside");
        addStyle("position:sticky");
        addStyle("top:var(--wa-spacing-large)");
        addStyle("padding:var(--wa-spacing-large)");
        addStyle("min-width:14rem");
        addStyle("display:flex");
        addStyle("flex-direction:column");
        addStyle("gap:var(--wa-spacing-large)");

        // ── BOM Import ──
        add(compactSnippet("BOM Import",
                """
                        <dependencyManagement>
                            <dependencies>
                                <dependency>
                                    <groupId>com.jwebmp</groupId>
                                    <artifactId>jwebmp-bom</artifactId>
                                    <version>${jwebmp.version}</version>
                                    <type>pom</type>
                                    <scope>import</scope>
                                </dependency>
                            </dependencies>
                        </dependencyManagement>""", PrismLanguage.Xml));

        // ── Plugin Dependency ──
        add(compactSnippet("Plugin Dependency",
                """
                        <dependency>
                            <groupId>com.jwebmp.plugins</groupId>
                            <artifactId>web-awesome</artifactId>
                        </dependency>""", PrismLanguage.Xml));

        // ── Module Descriptor ──
        add(compactSnippet("module-info.java",
                """
                        module my.app {
                            requires transitive com.jwebmp.webawesome;
                            opens my.app to com.google.guice;
                        }""", PrismLanguage.Java));
    }

    private DivSimple<?> compactSnippet(String title, String code, PrismLanguage language)
    {
        var wrapper = new DivSimple<>();
        wrapper.addClass("aside-snippet");

        var label = new WaText<>();
        label.setTag("div");
        label.setWaCaption("s");
        label.setWaFontWeight("semibold");
        label.setText(title);
        label.addClass("aside-snippet-label");
        wrapper.add(label);

        var md = new Markdown<>("```" + language.getLanguageCode() + "\n" + code + "\n```");
        md.setClipboard(true);
        md.addClass("aside-snippet-code");
        wrapper.add(md);

        return wrapper;
    }
}

