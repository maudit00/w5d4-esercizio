package it.epicode.w5d4.repository;

import it.epicode.w5d4.beans.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UtentiDao extends JpaRepository<Utenti, Integer> {

}
