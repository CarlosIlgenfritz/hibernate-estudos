package model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "compras")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "produto")
    private String produto;
}
