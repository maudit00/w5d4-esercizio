package it.epicode.w5d4;

import it.epicode.w5d4.beans.Edifici;
import it.epicode.w5d4.beans.Postazioni;
import it.epicode.w5d4.beans.Prenotazioni;
import it.epicode.w5d4.beans.Utenti;
import it.epicode.w5d4.services.EdificiService;
import it.epicode.w5d4.services.PostazioniService;
import it.epicode.w5d4.services.PrenotazioniService;
import it.epicode.w5d4.services.UtentiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    static EdificiService edificioService;
    @Autowired
    static PrenotazioniService prenotazioniService;
    @Autowired
    static PostazioniService postazioniService;
    @Autowired
    static UtentiService utentiService;

    final static Logger logger = LoggerFactory.getLogger("w5d4");

    @Override
    public void run (String... args) throws Exception{

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d4Application.class);
        Edifici e = ctx.getBean("palazzoFrancia", Edifici.class);
        edificioService.saveEdificio(e);
        logger.info("edificio aggiunto");
        Postazioni post = ctx.getBean("postazione1", Postazioni.class);
        postazioniService.savePostazione(post);
        logger.info("postazione aggiunta");

        Postazioni post1 = postazioniService.


        Utenti u = ctx.getBean("marioRossi", Utenti.class);
        utentiService.saveUtente(u);
        logger.info("utente aggiunto");
        Prenotazioni p = ctx.getBean("prenotazione1", Prenotazioni.class);
        insertReservation(post,p);


        Prenotazioni p = ctx.getBean("prenotazione1", Prenotazioni.class);
            prenotazioniService.savePrenotazioni(p);
            logger.info("prenotazione aggiunta");
    }

    public void insertReservation (Postazioni postazione, Prenotazioni prenotazione){
        List<LocalDate> list = postazione.getPrenotazioni().stream().map(prenotazioni -> prenotazione.getData()).toList();
        if (list.contains(prenotazione.getData())){
            logger.error("Postazione occupata in data :" + prenotazione.getData());
        } else {
           prenotazioniService.savePrenotazioni(prenotazione);
        }
    }

}
