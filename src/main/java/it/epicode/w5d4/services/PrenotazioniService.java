package it.epicode.w5d4.services;

import it.epicode.w5d4.beans.Postazioni;
import it.epicode.w5d4.beans.Prenotazioni;
import it.epicode.w5d4.beans.Utenti;
import it.epicode.w5d4.repository.PrenotazioniDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioniService
{
    @Autowired
    private PrenotazioniDao prenotazioniDao;

    public void savePrenotazioni(Prenotazioni prenotazione) throws Exception{
        checkReservation(prenotazione);
        prenotazioniDao.save(prenotazione);
    }

    public void updatePrenotazioni(Prenotazioni prenotazione){
        Prenotazioni p = prenotazioniDao.findById(prenotazione.getId()).get();
        p.setPostazione(prenotazione.getPostazione());
        p.setData(prenotazione.getData());
        p.setUtente(prenotazione.getUtente());
        prenotazioniDao.save(p);
    }

    public Prenotazioni searchById(int id){ return prenotazioniDao.findById(id).get();}
    public void  deletePrenotazione (int id){ prenotazioniDao.deleteById(id);}

    public boolean checkLocation(int id, LocalDate data) {
        return prenotazioniDao.findByDateAndPostId(data,id)==null;
    }
    public boolean checkUtente(Utenti utente, LocalDate data) {
        return prenotazioniDao.findByDateAndUtente(data,utente)==null;
    }
    public void checkReservation(Prenotazioni p) throws Exception {
        if(p.getUtente()==null){
            throw new Exception("Utente Mancante");
        }
        if(p.getData()==null){
            throw new Exception("Data Mancante");
        }
        if(p.getPostazione()==null){
            throw new Exception("Postazione Mancante");
        }
        if(!checkLocation(p.getPostazione().getId(),p.getData())){
            throw new Exception("Postazione Occupata");
        }
        if(!checkUtente(p.getUtente(),p.getData())){
            throw new Exception("Utente Già Occupato");
        }
    }
}
