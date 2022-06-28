package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.AnnotationType;
import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.USER)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    @Type(type = AnnotationType.UUID_CHAR_TYPE)
    private UUID id;

    @Column(name = ColumnNames.USERNAME, nullable = false, unique = true, length = 64)
    private String username;

    @Column(name = ColumnNames.PASSWORD, nullable = false, length = 128)
    private String password;

    @Transient
    private String passwordConfirm;

    @OneToOne
    @MapsId
    private Profile profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
