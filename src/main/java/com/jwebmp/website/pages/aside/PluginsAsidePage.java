package com.jwebmp.website.pages.aside;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.webawesome.components.icon.WaIcon;
import com.jwebmp.webawesome.components.input.InputSize;
import com.jwebmp.webawesome.components.input.WaInput;
import com.jwebmp.webawesome.components.text.WaText;
import com.jwebmp.webawesome.components.tree.WaTree;
import com.jwebmp.webawesome.components.tree.WaTreeItem;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;
import com.jwebmp.website.pages.plugins.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Aside component for the Plugins page.
 * Renders a search filter and a tree of categories with plugins nested underneath.
 * Clicking a plugin navigates to its detail page; components are nested under each plugin.
 * Framework plugins are cross-linked to the frameworks page.
 */
@NgComponent("jwebmp-plugins-aside")
@NgRoutable(path = "plugins", outlet = "aside")
@NgImportReference(value = "Router", reference = "@angular/router")
@NgImportReference(value = "inject", reference = "@angular/core")
public class PluginsAsidePage extends DivSimple<PluginsAsidePage> implements INgComponent<PluginsAsidePage>
{
    /** Maps plugin IDs to their component lists. */
    private static final Map<String, List<PluginEntry.ComponentInfo>> PLUGIN_COMPONENTS = new LinkedHashMap<>();

