package com.javacourse.user.role;
//todo write javadoc
public enum Role {
    ADMIN("admin"),
    USER("user");
    private int id;
    private String name;
    private Role(String name){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
