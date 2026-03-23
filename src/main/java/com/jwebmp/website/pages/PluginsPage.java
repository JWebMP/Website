package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaGrid;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.card.WaCard;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

@NgComponent("jwebmp-plugins")
@NgRoutable(path = "plugins")
public class PluginsPage extends WebsitePage<PluginsPage> implements INgComponent<PluginsPage>
{
    public PluginsPage()
    {
        buildPluginsPage();
    }

    private void buildPluginsPage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Intro
        var intro = new WaStack();
        intro.setGap(PageSize.Medium);
        intro.add(bodyText(
                "Every JWebMP plugin is a proper JPMS module with an explicit module-info.java. "
                + "Add the Maven dependency, and the component is immediately available as a type-safe "
                + "Java class. The Angular Maven Plugin generates all the TypeScript integration at build time. "
                + "No npm install. No Angular module registration. Just Java.",
                "m"));

        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.add(buildTag(PluginCatalog.getPlugins().size() + " Plugins", Variant.Brand));
        tags.add(buildTag(PluginCatalog.getCategories().size() + " Categories", Variant.Neutral));
        tags.add(buildTag("JPMS Modular", Variant.Success));
        intro.add(tags);

        layout.add(buildSection("ECOSYSTEM",
                "Plugin & Component Catalog",
                "Production-ready modules for every use case.",
                false, intro));

        // Category sections with summary plugin cards
        boolean alt = true;
        for (String category : PluginCatalog.getCategories())
        {
            var plugins = PluginCatalog.getByCategory(category);

            var categoryGrid = new WaGrid<>();
            categoryGrid.setGap(PageSize.Medium);
            categoryGrid.setMinColumnSize("20rem");

            for (PluginEntry plugin : plugins)
            {
                categoryGrid.add(buildSummaryCard(plugin));
            }

            layout.add(buildSection(null, category, null, alt, categoryGrid));
            alt = !alt;
        }
    }

    // ── Summary card — name, short description, badges, CTA ──

    private WaCard<?> buildSummaryCard(PluginEntry plugin)
    {
        var card = new WaCard<>();
        card.setAppearance(Appearance.Outlined);

        var stack = new WaStack();
        stack.setGap(PageSize.Small);

        // Title
        stack.add(headingText("h3", "m", plugin.getName()));

        // Short description (first sentence)
        String shortDesc = firstSentence(plugin.getDescription());
        var desc = bodyText(shortDesc, "s");
        desc.setWaColorText("quiet");
        stack.add(desc);

        // Upstream badge
        if (plugin.getUpstreamName() != null && plugin.getUpstreamVersion() != null)
        {
            var upstream = captionText(plugin.getUpstreamName() + " " + plugin.getUpstreamVersion());
            upstream.setWaColorText("quiet");
            stack.add(upstream);
        }

        // Tech badges (first 4 max)
        if (!plugin.getTechBadges().isEmpty())
        {
            var badgeCluster = new WaCluster<>();
            badgeCluster.setGap(PageSize.ExtraSmall);
            int count = 0;
            for (String badge : plugin.getTechBadges())
            {
                if (count >= 4) break;
                badgeCluster.add(buildTag(badge,
                        "License Required".equals(badge) ? Variant.Warning : Variant.Neutral));
                count++;
            }
            stack.add(badgeCluster);
        }

        // View Details CTA
        stack.add(buildCta("View Details", "/plugins/" + plugin.getId(), Variant.Brand, Appearance.Outlined));

        card.add(stack);
        return card;
    }

    private String firstSentence(String text)
    {
        if (text == null || text.isBlank()) return "";
        // Split on " — " first (em-dash separator used in descriptions)
        int dash = text.indexOf(" \u2014 ");
        if (dash > 0 && dash < 120)
        {
            return text.substring(0, dash);
        }
        // Fallback: first sentence ending with period
        int dot = text.indexOf(". ");
        if (dot > 0 && dot < 160)
        {
            return text.substring(0, dot + 1);
        }
        // Truncate at 150 chars
        if (text.length() > 150)
        {
            return text.substring(0, 147) + "...";
        }
        return text;
    }
}
