package com.sourin.githubapp;

public class modelTwo {
    int id;
    String name, full_name, repos_url;

    public modelTwo(int id, String name, String full_name, String repos_url) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.repos_url = repos_url;
    }

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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }
}
