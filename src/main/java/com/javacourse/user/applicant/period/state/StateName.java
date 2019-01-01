package com.javacourse.user.applicant.period.state;

import java.util.Iterator;

public enum StateName{
    CHOICE_SUBJECTS{
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

    public abstract StateName getNext();


}
