/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dimitrov.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;


@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "createdDate")
    private Timestamp date;
    @Column(name = "age")
    private int age;
    @Column(name = "isAdmin")
    private boolean isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (isAdmin != user.isAdmin) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return date != null ? date.equals(user.date) : user.date == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
