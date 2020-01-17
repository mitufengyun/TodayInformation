package com.example.todayinformation.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpController;

/**
 * author: xpf
 * time: 2020/1/17 8:25
 * describe:
 */
public class LifecycleMvpActivity extends AppCompatActivity implements IMvpView {

    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if (mvpController == null) {
            mvpController = new MvpController();
        }
        return mvpController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if (intent == null) {
            intent = new Intent();
        }

        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onCreate(savedInstanceState, intent, null);
            mvpController.onActivityCreated(savedInstanceState, intent, null);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onDestroy();
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpController mvpController = getMvpController();
        if (mvpController != null) {
            mvpController.onNewIntent(intent);
        }
    }
}
