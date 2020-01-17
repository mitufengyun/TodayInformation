package com.example.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * author: xpf
 * time: 2020/1/17 6:56
 * describe:
 */
public interface ILifecycle {

    void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments);

//    void onCreateView();

    void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onNewIntent(Intent intent);

    void attachView(IMvpView iMvpView);

    void destroyView();

    void onViewDestroy();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle bundle);
}
