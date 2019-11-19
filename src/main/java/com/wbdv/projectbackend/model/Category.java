package com.wbdv.projectbackend.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;

    @ManyToMany
    private List<Item> items;

    private String name;
}
