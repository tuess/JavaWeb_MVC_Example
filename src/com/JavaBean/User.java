package com.JavaBean;

public class User {
    int id;
    String name;
    String tel;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public User(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}