    static
    {
        PLUGIN_COMPONENTS.put("angular", AngularPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("core", CorePluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("client", ClientPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("vertx", VertxPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("bootstrap", BootstrapPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("web-awesome", WebAwesomePluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("web-awesome-pro", WebAwesomeProPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("jquery", JQueryPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("jquery-ui", JQueryUIPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("globalize", GlobalizePluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("fontawesome", FontAwesomePluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("chartjs", ChartJsPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("aggrid", AgGridPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("aggrid-enterprise", AgGridEnterprisePluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("easing", EasingPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("waves", WavesEffectPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("datatables", DataTablesPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("agcharts", AgChartsPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("agcharts-enterprise", AgChartsEnterprisePluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("fullcalendar", FullCalendarPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("fullcalendar-pro", FullCalendarProPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("fontawesome-pro", FontAwesomeProPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("themify-icons", ThemifyIconsPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("material-icons", MaterialIconsPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("material-design-icons", MaterialDesignIconsPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("weather-icons", WeatherIconsPluginPage.COMPONENTS);
        PLUGIN_COMPONENTS.put("glyphicons", GlyphiconsPluginPage.COMPONENTS);
    }

    public PluginsAsidePage()
    {
        setTag("aside");
        addClass("page-aside");
        addStyle("position:sticky");
        addStyle("top:var(--wa-spacing-large)");
        addStyle("padding:0 var(--wa-spacing-large) var(--wa-spacing-large) var(--wa-spacing-large)");
        addStyle("min-width:14rem");
        addStyle("max-height:calc(100vh - var(--wa-spacing-3x-large))");
        addStyle("overflow-y:auto");

        // Search input
        var search = new WaInput<>();
        search.setPlaceholder("Filter plugins\u2026");
        search.setSize(InputSize.Small);
        search.setClearable(true);
        search.addAttribute("(wa-input)", "onFilterChange($event)");
        search.addAttribute("(wa-clear)", "onFilterChange($event)");

        var searchIcon = new WaIcon<>("magnifying-glass");
        searchIcon.addAttribute("slot", "start");
        search.add(searchIcon);
        search.addStyle("margin-bottom", "var(--wa-spacing-medium)");
        add(search);

        // Heading
        var heading = new WaText<>();
        heading.setTag("div");
        heading.setWaCaption("s");
        heading.setWaFontWeight("semibold");
        heading.addClass("hero-eyebrow");
        heading.setText("Plugins & Categories");
        add(heading);

        // Tree
        var tree = new WaTree<>();
        tree.setIndentSize("12px");
        tree.setIndentGuideColor("var(--wa-color-neutral-300)");

        // Category → plugins → components
        for (String category : PluginCatalog.getNonFrameworkCategories())
        {
            var catItem = new WaTreeItem<>();

            // Category label
            var catLabel = new DivSimple<>();
            catLabel.setTag("span");
            catLabel.setText(category);
            catLabel.addStyle("font-weight", "var(--wa-font-weight-semibold)");
            catItem.add(catLabel);

            // Plugins in this category
            for (PluginEntry plugin : PluginCatalog.getNonFrameworkByCategory(category))
            {
                var pluginItem = new WaTreeItem<>();

                // Plugin link — navigates to detail page
                var pluginLink = new Link<>();
                pluginLink.setTag("a");
                pluginLink.addAttribute("href", "javascript:void(0)");
                pluginLink.addAttribute("(click)",
                        "navigateToPlugin('" + plugin.getId() + "')");
                pluginLink.setText(plugin.getName());
                pluginLink.addStyle("font-size", "var(--wa-font-size-xs)");
                pluginLink.addStyle("cursor", "pointer");
                pluginItem.add(pluginLink);

                // Nest components under the plugin
                List<PluginEntry.ComponentInfo> components = PLUGIN_COMPONENTS.getOrDefault(plugin.getId(), List.of());
                for (PluginEntry.ComponentInfo comp : components)
                {
                    pluginItem.add(createComponentTreeItem(plugin.getId(), comp));
                }

                catItem.add(pluginItem);
            }

            tree.add(catItem);
        }

        // UI Frameworks section
        var fwItem = new WaTreeItem<>();
        var fwLabel = new DivSimple<>();
        fwLabel.setTag("span");
        fwLabel.setText("UI Frameworks");
        fwLabel.addStyle("font-weight", "var(--wa-font-weight-semibold)");
        fwLabel.addStyle("color", "var(--wa-color-brand-normal)");
        fwItem.add(fwLabel);

        for (PluginEntry fw : PluginCatalog.getFrameworks())
        {
            var frameworkItem = new WaTreeItem<>();
            var frameworkLink = new Link<>();
            frameworkLink.setTag("a");
            frameworkLink.addAttribute("href", "javascript:void(0)");
            frameworkLink.addAttribute("(click)", "navigateToFramework('" + fw.getId() + "')");
            frameworkLink.setText(fw.getName());
            frameworkLink.addStyle("font-size", "var(--wa-font-size-xs)");
            frameworkLink.addStyle("color", "var(--wa-color-brand-normal)");
            frameworkLink.addStyle("cursor", "pointer");
            frameworkItem.add(frameworkLink);
            fwItem.add(frameworkItem);
        }

        tree.add(fwItem);

        add(tree);
    }

    private WaTreeItem<?> createComponentTreeItem(String pluginId, PluginEntry.ComponentInfo comp)
    {
        var item = new WaTreeItem<>();
        String slug = comp.className().replaceAll("([a-z])([A-Z])", "$1-$2").toLowerCase();

        var link = new Link<>();
        link.setTag("a");
        link.addAttribute("href", "javascript:void(0)");
        link.addAttribute("(click)",
                "navigateToComponent('" + pluginId + "', '" + slug + "')");
        link.setText(comp.className());
        link.addStyle("font-size", "var(--wa-font-size-2xs)");
        link.addStyle("color", "var(--wa-color-text-quiet)");
        link.addStyle("cursor", "pointer");
        item.add(link);
        return item;
    }

    @Override
    public List<String> fields()
    {
        var f = new ArrayList<>(INgComponent.super.fields());
        f.add("private router: Router = inject(Router);");
        return f;
    }

    @Override
    public List<String> methods()
    {
        var m = new ArrayList<String>();
        m.add("""
                navigateToPlugin(pluginId: string) {
                    this.router.navigate(['/plugins', pluginId]);
                }
                """);
        m.add("""
                navigateToComponent(pluginId: string, slug: string) {
                    this.router.navigate(['/plugins', pluginId, slug]);
                }
                """);
        m.add("""
                navigateToFramework(frameworkId: string) {
                    this.router.navigate(['/frameworks', frameworkId]);
                }
                """);
        m.add("""
                onFilterChange(event: any) {
                    const query = (event?.target?.value || '').toLowerCase().trim();
                    const items = document.querySelectorAll('wa-tree-item');
                    items.forEach((item: any) => {
                        const text = item.textContent?.toLowerCase() || '';
                        if (!query || text.includes(query)) {
                            item.style.display = '';
                            let parent = item.parentElement?.closest('wa-tree-item');
                            while (parent) {
                                parent.style.display = '';
                                parent = parent.parentElement?.closest('wa-tree-item');
                            }
                        } else {
                            item.style.display = 'none';
                        }
                    });
                    items.forEach((item: any) => {
                        if (item.style.display === 'none') {
                            const visibleChild = item.querySelector('wa-tree-item:not([style*="display: none"])');
                            if (visibleChild) {
                                item.style.display = '';
                            }
                        }
                    });
                }
                """);
        return m;
    }
}
