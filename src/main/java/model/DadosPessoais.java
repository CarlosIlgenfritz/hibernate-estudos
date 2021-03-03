package model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DadosPessoais {

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "sexo")
    private char sexo;

}
