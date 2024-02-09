package it.epicode.w5d4.repository;

import it.epicode.w5d4.beans.Postazioni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostazioniDao extends JpaRepository<Postazioni, Integer> {
}
