package com.kiwilss.hxim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.kiwilss.hxim.R;

/**
 * @author : Lss kiwilss
 * @FileName: EmTakeActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/27
 * @desc : {DESCRIPTION}
 */
public class EmTakeActivity extends AppCompatActivity {
    private android.widget.EditText etemtakeid;
    private android.widget.Button btnemtaketake;
    private android.widget.Button btnemtakeexit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emtake);
        this.btnemtakeexit = (Button) findViewById(R.id.btn_emtake_exit);
        this.btnemtaketake = (Button) findViewById(R.id.btn_emtake_take);
        this.etemtakeid = (EditText) findViewById(R.id.et_emtake_id);



        btnemtakeexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EMClient.getInstance().logout(true, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        Log.e("MMM", " exit onSuccess: " );
                    }

                    @Override
                    public void onError(int code, String error) {
                        Log.e("MMM", " exit error: " + error );
                    }

                    @Override
                    public void onProgress(int progress, String status) {
                        Log.e("MMM", " exit : " + progress +"---" + status );
                    }
                });
            }
        });

        btnemtaketake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String account = etemtakeid.getText().toString().trim();
                Intent intent = new Intent(EmTakeActivity.this, ChatActivity.class);
                intent.putExtra("id",account);
                startActivity(intent);

            }
        });
    }
}
