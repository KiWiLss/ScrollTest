package com.kiwilss.hxim.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessageBody;
import com.kiwilss.hxim.R;

import java.util.List;

/**
 * @author : Lss kiwilss
 * @FileName: ChatActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/27
 * @desc : {DESCRIPTION}
 */
public class ChatActivity extends AppCompatActivity {
    private android.widget.TextView tvchatcontent;
    private android.widget.EditText etchatchat;
    private android.widget.Button btnchatsend;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        this.btnchatsend = (Button) findViewById(R.id.btn_chat_send);
        this.etchatchat = (EditText) findViewById(R.id.et_chat_chat);
        this.tvchatcontent = (TextView) findViewById(R.id.tv_chat_content);


        id = getIntent().getStringExtra("id");

        btnchatsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
                EMMessage message = EMMessage.createTxtSendMessage(etchatchat.getText().toString(),
                        id);
//如果是群聊，设置chattype，默认是单聊
                //message.getChatType()
                //if (chatType == CHATTYPE_GROUP)
                    message.setChatType(EMMessage.ChatType.Chat);
//发送消息
                EMClient.getInstance().chatManager().sendMessage(message);


            }
        });


        //接收消息监听
        EMClient.getInstance().chatManager().addMessageListener(msgListener);

    }

    EMMessageListener msgListener = new EMMessageListener() {

        @Override
        public void onMessageReceived(List<EMMessage> messages) {
            //收到消息
            final String message = tvchatcontent.getText().toString();
            for (final EMMessage mm :
                    messages) {
                EMMessageBody body = mm.getBody();

                Log.e("MMM", "onMessageReceived: "+mm.getBody().toString() );
                runOnUiThread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        tvchatcontent.setText(message + "\n" +mm.getBody().toString());
                    }
                });

            }

        }

        @Override
        public void onCmdMessageReceived(List<EMMessage> messages) {
            //收到透传消息
        }

        @Override
        public void onMessageRead(List<EMMessage> messages) {
            //收到已读回执
        }

        @Override
        public void onMessageDelivered(List<EMMessage> message) {
            //收到已送达回执
        }

        @Override
        public void onMessageRecalled(List<EMMessage> list) {

        }

        @Override
        public void onMessageChanged(EMMessage message, Object change) {
            //消息状态变动
        }
    };

    @Override
    protected void onDestroy() {
        //记得在不需要的时候移除listener，如在activity的onDestroy()时
        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
        super.onDestroy();
    }
}
