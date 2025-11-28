package com.xuanxue.system.enums;

/**
 * 爻的类型枚举
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public enum YaoType {
    
    /**
     * 老阳（阳爻，会变）
     */
    OLD_YANG(9, "老阳", "⚊", true, true),
    
    /**
     * 少阳（阳爻，不变）
     */
    YOUNG_YANG(7, "少阳", "⚊", true, false),
    
    /**
     * 老阴（阴爻，会变）
     */
    OLD_YIN(6, "老阴", "⚋", false, true),
    
    /**
     * 少阴（阴爻，不变）
     */
    YOUNG_YIN(8, "少阴", "⚋", false, false);

    private final int value;
    private final String name;
    private final String symbol;
    private final boolean isYang;
    private final boolean isChanging;

    /**
     * 构造函数
     * 
     * @param value 数值
     * @param name 名称
     * @param symbol 符号
     * @param isYang 是否为阳爻
     * @param isChanging 是否为变爻
     */
    YaoType(int value, String name, String symbol, boolean isYang, boolean isChanging) {
        this.value = value;
        this.name = name;
        this.symbol = symbol;
        this.isYang = isYang;
        this.isChanging = isChanging;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isYang() {
        return isYang;
    }

    public boolean isChanging() {
        return isChanging;
    }

    /**
     * 根据数值获取爻类型
     * 
     * @param value 数值
     * @return 爻类型
     */
    public static YaoType fromValue(int value) {
        for (YaoType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid yao value: " + value);
    }
}


