package com.kiwilss.hxim.easyui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseBaseActivity;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.kiwilss.hxim.R;

/**
 * @author : Lss kiwilss
 * @FileName: EmChatActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/28
 * @desc : {DESCRIPTION}
 */
public class EmChatActivity extends EaseBaseActivity {
    private EmChatActivity activityInstance;
    private String toChatUsername;
    private EaseChatFragment chatFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em_chat);

        activityInstance = this;
        //user or group id
        toChatUsername = getIntent().getExtras().getString(EaseConstant.EXTRA_USER_ID);
        Log.e("MMM", "onCreate: "+toChatUsername );
        chatFragment = new EaseChatFragment();
        //set arguments
        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityInstance = null;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // enter to chat activity when click notification bar, here make sure only one chat activiy
        String username = intent.getStringExtra("userId");
        if (toChatUsername.equals(username))
            super.onNewIntent(intent);
        else {
            finish();
            startActivity(intent);
        }

    }
    @Override
    public void onBackPressed() {
        chatFragment.onBackPressed();
    }

    public String getToChatUsername(){
        return toChatUsername;
    }
}
