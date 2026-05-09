package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-jquery-ui")
@NgRoutable(path = "plugins/jquery-ui")
public class JQueryUIPluginPage extends PluginDetailPage<JQueryUIPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("JQUIAccordion", "Collapsible content panels with animation, easing, and height styles", "com.jwebmp.plugins.jqueryui.accordion",
                    List.of(
                            new PluginEntry.PropertyInfo("collapsible", "boolean", "false", "Allows all sections to be collapsed simultaneously"),
                            new PluginEntry.PropertyInfo("active", "int", "0", "Zero-based index of the initially active panel"),
                            new PluginEntry.PropertyInfo("heightStyle", "String", "auto", "Height style: auto, fill, or content"),
                            new PluginEntry.PropertyInfo("animate", "JQEasingEffects", "null", "Animation easing effect for transitions")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Collapsible Accordion", "Create an accordion with easing",
                            "JQUIAccordion&lt;?&gt; accordion = new JQUIAccordion&lt;&gt;();\naccordion.addAccordianTab(tab1);\naccordion.addAccordianTab(tab2);\naccordion.getOptions().setCollapsible(true);\naccordion.getOptions().getAnimate().setEasing(JQEasingEffects.easeInBack);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUIAccordion()", "Creates an accordion widget")),
                    List.of(
                            new PluginEntry.MethodInfo("addAccordianTab", "JQUIAccordion", "addAccordianTab(JQUIAccordionTab tab)", "Adds a tab panel to the accordion"),
                            new PluginEntry.MethodInfo("getOptions", "JQUIAccordionOptions", "getOptions()", "Returns the accordion options"),
                            new PluginEntry.MethodInfo("setCollapsible", "JQUIAccordion", "setCollapsible(boolean collapsible)", "Enables all-collapsed state"),
                            new PluginEntry.MethodInfo("setActive", "JQUIAccordion", "setActive(int active)", "Sets the initially active panel index")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("activate", "Fired when a panel is activated"),
                            new PluginEntry.EventInfo("beforeActivate", "Fired before a panel is activated")
                    ),
                    List.of(),
                    List.of("IJQUIAccordion")),

            new PluginEntry.ComponentInfo("JQUIAutoComplete", "Autocomplete input with local or AJAX-backed server-side data", "com.jwebmp.plugins.jqueryui.autocomplete",
                    List.of(
                            new PluginEntry.PropertyInfo("source", "List&lt;String&gt;", "empty", "Local source data for suggestions"),
                            new PluginEntry.PropertyInfo("ajax", "boolean", "false", "Enables AJAX-based server-side lookup"),
                            new PluginEntry.PropertyInfo("minLength", "int", "1", "Minimum characters before suggestions appear"),
                            new PluginEntry.PropertyInfo("delay", "int", "300", "Delay in ms between keystroke and search")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("AJAX Autocomplete", "Autocomplete with server-side data fetching",
                            "JQUIAutoComplete&lt;?&gt; ac = new JQUIAutoComplete&lt;&gt;(\"search\");\nac.getOptions().addOption(\"Java\");\nac.getOptions().addOption(\"JavaScript\");\nac.getOptions().setAjax(true, ac);\nac.getOptions().setMinLength(2);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("JQUIAutoComplete()", "Creates an autocomplete input"),
                            new PluginEntry.ConstructorInfo("JQUIAutoComplete(String variableName)", "Creates an autocomplete with a binding variable name")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUIAutoCompleteOptions", "getOptions()", "Returns autocomplete options"),
                            new PluginEntry.MethodInfo("addOption", "JQUIAutoComplete", "addOption(String option)", "Adds a local suggestion option"),
                            new PluginEntry.MethodInfo("setMinLength", "JQUIAutoComplete", "setMinLength(int minLength)", "Sets minimum characters for suggestions"),
                            new PluginEntry.MethodInfo("setDelay", "JQUIAutoComplete", "setDelay(int delay)", "Sets search delay in ms")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("select", "Fired when a suggestion is selected"),
                            new PluginEntry.EventInfo("change", "Fired when the input value changes"),
                            new PluginEntry.EventInfo("search", "Fired before a search is performed")
                    ),
                    List.of(),
                    List.of("IJQUIAutoComplete")),

            new PluginEntry.ComponentInfo("JQUIButton", "Enhanced buttons and button sets with icons and label customization", "com.jwebmp.plugins.jqueryui.button",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "The button label text"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the button is disabled"),
                            new PluginEntry.PropertyInfo("icon", "String", "null", "Primary icon CSS class"),
                            new PluginEntry.PropertyInfo("iconPosition", "String", "beginning", "Icon position: beginning or end")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Icon Button", "Create a button with an icon",
                            "JQUIButton&lt;?&gt; btn = new JQUIButton&lt;&gt;(\"Save\");\nbtn.getOptions().setIcon(\"ui-icon-disk\");\nbtn.getOptions().setIconPosition(\"beginning\");", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("JQUIButton()", "Creates an empty button"),
                            new PluginEntry.ConstructorInfo("JQUIButton(String text)", "Creates a button with label text")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUIButtonOptions", "getOptions()", "Returns the button options"),
                            new PluginEntry.MethodInfo("setLabel", "JQUIButton", "setLabel(String label)", "Sets the button label"),
                            new PluginEntry.MethodInfo("setDisabled", "JQUIButton", "setDisabled(boolean disabled)", "Disables the button"),
                            new PluginEntry.MethodInfo("setIcon", "JQUIButton", "setIcon(String iconClass)", "Sets the icon CSS class")
                    ),
                    List.of(new PluginEntry.EventInfo("click", "Fired when the button is clicked")),
                    List.of(),
                    List.of("IJQUIButton")),

            new PluginEntry.ComponentInfo("JQUIDatePicker", "Full-featured date selection widget with format, range, and locale options", "com.jwebmp.plugins.jqueryui.datepicker",
                    List.of(
                            new PluginEntry.PropertyInfo("dateFormat", "String", "mm/dd/yy", "The date format string"),
                            new PluginEntry.PropertyInfo("minDate", "String", "null", "Minimum selectable date (relative or absolute)"),
                            new PluginEntry.PropertyInfo("maxDate", "String", "null", "Maximum selectable date (relative or absolute)"),
                            new PluginEntry.PropertyInfo("showAnim", "String", "show", "Animation effect for showing the picker"),
                            new PluginEntry.PropertyInfo("numberOfMonths", "int", "1", "Number of months to show simultaneously"),
                            new PluginEntry.PropertyInfo("changeMonth", "boolean", "false", "Shows a month dropdown"),
                            new PluginEntry.PropertyInfo("changeYear", "boolean", "false", "Shows a year dropdown")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Date Picker", "Create a date picker with month/year dropdowns",
                            "JQUIDatePicker&lt;?&gt; dp = new JQUIDatePicker&lt;&gt;();\ndp.getOptions().setDateFormat(\"yy-mm-dd\");\ndp.getOptions().setChangeMonth(true);\ndp.getOptions().setChangeYear(true);\ndp.getOptions().setNumberOfMonths(2);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUIDatePicker()", "Creates a date picker input")),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUIDatePickerOptions", "getOptions()", "Returns the date picker options"),
                            new PluginEntry.MethodInfo("setDateFormat", "JQUIDatePicker", "setDateFormat(String format)", "Sets the date format"),
                            new PluginEntry.MethodInfo("setMinDate", "JQUIDatePicker", "setMinDate(String minDate)", "Sets the minimum date"),
                            new PluginEntry.MethodInfo("setMaxDate", "JQUIDatePicker", "setMaxDate(String maxDate)", "Sets the maximum date")
                    ),
                    List.of(new PluginEntry.EventInfo("onSelect", "Fired when a date is selected")),
                    List.of(),
                    List.of("IJQUIDatePicker")),

            new PluginEntry.ComponentInfo("JQUIDialog", "Modal and modeless dialog boxes with configurable buttons and dimensions", "com.jwebmp.plugins.jqueryui.dialog",
                    List.of(
                            new PluginEntry.PropertyInfo("modal", "boolean", "false", "Whether the dialog is modal"),
                            new PluginEntry.PropertyInfo("title", "String", "null", "The dialog title"),
                            new PluginEntry.PropertyInfo("width", "int", "300", "Dialog width in pixels"),
                            new PluginEntry.PropertyInfo("height", "int", "auto", "Dialog height in pixels or 'auto'"),
                            new PluginEntry.PropertyInfo("draggable", "boolean", "true", "Whether the dialog is draggable"),
                            new PluginEntry.PropertyInfo("resizable", "boolean", "true", "Whether the dialog is resizable"),
                            new PluginEntry.PropertyInfo("autoOpen", "boolean", "true", "Opens the dialog automatically on creation"),
                            new PluginEntry.PropertyInfo("closeOnEscape", "boolean", "true", "Closes dialog on Escape key")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Modal Dialog", "Create a modal dialog",
                            "JQUIDialog&lt;?&gt; dialog = new JQUIDialog&lt;&gt;(\"Confirm\");\ndialog.getOptions().setModal(true);\ndialog.getOptions().setWidth(400);\ndialog.getOptions().setHeight(300);\ndialog.add(new Paragraph&lt;&gt;().setText(\"Are you sure?\"));", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("JQUIDialog()", "Creates an empty dialog"),
                            new PluginEntry.ConstructorInfo("JQUIDialog(String title)", "Creates a dialog with a title")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUIDialogOptions", "getOptions()", "Returns the dialog options"),
                            new PluginEntry.MethodInfo("setModal", "JQUIDialog", "setModal(boolean modal)", "Sets whether the dialog is modal"),
                            new PluginEntry.MethodInfo("setTitle", "JQUIDialog", "setTitle(String title)", "Sets the dialog title"),
                            new PluginEntry.MethodInfo("setWidth", "JQUIDialog", "setWidth(int width)", "Sets the dialog width"),
                            new PluginEntry.MethodInfo("setHeight", "JQUIDialog", "setHeight(int height)", "Sets the dialog height")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("open", "Fired when the dialog opens"),
                            new PluginEntry.EventInfo("close", "Fired when the dialog closes"),
                            new PluginEntry.EventInfo("beforeClose", "Fired before the dialog closes")
                    ),
                    List.of(),
                    List.of("IJQUIDialog")),

            new PluginEntry.ComponentInfo("JQUIDraggable", "Make elements draggable with containment, grid, and axis constraints", "com.jwebmp.plugins.jqueryui.draggable",
                    List.of(
                            new PluginEntry.PropertyInfo("axis", "String", "null", "Constrains dragging to x or y axis"),
                            new PluginEntry.PropertyInfo("containment", "String", "null", "Constrains dragging within an element or 'parent'"),
                            new PluginEntry.PropertyInfo("grid", "int[]", "null", "Snaps to a grid [x, y] in pixels"),
                            new PluginEntry.PropertyInfo("handle", "String", "null", "CSS selector for the drag handle"),
                            new PluginEntry.PropertyInfo("opacity", "double", "1.0", "Opacity during drag"),
                            new PluginEntry.PropertyInfo("revert", "boolean", "false", "Returns to original position after drag")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Draggable Element", "Make a div draggable within its parent",
                            "JQUIDraggable&lt;?&gt; drag = new JQUIDraggable&lt;&gt;();\ndrag.setText(\"Drag me!\");\ndrag.getOptions().setContainment(\"parent\");\ndrag.getOptions().setAxis(\"x\");\ndrag.getOptions().setOpacity(0.7);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUIDraggable()", "Creates a draggable element")),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUIDraggableOptions", "getOptions()", "Returns the draggable options"),
                            new PluginEntry.MethodInfo("setAxis", "JQUIDraggable", "setAxis(String axis)", "Constrains to x or y axis"),
                            new PluginEntry.MethodInfo("setContainment", "JQUIDraggable", "setContainment(String containment)", "Sets the containment boundary"),
                            new PluginEntry.MethodInfo("setRevert", "JQUIDraggable", "setRevert(boolean revert)", "Returns to original position")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("start", "Fired when dragging starts"),
                            new PluginEntry.EventInfo("drag", "Fired during dragging"),
                            new PluginEntry.EventInfo("stop", "Fired when dragging stops")
                    ),
                    List.of(),
                    List.of("IJQUIDraggable")),

            new PluginEntry.ComponentInfo("JQUIDroppable", "Define drop targets with accept filtering, tolerance, and visual feedback", "com.jwebmp.plugins.jqueryui.droppable",
                    List.of(
                            new PluginEntry.PropertyInfo("accept", "String", "*", "CSS selector for accepted draggable elements"),
                            new PluginEntry.PropertyInfo("activeClass", "String", "null", "CSS class applied when a draggable is active"),
                            new PluginEntry.PropertyInfo("hoverClass", "String", "null", "CSS class applied when hovering over the target"),
                            new PluginEntry.PropertyInfo("tolerance", "String", "intersect", "Tolerance mode: fit, intersect, pointer, touch")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Drop Target", "Create a drop zone that accepts specific elements",
                            "JQUIDroppable&lt;?&gt; drop = new JQUIDroppable&lt;&gt;();\ndrop.setText(\"Drop here\");\ndrop.getOptions().setAccept(\".draggable-item\");\ndrop.getOptions().setHoverClass(\"highlight\");\ndrop.getOptions().setTolerance(\"pointer\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUIDroppable()", "Creates a droppable target")),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUIDroppableOptions", "getOptions()", "Returns the droppable options"),
                            new PluginEntry.MethodInfo("setAccept", "JQUIDroppable", "setAccept(String selector)", "Sets the accepted draggable selector"),
                            new PluginEntry.MethodInfo("setTolerance", "JQUIDroppable", "setTolerance(String tolerance)", "Sets the tolerance mode")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("drop", "Fired when an accepted element is dropped"),
                            new PluginEntry.EventInfo("over", "Fired when hovering over the target"),
                            new PluginEntry.EventInfo("out", "Fired when leaving the target")
                    ),
                    List.of(),
                    List.of("IJQUIDroppable")),

            new PluginEntry.ComponentInfo("JQUISlider", "Range and value sliders with step increments and orientation", "com.jwebmp.plugins.jqueryui.slider",
                    List.of(
                            new PluginEntry.PropertyInfo("min", "int", "0", "Minimum slider value"),
                            new PluginEntry.PropertyInfo("max", "int", "100", "Maximum slider value"),
                            new PluginEntry.PropertyInfo("value", "int", "0", "Current slider value"),
                            new PluginEntry.PropertyInfo("step", "int", "1", "Step increment"),
                            new PluginEntry.PropertyInfo("orientation", "String", "horizontal", "Orientation: horizontal or vertical"),
                            new PluginEntry.PropertyInfo("range", "boolean", "false", "Enables range selection with two handles")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Range Slider", "Create a range slider",
                            "JQUISlider&lt;?&gt; slider = new JQUISlider&lt;&gt;();\nslider.getOptions().setMin(0);\nslider.getOptions().setMax(100);\nslider.getOptions().setStep(5);\nslider.getOptions().setRange(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUISlider()", "Creates a slider widget")),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUISliderOptions", "getOptions()", "Returns the slider options"),
                            new PluginEntry.MethodInfo("setMin", "JQUISlider", "setMin(int min)", "Sets the minimum value"),
                            new PluginEntry.MethodInfo("setMax", "JQUISlider", "setMax(int max)", "Sets the maximum value"),
                            new PluginEntry.MethodInfo("setStep", "JQUISlider", "setStep(int step)", "Sets the step increment"),
                            new PluginEntry.MethodInfo("setRange", "JQUISlider", "setRange(boolean range)", "Enables range mode")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("slide", "Fired as the handle is moved"),
                            new PluginEntry.EventInfo("change", "Fired after the value changes"),
                            new PluginEntry.EventInfo("start", "Fired when sliding starts"),
                            new PluginEntry.EventInfo("stop", "Fired when sliding stops")
                    ),
                    List.of(),
                    List.of("IJQUISlider")),

            new PluginEntry.ComponentInfo("JQUISortable", "Reorderable lists with drag-and-drop, connected lists, and placeholders", "com.jwebmp.plugins.jqueryui.sortable",
                    List.of(
                            new PluginEntry.PropertyInfo("axis", "String", "null", "Constrains sorting to x or y axis"),
                            new PluginEntry.PropertyInfo("connectWith", "String", "null", "CSS selector of connected sortable lists"),
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "CSS class for the placeholder element"),
                            new PluginEntry.PropertyInfo("handle", "String", "null", "CSS selector for the drag handle"),
                            new PluginEntry.PropertyInfo("items", "String", "&gt; *", "Selector for sortable items")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Sortable List", "Create a reorderable list",
                            "JQUISortable&lt;?&gt; sortable = new JQUISortable&lt;&gt;();\nsortable.add(new ListItem&lt;&gt;(\"Item 1\"));\nsortable.add(new ListItem&lt;&gt;(\"Item 2\"));\nsortable.add(new ListItem&lt;&gt;(\"Item 3\"));\nsortable.getOptions().setPlaceholder(\"ui-state-highlight\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUISortable()", "Creates a sortable list")),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUISortableOptions", "getOptions()", "Returns the sortable options"),
                            new PluginEntry.MethodInfo("setAxis", "JQUISortable", "setAxis(String axis)", "Constrains to an axis"),
                            new PluginEntry.MethodInfo("setConnectWith", "JQUISortable", "setConnectWith(String selector)", "Connects to another sortable"),
                            new PluginEntry.MethodInfo("setPlaceholder", "JQUISortable", "setPlaceholder(String className)", "Sets the placeholder class")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("update", "Fired when the sort order changes"),
                            new PluginEntry.EventInfo("start", "Fired when sorting starts"),
                            new PluginEntry.EventInfo("stop", "Fired when sorting stops"),
                            new PluginEntry.EventInfo("receive", "Fired when an item is received from a connected list")
                    ),
                    List.of(),
                    List.of("IJQUISortable")),

            new PluginEntry.ComponentInfo("JQUITabs", "Tabbed content panels with events, animations, and AJAX loading", "com.jwebmp.plugins.jqueryui.tabs",
                    List.of(
                            new PluginEntry.PropertyInfo("active", "int", "0", "Zero-based index of the initially active tab"),
                            new PluginEntry.PropertyInfo("collapsible", "boolean", "false", "Allows all tabs to be collapsed"),
                            new PluginEntry.PropertyInfo("heightStyle", "String", "content", "Height style: auto, fill, or content"),
                            new PluginEntry.PropertyInfo("hide", "String", "null", "Animation for hiding a tab panel"),
                            new PluginEntry.PropertyInfo("show", "String", "null", "Animation for showing a tab panel")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Tabbed Panels", "Create tabs with content panels",
                            "JQUITabs&lt;?&gt; tabs = new JQUITabs&lt;&gt;();\ntabs.addTab(\"Tab 1\", new DivSimple&lt;&gt;().setText(\"Content 1\"));\ntabs.addTab(\"Tab 2\", new DivSimple&lt;&gt;().setText(\"Content 2\"));\ntabs.getOptions().setCollapsible(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUITabs()", "Creates a tabbed panel widget")),
                    List.of(
                            new PluginEntry.MethodInfo("addTab", "JQUITabs", "addTab(String label, IComponentHierarchyBase content)", "Adds a tab with content"),
                            new PluginEntry.MethodInfo("getOptions", "JQUITabsOptions", "getOptions()", "Returns the tabs options"),
                            new PluginEntry.MethodInfo("setActive", "JQUITabs", "setActive(int active)", "Sets the active tab index"),
                            new PluginEntry.MethodInfo("setCollapsible", "JQUITabs", "setCollapsible(boolean collapsible)", "Allows all tabs to be collapsed")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("activate", "Fired when a tab is activated"),
                            new PluginEntry.EventInfo("beforeActivate", "Fired before a tab is activated"),
                            new PluginEntry.EventInfo("beforeLoad", "Fired before AJAX tab content is loaded")
                    ),
                    List.of(),
                    List.of("IJQUITabs")),

            new PluginEntry.ComponentInfo("JQUIToolTip", "Configurable tooltips with positioning, animation, and custom content", "com.jwebmp.plugins.jqueryui.tooltips",
                    List.of(
                            new PluginEntry.PropertyInfo("content", "String", "null", "Custom tooltip content (overrides title attribute)"),
                            new PluginEntry.PropertyInfo("position", "JQUIPositionOptions", "null", "Tooltip position relative to the target"),
                            new PluginEntry.PropertyInfo("show", "String", "null", "Animation for showing the tooltip"),
                            new PluginEntry.PropertyInfo("hide", "String", "null", "Animation for hiding the tooltip"),
                            new PluginEntry.PropertyInfo("track", "boolean", "false", "Tooltip follows the mouse cursor")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Custom Tooltip", "Create a tooltip with custom content",
                            "JQUIToolTip&lt;?&gt; tooltip = new JQUIToolTip&lt;&gt;();\ntooltip.getOptions().setContent(\"Helpful information\");\ntooltip.getOptions().setTrack(true);\ntooltip.getOptions().setShow(\"slideDown\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("JQUIToolTip()", "Creates a tooltip widget")),
                    List.of(
                            new PluginEntry.MethodInfo("getOptions", "JQUIToolTipOptions", "getOptions()", "Returns the tooltip options"),
                            new PluginEntry.MethodInfo("setContent", "JQUIToolTip", "setContent(String content)", "Sets the tooltip content"),
                            new PluginEntry.MethodInfo("setTrack", "JQUIToolTip", "setTrack(boolean track)", "Enables mouse tracking"),
                            new PluginEntry.MethodInfo("setPosition", "JQUIToolTip", "setPosition(JQUIPositionOptions position)", "Sets the tooltip position")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("open", "Fired when the tooltip is shown"),
                            new PluginEntry.EventInfo("close", "Fired when the tooltip is hidden")
                    ),
                    List.of(),
                    List.of("IJQUIToolTip"))
    );

    public JQueryUIPluginPage()
    {
        super(PluginCatalog.getById("jquery-ui").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Accordion",
                        "Create a collapsible accordion with animated transitions.",
                        "JQUIAccordion accordion = new JQUIAccordion();\naccordion.addAccordianTab(tab1);\naccordion.addAccordianTab(tab2);\naccordion.getOptions().setCollapsible(true);\naccordion.getOptions().getAnimate()\n    .setEasing(JQEasingEffects.easeInBack);",
                        "java"),
                new PluginEntry.ExampleSnippet("Dialog",
                        "Create a modal dialog with configurable dimensions.",
                        "JQUIDialog dialog = new JQUIDialog(\"My Dialog\");\ndialog.getOptions().setModal(true);\ndialog.getOptions().setWidth(400);\ndialog.getOptions().setHeight(300);",
                        "java"),
                new PluginEntry.ExampleSnippet("Autocomplete with AJAX",
                        "Server-side autocomplete with AJAX data fetching.",
                        "JQUIAutoComplete ac = new JQUIAutoComplete(\"search\");\nac.getOptions().addOption(\"option 1\");\nac.getOptions().setAjax(true, ac);",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "JQUIPageConfigurator auto-registers jQuery UI 1.14.2 JS and base theme CSS"),
                new PluginEntry.SpiDetail("IGuiceScanModuleInclusions", "provides", "JQueryUIModuleInclusion includes the jQuery UI module in Guice classpath scanning"),
                new PluginEntry.SpiDetail("IGuiceScanModuleExclusions", "provides", "JQueryUIExclusionsModule excludes unnecessary scan targets for performance")
        );
    }
}
