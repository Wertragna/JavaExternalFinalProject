package com.javacourse.applicant.period.state;

public enum  State {
    CHOICE_SUBJECTS("choice_subject",1),
    CHECK_TESTS("check_test",2),
    CHOICE_SPECIALITY("choice_speciality",3),
    ENDED("ended",3);

    private int id;
    private String name;
    private State(String name,int id){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
