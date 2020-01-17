package com.example.todayinformation.splash;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.todayinformation.main.MainActivity;
import com.example.todayinformation.mvp.base.BaseMvpPresenter;

/**
 * author: xpf
 * time: 2020/1/17 6:04
 * describe: SplashActivity倒计时的任务P层实现
 */
public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {
    private static final String TAG = SplashTimerPresenter.class.getSimpleName();

    private CustomCountDownTimer mTimer;

    public SplashTimerPresenter(ISplashActivityContract.IView view) {
        super(view);
    }


    public void initTimer() {
        mTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer("跳过 " + time);
//                getView().setTvTimer("跳过 " + time);
            }

            @Override
            public void onFinish() {
                getView().startActivity(new Intent((Context) getView(), MainActivity.class));
                getView().finish();
            }
        });

        mTimer.start();
    }

    public void cancel() {
        mTimer.cancel();
    }

    /**
     * 防止空指针异常
     * @return
     */
    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.d(TAG, "onDestroy: " + System.currentTimeMillis());
    }

}
