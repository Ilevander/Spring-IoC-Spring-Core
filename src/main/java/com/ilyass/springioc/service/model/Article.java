package com.ilyass.springioc.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long id;
    private String description;
    private Double price;
    private Double quantity;
}
/*
    •  @Data est une annotation de Lombok. Elle permet d’ajouter au niveau du fichier .class 
        ◦ Les getters, les setters, la méthode equals, la méthode hashCode et la méthode toString.
    • @NoArgsConstructor est une annotation de Lombok. Elle permet d’ajouter au niveau du fichier .class le constructeur par défaut.

    • @AllArgsConstructor est une annotation de Lombok. Elle permet d’ajouter au niveau du fichier .class le constructeur avec l’ensemble des paramètres.
 */
