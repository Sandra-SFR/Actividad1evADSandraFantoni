package com.sanvalero.telovendo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data //lombok (para tener todos los getters y setters sin verlos)
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor  //constructor vacio

@Entity(name = "users")//javax.persistence para que entienda que a la bbdd le corresponde una tabla con estos datos
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private long id;
    @Column//columna de la tabla
    private String name;
    @Column
    private String surname;
    @Column
    private boolean age18;
    @Column
    private String nickName;
    @Column
    private String password;
    @Column
    private Date bornDate;

}
