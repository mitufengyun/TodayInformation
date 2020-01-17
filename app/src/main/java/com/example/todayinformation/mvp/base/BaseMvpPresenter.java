package com.example.todayinformation.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.presenter.LifecycleMvpPresenter;

/**
 * author: xpf
 * time: 2020/1/17 8:09
 * describe: P层的中间类
 * 抽象中介者：空实现ILifestyle接口中的方法
 */
public abstract   class BaseMvpPresenter<T extends IMvpView> extends LifecycleMvpPresenter<T> {

    public BaseMvpPresenter(T view) {
        super(view);
    }

    @Override
    public void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments) {

    }


    @Override
    public void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }
}
