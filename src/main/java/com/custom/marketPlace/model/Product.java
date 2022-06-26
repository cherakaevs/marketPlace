package com.custom.marketPlace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
}
