package com.javacourse.user.applicant.period.state;

import java.util.EnumMap;

public enum StateName {
    CHOICE_SUBJECTS {
        @Override
        public StateName getNext() {
            return StateName.CHECK_TESTS;
        }
    },
    CHECK_TESTS {
        @Override
        public StateName getNext() {
            return StateName.CHOICE_SPECIALITY;
        }
    },
    CHOICE_SPECIALITY {
        @Override
        public StateName getNext() {
            return StateName.ENDED;
        }
    },
    ENDED {
        @Override
        public StateName getNext() {
            return StateName.ENDED;
        }
    };

    private final static EnumMap<StateName, String> names = new EnumMap<>(StateName.class);
    static {
        names.put(CHOICE_SUBJECTS,"choice subjects");
        names.put(CHECK_TESTS, "check tests");
        names.put(CHOICE_SPECIALITY, "choice speciality");
        names.put(ENDED, "ended");
    }

    public static EnumMap<StateName, String> getNames() {
        return names;
    }

    public static StateName getByName(String name){
        for (StateName stateName:names.keySet()) {
            String nameSt= names.get(stateName);
            if(nameSt.equals(name))
                return stateName;
        }
        //toDo change this exception
        throw new NullPointerException();
    }

    public abstract StateName getNext();

}
