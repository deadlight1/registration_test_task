package com.volodymyr.register_usertest_task.model.dto;

import com.volodymyr.register_usertest_task.model.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserDetails {

    private Long id;
    @NotBlank(message = "Username cannot be empty ")
    @Email(message = "Username is incorrect")
    private String username;
    @NotBlank(message = "Password cannot be empty. ")
    @Pattern(regexp = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{8,})", message =
            "Minimum length is 8. " +
                    "Contain at least one digit. " +
                    "Contain at least one lower case character. " +
                    "Contain at least one upper case character. "
    )
    private String password;
    private Set<Authority> authorities = new HashSet<>();
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
}