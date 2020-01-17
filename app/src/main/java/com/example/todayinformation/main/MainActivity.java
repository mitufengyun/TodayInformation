package com.example.todayinformation.main;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.todayinformation.R;
import com.example.todayinformation.base.ViewInject;
import com.example.todayinformation.base.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(layoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView{


    @BindView(R.id.fab_main_home)
    FloatingActionButton fabMainHome;
    @BindView(R.id.rb_main_tab_shanghai)
    RadioButton rbMainTabShanghai;
    @BindView(R.id.rb_main_tab_hangzhou)
    RadioButton rbMainTabHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.rb_main_tab_beijing)
    RadioButton rbMainNavHomeBeijing;
    @BindView(R.id.rb_main_tab_shenzhen)
    RadioButton rbMainNavHomeShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    private boolean isChangeTopOrBottom;

    //当前选中的RadioButton的id
    private int mCurrentCheckedId;


    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnimate(rgMainBottom, rgMainTop);
    }

    // 初始化Fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    @OnClick({R.id.fab_main_home, R.id.rb_main_tab_shanghai, R.id.rb_main_tab_hangzhou, R.id.rb_main_tab_beijing, R.id.rb_main_tab_shenzhen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab_main_home:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnimate(rgMainTop, rgMainBottom);
                    handleTopPosition();
                } else {
                    changeAnimate(rgMainBottom, rgMainTop);
                    handleBottomPosition();
                }
                break;

            case R.id.rb_main_tab_shanghai:
                mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                break;
            case R.id.rb_main_tab_hangzhou:
                mPresenter.replaceFragment(MainConstantTool.HANGZHOU);

                break;
            case R.id.rb_main_tab_beijing:
                mPresenter.replaceFragment(MainConstantTool.BEIJING);

                break;
            case R.id.rb_main_tab_shenzhen:
                mPresenter.replaceFragment(MainConstantTool.SHENZHEN);

                break;
        }
    }

    // 上海、杭州
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() != 3) {
            mPresenter.replaceFragment(2);
            rbMainNavHomeBeijing.setChecked(true);
        } else {
            mPresenter.replaceFragment(3);
            rbMainNavHomeShenzhen.setChecked(true);
        }
    }

    // 北京、深圳
    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() != 1) {
            mPresenter.replaceFragment(0);
            rbMainTabShanghai.setChecked(true);
        } else {
            mPresenter.replaceFragment(1);
            rbMainTabHangzhou.setChecked(true);
        }
    }

    /**
     * RadioGroup切换动画(上海、杭州切换到北京、深圳)
     */
    private void changeAnimate(RadioGroup gone, RadioGroup show) {
        // 消失动画
        gone.clearAnimation();// 先清除动画
        Animation goneAnimation = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(goneAnimation);
        gone.setVisibility(View.GONE);

        // 显示的动画
        show.clearAnimation();
        Animation showAnimation = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(showAnimation);
        show.setVisibility(View.VISIBLE);


    }



    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, fragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }
}
