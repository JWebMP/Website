package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Table;
import com.jwebmp.core.base.html.TableBodyGroup;
import com.jwebmp.core.base.html.TableCell;
import com.jwebmp.core.base.html.TableHeaderCell;
import com.jwebmp.core.base.html.TableHeaderGroup;
import com.jwebmp.core.base.html.TableRow;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.details.WaDetails;
import com.jwebmp.website.catalog.PluginEntry;
import com.jwebmp.website.pages.WebsitePage;

import java.util.List;

/**
 * Base class for individual plugin component pages.
 * Each concrete subclass has its own @NgRoutable path like
 * {@code plugins/bootstrap/bs-button}.
 */
public abstract class PluginComponentPage<J extends PluginComponentPage<J>> extends WebsitePage<J> implements INgComponent<J>
{
    private static final String QUIET = "quiet";

    protected PluginComponentPage(String pluginId, String pluginName, PluginEntry.ComponentInfo component)
    {
        var layout = new WaStack<>();
        layout.setGap(PageSize.Large);
        getMain().add(layout);

        // Back link
        layout.add(buildCta("← Back to " + pluginName, "/plugins/" + pluginId, Variant.Neutral, Appearance.Plain));

        // ── Header with Examples quick-link ──
        var headerRow = new WaCluster<>();
        headerRow.addStyle("justify-content", "space-between");
        headerRow.addStyle("align-items", "center");
        headerRow.add(headingText("h1", "xl", component.className()));

        boolean hasExamples = (component.examples() != null && !component.examples().isEmpty())
                              || !additionalExamples().isEmpty();
        if (hasExamples)
        {
            var exLink = new Link<>();
            exLink.setTag("a");
            exLink.addAttribute("href", "javascript:void(0)");
            exLink.addAttribute("onclick", "document.getElementById('examples-section')?.scrollIntoView({behavior:'smooth'})");
            exLink.setText("Examples ↓");
            exLink.addStyle("font-size", "var(--wa-font-size-s)");
            exLink.addStyle("color", "var(--wa-color-brand-normal)");
            exLink.addStyle("cursor", "pointer");
            exLink.addStyle("white-space", "nowrap");
            headerRow.add(exLink);
        }
        layout.add(headerRow);

        var desc = bodyText(component.description(), "m");
        desc.setWaColorText(QUIET);
        layout.add(desc);

        // ── Import / Implements / Constructors in a single collapsed WaDetails ──
        boolean hasImport = component.packageName() != null && !component.packageName().isBlank();
        boolean hasIfaces = component.implementsInterfaces() != null && !component.implementsInterfaces().isEmpty();
        boolean hasCtors = component.constructors() != null && !component.constructors().isEmpty();

        if (hasImport || hasIfaces || hasCtors)
        {
            var metaDetails = new WaDetails<>();
            metaDetails.setSummary("Import, Interfaces & Constructors");
            metaDetails.setAppearance("outlined");

            var metaStack = new WaStack<>();
            metaStack.setGap(PageSize.Medium);

            if (hasImport)
            {
                metaStack.add(captionText("IMPORT"));
                metaStack.add(codeBlock("import " + component.packageName() + "." + component.className() + ";", "java"));
            }

            if (hasIfaces)
            {
                metaStack.add(captionText("IMPLEMENTS"));
                var cluster = new WaCluster<>();
                cluster.setGap(PageSize.ExtraSmall);
                for (String iface : component.implementsInterfaces())
                {
                    cluster.add(buildTag(iface, Variant.Neutral));
                }
                metaStack.add(cluster);
            }

            if (hasCtors)
            {
                metaStack.add(captionText("CONSTRUCTORS"));
                for (PluginEntry.ConstructorInfo ctor : component.constructors())
                {
                    metaStack.add(codeBlock(ctor.signature(), "java"));
                    if (ctor.description() != null && !ctor.description().isBlank())
                    {
                        var ctorDesc = bodyText(ctor.description(), "s");
                        ctorDesc.setWaColorText(QUIET);
                        metaStack.add(ctorDesc);
                    }
                }
            }

            metaDetails.add(metaStack);
            layout.add(metaDetails);
        }

        // ── Properties (WaDetails, open by default) ──
        if (component.properties() != null && !component.properties().isEmpty())
        {
            var propsDetails = new WaDetails<>();
            propsDetails.setSummary("Properties (" + component.properties().size() + ")");
            propsDetails.setOpen(true);

            propsDetails.add(buildPropsTable(component.properties()));
            layout.add(propsDetails);
        }

        // ── Methods (WaDetails, open by default, as table) ──
        if (component.methods() != null && !component.methods().isEmpty())
        {
            var methodDetails = new WaDetails<>();
            methodDetails.setSummary("Methods (" + component.methods().size() + ")");
            methodDetails.setOpen(true);

            methodDetails.add(buildTwoColumnTable("Signature", "Description",
                    component.methods().stream()
                            .map(m -> new String[]{m.signature(), m.description() != null ? m.description() : ""})
                            .toList()));
            layout.add(methodDetails);
        }

        // ── Events (WaDetails, open by default) ──
        if (component.events() != null && !component.events().isEmpty())
        {
            var eventDetails = new WaDetails<>();
            eventDetails.setSummary("Events (" + component.events().size() + ")");
            eventDetails.setOpen(true);

            eventDetails.add(buildTwoColumnTable("Event", "Description",
                    component.events().stream()
                            .map(e -> new String[]{e.name(), e.description() != null ? e.description() : ""})
                            .toList()));
            layout.add(eventDetails);
        }

        // ── Slots (WaDetails, open by default) ──
        if (component.slots() != null && !component.slots().isEmpty())
        {
            var slotDetails = new WaDetails<>();
            slotDetails.setSummary("Slots (" + component.slots().size() + ")");
            slotDetails.setOpen(true);

            slotDetails.add(buildTwoColumnTable("Slot", "Description",
                    component.slots().stream()
                            .map(s -> new String[]{s.name(), s.description() != null ? s.description() : ""})
                            .toList()));
            layout.add(slotDetails);
        }

        // ── Examples ──
        if (hasExamples)
        {
            var exSection = new WaStack<>();
            exSection.setGap(PageSize.Medium);
            exSection.setID("examples-section");
            exSection.add(headingText("h2", "l", "Examples"));

            if (component.examples() != null)
            {
                for (PluginEntry.ExampleSnippet example : component.examples())
                {
                    exSection.add(buildExampleBlock(example));
                }
            }
            for (PluginEntry.ExampleSnippet example : additionalExamples())
            {
                exSection.add(buildExampleBlock(example));
            }
            layout.add(exSection);
        }
    }

