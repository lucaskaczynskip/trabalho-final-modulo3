package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto;

import lombok.Data;

@Data
public class RequestDTO extends RequestCreateDTO {

    private Integer idRequest;
    private Double reachedValue = 0.0;
}