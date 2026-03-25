package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.markdown.Markdown;
import com.jwebmp.plugins.prism.PrismLanguage;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaGrid;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.webawesome.components.button.WaButton;
import com.jwebmp.webawesome.components.card.WaCard;
import com.jwebmp.webawesome.components.divider.WaDivider;
import com.jwebmp.webawesome.components.tag.WaTag;
import com.jwebmp.webawesome.components.text.WaText;
import org.apache.commons.text.StringEscapeUtils;

/**
 * Base class for all JWebMP website content pages.
 * <p>
 * Pages render inside the primary RouterOutlet of the single WaPage in WebsiteBoot.
 * The WaPage shell (header, menu, navigation, footer) is defined once in boot;
 * each page is a simple content div.
 * <p>
 * {@link #getMain()} returns {@code this} so child pages can call
 * {@code getMain().add(layout)} without change.
 */
public abstract class WebsitePage<J extends WebsitePage<J>> extends DivSimple<J> implements INgComponent<J>
{
    protected WebsitePage()
    {
        addStyle("padding:var(--wa-spacing-x-large)");
        addStyle("max-width:72rem");
    }

    /**
     * Returns this page as the content target.
     * Keeps the {@code getMain().add(...)} API that every child page uses.
     */
    @SuppressWarnings("unchecked")
    protected J getMain()
    {
        return (J) this;
    }

    protected WaGrid<?> grid(int columns)
    {
        var grid = new WaGrid<>();
        grid.setGap(PageSize.Medium);
        if (columns == 2)
        {
            grid.setMinColumnSize("20rem");
        }
        else if (columns >= 3)
        {
            grid.setMinColumnSize("14rem");
        }
        return grid;
    }

    // ── Text helpers ──────────────────────────────────

    protected String escapeAngular(String text)
    {
        if (text == null)
        {
            return null;
        }
        return StringEscapeUtils.escapeHtml4(text)
                                .replace("@", "&#64;")
                                .replace("{", "&#123;")
                                .replace("}", "&#125;")
                                .replace("[", "&#91;")
                                .replace("]", "&#93;")
                                .replace("(", "&#40;")
                                .replace(")", "&#41;")
                                .replace("*", "&#42;")
                                .replace("_", "&#95;");
    }

    protected WaText<?> headingText(String tag, String size, String text)
    {
        var heading = new WaText<>();
        heading.setTag(tag);
        heading.setWaHeading(size);
        heading.setText(escapeAngular(text));
        return heading;
    }

    protected WaText<?> bodyText(String text, String size)
    {
        var body = new WaText<>();
        body.setTag("p");
        body.setWaBody(size == null || size.isBlank() ? "m" : size);
        body.setText(escapeAngular(text));
        return body;
    }

    /**
     * Body text rendered via Markdown so that backtick code spans, bold, italic, and
     * links are preserved.  Use {@code `@NgComponent`} in the source string to render
     * inline code.
     */
    protected Markdown<?> richText(String markdownText, String size)
    {
        var md = new Markdown<>(markdownText);
        return md;
    }

    protected WaText<?> captionText(String text)
    {
        var caption = new WaText<>();
        caption.setTag("div");
        caption.setWaCaption("s");
        caption.setWaFontWeight("semibold");
        caption.setText(escapeAngular(text));
        return caption;
    }

    // ── Component helpers ─────────────────────────────

    protected WaTag<?> buildTag(String label, Variant variant)
    {
        WaTag<?> tag = new WaTag<>();
        tag.setText(escapeAngular(label));
        tag.setVariant(variant);
        tag.setPill(true);
        return tag;
    }

    protected WaButton<?> buildCta(String label, String route, Variant variant, Appearance appearance)
    {
        WaButton<?> button = new WaButton<>(escapeAngular(label), variant);
        if (appearance != null)
        {
            button.setAppearance(appearance);
        }
        button.addAttribute("[routerLink]", "['" + route + "']");
        return button;
    }

