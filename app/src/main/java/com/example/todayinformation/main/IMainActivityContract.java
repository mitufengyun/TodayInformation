package com.example.todayinformation.main;

import androidx.fragment.app.Fragment;

import com.example.todayinformation.mvp.ILifecycle;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpController;

/**
 * author: xpf
 * time: 2020/1/17 9:41
 * describe:
 */
public interface IMainActivityContract {

    interface IView extends IMvpView {


        void showFragment(Fragment fragment);

        void addFragment(Fragment fragment);

        void hideFragment(Fragment fragment);
    }

    interface IPresenter extends ILifecycle {

        void initHomeFragment();


        void replaceFragment(int index);

        int getTopPosition();

        int getBottomPosition();
    }

    IView emptyView = new IView() {


        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
