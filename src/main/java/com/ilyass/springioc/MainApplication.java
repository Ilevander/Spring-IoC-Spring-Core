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
