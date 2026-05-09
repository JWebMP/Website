package com.jwebmp.website.pages.frameworks;

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
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-frameworks")
@NgRoutable(path = "frameworks")
public class FrameworksPage extends WebsitePage<FrameworksPage> implements INgComponent<FrameworksPage>
{
    public FrameworksPage()
    {
        var layout = new WaStack<>();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Intro
        var intro = new WaStack<>();
        intro.setGap(PageSize.Medium);
        intro.add(richText(
                "JWebMP wraps complete UI frameworks as type-safe Java components with CRTP fluent APIs. "
                + "Each framework's full component set is available — buttons, cards, modals, forms, navigation, "
                + "and layout primitives — all configured in Java, rendered via Angular.",
                "m"));

        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.add(buildTag(PluginCatalog.getFrameworks().size() + " Frameworks", Variant.Brand));
        tags.add(buildTag("CRTP Fluent APIs", Variant.Success));
        tags.add(buildTag("Zero Config", Variant.Neutral));
        intro.add(tags);

        layout.add(buildSection("UI FRAMEWORKS",
                "Supported UI Frameworks",
                "Production-ready component libraries — pick the one that fits your project.",
                false, intro));

        // Framework cards
        var grid = new WaGrid<>();
        grid.setGap(PageSize.Large);
        grid.setMinColumnSize("20rem");

        for (PluginEntry fw : PluginCatalog.getFrameworks())
        {
            var card = buildFrameworkCard(fw);
            card.setID(toAnchorId(fw.getName()));
            grid.add(card);
        }
        layout.add(grid);
    }

    private static String toAnchorId(String name)
    {
        return name.toLowerCase()
                   .replaceAll("[^a-z0-9]+", "-")
                   .replaceAll("^-|-$", "");
    }

    private WaCard<?> buildFrameworkCard(PluginEntry fw)
    {
        var card = new WaCard<>();
        card.setAppearance(Appearance.Outlined);

        var stack = new WaStack<>();
        stack.setGap(PageSize.Small);

        stack.add(headingText("h2", "l", fw.getName()));

        String shortDesc = fw.getDescription();
        int dash = shortDesc.indexOf(" \u2014 ");
        if (dash > 0 && dash < 120)
        {
            shortDesc = shortDesc.substring(0, dash);
        }
        var desc = bodyText(shortDesc, "m");
        desc.setWaColorText("quiet");
        stack.add(desc);

        if (fw.getUpstreamName() != null && fw.getUpstreamVersion() != null)
        {
            var upstream = captionText(fw.getUpstreamName() + " " + fw.getUpstreamVersion());
            upstream.setWaColorText("quiet");
            stack.add(upstream);
        }

        if (!fw.getTechBadges().isEmpty())
        {
            var badges = new WaCluster<>();
            badges.setGap(PageSize.ExtraSmall);
            int count = 0;
            for (String badge : fw.getTechBadges())
            {
                if (count >= 5) break;
                badges.add(buildTag(badge,
                        "License Required".equals(badge) ? Variant.Warning : Variant.Neutral));
                count++;
            }
            stack.add(badges);
        }

        stack.add(buildCta("Explore Components", "/frameworks/" + fw.getId(), Variant.Brand, Appearance.Outlined));

        card.add(stack);
        return card;
    }
}

