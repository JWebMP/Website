package com.jwebmp.website.pages.frameworks;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.components.NgIf;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaGrid;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.card.WaCard;
import com.jwebmp.webawesome.components.details.WaDetails;
import com.jwebmp.webawesome.components.divider.WaDivider;
import com.jwebmp.website.catalog.PluginEntry;
import com.jwebmp.website.pages.WebsitePage;

import java.util.List;
import java.util.Map;

/**
 * Base class for framework hub pages (e.g. /frameworks/bootstrap).
 * <p>
 * Renders the framework overview with installation, features, and a component
 * grid where each component card links to its own per-component route
 * (e.g. /frameworks/bootstrap/bs-card).
 */
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
public abstract class FrameworkDetailPage<J extends FrameworkDetailPage<J>> extends WebsitePage<J> implements INgComponent<J>
{
    protected FrameworkDetailPage(PluginEntry plugin)
    {
        var layout = new WaStack<>();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Back link
        layout.add(buildCta("← Back to UI Frameworks", "/frameworks", Variant.Neutral, Appearance.Plain));

        // Header card
        var card = new WaCard<>();
        card.setAppearance(Appearance.Outlined);

        var outerStack = new WaStack<>();
        outerStack.setGap(PageSize.Medium);

        outerStack.add(buildFrameworkHeader(plugin));
        outerStack.add(new WaDivider<>());
        addCoordinatesSection(outerStack, plugin);
        addInstallationSection(outerStack, plugin);
        addNpmSection(outerStack, plugin);
        outerStack.add(new WaDivider<>());
        addFeaturesSection(outerStack, plugin);
        outerStack.add(new WaDivider<>());
        addQuickStartSection(outerStack, plugin);
        outerStack.add(new WaDivider<>());
        addSpiSection(outerStack, plugin);
        addPrerequisitesSection(outerStack, plugin);
        addLinksSection(outerStack, plugin);

        card.add(outerStack);
        layout.add(card);

        // Components grid — each links to its own route
        addComponentsGrid(layout);
    }

    // ══════════════════════════════════════════════════
    //  Template methods — override in subclasses
    // ══════════════════════════════════════════════════

    /**
     * The framework ID used in routes (e.g. "bootstrap", "web-awesome").
     */
    protected abstract String frameworkId();

    /**
     * Components exposed by this framework.
     */
    protected List<PluginEntry.ComponentInfo> frameworkComponents()
    {
        return List.of();
    }

    // ══════════════════════════════════════════════════
    //  Sections
    // ══════════════════════════════════════════════════

    private WaStack<?> buildFrameworkHeader(PluginEntry plugin)
    {
        var header = new WaStack<>();
        header.setGap(PageSize.Small);
        header.add(headingText("h1", "xl", plugin.getName()));
        header.add(bodyText(plugin.getDescription(), "m"));

        if (!plugin.getTechBadges().isEmpty())
        {
            var badges = new WaCluster<>();
            badges.setGap(PageSize.ExtraSmall);
            for (String badge : plugin.getTechBadges())
            {
                badges.add(buildTag(badge,
                        "License Required".equals(badge) ? Variant.Warning : Variant.Neutral));
            }
            header.add(badges);
        }

        if (plugin.isRequiresLicense() && plugin.getLicenseNote() != null)
        {
            var note = bodyText(plugin.getLicenseNote(), "s");
            note.setWaColorText("warning");
            header.add(note);
        }
        return header;
    }

    private void addCoordinatesSection(WaStack<?> parent, PluginEntry plugin)
    {
        var stack = new WaStack<>();
        stack.setGap(PageSize.ExtraSmall);
        stack.add(captionText("COORDINATES & MODULE"));
        stack.add(bodyText("Maven: " + plugin.getGroupId() + ":" + plugin.getArtifactId(), "s"));
        if (plugin.getJpmsModule() != null)
        {
            stack.add(bodyText("JPMS Module: " + plugin.getJpmsModule(), "s"));
        }
        if (plugin.getUpstreamName() != null)
        {
            String upstream = "Built on: " + plugin.getUpstreamName();
            if (plugin.getUpstreamVersion() != null) upstream += " " + plugin.getUpstreamVersion();
            stack.add(bodyText(upstream, "s"));
        }
        parent.add(stack);
    }

