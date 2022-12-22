package com.example.demo.translation;

import javax.persistence.*;

@Entity
@Table
public class Translation {
    @Id
    @SequenceGenerator(name = "translation_sequence", sequenceName = "translation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "translation_sequence")
    private Long id;
    private String key;
    private String language;
    private String translation;

    public Translation() {
    }

    public Translation(Long id, String key, String language, String translation) {
        this.id = id;
        this.key = key;
        this.language = language;
        this.translation = translation;
    }

    public Translation(String key, String language, String translation) {
        this.key = key;
        this.language = language;
        this.translation = translation;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTranslation() {
        return this.translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", key='" + getKey() + "'" +
                ", language='" + getLanguage() + "'" +
                ", translation='" + getTranslation() + "'" +
                "}";
    }

}
