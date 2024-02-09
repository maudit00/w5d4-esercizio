package it.epicode.w5d4.beans;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Data
public class Postazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_postazioni")
    @SequenceGenerator(name = "id_postazioni", allocationSize = 1, initialValue = 1)
    private int id;

    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int nMassimoOccupanti;
    @ManyToOne
    @JoinColumn (name = "id_edificio")
    private Edifici edificio;
    @OneToMany
    private List<Prenotazioni> prenotazioni;

}
