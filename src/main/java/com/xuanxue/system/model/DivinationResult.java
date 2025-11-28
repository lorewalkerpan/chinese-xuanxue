package com.xuanxue.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 占卜结果实体类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class DivinationResult {
    
    /**
     * 占卜时间（东八区时间）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date timestamp;
    
    /**
     * 本卦（当前卦）
     */
    private Hexagram originalHexagram;
    
    /**
     * 变卦（未来卦）
     */
    private Hexagram changedHexagram;
    
    /**
     * 变爻位置列表
     */
    private List<Integer> changingPositions;
    
    /**
     * 占卜解析
     */
    private String interpretation;
    
    /**
     * 本卦卦象图
     */
    private String originalHexagramDiagram;
    
    /**
     * 变卦卦象图
     */
    private String changedHexagramDiagram;

    public DivinationResult() {
        this.timestamp = new Date();
    }

    /**
     * 构造函数
     * 
     * @param originalHexagram 本卦
     * @param changedHexagram 变卦
     * @param changingPositions 变爻位置
     */
    public DivinationResult(Hexagram originalHexagram, Hexagram changedHexagram, 
                           List<Integer> changingPositions) {
        this.timestamp = new Date();
        this.originalHexagram = originalHexagram;
        this.changedHexagram = changedHexagram;
        this.changingPositions = changingPositions;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Hexagram getOriginalHexagram() {
        return originalHexagram;
    }

    public void setOriginalHexagram(Hexagram originalHexagram) {
        this.originalHexagram = originalHexagram;
    }

    public Hexagram getChangedHexagram() {
        return changedHexagram;
    }

    public void setChangedHexagram(Hexagram changedHexagram) {
        this.changedHexagram = changedHexagram;
    }

    public List<Integer> getChangingPositions() {
        return changingPositions;
    }

    public void setChangingPositions(List<Integer> changingPositions) {
        this.changingPositions = changingPositions;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public String getOriginalHexagramDiagram() {
        return originalHexagramDiagram;
    }

    public void setOriginalHexagramDiagram(String originalHexagramDiagram) {
        this.originalHexagramDiagram = originalHexagramDiagram;
    }

    public String getChangedHexagramDiagram() {
        return changedHexagramDiagram;
    }

    public void setChangedHexagramDiagram(String changedHexagramDiagram) {
        this.changedHexagramDiagram = changedHexagramDiagram;
    }
}


