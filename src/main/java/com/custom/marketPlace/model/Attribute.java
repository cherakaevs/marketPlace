package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import com.custom.marketPlace.enums.PossibleValues;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.ATTRIBUTE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Attribute {
    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    private UUID id;

    @Column(name = ColumnNames.ATTRIBUTE_NAME, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = ColumnNames.CATEGORY_ID, nullable = false)
    private Category category;

    @Column(name = ColumnNames.POSSIBLE_VALUES, nullable = false)
    private PossibleValues values;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attribute attribute = (Attribute) o;
        return id != null && Objects.equals(id, attribute.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
