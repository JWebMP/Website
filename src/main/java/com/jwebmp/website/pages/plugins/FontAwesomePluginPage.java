package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-fontawesome")
@NgRoutable(path = "plugins/fontawesome")
public class FontAwesomePluginPage extends PluginDetailPage<FontAwesomePluginPage>
{
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            // 0 - FontAwesome
            new PluginEntry.ComponentInfo("FontAwesome", "Icon component — renders an fa-icon Angular element with style, icon enum, size, animation, transforms, masking, and duotone color support",
                    "com.jwebmp.plugins.fontawesome5",
                    List.of(
                            new PluginEntry.PropertyInfo("style", "FontAwesomeStyles", "Classic", "Icon style: Classic, Duotone, Brand, or Filled"),
                            new PluginEntry.PropertyInfo("icon", "IFontAwesomeIcon", null, "Icon enum value (FontAwesomeIcons or FontAwesomeBrandIcons)")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Solid Icon with Size",
                                    "Create a solid cog icon at 3x size.",
                                    "var icon = new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.cog)\n    .setSize(FontAwesomeSizes.$3x);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Brand Icon",
                                    "Create a GitHub brand icon.",
                                    "var github = new FontAwesome<>(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.github);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Spinning Icon with Transform",
                                    "Create a spinning spinner icon with a grow transform.",
                                    "var spinner = new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.spinner)\n    .spin()\n    .setSize(FontAwesomeSizes.$2x)\n    .transform(FontAwesomeTransforms.Grow_4);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Duotone Icon with Colors",
                                    "Create a duotone icon with custom primary/secondary colors.",
                                    "var icon = new FontAwesome<>(FontAwesomeStyles.Duotone, FontAwesomeIcons.calendar)\n    .primaryColour(\"#2196F3\")\n    .secondaryColour(\"#90CAF9\");",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Masked Icon",
                                    "Create a masked icon using the static factory method.",
                                    "var masked = IFontAwesome.createMaskIcon(\n    FontAwesomeIcons.pencil, FontAwesomeStyles.Classic,\n    FontAwesomeIcons.circle, FontAwesomeStyles.Classic);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Static Factory Methods",
                                    "Use convenience icon() factory methods.",
                                    "// Simple icon\nvar home = FontAwesome.icon(FontAwesomeIcons.home);\n\n// Icon with style\nvar star = FontAwesome.icon(FontAwesomeIcons.star, FontAwesomeStyles.Filled);\n\n// Icon with size and style\nvar bell = FontAwesome.icon(FontAwesomeIcons.bell, FontAwesomeSizes.Lg, FontAwesomeStyles.Classic);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FontAwesome(FontAwesomeStyles style, IFontAwesomeIcon icon)", "Creates an icon with the given style and icon"),
                            new PluginEntry.ConstructorInfo("FontAwesome()", "Creates a blank icon element (set icon/style later)")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setIcon", "J", "setIcon(IFontAwesomeIcon)", "Set the icon enum value"),
                            new PluginEntry.MethodInfo("setStyle", "J", "setStyle(FontAwesomeStyles)", "Set the icon style (Classic, Brand, Duotone, Filled)"),
                            new PluginEntry.MethodInfo("setSize", "J", "setSize(FontAwesomeSizes)", "Set the icon size (Xs, Sm, Lg, 2x–10x)"),
                            new PluginEntry.MethodInfo("spin", "J", "spin()", "Apply continuous spin animation"),
                            new PluginEntry.MethodInfo("pulse", "J", "pulse()", "Apply 8-step pulse rotation animation"),
                            new PluginEntry.MethodInfo("fixedWidth", "J", "fixedWidth()", "Set fixed width for vertical alignment"),
                            new PluginEntry.MethodInfo("pullLeft", "J", "pullLeft()", "Float the icon to the left"),
                            new PluginEntry.MethodInfo("pullRight", "J", "pullRight()", "Float the icon to the right"),
                            new PluginEntry.MethodInfo("border", "J", "border()", "Add a border around the icon"),
                            new PluginEntry.MethodInfo("inverse", "J", "inverse()", "Invert the icon color (white)"),
                            new PluginEntry.MethodInfo("transform", "J", "transform(FontAwesomeTransforms...)", "Apply power transforms (grow, shrink, rotate, flip, position)"),
                            new PluginEntry.MethodInfo("primaryColour", "J", "primaryColour(String)", "Set primary color for duotone icons"),
                            new PluginEntry.MethodInfo("secondaryColour", "J", "secondaryColour(String)", "Set secondary color for duotone icons"),
                            new PluginEntry.MethodInfo("style", "J", "style(CSSImpl)", "Apply custom inline CSS styles"),
                            new PluginEntry.MethodInfo("icon (static)", "FontAwesome", "FontAwesome.icon(IFontAwesomeIcon)", "Static factory: create a Classic icon"),
                            new PluginEntry.MethodInfo("icon (static)", "FontAwesome", "FontAwesome.icon(IFontAwesomeIcon, FontAwesomeSizes)", "Static factory: icon with size"),
                            new PluginEntry.MethodInfo("icon (static)", "FontAwesome", "FontAwesome.icon(IFontAwesomeIcon, FontAwesomeStyles)", "Static factory: icon with style"),
                            new PluginEntry.MethodInfo("icon (static)", "FontAwesome", "FontAwesome.icon(IFontAwesomeIcon, FontAwesomeSizes, FontAwesomeStyles)", "Static factory: icon with size and style"),
                            new PluginEntry.MethodInfo("iconString (static)", "String", "FontAwesome.iconString(IFontAwesomeIcon)", "Static factory: render icon as HTML string"),
                            new PluginEntry.MethodInfo("createIcon (static)", "FontAwesome", "IFontAwesome.createIcon(IFontAwesomeIcon, FontAwesomeStyles)", "Static factory: create icon via interface"),
                            new PluginEntry.MethodInfo("createMaskIcon (static)", "FontAwesome", "IFontAwesome.createMaskIcon(IFontAwesomeIcon, FontAwesomeStyles, IFontAwesomeIcon, FontAwesomeStyles, FontAwesomeDisplayOptions...)", "Static factory: create a masked icon with transforms")
                    ), null, null, null),

            // 1 - FontAwesomeLayers
            new PluginEntry.ComponentInfo("FontAwesomeLayers", "Layered icon container — combines multiple icons, counters, and text overlays using fa-layers Angular element",
                    "com.jwebmp.plugins.fontawesome5",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Layers with Counter",
                                    "Create a layered icon with an envelope and counter badge.",
                                    "var layers = new FontAwesomeLayers<>()\n    .addIcon(new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.envelope))\n    .addCounter(new FontAwesomeLayerCounter<>().setText(\"99+\"));",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Stacked Icons",
                                    "Combine a circle background with a smaller icon on top.",
                                    "var layers = new FontAwesomeLayers<>()\n    .setSize(FontAwesomeSizes.$3x)\n    .addIcon(new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.circle))\n    .addIcon(new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.check)\n        .inverse()\n        .transform(FontAwesomeTransforms.Shrink_6));",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Layers with Text",
                                    "Overlay text on top of an icon.",
                                    "var layers = new FontAwesomeLayers<>()\n    .addIcon(new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.certificate))\n    .addText(new FontAwesomeLayerText<>().setText(\"NEW\")\n        .transform(FontAwesomeTransforms.Shrink_4));",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FontAwesomeLayers()", "Creates an empty layers container")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addIcon", "J", "addIcon(FontAwesome&lt;?&gt;)", "Add an icon to the layers stack"),
                            new PluginEntry.MethodInfo("addCounter", "J", "addCounter(FontAwesomeLayerCounter)", "Add a counter badge to the layers"),
                            new PluginEntry.MethodInfo("addText", "J", "addText(FontAwesomeLayerText)", "Add text overlay to the layers"),
                            new PluginEntry.MethodInfo("setSize", "J", "setSize(FontAwesomeSizes)", "Set the overall layers container size"),
                            new PluginEntry.MethodInfo("spin", "J", "spin()", "Spin the entire layers container"),
                            new PluginEntry.MethodInfo("pulse", "J", "pulse()", "Pulse the entire layers container"),
                            new PluginEntry.MethodInfo("fixedWidth", "J", "fixedWidth()", "Set fixed width for vertical alignment"),
                            new PluginEntry.MethodInfo("pullLeft", "J", "pullLeft()", "Float layers to the left"),
                            new PluginEntry.MethodInfo("pullRight", "J", "pullRight()", "Float layers to the right"),
                            new PluginEntry.MethodInfo("border", "J", "border()", "Add a border around the layers"),
                            new PluginEntry.MethodInfo("inverse", "J", "inverse()", "Invert all layer icon colors"),
                            new PluginEntry.MethodInfo("transform", "J", "transform(FontAwesomeTransforms...)", "Apply power transforms to the layers container"),
                            new PluginEntry.MethodInfo("primaryColour", "J", "primaryColour(String)", "Set primary color for duotone layers"),
                            new PluginEntry.MethodInfo("secondaryColour", "J", "secondaryColour(String)", "Set secondary color for duotone layers")
                    ), null, null, null),

            // 2 - FontAwesomeLayerCounter
            new PluginEntry.ComponentInfo("FontAwesomeLayerCounter", "Counter badge — renders a fa-layers-counter element overlaid on icon layers, typically used for notification counts",
                    "com.jwebmp.plugins.fontawesome5",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Counter Badge",
                                    "Create a counter badge with text.",
                                    "var counter = new FontAwesomeLayerCounter<>()\n    .setText(\"42\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FontAwesomeLayerCounter()", "Creates a counter badge element")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setText", "J", "setText(String)", "Set the counter display text (e.g. '99+')"),
                            new PluginEntry.MethodInfo("transform", "J", "transform(FontAwesomeTransforms...)", "Apply power transforms to the counter")
                    ), null, null, null),

            // 3 - FontAwesomeLayerText
            new PluginEntry.ComponentInfo("FontAwesomeLayerText", "Text overlay — renders a fa-layers-text element overlaid on icon layers, used for labels and badges within stacked icons",
                    "com.jwebmp.plugins.fontawesome5",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Text Overlay",
                                    "Create a text overlay for layers.",
                                    "var text = new FontAwesomeLayerText<>()\n    .setText(\"FREE\")\n    .transform(FontAwesomeTransforms.Shrink_4);",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FontAwesomeLayerText()", "Creates a text overlay element")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setText", "J", "setText(String)", "Set the display text content"),
                            new PluginEntry.MethodInfo("transform", "J", "transform(FontAwesomeTransforms...)", "Apply power transforms to the text (e.g. shrink, position)")
                    ), null, null, null),

            // 4 - FontAwesomeList
            new PluginEntry.ComponentInfo("FontAwesomeList", "Icon list — replaces default list bullets with Font Awesome icons using fa-ul/fa-li CSS classes",
                    "com.jwebmp.plugins.fontawesome5",
                    List.of(),
                    List.of(
                            new PluginEntry.ExampleSnippet("Icon List",
                                    "Create a list with icon bullets.",
                                    "var list = new FontAwesomeList<>();\nlist.addItem(\"Item one\", new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.check));\nlist.addItem(\"Item two\", new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.times));\nlist.addItem(\"Item three\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FontAwesomeList()", "Creates an unordered icon list"),
                            new PluginEntry.ConstructorInfo("FontAwesomeList(boolean orderedList)", "Creates an ordered or unordered icon list")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("addItem", "J", "addItem(String text, FontAwesome&lt;?&gt; icon)", "Add a list item with an icon bullet"),
                            new PluginEntry.MethodInfo("addItem", "ListItem", "addItem(String text)", "Add a list item without an icon (plain bullet)")
                    ), null, null, null),

            // 5 - FontAwesomeIcons
            new PluginEntry.ComponentInfo("FontAwesomeIcons", "Enum of 1,932 free solid/classic icons — pass to FontAwesome constructor or setIcon() as the icon value",
                    "com.jwebmp.plugins.fontawesome5.icons",
                    List.of(
                            new PluginEntry.PropertyInfo("Navigation", "FontAwesomeIcons", null, "home, arrow_left, arrow_right, arrow_up, arrow_down, angle_left, angle_right, angle_up, angle_down, angles_left, angles_right, chevron_left, chevron_right, chevron_up, chevron_down, caret_left, caret_right, caret_up, caret_down, bars, ellipsis, ellipsis_vertical"),
                            new PluginEntry.PropertyInfo("Actions", "FontAwesomeIcons", null, "check, times, plus, minus, search, edit, trash, save, copy, paste, cut, undo, redo, download, upload, share, print, link, unlink, refresh, sync"),
                            new PluginEntry.PropertyInfo("Communication", "FontAwesomeIcons", null, "envelope, phone, comment, comments, bell, inbox, paper_plane, reply, reply_all, share_nodes, at, hashtag, rss, satellite_dish, tower_cell"),
                            new PluginEntry.PropertyInfo("Users &amp; People", "FontAwesomeIcons", null, "user, users, user_plus, user_minus, user_check, user_xmark, user_gear, user_shield, user_lock, user_group, people_group, person, children, baby"),
                            new PluginEntry.PropertyInfo("Media", "FontAwesomeIcons", null, "image, camera, video, film, music, play, pause, stop, forward, backward, volume_high, volume_low, volume_off, volume_xmark, microphone, headphones, photo_film"),
                            new PluginEntry.PropertyInfo("Files &amp; Documents", "FontAwesomeIcons", null, "file, folder, folder_open, file_pdf, file_word, file_excel, file_powerpoint, file_image, file_video, file_audio, file_code, file_zipper, file_lines, clipboard, note_sticky"),
                            new PluginEntry.PropertyInfo("UI Elements", "FontAwesomeIcons", null, "spinner, circle_notch, gear, cog, sliders, toggle_on, toggle_off, eye, eye_slash, lock, unlock, key, shield, filter, sort, table, list, grip, palette"),
                            new PluginEntry.PropertyInfo("Shapes &amp; Symbols", "FontAwesomeIcons", null, "circle, square, triangle_exclamation, star, heart, bookmark, flag, tag, tags, thumbs_up, thumbs_down, certificate, award, trophy, crown, gem, fire, bolt, snowflake"),
                            new PluginEntry.PropertyInfo("Date &amp; Time", "FontAwesomeIcons", null, "calendar, calendar_days, calendar_check, calendar_plus, calendar_minus, calendar_xmark, clock, hourglass, hourglass_half, hourglass_end, stopwatch, timer"),
                            new PluginEntry.PropertyInfo("Maps &amp; Location", "FontAwesomeIcons", null, "map, map_pin, map_location_dot, location_dot, location_arrow, location_crosshairs, compass, globe, earth_americas, earth_europe, earth_asia, route, signs_post, mountain"),
                            new PluginEntry.PropertyInfo("Charts &amp; Data", "FontAwesomeIcons", null, "chart_bar, chart_line, chart_pie, chart_area, chart_column, chart_simple, database, server, hard_drive, memory, microchip, code, terminal, bug, wrench"),
                            new PluginEntry.PropertyInfo("Commerce", "FontAwesomeIcons", null, "cart_shopping, bag_shopping, basket_shopping, store, shop, cash_register, credit_card, money_bill, coins, wallet, receipt, barcode, qrcode, percent, tags"),
                            new PluginEntry.PropertyInfo("Medical &amp; Science", "FontAwesomeIcons", null, "heart_pulse, stethoscope, syringe, pills, capsules, prescription_bottle, hospital, kit_medical, virus, vial, flask, atom, dna, microscope, biohazard"),
                            new PluginEntry.PropertyInfo("Transport", "FontAwesomeIcons", null, "car, truck, bus, train, plane, helicopter, ship, bicycle, motorcycle, taxi, rocket, shuttle_space, road, gas_pump, charging_station")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Using Icons Enum",
                                    "Pass an icon enum to a FontAwesome component.",
                                    "new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.home);\nnew FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.cog);\nnew FontAwesome<>(FontAwesomeStyles.Filled, FontAwesomeIcons.star);",
                                    "java")
                    ),
                    null, null, null, null, null),

            // 6 - FontAwesomeBrandIcons
            new PluginEntry.ComponentInfo("FontAwesomeBrandIcons", "Enum of 462 brand icons — automatically uses Brand style when no style is specified",
                    "com.jwebmp.plugins.fontawesome5.icons",
                    List.of(
                            new PluginEntry.PropertyInfo("Social Media", "FontAwesomeBrandIcons", null, "twitter, facebook, instagram, linkedin, tiktok, snapchat, pinterest, reddit, tumblr, mastodon, threads, x_twitter, square_facebook, square_twitter, square_instagram"),
                            new PluginEntry.PropertyInfo("Development", "FontAwesomeBrandIcons", null, "github, gitlab, bitbucket, stack_overflow, dev, codepen, jsfiddle, npm, yarn, git_alt, docker, kubernetes, jenkins, confluence, jira"),
                            new PluginEntry.PropertyInfo("Languages &amp; Frameworks", "FontAwesomeBrandIcons", null, "java, python, js, node_js, php, rust, golang, swift, angular, react, vuejs, sass, less, css3, html5, bootstrap, laravel, ember, symfony"),
                            new PluginEntry.PropertyInfo("Cloud &amp; Hosting", "FontAwesomeBrandIcons", null, "aws, azure, google, digital_ocean, cloudflare, linode, heroku, netlify, vercel"),
                            new PluginEntry.PropertyInfo("Operating Systems", "FontAwesomeBrandIcons", null, "apple, windows, linux, ubuntu, redhat, fedora, suse, centos, freebsd, android, chrome_os"),
                            new PluginEntry.PropertyInfo("Browsers", "FontAwesomeBrandIcons", null, "chrome, firefox, safari, edge, opera, internet_explorer, brave"),
                            new PluginEntry.PropertyInfo("Communication", "FontAwesomeBrandIcons", null, "slack, discord, telegram, whatsapp, skype, rocketchat, teamspeak, viber, line, signal"),
                            new PluginEntry.PropertyInfo("Media &amp; Entertainment", "FontAwesomeBrandIcons", null, "youtube, spotify, soundcloud, bandcamp, itunes, audible, twitch, steam, playstation, xbox, nintendo_switch, unity, unreal_engine"),
                            new PluginEntry.PropertyInfo("Payments", "FontAwesomeBrandIcons", null, "paypal, stripe, amazon_pay, apple_pay, google_pay, cc_visa, cc_mastercard, cc_amex, cc_discover, cc_jcb, cc_diners_club, bitcoin, ethereum, monero"),
                            new PluginEntry.PropertyInfo("Design &amp; Creative", "FontAwesomeBrandIcons", null, "figma, sketch, invision, dribbble, behance, artstation, deviantart, unsplash, creative_commons, adobe"),
                            new PluginEntry.PropertyInfo("Companies", "FontAwesomeBrandIcons", null, "amazon, google, microsoft, apple, meta, twitter, shopify, salesforce, atlassian, dropbox, mailchimp, hubspot, wordpress, medium, blogger")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Brand Icons",
                                    "Create brand icons — Brand style is auto-applied.",
                                    "new FontAwesome<>(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.github);\nnew FontAwesome<>(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.twitter);\nnew FontAwesome<>(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.docker);",
                                    "java")
                    ),
                    null, null, null, null, null),

            // 7 - FontAwesomeStyles
            new PluginEntry.ComponentInfo("FontAwesomeStyles", "Enum of icon styles — determines which icon font family is used for rendering",
                    "com.jwebmp.plugins.fontawesome5.options",
                    List.of(
                            new PluginEntry.PropertyInfo("Classic", "FontAwesomeStyles", null, "Classic solid icons (fa-solid / fac)"),
                            new PluginEntry.PropertyInfo("Duotone", "FontAwesomeStyles", null, "Two-tone layered icons (fa-duotone / fad) — supports primaryColour/secondaryColour"),
                            new PluginEntry.PropertyInfo("Brand", "FontAwesomeStyles", null, "Brand/logo icons (fa-brands / fab)"),
                            new PluginEntry.PropertyInfo("Filled", "FontAwesomeStyles", null, "Regular/filled outline icons (fa-regular / far)")
                    ),
                    null, null, null, null, null, null),

            // 8 - FontAwesomeSizes
            new PluginEntry.ComponentInfo("FontAwesomeSizes", "Enum of icon sizes — relative scaling from extra-small to 10x",
                    "com.jwebmp.plugins.fontawesome5.options",
                    List.of(
                            new PluginEntry.PropertyInfo("Xs", "FontAwesomeSizes", null, "Extra small (.75em)"),
                            new PluginEntry.PropertyInfo("Sm", "FontAwesomeSizes", null, "Small (.875em)"),
                            new PluginEntry.PropertyInfo("Lg", "FontAwesomeSizes", null, "Large (1.33em, slightly larger than default)"),
                            new PluginEntry.PropertyInfo("$2x", "FontAwesomeSizes", null, "2x multiplier (2em)"),
                            new PluginEntry.PropertyInfo("$3x", "FontAwesomeSizes", null, "3x multiplier (3em)"),
                            new PluginEntry.PropertyInfo("$4x", "FontAwesomeSizes", null, "4x multiplier (4em)"),
                            new PluginEntry.PropertyInfo("$5x", "FontAwesomeSizes", null, "5x multiplier (5em)"),
                            new PluginEntry.PropertyInfo("$6x", "FontAwesomeSizes", null, "6x multiplier (6em)"),
                            new PluginEntry.PropertyInfo("$7x", "FontAwesomeSizes", null, "7x multiplier (7em)"),
                            new PluginEntry.PropertyInfo("$8x", "FontAwesomeSizes", null, "8x multiplier (8em)"),
                            new PluginEntry.PropertyInfo("$9x", "FontAwesomeSizes", null, "9x multiplier (9em)"),
                            new PluginEntry.PropertyInfo("$10x", "FontAwesomeSizes", null, "10x multiplier (10em)")
                    ),
                    null, null, null, null, null, null),

            // 9 - FontAwesomeTransforms
            new PluginEntry.ComponentInfo("FontAwesomeTransforms", "Enum of power transforms — scale, position, rotate, and flip icons in 1/16em increments without affecting container",
                    "com.jwebmp.plugins.fontawesome5.options",
                    List.of(
                            new PluginEntry.PropertyInfo("Grow_1", "FontAwesomeTransforms", null, "Scale up by 1 unit (1/16em)"),
                            new PluginEntry.PropertyInfo("Grow_2", "FontAwesomeTransforms", null, "Scale up by 2 units"),
                            new PluginEntry.PropertyInfo("Grow_3", "FontAwesomeTransforms", null, "Scale up by 3 units"),
                            new PluginEntry.PropertyInfo("Grow_4", "FontAwesomeTransforms", null, "Scale up by 4 units"),
                            new PluginEntry.PropertyInfo("Grow_5", "FontAwesomeTransforms", null, "Scale up by 5 units"),
                            new PluginEntry.PropertyInfo("Grow_6", "FontAwesomeTransforms", null, "Scale up by 6 units"),
                            new PluginEntry.PropertyInfo("Grow_7", "FontAwesomeTransforms", null, "Scale up by 7 units"),
                            new PluginEntry.PropertyInfo("Grow_8", "FontAwesomeTransforms", null, "Scale up by 8 units"),
                            new PluginEntry.PropertyInfo("Shrink_1", "FontAwesomeTransforms", null, "Scale down by 1 unit"),
                            new PluginEntry.PropertyInfo("Shrink_2", "FontAwesomeTransforms", null, "Scale down by 2 units"),
                            new PluginEntry.PropertyInfo("Shrink_3", "FontAwesomeTransforms", null, "Scale down by 3 units"),
                            new PluginEntry.PropertyInfo("Shrink_4", "FontAwesomeTransforms", null, "Scale down by 4 units"),
                            new PluginEntry.PropertyInfo("Shrink_5", "FontAwesomeTransforms", null, "Scale down by 5 units"),
                            new PluginEntry.PropertyInfo("Shrink_6", "FontAwesomeTransforms", null, "Scale down by 6 units"),
                            new PluginEntry.PropertyInfo("Shrink_7", "FontAwesomeTransforms", null, "Scale down by 7 units"),
                            new PluginEntry.PropertyInfo("Shrink_8", "FontAwesomeTransforms", null, "Scale down by 8 units"),
                            new PluginEntry.PropertyInfo("Up_1", "FontAwesomeTransforms", null, "Move up by 1 unit"),
                            new PluginEntry.PropertyInfo("Up_2", "FontAwesomeTransforms", null, "Move up by 2 units"),
                            new PluginEntry.PropertyInfo("Up_3", "FontAwesomeTransforms", null, "Move up by 3 units"),
                            new PluginEntry.PropertyInfo("Up_4", "FontAwesomeTransforms", null, "Move up by 4 units"),
                            new PluginEntry.PropertyInfo("Up_5", "FontAwesomeTransforms", null, "Move up by 5 units"),
                            new PluginEntry.PropertyInfo("Up_6", "FontAwesomeTransforms", null, "Move up by 6 units"),
                            new PluginEntry.PropertyInfo("Up_7", "FontAwesomeTransforms", null, "Move up by 7 units"),
                            new PluginEntry.PropertyInfo("Up_8", "FontAwesomeTransforms", null, "Move up by 8 units"),
                            new PluginEntry.PropertyInfo("Down_1", "FontAwesomeTransforms", null, "Move down by 1 unit"),
                            new PluginEntry.PropertyInfo("Down_2", "FontAwesomeTransforms", null, "Move down by 2 units"),
                            new PluginEntry.PropertyInfo("Down_3", "FontAwesomeTransforms", null, "Move down by 3 units"),
                            new PluginEntry.PropertyInfo("Down_4", "FontAwesomeTransforms", null, "Move down by 4 units"),
                            new PluginEntry.PropertyInfo("Down_5", "FontAwesomeTransforms", null, "Move down by 5 units"),
                            new PluginEntry.PropertyInfo("Down_6", "FontAwesomeTransforms", null, "Move down by 6 units"),
                            new PluginEntry.PropertyInfo("Down_7", "FontAwesomeTransforms", null, "Move down by 7 units"),
                            new PluginEntry.PropertyInfo("Down_8", "FontAwesomeTransforms", null, "Move down by 8 units"),
                            new PluginEntry.PropertyInfo("Left_1", "FontAwesomeTransforms", null, "Move left by 1 unit"),
                            new PluginEntry.PropertyInfo("Left_2", "FontAwesomeTransforms", null, "Move left by 2 units"),
                            new PluginEntry.PropertyInfo("Left_3", "FontAwesomeTransforms", null, "Move left by 3 units"),
                            new PluginEntry.PropertyInfo("Left_4", "FontAwesomeTransforms", null, "Move left by 4 units"),
                            new PluginEntry.PropertyInfo("Left_5", "FontAwesomeTransforms", null, "Move left by 5 units"),
                            new PluginEntry.PropertyInfo("Left_6", "FontAwesomeTransforms", null, "Move left by 6 units"),
                            new PluginEntry.PropertyInfo("Left_7", "FontAwesomeTransforms", null, "Move left by 7 units"),
                            new PluginEntry.PropertyInfo("Left_8", "FontAwesomeTransforms", null, "Move left by 8 units"),
                            new PluginEntry.PropertyInfo("Right_1", "FontAwesomeTransforms", null, "Move right by 1 unit"),
                            new PluginEntry.PropertyInfo("Right_2", "FontAwesomeTransforms", null, "Move right by 2 units"),
                            new PluginEntry.PropertyInfo("Right_3", "FontAwesomeTransforms", null, "Move right by 3 units"),
                            new PluginEntry.PropertyInfo("Right_4", "FontAwesomeTransforms", null, "Move right by 4 units"),
                            new PluginEntry.PropertyInfo("Right_5", "FontAwesomeTransforms", null, "Move right by 5 units"),
                            new PluginEntry.PropertyInfo("Right_6", "FontAwesomeTransforms", null, "Move right by 6 units"),
                            new PluginEntry.PropertyInfo("Right_7", "FontAwesomeTransforms", null, "Move right by 7 units"),
                            new PluginEntry.PropertyInfo("Right_8", "FontAwesomeTransforms", null, "Move right by 8 units"),
                            new PluginEntry.PropertyInfo("Rotate_45", "FontAwesomeTransforms", null, "Rotate 45 degrees"),
                            new PluginEntry.PropertyInfo("Rotate_90", "FontAwesomeTransforms", null, "Rotate 90 degrees"),
                            new PluginEntry.PropertyInfo("Rotate_120", "FontAwesomeTransforms", null, "Rotate 120 degrees"),
                            new PluginEntry.PropertyInfo("Rotate_180", "FontAwesomeTransforms", null, "Rotate 180 degrees"),
                            new PluginEntry.PropertyInfo("Rotate_270", "FontAwesomeTransforms", null, "Rotate 270 degrees"),
                            new PluginEntry.PropertyInfo("Flip_V", "FontAwesomeTransforms", null, "Flip vertically"),
                            new PluginEntry.PropertyInfo("Flip_H", "FontAwesomeTransforms", null, "Flip horizontally")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Transforms",
                                    "Apply multiple transforms to an icon.",
                                    "new FontAwesome<>(FontAwesomeStyles.Classic, FontAwesomeIcons.magic)\n    .transform(FontAwesomeTransforms.Grow_3, FontAwesomeTransforms.Rotate_45, FontAwesomeTransforms.Right_2);",
                                    "java")
                    ),
                    null, null, null, null, null)
    );

    public FontAwesomePluginPage()
    {
        super(PluginCatalog.getById("fontawesome").orElseThrow());
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
                new PluginEntry.ExampleSnippet("Basic Icons",
                        "Create solid and brand icons with animation.",
                        "// Solid icon\nFontAwesome icon = new FontAwesome(\n    FontAwesomeStyles.Solid,\n    FontAwesomeIcons.cog);\n\n// Brand icon\nFontAwesome github = IFontAwesome.createIcon(\n    FontAwesomeBrandIcons.github,\n    FontAwesomeStyles.Brand);\n\n// With animation\nicon.spin().setSize(FontAwesomeSizes.Fa3x);",
                        "java"),
                new PluginEntry.ExampleSnippet("Layered Icons",
                        "Combine multiple icons with layers and counters.",
                        "var layers = new FontAwesomeLayers<>();\nlayers.add(new FontAwesome(FontAwesomeStyles.Solid, FontAwesomeIcons.envelope));\nlayers.add(new FontAwesomeLayerCounter(\"99+\"));",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "FontAwesomePageConfigurator auto-registers fontawesome-svg-core and Angular FontAwesome module")
        );
    }
}
