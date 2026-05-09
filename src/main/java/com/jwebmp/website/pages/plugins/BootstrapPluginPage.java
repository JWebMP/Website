package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-bootstrap")
@NgRoutable(path = "plugins/bootstrap")
public class BootstrapPluginPage extends PluginDetailPage<BootstrapPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("BSAccordion", "Collapsible content panels with show/hide transitions using ngbAccordion", "com.jwebmp.plugins.bootstrap.accordion",
                    List.of(
                            new PluginEntry.PropertyInfo("closeOthers", "boolean", "false", "When true, only one panel can be open at a time"),
                            new PluginEntry.PropertyInfo("destroyOnHide", "boolean", "false", "When true, panel content is destroyed when collapsed")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Basic Accordion", "Create a collapsible accordion with two panels",
                            "BSAccordion&lt;?&gt; accordion = new BSAccordion&lt;&gt;();\naccordion.setCloseOthers(true);\naccordion.addPanel(\"panel1\", \"Header\", new Paragraph&lt;&gt;().setText(\"Content\"), true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSAccordion()", "Creates an accordion and adds the ngbAccordion attribute")),
                    List.of(
                            new PluginEntry.MethodInfo("addItem", "BSAccordion", "addItem(BSAccordionItem item)", "Adds an accordion item panel"),
                            new PluginEntry.MethodInfo("setCloseOthers", "BSAccordion", "setCloseOthers(boolean closeOthers)", "Sets whether only one panel can be open"),
                            new PluginEntry.MethodInfo("setDestroyOnHide", "BSAccordion", "setDestroyOnHide(boolean destroyOnHide)", "Sets whether content is destroyed when hidden"),
                            new PluginEntry.MethodInfo("addPanel", "BSAccordion", "addPanel(String panelId, String header, IComponentHierarchyBase content, boolean active)", "Adds a panel with id, header, content, and active state")
                    ),
                    List.of(), List.of(),
                    List.of("IBSAccordion", "INgComponent")),

            new PluginEntry.ComponentInfo("BSAlert", "Dismissible alert messages with contextual styles and close events", "com.jwebmp.plugins.bootstrap.alerts",
                    List.of(
                            new PluginEntry.PropertyInfo("dismissible", "boolean", "false", "Whether the alert can be dismissed"),
                            new PluginEntry.PropertyInfo("type", "BSColourTypes", "Info", "The contextual colour type of the alert")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Dismissible Alert", "Create a warning alert that can be closed",
                            "BSAlert&lt;?&gt; alert = new BSAlert&lt;&gt;(\"Operation completed!\");\nalert.setDismissible(true);\nalert.setType(BSColourTypes.Warning);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("BSAlert()", "Creates an empty ngb-alert element"),
                            new PluginEntry.ConstructorInfo("BSAlert(String text)", "Creates an alert with display text"),
                            new PluginEntry.ConstructorInfo("BSAlert(IComponentHierarchyBase&lt;?&gt; content)", "Creates an alert with a child component")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setDismissible", "BSAlert", "setDismissible(boolean dismissible)", "Enables or disables the close button"),
                            new PluginEntry.MethodInfo("setType", "BSAlert", "setType(BSColourTypes type)", "Sets the contextual colour type"),
                            new PluginEntry.MethodInfo("bind", "BSAlert", "bind(String variableName)", "Binds the alert to an Angular variable")
                    ),
                    List.of(new PluginEntry.EventInfo("close", "Fired when the alert is dismissed")),
                    List.of(),
                    List.of("IBSAlert", "INgComponent")),

            new PluginEntry.ComponentInfo("BSBadge", "Inline badge/pill labels with contextual colour variants", "com.jwebmp.plugins.bootstrap.badge",
                    List.of(
                            new PluginEntry.PropertyInfo("asPill", "boolean", "false", "Renders the badge with rounded-pill class"),
                            new PluginEntry.PropertyInfo("asLink", "boolean", "false", "Renders the badge as a clickable link")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Coloured Badge", "Create a danger-coloured pill badge",
                            "BSBadge&lt;?&gt; badge = new BSBadge&lt;&gt;(\"Alert\", true, BSBadgeOptions.Danger);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("BSBadge(boolean asPill, BSBadgeOptions... options)", "Creates a badge with pill style and colour options"),
                            new PluginEntry.ConstructorInfo("BSBadge(String text, boolean asPill, BSBadgeOptions... options)", "Creates a badge with text, pill style, and colour options")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setPrimary", "BSBadge", "setPrimary(boolean primary)", "Applies the primary colour"),
                            new PluginEntry.MethodInfo("setSecondary", "BSBadge", "setSecondary(boolean secondary)", "Applies the secondary colour"),
                            new PluginEntry.MethodInfo("setSuccess", "BSBadge", "setSuccess(boolean success)", "Applies the success colour"),
                            new PluginEntry.MethodInfo("setDanger", "BSBadge", "setDanger(boolean danger)", "Applies the danger colour"),
                            new PluginEntry.MethodInfo("setWarning", "BSBadge", "setWarning(boolean warning)", "Applies the warning colour"),
                            new PluginEntry.MethodInfo("setInfo", "BSBadge", "setInfo(boolean info)", "Applies the info colour"),
                            new PluginEntry.MethodInfo("setAsLink", "BSBadge", "setAsLink(boolean asLink)", "Renders as clickable link badge")
                    ),
                    List.of(), List.of(),
                    List.of("IBSBadge")),

            new PluginEntry.ComponentInfo("BSBreadcrumbContainer", "Breadcrumb navigation trail container", "com.jwebmp.plugins.bootstrap.breadcrumbs",
                    List.of(),
                    List.of(new PluginEntry.ExampleSnippet("Breadcrumb Trail", "Create a breadcrumb navigation",
                            "BSBreadcrumbContainer&lt;?&gt; bc = new BSBreadcrumbContainer&lt;&gt;();\nbc.add(new BSBreadcrumbItem&lt;&gt;(\"Home\", \"/\"));\nbc.add(new BSBreadcrumbItem&lt;&gt;(\"Products\", \"/products\"));\nbc.add(new BSBreadcrumbItem&lt;&gt;(\"Detail\").setActive(true));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSBreadcrumbContainer()", "Creates a nav element with breadcrumb styling")),
                    List.of(new PluginEntry.MethodInfo("add", "BSBreadcrumbContainer", "add(BSBreadcrumbItem item)", "Adds a breadcrumb item to the trail")),
                    List.of(), List.of(),
                    List.of("IBSBreadcrumbs")),

            new PluginEntry.ComponentInfo("BSButton", "Enhanced buttons with size, colour, outline, toggle, and pressed states", "com.jwebmp.plugins.bootstrap.buttons",
                    List.of(
                            new PluginEntry.PropertyInfo("size", "BSButtonSizeOptions", "null", "Button size: Lg, Sm, or default"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the button is disabled"),
                            new PluginEntry.PropertyInfo("pressed", "boolean", "false", "Whether the button appears pressed/active"),
                            new PluginEntry.PropertyInfo("toggle", "boolean", "false", "Whether the button is a toggle button")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Outlined Button", "Create an outline-primary button",
                            "BSButton&lt;?&gt; btn = new BSButton&lt;&gt;(\"Submit\");\nbtn.setPrimaryOutline(true);\nbtn.setSize(BSButtonSizeOptions.Lg);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("BSButton()", "Creates an empty button"),
                            new PluginEntry.ConstructorInfo("BSButton(String text)", "Creates a button with display text")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setPrimary", "BSButton", "setPrimary(boolean primary)", "Applies btn-primary class"),
                            new PluginEntry.MethodInfo("setSecondary", "BSButton", "setSecondary(boolean secondary)", "Applies btn-secondary class"),
                            new PluginEntry.MethodInfo("setSuccess", "BSButton", "setSuccess(boolean success)", "Applies btn-success class"),
                            new PluginEntry.MethodInfo("setDanger", "BSButton", "setDanger(boolean danger)", "Applies btn-danger class"),
                            new PluginEntry.MethodInfo("setWarning", "BSButton", "setWarning(boolean warning)", "Applies btn-warning class"),
                            new PluginEntry.MethodInfo("setInfo", "BSButton", "setInfo(boolean info)", "Applies btn-info class"),
                            new PluginEntry.MethodInfo("setLink", "BSButton", "setLink(boolean link)", "Applies btn-link class"),
                            new PluginEntry.MethodInfo("setPrimaryOutline", "BSButton", "setPrimaryOutline(boolean outline)", "Applies btn-outline-primary class"),
                            new PluginEntry.MethodInfo("setSecondaryOutline", "BSButton", "setSecondaryOutline(boolean outline)", "Applies btn-outline-secondary class"),
                            new PluginEntry.MethodInfo("setSize", "BSButton", "setSize(BSButtonSizeOptions size)", "Sets the button size"),
                            new PluginEntry.MethodInfo("setDisabled", "BSButton", "setDisabled(boolean disabled)", "Disables or enables the button"),
                            new PluginEntry.MethodInfo("setPressed", "BSButton", "setPressed(boolean pressed)", "Sets the pressed/active state"),
                            new PluginEntry.MethodInfo("setToggle", "BSButton", "setToggle(boolean toggle)", "Enables toggle behaviour")
                    ),
                    List.of(), List.of(),
                    List.of("IBSButton", "BSFormChildren")),

            new PluginEntry.ComponentInfo("BSButtonGroup", "Button groups, toolbars, and segmented controls", "com.jwebmp.plugins.bootstrap.buttons.groups",
                    List.of(
                            new PluginEntry.PropertyInfo("vertical", "boolean", "false", "Renders the group vertically"),
                            new PluginEntry.PropertyInfo("size", "BSButtonSizeOptions", "null", "Size applied to all buttons in the group")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Button Group", "Create a horizontal button group",
                            "BSButtonGroup&lt;?&gt; group = new BSButtonGroup&lt;&gt;();\ngroup.add(new BSButton&lt;&gt;(\"Left\").setPrimary(true));\ngroup.add(new BSButton&lt;&gt;(\"Right\").setPrimary(true));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSButtonGroup()", "Creates a horizontal button group")),
                    List.of(
                            new PluginEntry.MethodInfo("add", "BSButtonGroup", "add(BSButton button)", "Adds a button to the group"),
                            new PluginEntry.MethodInfo("setVertical", "BSButtonGroup", "setVertical(boolean vertical)", "Switches between horizontal and vertical layout"),
                            new PluginEntry.MethodInfo("setSize", "BSButtonGroup", "setSize(BSButtonSizeOptions size)", "Sets the size for all buttons in the group")
                    ),
                    List.of(), List.of(),
                    List.of("IBSButtonGroup")),

            new PluginEntry.ComponentInfo("BSCheckBox", "Styled checkbox input with Bootstrap form-check classes", "com.jwebmp.plugins.bootstrap.buttons.checkbox",
                    List.of(
                            new PluginEntry.PropertyInfo("checked", "boolean", "false", "Whether the checkbox is checked"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "The label text for the checkbox"),
                            new PluginEntry.PropertyInfo("inline", "boolean", "false", "Renders checkboxes inline")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Inline Checkbox", "Create an inline checkbox",
                            "BSCheckBox&lt;?&gt; cb = new BSCheckBox&lt;&gt;();\ncb.setLabel(\"Accept Terms\");\ncb.setInline(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSCheckBox()", "Creates a Bootstrap styled checkbox")),
                    List.of(
                            new PluginEntry.MethodInfo("setChecked", "BSCheckBox", "setChecked(boolean checked)", "Sets the checked state"),
                            new PluginEntry.MethodInfo("setLabel", "BSCheckBox", "setLabel(String label)", "Sets the label text"),
                            new PluginEntry.MethodInfo("setInline", "BSCheckBox", "setInline(boolean inline)", "Renders the checkbox inline")
                    ),
                    List.of(new PluginEntry.EventInfo("change", "Fired when the checkbox state changes")),
                    List.of(),
                    List.of("BSFormChildren")),

            new PluginEntry.ComponentInfo("BSRadioButton", "Styled radio button input with Bootstrap form-check classes", "com.jwebmp.plugins.bootstrap.buttons.radio",
                    List.of(
                            new PluginEntry.PropertyInfo("checked", "boolean", "false", "Whether the radio button is selected"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "The label text"),
                            new PluginEntry.PropertyInfo("name", "String", "null", "Radio group name"),
                            new PluginEntry.PropertyInfo("inline", "boolean", "false", "Renders radio buttons inline")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Radio Group", "Create a group of radio buttons",
                            "BSRadioButton&lt;?&gt; r1 = new BSRadioButton&lt;&gt;();\nr1.setLabel(\"Option A\").setName(\"choice\");\nBSRadioButton&lt;?&gt; r2 = new BSRadioButton&lt;&gt;();\nr2.setLabel(\"Option B\").setName(\"choice\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSRadioButton()", "Creates a Bootstrap styled radio button")),
                    List.of(
                            new PluginEntry.MethodInfo("setChecked", "BSRadioButton", "setChecked(boolean checked)", "Sets the selected state"),
                            new PluginEntry.MethodInfo("setLabel", "BSRadioButton", "setLabel(String label)", "Sets the label text"),
                            new PluginEntry.MethodInfo("setName", "BSRadioButton", "setName(String name)", "Sets the radio group name"),
                            new PluginEntry.MethodInfo("setInline", "BSRadioButton", "setInline(boolean inline)", "Renders the radio inline")
                    ),
                    List.of(new PluginEntry.EventInfo("change", "Fired when the radio selection changes")),
                    List.of(),
                    List.of("BSFormChildren")),

            new PluginEntry.ComponentInfo("BSSwitch", "Toggle switch styled as a Bootstrap switch control", "com.jwebmp.plugins.bootstrap.buttons.switches",
                    List.of(
                            new PluginEntry.PropertyInfo("checked", "boolean", "false", "Whether the switch is on"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "The label text"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the switch is disabled")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Toggle Switch", "Create a labelled switch",
                            "BSSwitch&lt;?&gt; sw = new BSSwitch&lt;&gt;();\nsw.setLabel(\"Enable notifications\");\nsw.setChecked(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSSwitch()", "Creates a Bootstrap switch control")),
                    List.of(
                            new PluginEntry.MethodInfo("setChecked", "BSSwitch", "setChecked(boolean checked)", "Sets the on/off state"),
                            new PluginEntry.MethodInfo("setLabel", "BSSwitch", "setLabel(String label)", "Sets the label text"),
                            new PluginEntry.MethodInfo("setDisabled", "BSSwitch", "setDisabled(boolean disabled)", "Disables the switch")
                    ),
                    List.of(new PluginEntry.EventInfo("change", "Fired when the switch is toggled")),
                    List.of(),
                    List.of("BSFormChildren")),

            new PluginEntry.ComponentInfo("BSCard", "Flexible content container with header, body, footer, images, and themed variants", "com.jwebmp.plugins.bootstrap.cards",
                    List.of(
                            new PluginEntry.PropertyInfo("inverse", "boolean", "false", "Uses inverse/dark card styling"),
                            new PluginEntry.PropertyInfo("textCenter", "boolean", "false", "Centers text within the card"),
                            new PluginEntry.PropertyInfo("textRight", "boolean", "false", "Right-aligns text within the card")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Card with Image", "Create a card with a top image, body, and footer",
                            "BSCard&lt;?&gt; card = new BSCard&lt;&gt;();\ncard.addCardImageTop(\"/img/hero.jpg\");\ncard.addCardHeader(\"Title\");\ncard.addCardBody(\"Card content goes here.\");\ncard.addCardFooter(\"Last updated 3 mins ago\");", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("BSCard()", "Creates an empty card"),
                            new PluginEntry.ConstructorInfo("BSCard(String text)", "Creates a card with body text"),
                            new PluginEntry.ConstructorInfo("BSCard(boolean inverse)", "Creates an inverse/dark card")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addCardHeader", "BSCard", "addCardHeader(String header)", "Adds a text header to the card"),
                            new PluginEntry.MethodInfo("addCardBody", "BSCardBody", "addCardBody()", "Adds and returns an empty card body"),
                            new PluginEntry.MethodInfo("addCardText", "BSCard", "addCardText(String text)", "Adds a text paragraph to the card body"),
                            new PluginEntry.MethodInfo("addCardFooter", "BSCard", "addCardFooter(String footer)", "Adds a text footer to the card"),
                            new PluginEntry.MethodInfo("addCardImageTop", "BSCard", "addCardImageTop(String url)", "Adds an image at the top of the card"),
                            new PluginEntry.MethodInfo("addCardImageBottom", "BSCard", "addCardImageBottom(String url)", "Adds an image at the bottom of the card"),
                            new PluginEntry.MethodInfo("addCardImageOverlay", "BSCard", "addCardImageOverlay(String title, String subtitle, String... paragraphs)", "Adds an image overlay with text"),
                            new PluginEntry.MethodInfo("addListGroup", "BSCard", "addListGroup(List items)", "Adds a list group to the card"),
                            new PluginEntry.MethodInfo("setTextCenter", "BSCard", "setTextCenter(boolean center)", "Centers text alignment"),
                            new PluginEntry.MethodInfo("addBackground", "BSCard", "addBackground(BSBackgroundOptions bg)", "Applies a background colour"),
                            new PluginEntry.MethodInfo("addForeground", "BSCard", "addForeground(BSColoursOptions fg)", "Applies a foreground colour"),
                            new PluginEntry.MethodInfo("addMargin", "BSCard", "addMargin(BSMarginOptions margin)", "Applies margin spacing"),
                            new PluginEntry.MethodInfo("addPadding", "BSCard", "addPadding(BSPaddingOptions padding)", "Applies padding spacing"),
                            new PluginEntry.MethodInfo("addBorder", "BSCard", "addBorder(BSBorderOptions border)", "Applies border styling")
                    ),
                    List.of(), List.of(),
                    List.of("IBSLayout", "IBSCard", "IBSCardDeckChildren")),

            new PluginEntry.ComponentInfo("BSCarousel", "Slide show component with navigation arrows, indicators, and auto-play", "com.jwebmp.plugins.bootstrap.carousel",
                    List.of(
                            new PluginEntry.PropertyInfo("showNavigationArrows", "Boolean", "null", "Shows prev/next navigation arrows"),
                            new PluginEntry.PropertyInfo("showNavigationIndicators", "Boolean", "null", "Shows slide position indicators"),
                            new PluginEntry.PropertyInfo("interval", "Integer", "null", "Auto-advance interval in milliseconds"),
                            new PluginEntry.PropertyInfo("pauseOnHover", "Boolean", "null", "Pauses auto-advance on mouse hover"),
                            new PluginEntry.PropertyInfo("pauseOnFocus", "Boolean", "null", "Pauses auto-advance on focus")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Image Carousel", "Create a carousel with navigation and indicators",
                            "BSCarousel&lt;?&gt; carousel = new BSCarousel&lt;&gt;();\ncarousel.setShowNavigationArrows(true);\ncarousel.setShowNavigationIndicators(true);\ncarousel.setInterval(5000);\ncarousel.addSlide(new BSCarouselSlide&lt;&gt;(\"/img/slide1.jpg\"));\ncarousel.addSlide(new BSCarouselSlide&lt;&gt;(\"/img/slide2.jpg\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSCarousel()", "Creates an ngb-carousel element")),
                    List.of(
                            new PluginEntry.MethodInfo("addSlide", "BSCarousel", "addSlide(BSCarouselSlide slide)", "Adds a slide to the carousel"),
                            new PluginEntry.MethodInfo("setShowNavigationArrows", "BSCarousel", "setShowNavigationArrows(Boolean show)", "Toggles navigation arrows"),
                            new PluginEntry.MethodInfo("setShowNavigationIndicators", "BSCarousel", "setShowNavigationIndicators(Boolean show)", "Toggles slide indicators"),
                            new PluginEntry.MethodInfo("setInterval", "BSCarousel", "setInterval(Integer interval)", "Sets auto-advance interval in ms"),
                            new PluginEntry.MethodInfo("setPauseOnHover", "BSCarousel", "setPauseOnHover(Boolean pause)", "Pauses on mouse hover"),
                            new PluginEntry.MethodInfo("setPauseOnFocus", "BSCarousel", "setPauseOnFocus(Boolean pause)", "Pauses on focus")
                    ),
                    List.of(new PluginEntry.EventInfo("slide", "Fired when the carousel transitions between slides")),
                    List.of(),
                    List.of("IBSCarousel", "INgComponent")),

            new PluginEntry.ComponentInfo("BSCloseIcon", "Close/dismiss button for modals, alerts, and toasts", "com.jwebmp.plugins.bootstrap.close",
                    List.of(
                            new PluginEntry.PropertyInfo("whiteVariant", "boolean", "false", "Uses the white close button variant for dark backgrounds")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Close Button", "Add a close button to a container",
                            "BSCloseIcon&lt;?&gt; close = new BSCloseIcon&lt;&gt;();\nclose.addAttribute(\"aria-label\", \"Close\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSCloseIcon()", "Creates a close button with btn-close class")),
                    List.of(new PluginEntry.MethodInfo("setWhiteVariant", "BSCloseIcon", "setWhiteVariant(boolean white)", "Uses white variant for dark backgrounds")),
                    List.of(new PluginEntry.EventInfo("click", "Fired when the close button is clicked")),
                    List.of(),
                    List.of("IBSCloseIcon")),

            new PluginEntry.ComponentInfo("BSCollapse", "Toggle visibility of elements with animation using ngbCollapse", "com.jwebmp.plugins.bootstrap.collapse",
                    List.of(
                            new PluginEntry.PropertyInfo("hideOnStart", "boolean", "false", "Whether the target is hidden on initial render")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Collapse with Button", "Toggle a div visibility with a button",
                            "DivSimple&lt;?&gt; content = new DivSimple&lt;&gt;();\ncontent.setText(\"Collapsible content\");\nBSButton&lt;?&gt; trigger = new BSButton&lt;&gt;(\"Toggle\");\nBSCollapse.link(trigger, content, true);", "java")),
                    List.of(),
                    List.of(
                            new PluginEntry.MethodInfo("link", "void", "link(Link trigger, IComponentHierarchyBase target, boolean hideOnStart)", "Links a link element to toggle target visibility"),
                            new PluginEntry.MethodInfo("link", "void", "link(Button trigger, IComponentHierarchyBase target, boolean hideOnStart)", "Links a button to toggle target visibility"),
                            new PluginEntry.MethodInfo("link", "void", "link(IComponentHierarchyBase trigger, IComponentHierarchyBase target, boolean hideOnStart)", "Links any component to toggle target visibility")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("shown", "Fired after the collapse target becomes visible"),
                            new PluginEntry.EventInfo("hidden", "Fired after the collapse target is hidden")
                    ),
                    List.of(),
                    List.of()),

            new PluginEntry.ComponentInfo("BSContainer", "Responsive fixed-width and fluid-width layout containers", "com.jwebmp.plugins.bootstrap.containers",
                    List.of(
                            new PluginEntry.PropertyInfo("fluid", "boolean", "false", "Uses container-fluid for full-width layout"),
                            new PluginEntry.PropertyInfo("size", "BSSizes", "null", "Responsive breakpoint: Sm, Md, Lg, Xl, Xxl")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Fluid Container", "Create a full-width container",
                            "BSContainer&lt;?&gt; container = new BSContainer&lt;&gt;();\ncontainer.setFluid(true);\ncontainer.add(new BSRow&lt;&gt;());", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("BSContainer()", "Creates a fixed-width container"),
                            new PluginEntry.ConstructorInfo("BSContainer(boolean fluid)", "Creates a container, fluid if true")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setFluid", "BSContainer", "setFluid(boolean fluid)", "Switches between fixed and fluid layout"),
                            new PluginEntry.MethodInfo("setSize", "BSContainer", "setSize(BSSizes size)", "Sets the responsive breakpoint size")
                    ),
                    List.of(), List.of(),
                    List.of("IBSContainer", "IBSLayout")),

            new PluginEntry.ComponentInfo("BSDatePicker", "Date selection widget backed by ng-bootstrap datepicker", "com.jwebmp.plugins.bootstrap.datepicker",
                    List.of(
                            new PluginEntry.PropertyInfo("minDate", "NgbDateStruct", "null", "Minimum selectable date"),
                            new PluginEntry.PropertyInfo("maxDate", "NgbDateStruct", "null", "Maximum selectable date"),
                            new PluginEntry.PropertyInfo("startDate", "NgbDateStruct", "null", "Initial calendar display month"),
                            new PluginEntry.PropertyInfo("navigation", "String", "select", "Navigation type: select, arrows, or none"),
                            new PluginEntry.PropertyInfo("outsideDays", "String", "visible", "How to display days outside the current month"),
                            new PluginEntry.PropertyInfo("firstDayOfWeek", "int", "1", "First day of the week (1=Monday, 7=Sunday)")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Date Picker", "Create a date picker with min/max bounds",
                            "BSDatePicker&lt;?&gt; dp = new BSDatePicker&lt;&gt;();\ndp.setMinDate(2024, 1, 1);\ndp.setMaxDate(2025, 12, 31);\ndp.setNavigation(\"arrows\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSDatePicker()", "Creates an ngb-datepicker element")),
                    List.of(
                            new PluginEntry.MethodInfo("setMinDate", "BSDatePicker", "setMinDate(int year, int month, int day)", "Sets the minimum selectable date"),
                            new PluginEntry.MethodInfo("setMaxDate", "BSDatePicker", "setMaxDate(int year, int month, int day)", "Sets the maximum selectable date"),
                            new PluginEntry.MethodInfo("setStartDate", "BSDatePicker", "setStartDate(int year, int month, int day)", "Sets initial display month"),
                            new PluginEntry.MethodInfo("setNavigation", "BSDatePicker", "setNavigation(String navigation)", "Sets navigation mode"),
                            new PluginEntry.MethodInfo("setFirstDayOfWeek", "BSDatePicker", "setFirstDayOfWeek(int day)", "Sets the first day of the week")
                    ),
                    List.of(new PluginEntry.EventInfo("dateSelect", "Fired when a date is selected")),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("BSDropDown", "Toggleable dropdown menus with Popper.js positioning and dynamic placement", "com.jwebmp.plugins.bootstrap.dropdown",
                    List.of(
                            new PluginEntry.PropertyInfo("placement", "BSPlacements", "null", "Menu placement: top, bottom, left, right and variants"),
                            new PluginEntry.PropertyInfo("bodyContainer", "boolean", "false", "Appends the menu to the document body"),
                            new PluginEntry.PropertyInfo("dynamic", "boolean", "false", "Enables dynamic Popper.js positioning")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Dropdown Menu", "Create a dropdown with items",
                            "BSDropDown&lt;?&gt; dd = new BSDropDown&lt;&gt;();\ndd.setText(\"Actions\");\ndd.addItem(\"Edit\");\ndd.addItem(\"Delete\");\ndd.setPlacement(BSPlacements.BottomEnd);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSDropDown()", "Creates a dropdown with ngbDropdown attribute")),
                    List.of(
                            new PluginEntry.MethodInfo("addItem", "BSDropDown", "addItem(String text)", "Adds a text menu item"),
                            new PluginEntry.MethodInfo("addItem", "BSDropDown", "addItem(IComponentHierarchyBase component)", "Adds a component menu item"),
                            new PluginEntry.MethodInfo("setText", "BSDropDown", "setText(String text)", "Sets the dropdown toggle button text"),
                            new PluginEntry.MethodInfo("setPlacement", "BSDropDown", "setPlacement(BSPlacements placement)", "Sets the menu placement"),
                            new PluginEntry.MethodInfo("setBodyContainer", "BSDropDown", "setBodyContainer(boolean bodyContainer)", "Appends menu to document body"),
                            new PluginEntry.MethodInfo("setDynamic", "BSDropDown", "setDynamic(boolean dynamic)", "Enables dynamic positioning"),
                            new PluginEntry.MethodInfo("asLink", "BSDropDown", "asLink()", "Renders the toggle as a link instead of a button"),
                            new PluginEntry.MethodInfo("getDropDownButton", "BSDropDownButton", "getDropDownButton()", "Returns the dropdown toggle button"),
                            new PluginEntry.MethodInfo("getDropDownMenu", "BSDropDownMenu", "getDropDownMenu()", "Returns the dropdown menu container")
                    ),
                    List.of(new PluginEntry.EventInfo("openChange", "Fired when the dropdown open state changes")),
                    List.of(),
                    List.of("IBSDropDown")),

            new PluginEntry.ComponentInfo("BSFigure", "Figure element for images and media with optional caption", "com.jwebmp.plugins.bootstrap.figures",
                    List.of(
                            new PluginEntry.PropertyInfo("caption", "String", "null", "The figure caption text"),
                            new PluginEntry.PropertyInfo("imageUrl", "String", "null", "The image source URL")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Image Figure", "Create a figure with image and caption",
                            "BSFigure&lt;?&gt; fig = new BSFigure&lt;&gt;();\nfig.setImageUrl(\"/img/photo.jpg\");\nfig.setCaption(\"A beautiful sunset\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSFigure()", "Creates a figure element with Bootstrap styling")),
                    List.of(
                            new PluginEntry.MethodInfo("setCaption", "BSFigure", "setCaption(String caption)", "Sets the figcaption text"),
                            new PluginEntry.MethodInfo("setImageUrl", "BSFigure", "setImageUrl(String url)", "Sets the image source URL")
                    ),
                    List.of(), List.of(),
                    List.of("IBSFigure")),

            new PluginEntry.ComponentInfo("BSFileUpload", "Custom file input with label and filename display", "com.jwebmp.plugins.bootstrap.fileupload",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "Choose file", "The label displayed on the input"),
                            new PluginEntry.PropertyInfo("multiple", "boolean", "false", "Whether multiple files can be selected"),
                            new PluginEntry.PropertyInfo("accept", "String", "null", "Accepted file types (MIME or extension)")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("File Upload", "Create a multi-file upload",
                            "BSFileUpload&lt;?&gt; upload = new BSFileUpload&lt;&gt;();\nupload.setLabel(\"Upload documents\");\nupload.setMultiple(true);\nupload.setAccept(\".pdf,.docx\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSFileUpload()", "Creates a custom file input")),
                    List.of(
                            new PluginEntry.MethodInfo("setLabel", "BSFileUpload", "setLabel(String label)", "Sets the input label"),
                            new PluginEntry.MethodInfo("setMultiple", "BSFileUpload", "setMultiple(boolean multiple)", "Enables multi-file selection"),
                            new PluginEntry.MethodInfo("setAccept", "BSFileUpload", "setAccept(String accept)", "Sets accepted file types")
                    ),
                    List.of(new PluginEntry.EventInfo("change", "Fired when files are selected")),
                    List.of(),
                    List.of("BSFormChildren")),

            new PluginEntry.ComponentInfo("BSForm", "Bootstrap form with groups, controls, input sets, and validation", "com.jwebmp.plugins.bootstrap.forms",
                    List.of(
                            new PluginEntry.PropertyInfo("inline", "boolean", "false", "Renders the form inline"),
                            new PluginEntry.PropertyInfo("noValidate", "boolean", "false", "Disables browser validation"),
                            new PluginEntry.PropertyInfo("wasValidated", "boolean", "false", "Shows validation feedback styles")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Login Form", "Create a login form with validation",
                            "BSForm&lt;?&gt; form = new BSForm&lt;&gt;();\nBSFormGroup&lt;?&gt; email = form.addGroup(\"email\", \"Email\", new InputEmailType&lt;&gt;());\nBSFormGroup&lt;?&gt; pass = form.addGroup(\"password\", \"Password\", new InputPasswordType&lt;&gt;());\nform.add(new BSButton&lt;&gt;(\"Login\").setPrimary(true));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSForm()", "Creates a Bootstrap styled form")),
                    List.of(
                            new PluginEntry.MethodInfo("addGroup", "BSFormGroup", "addGroup(String id, String label, InputType input)", "Adds a labelled form group with input"),
                            new PluginEntry.MethodInfo("setInline", "BSForm", "setInline(boolean inline)", "Renders form elements inline"),
                            new PluginEntry.MethodInfo("setNoValidate", "BSForm", "setNoValidate(boolean noValidate)", "Disables browser validation"),
                            new PluginEntry.MethodInfo("setWasValidated", "BSForm", "setWasValidated(boolean validated)", "Shows validation feedback")
                    ),
                    List.of(new PluginEntry.EventInfo("submit", "Fired when the form is submitted")),
                    List.of(),
                    List.of("IBSForm")),

            new PluginEntry.ComponentInfo("BSImage", "Responsive and thumbnail image components", "com.jwebmp.plugins.bootstrap.images",
                    List.of(
                            new PluginEntry.PropertyInfo("responsive", "boolean", "false", "Applies img-fluid for responsive scaling"),
                            new PluginEntry.PropertyInfo("thumbnail", "boolean", "false", "Applies img-thumbnail border"),
                            new PluginEntry.PropertyInfo("rounded", "boolean", "false", "Applies rounded corners")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Responsive Image", "Create a responsive thumbnail",
                            "BSImage&lt;?&gt; img = new BSImage&lt;&gt;(\"/img/photo.jpg\");\nimg.setResponsive(true);\nimg.setThumbnail(true);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("BSImage()", "Creates an empty image element"),
                            new PluginEntry.ConstructorInfo("BSImage(String src)", "Creates an image with a source URL")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setResponsive", "BSImage", "setResponsive(boolean responsive)", "Applies img-fluid class"),
                            new PluginEntry.MethodInfo("setThumbnail", "BSImage", "setThumbnail(boolean thumbnail)", "Applies img-thumbnail class"),
                            new PluginEntry.MethodInfo("setRounded", "BSImage", "setRounded(boolean rounded)", "Applies rounded class")
                    ),
                    List.of(), List.of(),
                    List.of("IBSImage")),

            new PluginEntry.ComponentInfo("BSJumbotron", "Hero section for showcasing key content with large text", "com.jwebmp.plugins.bootstrap.jumbotron",
                    List.of(
                            new PluginEntry.PropertyInfo("fluid", "boolean", "false", "Extends the jumbotron full width")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Hero Section", "Create a jumbotron with heading and lead",
                            "BSJumbotron&lt;?&gt; jumbo = new BSJumbotron&lt;&gt;();\njumbo.add(new H1&lt;&gt;().setText(\"Welcome!\"));\njumbo.add(new Paragraph&lt;&gt;().setText(\"This is a hero section.\"));\njumbo.setFluid(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSJumbotron()", "Creates a jumbotron container")),
                    List.of(
                            new PluginEntry.MethodInfo("setFluid", "BSJumbotron", "setFluid(boolean fluid)", "Extends to full width")
                    ),
                    List.of(), List.of(),
                    List.of("IBSJumbotron")),

            new PluginEntry.ComponentInfo("BSListGroup", "Flexible list group with active, disabled, flush, and contextual items", "com.jwebmp.plugins.bootstrap.listgroup",
                    List.of(
                            new PluginEntry.PropertyInfo("flush", "boolean", "false", "Removes outer borders for edge-to-edge rendering")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("List Group", "Create a list group with items",
                            "BSListGroup&lt;?&gt; list = new BSListGroup&lt;&gt;();\nlist.addButtonItem(\"Action 1\");\nlist.addButtonItem(\"Action 2\");\nlist.addLinkItem(\"Link Item\");\nlist.setFlush();", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSListGroup()", "Creates a ul element with list-group class")),
                    List.of(
                            new PluginEntry.MethodInfo("addButtonItem", "BSListGroup", "addButtonItem(String text)", "Adds a button-style list item"),
                            new PluginEntry.MethodInfo("addButtonItem", "BSListGroup", "addButtonItem(ListItemChildren icon, String text)", "Adds a button item with icon and text"),
                            new PluginEntry.MethodInfo("addLinkItem", "BSListGroup", "addLinkItem(String text)", "Adds a link-style list item"),
                            new PluginEntry.MethodInfo("addListItem", "BSListGroup", "addListItem(String text)", "Adds a basic list item"),
                            new PluginEntry.MethodInfo("setFlush", "BSListGroup", "setFlush()", "Removes outer borders for flush rendering")
                    ),
                    List.of(), List.of(),
                    List.of("IBSListGroup")),

            new PluginEntry.ComponentInfo("BSMedia", "Media object layout for images alongside text content", "com.jwebmp.plugins.bootstrap.media",
                    List.of(
                            new PluginEntry.PropertyInfo("imageUrl", "String", "null", "The media image source URL"),
                            new PluginEntry.PropertyInfo("alignment", "String", "top", "Vertical alignment of the image: top, center, bottom")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Media Object", "Create a media layout with image and text",
                            "BSMedia&lt;?&gt; media = new BSMedia&lt;&gt;();\nmedia.setImageUrl(\"/img/avatar.jpg\");\nmedia.add(new H5&lt;&gt;().setText(\"Media Heading\"));\nmedia.add(new Paragraph&lt;&gt;().setText(\"Descriptive text.\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSMedia()", "Creates a media object layout")),
                    List.of(
                            new PluginEntry.MethodInfo("setImageUrl", "BSMedia", "setImageUrl(String url)", "Sets the media image source"),
                            new PluginEntry.MethodInfo("setAlignment", "BSMedia", "setAlignment(String alignment)", "Sets the vertical alignment")
                    ),
                    List.of(), List.of(),
                    List.of("IBSMedia")),

            new PluginEntry.ComponentInfo("BSModal", "Modal dialog with backdrop, size, fullscreen, and keyboard options", "com.jwebmp.plugins.bootstrap.modal",
                    List.of(
                            new PluginEntry.PropertyInfo("backdrop", "boolean", "true", "Shows a backdrop behind the modal"),
                            new PluginEntry.PropertyInfo("backdropStatic", "boolean", "false", "Prevents closing on backdrop click"),
                            new PluginEntry.PropertyInfo("centered", "boolean", "false", "Vertically centres the modal"),
                            new PluginEntry.PropertyInfo("fullScreen", "boolean", "false", "Displays modal as full screen"),
                            new PluginEntry.PropertyInfo("fullScreenBelow", "BSSizes", "null", "Breakpoint below which modal goes fullscreen"),
                            new PluginEntry.PropertyInfo("keyboard", "boolean", "true", "Allows closing with Escape key"),
                            new PluginEntry.PropertyInfo("size", "BSSizes", "null", "Modal size: Sm, Lg, Xl")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Modal Dialog", "Create a centred modal with header, body, and footer",
                            "BSModal&lt;?&gt; modal = new BSModal&lt;&gt;();\nmodal.setCentered(true);\nmodal.setSize(BSSizes.Lg);\nmodal.getModalHeader().add(new H5&lt;&gt;().setText(\"Confirm\"));\nmodal.getModalBody().add(\"Are you sure?\");\nmodal.getModalFooter().add(new BSButton&lt;&gt;(\"OK\").setPrimary(true));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSModal()", "Creates a modal using ng-template tag")),
                    List.of(
                            new PluginEntry.MethodInfo("getModalHeader", "BSModalHeader", "getModalHeader()", "Returns the modal header section"),
                            new PluginEntry.MethodInfo("getModalBody", "BSModalBody", "getModalBody()", "Returns the modal body section"),
                            new PluginEntry.MethodInfo("getModalFooter", "BSModalFooter", "getModalFooter()", "Returns the modal footer section"),
                            new PluginEntry.MethodInfo("setModalHeader", "BSModal", "setModalHeader(BSModalHeader header)", "Sets a custom modal header"),
                            new PluginEntry.MethodInfo("setModalBody", "BSModal", "setModalBody(BSModalBody body)", "Sets a custom modal body"),
                            new PluginEntry.MethodInfo("setModalFooter", "BSModal", "setModalFooter(BSModalFooter footer)", "Sets a custom modal footer"),
                            new PluginEntry.MethodInfo("setCloseButton", "BSModal", "setCloseButton(IComponentHierarchyBase component)", "Sets the close button component"),
                            new PluginEntry.MethodInfo("setOpenButton", "BSModal", "setOpenButton(IComponentHierarchyBase component)", "Sets the open trigger component"),
                            new PluginEntry.MethodInfo("setBackdrop", "BSModal", "setBackdrop(boolean backdrop)", "Toggles the backdrop"),
                            new PluginEntry.MethodInfo("setBackdropStatic", "BSModal", "setBackdropStatic(boolean staticBackdrop)", "Prevents close on backdrop click"),
                            new PluginEntry.MethodInfo("setCentered", "BSModal", "setCentered(boolean centered)", "Vertically centres the modal"),
                            new PluginEntry.MethodInfo("setFullScreen", "BSModal", "setFullScreen(boolean fullScreen)", "Enables fullscreen display"),
                            new PluginEntry.MethodInfo("setSize", "BSModal", "setSize(BSSizes size)", "Sets the modal size"),
                            new PluginEntry.MethodInfo("setKeyboard", "BSModal", "setKeyboard(boolean keyboard)", "Toggles Escape key closing")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("shown", "Fired after the modal is fully shown"),
                            new PluginEntry.EventInfo("hidden", "Fired after the modal is hidden"),
                            new PluginEntry.EventInfo("dismiss", "Fired when the modal is dismissed")
                    ),
                    List.of(),
                    List.of("IBSModal", "INgComponent")),

            new PluginEntry.ComponentInfo("BSNavBar", "Responsive navigation bar with brand, toggler, collapse, and theming", "com.jwebmp.plugins.bootstrap.navbar",
                    List.of(
                            new PluginEntry.PropertyInfo("menuCollapsed", "boolean", "true", "Whether the menu starts collapsed on mobile"),
                            new PluginEntry.PropertyInfo("collapsedFieldName", "String", "null", "Angular variable name for collapse state")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Navigation Bar", "Create a themed navbar with brand and links",
                            "BSNavBar&lt;?&gt; nav = new BSNavBar&lt;&gt;();\nnav.addBrand(\"My App\", \"/logo.png\");\nnav.addHeaderText(\"Dashboard\");\nnav.setNavBarTheme(BSNavBarColourSchemes.Navbar_Dark);\nnav.addBackground(BSBackgroundOptions.Bg_Primary);\nnav.setCollapseWhen(BSSizes.Lg);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("BSNavBar()", "Creates a responsive navbar"),
                            new PluginEntry.ConstructorInfo("BSNavBar(String collapsedFieldName)", "Creates a navbar with a named collapse variable")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addBrand", "BSNavBar", "addBrand(String name)", "Adds a text brand link"),
                            new PluginEntry.MethodInfo("addBrand", "BSNavBar", "addBrand(String name, String image)", "Adds a brand with image and text"),
                            new PluginEntry.MethodInfo("addBrandImage", "BSNavBar", "addBrandImage(String imageUrl)", "Adds an image-only brand"),
                            new PluginEntry.MethodInfo("addHeaderText", "BSNavBar", "addHeaderText(String text)", "Adds header text to the nav"),
                            new PluginEntry.MethodInfo("addForm", "BSForm", "addForm()", "Adds and returns an inline search form"),
                            new PluginEntry.MethodInfo("addToggle", "BSNavBar", "addToggle()", "Adds a mobile toggle button"),
                            new PluginEntry.MethodInfo("addNavs", "BSNavBar", "addNavs(BSNavBarNavs navs)", "Adds a navigation item set"),
                            new PluginEntry.MethodInfo("addText", "BSNavBar", "addText(String text)", "Adds inline text"),
                            new PluginEntry.MethodInfo("setNavBarTheme", "BSNavBar", "setNavBarTheme(BSNavBarColourSchemes theme)", "Sets the navbar colour scheme"),
                            new PluginEntry.MethodInfo("setCollapseWhen", "BSNavBar", "setCollapseWhen(BSSizes size)", "Sets the breakpoint for collapse"),
                            new PluginEntry.MethodInfo("addBackground", "BSNavBar", "addBackground(BSBackgroundOptions bg)", "Applies a background colour"),
                            new PluginEntry.MethodInfo("addToCollapsable", "BSNavBar", "addToCollapsable(GlobalChildren child)", "Adds content inside the collapsible section")
                    ),
                    List.of(), List.of(),
                    List.of("IBSNavBar")),

            new PluginEntry.ComponentInfo("BSNavs", "Nav tabs, pills, and justified/fill navigation", "com.jwebmp.plugins.bootstrap.navs",
                    List.of(
                            new PluginEntry.PropertyInfo("tabs", "boolean", "false", "Renders as tab-style navigation"),
                            new PluginEntry.PropertyInfo("pills", "boolean", "false", "Renders as pill-style navigation"),
                            new PluginEntry.PropertyInfo("justified", "boolean", "false", "Justifies items to fill the width"),
                            new PluginEntry.PropertyInfo("fill", "boolean", "false", "Fills available width proportionally"),
                            new PluginEntry.PropertyInfo("vertical", "boolean", "false", "Renders navigation vertically")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Tabbed Navigation", "Create tabs with tab panes",
                            "BSNavs&lt;?&gt; navs = new BSNavs&lt;&gt;();\nnavs.setTabs(true);\nnavs.addTab(\"Home\", homeContent);\nnavs.addTab(\"Profile\", profileContent);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSNavs()", "Creates a nav element")),
                    List.of(
                            new PluginEntry.MethodInfo("setTabs", "BSNavs", "setTabs(boolean tabs)", "Renders as tab-style"),
                            new PluginEntry.MethodInfo("setPills", "BSNavs", "setPills(boolean pills)", "Renders as pill-style"),
                            new PluginEntry.MethodInfo("setJustified", "BSNavs", "setJustified(boolean justified)", "Justifies items"),
                            new PluginEntry.MethodInfo("setFill", "BSNavs", "setFill(boolean fill)", "Fills available width"),
                            new PluginEntry.MethodInfo("setVertical", "BSNavs", "setVertical(boolean vertical)", "Renders vertically"),
                            new PluginEntry.MethodInfo("addTab", "BSNavs", "addTab(String label, IComponentHierarchyBase content)", "Adds a tab with content pane")
                    ),
                    List.of(new PluginEntry.EventInfo("tabChange", "Fired when the active tab changes")),
                    List.of(),
                    List.of("IBSNavs")),

            new PluginEntry.ComponentInfo("BSPagination", "Pagination navigation with page items, sizing, and alignment", "com.jwebmp.plugins.bootstrap.pagination",
                    List.of(
                            new PluginEntry.PropertyInfo("size", "BSSizes", "null", "Pagination size: Sm or Lg"),
                            new PluginEntry.PropertyInfo("alignment", "String", "start", "Alignment: start, center, or end"),
                            new PluginEntry.PropertyInfo("maxSize", "int", "0", "Maximum number of visible page links"),
                            new PluginEntry.PropertyInfo("rotate", "boolean", "false", "Rotates pages when maxSize is set")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Pagination", "Create centred pagination",
                            "BSPagination&lt;?&gt; pager = new BSPagination&lt;&gt;();\npager.setSize(BSSizes.Lg);\npager.setAlignment(\"center\");\npager.setMaxSize(5);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSPagination()", "Creates a pagination nav element")),
                    List.of(
                            new PluginEntry.MethodInfo("setSize", "BSPagination", "setSize(BSSizes size)", "Sets the pagination size"),
                            new PluginEntry.MethodInfo("setAlignment", "BSPagination", "setAlignment(String alignment)", "Sets the alignment"),
                            new PluginEntry.MethodInfo("setMaxSize", "BSPagination", "setMaxSize(int maxSize)", "Sets the maximum visible page links"),
                            new PluginEntry.MethodInfo("setRotate", "BSPagination", "setRotate(boolean rotate)", "Enables page rotation")
                    ),
                    List.of(new PluginEntry.EventInfo("pageChange", "Fired when the active page changes")),
                    List.of(),
                    List.of("IBSPagination", "INgComponent")),

            new PluginEntry.ComponentInfo("BSPopOver", "Configurable popovers with title, content, placement, and triggers", "com.jwebmp.plugins.bootstrap.popovers",
                    List.of(
                            new PluginEntry.PropertyInfo("title", "String", "null", "The popover title text"),
                            new PluginEntry.PropertyInfo("content", "String", "null", "The popover body content"),
                            new PluginEntry.PropertyInfo("placement", "BSPlacements", "top", "Popover placement relative to trigger"),
                            new PluginEntry.PropertyInfo("triggers", "String", "click", "Trigger events: click, hover, focus, manual"),
                            new PluginEntry.PropertyInfo("container", "String", "body", "Container to append the popover to"),
                            new PluginEntry.PropertyInfo("autoClose", "boolean", "true", "Auto-close on outside click")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Popover", "Attach a popover to a button",
                            "BSButton&lt;?&gt; btn = new BSButton&lt;&gt;(\"Help\");\nBSPopOver.attach(btn, \"Info\", \"Helpful details here\", BSPlacements.Right);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSPopOver()", "Creates popover configuration")),
                    List.of(
                            new PluginEntry.MethodInfo("setTitle", "BSPopOver", "setTitle(String title)", "Sets the popover title"),
                            new PluginEntry.MethodInfo("setContent", "BSPopOver", "setContent(String content)", "Sets the popover body content"),
                            new PluginEntry.MethodInfo("setPlacement", "BSPopOver", "setPlacement(BSPlacements placement)", "Sets the popover placement"),
                            new PluginEntry.MethodInfo("setTriggers", "BSPopOver", "setTriggers(String triggers)", "Sets the trigger events"),
                            new PluginEntry.MethodInfo("setAutoClose", "BSPopOver", "setAutoClose(boolean autoClose)", "Toggles auto-close behaviour")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("shown", "Fired after the popover is shown"),
                            new PluginEntry.EventInfo("hidden", "Fired after the popover is hidden")
                    ),
                    List.of(),
                    List.of("IBSPopOver", "INgComponent")),

            new PluginEntry.ComponentInfo("BSProgressBar", "Progress bar with animated segments and label", "com.jwebmp.plugins.bootstrap.progressbar",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "int", "0", "Current progress value (0–100)"),
                            new PluginEntry.PropertyInfo("max", "int", "100", "Maximum progress value"),
                            new PluginEntry.PropertyInfo("striped", "boolean", "false", "Adds striped styling"),
                            new PluginEntry.PropertyInfo("animated", "boolean", "false", "Animates the stripes"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Text label inside the bar"),
                            new PluginEntry.PropertyInfo("type", "BSColourTypes", "null", "Contextual colour for the bar")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Animated Progress", "Create an animated striped progress bar",
                            "BSProgressBar&lt;?&gt; bar = new BSProgressBar&lt;&gt;();\nbar.setValue(75);\nbar.setStriped(true);\nbar.setAnimated(true);\nbar.setType(BSColourTypes.Success);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSProgressBar()", "Creates a progress bar element")),
                    List.of(
                            new PluginEntry.MethodInfo("setValue", "BSProgressBar", "setValue(int value)", "Sets the current progress value"),
                            new PluginEntry.MethodInfo("setMax", "BSProgressBar", "setMax(int max)", "Sets the maximum value"),
                            new PluginEntry.MethodInfo("setStriped", "BSProgressBar", "setStriped(boolean striped)", "Adds striped styling"),
                            new PluginEntry.MethodInfo("setAnimated", "BSProgressBar", "setAnimated(boolean animated)", "Animates the stripes"),
                            new PluginEntry.MethodInfo("setLabel", "BSProgressBar", "setLabel(String label)", "Sets the label text"),
                            new PluginEntry.MethodInfo("setType", "BSProgressBar", "setType(BSColourTypes type)", "Sets the contextual colour")
                    ),
                    List.of(), List.of(),
                    List.of("IBSProgressBar")),

            new PluginEntry.ComponentInfo("BSRange", "Range slider input control", "com.jwebmp.plugins.bootstrap.range",
                    List.of(
                            new PluginEntry.PropertyInfo("min", "int", "0", "Minimum value"),
                            new PluginEntry.PropertyInfo("max", "int", "100", "Maximum value"),
                            new PluginEntry.PropertyInfo("step", "int", "1", "Step increment"),
                            new PluginEntry.PropertyInfo("value", "int", "0", "Current slider value"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the slider is disabled")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Range Slider", "Create a range slider with custom step",
                            "BSRange&lt;?&gt; range = new BSRange&lt;&gt;();\nrange.setMin(0);\nrange.setMax(100);\nrange.setStep(5);\nrange.setValue(50);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSRange()", "Creates a range input with form-range class")),
                    List.of(
                            new PluginEntry.MethodInfo("setMin", "BSRange", "setMin(int min)", "Sets the minimum value"),
                            new PluginEntry.MethodInfo("setMax", "BSRange", "setMax(int max)", "Sets the maximum value"),
                            new PluginEntry.MethodInfo("setStep", "BSRange", "setStep(int step)", "Sets the step increment"),
                            new PluginEntry.MethodInfo("setValue", "BSRange", "setValue(int value)", "Sets the current value"),
                            new PluginEntry.MethodInfo("setDisabled", "BSRange", "setDisabled(boolean disabled)", "Disables the slider")
                    ),
                    List.of(new PluginEntry.EventInfo("input", "Fired continuously as the slider moves")),
                    List.of(),
                    List.of("BSFormChildren")),

            new PluginEntry.ComponentInfo("BSSelect", "Styled select dropdown with size variants and custom styles", "com.jwebmp.plugins.bootstrap.select",
                    List.of(
                            new PluginEntry.PropertyInfo("size", "BSSizes", "null", "Select size: Sm or Lg"),
                            new PluginEntry.PropertyInfo("multiple", "boolean", "false", "Enables multi-select"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Disables the select")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Select Dropdown", "Create a select with options",
                            "BSSelect&lt;?&gt; select = new BSSelect&lt;&gt;();\nselect.addOption(\"Choose...\", \"\", true);\nselect.addOption(\"Option 1\", \"1\");\nselect.addOption(\"Option 2\", \"2\");\nselect.setSize(BSSizes.Lg);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSSelect()", "Creates a select element with form-select class")),
                    List.of(
                            new PluginEntry.MethodInfo("addOption", "BSSelect", "addOption(String label, String value)", "Adds an option"),
                            new PluginEntry.MethodInfo("addOption", "BSSelect", "addOption(String label, String value, boolean selected)", "Adds an option with selected state"),
                            new PluginEntry.MethodInfo("setSize", "BSSelect", "setSize(BSSizes size)", "Sets the select size"),
                            new PluginEntry.MethodInfo("setMultiple", "BSSelect", "setMultiple(boolean multiple)", "Enables multi-select"),
                            new PluginEntry.MethodInfo("setDisabled", "BSSelect", "setDisabled(boolean disabled)", "Disables the select")
                    ),
                    List.of(new PluginEntry.EventInfo("change", "Fired when the selection changes")),
                    List.of(),
                    List.of("BSFormChildren")),

            new PluginEntry.ComponentInfo("BSTable", "Styled tables with striped, bordered, hover, and responsive options", "com.jwebmp.plugins.bootstrap.tables",
                    List.of(
                            new PluginEntry.PropertyInfo("striped", "boolean", "false", "Adds alternate row striping"),
                            new PluginEntry.PropertyInfo("bordered", "boolean", "false", "Adds borders to all cells"),
                            new PluginEntry.PropertyInfo("hover", "boolean", "false", "Adds hover highlighting"),
                            new PluginEntry.PropertyInfo("small", "boolean", "false", "Uses compact table styling"),
                            new PluginEntry.PropertyInfo("responsive", "boolean", "false", "Wraps in a responsive container"),
                            new PluginEntry.PropertyInfo("dark", "boolean", "false", "Uses dark table variant")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Striped Table", "Create a striped, hoverable table",
                            "BSTable&lt;?&gt; table = new BSTable&lt;&gt;();\ntable.setStriped(true);\ntable.setHover(true);\ntable.setResponsive(true);\ntable.addHeaderRow(\"Name\", \"Email\", \"Role\");\ntable.addRow(\"Alice\", \"alice@ex.com\", \"Admin\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSTable()", "Creates a Bootstrap styled table")),
                    List.of(
                            new PluginEntry.MethodInfo("setStriped", "BSTable", "setStriped(boolean striped)", "Applies alternate row striping"),
                            new PluginEntry.MethodInfo("setBordered", "BSTable", "setBordered(boolean bordered)", "Adds cell borders"),
                            new PluginEntry.MethodInfo("setHover", "BSTable", "setHover(boolean hover)", "Adds hover highlighting"),
                            new PluginEntry.MethodInfo("setSmall", "BSTable", "setSmall(boolean small)", "Uses compact styling"),
                            new PluginEntry.MethodInfo("setResponsive", "BSTable", "setResponsive(boolean responsive)", "Wraps in responsive container"),
                            new PluginEntry.MethodInfo("setDark", "BSTable", "setDark(boolean dark)", "Uses dark variant"),
                            new PluginEntry.MethodInfo("addHeaderRow", "BSTable", "addHeaderRow(String... headers)", "Adds a header row"),
                            new PluginEntry.MethodInfo("addRow", "BSTable", "addRow(String... cells)", "Adds a data row")
                    ),
                    List.of(), List.of(),
                    List.of("IBSTable")),

            new PluginEntry.ComponentInfo("BSTimePicker", "Time selection widget backed by ng-bootstrap timepicker", "com.jwebmp.plugins.bootstrap.timepicker",
                    List.of(
                            new PluginEntry.PropertyInfo("meridian", "boolean", "false", "Shows AM/PM selector"),
                            new PluginEntry.PropertyInfo("spinners", "boolean", "true", "Shows increment/decrement spinners"),
                            new PluginEntry.PropertyInfo("seconds", "boolean", "false", "Shows seconds field"),
                            new PluginEntry.PropertyInfo("hourStep", "int", "1", "Hour increment step"),
                            new PluginEntry.PropertyInfo("minuteStep", "int", "1", "Minute increment step"),
                            new PluginEntry.PropertyInfo("secondStep", "int", "1", "Second increment step")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Time Picker", "Create a time picker with meridian and seconds",
                            "BSTimePicker&lt;?&gt; tp = new BSTimePicker&lt;&gt;();\ntp.setMeridian(true);\ntp.setSeconds(true);\ntp.setMinuteStep(15);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSTimePicker()", "Creates an ngb-timepicker element")),
                    List.of(
                            new PluginEntry.MethodInfo("setMeridian", "BSTimePicker", "setMeridian(boolean meridian)", "Toggles AM/PM display"),
                            new PluginEntry.MethodInfo("setSpinners", "BSTimePicker", "setSpinners(boolean spinners)", "Toggles spinner buttons"),
                            new PluginEntry.MethodInfo("setSeconds", "BSTimePicker", "setSeconds(boolean seconds)", "Toggles seconds field"),
                            new PluginEntry.MethodInfo("setHourStep", "BSTimePicker", "setHourStep(int step)", "Sets the hour step"),
                            new PluginEntry.MethodInfo("setMinuteStep", "BSTimePicker", "setMinuteStep(int step)", "Sets the minute step"),
                            new PluginEntry.MethodInfo("setSecondStep", "BSTimePicker", "setSecondStep(int step)", "Sets the second step")
                    ),
                    List.of(new PluginEntry.EventInfo("timeChange", "Fired when the time value changes")),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("BSToast", "Lightweight push notification with auto-hide, delay, and stacking", "com.jwebmp.plugins.bootstrap.toasts",
                    List.of(
                            new PluginEntry.PropertyInfo("autohide", "boolean", "true", "Automatically hides the toast after delay"),
                            new PluginEntry.PropertyInfo("delay", "int", "5000", "Auto-hide delay in milliseconds"),
                            new PluginEntry.PropertyInfo("animation", "boolean", "true", "Enables fade animation"),
                            new PluginEntry.PropertyInfo("header", "String", "null", "Toast header text")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Toast Notification", "Show an auto-hiding toast",
                            "BSToast&lt;?&gt; toast = new BSToast&lt;&gt;();\ntoast.setHeader(\"Notification\");\ntoast.add(new Paragraph&lt;&gt;().setText(\"Operation successful!\"));\ntoast.setAutohide(true);\ntoast.setDelay(3000);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSToast()", "Creates a toast notification element")),
                    List.of(
                            new PluginEntry.MethodInfo("setAutohide", "BSToast", "setAutohide(boolean autohide)", "Toggles auto-hide"),
                            new PluginEntry.MethodInfo("setDelay", "BSToast", "setDelay(int delay)", "Sets the auto-hide delay in ms"),
                            new PluginEntry.MethodInfo("setAnimation", "BSToast", "setAnimation(boolean animation)", "Toggles fade animation"),
                            new PluginEntry.MethodInfo("setHeader", "BSToast", "setHeader(String header)", "Sets the toast header text")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("shown", "Fired after the toast is shown"),
                            new PluginEntry.EventInfo("hidden", "Fired after the toast is hidden")
                    ),
                    List.of(),
                    List.of("IBSToast")),

            new PluginEntry.ComponentInfo("BSToggle", "Toggle component for on/off states with Bootstrap styling", "com.jwebmp.plugins.bootstrap.toggle",
                    List.of(
                            new PluginEntry.PropertyInfo("checked", "boolean", "false", "Whether the toggle is on"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Toggle label text"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the toggle is disabled")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Toggle Button", "Create a toggle button",
                            "BSToggle&lt;?&gt; toggle = new BSToggle&lt;&gt;();\ntoggle.setLabel(\"Dark mode\");\ntoggle.setChecked(false);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("BSToggle()", "Creates a toggle component")),
                    List.of(
                            new PluginEntry.MethodInfo("setChecked", "BSToggle", "setChecked(boolean checked)", "Sets the on/off state"),
                            new PluginEntry.MethodInfo("setLabel", "BSToggle", "setLabel(String label)", "Sets the label text"),
                            new PluginEntry.MethodInfo("setDisabled", "BSToggle", "setDisabled(boolean disabled)", "Disables the toggle")
                    ),
                    List.of(new PluginEntry.EventInfo("change", "Fired when the toggle state changes")),
                    List.of(),
                    List.of("BSFormChildren"))
    );

    public BootstrapPluginPage()
    {
        super(PluginCatalog.getById("bootstrap").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return COMPONENTS;
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Card",
                        "Create a Bootstrap card with header, body, and footer.",
                        "BSCard<?> card = new BSCard<>();\ncard.addCardHeader(\"Header\");\ncard.addCardBody(\"Content\");\ncard.addCardFooter(\"Footer\");",
                        "java"),
                new PluginEntry.ExampleSnippet("Modal",
                        "Create a modal dialog with dismiss and primary buttons.",
                        "BSModal<?> modal = new BSModal<>();\nmodal.addTitle(\"Confirm\");\nmodal.addModalBody(\"Are you sure?\");\nmodal.addDismissButton(\"Cancel\");\nmodal.addPrimaryButton(\"OK\");",
                        "java"),
                new PluginEntry.ExampleSnippet("Navbar",
                        "Create a responsive navigation bar.",
                        "BSNavBar<?> navbar = new BSNavBar<>();\nnavbar.addBrand(\"My App\", \"/\");\nnavbar.addHeaderItem(\"Home\", \"/home\");\nnavbar.addHeaderItem(\"About\", \"/about\");",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "BootstrapPageConfigurator auto-registers Bootstrap 5.3.8 CSS/JS, Popper.js, and ng-bootstrap"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "BootstrapModuleInclusion includes the Bootstrap module in Guice classpath scanning"),
                new PluginEntry.SpiDetail("IOnComponentAdded", "provides", "OnBootstrapComponentAdded auto-applies Bootstrap CSS classes when components are added"),
                new PluginEntry.SpiDetail("IOnComponentConfigured", "provides", "OnBootstrapComponentAdded handles component configuration events")
        );
    }
}
