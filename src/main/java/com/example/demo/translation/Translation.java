package com.example.demo.translation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.example.demo.translation.enumeration.LanguageEnum;

/**
 * @author Edin Mahmutovic
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "language", "keyes" }))
@Getter
@Setter
@NoArgsConstructor
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @Column(nullable = false)
    private String keyes;

    @Column(nullable = false)
    private String platform;

    @Column(nullable = false, length = 1024)
    private String value;

    private String description;
}
