package com.custom.marketPlace.security.model;

import com.custom.marketPlace.database.constants.ColumnNames;
import com.custom.marketPlace.database.constants.Queries;
import com.custom.marketPlace.database.constants.QueriesNames;
import com.custom.marketPlace.database.constants.TableNames;
import com.custom.marketPlace.model.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = TableNames.MANAGER_CLIENT)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQueries({
        @NamedQuery(
                name = QueriesNames.GET_MANAGER_CLIENT_BY_CLIENT_ID,
                query = Queries.GET_MANAGER_CLIENT_BY_CLIENT_ID)
})

public class ManagerClient extends BaseEntity {
    @Column(name = ColumnNames.SECRET)
    private String secret;

    @Column(name= ColumnNames.CLIENT_ID)
    private String clientId;
}
