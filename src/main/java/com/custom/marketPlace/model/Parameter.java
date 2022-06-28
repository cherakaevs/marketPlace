package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.PARAMETER)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Parameter {
    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = ColumnNames.ATTRIBUTE_ID, nullable = false)
    private Attribute attribute;

    @ManyToOne
    @JoinColumn(name = ColumnNames.PRODUCT_ID, nullable = false)
    private Product product;

    @Column(name = ColumnNames.PARAMETER_NAME)
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
