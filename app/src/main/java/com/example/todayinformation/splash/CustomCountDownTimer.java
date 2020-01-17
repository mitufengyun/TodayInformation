package com.example.todayinformation.splash;

import android.os.Handler;

/**
 * author: xpf
 * time: 2020/1/15 16:19
 * describe: splash页面广告倒数计时
 */
public class CustomCountDownTimer implements Runnable{
    // 1、实时去回调 这个时候是什么时间 倒计时到几秒 观察者设计模式
    // 2、支持动态传入总时间
    // 3、每过一秒 总秒数减一
    // 4、总时间倒计时为0时，要回调完成的状态

    private int time;// 倒计时初始值
    private int countDowntime;// 倒计时当前显示的值
    private final ICountDownHandler countDownHandler;
    private final Handler mHandler;
    // 首次进入应用
    private boolean isRun;

    public CustomCountDownTimer (int time, ICountDownHandler countDownHandler) {
        mHandler = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;
    }

    @Override
    public void run() {
        if (isRun) {
            if (countDownHandler != null) {
                countDownHandler.onTicker(countDowntime);
            }

            // 判断倒计时是否为0，是就结束(跳转至主界面)，否就自减一
            if (countDowntime == 0) {
                if (countDownHandler != null) {
                    countDownHandler.onFinish();
                }
            } else  {
                countDowntime = time--;
                mHandler.postDelayed(this, 1000);
            }
        }
    }


    /**
     * 开始倒计时
     */
    public void start() {
        isRun = true;
        mHandler.post(this);
    }

    /**
     * 结束倒计时
     */
    public void cancel() {
        isRun = false;
        mHandler.post(this);
    }


    // 观察者回调接口(观察倒计时)
    public interface ICountDownHandler {
        // 倒计时回调
        void onTicker(int time);
        // 完成时回调
        void onFinish();
    }
}
