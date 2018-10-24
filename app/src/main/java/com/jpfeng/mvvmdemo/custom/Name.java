package com.jpfeng.mvvmdemo.custom;

import java.io.Serializable;

/**
 * Author: Jpfeng
 * E-mail: fengjupeng@whale.ws
 * Date: 2018/10/24
 */
public class Name implements Serializable {
    private String firstName;
    private String lastName;

    public Name(String first, String last) {
        setFirstName(first);
        setLastName(last);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
