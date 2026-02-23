package com.finance.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.ORDINAL) // или STRING, в зависимости от вашей логики
    @Column(name = "type", nullable = false,columnDefinition = "smallint")
    private CategoryType type;

    public enum CategoryType {
        EXPENSE, // Расход
        INCOME // Доход
    }

}
