/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dimitrov.dao;

import com.github.dimitrov.entity.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.access.InvocationFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDAO implements IUserDAO<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User findByName(String name) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("name", name).ignoreCase())
                .uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAllWithName(String name) {
        return sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.like("name", name + "%").ignoreCase())
                .list();
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User deleteUser(String id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, Integer.parseInt(id));
        deleteUser(user);
        return user;
    }

    @Override
    public List<User> findAll(int page) {
        int maxResult = 20;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.setFirstResult(maxResult * page);
        criteria.setMaxResults(maxResult);
        List<User> users = criteria.list();
        return users;
    }
}
