package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.AnnotationType;
import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.COUPON)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    @Type(type = AnnotationType.UUID_CHAR_TYPE)
    private UUID id;

    @Column(name = ColumnNames.DISCOUNT_MULTIPLIER)
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private Double discountMultiplier;

    @Column(name = ColumnNames.DISCOUNT)
    private Double discount;

    @ManyToMany
    @JoinTable(name = TableNames.CATEGORIES_COUPONS,
            joinColumns = {
                    @JoinColumn(name = ColumnNames.COUPON_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = ColumnNames.CATEGORY_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)})
    @ToString.Exclude
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = TableNames.PRODUCTS_COUPONS,
            joinColumns = {
                    @JoinColumn(name = ColumnNames.COUPON_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = ColumnNames.PRODUCT_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)})
    @ToString.Exclude
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Coupon coupon = (Coupon) o;
        return id != null && Objects.equals(id, coupon.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
