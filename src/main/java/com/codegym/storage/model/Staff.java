package com.codegym.storage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Staff {
    private int userID;

    public Staff(int userID) {
        this.userID = userID;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return "Staff{" +
                "userID=" + userID +
                '}';
    }
}
