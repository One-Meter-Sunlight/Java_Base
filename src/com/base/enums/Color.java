package com.base.enums;

/**
 * Created by ck on 2017-09-17.
 */
public enum Color {

    RED(1, "红色"), BLUE(2, "蓝色"), YELLOW(3), BLACK, GREEN;

    int index;
    String name;

    Color(int index, String name) {
        this.index = index;
        this.name = name;
    }

    Color(int index) {
        this.index = index;
    }

    Color() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static void getColor() {
        for (Color color : Color.values()) {
            System.out.println(color.getName());
        }
    }

    public static void main(String[] args) {

        //当枚举第一次调用的时候，会去调用一次所有的构造方法，下次使用枚举，则不再调用；
        getColor();

        System.out.println(Color.BLACK);
    }
}
