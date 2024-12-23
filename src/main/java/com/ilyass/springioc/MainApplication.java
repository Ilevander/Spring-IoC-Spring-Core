package com.ilyass.springioc;

import com.ilyass.springioc.dao.DaoImpl1;
import com.ilyass.springioc.dao.IDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ilyass.springioc")
public class MainApplication {

    @Bean
    @Qualifier("dao1")
    public IDao getDao() {
        return new DaoImpl1();
    }
}

/*
 *     • L’annotation @Configuration est une classe Java Config. Elle est équivalente à un fichier XML. Cette classe devrait contenir les Bean à utiliser dans l’application.
 *
 *     • L’annotation  @ComponentScan permet à Spring de gérer toutes les classes se trouvant au niveau du package ma.formations.ioc et également au niveau des sous packages de ce dernier.
 *
 *     • Spring ignorera toute classe ne se trouvant pas dans ces packages.
 */