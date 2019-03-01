package com.kiwilss.scrolltest.model.modelj;

import android.view.View;
import android.widget.Toast;

/**
 * @author : Lss kiwilss
 * @FileName: UserT
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/25
 * @desc : {DESCRIPTION}
 */
public class UserT {
    String name;
    String nickname;
    boolean isMale;
    int age;

    public void onNameClick(View view) {
        Toast.makeText(view.getContext(), name + " is Clicked", Toast.LENGTH_SHORT).show();
    }

    public boolean onNicknameLongClick(View view) {
        Toast.makeText(view.getContext(), nickname + " is long Clicked", Toast.LENGTH_SHORT).show();
        return true;
    }


    public UserT(String name, String nickname, boolean isMale, int age) {
        this.name = name;
        this.nickname = nickname;
        this.isMale = isMale;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
