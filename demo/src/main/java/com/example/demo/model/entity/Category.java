package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "category_id")
    private String cateId;

    private String cateName;
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
