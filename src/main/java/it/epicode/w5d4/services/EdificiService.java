package it.epicode.w5d4.services;

import it.epicode.w5d4.beans.Edifici;
import it.epicode.w5d4.beans.Postazioni;
import it.epicode.w5d4.repository.EdificiDao;
import it.epicode.w5d4.repository.PostazioniDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificiService {
    @Autowired
    private EdificiDao edificiDao;

    public void saveUtente(Edifici edificio) {
        edificiDao.save(edificio);
    }

    public void updateUtente(Edifici edificio){
        Edifici e = edificiDao.findById(edificio.getId()).get();
        e.setCittà(edificio.getCittà());
        e.setNome(edificio.getNome());
        e.setIndirizzo(edificio.getIndirizzo());
        e.setPostazioni(edificio.getPostazioni());
        edificiDao.save(e);
    }

    public Edifici searchById(int id){ return edificiDao.findById(id).get();}
    public void  deleteEdificio (int id){ edificiDao.deleteById(id);}
}
