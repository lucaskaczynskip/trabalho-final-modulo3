package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.entity;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Request {

    private Integer idRequest;
    private String title;
    private String description;
    private Double goal;
    private Double reachedValue;
    private Integer idCategory;
    private Integer idUser;

    public Request(Integer idRequest, String title, String description, Double goal, Integer idCategory, Integer idUser) {
        this.idRequest = idRequest;
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.reachedValue = 0.0;
        this.idCategory = idCategory;
        this.idUser = idUser;
    }
}
