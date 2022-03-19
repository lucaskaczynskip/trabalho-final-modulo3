package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RequestCreateDTO {

    @NotEmpty
    private String title;
    private String description;

    @NotEmpty
    private Double goal;

    @NotEmpty
    private Integer idCategory;

    @NotEmpty
    private Integer idUser;
}
