package com.kiwilss.hxim.easyui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseBaseActivity;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.kiwilss.hxim.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lss kiwilss
 * @FileName: HomeActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/28
 * @desc : {DESCRIPTION}
 */

//@SuppressLint({"NewApi", "Registered"})
public class HomeActivity extends EaseBaseActivity {
    private android.widget.Button btnhomechat;
    private android.widget.Button btnhomeconnact;
    private android.widget.Button btnhomemy;
    private android.widget.FrameLayout flhomecontainer;

    private EaseConversationListFragment conversationListFragment;
    private EaseContactListFragment contactListFragment;
    private SettingsFragment settingFragment;
    private ArrayList<Fragment> fragments;

    private int index;
    private int currentTabIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.flhomecontainer = (FrameLayout) findViewById(R.id.fl_home_container);
        this.btnhomemy = (Button) findViewById(R.id.btn_home_my);
        this.btnhomeconnact = (Button) findViewById(R.id.btn_home_connact);
        this.btnhomechat = (Button) findViewById(R.id.btn_home_chat);

        fragments = new ArrayList<>();

        conversationListFragment = new EaseConversationListFragment();
        contactListFragment = new EaseContactListFragment();
        settingFragment = new SettingsFragment();

        fragments.add(conversationListFragment);
        fragments.add(contactListFragment);
        fragments.add(settingFragment);

        contactListFragment.setContactsMap(getContacts());

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_home_container,conversationListFragment)
                .add(R.id.fl_home_container,contactListFragment)
                .add(R.id.fl_home_container,settingFragment)
                .hide(contactListFragment).hide(settingFragment).show(conversationListFragment)
                .commit();


        conversationListFragment.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation conversation) {
                startActivity(new Intent(HomeActivity.this, EmChatActivity.class)
                        .putExtra(EaseConstant.EXTRA_USER_ID, conversation.conversationId()));

            }
        });


        contactListFragment.setContactListItemClickListener(new EaseContactListFragment.EaseContactListItemClickListener() {

            @Override
            public void onListItemClicked(EaseUser user) {
                startActivity(new Intent(HomeActivity.this, EmChatActivity.class)
                        .putExtra(EaseConstant.EXTRA_USER_ID, user.getUsername()));
            }
        });



        //点击切换
        btnhomechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 0;
                changeFg();
            }
        });
        btnhomeconnact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 1;
                changeFg();
            }
        });
        btnhomemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 2;
                changeFg();
            }
        });
    }

    private void changeFg() {
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments.get(currentTabIndex));
            if (!fragments.get(index).isAdded()) {
                trx.add(R.id.fl_home_container, fragments.get(index));
            }
            trx.show(fragments.get(index)).commit();
        }
        currentTabIndex = index;
    }

    /**
     * prepared users, password is "123456"
     * you can use these user to test
     * @return
     */
    private Map<String, EaseUser> getContacts(){
        Map<String, EaseUser> contacts = new HashMap<String, EaseUser>();
        for(int i = 1; i <= 10; i++){
            EaseUser user = new EaseUser("test" + i);
            contacts.put("test" + i, user);
        }
        return contacts;
    }
}
