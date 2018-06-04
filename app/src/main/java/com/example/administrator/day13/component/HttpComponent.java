package com.example.administrator.day13.component;

import com.example.administrator.day13.MainActivity;
import com.example.administrator.day13.module.HttpModule;
import com.example.administrator.day13.reg.Main2Activity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(MainActivity mainActivity);
    void inject(Main2Activity main2Activity);
}
