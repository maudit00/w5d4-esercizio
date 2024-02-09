package it.epicode.w5d4.repository;

import it.epicode.w5d4.beans.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioniDao extends JpaRepository<Prenotazioni, Integer> {
}
