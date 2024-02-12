package it.epicode.w5d4.repository;

import it.epicode.w5d4.beans.Prenotazioni;
import it.epicode.w5d4.beans.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioniDao extends JpaRepository<Prenotazioni, Integer> {
    @Query("SELECT p FROM Prenotazioni p WHERE p.data = :data AND p.postazione.id = :id")
    Prenotazioni findByDateAndPostId(LocalDate data, int id);

    Prenotazioni findByDateAndUtente(LocalDate data, Utenti utente);
}
