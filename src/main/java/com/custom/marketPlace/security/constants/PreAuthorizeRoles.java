package com.custom.marketPlace.security.constants;

public interface PreAuthorizeRoles {
    String ADMIN = "hasRole('ROLE_ADMIN')";
    String ALL = "permitAll()";
}
