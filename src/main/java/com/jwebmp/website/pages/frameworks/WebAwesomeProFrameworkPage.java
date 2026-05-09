package com.jwebmp.website.pages.frameworks;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-framework-web-awesome-pro")
@NgRoutable(path = "frameworks/web-awesome-pro")
public class WebAwesomeProFrameworkPage extends FrameworkDetailPage<WebAwesomeProFrameworkPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(

            // ── Pro Form Controls ────────────────────────────
            new PluginEntry.ComponentInfo("WaCombobox",
                    "Combination of a text input and a dropdown select that allows users to type to filter and select from a list of options. "
                    + "Supports single and multiple selection, labeling, hints, clearable state, and Angular form integration.",
                    "com.jwebmp.webawesomepro.components.combobox",
                    List.of(
                            new PluginEntry.PropertyInfo("value", "String", "null", "The current selected value(s)"),
                            new PluginEntry.PropertyInfo("placeholder", "String", "null", "Placeholder text when no option is selected"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the combobox"),
                            new PluginEntry.PropertyInfo("clearable", "Boolean", "false", "Shows a clear button when a value is selected"),
                            new PluginEntry.PropertyInfo("multiple", "Boolean", "false", "Allows multiple selections"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Component size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text above the combobox"),
                            new PluginEntry.PropertyInfo("hint", "String", "null", "Hint text below the combobox"),
                            new PluginEntry.PropertyInfo("required", "Boolean", "false", "Makes selection required for form validation"),
                            new PluginEntry.PropertyInfo("form", "String", "null", "Form ID to associate with")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Basic Combobox", "Create a filterable combobox with options.",
                                    "var combo = new WaCombobox<>(\"Search items\");\ncombo.add(new WaSelectOption<>(\"item1\", \"Item 1\"));\ncombo.add(new WaSelectOption<>(\"item2\", \"Item 2\"));\ncombo.add(new WaSelectOption<>(\"item3\", \"Item 3\"));", "java"),
                            new PluginEntry.ExampleSnippet("Multiple Selection", "Allow selecting multiple items with clear button.",
                                    "var combo = new WaCombobox<>(\"Tags\");\ncombo.setMultiple(true);\ncombo.setClearable(true);\ncombo.add(new WaSelectOption<>(\"java\", \"Java\"));\ncombo.add(new WaSelectOption<>(\"angular\", \"Angular\"));\ncombo.add(new WaSelectOption<>(\"vertx\", \"Vert.x\"));", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new WaCombobox<>()", "Creates an empty wa-combobox element"),
                            new PluginEntry.ConstructorInfo("new WaCombobox<>(String placeholder)", "Creates a combobox with placeholder text")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("bind", "J", "bind(String variableName)", "Two-way binds the selected value via ngModel")
                    ),
                    List.of(
                            new PluginEntry.EventInfo("wa-input", "Fires as the user types in the filter input"),
                            new PluginEntry.EventInfo("wa-change", "Fires when the selected value changes"),
                            new PluginEntry.EventInfo("wa-focus", "Fires when the combobox gains focus"),
                            new PluginEntry.EventInfo("wa-blur", "Fires when the combobox loses focus"),
                            new PluginEntry.EventInfo("wa-clear", "Fires when the clear button is clicked"),
                            new PluginEntry.EventInfo("wa-show", "Fires when the dropdown opens"),
                            new PluginEntry.EventInfo("wa-hide", "Fires when the dropdown closes")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("default", "Combobox options (wa-option elements)"),
                            new PluginEntry.SlotInfo("label", "Custom label content"),
                            new PluginEntry.SlotInfo("hint", "Custom hint content"),
                            new PluginEntry.SlotInfo("start", "Content before the input"),
                            new PluginEntry.SlotInfo("end", "Content after the input"),
                            new PluginEntry.SlotInfo("clear-icon", "Custom clear icon")
                    ),
                    List.of()
            ),
            new PluginEntry.ComponentInfo("WaFileInput",
                    "File upload input control with single and multiple file selection, accepted file types, drag-and-drop, "
                    + "and Angular form integration via ControlValueAccessor (value type: FileList).",
                    "com.jwebmp.webawesomepro.components.fileinput",
                    List.of(
                            new PluginEntry.PropertyInfo("accept", "String", "null", "Comma-separated list of accepted file types (e.g. 'image/*,.pdf')"),
                            new PluginEntry.PropertyInfo("multiple", "Boolean", "false", "Allows selecting multiple files"),
                            new PluginEntry.PropertyInfo("disabled", "Boolean", "false", "Disables the file input"),
                            new PluginEntry.PropertyInfo("label", "String", "null", "Label text above the file input"),
                            new PluginEntry.PropertyInfo("hint", "String", "null", "Hint text below the file input"),
                            new PluginEntry.PropertyInfo("required", "Boolean", "false", "Makes file selection required"),
                            new PluginEntry.PropertyInfo("size", "Size", "null", "Component size: Small, Medium, Large"),
                            new PluginEntry.PropertyInfo("form", "String", "null", "Form ID to associate with")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Image Upload", "Accept only images and PDFs.",
                                    "var fileInput = new WaFileInput<>();\nfileInput.setAccept(\"image/*,.pdf\");\nfileInput.setMultiple(true);\nfileInput.setLabel(\"Upload files\");", "java"),
                            new PluginEntry.ExampleSnippet("Single Document Upload", "Upload a single document.",
                                    "var fileInput = new WaFileInput<>(\"Upload document\");\nfileInput.setAccept(\".doc,.docx,.pdf\");\nfileInput.setRequired(true);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new WaFileInput<>()", "Creates an empty wa-file-input element"),
                            new PluginEntry.ConstructorInfo("new WaFileInput<>(String label)", "Creates a file input with label text")
                    ),
                    List.of(),
                    List.of(
                            new PluginEntry.EventInfo("wa-change", "Fires when files are selected"),
                            new PluginEntry.EventInfo("wa-focus", "Fires when the input gains focus"),
                            new PluginEntry.EventInfo("wa-blur", "Fires when the input loses focus")
                    ),
                    List.of(
                            new PluginEntry.SlotInfo("label", "Custom label content"),
                            new PluginEntry.SlotInfo("hint", "Custom hint content"),
                            new PluginEntry.SlotInfo("button", "Custom trigger button")
                    ),
                    List.of()
            ),

            // ── Pro Charts (Chart.js-backed) ─────────────────
            new PluginEntry.ComponentInfo("WaChart",
                    "Base chart component with Chart.js integration. All chart types extend WaChartBase which provides shared properties for labels, axes, and legend.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title label"),
                            new PluginEntry.PropertyInfo("description", "String", "null", "Accessible description for screen readers"),
                            new PluginEntry.PropertyInfo("xAxisLabel", "String", "null", "Label for the X axis"),
                            new PluginEntry.PropertyInfo("yAxisLabel", "String", "null", "Label for the Y axis"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Position of the legend: top, bottom, left, right"),
                            new PluginEntry.PropertyInfo("stacked", "Boolean", "false", "Enables stacked mode for bar/line charts")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Chart Setup", "All charts share the same base properties.",
                            "var chart = new WaBarChart<>();\nchart.setLabel(\"Monthly Revenue\");\nchart.setXAxisLabel(\"Month\");\nchart.setYAxisLabel(\"Revenue ($)\");\nchart.setLegendPosition(LegendPosition.Bottom);", "java")),
                    List.of(), List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaBarChart",
                    "Bar chart with grouped and stacked variants. Extends WaChartBase with Chart.js bar chart rendering.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("stacked", "Boolean", "false", "Stacks bars on top of each other"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Stacked Bar Chart", "Create a stacked bar chart.",
                            "var chart = new WaBarChart<>();\nchart.setLabel(\"Sales by Region\");\nchart.setStacked(true);\nchart.setLegendPosition(LegendPosition.Top);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaBarChart<>()", "Creates a wa-bar-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaLineChart",
                    "Line chart with tension and fill options. Supports smooth curves via tension and area fills.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Line Chart", "Create a line chart with axes.",
                            "var chart = new WaLineChart<>();\nchart.setLabel(\"User Growth\");\nchart.setXAxisLabel(\"Month\");\nchart.setYAxisLabel(\"Users\");", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaLineChart<>()", "Creates a wa-line-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaPieChart",
                    "Pie chart with segment customization. Displays data as proportional slices.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(new PluginEntry.ExampleSnippet("Pie Chart", "Create a simple pie chart.",
                            "var chart = new WaPieChart<>();\nchart.setLabel(\"Market Share\");\nchart.setLegendPosition(LegendPosition.Right);", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaPieChart<>()", "Creates a wa-pie-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaDoughnutChart",
                    "Doughnut chart with cutout and rotation options. A pie chart with a hole in the center.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaDoughnutChart<>()", "Creates a wa-doughnut-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaBubbleChart",
                    "Bubble chart with x/y/radius data points. Each point is rendered as a circle with its radius encoding a third dimension.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaBubbleChart<>()", "Creates a wa-bubble-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaScatterChart",
                    "Scatter plot with point styles. Displays data as individual points on a Cartesian grid.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("xAxisLabel", "String", "null", "X axis label"),
                            new PluginEntry.PropertyInfo("yAxisLabel", "String", "null", "Y axis label"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaScatterChart<>()", "Creates a wa-scatter-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaRadarChart",
                    "Radar/spider chart for multi-axis comparison. Plots data across multiple axes radiating from a center point.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaRadarChart<>()", "Creates a wa-radar-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaPolarAreaChart",
                    "Polar area chart with angular scales. Like a pie chart but each segment has equal angle and the radius encodes the value.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(
                            new PluginEntry.PropertyInfo("label", "String", "null", "Chart title"),
                            new PluginEntry.PropertyInfo("legendPosition", "LegendPosition", "null", "Legend position")
                    ),
                    List.of(),
                    List.of(new PluginEntry.ConstructorInfo("new WaPolarAreaChart<>()", "Creates a wa-polar-area-chart element")),
                    List.of(), List.of(), List.of(), List.of()),
            new PluginEntry.ComponentInfo("WaSparkline",
                    "Compact inline sparkline chart without axes or labels. Typically used for trend indicators in tables, cards, or dashboards.",
                    "com.jwebmp.webawesomepro.components.chart",
                    List.of(),
                    List.of(new PluginEntry.ExampleSnippet("Inline Sparkline", "Add a sparkline trend indicator.",
                            "var spark = new WaSparkline<>();\n// Data is bound via Angular template or slot content", "java")),
                    List.of(new PluginEntry.ConstructorInfo("new WaSparkline<>()", "Creates a wa-sparkline element")),
                    List.of(), List.of(), List.of(), List.of()),

            // ── Pro Icons ────────────────────────────────────
            new PluginEntry.ComponentInfo("WaIconFA",
                    "Font Awesome icon with Pro styling integration. Extends WaIcon and accepts FontAwesome Pro icon enums, "
                    + "families (Solid, Regular, Light, Thin, Duotone), and variants.",
                    "com.jwebmp.webawesomepro.components.page.faicon",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Pro Solid Icon", "Create a solid FA Pro icon.",
                                    "var icon = new WaIconFA<>(FontAwesome5ProIcons.user);", "java"),
                            new PluginEntry.ExampleSnippet("Pro Light Icon", "Create a light-weight icon.",
                                    "var icon = new WaIconFA<>(FontAwesome5ProIcons.heart, FontAwesomeStyles.Light);", "java"),
                            new PluginEntry.ExampleSnippet("Icon with Family and Variant", "Specify family and variant explicitly.",
                                    "var icon = new WaIconFA<>(\"bell\", FontAwesomeStyles.Duotone, IconVariant.Solid);", "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("new WaIconFA<>()", "Creates an empty WaIconFA element"),
                            new PluginEntry.ConstructorInfo("new WaIconFA<>(IFontAwesomeIcon iconName)", "Creates an icon from a FA icon enum"),
                            new PluginEntry.ConstructorInfo("new WaIconFA<>(IFontAwesomeIcon iconName, FontAwesomeStyles family)", "Creates an icon with specific family"),
                            new PluginEntry.ConstructorInfo("new WaIconFA<>(String iconName, FontAwesomeStyles family, IconVariant variant)", "Creates an icon with name, family, and variant")
                    ),
                    List.of(), List.of(), List.of(),
                    List.of("All WaIcon capabilities — name, family, variant, src, label, fixed-width, duotone coloring"))
    );

    public WebAwesomeProFrameworkPage()
    {
        super(PluginCatalog.getById("web-awesome-pro").orElseThrow());
    }

    @Override
    protected String frameworkId()
    {
        return "web-awesome-pro";
    }

    @Override
    protected List<PluginEntry.ComponentInfo> frameworkComponents()
    {
        return COMPONENTS;
    }
}


