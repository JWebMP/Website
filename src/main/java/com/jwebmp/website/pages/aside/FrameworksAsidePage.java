package com.jwebmp.website.pages.aside;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
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
import com.jwebmp.website.pages.frameworks.AngularMaterialFrameworkPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
import com.jwebmp.website.pages.frameworks.JQueryUIFrameworkPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeFrameworkPage;
import com.jwebmp.website.pages.frameworks.WebAwesomeProFrameworkPage;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Aside component for the UI Frameworks page.
 * Renders a search filter and a tree of frameworks with their components
 * and dependent plugins nested underneath.
 */
@NgComponent("jwebmp-frameworks-aside")
@NgRoutable(path = "frameworks", outlet = "aside")
@NgImportReference(value = "Router", reference = "@angular/router")
@NgImportReference(value = "inject", reference = "@angular/core")
public class FrameworksAsidePage extends DivSimple<FrameworksAsidePage> implements INgComponent<FrameworksAsidePage>
{
    /** Maps framework IDs to their component lists. */
    private static final Map<String, List<PluginEntry.ComponentInfo>> FRAMEWORK_COMPONENTS = new LinkedHashMap<>();

    /** Maps framework IDs to dependent plugin IDs. */
    private static final Map<String, List<String>> FRAMEWORK_DEPENDENT_PLUGINS = new LinkedHashMap<>();

    static
    {
        FRAMEWORK_COMPONENTS.put("web-awesome", WebAwesomeFrameworkPage.COMPONENTS);
        FRAMEWORK_COMPONENTS.put("web-awesome-pro", WebAwesomeProFrameworkPage.COMPONENTS);
        FRAMEWORK_COMPONENTS.put("bootstrap", BootstrapFrameworkPage.COMPONENTS);
        FRAMEWORK_COMPONENTS.put("jquery-ui", JQueryUIFrameworkPage.COMPONENTS);
        FRAMEWORK_COMPONENTS.put("angular-material", AngularMaterialFrameworkPage.COMPONENTS);

        FRAMEWORK_DEPENDENT_PLUGINS.put("web-awesome", List.of("fontawesome", "fontawesome-pro"));
        FRAMEWORK_DEPENDENT_PLUGINS.put("web-awesome-pro", List.of("chartjs"));
        FRAMEWORK_DEPENDENT_PLUGINS.put("bootstrap", List.of());
        FRAMEWORK_DEPENDENT_PLUGINS.put("jquery-ui", List.of("jquery", "easing"));
        FRAMEWORK_DEPENDENT_PLUGINS.put("angular-material", List.of());
    }

    public FrameworksAsidePage()
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
        search.setPlaceholder("Filter\u2026");
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
        heading.setText("Frameworks & Components");
        add(heading);

        // Tree
        var tree = new WaTree<>();
        tree.setIndentSize("12px");
        tree.setIndentGuideColor("var(--wa-color-neutral-300)");

        for (PluginEntry fw : PluginCatalog.getFrameworks())
        {
            var fwItem = new WaTreeItem<>();

            // Framework link — navigate primary outlet
            var fwLink = new Link<>();
            fwLink.setTag("a");
            fwLink.addAttribute("href", "javascript:void(0)");
            fwLink.addAttribute("(click)", "navigateToFramework('" + fw.getId() + "')");
            fwLink.setText(fw.getName());
            fwLink.addStyle("font-weight", "var(--wa-font-weight-semibold)");
            fwLink.addStyle("cursor", "pointer");
            fwItem.add(fwLink);

            // Group components by category
            List<PluginEntry.ComponentInfo> components = FRAMEWORK_COMPONENTS.getOrDefault(fw.getId(), List.of());
            if (!components.isEmpty())
            {
                Map<String, List<PluginEntry.ComponentInfo>> grouped = groupByCategory(components);

                for (Map.Entry<String, List<PluginEntry.ComponentInfo>> group : grouped.entrySet())
                {
                    if (grouped.size() == 1 && group.getValue().size() <= 6)
                    {
                        // Small framework — list components directly
                        for (PluginEntry.ComponentInfo comp : group.getValue())
                        {
                            fwItem.add(createComponentTreeItem(fw.getId(), comp));
                        }
                    }
                    else
                    {
                        // Group into category sub-items
                        var catItem = new WaTreeItem<>();
                        var catLabel = new DivSimple<>();
                        catLabel.setTag("span");
                        catLabel.setText(group.getKey());
                        catLabel.addStyle("color", "var(--wa-color-text-quiet)");
                        catLabel.addStyle("font-size", "var(--wa-font-size-xs)");
                        catItem.add(catLabel);

                        for (PluginEntry.ComponentInfo comp : group.getValue())
                        {
                            catItem.add(createComponentTreeItem(fw.getId(), comp));
                        }
                        fwItem.add(catItem);
                    }
                }
            }

            // Dependent plugins nested under framework
            List<String> depPluginIds = FRAMEWORK_DEPENDENT_PLUGINS.getOrDefault(fw.getId(), List.of());
            if (!depPluginIds.isEmpty())
            {
                var depsItem = new WaTreeItem<>();
                var depsLabel = new DivSimple<>();
                depsLabel.setTag("span");
                depsLabel.setText("Related Plugins");
                depsLabel.addStyle("color", "var(--wa-color-brand-normal)");
                depsLabel.addStyle("font-size", "var(--wa-font-size-xs)");
                depsItem.add(depsLabel);

                for (String depId : depPluginIds)
                {
                    PluginCatalog.getById(depId).ifPresent(dep ->
                    {
                        var depItem = new WaTreeItem<>();
                        var depLink = new Link<>();
                        depLink.setTag("a");
                        depLink.addAttribute("href", "javascript:void(0)");
                        depLink.addAttribute("(click)", "navigateToPlugin('" + dep.getId() + "')");
                        depLink.setText(dep.getName());
                        depLink.addStyle("color", "var(--wa-color-brand-normal)");
                        depLink.addStyle("cursor", "pointer");
                        depItem.add(depLink);
                        depsItem.add(depItem);
                    });
                }
                fwItem.add(depsItem);
            }

            tree.add(fwItem);
        }

