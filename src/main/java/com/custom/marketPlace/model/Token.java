package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.ColumnNames;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token{
    private String access_token;
    private int expires_in;
    private int refresh_expires_in;
    private String token_type;
    private int not_before_policy;
    private String scope;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Token token = (Token) o;
        return access_token != null && Objects.equals(access_token, token.access_token);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
