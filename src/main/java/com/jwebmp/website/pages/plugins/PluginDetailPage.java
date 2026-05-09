package com.jwebmp.website.pages.plugins;

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
 * Base class for individual plugin detail pages.
 * <p>
 * Renders the full detail view for a single {@link PluginEntry}.
 * Catalog-level data (header, coordinates, install, npm, features,
 * quick-start, SPI tag summary, prerequisites, and links) is rendered
 * from the {@link PluginEntry}.
 * <p>
 * Page-specific data — components, examples, SPI details, and
 * configurations — is provided by overriding the protected template
 * methods. Each plugin page knows its own setup best.
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
public abstract class PluginDetailPage<J extends PluginDetailPage<J>> extends WebsitePage<J> implements INgComponent<J>
{
    private final String pluginId;

    protected PluginDetailPage(PluginEntry plugin)
    {
        this.pluginId = plugin.getId();

        var layout = new WaStack<>();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Back link
        layout.add(buildCta("Back to Plugins", "/plugins", Variant.Neutral, Appearance.Plain));

        // Full detail card
        var card = new WaCard<>();
        card.setAppearance(Appearance.Outlined);

        var outerStack = new WaStack<>();
        outerStack.setGap(PageSize.Medium);

        outerStack.add(buildPluginHeader(plugin));
        outerStack.add(new WaDivider<>());
        outerStack.add(buildCoordinatesSection(plugin));
        addInstallationSection(outerStack, plugin);
        addNpmSection(outerStack, plugin);
        outerStack.add(new WaDivider<>());
        addComponentsSection(outerStack);
        addFeaturesSection(outerStack, plugin);
        outerStack.add(new WaDivider<>());
        addExamplesSection(outerStack);
        addQuickStartSection(outerStack, plugin);
        outerStack.add(new WaDivider<>());
        addSpiDetailsSection(outerStack);
        addSpiSection(outerStack, plugin);
        outerStack.add(new WaDivider<>());
        addConfigurationsSection(outerStack);
        addPrerequisitesSection(outerStack, plugin);
        addLinksSection(outerStack, plugin);

        card.add(outerStack);
        layout.add(card);
    }

    // ══════════════════════════════════════════════════
    //  Template methods — override in subclasses
    // ══════════════════════════════════════════════════

