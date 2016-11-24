/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dimitrov.dao;

import com.github.dimitrov.entity.User;

import java.io.Serializable;
import java.util.List;

public interface IUserDAO<T extends Serializable> {
    
    void save(User user);

    void update(User user);

    List<User> findAll();
    
    User findByName(String name);

    List findAllWithName(String name);

    void deleteUser(User user);

    User deleteUser(String id);

    List<User> findAll(int page);
}