    private void addInstallationSection(WaStack<?> parent, PluginEntry plugin)
    {
        if (plugin.getMavenSnippet() == null && plugin.getGradleSnippet() == null) return;
        var details = new WaDetails<>();
        details.setSummary("Installation");
        details.setOpen(true);

        var stack = new WaStack<>();
        stack.setGap(PageSize.ExtraSmall);

        if (plugin.getMavenSnippet() != null)
        {
            var mavenIf = new NgIf("!useGradle");
            mavenIf.add(codeBlockWithTitle("Maven", plugin.getMavenSnippet(), "xml"));
            stack.add(mavenIf);
        }
        if (plugin.getGradleSnippet() != null)
        {
            var gradleIf = new NgIf("useGradle");
            gradleIf.add(codeBlockWithTitle("Gradle (Kotlin DSL)", plugin.getGradleSnippet(), "kotlin"));
            stack.add(gradleIf);
        }

        details.add(stack);
        parent.add(details);
    }

    private void addNpmSection(WaStack<?> parent, PluginEntry plugin)
    {
        if (plugin.getNpmDependencies().isEmpty()) return;
        var details = new WaDetails<>();
        details.setSummary("NPM Dependencies (auto-included)");
        details.setOpen(true);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> dep : plugin.getNpmDependencies().entrySet())
        {
            sb.append("\"").append(dep.getKey()).append("\": \"").append(dep.getValue()).append("\"\n");
        }
        details.add(codeBlock(sb.toString().trim(), "json"));
        parent.add(details);
    }

    private void addFeaturesSection(WaStack<?> parent, PluginEntry plugin)
    {
        if (plugin.getFeatures().isEmpty()) return;
        var details = new WaDetails<>();
        details.setSummary("Features (" + plugin.getFeatures().size() + ")");
        details.setOpen(true);

        var stack = new WaStack<>();
        stack.setGap(PageSize.ExtraSmall);
        for (String feature : plugin.getFeatures())
        {
            var text = bodyText(feature, "s");
            text.setWaColorText("quiet");
            stack.add(text);
        }
        details.add(stack);
        parent.add(details);
    }

    private void addQuickStartSection(WaStack<?> parent, PluginEntry plugin)
    {
        if (plugin.getQuickStartCode() == null) return;
        var details = new WaDetails<>();
        details.setSummary("Quick Start");
        details.setOpen(true);
        details.add(codeBlock(plugin.getQuickStartCode()));
        parent.add(details);
    }

    private void addSpiSection(WaStack<?> parent, PluginEntry plugin)
    {
        if (plugin.getSpiProvides().isEmpty() && plugin.getSpiUses().isEmpty()) return;
        var details = new WaDetails<>();
        details.setSummary("SPI Extension Points");
        details.setOpen(true);

        var stack = new WaStack<>();
        stack.setGap(PageSize.ExtraSmall);

        if (!plugin.getSpiProvides().isEmpty())
        {
            var cluster = new WaCluster<>();
            cluster.setGap(PageSize.ExtraSmall);
            for (String spi : plugin.getSpiProvides())
            {
                cluster.add(buildTag("provides " + spi, Variant.Success));
            }
            stack.add(cluster);
        }
        if (!plugin.getSpiUses().isEmpty())
        {
            var cluster = new WaCluster<>();
            cluster.setGap(PageSize.ExtraSmall);
            for (String spi : plugin.getSpiUses())
            {
                cluster.add(buildTag("uses " + spi, Variant.Brand));
            }
            stack.add(cluster);
        }
        details.add(stack);
        parent.add(details);
    }

    private void addPrerequisitesSection(WaStack<?> parent, PluginEntry plugin)
    {
        if (plugin.getPrerequisites().isEmpty()) return;
        var details = new WaDetails<>();
        details.setSummary("Prerequisites");
        details.setOpen(true);

        var cluster = new WaCluster<>();
        cluster.setGap(PageSize.ExtraSmall);
        for (String prereq : plugin.getPrerequisites())
        {
            cluster.add(buildTag(prereq, Variant.Neutral));
        }
        details.add(cluster);
        parent.add(details);
    }

    private void addLinksSection(WaStack<?> parent, PluginEntry plugin)
    {
        if (plugin.getUpstreamUrl() == null && plugin.getDocsUrl() == null && plugin.getSourceUrl() == null) return;
        parent.add(new WaDivider<>());
        var cluster = new WaCluster<>();
        cluster.setGap(PageSize.Small);
        if (plugin.getUpstreamUrl() != null) cluster.add(buildTag("Upstream: " + plugin.getUpstreamUrl(), Variant.Neutral));
        if (plugin.getDocsUrl() != null) cluster.add(buildTag("Docs: " + plugin.getDocsUrl(), Variant.Neutral));
        if (plugin.getSourceUrl() != null) cluster.add(buildTag("Source: " + plugin.getSourceUrl(), Variant.Neutral));
        parent.add(cluster);
    }

    // ══════════════════════════════════════════════════
    //  Components — card grid linking to individual pages
    // ══════════════════════════════════════════════════

    private void addComponentsGrid(WaStack<?> layout)
    {
        var components = frameworkComponents();
        if (components.isEmpty()) return;

        var section = new WaStack<>();
        section.setGap(PageSize.Medium);
        section.add(headingText("h2", "l", "Components (" + components.size() + ")"));
        section.add(bodyText("Click any component to see its full API — properties, constructors, methods, events, slots, and examples.", "m"));

        var grid = new WaGrid<>();
        grid.setGap(PageSize.Small);
        grid.setMinColumnSize("18rem");

        for (PluginEntry.ComponentInfo comp : components)
        {
            grid.add(buildComponentCard(comp));
        }

        section.add(grid);
        layout.add(section);
    }

    private WaCard<?> buildComponentCard(PluginEntry.ComponentInfo comp)
    {
        var compCard = new WaCard<>();
        compCard.setAppearance(Appearance.Outlined);

        var stack = new WaStack<>();
        stack.setGap(PageSize.ExtraSmall);
        stack.add(headingText("h4", "s", comp.className()));

        var desc = bodyText(comp.description(), "s");
        desc.setWaColorText("quiet");
        stack.add(desc);

        // Summary badges
        var badges = new WaCluster<>();
        badges.setGap(PageSize.ExtraSmall);
        if (comp.properties() != null && !comp.properties().isEmpty())
        {
            badges.add(buildTag(comp.properties().size() + " props", Variant.Brand));
        }
        if (comp.methods() != null && !comp.methods().isEmpty())
        {
            badges.add(buildTag(comp.methods().size() + " methods", Variant.Neutral));
        }
        if (comp.events() != null && !comp.events().isEmpty())
        {
            badges.add(buildTag(comp.events().size() + " events", Variant.Warning));
        }
        if (comp.slots() != null && !comp.slots().isEmpty())
        {
            badges.add(buildTag(comp.slots().size() + " slots", Variant.Neutral));
        }
        if (comp.examples() != null && !comp.examples().isEmpty())
        {
            badges.add(buildTag(comp.examples().size() + " examples", Variant.Success));
        }
        stack.add(badges);

        // Link to component detail page
        String slug = comp.className().replaceAll("([a-z])([A-Z])", "$1-$2").toLowerCase();
        stack.add(buildCta("View Details →", "/frameworks/" + frameworkId() + "/" + slug, Variant.Brand, Appearance.Plain));

        compCard.add(stack);
        return compCard;
    }
}

