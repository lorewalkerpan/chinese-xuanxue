package com.xuanxue.system.enums;

/**
 * 八卦枚举
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public enum Trigram {
    
    /**
     * 乾卦：天
     */
    QIAN("乾", "111", "天", "☰"),
    
    /**
     * 兑卦：泽
     */
    DUI("兑", "011", "泽", "☱"),
    
    /**
     * 离卦：火
     */
    LI("离", "101", "火", "☲"),
    
    /**
     * 震卦：雷
     */
    ZHEN("震", "001", "雷", "☳"),
    
    /**
     * 巽卦：风
     */
    XUN("巽", "110", "风", "☴"),
    
    /**
     * 坎卦：水
     */
    KAN("坎", "010", "水", "☵"),
    
    /**
     * 艮卦：山
     */
    GEN("艮", "100", "山", "☶"),
    
    /**
     * 坤卦：地
     */
    KUN("坤", "000", "地", "☷");

    private final String name;
    private final String binary;
    private final String nature;
    private final String symbol;

    /**
     * 构造函数
     * 
     * @param name 卦名
     * @param binary 二进制表示（1为阳，0为阴）
     * @param nature 自然象征
     * @param symbol 卦象符号
     */
    Trigram(String name, String binary, String nature, String symbol) {
        this.name = name;
        this.binary = binary;
        this.nature = nature;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getBinary() {
        return binary;
    }

    public String getNature() {
        return nature;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * 根据二进制字符串获取卦象
     * 
     * @param binary 二进制字符串
     * @return 八卦
     */
    public static Trigram fromBinary(String binary) {
        for (Trigram trigram : values()) {
            if (trigram.binary.equals(binary)) {
                return trigram;
            }
        }
        throw new IllegalArgumentException("Invalid binary: " + binary);
    }
}


