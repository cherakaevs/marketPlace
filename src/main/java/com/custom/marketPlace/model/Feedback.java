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
@Table(name = TableNames.FEEDBACK)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback extends BaseEntity {

    @Column(name = ColumnNames.MESSAGE, length = 1024)
    private String message;

    @Column(name = ColumnNames.RATE)
    private Double rate;

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
