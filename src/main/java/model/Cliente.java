package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "compras_id")
    private Compras compras;


}
