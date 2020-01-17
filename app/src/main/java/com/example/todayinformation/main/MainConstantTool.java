package com.example.todayinformation.main;

import androidx.annotation.IntDef;

import static com.example.todayinformation.main.MainConstantTool.BEIJING;
import static com.example.todayinformation.main.MainConstantTool.HANGZHOU;
import static com.example.todayinformation.main.MainConstantTool.SHANGHAI;
import static com.example.todayinformation.main.MainConstantTool.SHENZHEN;

/**
 * author: xpf
 * time: 2020/1/17 16:29
 * describe:
 */
@IntDef({SHANGHAI, HANGZHOU, BEIJING, SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
