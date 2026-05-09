package com.jwebmp.website.pages.frameworks;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-framework-angular-material")
@NgRoutable(path = "frameworks/angular-material")
public class AngularMaterialFrameworkPage extends FrameworkDetailPage<AngularMaterialFrameworkPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("MatAccordion", "Material Design expansion panel accordion with multi-expand and display modes", "com.jwebmp.plugins.angular.material.accordion",
                    List.of(
                            new PluginEntry.PropertyInfo("multi", "boolean", "false", "Allows multiple panels to be expanded simultaneously"),
                            new PluginEntry.PropertyInfo("displayMode", "String", "default", "Display mode: default or flat"),
                            new PluginEntry.PropertyInfo("hideToggle", "boolean", "false", "Hides the expand/collapse toggle icon")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Material Accordion", "Create an accordion with multiple panels",
                            "MatAccordion&lt;?&gt; acc = new MatAccordion&lt;&gt;();\nacc.setMulti(true);\nacc.addPanel(\"Section 1\", new DivSimple&lt;&gt;().setText(\"Content 1\"));\nacc.addPanel(\"Section 2\", new DivSimple&lt;&gt;().setText(\"Content 2\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatAccordion()", "Creates a mat-accordion element")),
                    List.of(
                            new PluginEntry.MethodInfo("setMulti", "MatAccordion", "setMulti(boolean multi)", "Enables multi-panel expansion"),
                            new PluginEntry.MethodInfo("setDisplayMode", "MatAccordion", "setDisplayMode(String mode)", "Sets to default or flat"),
                            new PluginEntry.MethodInfo("addPanel", "MatAccordion", "addPanel(String title, IComponentHierarchyBase content)", "Adds an expansion panel"),
                            new PluginEntry.MethodInfo("setHideToggle", "MatAccordion", "setHideToggle(boolean hide)", "Hides the toggle icon")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("opened", "Fired when a panel is expanded"),
                            new PluginEntry.EventInfo("closed", "Fired when a panel is collapsed")
                    ),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatAutoComplete", "Autocomplete input with filtered suggestions and option groups", "com.jwebmp.plugins.angular.material.autocomplete",
                    List.of(
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Placeholder text for the input"),
                            new PluginEntry.PropertyInfo("options", "List&lt;String&gt;", "empty", "Available autocomplete options"),
                            new PluginEntry.PropertyInfo("autoActiveFirstOption", "boolean", "false", "Auto-activates the first option"),
                            new PluginEntry.PropertyInfo("panelWidth", "String", "null", "Width of the autocomplete panel")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Material Autocomplete", "Create an autocomplete with options",
                            "MatAutoComplete&lt;?&gt; ac = new MatAutoComplete&lt;&gt;();\nac.setPlaceholder(\"Search...\");\nac.addOption(\"Angular\");\nac.addOption(\"React\");\nac.addOption(\"Vue\");\nac.setAutoActiveFirstOption(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatAutoComplete()", "Creates a mat-autocomplete element")),
                    List.of(
                            new PluginEntry.MethodInfo("addOption", "MatAutoComplete", "addOption(String option)", "Adds a suggestion option"),
                            new PluginEntry.MethodInfo("setPlaceholder", "MatAutoComplete", "setPlaceholder(String placeholder)", "Sets the placeholder text"),
                            new PluginEntry.MethodInfo("setAutoActiveFirstOption", "MatAutoComplete", "setAutoActiveFirstOption(boolean auto)", "Auto-activates first option"),
                            new PluginEntry.MethodInfo("setPanelWidth", "MatAutoComplete", "setPanelWidth(String width)", "Sets the panel width")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("optionSelected", "Fired when an option is selected"),
                            new PluginEntry.EventInfo("opened", "Fired when the panel opens"),
                            new PluginEntry.EventInfo("closed", "Fired when the panel closes")
                    ),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatButton", "Material Design raised, flat, stroked, fab, and icon buttons", "com.jwebmp.plugins.angular.material",
                    List.of(
                            new PluginEntry.PropertyInfo("color", "String", "null", "Theme colour: primary, accent, or warn"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the button is disabled"),
                            new PluginEntry.PropertyInfo("disableRipple", "boolean", "false", "Disables the ripple effect")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Raised Button", "Create a raised primary button",
                            "MatButton&lt;?&gt; btn = new MatButton&lt;&gt;(\"Submit\");\nbtn.setColor(\"primary\");\nbtn.setRaised(true);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("MatButton()", "Creates a mat-button element"),
                            new PluginEntry.ConstructorInfo("MatButton(String text)", "Creates a button with text")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setColor", "MatButton", "setColor(String color)", "Sets the theme colour"),
                            new PluginEntry.MethodInfo("setRaised", "MatButton", "setRaised(boolean raised)", "Applies mat-raised-button style"),
                            new PluginEntry.MethodInfo("setFlat", "MatButton", "setFlat(boolean flat)", "Applies mat-flat-button style"),
                            new PluginEntry.MethodInfo("setStroked", "MatButton", "setStroked(boolean stroked)", "Applies mat-stroked-button style"),
                            new PluginEntry.MethodInfo("setFab", "MatButton", "setFab(boolean fab)", "Applies mat-fab style"),
                            new PluginEntry.MethodInfo("setIcon", "MatButton", "setIcon(boolean icon)", "Applies mat-icon-button style"),
                            new PluginEntry.MethodInfo("setDisabled", "MatButton", "setDisabled(boolean disabled)", "Disables the button")
                    ),
                    List.of(), List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatCheckbox", "Material Design checkbox with indeterminate state and label positioning", "com.jwebmp.plugins.angular.material.checkbox",
                    List.of(
                            new PluginEntry.PropertyInfo("checked", "boolean", "false", "Whether the checkbox is checked"),
                            new PluginEntry.PropertyInfo("indeterminate", "boolean", "false", "Whether the checkbox is in indeterminate state"),
                            new PluginEntry.PropertyInfo("labelPosition", "String", "after", "Label position: before or after"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the checkbox is disabled"),
                            new PluginEntry.PropertyInfo("color", "String", "accent", "Theme colour")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Material Checkbox", "Create a primary checkbox",
                            "MatCheckbox&lt;?&gt; cb = new MatCheckbox&lt;&gt;();\ncb.setLabel(\"Accept terms\");\ncb.setColor(\"primary\");\ncb.setLabelPosition(\"before\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatCheckbox()", "Creates a mat-checkbox element")),
                    List.of(
                            new PluginEntry.MethodInfo("setChecked", "MatCheckbox", "setChecked(boolean checked)", "Sets the checked state"),
                            new PluginEntry.MethodInfo("setIndeterminate", "MatCheckbox", "setIndeterminate(boolean indeterminate)", "Sets indeterminate state"),
                            new PluginEntry.MethodInfo("setLabelPosition", "MatCheckbox", "setLabelPosition(String position)", "Sets label before or after"),
                            new PluginEntry.MethodInfo("setColor", "MatCheckbox", "setColor(String color)", "Sets the theme colour"),
                            new PluginEntry.MethodInfo("setDisabled", "MatCheckbox", "setDisabled(boolean disabled)", "Disables the checkbox")
                    ),
                    List.of(new PluginEntry.EventInfo("change", "Fired when the checked state changes")),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatChipAutoComplete", "Chip input with autocomplete suggestions and removable chips", "com.jwebmp.plugins.angular.material.chips",
                    List.of(
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Input placeholder text"),
                            new PluginEntry.PropertyInfo("removable", "boolean", "true", "Whether chips can be removed"),
                            new PluginEntry.PropertyInfo("selectable", "boolean", "true", "Whether chips can be selected"),
                            new PluginEntry.PropertyInfo("separatorKeyCodes", "List&lt;Integer&gt;", "[ENTER, COMMA]", "Key codes that trigger chip creation")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Chip Autocomplete", "Create a chip input with suggestions",
                            "MatChipAutoComplete&lt;?&gt; chips = new MatChipAutoComplete&lt;&gt;();\nchips.setPlaceholder(\"Add tags...\");\nchips.addOption(\"Angular\");\nchips.addOption(\"React\");\nchips.setRemovable(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatChipAutoComplete()", "Creates a chip autocomplete element")),
                    List.of(
                            new PluginEntry.MethodInfo("addOption", "MatChipAutoComplete", "addOption(String option)", "Adds an autocomplete suggestion"),
                            new PluginEntry.MethodInfo("setPlaceholder", "MatChipAutoComplete", "setPlaceholder(String placeholder)", "Sets the placeholder"),
                            new PluginEntry.MethodInfo("setRemovable", "MatChipAutoComplete", "setRemovable(boolean removable)", "Enables chip removal"),
                            new PluginEntry.MethodInfo("setSelectable", "MatChipAutoComplete", "setSelectable(boolean selectable)", "Enables chip selection")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("chipAdded", "Fired when a chip is added"),
                            new PluginEntry.EventInfo("chipRemoved", "Fired when a chip is removed")
                    ),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatDialog", "Modal dialog with open/close lifecycle, data injection, and configurable dimensions", "com.jwebmp.plugins.angular.material.dialog",
                    List.of(
                            new PluginEntry.PropertyInfo("width", "String", "null", "Dialog width (e.g. '400px' or '80%')"),
                            new PluginEntry.PropertyInfo("height", "String", "null", "Dialog height"),
                            new PluginEntry.PropertyInfo("disableClose", "boolean", "false", "Prevents closing on backdrop click or Escape"),
                            new PluginEntry.PropertyInfo("hasBackdrop", "boolean", "true", "Shows a backdrop behind the dialog"),
                            new PluginEntry.PropertyInfo("panelClass", "String", "null", "CSS class applied to the dialog panel")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Material Dialog", "Create and open a dialog",
                            "MatDialog&lt;?&gt; dialog = new MatDialog&lt;&gt;();\ndialog.setWidth(\"500px\");\ndialog.setDisableClose(true);\ndialog.add(new Paragraph&lt;&gt;().setText(\"Dialog content\"));\n// Dialog is opened programmatically via MatDialogService", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatDialog()", "Creates a mat-dialog-content container")),
                    List.of(
                            new PluginEntry.MethodInfo("setWidth", "MatDialog", "setWidth(String width)", "Sets the dialog width"),
                            new PluginEntry.MethodInfo("setHeight", "MatDialog", "setHeight(String height)", "Sets the dialog height"),
                            new PluginEntry.MethodInfo("setDisableClose", "MatDialog", "setDisableClose(boolean disable)", "Prevents close on backdrop/escape"),
                            new PluginEntry.MethodInfo("setHasBackdrop", "MatDialog", "setHasBackdrop(boolean backdrop)", "Toggles the backdrop"),
                            new PluginEntry.MethodInfo("setPanelClass", "MatDialog", "setPanelClass(String panelClass)", "Sets the panel CSS class")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("afterOpened", "Fired after the dialog opens"),
                            new PluginEntry.EventInfo("afterClosed", "Fired after the dialog closes"),
                            new PluginEntry.EventInfo("beforeClosed", "Fired before the dialog closes")
                    ),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatFormField", "Form field wrapper with label, hint, prefix/suffix, and error messages", "com.jwebmp.plugins.angular.material.formfield",
                    List.of(
                            new PluginEntry.PropertyInfo("appearance", "String", "fill", "Appearance: fill or outline"),
                            new PluginEntry.PropertyInfo("floatLabel", "String", "auto", "Label float behaviour: auto, always, or never"),
                            new PluginEntry.PropertyInfo("hideRequiredMarker", "boolean", "false", "Hides the required asterisk"),
                            new PluginEntry.PropertyInfo("color", "String", "primary", "Theme colour for the underline")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Outlined Form Field", "Create an outline form field with hint",
                            "MatFormField&lt;?&gt; field = new MatFormField&lt;&gt;();\nfield.setAppearance(\"outline\");\nfield.setLabel(\"Email\");\nfield.addHint(\"Enter your email address\");\nfield.add(new InputTextType&lt;&gt;());", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatFormField()", "Creates a mat-form-field element")),
                    List.of(
                            new PluginEntry.MethodInfo("setAppearance", "MatFormField", "setAppearance(String appearance)", "Sets fill or outline appearance"),
                            new PluginEntry.MethodInfo("setLabel", "MatFormField", "setLabel(String label)", "Sets the floating label"),
                            new PluginEntry.MethodInfo("addHint", "MatFormField", "addHint(String hint)", "Adds a hint message below the input"),
                            new PluginEntry.MethodInfo("addError", "MatFormField", "addError(String error)", "Adds an error message"),
                            new PluginEntry.MethodInfo("setFloatLabel", "MatFormField", "setFloatLabel(String float)", "Sets float label behaviour"),
                            new PluginEntry.MethodInfo("setColor", "MatFormField", "setColor(String color)", "Sets the underline colour")
                    ),
                    List.of(), List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatIcon", "Material Design icon component with ligature, SVG, and font icon support", "com.jwebmp.plugins.angular.material",
                    List.of(
                            new PluginEntry.PropertyInfo("fontSet", "String", "material-icons", "Font icon set to use"),
                            new PluginEntry.PropertyInfo("fontIcon", "String", "null", "Font icon class name"),
                            new PluginEntry.PropertyInfo("svgIcon", "String", "null", "SVG icon name from registered sets"),
                            new PluginEntry.PropertyInfo("inline", "boolean", "false", "Renders the icon inline with text"),
                            new PluginEntry.PropertyInfo("color", "String", "null", "Theme colour")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Material Icon", "Create an icon using ligature",
                            "MatIcon&lt;?&gt; icon = new MatIcon&lt;&gt;(\"home\");\nicon.setColor(\"primary\");\nicon.setInline(true);", "java")),
                    List.of(
                            new PluginEntry.ConstructorInfo("MatIcon()", "Creates an empty mat-icon element"),
                            new PluginEntry.ConstructorInfo("MatIcon(String ligature)", "Creates an icon with the given ligature name")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setFontSet", "MatIcon", "setFontSet(String fontSet)", "Sets the font icon set"),
                            new PluginEntry.MethodInfo("setFontIcon", "MatIcon", "setFontIcon(String icon)", "Sets the font icon class"),
                            new PluginEntry.MethodInfo("setSvgIcon", "MatIcon", "setSvgIcon(String icon)", "Sets the SVG icon name"),
                            new PluginEntry.MethodInfo("setInline", "MatIcon", "setInline(boolean inline)", "Renders inline with text"),
                            new PluginEntry.MethodInfo("setColor", "MatIcon", "setColor(String color)", "Sets the theme colour")
                    ),
                    List.of(), List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatProgressBar", "Linear progress indicator with determinate, indeterminate, buffer, and query modes", "com.jwebmp.plugins.angular.material.progressbar",
                    List.of(
                            new PluginEntry.PropertyInfo("mode", "String", "determinate", "Progress mode: determinate, indeterminate, buffer, query"),
                            new PluginEntry.PropertyInfo("value", "int", "0", "Current progress value (0–100)"),
                            new PluginEntry.PropertyInfo("bufferValue", "int", "0", "Buffer value for buffer mode (0–100)"),
                            new PluginEntry.PropertyInfo("color", "String", "primary", "Theme colour")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Progress Bar", "Create an indeterminate loading bar",
                            "MatProgressBar&lt;?&gt; bar = new MatProgressBar&lt;&gt;();\nbar.setMode(\"indeterminate\");\nbar.setColor(\"accent\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatProgressBar()", "Creates a mat-progress-bar element")),
                    List.of(
                            new PluginEntry.MethodInfo("setMode", "MatProgressBar", "setMode(String mode)", "Sets the progress mode"),
                            new PluginEntry.MethodInfo("setValue", "MatProgressBar", "setValue(int value)", "Sets the current value"),
                            new PluginEntry.MethodInfo("setBufferValue", "MatProgressBar", "setBufferValue(int buffer)", "Sets the buffer value"),
                            new PluginEntry.MethodInfo("setColor", "MatProgressBar", "setColor(String color)", "Sets the theme colour")
                    ),
                    List.of(new PluginEntry.EventInfo("animationEnd", "Fired when the progress animation completes")),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatSelect", "Dropdown select with option groups, multiple selection, and search", "com.jwebmp.plugins.angular.material.select",
                    List.of(
                            new PluginEntry.PropertyInfo("multiple", "boolean", "false", "Enables multi-select"),
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Placeholder text"),
                            new PluginEntry.PropertyInfo("disabled", "boolean", "false", "Whether the select is disabled"),
                            new PluginEntry.PropertyInfo("panelClass", "String", "null", "CSS class for the select panel"),
                            new PluginEntry.PropertyInfo("disableRipple", "boolean", "false", "Disables the ripple effect")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Material Select", "Create a multi-select dropdown",
                            "MatSelect&lt;?&gt; select = new MatSelect&lt;&gt;();\nselect.setPlaceholder(\"Choose colours\");\nselect.setMultiple(true);\nselect.addOption(\"Red\", \"red\");\nselect.addOption(\"Green\", \"green\");\nselect.addOption(\"Blue\", \"blue\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatSelect()", "Creates a mat-select element")),
                    List.of(
                            new PluginEntry.MethodInfo("addOption", "MatSelect", "addOption(String label, String value)", "Adds a select option"),
                            new PluginEntry.MethodInfo("addOptGroup", "MatSelect", "addOptGroup(String label, List options)", "Adds an option group"),
                            new PluginEntry.MethodInfo("setMultiple", "MatSelect", "setMultiple(boolean multiple)", "Enables multi-select"),
                            new PluginEntry.MethodInfo("setPlaceholder", "MatSelect", "setPlaceholder(String placeholder)", "Sets the placeholder"),
                            new PluginEntry.MethodInfo("setDisabled", "MatSelect", "setDisabled(boolean disabled)", "Disables the select")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("selectionChange", "Fired when the selection changes"),
                            new PluginEntry.EventInfo("openedChange", "Fired when the panel opens or closes")
                    ),
                    List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatTable", "Data table with sorting, pagination, column definitions, and data source binding", "com.jwebmp.plugins.angular.material.table",
                    List.of(
                            new PluginEntry.PropertyInfo("dataSource", "MatTableDataSource", "null", "The data source providing table rows"),
                            new PluginEntry.PropertyInfo("displayedColumns", "List&lt;String&gt;", "empty", "List of column names to display"),
                            new PluginEntry.PropertyInfo("multiTemplateDataRows", "boolean", "false", "Enables multiple template rows per data row")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Material Table", "Create a data table with columns",
                            "MatTable&lt;?&gt; table = new MatTable&lt;&gt;();\ntable.addColumn(\"name\", \"Name\");\ntable.addColumn(\"email\", \"Email\");\ntable.addColumn(\"role\", \"Role\");\ntable.setDisplayedColumns(List.of(\"name\", \"email\", \"role\"));", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatTable()", "Creates a mat-table element")),
                    List.of(
                            new PluginEntry.MethodInfo("addColumn", "MatTable", "addColumn(String id, String header)", "Adds a column definition"),
                            new PluginEntry.MethodInfo("setDataSource", "MatTable", "setDataSource(MatTableDataSource dataSource)", "Sets the data source"),
                            new PluginEntry.MethodInfo("setDisplayedColumns", "MatTable", "setDisplayedColumns(List&lt;String&gt; columns)", "Sets which columns are shown"),
                            new PluginEntry.MethodInfo("setSorting", "MatTable", "setSorting(boolean sorting)", "Enables header sort controls")
                    ),
                    List.of(), List.of(),
                    List.of("INgComponent")),

            new PluginEntry.ComponentInfo("MatTablePaginator", "Paginator control for MatTable with page size options and navigation", "com.jwebmp.plugins.angular.material.table",
                    List.of(
                            new PluginEntry.PropertyInfo("pageSize", "int", "10", "Number of rows per page"),
                            new PluginEntry.PropertyInfo("pageSizeOptions", "List&lt;Integer&gt;", "[5, 10, 25]", "Available page size options"),
                            new PluginEntry.PropertyInfo("length", "int", "0", "Total number of items"),
                            new PluginEntry.PropertyInfo("showFirstLastButtons", "boolean", "false", "Shows first/last page buttons"),
                            new PluginEntry.PropertyInfo("color", "String", "null", "Theme colour")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Table Paginator", "Add pagination to a material table",
                            "MatTablePaginator&lt;?&gt; paginator = new MatTablePaginator&lt;&gt;();\npaginator.setPageSize(25);\npaginator.setPageSizeOptions(List.of(10, 25, 50, 100));\npaginator.setShowFirstLastButtons(true);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("MatTablePaginator()", "Creates a mat-paginator element")),
                    List.of(
                            new PluginEntry.MethodInfo("setPageSize", "MatTablePaginator", "setPageSize(int pageSize)", "Sets rows per page"),
                            new PluginEntry.MethodInfo("setPageSizeOptions", "MatTablePaginator", "setPageSizeOptions(List&lt;Integer&gt; options)", "Sets page size options"),
                            new PluginEntry.MethodInfo("setLength", "MatTablePaginator", "setLength(int length)", "Sets total item count"),
                            new PluginEntry.MethodInfo("setShowFirstLastButtons", "MatTablePaginator", "setShowFirstLastButtons(boolean show)", "Shows first/last buttons")
                    ),
                    List.of(new PluginEntry.EventInfo("page", "Fired when the page changes")),
                    List.of(),
                    List.of("INgComponent"))
    );

    public AngularMaterialFrameworkPage()
    {
        super(PluginCatalog.getById("angular-material").orElseThrow());
    }

    @Override
    protected String frameworkId()
    {
        return "angular-material";
    }

    @Override
    protected List<PluginEntry.ComponentInfo> frameworkComponents()
    {
        return COMPONENTS;
    }
}

