package it.epicode.w5d4.beans;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Entity
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_prenotazioni")
    @SequenceGenerator(name = "id_prenotazioni", initialValue = 1, allocationSize = 1)
    private int id;
    @ManyToOne
    @JoinColumn( name = "id_postazione")
    private Postazioni postazione;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn( name = "id_utente")
    private Utenti utente;
    private LocalDate data;
}