        add(tree);
    }

    private WaTreeItem<?> createComponentTreeItem(String frameworkId, PluginEntry.ComponentInfo comp)
    {
        var item = new WaTreeItem<>();
        String slug = comp.className().replaceAll("([a-z])([A-Z])", "$1-$2").toLowerCase();

        var link = new Link<>();
        link.setTag("a");
        link.addAttribute("href", "javascript:void(0)");
        link.addAttribute("(click)",
                "navigateToComponent('" + frameworkId + "', '" + slug + "')");
        link.setText(comp.className());
        link.addStyle("font-size", "var(--wa-font-size-xs)");
        link.addStyle("cursor", "pointer");
        item.add(link);
        return item;
    }

    private static Map<String, List<PluginEntry.ComponentInfo>> groupByCategory(List<PluginEntry.ComponentInfo> components)
    {
        Map<String, List<PluginEntry.ComponentInfo>> groups = new LinkedHashMap<>();
        for (PluginEntry.ComponentInfo comp : components)
        {
            String category = deriveCategoryFromPackage(comp.packageName(), comp.className());
            groups.computeIfAbsent(category, k -> new ArrayList<>()).add(comp);
        }
        return groups;
    }

    private static String deriveCategoryFromPackage(String pkg, String className)
    {
        if (pkg == null || pkg.isBlank()) return "General";
        String lastSegment = pkg.contains(".") ? pkg.substring(pkg.lastIndexOf('.') + 1) : pkg;

        return switch (lastSegment)
        {
            case "button", "copybutton" -> "Buttons";
            case "card", "callout", "details" -> "Cards & Containers";
            case "breadcrumb", "tabgroup", "tree", "tabs" -> "Navigation";
            case "input", "numberinput", "textarea", "select", "checkbox", "radio", "range",
                 "colorpicker", "rating", "waswitch", "spinner", "selectmenu",
                 "datepicker", "timepicker", "fileupload" -> "Form Controls";
            case "text", "tag", "badge", "icon", "avatar", "divider", "qrcode", "markdown",
                 "tables" -> "Data Display";
            case "carousel", "animatedimage", "imagecompare", "comparison", "zoom",
                 "images", "figures", "media" -> "Media";
            case "dialog", "drawer", "tooltip", "popover", "popup", "toast", "modal",
                 "popovers", "toasts" -> "Overlays & Feedback";
            case "page" -> "Page Shell";
            case "progressbar", "progress", "skeleton" -> "Progress & Loading";
            case "splitpanel", "scroller", "containers" -> "Layout";
            case "accordion", "collapse" -> "Disclosure";
            case "alerts" -> "Alerts";
            case "dropdown", "navbar", "navs", "pagination", "menu" -> "Navigation";
            case "forms" -> "Form Controls";
            case "jumbotron" -> "Hero";
            case "listgroup" -> "Lists";
            case "toggle", "close" -> "Utilities";
            case "autocomplete" -> "Form Controls";
            case "chips" -> "Form Controls";
            case "formfield" -> "Form Controls";
            case "table" -> "Data Display";
            case "draggable", "droppable", "resizable", "selectable", "sortable" -> "Interaction";
            case "slider" -> "Form Controls";
            case "checkboxradio" -> "Form Controls";
            case "components" ->
            {
                if (className.startsWith("WaStack") || className.startsWith("WaCluster")
                    || className.startsWith("WaGrid") || className.startsWith("WaSplit")
                    || className.startsWith("WaFlank") || className.startsWith("WaFrame")
                    || className.startsWith("WaDiv"))
                {
                    yield "Layout";
                }
                yield "General";
            }
            default ->
            {
                if (pkg.contains("webawesomepro"))
                {
                    if (className.contains("Chart") || className.contains("Sparkline")) yield "Charts";
                    if (className.contains("Combobox") || className.contains("FileInput")) yield "Form Controls";
                    if (className.contains("Icon")) yield "Icons";
                }
                yield "General";
            }
        };
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
                navigateToFramework(frameworkId: string) {
                    this.router.navigate(['/frameworks', frameworkId]);
                }
                """);
        m.add("""
                navigateToComponent(frameworkId: string, slug: string) {
                    this.router.navigate(['/frameworks', frameworkId, slug]);
                }
                """);
        m.add("""
                navigateToPlugin(pluginId: string) {
                    this.router.navigate(['/plugins'], {fragment: pluginId});
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







