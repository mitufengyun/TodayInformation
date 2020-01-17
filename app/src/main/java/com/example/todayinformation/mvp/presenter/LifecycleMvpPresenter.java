package com.example.todayinformation.mvp.presenter;

import com.example.todayinformation.mvp.ILifecycle;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpController;

import java.lang.ref.WeakReference;

/**
 * author: xpf
 * time: 2020/1/17 7:03
 * describe:
 */
public abstract class LifecycleMvpPresenter<T extends IMvpView> implements ILifecycle {

    private WeakReference<T> mWeakReference;

    protected LifecycleMvpPresenter() {
        super();
    }

    public LifecycleMvpPresenter(IMvpView iMvpView) {
        super();
        attachView(iMvpView);
        MvpController mvpController = iMvpView.getMvpController();
        mvpController.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if (mWeakReference == null) {
            mWeakReference = new WeakReference(iMvpView);
        } else {
           T view = mWeakReference.get();
            if (view != null) {
                mWeakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        mWeakReference = null;
    }

    protected T getView() {
        T view = mWeakReference != null ? mWeakReference.get() : null;
        if (view == null) {
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();
}
