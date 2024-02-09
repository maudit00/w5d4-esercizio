package it.epicode.w5d4;

import it.epicode.w5d4.beans.Edifici;
import it.epicode.w5d4.beans.Utenti;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
@Bean("palazzoFrancia")
    public Edifici palazzoFrancia(){
    Edifici e = new Edifici();
    e.setCittà("Milano");
    e.setNome("Palazzo Francia");
    e.setIndirizzo("Via dei salici");
    return e;
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



}
