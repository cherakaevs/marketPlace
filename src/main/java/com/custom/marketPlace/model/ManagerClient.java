package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.TableNames;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager_client")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerClient extends BaseEntity{
    @Column(name ="secret")
    private String secret;

    @Column(name="clientId")
    private String clientId;
}
