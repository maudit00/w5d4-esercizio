package it.epicode.w5d4.beans;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
public class Edifici {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String indirizzo;
    private String città;
    @OneToOne (mappedBy = "edificio")
    private Postazioni postazione;
}
