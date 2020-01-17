package com.example.todayinformation.main;

import androidx.fragment.app.Fragment;

import com.example.todayinformation.R;
import com.example.todayinformation.main.beijing.BeijingFragment;
import com.example.todayinformation.main.hangzhou.HangzhouFragment;
import com.example.todayinformation.main.shanghai.ShanghaiFragment;
import com.example.todayinformation.main.shenzhen.ShenzhenFragment;
import com.example.todayinformation.mvp.base.BaseMvpPresenter;

/**
 * author: xpf
 * time: 2020/1/17 12:37
 * describe:
 */
public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {
    //当前fragment的角标
    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    //当前选中的RadioButton的id
    private int mCurrentCheckedId;
    private int mTopPosition;
    private int mBottomPosition;
    private Fragment mFragment;


    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);

    }


    // 切换Fragment的方法
    public void replaceFragment(int currentFragmentIndex) {
        this.mCurrentFragmentIndex = currentFragmentIndex;
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }

        mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurrentChecked(mCurrentFragmentIndex);
        } else {
            createCurrentFragment(mCurrentFragmentIndex);
            setCurrentChecked(mCurrentFragmentIndex);
        }
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }

    /**
     * 记录当前显示Fragment的角标
     */
    private void setCurrentChecked(int index) {
        this.mCurrentFragmentIndex = index;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentCheckedId = R.id.rb_main_tab_shanghai;
                mTopPosition = 0;
                break;

            case 1:
                mCurrentCheckedId = R.id.rb_main_tab_hangzhou;
                mTopPosition = 1;
                break;
            case 2:
                mCurrentCheckedId = R.id.rb_main_tab_beijing;
                mBottomPosition = 2;
                break;
            case 3:
                mCurrentCheckedId = R.id.rb_main_tab_shenzhen;
                mBottomPosition = 3;
                break;
        }
    }

    /**
     * 创建Fragment
     * @param mCurrentFragmentIndex 要创建显示Fragment的角标
     */
    private void createCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case 0:
                fragment = new ShanghaiFragment();
                break;
            case 1:
                fragment = new HangzhouFragment();
                break;
            case 2:
                fragment = new BeijingFragment();
                break;
            case 3:
                fragment = new ShenzhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    /**
     * 显示Fragment
     */
    private void addAndShowFragment(Fragment fragment) {
        if (fragment.isAdded()) {
            getView().showFragment(fragment);
        } else {
            getView().addFragment(fragment);
        }
    }

    /**
     * 隐藏Fragment
     */
    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }
    }
}
