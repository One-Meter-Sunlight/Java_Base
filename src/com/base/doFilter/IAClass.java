package com.base.doFilter;

/**
 * Created by ck on 2017-11-18.
 */
public class IAClass implements IA {

    @Override
    public void doSomething(IAChain chain) {
        System.out.println("IAClass 执行");
        chain.doSomething();
    }
}
