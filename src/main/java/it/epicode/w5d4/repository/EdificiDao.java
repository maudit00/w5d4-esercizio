package it.epicode.w5d4.repository;

import it.epicode.w5d4.beans.Edifici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificiDao extends JpaRepository<Edifici, Integer> {
}
