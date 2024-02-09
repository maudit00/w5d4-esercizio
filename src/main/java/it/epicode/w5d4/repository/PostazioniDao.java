package it.epicode.w5d4.repository;

import it.epicode.w5d4.beans.Postazioni;
import it.epicode.w5d4.beans.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioniDao extends JpaRepository<Postazioni, Integer> {
    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione= :tipoPostazione AND p.edificio.citta = :citta")
    List<Postazioni> searchByCittàAndTipo(TipoPostazione tipoPostazione, String citta);

}
