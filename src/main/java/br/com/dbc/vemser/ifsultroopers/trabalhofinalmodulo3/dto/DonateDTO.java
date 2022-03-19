package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DonateDTO extends DonateCreateDTO{
    @NotNull @Min(1)
    private Integer id_donate;
    @NotNull @Min(1)
    private Integer idRequest;
}