    protected WaCard<?> featureCard(String title, String body, String note)
    {
        var card = new WaCard<>();
        card.setAppearance(Appearance.Outlined);

        var stack = new WaStack();
        stack.setGap(PageSize.Small);
        stack.add(headingText("h3", "m", title));
        var bodyCopy = bodyText(body, "m");
        bodyCopy.setWaColorText("quiet");
        stack.add(bodyCopy);
        if (note != null && !note.isBlank())
        {
            var noteText = captionText(note);
            noteText.setWaColorText("quiet");
            stack.add(noteText);
        }
        card.add(stack);
        return card;
    }

    // ── Section helpers ───────────────────────────────

    protected WaStack section(String eyebrow, String title, String subtitle,
                              com.jwebmp.core.base.interfaces.IComponentHierarchyBase<?, ?> content)
    {
        var section = new WaStack();
        section.setGap(PageSize.Medium);

        section.add(new WaDivider<>());
        section.add(sectionHeader(eyebrow, title, subtitle));
        if (content != null)
        {
            section.add(content);
        }
        return section;
    }

    protected WaStack section(String eyebrow, String title, String subtitle)
    {
        return section(eyebrow, title, subtitle, null);
    }

    protected WaStack sectionHeader(String eyebrow, String title, String subtitle)
    {
        var header = new WaStack();
        header.setGap(PageSize.Small);
        if (eyebrow != null && !eyebrow.isBlank())
        {
            header.add(captionText(eyebrow));
        }
        if (title != null && !title.isBlank())
        {
            header.add(headingText("h2", "l", title));
        }
        if (subtitle != null && !subtitle.isBlank())
        {
            var subtitleText = bodyText(subtitle, "m");
            subtitleText.setWaColorText("quiet");
            header.add(subtitleText);
        }
        return header;
    }

    // ── Diagram helpers ──────────────────────────────

    protected DivSimple<?> mermaidDiagram(String mermaidCode)
    {
        var wrapper = new DivSimple<>();
        wrapper.addClass("mermaid-diagram");
        var md = new Markdown<>("```mermaid\n" + mermaidCode + "\n```");
        md.setMermaid(true);
        wrapper.add(md);
        return wrapper;
    }

    protected DivSimple<?> mermaidDiagramWithTitle(String title, String mermaidCode)
    {
        var wrapper = new DivSimple<>();
        wrapper.addClass("mermaid-diagram-wrapper");
        var label = captionText(title);
        label.addClass("mermaid-diagram-label");
        wrapper.add(label);
        wrapper.add(mermaidDiagram(mermaidCode));
        return wrapper;
    }

    // ── Code block helpers ────────────────────────────

    protected DivSimple<?> codeBlock(String code)
    {
        return codeBlock(code, PrismLanguage.Java);
    }

    protected DivSimple<?> codeBlock(String code, PrismLanguage language)
    {
        var wrapper = new DivSimple<>();
        wrapper.addClass("code-block");

        var md = new Markdown<>("```" + language.getLanguageCode() + "\n" + code + "\n```");
        md.setLineNumbers(true);
        md.setClipboard(true);
        wrapper.add(md);
        return wrapper;
    }

    protected DivSimple<?> codeBlockWithTitle(String title, String code)
    {
        return codeBlockWithTitle(title, code, PrismLanguage.Java);
    }

    protected DivSimple<?> codeBlockWithTitle(String title, String code, PrismLanguage language)
    {
        var wrapper = new DivSimple<>();
        wrapper.addClass("code-block-wrapper");

        var label = captionText(title);
        label.addClass("code-block-label");
        wrapper.add(label);

        var md = new Markdown<>("```" + language.getLanguageCode() + "\n" + code + "\n```");
        md.setLineNumbers(true);
        md.setClipboard(true);
        md.addClass("code-block");
        wrapper.add(md);
        return wrapper;
    }

    // ── Legacy compat — buildSection delegates to section ──

    protected WaStack buildSection(String eyebrow, String title, String subtitle,
                                   boolean alt,
                                   com.jwebmp.core.base.interfaces.IComponentHierarchyBase<?, ?> content)
    {
        return section(eyebrow, title, subtitle, content);
    }
}

