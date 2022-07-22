package com.custom.marketPlace.model;

import com.custom.marketPlace.database.constants.ColumnNames;
import com.custom.marketPlace.database.constants.MappedByFields;
import com.custom.marketPlace.database.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = TableNames.USER)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    public User(String name, String password, String passwordConfirm){
        this.username = name;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    @Column(name = ColumnNames.USERNAME, nullable = false, unique = true, length = 64)
    private String username;

    @Column(name = ColumnNames.PASSWORD, nullable = false, length = 128)
    private String password;

    @Transient
    private String passwordConfirm;

    @OneToOne(mappedBy = MappedByFields.USER, cascade = CascadeType.ALL)
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
