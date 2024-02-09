package it.epicode.w5d4.beans;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component
public class Utenti {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_utenti")
    @SequenceGenerator(name = "id_utenti", initialValue = 1, allocationSize = 1)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazioni> prenotazioni;
}
