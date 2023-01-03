package com.sanvalero.telovendo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data //lombok (para tener todos los getters y setters sin verlos)
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor  //constructor vacio

@Entity(name = "product")//javax.persistence para que entienda que a la bbdd le corresponde una tabla con estos datos
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private long id;
    @Column//columna de la tabla
    private String name;
    @Column(name = "release_date")//se cambia el nombre adecuandolo para bbdd
    private LocalTime releaseDate;
    @Column
    private float price;
    @Column(name = "on_sale")
    private boolean onSale;
    @Column
    private String currency;

    //Todo datos relacionados:
    @ManyToOne
    @JoinColumn(name = "list_id")
    @JsonBackReference(value = "list_buyList")
    private BuyList buyList;

}
