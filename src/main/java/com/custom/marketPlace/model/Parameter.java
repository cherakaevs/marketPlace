package com.custom.marketPlace.model;

import com.custom.marketPlace.database.constants.ColumnNames;
import com.custom.marketPlace.database.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = TableNames.PARAMETER)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Parameter extends BaseEntity {

    @OneToOne
    @JoinColumn(name = ColumnNames.ATTRIBUTE_ID, nullable = false)
    private Attribute attribute;

    @ManyToOne
    @JoinColumn(name = ColumnNames.PRODUCT_ID, nullable = false)
    private Product product;

    @Column(name = ColumnNames.PARAMETER_VALUE, nullable = false)
    private String value;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Parameter parameter = (Parameter) o;
        return id != null && Objects.equals(id, parameter.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
