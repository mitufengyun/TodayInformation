package com.example.todayinformation.splash;

import android.content.Intent;

import com.example.todayinformation.mvp.ILifecycle;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpController;

/**
 * author: xpf
 * time: 2020/1/17 9:41
 * describe:
 */
public interface ISplashActivityContract {

    interface IView extends IMvpView {
       void setTvTimer(String timer);
       void startActivity(Intent intent);
       void finish();
    }

    interface IPresenter extends ILifecycle {
        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public void startActivity(Intent intent) {

        }

        @Override
        public void finish() {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
