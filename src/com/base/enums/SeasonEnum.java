package com.base.enums;

/**
 * Created by ck on 2017-09-17.
 */
public enum SeasonEnum {

    SPRING,  SUMMER, AUTUMN, WINTER, UNKNOWN;

    private static void showSeason(SeasonEnum e) {
        switch (e) {
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
            default:
                System.out.println("未知的节气");
                break;
        }

    }

    public static void main(String[] args) {

        System.out.println(SeasonEnum.SPRING.equals(SeasonEnum.SPRING.name())); // false 一边是枚举类型，一边是字符串

        System.out.println(SeasonEnum.SPRING.equals(SeasonEnum.SPRING)); //  true

        System.out.println(SeasonEnum.SPRING.toString().equals(SeasonEnum.SPRING.name())); // true  两边都是字符串

        SeasonEnum.showSeason(SeasonEnum.UNKNOWN); // default

    }
}
