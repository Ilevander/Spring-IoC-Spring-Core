package com.ilyass.springioc;

import com.ilyass.springioc.service.IService;
import com.ilyass.springioc.service.ServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestService {

	static AnnotationConfigApplicationContext context = null;

	@BeforeAll
	static void init() {
		context = new AnnotationConfigApplicationContext(MainApplication.class);
	}

	@AfterAll
	static void close() {
		context.close();
	}

	@Test
	void test1() {
		IService service = context.getBean(ServiceImpl.class);
		Assertions.assertAll("données erronées",
				() -> Assertions.assertEquals(1L, service.findById(1L).getId(), "First Id article is not correct"),
				() -> Assertions.assertEquals("PC HP I7", service.findById(1L).getDescription(), "First article description is not correct"),
				() -> Assertions.assertEquals(25000d, service.findById(1L).getPrice(), "First article price is not correct"),
				() -> Assertions.assertEquals(5d, service.findById(1L).getQuantity(), "First article quantity is not correct"));
	}

}

/*
    • L’annotation @BeforeAll de JUNIT permet d’exécuter la méthode une seule fois au début (avant toutes les méthodes annotées par @Test).

    • La méthode annotée par @BeforeAll doit être static.

    • L’annotation @AfterAll de JUNIT permet d’exécuter la méthode une seule fois à la fin (après toutes les méthodes annotées par @Test).

    • La méthode annotée par @AfterAll doit être static.

    • Remarquez que nous avons commencé par instancier la classe AnnotationConfigApplicationContext en lui passant en paramètre la classe MainApplication.

    En effet, ceci permettra de créer le conteneur de Spring et d’ajouter à ce dernier toutes les classes se trouvant au niveau du package ma.formations.ioc.

    • La méthode AnnotationConfigApplicationContext.getBean(ServiceImpl.class)  permet de récupérer une instance de la classe ServiceImpl.

    • Remarquez que nous avons utilisé la méthode Assertions.assertAll qui permet d’exécuter plusieurs vérifications.
 */
