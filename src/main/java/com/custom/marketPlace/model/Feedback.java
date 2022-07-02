package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = TableNames.FEEDBACK)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback extends BaseEntity {
    private static final int MAX_MESSAGE_LENGTH = 1024;

    @Column(name = ColumnNames.MESSAGE, length = MAX_MESSAGE_LENGTH)
    private String message;

    @Column(name = ColumnNames.RATE, nullable = false)
    private Double rate;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = ColumnNames.PRODUCT_ID, nullable = false)
    private Product product;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = ColumnNames.PROFILE_ID, nullable = false)
    private Profile profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Feedback feedback = (Feedback) o;
        return id != null && Objects.equals(id, feedback.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
