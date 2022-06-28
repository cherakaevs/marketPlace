package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.PRODUCT)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    private UUID id;

    @Column(name = ColumnNames.PRODUCT_NAME, nullable = false)
    private String name;

    @Column(name = ColumnNames.PRICE, nullable = false)
    private Double price;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = ColumnNames.CATEGORY_ID, nullable = false)
    private Category category;

    @OneToMany
    @ToString.Exclude
    private List<Parameter> parameters = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Feedback> feedbacks = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Commentary> comments = new ArrayList<>();

    @Column(name = ColumnNames.AVERAGE_RATE)
    private Double averageRate;

    @Column(name = ColumnNames.AVAILABLE_COUNT)
    private Integer availableCount;

//    @ManyToOne
//    @JoinColumn(name = ColumnNames.BUCKET_ID, nullable = false)
//    @ToString.Exclude
//    private Bucket bucket;
//
//    @ManyToOne
//    @JoinColumn(name = ColumnNames.COUPON_ID, nullable = false)
//    @ToString.Exclude
//    private Coupon coupon;
//
//    @ManyToOne
//    @JoinColumn(name = ColumnNames.ORDER_ID, nullable = false)
//    @ToString.Exclude
//    private Order order;

    public double getAverageRate(){
        Double sum = 0.0;
        for (Feedback feedback:
            feedbacks) {
            sum += feedback.getRate();
        }
        return sum / feedbacks.size();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
