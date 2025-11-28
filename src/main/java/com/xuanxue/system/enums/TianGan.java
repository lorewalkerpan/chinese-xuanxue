package com.xuanxue.system.enums;

/**
 * 天干枚举
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public enum TianGan {
    JIA("甲", "木", "阳"),
    YI("乙", "木", "阴"),
    BING("丙", "火", "阳"),
    DING("丁", "火", "阴"),
    WU("戊", "土", "阳"),
    JI("己", "土", "阴"),
    GENG("庚", "金", "阳"),
    XIN("辛", "金", "阴"),
    REN("壬", "水", "阳"),
    GUI("癸", "水", "阴");

    private final String name;
    private final String wuXing;
    private final String yinYang;

    TianGan(String name, String wuXing, String yinYang) {
        this.name = name;
        this.wuXing = wuXing;
        this.yinYang = yinYang;
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

    /**
     * 根据索引获取天干
     * 
     * @param index 索引值（0-9）
     * @return 天干
     */
    public static TianGan fromIndex(int index) {
        return values()[index % 10];
    }
}


