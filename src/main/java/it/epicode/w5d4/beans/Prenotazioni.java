package it.epicode.w5d4.beans;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Entity
@Component
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_prenotazioni")
    @SequenceGenerator(name = "id_prenotazioni", initialValue = 1, allocationSize = 1)
    private int id;
    private Edifici edificio;
    private Utenti utente;
    private LocalDate data;
}