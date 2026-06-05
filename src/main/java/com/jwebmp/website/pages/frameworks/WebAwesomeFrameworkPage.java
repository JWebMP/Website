package com.jwebmp.website.pages.frameworks;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-framework-web-awesome")
@NgRoutable(path = "frameworks/web-awesome")
public class WebAwesomeFrameworkPage extends FrameworkDetailPage<WebAwesomeFrameworkPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            // ── Page Shell ───────────────────────────────────
            new PluginEntry.ComponentInfo("WaPage",
                    "Full application shell with banner, header, navigation, main, aside, and footer slots. "
                    + "Provides responsive layout with mobile navigation drawer, sticky sections, and configurable column widths.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(
                            new PluginEntry.PropertyInfo("navOpen", "boolean", "false", "Controls the mobile navigation drawer open/close state"),
                            new PluginEntry.PropertyInfo("view", "String", "null", "Read-only view mode based on mobileBreakpoint: 'mobile' or 'desktop'"),
                            new PluginEntry.PropertyInfo("disableSticky", "String", "null", "Space-separated list of sticky sections to disable (e.g. 'header subheader')"),
                            new PluginEntry.PropertyInfo("navigationPlacement", "String", "null", "Placement of mobile nav drawer: 'start' or 'end'"),
                            new PluginEntry.PropertyInfo("menuWidth", "String", "null", "Width of the navigation/menu column (CSS value, sets --menu-width)"),
                            new PluginEntry.PropertyInfo("mainWidth", "String", "null", "Width of the main content area (CSS value, sets --main-width)"),
                            new PluginEntry.PropertyInfo("asideWidth", "String", "null", "Width of the aside column (CSS value, sets --aside-width)"),
                            new PluginEntry.PropertyInfo("bannerHeight", "String", "null", "Height of the banner area (CSS value, sets --banner-height)"),
                            new PluginEntry.PropertyInfo("headerHeight", "String", "null", "Height of the header (CSS value, sets --header-height)"),
                            new PluginEntry.PropertyInfo("subheaderHeight", "String", "null", "Height of the subheader (CSS value, sets --subheader-height)"),
                            new PluginEntry.PropertyInfo("disableNavigationToggle", "Boolean", "false", "Hides the built-in navigation toggle button")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Full Application Shell",
                                    "Build a complete responsive application shell with header, navigation, main content, aside, and footer.",
                                    "var page = new WaPage<>();\n\n// Header with branding\npage.getHeader().add(new WaText<>().setText(\"My Application\"));\n\n// Navigation drawer with tree menu\npage.getNavigation().add(buildMenuTree());\n\n// Main content area with router outlet\npage.getMain().add(new RouterOutlet<>());\n\n// Aside for secondary content\npage.getAside().add(buildTableOfContents());\n\n// Footer\npage.getFooter().add(new WaText<>().setText(\"© 2026 My Corp\"));",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Customized Column Widths",
                                    "Configure column widths and disable sticky header.",
                                    "var page = new WaPage<>();\npage.setMenuWidth(\"280px\");\npage.setMainWidth(\"1fr\");\npage.setAsideWidth(\"300px\");\npage.setDisableSticky(\"header\");",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new WaPage<>()", "Creates a wa-page element")),
                    List.of(
                            new PluginEntry.MethodInfo("getBanner", "WaPageBanner<?>", "getBanner()", "Gets or creates the banner sub-component"),
                            new PluginEntry.MethodInfo("getHeader", "WaPageHeader<?>", "getHeader()", "Gets or creates the header sub-component"),
                            new PluginEntry.MethodInfo("getSubHeader", "WaPageSubHeader<?>", "getSubHeader()", "Gets or creates the sub-header sub-component"),
                            new PluginEntry.MethodInfo("getNavigation", "WaPageContentsNavigation<?>", "getNavigation()", "Gets or creates the navigation drawer sub-component"),
                            new PluginEntry.MethodInfo("getNavigationHeader", "WaPageContentsNavigationHeader<?>", "getNavigationHeader()", "Gets or creates the navigation header sub-component"),
                            new PluginEntry.MethodInfo("getNavigationFooter", "WaPageContentsNavigationFooter<?>", "getNavigationFooter()", "Gets or creates the navigation footer sub-component"),
                            new PluginEntry.MethodInfo("getMain", "WaPageContentsMain<?>", "getMain()", "Gets or creates the main content sub-component"),
                            new PluginEntry.MethodInfo("getMainHeader", "WaPageContentsMainHeader<?>", "getMainHeader()", "Gets or creates the main header sub-component"),
                            new PluginEntry.MethodInfo("getMainFooter", "WaPageContentsMainFooter", "getMainFooter()", "Gets or creates the main footer sub-component"),
                            new PluginEntry.MethodInfo("getAside", "WaPageContentsAside<?>", "getAside()", "Gets or creates the aside sub-component"),
                            new PluginEntry.MethodInfo("getFooter", "WaPageFooter<?>", "getFooter()", "Gets or creates the footer sub-component"),
                            new PluginEntry.MethodInfo("getMenu", "WaPageMenu<?>", "getMenu()", "Gets or creates the menu sub-component"),
                            new PluginEntry.MethodInfo("getSkipToContent", "WaPageSkipToContent<?>", "getSkipToContent()", "Gets or creates the skip-to-content accessibility link"),
                            new PluginEntry.MethodInfo("getNavigationToggle", "WaPageNavigationToggle<?>", "getNavigationToggle()", "Gets or creates the navigation toggle button"),
                            new PluginEntry.MethodInfo("getDialogWrapper", "WaPageDialogWrapper<?>", "getDialogWrapper()", "Gets or creates the dialog wrapper for modal overlays"),
                            new PluginEntry.MethodInfo("showNavigation", "void", "showNavigation()", "Opens the mobile navigation drawer"),
                            new PluginEntry.MethodInfo("hideNavigation", "void", "hideNavigation()", "Closes the mobile navigation drawer"),
                            new PluginEntry.MethodInfo("toggleNavigation", "void", "toggleNavigation()", "Toggles the mobile navigation drawer")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.SlotInfo("default", "All page sub-components (banner, header, navigation, main, aside, footer, etc.)"),
                            new PluginEntry.SlotInfo("skip-to-content", "Accessibility skip-to-content link")
                    ),
                    List.of("BreakpointCapable", "SpaceTokenCapable", "TypographyTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaPageBanner",
                    "Top banner slot for product-level navigation, announcements, or branding above the header.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageBanner<>()", "Creates a wa-page-banner element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Banner content")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageHeader",
                    "Header slot for branding, primary actions, and top-level navigation. Sticky by default.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageHeader<>()", "Creates a wa-page-header element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Header content — logo, navigation links, action buttons")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageSubHeader",
                    "Sub-header below the main header for secondary navigation, breadcrumbs, or contextual actions.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageSubHeader<>()", "Creates a wa-page-sub-header element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Sub-header content — breadcrumbs, tabs, search")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContent", "Page content wrapper that holds the main, aside, and navigation columns.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContent<>()", "Creates a wa-page-content element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Main, aside, and navigation sub-components")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContentsMain",
                    "Primary content area within the page. Receives the main body content and router outlet.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContentsMain<>()", "Creates a wa-page-contents-main element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Main content — router outlet, page body")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContentsMainHeader", "Header within the main content area for page-level headings and actions.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContentsMainHeader<>()", "Creates a wa-page-contents-main-header element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Main header content")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContentsMainFooter", "Footer within the main content area for pagination or page-level actions.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContentsMainFooter<>()", "Creates a wa-page-contents-main-footer element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Main footer content")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContentsAside",
                    "Aside/sidebar content area for secondary content like table of contents, filters, or related links.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContentsAside<>()", "Creates a wa-page-contents-aside element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Aside content — table of contents, filters, ads")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContentsNavigation",
                    "Navigation drawer for side menu. On mobile, renders as a slide-out drawer controlled by navOpen.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContentsNavigation<>()", "Creates a wa-page-contents-navigation element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Navigation menu content — tree, links")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContentsNavigationHeader", "Branding area inside the navigation drawer.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContentsNavigationHeader<>()", "Creates a wa-page-contents-navigation-header element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Navigation header branding content")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageContentsNavigationFooter", "Footer links inside the navigation drawer.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageContentsNavigationFooter<>()", "Creates a wa-page-contents-navigation-footer element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Navigation footer content")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageNavigationToggle", "Burger button to toggle the mobile navigation drawer. Auto-hidden on desktop.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageNavigationToggle<>()", "Creates a wa-page-navigation-toggle element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaPageNavigationToggleIcon", "Icon displayed inside the navigation toggle button.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaPageFooter",
                    "Page footer slot for copyright notices, legal links, and site-wide actions.",
                    "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageFooter<>()", "Creates a wa-page-footer element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Footer content — copyright, links, social icons")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageMenu", "Menu slot inside the navigation drawer for tree-based navigation.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageMenu<>()", "Creates a wa-page-menu element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Menu/tree navigation content")),
                    List.of()),
            new PluginEntry.ComponentInfo("WaPageSkipToContent", "Accessibility skip-to-content link that appears on keyboard focus for screen reader users.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageSkipToContent<>()", "Creates a wa-page-skip-to-content element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaPageDialogWrapper", "Dialog wrapper for modal overlays. Ensures dialogs render above the page shell.", "com.jwebmp.webawesome.components.page",
                    List.of(), List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPageDialogWrapper<>()", "Creates a wa-page-dialog-wrapper element")),
                    List.of(), List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Dialog components")),
                    List.of()),

            // ── Layout ───────────────────────────────────────
            new PluginEntry.ComponentInfo("WaStack", "Vertical stack layout with configurable gap between children",
                    "com.jwebmp.webawesome.components",
                    List.of(new PluginEntry.PropertyInfo("gap", "PageSize", "null", "Vertical gap between children: ExtraSmall, Small, Medium, Large, ExtraLarge")),
                    List.of(new PluginEntry.ExampleSnippet("Stack Layout", "Stack elements vertically.",
                            "var stack = new WaStack<>();\nstack.setGap(PageSize.Medium);\nstack.add(headingText(\"Title\"));\nstack.add(bodyText(\"Content\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaStack<>()", "Creates a wa-stack element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaCluster", "Horizontal cluster layout with wrapping and configurable gap",
                    "com.jwebmp.webawesome.components",
                    List.of(new PluginEntry.PropertyInfo("gap", "PageSize", "null", "Horizontal gap between children")),
                    List.of(new PluginEntry.ExampleSnippet("Cluster Layout", "Horizontal tag cluster.",
                            "var cluster = new WaCluster<>();\ncluster.setGap(PageSize.Small);\ncluster.add(new WaTag<>(\"Java\"));\ncluster.add(new WaTag<>(\"Angular\"));", "java")),
                    List.of(), List.of(new PluginEntry.MethodInfo("setNoWrap", "J", "setNoWrap()", "Prevents children from wrapping to the next line")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaGrid", "CSS Grid layout with configurable min column size and gap",
                    "com.jwebmp.webawesome.components",
                    List.of(
                            new PluginEntry.PropertyInfo("minColumnSize", "String", "null", "Minimum column width (e.g. '20rem')"),
                            new PluginEntry.PropertyInfo("gap", "PageSize", "null", "Gap between grid cells")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Grid Layout", "Create a responsive card grid.",
                            "var grid = new WaGrid<>();\ngrid.setMinColumnSize(\"18rem\");\ngrid.setGap(PageSize.Small);\ngrid.add(card1);\ngrid.add(card2);", "java")),
                    List.of(), List.of(new PluginEntry.MethodInfo("spanFullRow", "J", "spanFullRow()", "Makes the next child span the full grid width")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSplit", "Split layout with configurable ratio between two children",
                    "com.jwebmp.webawesome.components",
                    List.of(new PluginEntry.PropertyInfo("fraction", "String", "null", "Split ratio (e.g. '2/3', '1/4')")),
                    List.of(),
                    List.of(), List.of(
                            new PluginEntry.MethodInfo("row", "J", "row()", "Sets horizontal (row) layout direction"),
                            new PluginEntry.MethodInfo("column", "J", "column()", "Sets vertical (column) layout direction"),
                            new PluginEntry.MethodInfo("alignItems", "J", "alignItems(String value)", "Sets cross-axis alignment (e.g. 'center', 'stretch')")
                    ), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaFlank", "Flanking layout with side and main content areas",
                    "com.jwebmp.webawesome.components",
                    List.of(),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaFrame", "Frame layout for constrained content areas with max-width control",
                    "com.jwebmp.webawesome.components",
                    List.of(),
                    List.of(),
                    List.of(), List.of(new PluginEntry.MethodInfo("setAspectRatio", "J", "setAspectRatio(String ratio)", "Sets the aspect ratio constraint (e.g. '16/9', '4/3')")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaDiv", "Styled div with WebAwesome token support for padding, margin, border, shadow, and typography",
                    "com.jwebmp.webawesome.components",
                    List.of(
                            new PluginEntry.PropertyInfo("padding", "WaSpaceToken", "null", "Padding using WA space tokens"),
                            new PluginEntry.PropertyInfo("margin", "WaSpaceToken", "null", "Margin using WA space tokens"),
                            new PluginEntry.PropertyInfo("fontSize", "WaTypographyToken", "null", "Font size using WA typography tokens")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSplitPanel", "Resizable split panel with draggable divider between two areas",
                    "com.jwebmp.webawesome.components.splitpanel",
                    List.of(
                            new PluginEntry.PropertyInfo("position", "Integer", "50", "Initial divider position as percentage"),
                            new PluginEntry.PropertyInfo("vertical", "Boolean", "false", "Vertical split instead of horizontal"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables resizing"),
                            new PluginEntry.PropertyInfo("primary", "SplitPanelPrimary", "start", "Which panel is primary: start or end"),
                            new PluginEntry.PropertyInfo("snap", "String", "null", "Snap points as percentages (e.g. '25% 50% 75%')")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Split Panel", "Resizable two-pane layout.",
                            "var split = new WaSplitPanel<>();\nsplit.setPosition(30);\nsplit.add(leftPanel);\nsplit.add(rightPanel);", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaScroller", "Scrollable container with custom scrollbar styling",
                    "com.jwebmp.webawesome.components.scroller",
                    List.of(),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Buttons ──────────────────────────────────────
            new PluginEntry.ComponentInfo("WaButton",
                    "A customizable button component with variant, appearance, size, pill, loading, "
                    + "prefix/suffix icon slots, link mode, and form integration.",
                    "com.jwebmp.webawesome.components.button",
                    List.of(
                            new PluginEntry.PropertyInfo("variant", "Variant", "null", "Color variant: Brand, Success, Warning, Danger, Neutral"),
                            new PluginEntry.PropertyInfo("appearance", "Appearance", "null", "Visual style: Filled, Outlined, Plain"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Button size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("pill", "Boolean", "false", "Renders fully rounded corners"),
                            new PluginEntry.PropertyInfo("caret", "Boolean", "false", "Adds a caret indicator for dropdowns"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the button, preventing interaction"),
                            new PluginEntry.PropertyInfo("loading", "Boolean", "false", "Shows a loading spinner"),
                            new PluginEntry.PropertyInfo("prefix", "IComponentHierarchyBase", "null", "Component placed in the start slot (e.g. icon)"),
                            new PluginEntry.PropertyInfo("suffix", "IComponentHierarchyBase", "null", "Component placed in the end slot (e.g. icon)"),
                            new PluginEntry.PropertyInfo("withStart", "Boolean", "false", "SSR attribute — renders with-start"),
                            new PluginEntry.PropertyInfo("withEnd", "Boolean", "false", "SSR attribute — renders with-end"),
                            new PluginEntry.PropertyInfo("type", "InputButtonType", "null", "HTML button type: submit, reset, button"),
                            new PluginEntry.PropertyInfo("formId", "String", "null", "Links this button to a form by ID"),
                            new PluginEntry.PropertyInfo("formAction", "String", "null", "URL for form submission"),
                            new PluginEntry.PropertyInfo("formMethod", "String", "null", "HTTP method for form submission (POST, GET)"),
                            new PluginEntry.PropertyInfo("formNoValidate", "Boolean", "false", "Skips validation on form submit"),
                            new PluginEntry.PropertyInfo("formTarget", "String", "null", "Target for form submission (_blank, _self, etc.)"),
                            new PluginEntry.PropertyInfo("blurEvent", "String", "null", "Angular expression for (wa-blur) event"),
                            new PluginEntry.PropertyInfo("focusEvent", "String", "null", "Angular expression for (wa-focus) event"),
                            new PluginEntry.PropertyInfo("invalidEvent", "String", "null", "Angular expression for (wa-invalid) event")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Button", "Create a brand-coloured button.",
                                    "var btn = new WaButton<>(\"Click Me\", Variant.Brand);", "java"),
                            new PluginEntry.ExampleSnippet("Outlined Danger Button", "Outlined appearance with danger variant.",
                                    "var btn = new WaButton<>(\"Delete\", Variant.Danger);\nbtn.setAppearance(Appearance.Outlined);", "java"),
                            new PluginEntry.ExampleSnippet("Button with Icon", "Add a prefix icon to the button.",
                                    "var btn = new WaButton<>(\"Settings\", Variant.Neutral);\nbtn.setPrefix(new WaIcon<>(\"gear\"));", "java"),
                            new PluginEntry.ExampleSnippet("Pill Loading Button", "A pill-shaped button in loading state.",
                                    "var btn = new WaButton<>(\"Saving...\", Variant.Success);\nbtn.setPill(true);\nbtn.setLoading(true);", "java"),
                            new PluginEntry.ExampleSnippet("Link Button", "Render a button that behaves as a link.",
                                    "var btn = new WaButton<>(\"Visit Site\", Variant.Brand);\nbtn.setAsLink(\"https://example.com\", \"_blank\", null);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new WaButton<>()", "Default constructor — creates an empty wa-button"),
                            new PluginEntry.ConstructorInfo("new WaButton<>(String text)", "Creates a button with the given label text"),
                            new PluginEntry.ConstructorInfo("new WaButton<>(String text, Variant variant)", "Creates a button with label and color variant")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setAsLink", "J", "setAsLink(String href, String target, String download)", "Configures the button as a link with href, target, and optional download filename")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("wa-blur", "Fires when the button loses focus"),
                            new PluginEntry.EventInfo("wa-focus", "Fires when the button receives focus"),
                            new PluginEntry.EventInfo("wa-invalid", "Emitted when form validation fails")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "The button label content"),
                            new PluginEntry.SlotInfo("start", "Left-aligned icon or element (prefix)"),
                            new PluginEntry.SlotInfo("end", "Right-aligned icon or element (suffix)")
                    ),
                    List.of("TooltipCapable", "VariantCapable", "GapCapable", "BorderTokenCapable",
                            "ShadowTokenCapable", "SpaceTokenCapable", "FocusTokenCapable",
                            "TransitionTokenCapable", "TypographyTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaButtonGroup", "Group of buttons rendered inline with shared appearance",
                    "com.jwebmp.webawesome.components.button",
                    List.of(new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label for the group")),
                    List.of(new PluginEntry.ExampleSnippet("Button Group", "Group three buttons together.",
                            "var group = new WaButtonGroup<>();\ngroup.add(new WaButton<>(\"One\", Variant.Brand));\ngroup.add(new WaButton<>(\"Two\", Variant.Brand));\ngroup.add(new WaButton<>(\"Three\", Variant.Brand));", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSplitButton", "Button with attached dropdown for secondary actions",
                    "com.jwebmp.webawesome.components.button",
                    List.of(
                            new PluginEntry.PropertyInfo("variant", "Variant", "null", "Color variant for the button"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Button size"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables both button and dropdown")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaCopyButton", "One-click copy-to-clipboard button with success feedback",
                    "com.jwebmp.webawesome.components.copybutton",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "The text value to copy to clipboard"),
                            new PluginEntry.PropertyInfo("from", "String", "null", "CSS selector of the element whose text content to copy"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the copy button"),
                            new PluginEntry.PropertyInfo("feedbackDuration", "Integer", "1000", "Duration in ms to show success feedback"),
                            new PluginEntry.PropertyInfo("tooltipPlacement", "TooltipPlacement", "top", "Placement of the success tooltip")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Copy Text", "Copy a value to clipboard.",
                            "var btn = new WaCopyButton<>();\nbtn.setValue(\"npm install angular-awesome\");", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Cards & Containers ───────────────────────────
            new PluginEntry.ComponentInfo("WaCard",
                    "Flexible container to group related content — images, headers, body text, and footers. "
                    + "Supports appearance variants, size, orientation, and full CSS custom property theming.",
                    "com.jwebmp.webawesome.components.card",
                    List.of(
                            new PluginEntry.PropertyInfo("appearance", "Appearance", "null", "Visual style: Filled, Outlined, Plain"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Card size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("orientation", "CardOrientation", "null", "Layout orientation: horizontal or vertical"),
                            new PluginEntry.PropertyInfo("withHeader", "Boolean", "false", "Whether the card has a header section"),
                            new PluginEntry.PropertyInfo("withImage", "Boolean", "false", "Whether the card has an image section"),
                            new PluginEntry.PropertyInfo("withFooter", "Boolean", "false", "Whether the card has a footer section"),
                            new PluginEntry.PropertyInfo("withMedia", "Boolean", "false", "Whether the card contains media content"),
                            new PluginEntry.PropertyInfo("color", "String", "null", "Text color"),
                            new PluginEntry.PropertyInfo("backgroundColor", "String", "null", "Background color"),
                            new PluginEntry.PropertyInfo("borderRadius", "String", "null", "Corner radius (--border-radius CSS var)"),
                            new PluginEntry.PropertyInfo("borderColor", "String", "null", "Border color (--border-color CSS var)"),
                            new PluginEntry.PropertyInfo("innerBorderColor", "String", "null", "Divider color between sections (--inner-border-color)"),
                            new PluginEntry.PropertyInfo("borderWidth", "String", "null", "Border thickness (--border-width CSS var)"),
                            new PluginEntry.PropertyInfo("spacing", "String", "null", "Internal layout spacing (--spacing CSS var)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Outlined Card", "A simple outlined card with text.",
                                    "var card = new WaCard<>();\ncard.setAppearance(Appearance.Outlined);\ncard.withText(\"Hello world\");", "java"),
                            new PluginEntry.ExampleSnippet("Card with Header & Footer", "Full card with all sections.",
                                    """
                                    var card = new WaCard<>();
                                    card.setAppearance(Appearance.Filled);
                                    card.withHeader("Card Title");
                                    card.withText("This is the card body content.");
                                    var footer = new DivSimple<>();
                                    footer.add(new WaButton<>("Action", Variant.Brand));
                                    card.withFooter(footer);""", "java"),
                            new PluginEntry.ExampleSnippet("Card with Image", "Card with a top image.",
                                    """
                                    var card = new WaCard<>();
                                    card.withImage(new Image<>("photo.jpg"));
                                    card.withHeader("Photo");
                                    card.withText("A beautiful landscape.");""", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new WaCard<>()", "Creates an empty wa-card element")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("withWidth", "J", "withWidth(String width)", "Sets the card width via inline style"),
                            new PluginEntry.MethodInfo("withImage", "J", "withImage(Image<?> image)", "Adds an image to the card's image slot"),
                            new PluginEntry.MethodInfo("withHeader", "J", "withHeader(String header)", "Adds a text header to the card"),
                            new PluginEntry.MethodInfo("withHeader", "J", "withHeader(DivSimple<?> header)", "Adds a component header to the card"),
                            new PluginEntry.MethodInfo("withText", "J", "withText(String text)", "Adds paragraph text to the card body"),
                            new PluginEntry.MethodInfo("withBody", "J", "withBody(IComponentHierarchyBase<?,?> body)", "Adds any component to the card body"),
                            new PluginEntry.MethodInfo("withSubText", "J", "withSubText(String text)", "Adds small/sub text to the card"),
                            new PluginEntry.MethodInfo("withFooter", "J", "withFooter(DivSimple<?> footer)", "Adds a footer component to the card")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.SlotInfo("default", "The main body content of the card"),
                            new PluginEntry.SlotInfo("header", "Optional header area content"),
                            new PluginEntry.SlotInfo("footer", "Optional footer area content"),
                            new PluginEntry.SlotInfo("image", "Optional image at the top of the card")
                    ),
                    List.of("VariantCapable", "BorderTokenCapable", "ShadowTokenCapable", "SpaceTokenCapable", "TypographyTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaCallout",
                    "Inline alert/message banner with variant styling, icon slot, size, and appearance options.",
                    "com.jwebmp.webawesome.components.callout",
                    List.of(
                            new PluginEntry.PropertyInfo("variant", "Variant", "null", "Color variant: Brand, Success, Warning, Danger, Neutral"),
                            new PluginEntry.PropertyInfo("appearance", "Appearance", "null", "Visual style: Filled, Outlined, Plain"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Callout size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("open", "Boolean", "true", "Whether the callout is visible"),
                            new PluginEntry.PropertyInfo("closable", "Boolean", "false", "Whether the callout can be dismissed"),
                            new PluginEntry.PropertyInfo("icon", "IComponentHierarchyBase", "null", "Icon placed in the icon slot")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Warning Callout", "Show a warning callout.",
                            "var callout = new WaCallout<>();\ncallout.setVariant(Variant.Warning);\ncallout.setText(\"This action is irreversible.\");", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaDetails",
                    "Expandable disclosure widget with summary, open/close animation, accordion grouping, and icon customization.",
                    "com.jwebmp.webawesome.components.details",
                    List.of(
                            new PluginEntry.PropertyInfo("summary", "String", "null", "Summary text shown in the collapsed header"),
                            new PluginEntry.PropertyInfo("open", "Boolean", "false", "Whether the details is expanded"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Prevents expanding"),
                            new PluginEntry.PropertyInfo("appearance", "DetailsAppearance", "null", "Visual style: Filled, Outlined, Plain"),
                            new PluginEntry.PropertyInfo("iconPosition", "IconPosition", "end", "Position of expand/collapse icon: start or end"),
                            new PluginEntry.PropertyInfo("name", "String", "null", "Group name for accordion behavior — one open at a time")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Accordion Group", "Three details in an accordion.",
                            "var d1 = new WaDetails<>();\nd1.setSummary(\"Section 1\");\nd1.setName(\"faq\");\nd1.setText(\"Content 1\");\n\nvar d2 = new WaDetails<>();\nd2.setSummary(\"Section 2\");\nd2.setName(\"faq\");\nd2.setText(\"Content 2\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaDetails<>()", "Creates a wa-details element")),
                    List.of(
                            new PluginEntry.MethodInfo("show", "J", "show()", "Programmatically opens the details"),
                            new PluginEntry.MethodInfo("hide", "J", "hide()", "Programmatically closes the details"),
                            new PluginEntry.MethodInfo("summary", "J", "summary(String summary)", "Sets the summary text"),
                            new PluginEntry.MethodInfo("summary", "J", "summary(IComponentHierarchyBase<?,?> summarySlot)", "Sets custom HTML summary content")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("wa-show", "Fires when the details starts to open"),
                            new PluginEntry.EventInfo("wa-after-show", "Fires after the open animation completes"),
                            new PluginEntry.EventInfo("wa-hide", "Fires when the details starts to close"),
                            new PluginEntry.EventInfo("wa-after-hide", "Fires after the close animation completes")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "Content shown when expanded"),
                            new PluginEntry.SlotInfo("summary", "HTML content for the summary header"),
                            new PluginEntry.SlotInfo("expand-icon", "Custom expand icon"),
                            new PluginEntry.SlotInfo("collapse-icon", "Custom collapse icon")
                    ),
                    List.of("BorderTokenCapable", "SpaceTokenCapable", "FocusTokenCapable", "TransitionTokenCapable")
            ),

            // ── Navigation ───────────────────────────────────
            new PluginEntry.ComponentInfo("WaBreadcrumbs", "Breadcrumb navigation trail with customizable separator",
                    "com.jwebmp.webawesome.components.breadcrumb",
                    List.of(new PluginEntry.PropertyInfo("separator", "BreadcrumbSeparator", "/", "Separator character between items")),
                    List.of(new PluginEntry.ExampleSnippet("Breadcrumbs", "Create a breadcrumb trail.",
                            "var crumbs = new WaBreadcrumbs<>();\ncrumbs.add(new WaBreadcrumbItem<>(\"/home\", \"Home\"));\ncrumbs.add(new WaBreadcrumbItem<>(\"/products\", \"Products\"));\ncrumbs.add(new WaBreadcrumbItem<>(null, \"Widget\"));", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaBreadcrumbItem", "Individual breadcrumb link item",
                    "com.jwebmp.webawesome.components.breadcrumb",
                    List.of(new PluginEntry.PropertyInfo("href", "String", "null", "URL the breadcrumb links to (null for current page)")),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaTabGroup",
                    "Tab container organizing content into panels, showing one at a time. "
                    + "Supports top/bottom/start/end placement, auto/manual activation, and custom styling.",
                    "com.jwebmp.webawesome.components.tabgroup",
                    List.of(
                            new PluginEntry.PropertyInfo("active", "String", "null", "Name of the currently active tab panel"),
                            new PluginEntry.PropertyInfo("placement", "TabPlacement", "top", "Tab position: top, bottom, start, end"),
                            new PluginEntry.PropertyInfo("activation", "TabActivation", "auto", "Keyboard activation: auto or manual"),
                            new PluginEntry.PropertyInfo("noScrollControls", "Boolean", "false", "Hides scroll arrows when tabs overflow")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Tab Group", "Create a tabbed interface.",
                            "var tabs = new WaTabGroup<>();\ntabs.add(new WaTab<>(\"General\", \"general\"));\ntabs.add(new WaTab<>(\"Settings\", \"settings\"));\ntabs.add(new WaTabPanel<>(\"general\", generalContent));\ntabs.add(new WaTabPanel<>(\"settings\", settingsContent));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaTabGroup<>()", "Creates a wa-tab-group element")),
                    List.of(
                            new PluginEntry.MethodInfo("addTab", "J", "addTab(String panelId, String tabText, boolean active)", "Adds a tab and panel pair by ID and label text"),
                            new PluginEntry.MethodInfo("addTab", "J", "addTab(WaTab<?> tab, WaTabPanel<?> panel, boolean active)", "Adds pre-built tab and panel components")
                    ),
                    List.of(new PluginEntry.EventInfo("wa-tab-show", "Fires when a tab is about to be shown"),
                            new PluginEntry.EventInfo("wa-tab-hide", "Fires when a tab is about to be hidden")),
                    List.of(new PluginEntry.SlotInfo("default", "Tab and panel children"),
                            new PluginEntry.SlotInfo("nav", "Navigation area for tabs")),
                    List.of("BorderTokenCapable", "SpaceTokenCapable", "ComponentGroupTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaTab", "Individual tab header within a tab group",
                    "com.jwebmp.webawesome.components.tabgroup",
                    List.of(
                            new PluginEntry.PropertyInfo("panel", "String", "null", "Name of the associated panel"),
                            new PluginEntry.PropertyInfo("active", "Boolean", "false", "Whether this tab is active"),
                            new PluginEntry.PropertyInfo("closable", "Boolean", "false", "Whether the tab shows a close button"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the tab")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaTabPanel", "Tab panel content associated with a tab",
                    "com.jwebmp.webawesome.components.tabgroup",
                    List.of(new PluginEntry.PropertyInfo("name", "String", "null", "Name that matches the associated tab's panel property")),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaTree",
                    "Hierarchical tree view with expandable items, selection modes, and customizable indent guides.",
                    "com.jwebmp.webawesome.components.tree",
                    List.of(
                            new PluginEntry.PropertyInfo("selection", "TreeSelectionMode", "null", "Selection mode: single, multiple, or leaf"),
                            new PluginEntry.PropertyInfo("indentGuideWidth", "String", "null", "Width of the indent guide lines"),
                            new PluginEntry.PropertyInfo("indentGuideColor", "String", "null", "Color of the indent guide lines"),
                            new PluginEntry.PropertyInfo("indentGuideOffset", "String", "null", "Offset of indent guide from the left edge"),
                            new PluginEntry.PropertyInfo("indentSize", "String", "null", "Size of each indent level")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Tree View", "Create a navigable tree.",
                            "var tree = new WaTree<>();\nvar item = new WaTreeItem<>();\nitem.setText(\"Documents\");\nvar child = new WaTreeItem<>();\nchild.setText(\"report.pdf\");\nitem.add(child);\ntree.add(item);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaTree<>()", "Creates a wa-tree element")),
                    List.of(
                            new PluginEntry.MethodInfo("add", "J", "add(WaTreeItem<?> item)", "Adds a tree item to the tree"),
                            new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the tree value via ngModel"),
                            new PluginEntry.MethodInfo("onSelectionChange", "J", "onSelectionChange(String handlerScript)", "Registers a selection change event handler")
                    ),
                    List.of(new PluginEntry.EventInfo("wa-selection-change", "Fires when the selection changes")),
                    List.of(new PluginEntry.SlotInfo("default", "Tree item children")),
                    List.of("BorderTokenCapable", "SpaceTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaTreeItem", "Individual tree node with expandable children, icon, and link support",
                    "com.jwebmp.webawesome.components.tree",
                    List.of(
                            new PluginEntry.PropertyInfo("expanded", "Boolean", "false", "Whether the node is expanded"),
                            new PluginEntry.PropertyInfo("selected", "Boolean", "false", "Whether the node is selected"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the tree item"),
                            new PluginEntry.PropertyInfo("lazy", "Boolean", "false", "Enables lazy loading of children")
                    ),
                    List.of(),
                    List.of(), List.of(
                            new PluginEntry.MethodInfo("add", "J", "add(WaTreeItem<?> child)", "Adds a child tree item"),
                            new PluginEntry.MethodInfo("onExpand", "J", "onExpand(String handlerScript)", "Registers a handler when the item expands"),
                            new PluginEntry.MethodInfo("onCollapse", "J", "onCollapse(String handlerScript)", "Registers a handler when the item collapses"),
                            new PluginEntry.MethodInfo("onLazyLoad", "J", "onLazyLoad(String handlerScript)", "Registers a handler for lazy loading children")
                    ), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaDropDown",
                    "Dropdown menu triggered by a button with popover panel, placement, and selection events.",
                    "com.jwebmp.webawesome.components.button",
                    List.of(
                            new PluginEntry.PropertyInfo("placement", "PlacementExtended", "bottom-start", "Preferred placement of the dropdown panel"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the dropdown trigger"),
                            new PluginEntry.PropertyInfo("stayOpenOnSelect", "Boolean", "false", "Keeps dropdown open after item selection"),
                            new PluginEntry.PropertyInfo("distance", "Integer", "null", "Pixel distance from trigger"),
                            new PluginEntry.PropertyInfo("skidding", "Integer", "null", "Pixel offset along the trigger"),
                            new PluginEntry.PropertyInfo("value", "String", "null", "The selected dropdown item value")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Dropdown Menu", "Create a dropdown with items.",
                            "var dd = new WaDropDown<>();\ndd.add(new WaButton<>(\"Options\", Variant.Brand));\ndd.add(new WaDropdownItem<>(\"Edit\"));\ndd.add(new WaDropdownItem<>(\"Delete\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaDropDown<>()", "Creates a wa-dropdown element")),
                    List.of(
                            new PluginEntry.MethodInfo("addItem", "J", "addItem(WaDropdownItem<?> item)", "Adds a dropdown item component"),
                            new PluginEntry.MethodInfo("addItem", "J", "addItem(String text)", "Adds a simple text dropdown item"),
                            new PluginEntry.MethodInfo("addItem", "J", "addItem(String text, String value)", "Adds an item with display text and value"),
                            new PluginEntry.MethodInfo("show", "J", "show()", "Programmatically opens the dropdown"),
                            new PluginEntry.MethodInfo("hide", "J", "hide()", "Programmatically closes the dropdown"),
                            new PluginEntry.MethodInfo("reposition", "J", "reposition()", "Repositions the dropdown panel relative to its trigger")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("wa-show", "Fires when the dropdown opens"),
                            new PluginEntry.EventInfo("wa-after-show", "Fires after open animation completes"),
                            new PluginEntry.EventInfo("wa-hide", "Fires when the dropdown begins closing"),
                            new PluginEntry.EventInfo("wa-after-hide", "Fires after close animation completes"),
                            new PluginEntry.EventInfo("wa-select", "Fires when a dropdown item is selected")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "Dropdown items and trigger content"),
                            new PluginEntry.SlotInfo("trigger", "The element that triggers the dropdown")
                    ),
                    List.of("BorderTokenCapable", "ShadowTokenCapable", "SpaceTokenCapable", "TransitionTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaDropdownItem", "Individual dropdown menu item with value and optional prefix/suffix",
                    "com.jwebmp.webawesome.components.button",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "The value returned when selected"),
                            new PluginEntry.PropertyInfo("variant", "DropdownItemVariant", "null", "Visual variant: default or danger"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the item"),
                            new PluginEntry.PropertyInfo("checked", "Boolean", "false", "Shows a check mark when true")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Form Controls ────────────────────────────────
            new PluginEntry.ComponentInfo("WaInput",
                    "Text input with label, hint, placeholder, clearable, password toggle, validation, and rich slot support. "
                    + "Supports all HTML input types including text, password, email, number, date, tel, url, and search.",
                    "com.jwebmp.webawesome.components.input",
                    List.of(
                            new PluginEntry.PropertyInfo("type", "String", "text", "HTML input type: text, password, email, number, date, tel, url, search"),
                            new PluginEntry.PropertyInfo("value", "String", "null", "The current input value"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text rendered above the input"),
                            new PluginEntry.PropertyInfo("hint", "String", "null", "Hint text displayed below the input"),
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Placeholder text when empty"),
                            new PluginEntry.PropertyInfo("size", "InputSize", "null", "Input size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("appearance", "InputAppearance", "null", "Visual style: Filled, Outlined"),
                            new PluginEntry.PropertyInfo("pill", "Boolean", "false", "Pill-shaped input with rounded corners"),
                            new PluginEntry.PropertyInfo("clearable", "Boolean", "false", "Shows a clear button when input has value"),
                            new PluginEntry.PropertyInfo("passwordToggle", "Boolean", "false", "Shows a toggle to reveal/hide password text"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the input"),
                            new PluginEntry.PropertyInfo("readonly", "Boolean", "false", "Makes the input read-only"),
                            new PluginEntry.PropertyInfo("required", "Boolean", "false", "Marks the input as required for form validation"),
                            new PluginEntry.PropertyInfo("pattern", "String", "null", "Regex pattern for validation"),
                            new PluginEntry.PropertyInfo("minlength", "Integer", "null", "Minimum character length"),
                            new PluginEntry.PropertyInfo("maxlength", "Integer", "null", "Maximum character length"),
                            new PluginEntry.PropertyInfo("min", "String", "null", "Minimum value (for number/date inputs)"),
                            new PluginEntry.PropertyInfo("max", "String", "null", "Maximum value (for number/date inputs)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Text Input", "A simple labeled text input.",
                                    "var input = new WaInput<>();\ninput.setLabel(\"Name\");\ninput.setPlaceholder(\"Enter your name\");", "java"),
                            new PluginEntry.ExampleSnippet("Password Input", "Password input with toggle visibility.",
                                    "var input = new WaInput<>();\ninput.setType(\"password\");\ninput.setLabel(\"Password\");\ninput.setPasswordToggle(true);", "java"),
                            new PluginEntry.ExampleSnippet("Clearable Search", "Search input with clear button and icon.",
                                    """
                                    var input = new WaInput<>();
                                    input.setType("search");
                                    input.setPlaceholder("Search...");
                                    input.setClearable(true);
                                    var icon = new WaIcon<>("magnifying-glass");
                                    icon.addAttribute("slot", "start");
                                    input.add(icon);""", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new WaInput<>()", "Creates an empty wa-input element")
                    ),
                    List.of(new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the input value via ngModel")),
                    List.of(
                            new PluginEntry.EventInfo("wa-input", "Fires on every keystroke or value change"),
                            new PluginEntry.EventInfo("wa-change", "Fires when the value changes and the input loses focus"),
                            new PluginEntry.EventInfo("wa-clear", "Fires when the clear button is clicked"),
                            new PluginEntry.EventInfo("wa-focus", "Fires when the input receives focus"),
                            new PluginEntry.EventInfo("wa-blur", "Fires when the input loses focus"),
                            new PluginEntry.EventInfo("wa-invalid", "Fires when form validation fails")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "Hidden default slot"),
                            new PluginEntry.SlotInfo("label", "Label content (alternative to label property)"),
                            new PluginEntry.SlotInfo("hint", "Hint content (alternative to hint property)"),
                            new PluginEntry.SlotInfo("start", "Content before the input (e.g. icon)"),
                            new PluginEntry.SlotInfo("end", "Content after the input (e.g. icon)")
                    ),
                    List.of("BorderTokenCapable", "SpaceTokenCapable", "FocusTokenCapable", "TypographyTokenCapable", "ComponentGroupTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaNumberInput", "Numeric input with min/max/step and stepper controls",
                    "com.jwebmp.webawesome.components.numberinput",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "Number", "null", "Current numeric value"),
                            new PluginEntry.PropertyInfo("min", "Number", "null", "Minimum allowed value"),
                            new PluginEntry.PropertyInfo("max", "Number", "null", "Maximum allowed value"),
                            new PluginEntry.PropertyInfo("step", "Number", "1", "Step increment for stepper buttons"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text"),
                            new PluginEntry.PropertyInfo("noSteppers", "Boolean", "false", "Hides the +/- stepper buttons")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Number Input", "Quantity picker with min/max.",
                            "var num = new WaNumberInput<>();\nnum.setLabel(\"Quantity\");\nnum.setMin(1);\nnum.setMax(99);\nnum.setStep(1);", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaTextArea",
                    "Multi-line text input with resize options, label, hint, rows, maxlength, and appearance customization.",
                    "com.jwebmp.webawesome.components.textarea",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "Current text value"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text above the textarea"),
                            new PluginEntry.PropertyInfo("hint", "String", "null", "Hint text below the textarea"),
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Placeholder text"),
                            new PluginEntry.PropertyInfo("rows", "Integer", "4", "Number of visible text rows"),
                            new PluginEntry.PropertyInfo("resize", "TextAreaResize", "vertical", "Resize behavior: none, vertical, horizontal, auto"),
                            new PluginEntry.PropertyInfo("maxlength", "Integer", "null", "Maximum character count"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the textarea"),
                            new PluginEntry.PropertyInfo("required", "Boolean", "false", "Makes the textarea required")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("TextArea", "Create a labeled textarea.",
                            "var ta = new WaTextArea<>();\nta.setLabel(\"Comments\");\nta.setPlaceholder(\"Enter your comments...\");\nta.setRows(6);\nta.setResize(TextAreaResize.Auto);", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSelect",
                    "Dropdown select control with label, hint, placeholder, multiple selection, clearable, and filterable options.",
                    "com.jwebmp.webawesome.components.select",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text above the select"),
                            new PluginEntry.PropertyInfo("hint", "String", "null", "Hint text below the select"),
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Placeholder when nothing selected"),
                            new PluginEntry.PropertyInfo("multiple", "Boolean", "false", "Enables multiple selection"),
                            new PluginEntry.PropertyInfo("clearable", "Boolean", "false", "Shows a clear button"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the select"),
                            new PluginEntry.PropertyInfo("pill", "Boolean", "false", "Pill-shaped select"),
                            new PluginEntry.PropertyInfo("placement", "SelectPlacement", "bottom", "Dropdown placement: top or bottom"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("maxOptionsVisible", "Integer", "3", "Max selected tags visible when multiple")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Select", "Create a select dropdown.",
                            "var sel = new WaSelect<>();\nsel.setLabel(\"Country\");\nsel.setPlaceholder(\"Choose...\");\nsel.add(new WaSelectOption<>(\"us\", \"United States\"));\nsel.add(new WaSelectOption<>(\"uk\", \"United Kingdom\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaSelect<>()", "Creates a wa-select element")),
                    List.of(new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the selected value via ngModel")),
                    List.of(
                            new PluginEntry.EventInfo("wa-input", "Fires when the selection changes"),
                            new PluginEntry.EventInfo("wa-change", "Fires when selection changes and control loses focus"),
                            new PluginEntry.EventInfo("wa-clear", "Fires when the clear button is clicked"),
                            new PluginEntry.EventInfo("wa-focus", "Fires on focus"),
                            new PluginEntry.EventInfo("wa-blur", "Fires on blur")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "Select option children"),
                            new PluginEntry.SlotInfo("label", "Label content"),
                            new PluginEntry.SlotInfo("hint", "Hint content"),
                            new PluginEntry.SlotInfo("start", "Content before the value"),
                            new PluginEntry.SlotInfo("end", "Content after the value")
                    ),
                    List.of("BorderTokenCapable", "SpaceTokenCapable", "FocusTokenCapable", "TypographyTokenCapable", "ComponentGroupTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaSelectOption", "Individual option within a select",
                    "com.jwebmp.webawesome.components.select",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "The option's value"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the option")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaCheckbox",
                    "Checkbox input with checked, indeterminate, and disabled states. Supports form integration and custom size.",
                    "com.jwebmp.webawesome.components.checkbox",
                    List.of(
                            new PluginEntry.PropertyInfo("checked", "Boolean", "false", "Whether the checkbox is checked"),
                            new PluginEntry.PropertyInfo("indeterminate", "Boolean", "false", "Sets the checkbox to indeterminate state"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the checkbox"),
                            new PluginEntry.PropertyInfo("required", "Boolean", "false", "Makes the checkbox required"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Checkbox size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text next to the checkbox")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Checkbox", "Basic checkbox.",
                            "var cb = new WaCheckbox<>();\ncb.setLabel(\"I agree to the terms\");\ncb.setRequired(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaCheckbox<>()", "Creates a wa-checkbox element")),
                    List.of(
                            new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the checked state via ngModel"),
                            new PluginEntry.MethodInfo("focus", "J", "focus()", "Programmatically focuses the checkbox"),
                            new PluginEntry.MethodInfo("blur", "J", "blur()", "Programmatically removes focus from the checkbox")
                    ),
                    List.of(new PluginEntry.EventInfo("wa-change", "Fires when the checked state changes")),
                    List.of(new PluginEntry.SlotInfo("default", "Label content")),
                    List.of("SpaceTokenCapable", "FocusTokenCapable", "ComponentGroupTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaRadio", "Radio button input",
                    "com.jwebmp.webawesome.components.radio",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "Radio value"),
                            new PluginEntry.PropertyInfo("checked", "Boolean", "false", "Whether selected"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the radio")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaRadioGroup",
                    "Radio button group with mutual exclusion, orientation, and label support.",
                    "com.jwebmp.webawesome.components.radio",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "The selected radio value"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Group label"),
                            new PluginEntry.PropertyInfo("orientation", "RadioOrientation", "vertical", "Layout: vertical or horizontal"),
                            new PluginEntry.PropertyInfo("appearance", "RadioAppearance", "null", "Appearance: default or button"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Size for button-style radios"),
                            new PluginEntry.PropertyInfo("required", "Boolean", "false", "Makes selection required")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Radio Group", "Create a radio button group.",
                            "var group = new WaRadioGroup<>();\ngroup.setLabel(\"Size\");\ngroup.add(new WaRadio<>(\"s\", \"Small\"));\ngroup.add(new WaRadio<>(\"m\", \"Medium\"));\ngroup.add(new WaRadio<>(\"l\", \"Large\"));", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSwitch",
                    "Toggle switch for on/off states with label, hint, size, and form integration.",
                    "com.jwebmp.webawesome.components.waswitch",
                    List.of(
                            new PluginEntry.PropertyInfo("checked", "Boolean", "false", "Whether the switch is on"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the switch"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text"),
                            new PluginEntry.PropertyInfo("hint", "String", "null", "Hint text"),
                            new PluginEntry.PropertyInfo("required", "Boolean", "false", "Makes it required")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Switch", "Toggle notifications.",
                            "var sw = new WaSwitch<>();\nsw.setLabel(\"Enable notifications\");\nsw.bind(\"notifications\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaSwitch<>()", "Creates a wa-switch element")),
                    List.of(
                            new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the checked state via ngModel"),
                            new PluginEntry.MethodInfo("onChange", "J", "onChange(String handlerScript)", "Registers a handler for the change event"),
                            new PluginEntry.MethodInfo("onInput", "J", "onInput(String handlerScript)", "Registers a handler for the input event")
                    ),
                    List.of(new PluginEntry.EventInfo("wa-change", "Fires when the switch state changes")),
                    List.of(new PluginEntry.SlotInfo("default", "Label content")),
                    List.of("SpaceTokenCapable", "FocusTokenCapable", "ComponentGroupTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaRange",
                    "Range slider input with min/max/step, label, hint, tooltip, and custom track styling.",
                    "com.jwebmp.webawesome.components.range",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "Number", "0", "Current slider value"),
                            new PluginEntry.PropertyInfo("min", "Number", "0", "Minimum value"),
                            new PluginEntry.PropertyInfo("max", "Number", "100", "Maximum value"),
                            new PluginEntry.PropertyInfo("step", "Number", "1", "Step increment"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text"),
                            new PluginEntry.PropertyInfo("hint", "String", "null", "Hint text"),
                            new PluginEntry.PropertyInfo("tooltip", "RangeTooltipPosition", "null", "Tooltip position: top, bottom, or none"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the slider")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Range Slider", "Create a volume slider.",
                            "var range = new WaRange<>();\nrange.setLabel(\"Volume\");\nrange.setMin(0);\nrange.setMax(100);\nrange.setValue(50);\nrange.setTooltip(RangeTooltipPosition.Top);", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaColorPicker", "Color picker with swatches, opacity, format options, and eyedropper support",
                    "com.jwebmp.webawesome.components.colorpicker",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "Current color value (hex, rgb, hsl)"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text"),
                            new PluginEntry.PropertyInfo("format", "String", "hex", "Display format: hex, rgb, hsl"),
                            new PluginEntry.PropertyInfo("opacity", "Boolean", "false", "Enables opacity slider"),
                            new PluginEntry.PropertyInfo("swatches", "String", "null", "Preset color swatches separated by semicolons"),
                            new PluginEntry.PropertyInfo("noFormatToggle", "Boolean", "false", "Hides the format toggle button"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the picker")
                    ),
                    List.of(),
                    List.of(), List.of(
                            new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the color value via ngModel"),
                            new PluginEntry.MethodInfo("focus", "J", "focus()", "Programmatically focuses the color picker"),
                            new PluginEntry.MethodInfo("blur", "J", "blur()", "Programmatically removes focus")
                    ), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaRating", "Star rating input with half-star, custom icon, and readonly support",
                    "com.jwebmp.webawesome.components.rating",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "Number", "0", "Current rating value"),
                            new PluginEntry.PropertyInfo("max", "Integer", "5", "Maximum number of stars"),
                            new PluginEntry.PropertyInfo("precision", "Number", "1", "Step precision (0.5 for half-stars)"),
                            new PluginEntry.PropertyInfo("readonly", "Boolean", "false", "Makes the rating read-only"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the rating"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Rating", "Half-star rating.",
                            "var rating = new WaRating<>();\nrating.setMax(5);\nrating.setPrecision(0.5);\nrating.setValue(3.5);", "java")),
                    List.of(), List.of(new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the rating value via ngModel")),
                    List.of(), List.of(), List.of()),

            // ── Data Display ─────────────────────────────────
            new PluginEntry.ComponentInfo("WaText", "Typography component with heading/body/caption styles and size variants",
                    "com.jwebmp.webawesome.components.text",
                    List.of(
                            new PluginEntry.PropertyInfo("waHeading", "String", "null", "Heading size: xs, s, m, l, xl, 2xl, 3xl"),
                            new PluginEntry.PropertyInfo("waBody", "String", "null", "Body text size: 2xs, xs, s, m, l"),
                            new PluginEntry.PropertyInfo("waCaption", "String", "null", "Caption text size: s, m, l"),
                            new PluginEntry.PropertyInfo("waFontWeight", "String", "null", "Font weight: light, regular, semibold, bold")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaTag",
                    "Compact tag/pill component for labeling, categorizing, or indicating status. Supports variant, appearance, size, pill, and removable.",
                    "com.jwebmp.webawesome.components.tag",
                    List.of(
                            new PluginEntry.PropertyInfo("variant", "Variant", "null", "Color variant"),
                            new PluginEntry.PropertyInfo("appearance", "TagAppearance", "null", "Visual style: accent, filled, outlined, etc."),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Tag size"),
                            new PluginEntry.PropertyInfo("pill", "Boolean", "false", "Renders pill-shaped"),
                            new PluginEntry.PropertyInfo("removable", "Boolean", "false", "Shows a remove button")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Tag", "Create a removable tag.",
                            "var tag = new WaTag<>();\ntag.setVariant(Variant.Brand);\ntag.setPill(true);\ntag.setRemovable(true);\ntag.setText(\"Angular\");", "java")),
                    List.of(), List.of(new PluginEntry.MethodInfo("onRemove", "J", "onRemove(String handlerScript)", "Registers a handler for the remove event")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaBadge",
                    "Badge for small counts, labels, or status indicators. Supports variant, appearance, pill, and pulse animation.",
                    "com.jwebmp.webawesome.components.badge",
                    List.of(
                            new PluginEntry.PropertyInfo("variant", "Variant", "null", "Color variant"),
                            new PluginEntry.PropertyInfo("appearance", "Appearance", "null", "Visual style: accent, filled, outlined"),
                            new PluginEntry.PropertyInfo("pill", "Boolean", "false", "Pill-shaped badge"),
                            new PluginEntry.PropertyInfo("pulse", "Boolean", "false", "Adds a pulsing animation")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Badge", "Pulsing notification badge.",
                            "var badge = new WaBadge<>();\nbadge.setVariant(Variant.Danger);\nbadge.setPill(true);\nbadge.setPulse(true);\nbadge.setText(\"3\");", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaIcon",
                    "Icon component supporting Font Awesome families (classic, brands, sharp, sharp-duotone), "
                    + "library registration, SVG sources, duotone coloring, and accessibility labels.",
                    "com.jwebmp.webawesome.components.icon",
                    List.of(
                            new PluginEntry.PropertyInfo("name", "String", "null", "Icon name (e.g. 'star', 'gear', 'user')"),
                            new PluginEntry.PropertyInfo("family", "IconFamily/String", "null", "Font Awesome family: classic, brands, sharp, sharp-duotone"),
                            new PluginEntry.PropertyInfo("variant", "IconVariant/String", "null", "Variant within family: regular, solid, light, thin, duotone"),
                            new PluginEntry.PropertyInfo("library", "String", "null", "Name of a registered icon library"),
                            new PluginEntry.PropertyInfo("src", "String", "null", "URL to an SVG for custom icons"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label for screen readers"),
                            new PluginEntry.PropertyInfo("withFixedWidth", "Boolean", "false", "Forces fixed 1em width"),
                            new PluginEntry.PropertyInfo("primaryColor", "String", "null", "Duotone primary layer color"),
                            new PluginEntry.PropertyInfo("secondaryColor", "String", "null", "Duotone secondary layer color")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Icon", "Render a star icon.",
                                    "var icon = new WaIcon<>(\"star\");", "java"),
                            new PluginEntry.ExampleSnippet("Sharp Duotone", "Use sharp-duotone family.",
                                    "var icon = new WaIcon<>(\"house\");\nicon.setFamily(\"sharp-duotone\");", "java"),
                            new PluginEntry.ExampleSnippet("Custom Kit Icon", "Use a Font Awesome Kit icon.",
                                    "var icon = new WaIcon<>();\nicon.addClass(\"fak\");\nicon.addClass(\"fa-my-custom-icon\");", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new WaIcon<>()", "Creates an empty wa-icon element"),
                            new PluginEntry.ConstructorInfo("new WaIcon<>(String name)", "Creates an icon with the given name")
                    ),
                    List.of(),
                    List.of(),
                    List.of(new PluginEntry.SlotInfo("default", "Icon content or custom SVG")),
                    List.of()
            ),
            new PluginEntry.ComponentInfo("WaAvatar", "User avatar with image, initials, or icon fallback",
                    "com.jwebmp.webawesome.components.avatar",
                    List.of(
                            new PluginEntry.PropertyInfo("image", "String", "null", "URL of the avatar image"),
                            new PluginEntry.PropertyInfo("initials", "String", "null", "Initials shown when no image"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label"),
                            new PluginEntry.PropertyInfo("shape", "Shapes", "circle", "Shape: circle, square, rounded"),
                            new PluginEntry.PropertyInfo("loading", "String", "eager", "Image loading strategy: eager or lazy")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaAvatarGroup", "Group of overlapping avatars",
                    "com.jwebmp.webawesome.components.avatar",
                    List.of(new PluginEntry.PropertyInfo("label", "String", "null", "Accessible group label")),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaDivider", "Horizontal or vertical divider line",
                    "com.jwebmp.webawesome.components.divider",
                    List.of(new PluginEntry.PropertyInfo("vertical", "Boolean", "false", "Renders a vertical divider")),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaQRCode", "QR code generator with configurable size, error correction, and fill/background colors",
                    "com.jwebmp.webawesome.components.qrcode",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "The data to encode"),
                            new PluginEntry.PropertyInfo("size", "Integer", "128", "Size in pixels"),
                            new PluginEntry.PropertyInfo("errorCorrection", "String", "M", "Error correction: L, M, Q, H"),
                            new PluginEntry.PropertyInfo("fill", "String", "black", "Fill color of the QR modules"),
                            new PluginEntry.PropertyInfo("background", "String", "white", "Background color")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("QR Code", "Generate a QR code.",
                            "var qr = new WaQRCode<>();\nqr.setValue(\"https://jwebmp.com\");\nqr.setSize(200);", "java")),
                    List.of(), List.of(new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the QR code value via ngModel")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaMarkdown", "Markdown renderer with syntax highlighting and optional clipboard support",
                    "com.jwebmp.webawesome.components.markdown",
                    List.of(new PluginEntry.PropertyInfo("clipboard", "Boolean", "false", "Adds a copy button to code blocks")),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Media ────────────────────────────────────────
            new PluginEntry.ComponentInfo("WaCarousel", "Image/content carousel with navigation and autoplay",
                    "com.jwebmp.webawesome.components.carousel",
                    List.of(), List.of(),
                    List.of(), List.of(
                            new PluginEntry.MethodInfo("next", "J", "next()", "Navigates to the next slide"),
                            new PluginEntry.MethodInfo("previous", "J", "previous()", "Navigates to the previous slide"),
                            new PluginEntry.MethodInfo("goToSlide", "J", "goToSlide(int index)", "Navigates to a specific slide by index")
                    ), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaCarouselItem", "Individual slide within a carousel", "com.jwebmp.webawesome.components.carousel",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaAnimatedImage", "Animated image (GIF/APNG/WebP) with play/pause controls", "com.jwebmp.webawesome.components.animatedimage",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaImageCompare", "Before/after image comparison slider", "com.jwebmp.webawesome.components.imagecompare",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaComparison", "Side-by-side comparison component", "com.jwebmp.webawesome.components.comparison",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaZoomableFrame", "Zoomable/pannable frame for images and content", "com.jwebmp.webawesome.components.zoom",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Feedback & Overlays ──────────────────────────
            new PluginEntry.ComponentInfo("WaDialog",
                    "Modal dialog with header, body, and footer slots. Supports open/close animation, "
                    + "light-dismiss, no-close-button, and overlay customization.",
                    "com.jwebmp.webawesome.components.dialog",
                    List.of(
                            new PluginEntry.PropertyInfo("open", "Boolean", "false", "Whether the dialog is open"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label / title for the dialog"),
                            new PluginEntry.PropertyInfo("noCloseButton", "Boolean", "false", "Hides the close button in the header"),
                            new PluginEntry.PropertyInfo("lightDismiss", "Boolean", "false", "Allows closing by clicking the overlay backdrop")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Dialog", "Open a simple dialog.",
                                    """
                                    var dialog = new WaDialog<>();
                                    dialog.setLabel("Confirm");
                                    dialog.withHeader("Are you sure?");
                                    dialog.withBody("This action cannot be undone.");
                                    dialog.setOpen(true);""", "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new WaDialog<>()", "Creates a wa-dialog element")),
                    List.of(
                            new PluginEntry.MethodInfo("show", "J", "show()", "Programmatically opens the dialog"),
                            new PluginEntry.MethodInfo("hide", "J", "hide()", "Programmatically closes the dialog"),
                            new PluginEntry.MethodInfo("withHeader", "J", "withHeader(DivSimple<?> header)", "Adds a header component to the dialog"),
                            new PluginEntry.MethodInfo("withFooter", "J", "withFooter(DivSimple<?> footer)", "Adds a footer component to the dialog"),
                            new PluginEntry.MethodInfo("withHeaderActionIcon", "WaButton<?>", "withHeaderActionIcon(String iconName)", "Adds an icon button to the header actions"),
                            new PluginEntry.MethodInfo("withOpener", "J", "withOpener(IComponentHierarchyBase<?,?> component)", "Designates an element that opens this dialog on click"),
                            new PluginEntry.MethodInfo("withInitialFocusOn", "J", "withInitialFocusOn(IComponentHierarchyBase<?,?> component)", "Sets which element receives focus when the dialog opens")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("wa-show", "Fires when the dialog begins to open"),
                            new PluginEntry.EventInfo("wa-after-show", "Fires after the dialog open animation completes"),
                            new PluginEntry.EventInfo("wa-hide", "Fires when the dialog begins to close"),
                            new PluginEntry.EventInfo("wa-after-hide", "Fires after the dialog close animation completes"),
                            new PluginEntry.EventInfo("wa-request-close", "Fires when the user attempts to close; cancelable")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "The dialog body content"),
                            new PluginEntry.SlotInfo("header", "The dialog header / title area"),
                            new PluginEntry.SlotInfo("footer", "The dialog footer (action buttons)")
                    ),
                    List.of()
            ),
            new PluginEntry.ComponentInfo("WaDrawer",
                    "Slide-out drawer panel with placement options, label, and light-dismiss support.",
                    "com.jwebmp.webawesome.components.drawer",
                    List.of(
                            new PluginEntry.PropertyInfo("open", "Boolean", "false", "Whether the drawer is open"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label / header text"),
                            new PluginEntry.PropertyInfo("placement", "Placement", "end", "Side: top, end, bottom, start"),
                            new PluginEntry.PropertyInfo("withoutHeader", "Boolean", "false", "Hides the header and close button"),
                            new PluginEntry.PropertyInfo("lightDismiss", "Boolean", "false", "Close by clicking outside")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Drawer", "Open a side drawer.",
                            "var drawer = new WaDrawer<>();\ndrawer.setLabel(\"Settings\");\ndrawer.setPlacement(Placement.End);\ndrawer.setOpen(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaDrawer<>()", "Creates a wa-drawer element")),
                    List.of(
                            new PluginEntry.MethodInfo("show", "J", "show()", "Programmatically opens the drawer"),
                            new PluginEntry.MethodInfo("hide", "J", "hide()", "Programmatically closes the drawer"),
                            new PluginEntry.MethodInfo("withHeader", "J", "withHeader(DivSimple<?> header)", "Adds a header component to the drawer"),
                            new PluginEntry.MethodInfo("withFooter", "J", "withFooter(DivSimple<?> footer)", "Adds a footer component to the drawer"),
                            new PluginEntry.MethodInfo("withHeaderActionIcon", "WaButton<?>", "withHeaderActionIcon(String iconName)", "Adds an icon button to the header actions"),
                            new PluginEntry.MethodInfo("withInitialFocusOn", "J", "withInitialFocusOn(IComponentHierarchyBase<?,?> component)", "Sets which element receives focus when the drawer opens")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("wa-show", "Fires when opening"),
                            new PluginEntry.EventInfo("wa-after-show", "Fires after open animation"),
                            new PluginEntry.EventInfo("wa-hide", "Fires when closing"),
                            new PluginEntry.EventInfo("wa-after-hide", "Fires after close animation"),
                            new PluginEntry.EventInfo("wa-request-close", "Fires when attempting to close; cancelable")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "Drawer body content"),
                            new PluginEntry.SlotInfo("header", "Header area content"),
                            new PluginEntry.SlotInfo("footer", "Footer area content")
                    ),
                    List.of("BorderTokenCapable", "ShadowTokenCapable", "SpaceTokenCapable", "TransitionTokenCapable")
            ),
            new PluginEntry.ComponentInfo("WaTooltip",
                    "Displays contextual information when hovering, focusing, or programmatically toggling on a target element.",
                    "com.jwebmp.webawesome.components.tooltip",
                    List.of(
                            new PluginEntry.PropertyInfo("forId", "String", "null", "ID of the target element"),
                            new PluginEntry.PropertyInfo("placement", "TooltipPlacement", "top", "Preferred placement: top, bottom, left, right"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the tooltip"),
                            new PluginEntry.PropertyInfo("distance", "Integer", "8", "Pixel distance from target"),
                            new PluginEntry.PropertyInfo("open", "Boolean", "false", "Programmatically show/hide"),
                            new PluginEntry.PropertyInfo("maxWidth", "String", "null", "Maximum width of the tooltip")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Tooltip", "Add a tooltip to a button.",
                            "var btn = new WaButton<>(\"Hover me\", Variant.Brand);\nbtn.setID(\"my-btn\");\nvar tip = new WaTooltip<>();\ntip.setForId(\"my-btn\");\ntip.setText(\"Click to save\");", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaPopover",
                    "Floating panel with rich interactive content (links, buttons, forms), "
                    + "anchored to an element. Only one popover can be open at a time.",
                    "com.jwebmp.webawesome.components.popover",
                    List.of(
                            new PluginEntry.PropertyInfo("forElement", "IComponentHierarchyBase", "null", "Anchor element for the popover"),
                            new PluginEntry.PropertyInfo("placement", "WaPopoverPlacements", "bottom", "Preferred placement"),
                            new PluginEntry.PropertyInfo("open", "Boolean", "false", "Whether the popover is open"),
                            new PluginEntry.PropertyInfo("distance", "Integer", "null", "Pixel distance from anchor"),
                            new PluginEntry.PropertyInfo("maxWidth", "String", "null", "Maximum width")
                    ),
                    List.of(),
                    List.of(), List.of(
                            new PluginEntry.MethodInfo("show", "J", "show()", "Programmatically opens the popover"),
                            new PluginEntry.MethodInfo("hide", "J", "hide()", "Programmatically closes the popover"),
                            new PluginEntry.MethodInfo("onShow", "J", "onShow(String handlerScript)", "Registers a handler when the popover opens"),
                            new PluginEntry.MethodInfo("onHide", "J", "onHide(String handlerScript)", "Registers a handler when the popover closes"),
                            new PluginEntry.MethodInfo("setPopoverBorderColor", "J", "setPopoverBorderColor(Variant variant)", "Sets popover border color by variant"),
                            new PluginEntry.MethodInfo("setPopoverBorderWidth", "J", "setPopoverBorderWidth(WaBorderToken token)", "Sets popover border width using a design token"),
                            new PluginEntry.MethodInfo("setPopoverBorderRadius", "J", "setPopoverBorderRadius(WaBorderToken token)", "Sets popover corner radius using a design token"),
                            new PluginEntry.MethodInfo("setArrowColor", "J", "setArrowColor(Variant variant)", "Sets the arrow color by variant")
                    ), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaPopup", "Low-level popup with anchor positioning, auto-size, and sync options",
                    "com.jwebmp.webawesome.components.popup",
                    List.of(
                            new PluginEntry.PropertyInfo("anchor", "String", "null", "ID of the anchor element"),
                            new PluginEntry.PropertyInfo("placement", "WaPopupPlacements", "bottom", "Preferred placement"),
                            new PluginEntry.PropertyInfo("active", "Boolean", "false", "Whether the popup is active"),
                            new PluginEntry.PropertyInfo("autoSize", "WaPopupAutoSize", "null", "Auto-size behavior: width, height, both"),
                            new PluginEntry.PropertyInfo("sync", "WaPopupSync", "null", "Sync dimensions with anchor: width, height, both"),
                            new PluginEntry.PropertyInfo("flip", "Boolean", "false", "Flip to opposite side when not enough space")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaToastContainer", "Toast notification container with stacking and placement",
                    "com.jwebmp.webawesomepro.components.toast",
                    List.of(new PluginEntry.PropertyInfo("placement", "String", "top-end", "Stack placement: top-start, top-end, bottom-start, bottom-end")),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaToastItem", "Individual toast notification with variant, duration, and closable",
                    "com.jwebmp.webawesomepro.components.toast",
                    List.of(
                            new PluginEntry.PropertyInfo("variant", "Variant", "null", "Color variant"),
                            new PluginEntry.PropertyInfo("duration", "Integer", "5000", "Auto-hide duration in ms (0 = infinite)"),
                            new PluginEntry.PropertyInfo("closable", "Boolean", "true", "Shows a close button")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaToastDataService", "Angular data service for programmatic toast creation and management",
                    "com.jwebmp.webawesomepro.components.toast",
                    List.of(),
                    List.of(new PluginEntry.ExampleSnippet("Programmatic Toast", "Show a success toast.",
                            "// In your component, inject the toast container\n// and use WaToastItem to add notifications programmatically", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Progress & Loading ───────────────────────────
            new PluginEntry.ComponentInfo("WaProgressBar",
                    "Linear progress bar with determinate/indeterminate modes, label, custom indicator color, and track height.",
                    "com.jwebmp.webawesome.components.progressbar",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "Integer", "0", "Current progress percentage (0-100)"),
                            new PluginEntry.PropertyInfo("indeterminate", "Boolean", "false", "Shows indeterminate loading animation"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label for screen readers"),
                            new PluginEntry.PropertyInfo("indicatorColor", "String", "null", "CSS color for the progress indicator"),
                            new PluginEntry.PropertyInfo("trackHeight", "String", "null", "Height of the progress track")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Progress Bar", "Show 60% progress.",
                                    "var bar = new WaProgressBar<>();\nbar.setValue(60);\nbar.setLabel(\"Uploading...\");", "java"),
                            new PluginEntry.ExampleSnippet("Indeterminate", "Show a loading bar.",
                                    "var bar = new WaProgressBar<>();\nbar.setIndeterminate(true);", "java")
                    ),
                    List.of(), List.of(new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the progress value via ngModel")),
                    List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaProgressRing",
                    "Circular progress indicator with determinate/indeterminate modes.",
                    "com.jwebmp.webawesome.components.progressring",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "Integer", "0", "Current progress percentage (0-100)"),
                            new PluginEntry.PropertyInfo("indeterminate", "Boolean", "false", "Shows indeterminate animation"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Accessible label"),
                            new PluginEntry.PropertyInfo("indicatorColor", "String", "null", "Color of the ring indicator"),
                            new PluginEntry.PropertyInfo("trackWidth", "String", "null", "Width of the ring track")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSpinner", "Loading spinner with size variants",
                    "com.jwebmp.webawesome.components.spinner",
                    List.of(new PluginEntry.PropertyInfo("size", "Size", "null", "Spinner size: Small, Medium, Large")),
                    List.of(new PluginEntry.ExampleSnippet("Spinner", "Show a loading spinner.",
                            "var spinner = new WaSpinner<>();\nspinner.setSize(Size.Large);", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSkeleton", "Skeleton loading placeholder with shimmer animation effect",
                    "com.jwebmp.webawesome.components.skeleton",
                    List.of(
                            new PluginEntry.PropertyInfo("effect", "SkeletonEffect", "null", "Animation: sheen, pulse, none"),
                            new PluginEntry.PropertyInfo("borderRadius", "String", "null", "Corner radius")
                    ),
                    List.of(),
                    List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Formatting & Utilities ───────────────────────
            new PluginEntry.ComponentInfo("WaFormatBytes", "Formats byte values into human-readable sizes", "com.jwebmp.webawesome.components.formatbytes",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaFormatDate", "Locale-aware date/time formatter", "com.jwebmp.webawesome.components.formatdate",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaFormatNumber", "Locale-aware number formatter with currency/percent/unit", "com.jwebmp.webawesome.components.formatnumber",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaRelativeTime", "Relative time display (e.g. '3 hours ago')", "com.jwebmp.webawesome.components.relativetime",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaInclude", "Include external HTML content via URL", "com.jwebmp.webawesome.components.include",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaAnimation", "CSS animation wrapper with play/pause/cancel controls", "com.jwebmp.webawesome.components.animation",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),

            // ── Observers ────────────────────────────────────
            new PluginEntry.ComponentInfo("WaIntersectionObserver", "Detects when elements enter/exit the viewport", "com.jwebmp.webawesome.components.observer",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaMutationObserver", "Watches for DOM mutations on child elements", "com.jwebmp.webawesome.components.observer",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaResizeObserver", "Detects element size changes", "com.jwebmp.webawesome.components.observer",
                    List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of())
    );

    public WebAwesomeFrameworkPage()
    {
        super(PluginCatalog.getById("web-awesome").orElseThrow());
    }

    @Override
    protected String frameworkId()
    {
        return "web-awesome";
    }

    @Override
    protected List<PluginEntry.ComponentInfo> frameworkComponents()
    {
        return COMPONENTS;
    }
}


