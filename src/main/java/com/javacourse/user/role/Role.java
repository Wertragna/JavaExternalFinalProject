package com.javacourse.user.role;
/**
 * A model class for role database table
 */
public enum Role {
    ADMIN("admin"),
    USER("user");
    private String name;
    private Role(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", name='" + name + '\'' +
                '}';
    }
}
