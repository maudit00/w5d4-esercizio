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

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    EdificiService edificioService;
    @Autowired
    PrenotazioniService prenotazioniService;
    @Autowired
    PostazioniService postazioniService;
    @Autowired
    UtentiService utentiService;

    final static Logger logger = LoggerFactory.getLogger("w5d4");

    public void run (String... args) throws Exception{

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Edifici e = ctx.getBean("palazzoFrancia", Edifici.class);
        edificioService.saveEdificio(e);
        logger.info("edificio aggiunto");
        Postazioni post = ctx.getBean("postazione1", Postazioni.class);
        postazioniService.savePostazione(post);
        logger.info("postazione aggiunta");
        Utenti u = ctx.getBean("marioRossi", Utenti.class);
        utentiService.saveUtente(u);
        logger.info("utente aggiunto");
        Prenotazioni p = ctx.getBean("prenotazione1", Prenotazioni.class);
        if ( p.getPostazione().getPrenotazioni().stream().map(prenotazioni-> prenotazioni.getData()).anyMatch(prenotazioni -> prenotazioni == p.getData())){
            logger.error("postazione occupata per quel giorno");
        } else {
            prenotazioniService.savePrenotazioni(p);
            logger.info("prenotazione aggiunto");
        }

    }

}
