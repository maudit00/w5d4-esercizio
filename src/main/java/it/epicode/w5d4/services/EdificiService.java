package it.epicode.w5d4.services;

import it.epicode.w5d4.beans.Edifici;
import it.epicode.w5d4.repository.EdificiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificiService {
    @Autowired
    private EdificiDao edificiDao;

    public void saveEdificio(Edifici edificio) {
        edificiDao.save(edificio);
    }

    public void updateEdificio(Edifici edificio){
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
