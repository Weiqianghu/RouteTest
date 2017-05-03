package com.huweiqiang.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.huweiqiang.base.AccountUtil;
import com.huweiqiang.base.Transfer;

public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
    }

    public void isLogin(View view) {
        try {
            AccountUtil accountUtil = (AccountUtil) Transfer.obtainService(AccountUtil.class);
            Toast.makeText(this, String.valueOf(accountUtil.isLogin()), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
