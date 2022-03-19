package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.userdto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

@Data
public class UsersCreateDTO {
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 250)
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 8)
    private String password;

    @NotNull
    @NotEmpty
    private Boolean type;

    @NotNull
    @NotEmpty
    private String document;
}
