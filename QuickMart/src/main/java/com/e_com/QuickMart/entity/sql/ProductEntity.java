package com.e_com.QuickMart.entity.sql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//<<<<<<< Updated upstream
import lombok.Getter;
//=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//>>>>>>> Stashed changes
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
//<<<<<<< Updated upstream
//=======
@NoArgsConstructor
@AllArgsConstructor
//>>>>>>> Stashed changes
@Entity
@Table(
        name = "products",
        indexes = {
                @Index(name = "idx_category_active", columnList = "category_id, is_active"),
                @Index(name = "idx_created_at", columnList = "created_at")
        }
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* 🔗 Many products belong to one category */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private CategoryEntity category;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit", nullable = false, length = 20)
    private String unit;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isActive = true;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
