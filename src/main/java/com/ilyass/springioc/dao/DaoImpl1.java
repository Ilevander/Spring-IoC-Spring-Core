package com.ilyass.springioc.dao;

import com.ilyass.springioc.service.model.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("dao1")
public class DaoImpl1 implements IDao {
    private static final List<Article> repository = List.of(
            new Article(1L, "PC HP I7", 25000d, 5d),
            new Article(2L, "PC HP I5", 15000d, 10d),
            new Article(3L, "TV LG 32p", 3500d, 8d),
            new Article(4L, "TV SAMSUNG 60p", 9000d, 15d));

    @Override
    public List<Article> getAll() {
        return repository;
    }

    @Override
    public void save(Article article) {
        repository.add(article);
    }

    @Override
    public void deleteById(Long id) {
        repository.remove(repository.stream().filter(a -> a.getId().equals(id)).findAny().orElse(null).getId().intValue());
    }

    @Override
    public Article findById(Long id) {
        return repository.stream().filter(a -> a.getId().equals(id)).findAny().orElse(null);
    }
}

/*
    • L’annotation @Repository de Spring Context permet à Spring de gérer le Bean annoté par cette dernière.

    • L’annotation @Repository hérite de l’annotation @Component.

    • L’annotation @Component permet d’ajouter le bean annoté par cette dernière au conteneur de Spring. Les beans se trouvant dans le conteneur de Spring sont des « Managed Bean ».
 */