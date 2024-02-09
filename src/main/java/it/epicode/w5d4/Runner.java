package it.epicode.w5d4;

import it.epicode.w5d4.beans.Edifici;
import it.epicode.w5d4.services.EdificiService;
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

    final static Logger logger = LoggerFactory.getLogger("w5d4");

    public void run (String... args) throws Exception{

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d4Application.class);
        Edifici e = ctx.getBean(Edifici.class);
        e.setNome("cacca");
        e.setCittà("Milano");
        edificioService.saveEdificio(e);
        logger.info("edificio aggiunto");


    }

}
