package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.markdown.Markdown;
import com.jwebmp.webawesome.components.text.WaText;

/**
 * Aside component for the Getting Started page.
 * <p>
 * Displays compact code snippets for the Maven BOM import,
 * plugin dependency, and module descriptor in the named "aside" router-outlet.
 * <p>
 * Reacts to the Maven / Gradle toggle in the header by reading
 * from localStorage and listening for storage events.
 */
@NgComponent("jwebmp-getting-started-aside")
@NgRoutable(path = "getting-started", outlet = "aside")
@NgField("useGradle = false;")
@NgField("private _storageListener: any;")
@NgField("private _customListener: any;")
@NgImportReference(value = "OnDestroy, OnInit", reference = "@angular/core")
@NgMethod("""
        ngOnInit() {
            const saved = localStorage.getItem('jwebmp-build-tool');
            if (saved) { this.useGradle = saved === 'gradle'; }
            this._storageListener = (e: StorageEvent) => {
                if (e.key === 'jwebmp-build-tool') {
                    this.useGradle = e.newValue === 'gradle';
                }
            };
            this._customListener = (e: any) => {
                this.useGradle = e.detail;
            };
            window.addEventListener('storage', this._storageListener);
            window.addEventListener('jwebmp-build-tool-change', this._customListener);
        }""")
@NgMethod("""
        ngOnDestroy() {
            window.removeEventListener('storage', this._storageListener);
            window.removeEventListener('jwebmp-build-tool-change', this._customListener);
        }""")
public class GettingStartedAsidePage extends DivSimple<GettingStartedAsidePage> implements INgComponent<GettingStartedAsidePage>
{
    public GettingStartedAsidePage()
    {
        setTag("aside");
        addClass("getting-started-aside");
        addStyle("position:sticky");
        addStyle("top:var(--wa-spacing-large)");
        addStyle("padding:0 var(--wa-spacing-large) var(--wa-spacing-large) var(--wa-spacing-large)");
        addStyle("min-width:14rem");
        addStyle("display:flex");
        addStyle("flex-direction:column");
        addStyle("gap:var(--wa-spacing-large)");

        // ── BOM Import (Maven) ──
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
                        </dependencyManagement>""", "xml", "!useGradle"));

        // ── BOM Import (Gradle) ──
        add(compactSnippet("BOM Import",
                """
                        dependencies {
                            implementation platform(
                                "com.jwebmp:jwebmp-bom:$jwebmpVersion"
                            )
                        }""", "groovy", "useGradle"));

        // ── Plugin Dependency (Maven) ──
        add(compactSnippet("Plugin Dependency",
                """
                        <dependency>
                            <groupId>com.jwebmp</groupId>
                            <artifactId>jwebmp-core</artifactId>
                        </dependency>""", "xml", "!useGradle"));

        // ── Plugin Dependency (Gradle) ──
        add(compactSnippet("Plugin Dependency",
                """
                        dependencies {
                            implementation "com.jwebmp:jwebmp-core"
                        }""", "groovy", "useGradle"));

        // ── Module Descriptor (same for both) ──
        add(compactSnippet("module-info.java",
                """
                        module my.app {
                            requires transitive com.jwebmp.core;
                            opens my.app to com.google.guice;
                        }""", "java", null));
    }

    private DivSimple<?> compactSnippet(String title, String code, String language, String ngIf)
    {
        var wrapper = new DivSimple<>();
        wrapper.addClass("aside-snippet");
        if (ngIf != null)
        {
            wrapper.addAttribute("*ngIf", ngIf);
        }

        var label = new WaText<>();
        label.setTag("div");
        label.setWaCaption("s");
        label.setWaFontWeight("semibold");
        label.setText(title);
        label.addClass("aside-snippet-label");
        wrapper.add(label);

        var md = new Markdown<>("```" + language + "\n" + code + "\n```");
        md.setClipboard(true);
        md.addClass("aside-snippet-code");
        md.addClass("wa-body-s");
        wrapper.add(md);

        return wrapper;
    }
}

