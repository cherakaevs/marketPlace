package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.AnnotationType;
import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = TableNames.PROFILE)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @Column(name = ColumnNames.ID, nullable = false)
    @Type(type = AnnotationType.UUID_CHAR_TYPE)
    private UUID id;

    @Column(name = ColumnNames.FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = ColumnNames.LAST_NAME)
    private String lastName;

    @OneToMany
    @ToString.Exclude
    private List<Order> ordersHistory;

    @OneToMany
    @ToString.Exclude
    private List<Address> addresses;

    @OneToMany
    @ToString.Exclude
    private List<Product> favouriteProducts;

    @OneToMany
    @ToString.Exclude
    private List<Coupon> coupons;

    @OneToMany
    @ToString.Exclude
    private List<Feedback> feedbacks;

    @ToString.Exclude
    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = ColumnNames.USER_ID, nullable = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Profile profile = (Profile) o;
        return id != null && Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
