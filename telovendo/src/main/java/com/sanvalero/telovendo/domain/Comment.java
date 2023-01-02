package com.sanvalero.telovendo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data //lombok (para tener todos los getters y setters sin verlos)
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor  //constructor vacio

@Entity(name = "comment")//javax.persistence para que entienda que a la bbdd le corresponde una tabla con estos datos
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private long id;
    @Column(name = "comment_text")//columna de la tabla
    private String commentText;
    @Column(name = "buyer_name")//se cambia el nombre adecuandolo para bbdd
    private String buyerName;
    @Column(name = "seller_name")
    private String sellerName;
    @Column(name = "date_comment")
    private Date dateComment;
    @Column(name = "star_rate")
    private int starRate;

    //Todo datos relacionados:

}
