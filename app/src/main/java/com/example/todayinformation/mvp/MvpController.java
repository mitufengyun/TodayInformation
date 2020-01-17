package com.example.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * author: xpf
 * time: 2020/1/17 8:31
 * describe:
 */
public class MvpController implements ILifecycle{

    // 存放的是P层的实例
    private Set<ILifecycle> lifecycles = new HashSet<>();

    public void savePresenter(ILifecycle iLifecycle) {
        this.lifecycles.add(iLifecycle);
    }

    public static MvpController newInstance() {
        return new MvpController();
    }


    @Override
    public void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifecycle> iterator = this.lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            presenter.onCreate(saveInstanceState, intent, getArguments);

        }
    }



    @Override
    public void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            presenter.onActivityCreated(saveInstanceState, intent, getArguments);

        }
    }

    @Override
    public void onStart() {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.onStart();
        }

    }

    @Override
    public void onResume() {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            presenter.onNewIntent(intent);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            presenter.attachView(iMvpView);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();

            presenter.onActivityResult(requestCode, resultCode, data);

        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifecycle> iterator = lifecycles.iterator();
        while (iterator.hasNext()) {
            ILifecycle presenter = iterator.next();
            if (bundle == null) {
                bundle = new Bundle();
            }
            presenter.onSaveInstanceState(bundle);
        }
    }

}
