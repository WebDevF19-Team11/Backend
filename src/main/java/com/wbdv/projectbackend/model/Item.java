package com.wbdv.projectbackend.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    @ManyToMany
    private List<Category> categoryList;

    private String title;

    private String description;
}
