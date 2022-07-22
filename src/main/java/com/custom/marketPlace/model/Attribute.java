package com.custom.marketPlace.model;

import com.custom.marketPlace.database.constants.ColumnNames;
import com.custom.marketPlace.database.constants.TableNames;
import com.custom.marketPlace.enums.PossibleValues;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = TableNames.ATTRIBUTE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Attribute extends BaseEntity {

    @Column(name = ColumnNames.ATTRIBUTE_NAME, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = TableNames.CATEGORY_ATTRIBUTES,
            joinColumns = {
                    @JoinColumn(name = ColumnNames.ATTRIBUTE_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = ColumnNames.CATEGORY_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)})
    @ToString.Exclude
    private List<Category> category;

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
