package com.kiwilss.scrolltest.uij.et;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import com.kiwilss.scrolltest.R;

/**
 * @author : Lss kiwilss
 * @FileName: EtActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/19
 * @desc : {DESCRIPTION}
 */
public class EtActivity extends AppCompatActivity {
    private EditText etetpwd;

    String mPwd;
    String mText;
    private android.widget.TextView tvettx;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et);
        this.tvettx = (TextView) findViewById(R.id.tv_et_tx);
        etetpwd = findViewById(R.id.et_et_pwd);



        etetpwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                etetpwd.setAlpha(0);
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //tvettx.removeCallbacks(mRunnable);
                if (TextUtils.isEmpty(mPwd)){
                    mPwd = charSequence.toString();
                    String oldTx = tvettx.getText().toString();
                    int length = mPwd.length();
                    if (length > 0){
                        String last = mPwd.substring(length - 1, length);
                        tvettx.setText(oldTx + last);
                        final String s = mPwd.replaceAll("[\\d\\w]", "*");
                        Log.e("MMM", "afterTextChanged: " + s);
                        //etetpwd.setText(s);
                        mText = s;
                        tvettx.postDelayed(mRunnable,400);
                    }
                }else {
                    int oldLenth = mPwd.length();
                    Log.e("MMM", "onTextChanged: " + charSequence + "---" + i +"---" +i1 +"---" + i2);
                    mPwd = charSequence.toString();
                    String oldTx = tvettx.getText().toString();
                    int length = mPwd.length();
                    if (oldLenth > length){
                            tvettx.setText(oldTx.substring(0,oldLenth-1));
                            if (oldLenth == 1){
                                etetpwd.setAlpha(1);
                            }
                    }else {
                        if (length > 0){
                            String last = mPwd.substring(length - 1, length);
                            tvettx.setText(oldTx + last);
                            final String s = mPwd.replaceAll("[\\d\\w]", "*");
                            Log.e("MMM", "afterTextChanged: " + s);
                            //etetpwd.setText(s);
                            mText = s;

                            tvettx.postDelayed(mRunnable,400);

                        }

                    }

                }




            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        //etetpwd.setTransformationMethod(new AsteriskPasswordTransformationMethod());

//        etetpwd.setTransformationMethod(new TransformationMethod() {
//            @Override
//            public CharSequence getTransformation(CharSequence charSequence, View view) {
//                return new SubCharSequence(charSequence);
//            }
//
//            @Override
//            public void onFocusChanged(View view, CharSequence charSequence, boolean b, int i, Rect rect) {
//                Log.e("MMM", "onFocusChanged: "+charSequence +"----" + b +"----" + i );
//            }
//        });
    }
    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            tvettx.setText(mText);
        }
    };


    private class SubCharSequence implements CharSequence {
        private CharSequence mSource;

        public SubCharSequence(CharSequence source) {
            mSource = source;
        }

        public char charAt(int index) {
            return '*';
        }

        public int length() {
            return mSource.length();
        }

        public CharSequence subSequence(int start, int end) {
            return mSource.subSequence(start, end);
        }
    }
}
