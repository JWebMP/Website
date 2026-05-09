package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-fontawesome-pro")
@NgRoutable(path = "plugins/fontawesome-pro")
public class FontAwesomeProPluginPage extends PluginDetailPage<FontAwesomeProPluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            // 0 - FontAwesomeDuotone
            new PluginEntry.ComponentInfo("FontAwesomeDuotone", "Duotone icon component — renders a fa-duotone-icon Angular element, extends FontAwesome with two-layer rendering and primary/secondary color support",
                    "com.jwebmp.plugins.fontawesome5pro",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Duotone Icon",
                                    "Create a duotone icon with custom colors.",
                                    "var icon = new FontAwesomeDuotone<>()\n    .setStyle(FontAwesome5ProStyles.Duotone)\n    .setIcon(FontAwesome5ProIcons.calendar)\n    .primaryColour(\"#1976D2\")\n    .secondaryColour(\"#BBDEFB\")\n    .setSize(FontAwesomeSizes.$3x);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FontAwesomeDuotone()", "Creates a duotone icon element (fa-duotone-icon tag)")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("primaryColour", "J", "primaryColour(String)", "Set the primary layer color"),
                            new PluginEntry.MethodInfo("secondaryColour", "J", "secondaryColour(String)", "Set the secondary layer color")
                    ), null, null, null),

            // 1 - FontAwesome5ProStyles
            new PluginEntry.ComponentInfo("FontAwesome5ProStyles", "Enum of Pro-exclusive icon styles — additional style variants available with a Pro license",
                    "com.jwebmp.plugins.fontawesome5pro",
                    List.of(
                            new PluginEntry.PropertyInfo("Duotone", "FontAwesome5ProStyles", null, "Two-tone layered icons (fad) — supports primary/secondary colors"),
                            new PluginEntry.PropertyInfo("DuotoneSharp", "FontAwesome5ProStyles", null, "Sharp-edged duotone icons (fads) — geometric two-tone style"),
                            new PluginEntry.PropertyInfo("Solid", "FontAwesome5ProStyles", null, "Pro solid icons (fas) — same weight as free but with the full Pro icon set")
                    ),
                    null, null, null, null, null, null),

            // 2 - FontAwesome5Families
            new PluginEntry.ComponentInfo("FontAwesome5Families", "Enum of Pro+ icon families — decorative and specialty font families available with Pro+ subscription",
                    "com.jwebmp.plugins.fontawesome5pro",
                    List.of(
                            new PluginEntry.PropertyInfo("Duotone", "FontAwesome5Families", null, "Duotone family (fad) — two-layer icon rendering"),
                            new PluginEntry.PropertyInfo("Sharp", "FontAwesome5Families", null, "Sharp family — geometric, angular icon edges"),
                            new PluginEntry.PropertyInfo("DuotoneSharp", "FontAwesome5Families", null, "Sharp Duotone family — sharp edges with two-tone layers"),
                            new PluginEntry.PropertyInfo("Chisel", "FontAwesome5Families", null, "Chisel family — carved, dimensional icon style"),
                            new PluginEntry.PropertyInfo("Etch", "FontAwesome5Families", null, "Etch family — etched/engraved line-art style"),
                            new PluginEntry.PropertyInfo("Jelly", "FontAwesome5Families", null, "Jelly family — soft, rounded, playful icon style"),
                            new PluginEntry.PropertyInfo("NotDog", "FontAwesome5Families", null, "NotDog family — bold, chunky icon style"),
                            new PluginEntry.PropertyInfo("Slab", "FontAwesome5Families", null, "Slab family — slab-serif weighted icon style"),
                            new PluginEntry.PropertyInfo("ThumbPrint", "FontAwesome5Families", null, "ThumbPrint family — fingerprint/texture style"),
                            new PluginEntry.PropertyInfo("Whiteboard", "FontAwesome5Families", null, "Whiteboard family — hand-drawn whiteboard sketch style")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Using Pro+ Families",
                                    "Use a Pro+ family with the FontAwesome component.",
                                    "// Set the family on the page configurator\nFontAwesome5ProPageConfigurator.enableFamily(IconFamily.Jelly);\n\n// Use the icon with the family\nvar icon = new FontAwesome<>()\n    .setIcon(FontAwesome5ProIcons.star)\n    .setFamily(FontAwesome5Families.Jelly);",
                                    "java")
                    ),
                    null, null, null, null, null),

            // 3 - IconFamily
            new PluginEntry.ComponentInfo("IconFamily", "Enum of all icon families for dependency management — used with FontAwesome5ProPageConfigurator.enableFamily() to selectively install npm packages",
                    "com.jwebmp.plugins.fontawesome5.options",
                    List.of(
                            new PluginEntry.PropertyInfo("Classic", "IconFamily", null, "Pro Classic — overrides free solid/regular with Pro versions (&#64;fortawesome/pro-solid-svg-icons)"),
                            new PluginEntry.PropertyInfo("Brands", "IconFamily", null, "Brand icons (&#64;fortawesome/free-brands-svg-icons)"),
                            new PluginEntry.PropertyInfo("Duotone", "IconFamily", null, "Pro Duotone two-layer icons (&#64;fortawesome/pro-duotone-svg-icons)"),
                            new PluginEntry.PropertyInfo("Sharp", "IconFamily", null, "Sharp geometric icons (&#64;fortawesome/sharp-solid-svg-icons)"),
                            new PluginEntry.PropertyInfo("Sharp_Duotone", "IconFamily", null, "Sharp Duotone (&#64;fortawesome/sharp-duotone-solid-svg-icons)"),
                            new PluginEntry.PropertyInfo("Chisel", "IconFamily", null, "Pro+ Chisel regular (&#64;fortawesome/chisel-regular-svg-icons)"),
                            new PluginEntry.PropertyInfo("Etch", "IconFamily", null, "Pro+ Etch solid (&#64;fortawesome/etch-solid-svg-icons)"),
                            new PluginEntry.PropertyInfo("Graphite", "IconFamily", null, "Pro+ Graphite thin (&#64;fortawesome/graphite-thin-svg-icons)"),
                            new PluginEntry.PropertyInfo("Jelly", "IconFamily", null, "Pro+ Jelly regular (&#64;fortawesome/jelly-regular-svg-icons)"),
                            new PluginEntry.PropertyInfo("Jelly_Duo", "IconFamily", null, "Pro+ Jelly Duo regular (&#64;fortawesome/jelly-duo-regular-svg-icons)"),
                            new PluginEntry.PropertyInfo("Jelly_Fill", "IconFamily", null, "Pro+ Jelly Fill regular (&#64;fortawesome/jelly-fill-regular-svg-icons)"),
                            new PluginEntry.PropertyInfo("Notdog", "IconFamily", null, "Pro+ Notdog solid (&#64;fortawesome/notdog-solid-svg-icons)"),
                            new PluginEntry.PropertyInfo("Notdog_Duo", "IconFamily", null, "Pro+ Notdog Duo solid (&#64;fortawesome/notdog-duo-solid-svg-icons)"),
                            new PluginEntry.PropertyInfo("Slab", "IconFamily", null, "Pro+ Slab regular (&#64;fortawesome/slab-regular-svg-icons)"),
                            new PluginEntry.PropertyInfo("Slab_Press", "IconFamily", null, "Pro+ Slab Press regular (&#64;fortawesome/slab-press-regular-svg-icons)"),
                            new PluginEntry.PropertyInfo("Thumbprint", "IconFamily", null, "Pro+ Thumbprint light (&#64;fortawesome/thumbprint-light-svg-icons)"),
                            new PluginEntry.PropertyInfo("Utility", "IconFamily", null, "Pro+ Utility semibold (&#64;fortawesome/utility-semibold-svg-icons)"),
                            new PluginEntry.PropertyInfo("Utility_Duo", "IconFamily", null, "Pro+ Utility Duo semibold (&#64;fortawesome/utility-duo-semibold-svg-icons)"),
                            new PluginEntry.PropertyInfo("Utility_Fill", "IconFamily", null, "Pro+ Utility Fill semibold (&#64;fortawesome/utility-fill-semibold-svg-icons)"),
                            new PluginEntry.PropertyInfo("Whiteboard", "IconFamily", null, "Pro+ Whiteboard semibold (&#64;fortawesome/whiteboard-semibold-svg-icons)"),
                            new PluginEntry.PropertyInfo("Kit", "IconFamily", null, "Kit — custom uploaded icons via Font Awesome Kits (fak prefix, cloud-delivered)"),
                            new PluginEntry.PropertyInfo("Kit_Custom", "IconFamily", null, "Kit Custom — alias for kit-custom uploaded icons")
                    ),
                    null, null, null, null, null, null),

            // 4 - FontAwesome5ProIcons
            new PluginEntry.ComponentInfo("FontAwesome5ProIcons", "Enum of 4,085 Pro icons — the full Pro icon set including all icons not available in the free tier",
                    "com.jwebmp.plugins.fontawesome5pro",
                    List.of(
                            new PluginEntry.PropertyInfo("Numbers", "FontAwesome5ProIcons", null, "$0, $1, $2, $3, $4, $5, $6, $7, $8, $9, $00, $360_degrees"),
                            new PluginEntry.PropertyInfo("Pro-Only Objects", "FontAwesome5ProIcons", null, "abacus, acorn, air_conditioner, airplay, alarm_clock, alarm_exclamation, alarm_plus, alarm_snooze, album, album_circle_plus, album_collection, alicorn, alien, alien_8bit"),
                            new PluginEntry.PropertyInfo("Pro-Only UI", "FontAwesome5ProIcons", null, "align_slash, alt, amp, ampersand, angle, aperture, arrow_down_from_arc, arrow_up_from_arc, badge, badge_check, badge_dollar, badge_percent, ballot, ballot_check"),
                            new PluginEntry.PropertyInfo("Pro-Only Media", "FontAwesome5ProIcons", null, "boombox, camcorder, cassette_betamax, cassette_tape, cassette_vhs, clapperboard, clapperboard_play, compact_disc, disc_drive, film_canister, film_simple, gramophone"),
                            new PluginEntry.PropertyInfo("Pro-Only Food", "FontAwesome5ProIcons", null, "apple_core, avocado, bacon, bagel, banana, bone, bread_loaf, bread_slice, burger, burrito, cake_slice, candy, candy_bar, candy_cane, cheese, cherry, chocolate_bar"),
                            new PluginEntry.PropertyInfo("Pro-Only Animals", "FontAwesome5ProIcons", null, "bat, beaver, bee, bird, butterfly, camel, cat_space, deer, dolphin, duck, eagle, elephant, flamingo, lobster, monkey, moose, narwhal, octopus, otter, parrot, pegasus, rabbit, raccoon, ram, seal, shark, snake, squid, swan, turkey, turtle, unicorn, whale"),
                            new PluginEntry.PropertyInfo("Pro-Only Weather", "FontAwesome5ProIcons", null, "cloud_bolt_moon, cloud_bolt_sun, cloud_drizzle, cloud_fog, cloud_hail, cloud_hail_mixed, cloud_meatball, cloud_moon_rain, cloud_rainbow, cloud_sleet, cloud_snow, eclipse, fog, humidity, moon_cloud, rainbow, raindrops, stars, sun_bright, sun_cloud, sun_haze, sunrise, sunset, thunderstorm, tornado, wind_warning"),
                            new PluginEntry.PropertyInfo("Pro-Only Holidays", "FontAwesome5ProIcons", null, "candy_cane, chimney, dreidel, fireplace, gifts, gingerbread_man, hat_santa, hat_winter, holly_berry, ice_skate, icicles, lights_holiday, mistletoe, ornament, sled, sleigh, snowman, snowman_head, stocking, tree_christmas, wreath"),
                            new PluginEntry.PropertyInfo("Pro-Only Sports", "FontAwesome5ProIcons", null, "badminton, baseball_bat_ball, basketball_hoop, boxing_glove, cricket_bat_ball, curling_stone, field_hockey_stick_ball, fishing_rod, golf_ball_tee, hockey_puck, lacrosse_stick, paddle_ball, pickleball, polo, racquet, shuttlecock, ski_boot, ski_pole, snorkel, surfboard, tennis_ball, volleyball"),
                            new PluginEntry.PropertyInfo("All Std Icons Included", "FontAwesome5ProIcons", null, "All 1,932 free icons are also available: home, cog, user, search, check, times, spinner, envelope, bell, calendar, plus, minus, trash, edit, save, etc.")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Pro Icon Usage",
                                    "Use a Pro-only icon with a Pro style.",
                                    "var icon = new FontAwesome<>(FontAwesome5ProStyles.Duotone, FontAwesome5ProIcons.alarm_clock)\n    .primaryColour(\"#E53935\")\n    .secondaryColour(\"#FFCDD2\")\n    .setSize(FontAwesomeSizes.$2x);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Sharp Style Icon",
                                    "Use the Sharp Duotone style.",
                                    "var icon = new FontAwesome<>(FontAwesome5ProStyles.DuotoneSharp, FontAwesome5ProIcons.badge_check)\n    .setSize(FontAwesomeSizes.Lg);",
                                    "java")
                    ),
                    null, null, null, null, null),

            // 5 - FontAwesome5ProPageConfigurator
            new PluginEntry.ComponentInfo("FontAwesome5ProPageConfigurator", "Page configurator — manages Pro/Pro+ icon family npm dependencies and Kit-based cloud delivery",
                    "com.jwebmp.plugins.fontawesome5pro",
                    List.of(
                            new PluginEntry.PropertyInfo("kitCode", "String", "\"\"", "Font Awesome Kit ID for cloud-delivered icons (bypasses npm packages)"),
                            new PluginEntry.PropertyInfo("proKey", "String", null, "Pro license key for npm registry authentication"),
                            new PluginEntry.PropertyInfo("enableAllProVariants", "boolean", "false", "When true, adds all Pro Classic + Sharp + Duotone packages automatically")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Kit Mode",
                                    "Use a Font Awesome Kit for cloud-delivered Pro icons.",
                                    "// In your startup/configuration:\nFontAwesome5ProPageConfigurator.setKitCode(\"cf4534f35c\");\n// All Pro icons are now loaded from the cloud — no npm packages needed",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Selective Family Mode",
                                    "Enable specific icon families to install only the npm packages you need.",
                                    "// Enable just the families you need\nFontAwesome5ProPageConfigurator.enableFamily(IconFamily.Duotone);\nFontAwesome5ProPageConfigurator.enableFamily(IconFamily.Sharp);\nFontAwesome5ProPageConfigurator.enableFamily(IconFamily.Jelly);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Enable All Pro Variants",
                                    "Add all Pro Classic, Sharp, and Duotone packages at once.",
                                    "FontAwesome5ProPageConfigurator.setEnableAllProVariants(true);",
                                    "java")
                    ),
                    null,
                    List.of(
                            new PluginEntry.MethodInfo("setKitCode (static)", "void", "setKitCode(String kitCode)", "Set the Kit ID for cloud delivery — disables npm package mode"),
                            new PluginEntry.MethodInfo("enableFamily (static)", "void", "enableFamily(IconFamily family)", "Enable an icon family so its npm package is added"),
                            new PluginEntry.MethodInfo("disableFamily (static)", "void", "disableFamily(IconFamily family)", "Disable an icon family"),
                            new PluginEntry.MethodInfo("isFamilyEnabled (static)", "boolean", "isFamilyEnabled(IconFamily family)", "Check if a family is enabled"),
                            new PluginEntry.MethodInfo("getEnabledFamilies (static)", "Set&lt;IconFamily&gt;", "getEnabledFamilies()", "Get all currently enabled families"),
                            new PluginEntry.MethodInfo("setEnableAllProVariants (static)", "void", "setEnableAllProVariants(boolean)", "Enable/disable all Pro variant packages at once"),
                            new PluginEntry.MethodInfo("setProKey (static)", "void", "setProKey(String proKey)", "Set the Pro license key for npm registry auth")
                    ), null, null, null)
    );

    public FontAwesomeProPluginPage()
    {
        super(PluginCatalog.getById("fontawesome-pro").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Pro Icon Styles",
                        "Use the extended Pro icon styles — Regular, Light, Duotone, and Thin.",
                        "// Pro Regular icon\nFontAwesome icon = IFontAwesome.createIcon(\n    FontAwesomeIcons.user,\n    FontAwesomeStyles.Regular);\n\n// Pro Light icon\nFontAwesome light = IFontAwesome.createIcon(\n    FontAwesomeIcons.heart,\n    FontAwesomeStyles.Light);\n\n// Pro Duotone icon\nFontAwesome duo = IFontAwesome.createIcon(\n    FontAwesomeIcons.bell,\n    FontAwesomeStyles.Duotone);",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "FontAwesomeProPageConfigurator registers Pro icon packs — Regular, Light, Duotone, Thin SVG icons")
        );
    }
}
