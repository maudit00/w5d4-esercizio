package it.epicode.w5d4.services;

import it.epicode.w5d4.beans.Postazioni;
import it.epicode.w5d4.repository.PostazioniDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioniService {
    @Autowired
    private PostazioniDao postazioniDao;

    public void saveUtente(Postazioni postazione) {
        postazioniDao.save(postazione);
    }

    public void updateUtente(Postazioni postazione){
        Postazioni p = postazioniDao.findById(postazione.getId()).get();
        p.setTipoPostazione(postazione.getTipoPostazione());
        p.setEdificio(postazione.getEdificio());
        p.setPrenotazioni(postazione.getPrenotazioni());
        p.setNMassimoOccupanti(postazione.getNMassimoOccupanti());

        postazioniDao.save(p);
    }

    public Postazioni searchById(int id){ return postazioniDao.findById(id).get();}
    public void  deletePostazione (int id){ postazioniDao.deleteById(id);}
}