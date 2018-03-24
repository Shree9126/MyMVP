package com.mindnotix.mymvp.model;

/**
 * Created by Admin on 3/24/2018.
 */

public class User {


    private String id;
    private String name;
    private String body;

    public User(String id, String name, String body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
