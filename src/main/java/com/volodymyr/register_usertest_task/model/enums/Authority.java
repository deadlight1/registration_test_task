package com.volodymyr.register_usertest_task.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
