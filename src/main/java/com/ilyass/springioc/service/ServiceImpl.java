package com.ilyass.springioc.service;

import com.ilyass.springioc.dao.IDao;
import com.ilyass.springioc.service.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/*
NB : Spring crée par défaut les Beans sous forme de Singleton (une seule instance).
Si vous voulez que Spring crée à chaque fois une nouvelle instance du même Bean, il suffit d’annoter votre classe par : @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE).
 */

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

/*
    • L’annotation @Service de Spring Context permet à Spring de gérer le Bean annoté par cette dernière.

    • L’annotation @Service est utilisée sur les classes de la couche Service (ou Métier).
 */
@Service
public class ServiceImpl implements IService{
    private IDao dao;

    public ServiceImpl(@Qualifier("dao1") IDao dao) {
        this.dao = dao;
    }

    @Autowired
    @Qualifier("dao2")
    public void setDao(IDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Article> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(Article article) {
        dao.save(article);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Article findById(Long id) {
        return dao.findById(id);
    }
}

/*
    • L’annotation @Autowired appliquée sur le setter permet d’injecter le Bean implémentant l’interface IDao. Dans ce cas, Spring IOC passe une instance de la classe implémentant l’interface IDao en paramètre de la méthode setDao(IDao dao) : c’est l’injection par Modificateur.
    A partir de la version 4.3 de Spring, l’annotation @Autowired est facultative à condition que la classe ait un seul constructeur.
    Le cas échéant, il faut annoter le setter par cette dernière.

    • Vous constatez que la classe ServiceImpl n’a aucune connaissance de la classe implémentant l’interface IDao.
    En effet, nous pouvons changer l’implémentation de l’interface IDao sans modifier le code source de la classe ServiceImpl : c’est le principe de couplage faible.

    • Pour que Spring puisse injecter une instance de la classe DaoImpl2 au lieu de la classe DaoImpl1, il suffit d’annoter la classe DaoImpl2 par @Repository. Dans ce cas, il faut supprimer l’annotation @Repository de la classe DaoImpl1.

    • Si vous souhaitez garder l’annotation @Repository sur les deux classes DaoImpl1 et DaoImpl2, vous pouvez utiliser l’annotation @Qualifier comme expliqué ci-après :
    De cette façon, Spring injectera une instance de la classe DaoImpl2.

 */

