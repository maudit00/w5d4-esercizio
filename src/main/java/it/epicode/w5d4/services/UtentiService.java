package it.epicode.w5d4.services;

import it.epicode.w5d4.beans.Utenti;
import it.epicode.w5d4.repository.UtentiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtentiService {
    @Autowired
    private UtentiDao utenteDAO;

    public void saveUtente(Utenti utente) {
        utenteDAO.save(utente);
    }

    public void updateUtente(Utenti utente){
        Utenti u = utenteDAO.findById(utente.getId()).get();
        u.setUsername(utente.getUsername());
        u.setEmail(utente.getEmail());
        u.setNome(utente.getNome());
        u.setCognome(utente.getCognome());
        utenteDAO.save(u);
    }

    public Utenti searchById(int id){ return utenteDAO.findById(id).get();}
    public void  deleteUtente (int id){ utenteDAO.deleteById(id);}
}
