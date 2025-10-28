package application.afericoes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "afericoes")
@Getter
@Setter
@NoArgsConstructor
public class Afericao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String idSensor;
    
    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false)
    private String valor;

    public Afericao(AfericaoInsertDTO afericao) {
        this.setIdSensor(afericao.idSensor());
        this.setUnidade(afericao.unidade());
        this.setValor(afericao.valor());
    }
}
