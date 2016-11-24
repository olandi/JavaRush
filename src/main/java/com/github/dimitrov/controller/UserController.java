/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dimitrov.controller;

import com.github.dimitrov.dao.IUserDAO;
import com.github.dimitrov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;


@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private IUserDAO dao;
    
    @RequestMapping("/home/{page}")
    public ModelAndView home(ModelMap model,@PathVariable String page) {
        int pageNumber = Integer.parseInt(page);
        if(pageNumber>0 && pageNumber <100) {
            model.put("users", dao.findAll(pageNumber-1));
        }
        return new ModelAndView("users", model);
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public User saveContact(User user) {
        user.setDate(new Timestamp(System.currentTimeMillis()));
        dao.save(user);
        return user;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public void updateContact(@RequestBody User user) {
        dao.update(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User deleteContact(@PathVariable String id) {
        return dao.deleteUser(id);
    }
    
    @RequestMapping(value = "/getJSON/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User findByName(@PathVariable("name") String name) {
        return dao.findByName(name);
    }
    
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public ModelAndView load() {
        return new ModelAndView("/table");
    }
    
    @RequestMapping(value = "/load/{name}", method = RequestMethod.GET)
    public ModelAndView loadByName(@PathVariable("name") String name, ModelMap model) {
        model.put("users", dao.findAllWithName(name));
        return new ModelAndView("/search", model);
    }
}
