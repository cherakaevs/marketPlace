package com.custom.marketPlace.model;

import com.custom.marketPlace.database.constants.ColumnNames;
import com.custom.marketPlace.database.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = TableNames.BUCKET)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Bucket extends BaseEntity {

    @ManyToMany
    @JoinTable(name = TableNames.PRODUCTS_BUCKETS,
            joinColumns = {
                    @JoinColumn(name = ColumnNames.BUCKET_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = ColumnNames.PRODUCT_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)})
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    @Column(name = ColumnNames.SUM, nullable = false)
    private Double sumPrice;

    @OneToOne(optional = false)
    @JoinColumn(name = ColumnNames.PROFILE_ID)
    private Profile profile;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bucket bucket = (Bucket) o;
        return id != null && Objects.equals(id, bucket.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