    /**
     * Components exposed by this plugin.
     * Override to list Java classes this plugin provides.
     */
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return List.of();
    }

    /**
     * Code examples demonstrating this plugin's usage.
     * Override to provide plugin-specific examples.
     */
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of();
    }

    /**
     * Detailed SPI extension point descriptions.
     * Override to explain each SPI this plugin provides/uses.
     */
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of();
    }

    /**
     * Configuration options for this plugin.
     * Override to list plugin-specific configuration properties.
     */
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of();
    }

    // ── Header ────────────────────────────────────────

    private WaStack buildPluginHeader(PluginEntry plugin)
    {
        var header = new WaStack<>();
        header.setGap(PageSize.Small);
        header.add(headingText("h1", "xl", plugin.getName()));
        header.add(bodyText(plugin.getDescription(), "m"));

        if (!plugin.getTechBadges().isEmpty())
        {
            var badgeCluster = new WaCluster<>();
            badgeCluster.setGap(PageSize.ExtraSmall);
            for (String badge : plugin.getTechBadges())
            {
                badgeCluster.add(buildTag(badge,
                        "License Required".equals(badge) ? Variant.Warning : Variant.Neutral));
            }
            header.add(badgeCluster);
        }

        if (plugin.isRequiresLicense() && plugin.getLicenseNote() != null)
        {
            var licenseNote = bodyText(plugin.getLicenseNote(), "s");
            licenseNote.setWaColorText("warning");
            header.add(licenseNote);
        }
        return header;
    }

    // ── Coordinates ───────────────────────────────────

    private WaStack buildCoordinatesSection(PluginEntry plugin)
    {
        var coordsStack = new WaStack<>();
        coordsStack.setGap(PageSize.ExtraSmall);
        coordsStack.add(captionText("COORDINATES & MODULE"));
        coordsStack.add(bodyText("Maven: " + plugin.getGroupId() + ":" + plugin.getArtifactId(), "s"));

        if (plugin.getJpmsModule() != null)
        {
            coordsStack.add(bodyText("JPMS Module: " + plugin.getJpmsModule(), "s"));
        }
        if (plugin.getUpstreamName() != null)
        {
            String upstream = "Built on: " + plugin.getUpstreamName();
            if (plugin.getUpstreamVersion() != null)
            {
                upstream += " " + plugin.getUpstreamVersion();
            }
            coordsStack.add(bodyText(upstream, "s"));
        }
        return coordsStack;
    }

    // ── Installation ──────────────────────────────────

    private void addInstallationSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getMavenSnippet() == null && plugin.getGradleSnippet() == null)
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("Installation");

        var installStack = new WaStack<>();
        installStack.setGap(PageSize.ExtraSmall);

        if (plugin.getMavenSnippet() != null)
        {
            var mavenIf = new NgIf("!useGradle");
            mavenIf.add(codeBlockWithTitle("Maven", plugin.getMavenSnippet(), "xml"));
            installStack.add(mavenIf);
        }
        if (plugin.getGradleSnippet() != null)
        {
            var gradleIf = new NgIf("useGradle");
            gradleIf.add(codeBlockWithTitle("Gradle (Kotlin DSL)", plugin.getGradleSnippet(), "kotlin"));
            installStack.add(gradleIf);
        }

        details.add(installStack);
        parent.add(details);
    }

    // ── NPM dependencies ─────────────────────────────

    private void addNpmSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getNpmDependencies().isEmpty())
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("NPM Dependencies (auto-included)");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> dep : plugin.getNpmDependencies().entrySet())
        {
            sb.append("\"").append(dep.getKey()).append("\": \"").append(dep.getValue()).append("\"\n");
        }
        details.add(codeBlock(sb.toString().trim(), "json"));
        parent.add(details);
    }

    // ── Components ────────────────────────────────────

    private void addComponentsSection(WaStack parent)
    {
        var components = pluginComponents();
        if (components.isEmpty())
        {
            return;
        }

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
        parent.add(section);
    }

    private WaCard buildComponentCard(PluginEntry.ComponentInfo comp)
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
        stack.add(buildCta("View Details →", "/plugins/" + pluginId + "/" + slug, Variant.Brand, Appearance.Plain));

        compCard.add(stack);
        return compCard;
    }

    // ── Features ──────────────────────────────────────

    private void addFeaturesSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getFeatures().isEmpty())
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("Features (" + plugin.getFeatures().size() + ")");

        var featuresStack = new WaStack<>();
        featuresStack.setGap(PageSize.ExtraSmall);
        for (String feature : plugin.getFeatures())
        {
            var featureText = bodyText(feature, "s");
            featureText.setWaColorText("quiet");
            featuresStack.add(featureText);
        }
        details.add(featuresStack);
        parent.add(details);
    }

    // ── Examples ──────────────────────────────────────

    private void addExamplesSection(WaStack parent)
    {
        var examples = pluginExamples();
        if (examples.isEmpty())
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("Examples (" + examples.size() + ")");
        details.setOpen(true);

        var section = new WaStack<>();
        section.setGap(PageSize.Medium);

        for (PluginEntry.ExampleSnippet example : examples)
        {
            var exStack = new WaStack<>();
            exStack.setGap(PageSize.ExtraSmall);
            exStack.add(headingText("h4", "s", example.title()));
            if (example.description() != null && !example.description().isBlank())
            {
                var desc = bodyText(example.description(), "s");
                desc.setWaColorText("quiet");
                exStack.add(desc);
            }
            exStack.add(codeBlock(example.code()));
            section.add(exStack);
        }
        details.add(section);
        parent.add(details);
    }

    // ── Quick start ───────────────────────────────────

    private void addQuickStartSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getQuickStartCode() == null)
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("Quick Start");
        details.setOpen(true);
        details.add(codeBlock(plugin.getQuickStartCode()));
        parent.add(details);
    }

    // ── SPI Details ───────────────────────────────────

    private void addSpiDetailsSection(WaStack parent)
    {
        var spiDetails = pluginSpiDetails();
        if (spiDetails.isEmpty())
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("SPI Extension Point Details (" + spiDetails.size() + ")");
        details.setOpen(true);

        var section = new WaStack<>();
        section.setGap(PageSize.Small);

        for (PluginEntry.SpiDetail spi : spiDetails)
        {
            var row = new WaStack<>();
            row.setGap(PageSize.ExtraSmall);

            var nameCluster = new WaCluster<>();
            nameCluster.setGap(PageSize.ExtraSmall);
            nameCluster.add(buildTag(spi.interfaceName(),
                    "provides".equals(spi.direction()) ? Variant.Success : Variant.Brand));
            nameCluster.add(buildTag(spi.direction(), Variant.Neutral));
            row.add(nameCluster);

            var desc = bodyText(spi.description(), "s");
            desc.setWaColorText("quiet");
            row.add(desc);
            section.add(row);
        }
        details.add(section);
        parent.add(details);
    }

    // ── SPI tags (simple provides/uses) ───────────────

    private void addSpiSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getSpiProvides().isEmpty() && plugin.getSpiUses().isEmpty())
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("SPI Extension Points");
        details.setOpen(true);

        var spiStack = new WaStack<>();
        spiStack.setGap(PageSize.ExtraSmall);

        if (!plugin.getSpiProvides().isEmpty())
        {
            var providesCluster = new WaCluster<>();
            providesCluster.setGap(PageSize.ExtraSmall);
            for (String spi : plugin.getSpiProvides())
            {
                providesCluster.add(buildTag("provides " + spi, Variant.Success));
            }
            spiStack.add(providesCluster);
        }

        if (!plugin.getSpiUses().isEmpty())
        {
            var usesCluster = new WaCluster<>();
            usesCluster.setGap(PageSize.ExtraSmall);
            for (String spi : plugin.getSpiUses())
            {
                usesCluster.add(buildTag("uses " + spi, Variant.Brand));
            }
            spiStack.add(usesCluster);
        }
        details.add(spiStack);
        parent.add(details);
    }

    // ── Properties (Configuration) ────────────────────

    private void addConfigurationsSection(WaStack parent)
    {
        var configurations = pluginConfigurations();
        if (configurations.isEmpty())
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("Properties (" + configurations.size() + ")");
        details.setOpen(true);

        var table = new com.jwebmp.core.base.html.Table<>();
        table.addStyle("width", "100%");
        table.addStyle("border-collapse", "collapse");

        var thead = new com.jwebmp.core.base.html.TableHeaderGroup<>();
        var headerRow = new com.jwebmp.core.base.html.TableRow<>();
        headerRow.addStyle("border-bottom", "2px solid var(--wa-color-neutral-200)");
        for (String col : new String[]{"Property", "Type", "Default", "Description"})
        {
            var th = new com.jwebmp.core.base.html.TableHeaderCell<>();
            th.setText(col);
            th.addStyle("text-align", "left");
            th.addStyle("padding", "var(--wa-spacing-small)");
            th.addStyle("font-size", "var(--wa-font-size-xs)");
            th.addStyle("color", "var(--wa-color-text-quiet)");
            th.addStyle("font-weight", "var(--wa-font-weight-semibold)");
            headerRow.add(th);
        }
        thead.add(headerRow);
        table.add(thead);

        var tbody = new com.jwebmp.core.base.html.TableBodyGroup<>();
        for (PluginEntry.ConfigEntry config : configurations)
        {
            var row = new com.jwebmp.core.base.html.TableRow<>();
            row.addStyle("border-bottom", "1px solid var(--wa-color-neutral-100)");

            var nameCell = new com.jwebmp.core.base.html.TableCell<>();
            nameCell.setText(config.name());
            nameCell.addStyle("padding", "var(--wa-spacing-small)");
            nameCell.addStyle("font-family", "var(--wa-font-mono)");
            nameCell.addStyle("font-size", "var(--wa-font-size-xs)");
            nameCell.addStyle("color", "var(--wa-color-brand-normal)");
            nameCell.addStyle("font-weight", "var(--wa-font-weight-semibold)");
            row.add(nameCell);

            var typeCell = new com.jwebmp.core.base.html.TableCell<>();
            typeCell.setText(config.type() != null ? config.type() : "–");
            typeCell.addStyle("padding", "var(--wa-spacing-small)");
            typeCell.addStyle("font-family", "var(--wa-font-mono)");
            typeCell.addStyle("font-size", "var(--wa-font-size-xs)");
            typeCell.addStyle("color", "var(--wa-color-text-quiet)");
            row.add(typeCell);

            var defaultCell = new com.jwebmp.core.base.html.TableCell<>();
            defaultCell.setText(config.defaultValue() != null && !config.defaultValue().isBlank() ? config.defaultValue() : "–");
            defaultCell.addStyle("padding", "var(--wa-spacing-small)");
            defaultCell.addStyle("font-family", "var(--wa-font-mono)");
            defaultCell.addStyle("font-size", "var(--wa-font-size-xs)");
            defaultCell.addStyle("color", "var(--wa-color-text-quiet)");
            row.add(defaultCell);

            var descCell = new com.jwebmp.core.base.html.TableCell<>();
            descCell.setText(config.description() != null ? config.description() : "");
            descCell.addStyle("padding", "var(--wa-spacing-small)");
            descCell.addStyle("font-size", "var(--wa-font-size-s)");
            row.add(descCell);

            tbody.add(row);
        }
        table.add(tbody);

        details.add(table);
        parent.add(details);
    }

    // ── Prerequisites ─────────────────────────────────

    private void addPrerequisitesSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getPrerequisites().isEmpty())
        {
            return;
        }
        var details = new WaDetails<>();
        details.setSummary("Prerequisites");
        details.setOpen(true);

        var prereqCluster = new WaCluster<>();
        prereqCluster.setGap(PageSize.ExtraSmall);
        for (String prereq : plugin.getPrerequisites())
        {
            prereqCluster.add(buildTag(prereq, Variant.Neutral));
        }
        details.add(prereqCluster);
        parent.add(details);
    }

    // ── External links ────────────────────────────────

    private void addLinksSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getUpstreamUrl() == null && plugin.getDocsUrl() == null && plugin.getSourceUrl() == null)
        {
            return;
        }
        parent.add(new WaDivider<>());

        var linksCluster = new WaCluster<>();
        linksCluster.setGap(PageSize.Small);

        if (plugin.getUpstreamUrl() != null)
        {
            linksCluster.add(buildTag("Upstream: " + plugin.getUpstreamUrl(), Variant.Neutral));
        }
        if (plugin.getDocsUrl() != null)
        {
            linksCluster.add(buildTag("Docs: " + plugin.getDocsUrl(), Variant.Neutral));
        }
        if (plugin.getSourceUrl() != null)
        {
            linksCluster.add(buildTag("Source: " + plugin.getSourceUrl(), Variant.Neutral));
        }
        parent.add(linksCluster);
    }
}
