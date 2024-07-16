package org.example.demo.domian.user.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SigninRequest {
    @NotBlank
    @Size(min = 6, max = 12)
    private String id;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
}
