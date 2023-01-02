package com.sanvalero.telovendo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data //lombok (para tener todos los getters y setters sin verlos)
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor  //constructor vacio

@Entity(name = "user")//javax.persistence para que entienda que a la bbdd le corresponde una tabla con estos datos
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private long id;
    @Column//columna de la tabla
    private String name;
    @Column
    private String surname;
    @Column
    private boolean age18;
    @Column(name = "nick_name")//se cambia el nombre adecuandolo para bbdd
    private String nickName;
    @Column
    private String password;
    @Column(name = "born_date")
    private Date bornDate;

    //Todo datos relacionados:
}
