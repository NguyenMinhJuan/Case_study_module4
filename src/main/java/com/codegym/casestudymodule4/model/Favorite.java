package com.codegym.casestudymodule4.model;

import jakarta.persistence.*;


@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Người dùng đã yêu thích

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Món ăn được yêu thích


}
