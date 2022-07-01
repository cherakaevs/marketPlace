package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.AnnotationType;
import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import com.custom.marketPlace.enums.Status;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.ORDER)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Order extends BaseEntity {

    @Column(name = ColumnNames.STATUS, nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(name = TableNames.PRODUCTS_ORDERS,
            joinColumns = {
                    @JoinColumn(name = ColumnNames.ORDER_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = ColumnNames.PRODUCT_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)})
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = ColumnNames.PROFILE_ID)
    private Profile customer;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = ColumnNames.ADDRESS_ID)
    private Address address;

    @Column(name = ColumnNames.SUM, nullable = false)
    private Double sumPrice;

    @Column(name = ColumnNames.SHIPMENT_DATE, nullable = false)
    private LocalDate shipmentDate;

    @Column(name = ColumnNames.DELIVERY_DATE, nullable = false)
    private LocalDate deliveryDate;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}