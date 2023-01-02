package com.sanvalero.telovendo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data //lombok (para tener todos los getters y setters sin verlos)
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor  //constructor vacio

@Entity(name = "discount")//javax.persistence para que entienda que a la bbdd le corresponde una tabla con estos datos
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private long id;
    @Column//columna de la tabla
    private String name;
    @Column
    private float value;
    @Column
    private String currency;
    @Column
    private LocalDate available;
    @Column
    private boolean cumulative;

    //Todo datos relacionados:
}
