package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.ColumnNames;
import com.custom.marketPlace.constants.TableNames;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.MANAGER_CLIENT)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerClient extends BaseEntity{
    @Column(name = ColumnNames.SECRET )
    private String secret;

    @Column(name= ColumnNames.CLIENT_ID)
    private String clientId;
}
