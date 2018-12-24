package com.javacourse.shared.web;

public class Page {
    String name;
     private boolean isRedirect;

    public Page(String name, boolean isRedirect) {
        this.name = name;
        this.isRedirect = isRedirect;
    }

    public String getName() {
        return name;
    }

    public boolean isRedirect() {
        return isRedirect;
    }
}
