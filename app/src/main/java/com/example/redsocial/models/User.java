package com.example.redsocial.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("avatar")
    private String avatar;

    public User() {
    }

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String id, String username, String email,String avatar) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.avatar = avatar != null ? "https://5283-179-6-55-223.ngrok-free.app/api/files/users_red_social/" + id + "/" +avatar : "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
