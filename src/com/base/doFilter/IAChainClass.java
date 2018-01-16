package com.base.doFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ck on 2017-11-18.
 */
public class IAChainClass implements IAChain {

    List<IAClass> iaclassList = new ArrayList<>();

    public IAChainClass() {
        iaclassList.add(new IAClass());
        iaclassList.add(new IAClass());
        iaclassList.add(new IAClass());
        iaclassList.add(new IAClass());
    }

    int position;

    @Override
    public void doSomething() {
        if(position == iaclassList.size()) {
            System.out.println("执行完成");
            return;
        }
        IA ia = iaclassList.get(position++);
        ia.doSomething(this);
    }

    public static void main(String[] args) {
        IAChainClass clazz = new IAChainClass();
        clazz.doSomething();
    }
}
