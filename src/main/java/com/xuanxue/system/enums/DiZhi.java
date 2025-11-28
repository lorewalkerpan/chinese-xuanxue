package com.xuanxue.system.enums;

/**
 * 地支枚举
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public enum DiZhi {
    ZI("子", "水", "阳", "鼠", 23, 1),
    CHOU("丑", "土", "阴", "牛", 1, 3),
    YIN("寅", "木", "阳", "虎", 3, 5),
    MAO("卯", "木", "阴", "兔", 5, 7),
    CHEN("辰", "土", "阳", "龙", 7, 9),
    SI("巳", "火", "阴", "蛇", 9, 11),
    WU("午", "火", "阳", "马", 11, 13),
    WEI("未", "土", "阴", "羊", 13, 15),
    SHEN("申", "金", "阳", "猴", 15, 17),
    YOU("酉", "金", "阴", "鸡", 17, 19),
    XU("戌", "土", "阳", "狗", 19, 21),
    HAI("亥", "水", "阴", "猪", 21, 23);

    private final String name;
    private final String wuXing;
    private final String yinYang;
    private final String zodiac;
    private final int startHour;
    private final int endHour;

    DiZhi(String name, String wuXing, String yinYang, 
          String zodiac, int startHour, int endHour) {
        this.name = name;
        this.wuXing = wuXing;
        this.yinYang = yinYang;
        this.zodiac = zodiac;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getName() {
        return name;
    }

    public String getWuXing() {
        return wuXing;
    }

    public String getYinYang() {
        return yinYang;
    }

    public String getZodiac() {
        return zodiac;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    /**
     * 根据索引获取地支
     * 
     * @param index 索引值（0-11）
     * @return 地支
     */
    public static DiZhi fromIndex(int index) {
        return values()[index % 12];
    }

    /**
     * 根据时辰获取地支
     * 
     * @param hour 小时（0-23）
     * @return 地支
     */
    public static DiZhi fromHour(int hour) {
        if (hour == 23 || hour == 0) {
            return ZI;
        }
        return values()[(hour + 1) / 2];
    }
}


