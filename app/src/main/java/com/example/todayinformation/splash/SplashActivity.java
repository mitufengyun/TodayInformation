package com.example.todayinformation.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.todayinformation.base.BaseActivity;
import com.example.todayinformation.main.MainActivity;
import com.example.todayinformation.R;
import com.example.todayinformation.base.ViewInject;

import java.io.File;

import butterknife.BindView;

@ViewInject(layoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {


    @BindView(R.id.vv_play)
    FullScreenVideoView mVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView mTvTimer;
    private ISplashActivityContract.IPresenter mTimerPresenter;

    @Override
    public void afterBindView() {
        initTimerPresenter();
        initVideoPlay();
        initListener();
    }


    private void initTimerPresenter() {
        mTimerPresenter = new SplashTimerPresenter(this);
        mTimerPresenter.initTimer();
    }


    private void initListener() {
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    /**
     * splash页面视频播放
     */
    private void initVideoPlay() {
        // 设置资源路径
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));

        // 准备的监听
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // 播放
                mp.start();
            }
        });

        // 完成的监听
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // 完成后，再次播放，起到循环播放效果
                mp.start();
            }
        });
    }

    public void jump(View view) {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }


    public void setTvTimer(String string) {
        mTvTimer.setText(string);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimerPresenter.onDestroy();
    }
}
