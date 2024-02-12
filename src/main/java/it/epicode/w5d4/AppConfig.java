package it.epicode.w5d4;

import it.epicode.w5d4.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
@Bean("palazzoFrancia")
    public Edifici palazzoFrancia(){
    Edifici e = new Edifici();
    e.setCitta("Milano");
    e.setNome("Palazzo Francia");
    e.setIndirizzo("Via dei salici");
    return e;
}


@Bean ("postazione1")
public Postazioni postazione1(){
    Postazioni p = new Postazioni();
    p.setDescrizione("primo piano");
    p.setEdificio(palazzoFrancia());
    p.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
    p.setNMassimoOccupanti(200);
    return p;
}

@Bean("marioRossi")
    public Utenti marioRossi(){
    Utenti u = new Utenti();
    u.setNome("Mario");
    u.setCognome("Rossi");
    u.setEmail("mariorossi1@gmail.com");
    u.setUsername("mariorossi1");
    return u;
}

@Bean("prenotazione1")
    public Prenotazioni prenotazion1(){
    Prenotazioni p = new Prenotazioni();
    p.setData(LocalDate.now());
    p.setUtente(marioRossi());
    p.setPostazione(postazione1());
    return p;
}


    @Bean("prenotazione2")
    public Prenotazioni prenotazion2(){
        Prenotazioni p = new Prenotazioni();
        p.setData(LocalDate.now());
        p.setUtente(marioRossi());
        p.setPostazione(postazione1());
        return p;
    }

}
