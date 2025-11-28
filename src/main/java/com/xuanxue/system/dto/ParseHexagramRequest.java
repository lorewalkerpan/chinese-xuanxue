package com.xuanxue.system.dto;

import java.util.List;

/**
 * 解析卦象请求类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class ParseHexagramRequest {
    
    /**
     * 爻的数值列表（从下到上，6-9）
     * 6=老阴, 7=少阳, 8=少阴, 9=老阳
     */
    private List<Integer> yaoValues;

    public ParseHexagramRequest() {
    }

    /**
     * 构造函数
     * 
     * @param yaoValues 爻的数值列表
     */
    public ParseHexagramRequest(List<Integer> yaoValues) {
        this.yaoValues = yaoValues;
    }

    public List<Integer> getYaoValues() {
        return yaoValues;
    }

    public void setYaoValues(List<Integer> yaoValues) {
        this.yaoValues = yaoValues;
    }
}


