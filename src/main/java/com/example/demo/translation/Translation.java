package com.example.demo.translation;

import javax.persistence.*;

@Entity
@Table
public class Translation {
    @Id
    @SequenceGenerator(name = "translation_sequence", sequenceName = "translation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "translation_sequence")
    private Long id;

    private String language;

    private String key;

    private String platform;
    private String value;

    private String description;

    public Translation() {
    }

    public Translation(Long id, String language, String key, String platform, String value, String description) {
        this.id = id;
        this.language = language;
        this.key = key;
        this.platform = platform;
        this.value = value;
        this.description = description;
    }

    public Translation(String language, String key, String platform, String value, String description) {
        this.language = language;
        this.key = key;
        this.platform = platform;
        this.value = value;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", language='" + getLanguage() + "'" +
                ", key='" + getKey() + "'" +
                ", platform='" + getPlatform() + "'" +
                ", value='" + getValue() + "'" +

                ", description='" + getDescription() + "'" +
                "}";
    }
}
