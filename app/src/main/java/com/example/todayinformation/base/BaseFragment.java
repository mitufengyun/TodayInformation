package com.example.todayinformation.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todayinformation.mvp.view.LifecycleMvpFragment;

import butterknife.ButterKnife;

/**
 * author: xpf
 * time: 2020/1/15 19:02
 * describe: 基类Fragment
 */
@SuppressLint("Registered")
public abstract class BaseFragment extends LifecycleMvpFragment {

    private Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = null;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int layoutId = annotation.layoutId();
            if (layoutId > 0) {
                mView = initFragmentView(inflater,layoutId);
                bindView(mView);
                afterBindView();
            } else {
                throw new RuntimeException(" layoutId < 0 ");
            }
        } else {
            throw new NullPointerException(" annotation is null ");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater,int layoutId) {

        return inflater.inflate(layoutId, null);
    }

    // 模板方法 设计模式
    public abstract void afterBindView();

    // View 的依赖注入绑定
    private void bindView(View view) {
        ButterKnife.bind(this, view);
    }
}
