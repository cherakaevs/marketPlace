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
@Table(name = TableNames.FEEDBACK)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {

    @Id
    @Column(name = ColumnNames.FEEDBACK_ID, nullable = false)
    @Type(type = AnnotationType.UUID_CHAR_TYPE)
    private UUID id;

    @Column(name = ColumnNames.MESSAGE, length = 1024)
    private String message;

    @Column(name = ColumnNames.RATE)
    private Double rate;

    @OneToMany
    @ToString.Exclude
    private List<Commentary> commentaries;

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
