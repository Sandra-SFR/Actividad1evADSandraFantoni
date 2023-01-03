package com.sanvalero.telovendo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data //lombok para tener todos los getters y setters sin verlos
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor  //constructor vacio

@Entity(name = "buy_list")//javax.persistence para que entienda que a la bbdd le corresponde una tabla con estos datos
public class BuyList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private long id;
    @Column//columna de la tabla
    private String name;
    @Column
    private float total;
    @Column(name = "number_products")//se cambia el nombre adecuandolo para bbdd
    private int numberProducts;
    @Column(name = "public_list")
    private boolean publicList;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;

    //Todo datos relacionados:
    @OneToMany(mappedBy = "buyList")// se tiene que llamar como la variable de la otra clase
    private List<Product> products;

}
