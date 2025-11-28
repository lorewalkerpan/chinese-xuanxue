package com.xuanxue.system.model;

import com.xuanxue.system.enums.DiZhi;
import com.xuanxue.system.enums.TianGan;

/**
 * 柱（年柱、月柱、日柱、时柱）
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class Pillar {
    
    private TianGan tianGan;
    private DiZhi diZhi;
    private String ganZhi;

    /**
     * 构造函数
     * 
     * @param tianGan 天干
     * @param diZhi 地支
     */
    public Pillar(TianGan tianGan, DiZhi diZhi) {
        this.tianGan = tianGan;
        this.diZhi = diZhi;
        this.ganZhi = tianGan.getName() + diZhi.getName();
    }

    public TianGan getTianGan() {
        return tianGan;
    }

    public void setTianGan(TianGan tianGan) {
        this.tianGan = tianGan;
        this.ganZhi = tianGan.getName() + diZhi.getName();
    }

    public DiZhi getDiZhi() {
        return diZhi;
    }

    public void setDiZhi(DiZhi diZhi) {
        this.diZhi = diZhi;
        this.ganZhi = tianGan.getName() + diZhi.getName();
    }

    public String getGanZhi() {
        return ganZhi;
    }

    @Override
    public String toString() {
        return ganZhi;
    }
}


