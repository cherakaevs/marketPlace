package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.AnnotationType;
import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.ADDRESS)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    @Type(type = AnnotationType.UUID_CHAR_TYPE)
    private UUID id;

    @Column(name = ColumnNames.COUNTRY)
    private String country;

    @Column(name = ColumnNames.CITY)
    private String city;

    @Column(name = ColumnNames.STREET)
    private String street;

    @Column(name = ColumnNames.HOUSE_NUMBER)
    private String houseNumber;

    @Column(name = ColumnNames.FLAT_NUMBER)
    private Long flatNumber;

    @Column(name = ColumnNames.MAIL_INDEX)
    private Long mailIndex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return id != null && Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
