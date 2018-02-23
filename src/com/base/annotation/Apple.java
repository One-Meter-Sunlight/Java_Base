package com.base.annotation;

/**
 * 苹果
 *
 * @author ck
 * 2018/2/23 16:02
 */
public class Apple {

    @FruitName(value = "陕西红富士")
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.BLUE)
    private String appleColor;
    @FruitProvider(id = 10086, name = "山西苹果中国", address = "陕西省中原市区")
    private String appleProvider;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
