package dev.louiiuol.etin.domain.model.dtos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginDto {
    @NotBlank
    @Size(min=3, max = 60)
    private String userName;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    protected UserLoginDto() {}
    
}