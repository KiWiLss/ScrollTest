package com.kiwilss.hxim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.kiwilss.hxim.R;
import com.kiwilss.hxim.easyui.HomeActivity;

/**
 * @author : Lss kiwilss
 * @FileName: LoginActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/27
 * @desc : {DESCRIPTION}
 */
public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    private android.widget.EditText etloginaccount;
    private android.widget.EditText etloginpassword;
    private android.widget.Button btnloginregister;
    private android.widget.Button btnloginlogin;
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.btnloginlogin = (Button) findViewById(R.id.btn_login_login);
        this.btnloginregister = (Button) findViewById(R.id.btn_login_register);
        this.etloginpassword = (EditText) findViewById(R.id.et_login_password);
        this.etloginaccount = (EditText) findViewById(R.id.et_login_account);


        type = getIntent().getStringExtra("type");


        //register
        btnloginregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            EMClient.getInstance().createAccount(etloginaccount.getText().toString(),
                                    etloginpassword.getText().toString());
                            Log.e(TAG, "run: register success" );
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                            Log.e(TAG, "run: "+ e.getErrorCode() +"--" +e.getMessage() );
                        }
                    }
                }).start();

            }
        });

        //login
        btnloginlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EMClient.getInstance().login(etloginaccount.getText().toString(),
                        etloginpassword.getText().toString(), new EMCallBack() {
                            @Override
                            public void onSuccess() {
                                Log.e(TAG, "onSuccess: " );
                                if (TextUtils.isEmpty(type)) {
                                    startActivity(new Intent(LoginActivity.this,EmTakeActivity.class));
                                }else {
                                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                                }

                            }

                            @Override
                            public void onError(int code, String error) {
                                Log.e(TAG, "onError: "+error );
                            }

                            @Override
                            public void onProgress(int progress, String status) {
                                Log.e(TAG, "onProgress: "+progress +"status" + status );
                            }
                        });
            }
        });
    }
}
