package com.javacourse.user.role;
//todo write javadoc
public enum Role {
    ADMIN("admin",1),
    USER("user",2);
    private int id;
    private String name;
    private Role(String name, int id){
        this.name = name;
        this.id = id;
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
