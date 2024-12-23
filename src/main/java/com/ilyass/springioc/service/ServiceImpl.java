package com.ilyass.springioc.service;

import com.ilyass.springioc.dao.IDao;
import com.ilyass.springioc.service.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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

