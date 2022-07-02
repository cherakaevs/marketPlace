package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.AnnotationType;
import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.MappedByFields;
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
public class Profile extends BaseEntity {

    @Column(name = ColumnNames.FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = ColumnNames.LAST_NAME, nullable = false)
    private String lastName;

    @OneToMany
    @JoinColumn(name = ColumnNames.PROFILE_ID)
    @ToString.Exclude
    private List<Order> ordersHistory;

    @ManyToMany
    @JoinTable(name = TableNames.ADDRESSES_PROFILES,
            joinColumns = {
                    @JoinColumn(name = ColumnNames.PROFILE_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = ColumnNames.ADDRESS_ID, referencedColumnName = ColumnNames.ID,
                            nullable = false, updatable = false)})
    @ToString.Exclude
    private List<Address> addresses;

    @OneToMany
    @JoinColumn(name = ColumnNames.PROFILE_ID)
    @ToString.Exclude
    private List<Product> favouriteProducts;

    @OneToMany
    @JoinColumn(name = ColumnNames.PROFILE_ID)
    @ToString.Exclude
    private List<Coupon> coupons;

    @OneToMany
    @JoinColumn(name = ColumnNames.PROFILE_ID)
    @ToString.Exclude
    private List<Feedback> feedbacks;

    @ToString.Exclude
    @OneToOne(optional = false)
    @JoinColumn (name=ColumnNames.USER_ID)
    private User user;

    @ToString.Exclude
    @OneToOne(mappedBy = MappedByFields.PROFILE)
    private Bucket bucket;

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
