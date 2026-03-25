package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaGrid;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.card.WaCard;
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
public abstract class PluginDetailPage<J extends PluginDetailPage<J>> extends WebsitePage<J> implements INgComponent<J>
{
    protected PluginDetailPage(PluginEntry plugin)
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Back link
        layout.add(buildCta("Back to Plugins", "/plugins", Variant.Neutral, Appearance.Plain));

        // Full detail card
        var card = new WaCard<>();
        card.setAppearance(Appearance.Outlined);

        var outerStack = new WaStack();
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
        var header = new WaStack();
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
        var coordsStack = new WaStack();
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
        if (plugin.getMavenSnippet() == null)
        {
            return;
        }
        var installStack = new WaStack();
        installStack.setGap(PageSize.ExtraSmall);
        installStack.add(captionText("INSTALLATION"));
        installStack.add(codeBlockWithTitle("Maven", plugin.getMavenSnippet(), PrismLanguage.Xml));
        if (plugin.getGradleSnippet() != null)
        {
            installStack.add(codeBlockWithTitle("Gradle (Kotlin DSL)", plugin.getGradleSnippet(), PrismLanguage.Kotlin));
        }
        parent.add(installStack);
    }

    // ── NPM dependencies ─────────────────────────────

    private void addNpmSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getNpmDependencies().isEmpty())
        {
            return;
        }
        var npmStack = new WaStack();
        npmStack.setGap(PageSize.ExtraSmall);
        npmStack.add(captionText("NPM DEPENDENCIES (auto-included)"));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> dep : plugin.getNpmDependencies().entrySet())
        {
            sb.append("\"").append(dep.getKey()).append("\": \"").append(dep.getValue()).append("\"\n");
        }
        npmStack.add(codeBlock(sb.toString().trim(), PrismLanguage.Json));
        parent.add(npmStack);
    }

    // ── Components ────────────────────────────────────

    private void addComponentsSection(WaStack parent)
    {
        var components = pluginComponents();
        if (components.isEmpty())
        {
            return;
        }
        var section = new WaStack();
        section.setGap(PageSize.Small);
        section.add(captionText("COMPONENTS"));

        var componentGrid = new WaGrid<>();
        componentGrid.setGap(PageSize.Small);
        componentGrid.setMinColumnSize("18rem");

        for (PluginEntry.ComponentInfo comp : components)
        {
            var compCard = new WaCard<>();
            compCard.setAppearance(Appearance.Outlined);
            var stack = new WaStack();
            stack.setGap(PageSize.ExtraSmall);
            stack.add(headingText("h4", "s", comp.className()));
            var desc = bodyText(comp.description(), "s");
            desc.setWaColorText("quiet");
            stack.add(desc);
            if (comp.packageName() != null && !comp.packageName().isBlank())
            {
                var pkg = captionText(comp.packageName());
                pkg.setWaColorText("quiet");
                stack.add(pkg);
            }
            compCard.add(stack);
            componentGrid.add(compCard);
        }
        section.add(componentGrid);
        parent.add(section);
    }

    // ── Features ──────────────────────────────────────

    private void addFeaturesSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getFeatures().isEmpty())
        {
            return;
        }
        var featuresStack = new WaStack();
        featuresStack.setGap(PageSize.ExtraSmall);
        featuresStack.add(captionText("FEATURES"));

        for (String feature : plugin.getFeatures())
        {
            var featureText = bodyText(feature, "s");
            featureText.setWaColorText("quiet");
            featuresStack.add(featureText);
        }
        parent.add(featuresStack);
    }

    // ── Examples ──────────────────────────────────────

    private void addExamplesSection(WaStack parent)
    {
        var examples = pluginExamples();
        if (examples.isEmpty())
        {
            return;
        }
        var section = new WaStack();
        section.setGap(PageSize.Medium);
        section.add(captionText("EXAMPLES"));

        for (PluginEntry.ExampleSnippet example : examples)
        {
            var exStack = new WaStack();
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
        parent.add(section);
    }

    // ── Quick start ───────────────────────────────────

    private void addQuickStartSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getQuickStartCode() == null)
        {
            return;
        }
        var quickStack = new WaStack();
        quickStack.setGap(PageSize.ExtraSmall);
        quickStack.add(captionText("QUICK START"));
        quickStack.add(codeBlock(plugin.getQuickStartCode()));
        parent.add(quickStack);
    }

    // ── SPI Details ───────────────────────────────────

    private void addSpiDetailsSection(WaStack parent)
    {
        var spiDetails = pluginSpiDetails();
        if (spiDetails.isEmpty())
        {
            return;
        }
        var section = new WaStack();
        section.setGap(PageSize.Small);
        section.add(captionText("SPI EXTENSION POINT DETAILS"));

        for (PluginEntry.SpiDetail spi : spiDetails)
        {
            var row = new WaStack();
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
        parent.add(section);
    }

    // ── SPI tags (simple provides/uses) ───────────────

    private void addSpiSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getSpiProvides().isEmpty() && plugin.getSpiUses().isEmpty())
        {
            return;
        }
        var spiStack = new WaStack();
        spiStack.setGap(PageSize.ExtraSmall);
        spiStack.add(captionText("SPI EXTENSION POINTS"));

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
        parent.add(spiStack);
    }

    // ── Configurations ────────────────────────────────

    private void addConfigurationsSection(WaStack parent)
    {
        var configurations = pluginConfigurations();
        if (configurations.isEmpty())
        {
            return;
        }
        var section = new WaStack();
        section.setGap(PageSize.Small);
        section.add(captionText("CONFIGURATION"));

        for (PluginEntry.ConfigEntry config : configurations)
        {
            var row = new WaStack();
            row.setGap(PageSize.ExtraSmall);

            var nameCluster = new WaCluster<>();
            nameCluster.setGap(PageSize.ExtraSmall);
            nameCluster.add(headingText("h4", "s", config.name()));
            if (config.type() != null)
            {
                nameCluster.add(buildTag(config.type(), Variant.Neutral));
            }
            row.add(nameCluster);

            var desc = bodyText(config.description(), "s");
            desc.setWaColorText("quiet");
            row.add(desc);

            if (config.defaultValue() != null && !config.defaultValue().isBlank())
            {
                var def = captionText("Default: " + config.defaultValue());
                def.setWaColorText("quiet");
                row.add(def);
            }
            section.add(row);
        }
        parent.add(section);
    }

    // ── Prerequisites ─────────────────────────────────

    private void addPrerequisitesSection(WaStack parent, PluginEntry plugin)
    {
        if (plugin.getPrerequisites().isEmpty())
        {
            return;
        }
        var prereqStack = new WaStack();
        prereqStack.setGap(PageSize.ExtraSmall);
        prereqStack.add(captionText("PREREQUISITES"));

        var prereqCluster = new WaCluster<>();
        prereqCluster.setGap(PageSize.ExtraSmall);
        for (String prereq : plugin.getPrerequisites())
        {
            prereqCluster.add(buildTag(prereq, Variant.Neutral));
        }
        prereqStack.add(prereqCluster);
        parent.add(prereqStack);
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
