package com.jwebmp.website.pages.frameworks;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-framework-bootstrap")
@NgRoutable(path = "frameworks/bootstrap")
public class BootstrapFrameworkPage extends FrameworkDetailPage<BootstrapFrameworkPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            // ── BSAccordion ──
            new PluginEntry.ComponentInfo("BSAccordion",
                    "Collapsible content panels with show/hide transitions. Uses ng-bootstrap NgbAccordion directive.",
                    "com.jwebmp.plugins.bootstrap.accordion",
                    List.of(
                            new PluginEntry.PropertyInfo("closeOthers", "boolean", "false", "Only allow one panel open at a time"),
                            new PluginEntry.PropertyInfo("destroyOnHide", "boolean", "false", "Destroy hidden panel content to free resources")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Accordion",
                                    "Create an accordion with two collapsible panels.",
                                    "var accordion = new BSAccordion<>();\naccordion.setCloseOthers(true);\n\nvar item1 = new BSAccordionItem<>();\nitem1.addHeader(new BSAccordionPanelHeader<>().setText(\"Section 1\"));\nitem1.addContent(new BSAccordionPanelContent<>().setText(\"Content 1\"));\nitem1.setActive(true);\n\nvar item2 = new BSAccordionItem<>();\nitem2.addHeader(new BSAccordionPanelHeader<>().setText(\"Section 2\"));\nitem2.addContent(new BSAccordionPanelContent<>().setText(\"Content 2\"));\n\naccordion.addItem(item1);\naccordion.addItem(item2);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSAccordion<>()", "Creates a new accordion container")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addItem", "J", "addItem(BSAccordionItem<?> item)", "Adds an accordion item panel"),
                            new PluginEntry.MethodInfo("addPanel", "J", "addPanel(String panelId, BSAccordionPanelHeader<?> header, BSAccordionPanelContent<?> content, boolean active)", "Adds a complete panel with header, content, and active state"),
                            new PluginEntry.MethodInfo("setCloseOthers", "J", "setCloseOthers(boolean closeOthers)", "Sets whether only one panel can be open at a time"),
                            new PluginEntry.MethodInfo("setDestroyOnHide", "J", "setDestroyOnHide(boolean destroyOnHide)", "Sets whether hidden panel content is destroyed")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSAccordion", "INgComponent")
            ),
            // ── BSAlert ──
            new PluginEntry.ComponentInfo("BSAlert",
                    "Single dismissible alert message with contextual styling. Pre-styled variants include BSAlertPrimary, BSAlertSuccess, BSAlertDanger, BSAlertWarning, BSAlertInfo, BSAlertDark, BSAlertLight, and BSAlertSecondary.",
                    "com.jwebmp.plugins.bootstrap.alerts",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Contextual Alert",
                                    "Use a pre-styled variant for quick alerts.",
                                    "var alert = new BSAlertDanger<>();\nalert.setText(\"Something went wrong!\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSAlert<>()", "Creates a plain alert div"),
                            new PluginEntry.ConstructorInfo("new BSAlertDanger<>()", "Creates a danger-styled alert"),
                            new PluginEntry.ConstructorInfo("new BSAlertSuccess<>()", "Creates a success-styled alert")
                    ),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of("IBSAlerts")
            ),
            // ── BSBadge ──
            new PluginEntry.ComponentInfo("BSBadge",
                    "Inline badge labels with contextual colour variants. Pre-styled variants include BSBadgePrimary, BSBadgeSuccess, BSBadgeDanger, BSBadgeWarning, BSBadgeInfo, BSBadgeDark, BSBadgeLight, and BSBadgeSecondary.",
                    "com.jwebmp.plugins.bootstrap.badge",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Primary Badge",
                                    "Create a primary-coloured badge.",
                                    "var badge = new BSBadgePrimary<>();\nbadge.setText(\"New\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSBadge<>()", "Creates a plain badge span"),
                            new PluginEntry.ConstructorInfo("new BSBadgePrimary<>()", "Creates a primary-coloured badge")
                    ),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of("IBSBadge")
            ),
            // ── BSBreadcrumbContainer ──
            new PluginEntry.ComponentInfo("BSBreadcrumbContainer",
                    "Breadcrumb navigation trail. Contains BSBreadCrumbItem entries with optional links.",
                    "com.jwebmp.plugins.bootstrap.breadcrumbs",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Simple Breadcrumb",
                                    "Create a two-level breadcrumb.",
                                    "var bc = new BSBreadcrumbContainer<>();\nvar crumb = new BSBreadCrumb<>();\ncrumb.add(new BSBreadCrumbItem<>(new BSBreadCrumbLink<>(\"Home\", \"/\")));\ncrumb.add(new BSBreadCrumbItem<>().setText(\"Current Page\"));\nbc.add(crumb);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSBreadcrumbContainer<>()", "Creates a breadcrumb nav container")),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of("IBSBreadCrumb")
            ),
            // ── BSButton ──
            new PluginEntry.ComponentInfo("BSButton",
                    "Enhanced buttons with size, colour, outline, and pressed states. Pre-styled variants include BSButtonPrimary, BSButtonDanger, BSButtonSuccess, BSButtonWarning, etc., plus outline versions.",
                    "com.jwebmp.plugins.bootstrap.buttons",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Primary Button",
                                    "Create a primary-styled button.",
                                    "var btn = new BSButton<>(\"Click Me\");\nbtn.setPrimary(true);\nbtn.setSize(BSButtonSizeOptions.Btn_Lg);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Outline Button",
                                    "Create a danger outline button.",
                                    "var btn = new BSButtonDangerOutline<>();\nbtn.setText(\"Delete\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSButton<>()", "Creates a default button"),
                            new PluginEntry.ConstructorInfo("new BSButton<>(String text)", "Creates a button with the given text")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setPrimary", "J", "setPrimary(boolean applyStyle)", "Applies or removes primary colour style"),
                            new PluginEntry.MethodInfo("setSecondary", "J", "setSecondary(boolean applyStyle)", "Applies or removes secondary colour style"),
                            new PluginEntry.MethodInfo("setSuccess", "J", "setSuccess(boolean applyStyle)", "Applies or removes success colour style"),
                            new PluginEntry.MethodInfo("setDanger", "J", "setDanger(boolean applyStyle)", "Applies or removes danger colour style"),
                            new PluginEntry.MethodInfo("setWarning", "J", "setWarning(boolean applyStyle)", "Applies or removes warning colour style"),
                            new PluginEntry.MethodInfo("setInfo", "J", "setInfo(boolean applyStyle)", "Applies or removes info colour style"),
                            new PluginEntry.MethodInfo("setPrimaryOutline", "J", "setPrimaryOutline(boolean applyStyle)", "Applies or removes primary outline style"),
                            new PluginEntry.MethodInfo("setSecondaryOutline", "J", "setSecondaryOutline(boolean applyStyle)", "Applies or removes secondary outline style"),
                            new PluginEntry.MethodInfo("setDangerOutline", "J", "setDangerOutline(boolean applyStyle)", "Applies or removes danger outline style"),
                            new PluginEntry.MethodInfo("setSuccessOutline", "J", "setSuccessOutline(boolean applyStyle)", "Applies or removes success outline style"),
                            new PluginEntry.MethodInfo("setWarningOutline", "J", "setWarningOutline(boolean applyStyle)", "Applies or removes warning outline style"),
                            new PluginEntry.MethodInfo("setInfoOutline", "J", "setInfoOutline(boolean applyStyle)", "Applies or removes info outline style"),
                            new PluginEntry.MethodInfo("setSize", "J", "setSize(BSButtonSizeOptions size)", "Sets button size (Btn_Lg, Btn_Sm)"),
                            new PluginEntry.MethodInfo("setDisabled", "J", "setDisabled(boolean disabled)", "Disables the button with aria attributes"),
                            new PluginEntry.MethodInfo("setPressed", "J", "setPressed(boolean pressed)", "Sets the active/pressed state"),
                            new PluginEntry.MethodInfo("setToggle", "J", "setToggle(boolean toggle)", "Enables toggle behaviour via data-toggle"),
                            new PluginEntry.MethodInfo("setLink", "J", "setLink(boolean applyStyle)", "Styles the button as a link")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSButton")
            ),
            // ── BSButtonGroup ──
            new PluginEntry.ComponentInfo("BSButtonGroup",
                    "Button groups, toolbars, checkbox and radio button sets.",
                    "com.jwebmp.plugins.bootstrap.buttons.groups",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Button Group",
                                    "Group several buttons together.",
                                    "var group = new BSButtonGroup<>();\ngroup.add(new BSButtonPrimary<>().setText(\"Left\"));\ngroup.add(new BSButtonPrimary<>().setText(\"Middle\"));\ngroup.add(new BSButtonPrimary<>().setText(\"Right\"));",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSButtonGroup<>()", "Creates a horizontal button group")),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of("IBSButtonGroup")
            ),
            // ── BSCheckBox ──
            new PluginEntry.ComponentInfo("BSCheckBox",
                    "Styled checkbox inputs with contextual colour variants. Pre-styled variants include BSCheckBoxPrimary, BSCheckBoxDanger, BSCheckBoxSuccess, etc.",
                    "com.jwebmp.plugins.bootstrap.buttons.checkbox",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Checkbox Group",
                                    "Create a group of styled checkboxes.",
                                    "var group = new BSCheckBoxGroup<>();\ngroup.setForm(myForm);\ngroup.addLabel(\"Accept Terms\");\nvar input = new InputCheckBoxType<>();\ngroup.setInput(input);\ninput.bind(\"acceptTerms\");",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSCheckBox<>()", "Creates a styled checkbox")),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of()
            ),
            // ── BSRadioButton ──
            new PluginEntry.ComponentInfo("BSRadioButton",
                    "Styled radio button inputs with colour variants. Pre-styled variants include BSRadioButtonPrimary, BSRadioButtonDanger, BSRadioButtonSuccess, etc.",
                    "com.jwebmp.plugins.bootstrap.buttons.radio",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Radio Button Group",
                                    "Create a radio button group.",
                                    "var group = new BSRadioButtonGroup<>();\ngroup.setForm(myForm);\ngroup.addLabel(\"Option A\");\nvar input = new InputRadioType<>();\ninput.setGroup(\"options\");\ngroup.setInput(input);\ninput.bind(\"selectedOption\");",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSRadioButton<>()", "Creates a styled radio button")),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of()
            ),
            // ── BSSwitch ──
            new PluginEntry.ComponentInfo("BSSwitch",
                    "Toggle switch styled as a Bootstrap custom switch. Extends BSFormGroup with a checkbox input rendered as a switch.",
                    "com.jwebmp.plugins.bootstrap.buttons.switches",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Switch",
                                    "Create a toggle switch inside a form.",
                                    "var switchGroup = new BSCustomSwitchGroup<>(\"Enable Notifications\");\nvar input = new InputCheckBoxType<>();\nswitchGroup.setInput(input);\ninput.bind(\"notifications\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSCustomSwitchGroup<>()", "Creates a switch toggle group"),
                            new PluginEntry.ConstructorInfo("new BSCustomSwitchGroup<>(String label)", "Creates a switch with a label")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addLabel", "BSFormLabel<?>", "addLabel(String text)", "Adds a label with custom-control-label styling"),
                            new PluginEntry.MethodInfo("setInput", "InputCheckBoxType<?>", "setInput(InputCheckBoxType<?> input)", "Sets the checkbox input with custom-control-input styling"),
                            new PluginEntry.MethodInfo("setCustomControl", "J", "setCustomControl(boolean inline)", "Applies custom switch classes; if inline, adds inline layout"),
                            new PluginEntry.MethodInfo("setInline", "J", "setInline(boolean inline)", "Displays the switch inline on the same horizontal row"),
                            new PluginEntry.MethodInfo("setDisabled", "J", "setDisabled(boolean disabled)", "Disables the switch input")
                    ),
                    List.of(), List.of(),
                    List.of("BSFormGroup")
            ),
            // ── BSCard ──
            new PluginEntry.ComponentInfo("BSCard",
                    "Flexible content container with header, body, footer, images, list groups, and themed variants. Replaces the old panels, wells, and thumbnails.",
                    "com.jwebmp.plugins.bootstrap.cards",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Card with Header and Body",
                                    "Create a card with a header, body text, and footer.",
                                    "var card = new BSCard<>();\ncard.addCardHeader(\"Featured\");\nvar body = card.addCardBody();\nbody.addTitle(HeaderTypes.H5, \"Card Title\");\nbody.addText(\"Some quick example text.\");\ncard.addFooter(\"Last updated 3 mins ago\");",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Image Card with Overlay",
                                    "Create a card with a top image and overlay text.",
                                    "var card = new BSCard<>();\ncard.addCardImageTop(\"/images/banner.jpg\");\ncard.addCardImageOverlay(\"Title\", \"Subtitle\", \"Overlay text here.\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSCard<>()", "Creates a card container"),
                            new PluginEntry.ConstructorInfo("new BSCard<>(String text)", "Creates a card with the given text"),
                            new PluginEntry.ConstructorInfo("new BSCard<>(boolean inverse)", "Creates an inverse-styled card")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addCardHeader", "BSCardHeader<?>", "addCardHeader(String text)", "Adds a text header to the card"),
                            new PluginEntry.MethodInfo("addCardBody", "BSCardBody<?>", "addCardBody()", "Adds and returns a card body section"),
                            new PluginEntry.MethodInfo("addCardText", "BSCardText<?>", "addCardText(String text)", "Adds a paragraph of text"),
                            new PluginEntry.MethodInfo("addFooter", "BSCardFooter<?>", "addFooter(String text)", "Adds a text footer"),
                            new PluginEntry.MethodInfo("addCardImageTop", "BSCardImageTop<?>", "addCardImageTop(String url)", "Adds a top image"),
                            new PluginEntry.MethodInfo("addCardImageBottom", "BSCardImageBottom<?>", "addCardImageBottom(String url)", "Adds a bottom image"),
                            new PluginEntry.MethodInfo("addCardImageOverlay", "BSCardImageOverlay<?>", "addCardImageOverlay(String title, String subTitle, String... paragraphs)", "Adds an image overlay with title and text"),
                            new PluginEntry.MethodInfo("addListGroup", "BSListGroup<?>", "addListGroup(List&lt;BSListGroupListItem&lt;?&gt;&gt; items)", "Adds a list group to the card"),
                            new PluginEntry.MethodInfo("setTextCenter", "J", "setTextCenter(boolean center)", "Centers the card text"),
                            new PluginEntry.MethodInfo("setTextRight", "J", "setTextRight(boolean right)", "Right-aligns the card text"),
                            new PluginEntry.MethodInfo("addBackground", "J", "addBackground(BSBackgroundOptions bg)", "Sets the background colour"),
                            new PluginEntry.MethodInfo("addForeground", "J", "addForeground(BSColoursOptions color)", "Sets the text colour"),
                            new PluginEntry.MethodInfo("addMargin", "J", "addMargin(BSMarginOptions margin)", "Adds margin spacing"),
                            new PluginEntry.MethodInfo("addPadding", "J", "addPadding(BSPaddingOptions padding)", "Adds padding"),
                            new PluginEntry.MethodInfo("addBorder", "J", "addBorder(BSBorderOptions border)", "Sets the border style")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSCard", "IBSLayout")
            ),
            // ── BSCarousel ──
            new PluginEntry.ComponentInfo("BSCarousel",
                    "Slideshow component for cycling through images or slides of text. Uses ng-bootstrap NgbCarousel with navigation, indicators, and pause controls.",
                    "com.jwebmp.plugins.bootstrap.carousel",
                    List.of(
                            new PluginEntry.PropertyInfo("showNavigationArrows", "Boolean", "null", "Show or hide navigation arrows"),
                            new PluginEntry.PropertyInfo("showNavigationIndicators", "Boolean", "null", "Show or hide slide indicators"),
                            new PluginEntry.PropertyInfo("interval", "Integer", "null", "Time in ms between automatic slide transitions"),
                            new PluginEntry.PropertyInfo("pauseOnHover", "Boolean", "null", "Pause cycling when hovering over the carousel"),
                            new PluginEntry.PropertyInfo("pauseOnFocus", "Boolean", "null", "Pause cycling when the carousel is focused")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Image Carousel",
                                    "Create a carousel with slides and auto-cycling.",
                                    "var carousel = new MyCarousel();\ncarousel.setInterval(3000);\ncarousel.setShowNavigationArrows(true);\ncarousel.setShowNavigationIndicators(true);\n\nvar slide1 = new BSCarouselSlide<>();\nslide1.add(new Image<>(\"/images/slide1.jpg\"));\n\nvar slide2 = new BSCarouselSlide<>();\nslide2.add(new Image<>(\"/images/slide2.jpg\"));\n\ncarousel.addSlide(slide1);\ncarousel.addSlide(slide2);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSCarousel<>()", "Creates a carousel container (abstract — extend this class)")),
                    List.of(
                            new PluginEntry.MethodInfo("addSlide", "J", "addSlide(BSCarouselSlide<?> slide)", "Adds a slide to the carousel"),
                            new PluginEntry.MethodInfo("setShowNavigationArrows", "J", "setShowNavigationArrows(Boolean show)", "Shows or hides navigation arrows"),
                            new PluginEntry.MethodInfo("setShowNavigationIndicators", "J", "setShowNavigationIndicators(Boolean show)", "Shows or hides slide indicators"),
                            new PluginEntry.MethodInfo("setInterval", "J", "setInterval(Integer interval)", "Sets the auto-cycle interval in milliseconds"),
                            new PluginEntry.MethodInfo("setPauseOnHover", "J", "setPauseOnHover(Boolean pause)", "Pauses cycling on hover"),
                            new PluginEntry.MethodInfo("setPauseOnFocus", "J", "setPauseOnFocus(Boolean pause)", "Pauses cycling on focus")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSCarousel", "INgComponent")
            ),
            // ── BSCloseIcon ──
            new PluginEntry.ComponentInfo("BSCloseIcon",
                    "Close/dismiss button typically used inside modals, alerts, and toasts. Renders a small × icon button.",
                    "com.jwebmp.plugins.bootstrap.close",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Close Button in Alert",
                                    "Add a close icon to a dismissible alert.",
                                    "var alert = new BSAlertDanger<>();\nalert.setText(\"Error occurred!\");\nvar close = new BSCloseIcon<>();\nalert.add(close);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSCloseIcon<>()", "Creates a close icon button")),
                    List.of(), List.of(), List.of(), List.of()
            ),
            // ── BSCollapse ──
            new PluginEntry.ComponentInfo("BSCollapse",
                    "Toggle visibility of elements with animation. Provides a static link() method to wire a toggler to collapsible content.",
                    "com.jwebmp.plugins.bootstrap.collapse",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Collapse Toggle",
                                    "Link a button to a collapsible div.",
                                    "var toggler = new BSButton<>(\"Toggle\");\nvar content = new Div<>();\ncontent.setText(\"Collapsible content here.\");\nBSCollapse.link(toggler, content, true);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSCollapse<>()", "Creates a collapse container")),
                    List.of(
                            new PluginEntry.MethodInfo("link", "void", "BSCollapse.link(toggler, content, collapsed)", "Static method to wire a toggler to collapsible content")
                    ),
                    List.of(),
                    List.of(),
                    List.of()
            ),
            // ── BSContainer ──
            new PluginEntry.ComponentInfo("BSContainer",
                    "Responsive layout containers. Use BSContainerOptions for fixed-width or fluid-width variants. Also provides BSRow and BSColumn for grid layouts.",
                    "com.jwebmp.plugins.bootstrap.containers",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Fluid Container with Row",
                                    "Create a fluid container with a row and columns.",
                                    "var container = new BSContainer<>(BSContainerOptions.Container_Fluid);\nvar row = new BSRow<>();\nrow.add(new BSColumn<>().setText(\"Column 1\"));\nrow.add(new BSColumn<>().setText(\"Column 2\"));\ncontainer.add(row);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSContainer<>()", "Creates a default container"),
                            new PluginEntry.ConstructorInfo("new BSContainer<>(BSContainerOptions option)", "Creates a container with the given option (e.g. Container_Fluid)")
                    ),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of()
            ),
            // ── BSDatePicker ──
            new PluginEntry.ComponentInfo("BSDatePicker",
                    "Date selection widget backed by ng-bootstrap NgbDatepicker. Renders a calendar popup for date input.",
                    "com.jwebmp.plugins.bootstrap.datepicker",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Date Picker",
                                    "Add a date picker to a form.",
                                    "var datePicker = new BSDatePicker<>();\nform.add(datePicker);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSDatePicker<>()", "Creates a date picker input")),
                    List.of(), List.of(), List.of(), List.of()
            ),
            // ── BSDropDown ──
            new PluginEntry.ComponentInfo("BSDropDown",
                    "Toggleable dropdown menus with Popper.js positioning. Uses ng-bootstrap NgbDropdown directive.",
                    "com.jwebmp.plugins.bootstrap.dropdown",
                    List.of(
                            new PluginEntry.PropertyInfo("placement", "BSPlacements", "null", "Dropdown placement (e.g. bottom-left, top-right)"),
                            new PluginEntry.PropertyInfo("bodyContainer", "boolean", "false", "Append dropdown to body for overflow handling"),
                            new PluginEntry.PropertyInfo("dynamic", "boolean", "false", "Enable dynamic positioning")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Simple Dropdown",
                                    "Create a dropdown with menu items.",
                                    "var dropdown = new BSDropDown<>();\ndropdown.setText(\"Options\");\ndropdown.addItem(\"Action\");\ndropdown.addItem(\"Another action\");\ndropdown.addItem(\"Something else\");",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Dropdown with Placement",
                                    "Position the dropdown above the toggle.",
                                    "var dropdown = new BSDropDown<>();\ndropdown.setText(\"Dropup\");\ndropdown.setPlacement(BSPlacements.Top);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSDropDown<>()", "Creates a dropdown container with button and menu")),
                    List.of(
                            new PluginEntry.MethodInfo("setText", "J", "setText(String text)", "Sets the dropdown toggle button text"),
                            new PluginEntry.MethodInfo("addItem", "J", "addItem(String text)", "Adds a text menu item"),
                            new PluginEntry.MethodInfo("addItem", "J", "addItem(IComponentHierarchyBase&lt;?,?&gt; component)", "Adds a component as a menu item"),
                            new PluginEntry.MethodInfo("asLink", "J", "asLink()", "Renders the toggle as a link instead of a button"),
                            new PluginEntry.MethodInfo("setPlacement", "J", "setPlacement(BSPlacements placement)", "Sets the dropdown placement"),
                            new PluginEntry.MethodInfo("setBodyContainer", "J", "setBodyContainer(boolean bodyContainer)", "Appends dropdown to body"),
                            new PluginEntry.MethodInfo("setDynamic", "J", "setDynamic(boolean dynamic)", "Enables dynamic positioning"),
                            new PluginEntry.MethodInfo("getDropDownMenu", "BSDropDownMenu<?>", "getDropDownMenu()", "Returns the dropdown menu component"),
                            new PluginEntry.MethodInfo("getDropDownButton", "Button&lt;?,?,?,?,?&gt;", "getDropDownButton()", "Returns the toggle button")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSDropDown", "INgComponent")
            ),
            // ── BSFigure ──
            new PluginEntry.ComponentInfo("BSFigure",
                    "HTML5 figure element with optional caption for displaying images and media with descriptive text.",
                    "com.jwebmp.plugins.bootstrap.figures",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Figure with Caption",
                                    "Create a figure with an image and caption.",
                                    "var figure = new BSFigure<>();\nvar img = new BSImage<>();\nfigure.add(img);\nvar caption = new BSFigureCaption<>();\ncaption.setText(\"A descriptive caption.\");\nfigure.add(caption);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSFigure<>()", "Creates a figure element")),
                    List.of(), List.of(), List.of(), List.of()
            ),
            // ── BSFileUpload ──
            new PluginEntry.ComponentInfo("BSFileUpload",
                    "Custom file input control with Bootstrap styling. Displays selected filename in a label.",
                    "com.jwebmp.plugins.bootstrap.fileupload",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("File Upload",
                                    "Add a file upload input to a form.",
                                    "var upload = new BSFileUpload<>();\nform.add(upload);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSFileUpload<>()", "Creates a file upload input")),
                    List.of(), List.of(), List.of(), List.of()
            ),
            // ── BSForm ──
            new PluginEntry.ComponentInfo("BSForm",
                    "Form component with groups, input sets, controls, validation, and Angular reactive form binding. Provides factory methods for all standard input types.",
                    "com.jwebmp.plugins.bootstrap.forms",
                    List.of(
                            new PluginEntry.PropertyInfo("styleInputs", "boolean", "false", "Apply Bootstrap styling classes to all inputs on render")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Login Form",
                                    "Create a form with email and password fields.",
                                    "var form = new BSForm<>(\"loginForm\", myDataProvider);\n\nvar email = form.createEmailInput(\"email\", \"Email Address\");\nform.add(email);\n\nvar pwd = form.createPasswordInput(\"password\", \"Password\", true);\nform.add(pwd);\n\nvar submit = form.createSubmitButton();\nsubmit.setText(\"Sign In\");\nsubmit.setPrimary(true);\nform.add(submit);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSForm<>(String id, INgServiceProvider<?> formDataProvider)", "Creates a form with id and data provider")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("createTextInput", "BSFormGroup", "createTextInput(String binding, String label)", "Creates a text input group"),
                            new PluginEntry.MethodInfo("createEmailInput", "BSFormGroup", "createEmailInput(String binding, String label)", "Creates an email input group"),
                            new PluginEntry.MethodInfo("createPasswordInput", "BSFormInputGroup", "createPasswordInput(String binding, String label, boolean inputGroup)", "Creates a password input group"),
                            new PluginEntry.MethodInfo("createTextArea", "BSFormGroup", "createTextArea(String binding, String label)", "Creates a textarea group"),
                            new PluginEntry.MethodInfo("createSearchInput", "BSFormGroup", "createSearchInput(String binding, String label)", "Creates a search input group"),
                            new PluginEntry.MethodInfo("createSelectDropdown", "BSFormGroup", "createSelectDropdown(String binding, String label)", "Creates a select dropdown group"),
                            new PluginEntry.MethodInfo("createCheckboxInput", "BSCheckBoxGroup", "createCheckboxInput(String binding, String label)", "Creates a checkbox input group"),
                            new PluginEntry.MethodInfo("createRadioInput", "BSRadioButtonGroup", "createRadioInput(String binding, String label, String groupName)", "Creates a radio button group"),
                            new PluginEntry.MethodInfo("createFileInput", "BSFormGroup", "createFileInput(String binding, String label)", "Creates a file input group"),
                            new PluginEntry.MethodInfo("createNumberInput", "BSFormGroup", "createNumberInput(String binding, String label)", "Creates a number input group"),
                            new PluginEntry.MethodInfo("createDateInput", "BSFormGroup", "createDateInput(String binding, String label)", "Creates a date input group"),
                            new PluginEntry.MethodInfo("createTimeInput", "BSFormGroup", "createTimeInput(String binding, String label)", "Creates a time input group"),
                            new PluginEntry.MethodInfo("createUrlInput", "BSFormGroup", "createUrlInput(String binding, String label)", "Creates a URL input group"),
                            new PluginEntry.MethodInfo("createTelephoneInput", "BSFormGroup", "createTelephoneInput(String binding, String label)", "Creates a telephone input group"),
                            new PluginEntry.MethodInfo("createColourInput", "BSFormInputGroup", "createColourInput(String binding, String label)", "Creates a colour picker input"),
                            new PluginEntry.MethodInfo("createSubmitButton", "BSButton<?>", "createSubmitButton()", "Creates a submit button"),
                            new PluginEntry.MethodInfo("createCancelButton", "BSButton<?>", "createCancelButton()", "Creates a cancel button"),
                            new PluginEntry.MethodInfo("createResetButton", "BSButton<?>", "createResetButton()", "Creates a reset button"),
                            new PluginEntry.MethodInfo("createFormRow", "BSForm<?>", "createFormRow()", "Creates a horizontal form row"),
                            new PluginEntry.MethodInfo("createFieldSet", "BSFieldSet<?>", "createFieldSet(boolean disableOnOperation)", "Creates a fieldset, optionally disabled during operations"),
                            new PluginEntry.MethodInfo("setInline", "J", "setInline(boolean inline)", "Displays the form inline"),
                            new PluginEntry.MethodInfo("setHorizontal", "J", "setHorizontal(boolean horizontal)", "Applies horizontal form layout"),
                            new PluginEntry.MethodInfo("setAlignment", "J", "setAlignment(BSAlignmentVerticalOptions layout)", "Sets auto-sizing alignment"),
                            new PluginEntry.MethodInfo("setStyleInput", "J", "setStyleInput(boolean styleInput)", "Enables Bootstrap input styling classes")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSForm")
            ),
            // ── BSImage ──
            new PluginEntry.ComponentInfo("BSImage",
                    "Responsive image component with Bootstrap utility classes for fluid sizing and thumbnail styling.",
                    "com.jwebmp.plugins.bootstrap.images",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Responsive Image",
                                    "Create a responsive fluid image.",
                                    "var img = new BSImage<>(\"/images/photo.jpg\");\nimg.addClass(\"img-fluid\");",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSImage<>()", "Creates a responsive image")),
                    List.of(), List.of(), List.of(),
                    List.of("IBSImage")
            ),
            // ── BSJumbotron ──
            new PluginEntry.ComponentInfo("BSJumbotron",
                    "Hero section for showcasing key content with large padding and rounded corners. Ideal for marketing pages and call-to-action banners.",
                    "com.jwebmp.plugins.bootstrap.jumbotron",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Hero Section",
                                    "Create a jumbotron with a heading and text.",
                                    "var jumbo = new BSJumbotron<>();\njumbo.add(new H1<>().setText(\"Hello, world!\"));\njumbo.add(new Paragraph<>().setText(\"This is a simple hero unit.\"));",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSJumbotron<>()", "Creates a jumbotron container")),
                    List.of(), List.of(), List.of(),
                    List.of("IBSJumbotron")
            ),
            // ── BSListGroup ──
            new PluginEntry.ComponentInfo("BSListGroup",
                    "Flexible list group with active, disabled, and contextual items. Supports list items, link items, and button items.",
                    "com.jwebmp.plugins.bootstrap.listgroup",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("List Group",
                                    "Create a simple list group.",
                                    "var list = new BSListGroup<>();\nlist.add(new BSListGroupListItem<>().setText(\"Item 1\"));\nlist.add(new BSListGroupListItem<>().setText(\"Item 2\"));\nlist.add(new BSListGroupListItem<>().setText(\"Item 3\"));",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSListGroup<>()", "Creates a list group")),
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of("IBSListGroup")
            ),
            // ── BSMedia ──
            new PluginEntry.ComponentInfo("BSMedia",
                    "Media object for aligning images or icons alongside textual content. Common for comment threads, tweets, and list items.",
                    "com.jwebmp.plugins.bootstrap.media",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Media Object",
                                    "Create a media object with image and text.",
                                    "var media = new BSMedia<>();\nvar img = new BSImage<>(\"/images/avatar.jpg\");\nmedia.add(img);\nvar body = new Div<>();\nbody.setText(\"Media body content here.\");\nmedia.add(body);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSMedia<>()", "Creates a media object")),
                    List.of(), List.of(), List.of(),
                    List.of("IBSMedia")
            ),
            // ── BSModal ──
            new PluginEntry.ComponentInfo("BSModal",
                    "Modal dialog with show/hide events, header/body/footer parts, and ng-bootstrap NgbModal integration. Supports backdrop, centering, keyboard dismiss, sizing, and fullscreen mode.",
                    "com.jwebmp.plugins.bootstrap.modal",
                    List.of(
                            new PluginEntry.PropertyInfo("backdrop", "boolean", "true", "Show a backdrop behind the modal"),
                            new PluginEntry.PropertyInfo("backdropStatic", "boolean", "false", "Prevent closing when clicking the backdrop"),
                            new PluginEntry.PropertyInfo("centered", "boolean", "false", "Vertically center the modal"),
                            new PluginEntry.PropertyInfo("fullScreen", "boolean", "false", "Display as a fullscreen modal"),
                            new PluginEntry.PropertyInfo("fullScreenBelow", "BSSizes", "null", "Fullscreen only below this breakpoint"),
                            new PluginEntry.PropertyInfo("keyboard", "boolean", "true", "Allow closing with the Escape key"),
                            new PluginEntry.PropertyInfo("size", "BSSizes", "null", "Modal size (Small, Large, ExtraLarge)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Modal",
                                    "Create and open a modal dialog.",
                                    "var modal = new BSModal<>();\nmodal.getModalHeader().addTitle(\"Confirm\");\nmodal.getModalBody().setText(\"Are you sure?\");\n\nvar footer = modal.getModalFooter();\nvar closeBtn = new BSButton<>(\"Close\");\nmodal.setCloseButton(closeBtn);\nfooter.add(closeBtn);\n\n// Wire an open button\nvar openBtn = new BSButton<>(\"Open Modal\");\nmodal.setOpenButton(openBtn);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSModal<>()", "Creates a modal dialog (rendered as ng-template)")),
                    List.of(
                            new PluginEntry.MethodInfo("getModalHeader", "BSModalHeader<?>", "getModalHeader()", "Gets or creates the modal header"),
                            new PluginEntry.MethodInfo("getModalBody", "BSModalBody<?>", "getModalBody()", "Gets or creates the modal body"),
                            new PluginEntry.MethodInfo("getModalFooter", "BSModalFooter<?>", "getModalFooter()", "Gets or creates the modal footer"),
                            new PluginEntry.MethodInfo("setCloseButton", "T", "setCloseButton(T component)", "Wires a component as the modal close button"),
                            new PluginEntry.MethodInfo("setOpenButton", "T", "setOpenButton(T component)", "Wires a component as the modal open trigger"),
                            new PluginEntry.MethodInfo("setBackdrop", "J", "setBackdrop(boolean backdrop)", "Enables or disables the backdrop"),
                            new PluginEntry.MethodInfo("setBackdropStatic", "J", "setBackdropStatic(boolean backdropStatic)", "Prevents closing on backdrop click"),
                            new PluginEntry.MethodInfo("setCentered", "J", "setCentered(boolean centered)", "Centers the modal vertically"),
                            new PluginEntry.MethodInfo("setFullScreen", "J", "setFullScreen(boolean fullScreen)", "Makes the modal fullscreen"),
                            new PluginEntry.MethodInfo("setKeyboard", "J", "setKeyboard(boolean keyboard)", "Enables or disables Escape key dismiss"),
                            new PluginEntry.MethodInfo("setSize", "J", "setSize(BSSizes size)", "Sets the modal size")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSModal", "INgComponent")
            ),
            // ── BSNavBar ──
            new PluginEntry.ComponentInfo("BSNavBar",
                    "Responsive navigation bar with brand, toggler, collapse, colour schemes, and positioning. Wraps content in a BSContainer with a collapsible section.",
                    "com.jwebmp.plugins.bootstrap.navbar",
                    List.of(
                            new PluginEntry.PropertyInfo("menuCollapsed", "boolean", "true", "Whether the menu starts collapsed"),
                            new PluginEntry.PropertyInfo("collapsedFieldName", "String", "isMenuCollapsed", "Angular field name for the collapsed state")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Navbar with Brand and Links",
                                    "Create a responsive navbar with brand and navigation links.",
                                    "var navbar = new BSNavBar<>();\nnavbar.setNavBarTheme(BSNavBarColourSchemes.Navbar_Dark);\nnavbar.addBackground(BSBackgroundOptions.Bg_Dark);\nnavbar.setCollapseWhen(BSSizes.Large);\n\nnavbar.addBrand(\"My App\");\nnavbar.addToggle();\n\nvar navs = new BSNavBarNavs<>();\nnavs.addItem(\"Home\", \"/home\", true);\nnavs.addItem(\"About\", \"/about\", false);\nnavbar.addNavs(navs);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSNavBar<>()", "Creates a navbar with fluid container"),
                            new PluginEntry.ConstructorInfo("new BSNavBar<>(String collapsedFieldName)", "Creates a navbar with a custom collapsed field name")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addBrand", "BSNavBarBrand<?>", "addBrand(String brandName)", "Adds a text brand"),
                            new PluginEntry.MethodInfo("addBrand", "BSNavBarBrand<?>", "addBrand(String brandName, String brandImage)", "Adds a brand with name and image"),
                            new PluginEntry.MethodInfo("addBrandImage", "BSNavBarBrand<?>", "addBrandImage(String brandImage)", "Adds a brand with image only"),
                            new PluginEntry.MethodInfo("addToggle", "BSNavBarToggleButton<?>", "addToggle()", "Adds a hamburger toggle button"),
                            new PluginEntry.MethodInfo("addToggleWithContainer", "BSNavBarToggleContainer<?>", "addToggleWithContainer()", "Adds a toggle with collapsible container"),
                            new PluginEntry.MethodInfo("addNavs", "J", "addNavs(BSNavBarNavs<?> navigation)", "Adds navigation links to the collapsible area"),
                            new PluginEntry.MethodInfo("addForm", "BSForm<?>", "addForm()", "Adds an inline form to the navbar"),
                            new PluginEntry.MethodInfo("addText", "BSNavBarText", "addText(String text)", "Adds inline text"),
                            new PluginEntry.MethodInfo("addHeaderText", "BSNavBarHeaderSpan&lt;?,?&gt;", "addHeaderText(String text)", "Adds header text"),
                            new PluginEntry.MethodInfo("addPositioning", "J", "addPositioning(BSNavBarPositioning position)", "Sets fixed-top, fixed-bottom, or sticky-top"),
                            new PluginEntry.MethodInfo("setNavBarTheme", "J", "setNavBarTheme(BSNavBarColourSchemes schemes)", "Sets the navbar colour scheme (light or dark)"),
                            new PluginEntry.MethodInfo("setCollapseWhen", "J", "setCollapseWhen(BSSizes size)", "Sets the breakpoint for collapsing"),
                            new PluginEntry.MethodInfo("addBackground", "J", "addBackground(BSBackgroundOptions bg)", "Sets the background colour"),
                            new PluginEntry.MethodInfo("setColourTheme", "J", "setColourTheme(BSNavBarColourSchemes schemes)", "Alias for setNavBarTheme"),
                            new PluginEntry.MethodInfo("addToCollapsable", "J", "addToCollapsable(GlobalChildren child)", "Adds a child to the collapsible section")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSNavBar", "INgComponent")
            ),
            // ── BSNavs ──
            new PluginEntry.ComponentInfo("BSNavs",
                    "Navigation component supporting tabs, pills, vertical orientation, fill, and justified layouts. Uses ng-bootstrap NgbNav directive.",
                    "com.jwebmp.plugins.bootstrap.navs",
                    List.of(
                            new PluginEntry.PropertyInfo("pills", "boolean", "false", "Render nav items as pills instead of tabs"),
                            new PluginEntry.PropertyInfo("vertical", "boolean", "false", "Stack nav items vertically"),
                            new PluginEntry.PropertyInfo("animation", "boolean", "false", "Animate nav content transitions"),
                            new PluginEntry.PropertyInfo("destroyOnHide", "boolean", "false", "Destroy hidden tab content"),
                            new PluginEntry.PropertyInfo("activeId", "String", "null", "The id of the initially active nav item")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Tab Navigation",
                                    "Create a tabbed navigation.",
                                    "var navs = new BSNavs<>();\nnavs.setPills(false);\n\nvar tab1 = new BSNavItem<>();\ntab1.setText(\"Home\");\ntab1.setActive(true);\n\nvar tab2 = new BSNavItem<>();\ntab2.setText(\"Profile\");\n\nnavs.addTab(tab1);\nnavs.addTab(tab2);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Pill Navigation",
                                    "Create a pill-styled navigation.",
                                    "var navs = new BSNavs<>();\nnavs.setPills(true);\nnavs.setFill(true);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSNavs<>()", "Creates a nav component (tabs by default)")),
                    List.of(
                            new PluginEntry.MethodInfo("setPills", "J", "setPills(boolean pills)", "Renders items as pills instead of tabs"),
                            new PluginEntry.MethodInfo("setVertical", "J", "setVertical(boolean vertical)", "Stacks nav items vertically"),
                            new PluginEntry.MethodInfo("setAnimation", "J", "setAnimation(boolean animation)", "Enables animated transitions"),
                            new PluginEntry.MethodInfo("setDestroyOnHide", "J", "setDestroyOnHide(boolean destroy)", "Destroys hidden tab content"),
                            new PluginEntry.MethodInfo("setActiveId", "J", "setActiveId(String id)", "Sets the initially active nav item"),
                            new PluginEntry.MethodInfo("setFill", "J", "setFill(boolean fill)", "Fills all available horizontal space"),
                            new PluginEntry.MethodInfo("setEqualWidth", "J", "setEqualWidth(boolean equal)", "Forces equal-width nav items"),
                            new PluginEntry.MethodInfo("setHorizontalAlignment", "J", "setHorizontalAlignment(BSAlignmentHorizontalOptions options)", "Sets horizontal alignment (center, right)"),
                            new PluginEntry.MethodInfo("addTab", "J", "addTab(BSNavItem<?> navItem)", "Adds a tab/pill item"),
                            new PluginEntry.MethodInfo("addDropDown", "J", "addDropDown(BSDropDown<?> dropDown)", "Adds a dropdown to the nav")
                    ),
                    List.of(), List.of(),
                    List.of("IBSNavs", "INgComponent")
            ),
            // ── BSPagination ──
            new PluginEntry.ComponentInfo("BSPagination",
                    "Pagination navigation with page links, sizing, and alignment options for multi-page content.",
                    "com.jwebmp.plugins.bootstrap.pagination",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Pagination",
                                    "Create a pagination with page links.",
                                    "var pagination = new BSPagination<>(BSPaginationSizingOptions.Pagination_Lg);\npagination.createPageLink(\"Previous\").setText(\"«\");\npagination.createPageLink(\"1\").setText(\"1\");\npagination.createPageLink(\"2\").setText(\"2\");\npagination.createPageLink(\"3\").setText(\"3\");\npagination.createPageLink(\"Next\").setText(\"»\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSPagination<>()", "Creates a default pagination"),
                            new PluginEntry.ConstructorInfo("new BSPagination<>(BSPaginationSizingOptions sizing)", "Creates with a size (Pagination_Lg, Pagination_Sm)"),
                            new PluginEntry.ConstructorInfo("new BSPagination<>(BSPaginationAlignmentOptions alignment)", "Creates with alignment (center, end)"),
                            new PluginEntry.ConstructorInfo("new BSPagination<>(BSPaginationSizingOptions sizing, BSPaginationAlignmentOptions alignment)", "Creates with both sizing and alignment")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("createPageLink", "BSPaginationLink<?>", "createPageLink(String ariaLabel)", "Creates a new pagination link with the given aria label"),
                            new PluginEntry.MethodInfo("getPageList", "BSPaginationList<?>", "getPageList()", "Returns the internal pagination list"),
                            new PluginEntry.MethodInfo("setPageList", "void", "setPageList(BSPaginationList<?> pageList)", "Replaces the pagination list")
                    ),
                    List.of(), List.of(),
                    List.of("IBSPagination")
            ),
            // ── BSPopOver ──
            new PluginEntry.ComponentInfo("BSPopOver",
                    "Configurable popovers with title, content, placement, triggers, animation, and auto-close behaviour. Uses ng-bootstrap NgbPopover directive.",
                    "com.jwebmp.plugins.bootstrap.popovers",
                    List.of(
                            new PluginEntry.PropertyInfo("animation", "boolean", "false", "Enable open/close animation"),
                            new PluginEntry.PropertyInfo("autoClose", "BSTriggers", "null", "Auto-close behaviour (inside, outside, true, false)"),
                            new PluginEntry.PropertyInfo("placement", "BSPlacements", "null", "Popover placement (top, bottom, left, right)"),
                            new PluginEntry.PropertyInfo("containInBody", "Boolean", "null", "Append popover to body element"),
                            new PluginEntry.PropertyInfo("disablePopover", "boolean", "false", "Disable the popover"),
                            new PluginEntry.PropertyInfo("openDelay", "Integer", "null", "Delay in ms before opening"),
                            new PluginEntry.PropertyInfo("closeDelay", "Integer", "null", "Delay in ms before closing"),
                            new PluginEntry.PropertyInfo("popoverClass", "String", "null", "Additional CSS class for the popover")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Simple Popover",
                                    "Add a popover with title and content.",
                                    "var popover = new BSPopOver<>();\npopover.setPopOverTitle(new BSPopOverTitle<>().setText(\"Info\"));\npopover.setPopOverContent(new BSPopOverContent<>().setText(\"Details here.\"));\npopover.setPlacement(BSPlacements.Top);\npopover.setAnimation(true);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSPopOver<>()", "Creates a popover container")),
                    List.of(
                            new PluginEntry.MethodInfo("setPopOverTitle", "J", "setPopOverTitle(BSPopOverTitle<?> title)", "Sets the popover title template"),
                            new PluginEntry.MethodInfo("setPopOverContent", "J", "setPopOverContent(BSPopOverContent<?> content)", "Sets the popover content template"),
                            new PluginEntry.MethodInfo("setPlacement", "J", "setPlacement(BSPlacements placement)", "Sets the popover placement"),
                            new PluginEntry.MethodInfo("setAnimation", "J", "setAnimation(boolean animation)", "Enables or disables animation"),
                            new PluginEntry.MethodInfo("setAutoClose", "J", "setAutoClose(BSTriggers autoClose)", "Sets auto-close behaviour"),
                            new PluginEntry.MethodInfo("setOpenDelay", "J", "setOpenDelay(Integer ms)", "Sets the open delay in milliseconds"),
                            new PluginEntry.MethodInfo("setCloseDelay", "J", "setCloseDelay(Integer ms)", "Sets the close delay in milliseconds"),
                            new PluginEntry.MethodInfo("setContainInBody", "J", "setContainInBody(boolean contain)", "Appends popover to body"),
                            new PluginEntry.MethodInfo("setDisablePopover", "J", "setDisablePopover(boolean disable)", "Disables the popover"),
                            new PluginEntry.MethodInfo("setPopoverClass", "J", "setPopoverClass(String cssClass)", "Adds a CSS class to the popover"),
                            new PluginEntry.MethodInfo("setTriggers", "J", "setTriggers(List&lt;BSTriggers&gt; triggers)", "Sets the trigger events")
                    ),
                    List.of(), List.of(),
                    List.of("IBSPopOver", "INgComponent")
            ),
            // ── BSProgressBar ──
            new PluginEntry.ComponentInfo("BSProgressBar",
                    "Progress bar with support for percentage values, striping, animation, stacking, colour types, value display, and custom height. Uses ng-bootstrap NgbProgressbar.",
                    "com.jwebmp.plugins.bootstrap.progressbar",
                    List.of(
                            new PluginEntry.PropertyInfo("percent", "Double", "null", "The current progress value"),
                            new PluginEntry.PropertyInfo("striped", "Boolean", "false", "Whether the bar is striped"),
                            new PluginEntry.PropertyInfo("animated", "Boolean", "null", "Whether the stripes are animated"),
                            new PluginEntry.PropertyInfo("max", "Integer", "null", "The maximum value"),
                            new PluginEntry.PropertyInfo("type", "BSColourTypes", "null", "The colour type (success, info, warning, danger)"),
                            new PluginEntry.PropertyInfo("textType", "BSColourTypes", "null", "The text colour type"),
                            new PluginEntry.PropertyInfo("showValue", "Boolean", "null", "Whether to display the numeric value")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Animated Progress Bar",
                                    "Create a striped, animated progress bar.",
                                    "var bar = new BSProgressBar<>(true);\nbar.setPercentage(75);\nbar.setAnimated(true);\nbar.setType(BSColourTypes.Success);\nbar.setShowValue(true);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSProgressBar<>()", "Creates a default progress bar"),
                            new PluginEntry.ConstructorInfo("new BSProgressBar<>(boolean striped)", "Creates a progress bar, optionally striped")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setPercentage", "J", "setPercentage(double percent)", "Sets the progress percentage"),
                            new PluginEntry.MethodInfo("setStriped", "J", "setStriped(boolean striped)", "Enables or disables stripes"),
                            new PluginEntry.MethodInfo("setAnimated", "J", "setAnimated(boolean animated)", "Enables or disables animation"),
                            new PluginEntry.MethodInfo("setMax", "J", "setMax(Integer max)", "Sets the maximum value"),
                            new PluginEntry.MethodInfo("setType", "J", "setType(BSColourTypes type)", "Sets the colour type"),
                            new PluginEntry.MethodInfo("setTextType", "J", "setTextType(BSColourTypes textType)", "Sets the text colour type"),
                            new PluginEntry.MethodInfo("setShowValue", "J", "setShowValue(Boolean show)", "Shows or hides the numeric value"),
                            new PluginEntry.MethodInfo("setHeight", "J", "setHeight(MeasurementCSSImpl height)", "Sets a custom height")
                    ),
                    List.of(), List.of(),
                    List.of("INgComponent")
            ),
            // ── BSRange ──
            new PluginEntry.ComponentInfo("BSRange",
                    "Range slider input with Bootstrap styling for selecting numeric values within a range.",
                    "com.jwebmp.plugins.bootstrap.range",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Range Slider",
                                    "Create a range slider input.",
                                    "var range = new BSRange<>();\nform.add(range);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSRange<>()", "Creates a range slider input")),
                    List.of(), List.of(), List.of(), List.of()
            ),
            // ── BSSelect ──
            new PluginEntry.ComponentInfo("BSSelect",
                    "Styled select dropdown with Bootstrap form-select classes and size variants.",
                    "com.jwebmp.plugins.bootstrap.select",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Select Dropdown",
                                    "Create a styled select dropdown.",
                                    "var select = new BSSelect<>();\nselect.add(new Option<>(\"Option 1\"));\nselect.add(new Option<>(\"Option 2\"));\nform.add(select);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSSelect<>()", "Creates a styled select dropdown")),
                    List.of(), List.of(), List.of(), List.of()
            ),
            // ── BSTable ──
            new PluginEntry.ComponentInfo("BSTable",
                    "Styled tables with striped, bordered, hover, small, and responsive options. Supports themed row variants like BSTableRowPrimary, BSTableRowDanger, BSTableRowSuccess, etc.",
                    "com.jwebmp.plugins.bootstrap.tables",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Styled Table",
                                    "Create a striped, bordered, hoverable table.",
                                    "var table = new BSTable<>();\ntable.setStriped(true);\ntable.setBordered(true);\ntable.setHover(true);\ntable.setResponsive(true);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSTable<>()", "Creates a Bootstrap-styled table")),
                    List.of(
                            new PluginEntry.MethodInfo("setStriped", "J", "setStriped(boolean striped)", "Adds alternating row stripes"),
                            new PluginEntry.MethodInfo("setBordered", "J", "setBordered(boolean bordered)", "Adds borders to the table"),
                            new PluginEntry.MethodInfo("setHover", "J", "setHover(boolean hovered)", "Enables hover state on rows"),
                            new PluginEntry.MethodInfo("setSmall", "J", "setSmall(boolean small)", "Compact table layout"),
                            new PluginEntry.MethodInfo("setResponsive", "J", "setResponsive(boolean responsive)", "Wraps for horizontal scrolling on small screens"),
                            new PluginEntry.MethodInfo("addTheme", "J", "addTheme(BSTableOptions options)", "Adds a table theme class"),
                            new PluginEntry.MethodInfo("setEvenWidthCells", "J", "setEvenWidthCells()", "Forces even column widths via fixed layout"),
                            new PluginEntry.MethodInfo("fitInContainerBreakAll", "J", "fitInContainerBreakAll()", "Forces word-break to fit in container"),
                            new PluginEntry.MethodInfo("fitInContainerBreakWord", "J", "fitInContainerBreakWord()", "Forces word-wrap to fit in container")
                    ),
                    List.of(),
                    List.of(),
                    List.of("IBSTable")
            ),
            // ── BSTimePicker ──
            new PluginEntry.ComponentInfo("BSTimePicker",
                    "Time selection widget backed by ng-bootstrap NgbTimepicker with hour, minute, and second spinners.",
                    "com.jwebmp.plugins.bootstrap.timepicker",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Time Picker",
                                    "Add a time picker to a form.",
                                    "var timePicker = new BSTimePicker<>();\nform.add(timePicker);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSTimePicker<>()", "Creates a time picker input")),
                    List.of(), List.of(), List.of(), List.of()
            ),
            // ── BSToast ──
            new PluginEntry.ComponentInfo("BSToast",
                    "Lightweight push notification with header, body, auto-hide, and configurable delay. Supports stacking via BSToastContainer.",
                    "com.jwebmp.plugins.bootstrap.toasts",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Toast Notification",
                                    "Create a toast with header and body.",
                                    "var toast = new BSToast<>();\ntoast.getToastHeader().setText(\"Notification\");\ntoast.getToastBody().setText(\"You have a new message.\");\ntoast.setAutoHide(true);\ntoast.setShowDelay(5000);",
                                    "java")
                    ),
                    List.of(new PluginEntry.ConstructorInfo("new BSToast<>()", "Creates a toast notification")),
                    List.of(
                            new PluginEntry.MethodInfo("getToastHeader", "BSToastHeader<?>", "getToastHeader()", "Gets or creates the toast header"),
                            new PluginEntry.MethodInfo("setToastHeader", "J", "setToastHeader(BSToastHeader<?> header)", "Sets the toast header"),
                            new PluginEntry.MethodInfo("getToastBody", "BSToastBody<?>", "getToastBody()", "Gets or creates the toast body"),
                            new PluginEntry.MethodInfo("setToastBody", "J", "setToastBody(BSToastBody<?> body)", "Sets the toast body"),
                            new PluginEntry.MethodInfo("setAutoHide", "J", "setAutoHide(boolean autoHide)", "Enables or disables auto-hide (if false, add a close icon)"),
                            new PluginEntry.MethodInfo("setShowDelay", "J", "setShowDelay(Integer delay)", "Sets the auto-hide delay in milliseconds")
                    ),
                    List.of(), List.of(), List.of()
            ),
            // ── BSToggle ──
            new PluginEntry.ComponentInfo("BSToggle",
                    "Dropdown toggle component that wires a title (button or link) to a dropdown contents list. Used internally by BSDropDown.",
                    "com.jwebmp.plugins.bootstrap.toggle",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Dropdown Toggle",
                                    "Create a dropdown toggle with button title.",
                                    "var title = new BSDropDownToggleTitleButton<>();\ntitle.setText(\"Menu\");\nvar contents = new List<>();\nvar toggle = new BSDropDownToggle<>(title, contents);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new BSDropDownToggle&lt;&gt;(BSDropDownToggleTitleLink&lt;?&gt; title, List&lt;?,?,?,?&gt; contents)", "Creates toggle with link title and contents"),
                            new PluginEntry.ConstructorInfo("new BSDropDownToggle&lt;&gt;(BSDropDownToggleTitleButton&lt;?&gt; title, List&lt;?,?,?,?&gt; contents)", "Creates toggle with button title and contents")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setTitle", "J", "setTitle(BSDropDownToggleTitleButton<?> title)", "Sets the toggle title as a button"),
                            new PluginEntry.MethodInfo("setTitle", "J", "setTitle(BSDropDownToggleTitleLink<?> title)", "Sets the toggle title as a link"),
                            new PluginEntry.MethodInfo("getTitle", "BSToggleChildren", "getTitle()", "Returns the title component"),
                            new PluginEntry.MethodInfo("getContents", "List&lt;?,?,?,?&gt;", "getContents()", "Returns the dropdown contents list"),
                            new PluginEntry.MethodInfo("setContents", "J", "setContents(List&lt;?,?,?,?&gt; contents)", "Sets the dropdown contents list")
                    ),
                    List.of(), List.of(),
                    List.of("IBSDropDownToggle")
            )
    );

    public BootstrapFrameworkPage()
    {
        super(PluginCatalog.getById("bootstrap").orElseThrow());
    }

    @Override
    protected String frameworkId()
    {
        return "bootstrap";
    }

    @Override
    protected List<PluginEntry.ComponentInfo> frameworkComponents()
    {
        return COMPONENTS;
    }
}

