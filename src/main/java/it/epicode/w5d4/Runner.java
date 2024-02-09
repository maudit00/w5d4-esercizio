package it.epicode.w5d4;

import it.epicode.w5d4.beans.Edifici;
import it.epicode.w5d4.services.EdificiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    public void run (String... args) throw Exception{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Edifici e = new Edifici();
        e.setNome("cacca");
        e.setCittà("Milano");
        EdificiService.saveEdici();


    }

}
