package com.xuanxue.system.model;

import com.xuanxue.system.enums.YaoType;

/**
 * 爻实体类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class Yao {
    
    /**
     * 爻的位置（从下到上，1-6）
     */
    private int position;
    
    /**
     * 爻的类型
     */
    private YaoType type;

    public Yao() {
    }

    /**
     * 构造函数
     * 
     * @param position 爻的位置
     * @param type 爻的类型
     */
    public Yao(int position, YaoType type) {
        this.position = position;
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public YaoType getType() {
        return type;
    }

    public void setType(YaoType type) {
        this.type = type;
    }

    /**
     * 获取变化后的爻
     * 
     * @return 变化后的爻类型
     */
    public YaoType getChangedType() {
        if (!type.isChanging()) {
            return type;
        }
        return type.isYang() ? YaoType.YOUNG_YIN : YaoType.YOUNG_YANG;
    }

    @Override
    public String toString() {
        return "Yao{" +
                "position=" + position +
                ", type=" + type.getName() +
                ", symbol=" + type.getSymbol() +
                '}';
    }
}


