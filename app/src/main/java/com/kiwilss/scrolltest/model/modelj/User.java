package com.kiwilss.scrolltest.model.modelj;

import android.databinding.BaseObservable;

/**
 * @author : Lss kiwilss
 * @FileName: User
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/25
 * @desc : {DESCRIPTION}
 */
public class User extends BaseObservable {

    private String firstName;

    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
