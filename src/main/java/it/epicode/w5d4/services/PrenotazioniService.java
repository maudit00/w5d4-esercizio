package it.epicode.w5d4.services;

import it.epicode.w5d4.beans.Postazioni;
import it.epicode.w5d4.beans.Prenotazioni;
import it.epicode.w5d4.repository.PrenotazioniDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioniService {
    @Autowired
    private PrenotazioniDao prenotazioniDao;

    public void savePrenotazioni(Prenotazioni prenotazione) {
        Postazioni postazione = prenotazione.getPostazione();
        List<Prenotazioni> prenotazioniDaoByDateAndPostId = prenotazioniDao.findByDateAndPostId(prenotazione.getData(),prenotazione.getPostazione().getId());
        if (prenotazioniDaoByDateAndPostId.isEmpty()){
            prenotazioniDao.save(prenotazione);
        } else{
            System.out.println("Posto occupato ");
        }
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
}
