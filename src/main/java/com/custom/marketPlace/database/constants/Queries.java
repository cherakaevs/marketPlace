package com.custom.marketPlace.database.constants;

public interface Queries {

    /* ManagerClient */
    String GET_MANAGER_CLIENT_BY_CLIENT_ID = "select mc from ManagerClient mc where mc.clientId = :client_id";
}
