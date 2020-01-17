package com.example.todayinformation.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.todayinformation.mvp.view.LifecycleMvpActivity;

import butterknife.ButterKnife;

/**
 * author: xpf
 * time: 2020/1/15 19:02
 * describe: 基类Activity
 */
@SuppressLint("Registered")
public abstract class BaseActivity extends LifecycleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int layoutId = annotation.layoutId();
            if (layoutId > 0) {
                setContentView(layoutId);
                bindView();
                afterBindView();
            } else {
                throw new RuntimeException(" layoutId < 0 ");
            }
        } else {
            throw new NullPointerException(" annotation is null ");
        }
    }

    // 模板方法 设计模式
    public abstract void afterBindView();

    // View 的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);
    }
}
