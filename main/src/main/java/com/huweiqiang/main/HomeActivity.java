package com.huweiqiang.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huweiqiang.base.Transfer;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void toMine(View view) {
        Transfer.startActivity(this, "mine/MineActivity", new Intent());
    }
}