    protected List<PluginEntry.ExampleSnippet> additionalExamples()
    {
        return List.of();
    }

    // ══════════════════════════════════════════════════
    //  Table builders
    // ══════════════════════════════════════════════════

    private Table<?> buildPropsTable(List<PluginEntry.PropertyInfo> properties)
    {
        var table = new Table<>();
        table.addStyle("width", "100%");
        table.addStyle("border-collapse", "collapse");

        var thead = new TableHeaderGroup<>();
        var headerRow = new TableRow<>();
        headerRow.addStyle("border-bottom", "2px solid var(--wa-color-neutral-200)");
        for (String col : new String[]{"Property", "Type", "Default", "Description"})
        {
            headerRow.add(buildHeaderCell(col));
        }
        thead.add(headerRow);
        table.add(thead);

        var tbody = new TableBodyGroup<>();
        for (PluginEntry.PropertyInfo prop : properties)
        {
            var row = new TableRow<>();
            row.addStyle("border-bottom", "1px solid var(--wa-color-neutral-100)");
            row.add(buildMonoCell(prop.name(), "var(--wa-color-brand-normal)", true));
            row.add(buildMonoCell(prop.type() != null ? prop.type() : "–", null, false));
            row.add(buildMonoCell(prop.defaultValue() != null && !prop.defaultValue().isBlank() ? prop.defaultValue() : "–", null, false));
            row.add(buildTextCell(prop.description() != null ? prop.description() : ""));
            tbody.add(row);
        }
        table.add(tbody);
        return table;
    }

    private Table<?> buildTwoColumnTable(String col1, String col2, List<String[]> rows)
    {
        var table = new Table<>();
        table.addStyle("width", "100%");
        table.addStyle("border-collapse", "collapse");

        var thead = new TableHeaderGroup<>();
        var headerRow = new TableRow<>();
        headerRow.addStyle("border-bottom", "2px solid var(--wa-color-neutral-200)");
        headerRow.add(buildHeaderCell(col1));
        headerRow.add(buildHeaderCell(col2));
        thead.add(headerRow);
        table.add(thead);

        var tbody = new TableBodyGroup<>();
        for (String[] pair : rows)
        {
            var row = new TableRow<>();
            row.addStyle("border-bottom", "1px solid var(--wa-color-neutral-100)");
            row.add(buildMonoCell(pair[0], null, true));
            row.add(buildTextCell(pair.length > 1 ? pair[1] : ""));
            tbody.add(row);
        }
        table.add(tbody);
        return table;
    }

    private TableHeaderCell<?> buildHeaderCell(String text)
    {
        var th = new TableHeaderCell<>();
        th.setText(text);
        th.addStyle("text-align", "left");
        th.addStyle("padding", "var(--wa-spacing-small)");
        th.addStyle("font-size", "var(--wa-font-size-xs)");
        th.addStyle("color", "var(--wa-color-text-quiet)");
        th.addStyle("font-weight", "var(--wa-font-weight-semibold)");
        return th;
    }

    private TableCell<?> buildMonoCell(String text, String color, boolean bold)
    {
        var cell = new TableCell<>();
        cell.addStyle("padding", "var(--wa-spacing-small)");
        cell.addStyle("font-family", "var(--wa-font-mono)");
        cell.addStyle("font-size", "var(--wa-font-size-xs)");
        if (color != null) cell.addStyle("color", color);
        else cell.addStyle("color", "var(--wa-color-text-quiet)");
        if (bold) cell.addStyle("font-weight", "var(--wa-font-weight-semibold)");
        cell.setText(text);
        return cell;
    }

    private TableCell<?> buildTextCell(String text)
    {
        var cell = new TableCell<>();
        cell.addStyle("padding", "var(--wa-spacing-small)");
        cell.addStyle("font-size", "var(--wa-font-size-s)");
        cell.setText(text);
        return cell;
    }

    private WaStack<?> buildExampleBlock(PluginEntry.ExampleSnippet example)
    {
        var exStack = new WaStack<>();
        exStack.setGap(PageSize.ExtraSmall);
        exStack.add(headingText("h4", "s", example.title()));
        if (example.description() != null && !example.description().isBlank())
        {
            var exDesc = bodyText(example.description(), "s");
            exDesc.setWaColorText(QUIET);
            exStack.add(exDesc);
        }
        exStack.add(codeBlock(example.code(), example.language() != null ? example.language() : "java"));
        return exStack;
    }
}

