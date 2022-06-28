package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import com.custom.marketPlace.enums.Status;
import lombok.*;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Hibernate;

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
public class Order {
    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    private UUID id;

    @Column(name = ColumnNames.STATUS, nullable = false)
    private Status status;

    @OneToMany
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = ColumnNames.PROFILE_ID)
    private Profile customer;

    @OneToOne
    @ToString.Exclude
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