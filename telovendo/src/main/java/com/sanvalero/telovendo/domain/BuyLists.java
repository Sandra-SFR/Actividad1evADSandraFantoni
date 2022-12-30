package com.sanvalero.telovendo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data //lombok para tener todos los getters y setters sin verlos
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor  //constructor vacio

@Entity(name = "buy_lists")//javax.persistence para que entienda que a la bbdd le corresponde una tabla con estos datos
public class BuyLists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private long id;
    @Column//columna de la tabla
    private String code;
    @Column
    private float total;
    @Column(name = "number_products")//se cambia el nombre adecuandolo para bbdd
    private int numberProducts;
    @Column(name = "public_list")
    private boolean publicList;
    @Column(name = "create_date")
    private Date createDate;
}
