package com.custom.marketPlace.model;

import com.custom.marketPlace.constants.TableNames;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager_client" /* TODO: В константы */)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerClient extends BaseEntity{
    @Column(name ="secret" /* TODO: В константы (+ наверное будет client_secret)*/)
    private String secret;

    @Column(name="clientId" /* TODO: В константы (колонки называются как переменные в C++, т.е. через нижний прочерк. client_id*/)
    private String clientId;
}
