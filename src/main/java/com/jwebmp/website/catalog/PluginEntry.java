package com.jwebmp.website.catalog;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
public final class PluginEntry
{
    // ── Identity ──────────────────────────────────────
    private final String id;
    private final String name;
    private final String category;
    private final String description;

    // ── Maven coordinates ─────────────────────────────
    private final String groupId;
    private final String artifactId;
    private final String version;

    // ── Upstream library ──────────────────────────────
    private final String upstreamName;
    private final String upstreamVersion;
    private final String upstreamUrl;

    // ── JPMS ──────────────────────────────────────────
    private final String jpmsModule;

    // ── README & docs ─────────────────────────────────
    private final String readmePath;
    private final String docsUrl;
    private final String sourceUrl;

    // ── Features ──────────────────────────────────────
    private final List<String> features;

    // ── Tech badges ───────────────────────────────────
    private final List<String> techBadges;

    // ── Prerequisites ─────────────────────────────────
    private final List<String> prerequisites;

    // ── NPM dependencies (name → version) ─────────────
    private final Map<String, String> npmDependencies;

    // ── Quick start snippet ───────────────────────────
    private final String quickStartCode;
    private final String quickStartLanguage;

    // ── Installation snippet ──────────────────────────
    private final String mavenSnippet;
    private final String gradleSnippet;

    // ── License info ──────────────────────────────────
    private final boolean requiresLicense;
    private final String licenseNote;

    // ── SPI extensions provided ───────────────────────
    private final List<String> spiProvides;

    // ── SPI extensions consumed ───────────────────────
    private final List<String> spiUses;

    // ══════════════════════════════════════════════════
    //  Inner record types — used by detail pages
    // ══════════════════════════════════════════════════

    /**
     * A Java component class exposed by a plugin.
     */
    public record ComponentInfo(String className, String description, String packageName) {}

    /**
     * A code example demonstrating plugin usage.
     */
    public record ExampleSnippet(String title, String description, String code, String language) {}

    /**
     * Detailed explanation of an SPI extension point.
     */
    public record SpiDetail(String interfaceName, String direction, String description) {}

    /**
     * A configuration property or option.
     */
    public record ConfigEntry(String name, String type, String defaultValue, String description) {}

    private PluginEntry(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.description = builder.description;
        this.groupId = builder.groupId;
        this.artifactId = builder.artifactId;
        this.version = builder.version;
        this.upstreamName = builder.upstreamName;
        this.upstreamVersion = builder.upstreamVersion;
        this.upstreamUrl = builder.upstreamUrl;
        this.jpmsModule = builder.jpmsModule;
        this.readmePath = builder.readmePath;
        this.docsUrl = builder.docsUrl;
        this.sourceUrl = builder.sourceUrl;
        this.features = builder.features == null ? List.of() : Collections.unmodifiableList(builder.features);
        this.techBadges = builder.techBadges == null ? List.of() : Collections.unmodifiableList(builder.techBadges);
        this.prerequisites = builder.prerequisites == null ? List.of() : Collections.unmodifiableList(builder.prerequisites);
        this.npmDependencies = builder.npmDependencies == null ? Map.of() : Collections.unmodifiableMap(builder.npmDependencies);
        this.quickStartCode = builder.quickStartCode;
        this.quickStartLanguage = builder.quickStartLanguage;
        this.mavenSnippet = builder.mavenSnippet;
        this.gradleSnippet = builder.gradleSnippet;
        this.requiresLicense = builder.requiresLicense;
        this.licenseNote = builder.licenseNote;
        this.spiProvides = builder.spiProvides == null ? List.of() : Collections.unmodifiableList(builder.spiProvides);
        this.spiUses = builder.spiUses == null ? List.of() : Collections.unmodifiableList(builder.spiUses);
    }

    public static Builder builder(String id, String name, String category, String groupId, String artifactId)
    {
        return new Builder(id, name, category, groupId, artifactId);
    }

    public static final class Builder
    {
        private final String id;
        private final String name;
        private final String category;
        private final String groupId;
        private final String artifactId;

        private String description;
        private String version = "2.0.0-SNAPSHOT";
        private String upstreamName;
        private String upstreamVersion;
        private String upstreamUrl;
        private String jpmsModule;
        private String readmePath;
        private String docsUrl;
        private String sourceUrl;
        private List<String> features;
        private List<String> techBadges;
        private List<String> prerequisites;
        private Map<String, String> npmDependencies;
        private String quickStartCode;
        private String quickStartLanguage = "java";
        private String mavenSnippet;
        private String gradleSnippet;
        private boolean requiresLicense;
        private String licenseNote;
        private List<String> spiProvides;
        private List<String> spiUses;

        private Builder(String id, String name, String category, String groupId, String artifactId)
        {
            this.id = id;
            this.name = name;
            this.category = category;
            this.groupId = groupId;
            this.artifactId = artifactId;
        }

        public Builder description(String val) { description = val; return this; }
        public Builder version(String val) { version = val; return this; }
        public Builder upstreamName(String val) { upstreamName = val; return this; }
        public Builder upstreamVersion(String val) { upstreamVersion = val; return this; }
        public Builder upstreamUrl(String val) { upstreamUrl = val; return this; }
        public Builder jpmsModule(String val) { jpmsModule = val; return this; }
        public Builder readmePath(String val) { readmePath = val; return this; }
        public Builder docsUrl(String val) { docsUrl = val; return this; }
        public Builder sourceUrl(String val) { sourceUrl = val; return this; }
        public Builder features(List<String> val) { features = val; return this; }
        public Builder techBadges(List<String> val) { techBadges = val; return this; }
        public Builder prerequisites(List<String> val) { prerequisites = val; return this; }
        public Builder npmDependencies(Map<String, String> val) { npmDependencies = val; return this; }
        public Builder quickStartCode(String val) { quickStartCode = val; return this; }
        public Builder quickStartLanguage(String val) { quickStartLanguage = val; return this; }
        public Builder mavenSnippet(String val) { mavenSnippet = val; return this; }
        public Builder gradleSnippet(String val) { gradleSnippet = val; return this; }
        public Builder requiresLicense(boolean val) { requiresLicense = val; return this; }
        public Builder licenseNote(String val) { licenseNote = val; return this; }
        public Builder spiProvides(List<String> val) { spiProvides = val; return this; }
        public Builder spiUses(List<String> val) { spiUses = val; return this; }

        public PluginEntry build()
        {
            return new PluginEntry(this);
        }
    }
}
