package com.xuanxue.system.model;

/**
 * 八字模型
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class BaZi {
    
    private Pillar yearPillar;
    private Pillar monthPillar;
    private Pillar dayPillar;
    private Pillar hourPillar;
    private String solarDate;
    private String lunarDate;
    private String baZiString;

    /**
     * 构造函数
     * 
     * @param yearPillar 年柱
     * @param monthPillar 月柱
     * @param dayPillar 日柱
     * @param hourPillar 时柱
     * @param solarDate 公历日期时间
     * @param lunarDate 农历日期
     */
    public BaZi(Pillar yearPillar, Pillar monthPillar, 
                Pillar dayPillar, Pillar hourPillar,
                String solarDate, String lunarDate) {
        this.yearPillar = yearPillar;
        this.monthPillar = monthPillar;
        this.dayPillar = dayPillar;
        this.hourPillar = hourPillar;
        this.solarDate = solarDate;
        this.lunarDate = lunarDate;
        this.baZiString = String.format("%s %s %s %s",
                yearPillar.getGanZhi(),
                monthPillar.getGanZhi(),
                dayPillar.getGanZhi(),
                hourPillar.getGanZhi());
    }

    public Pillar getYearPillar() {
        return yearPillar;
    }

    public void setYearPillar(Pillar yearPillar) {
        this.yearPillar = yearPillar;
        updateBaZiString();
    }

    public Pillar getMonthPillar() {
        return monthPillar;
    }

    public void setMonthPillar(Pillar monthPillar) {
        this.monthPillar = monthPillar;
        updateBaZiString();
    }

    public Pillar getDayPillar() {
        return dayPillar;
    }

    public void setDayPillar(Pillar dayPillar) {
        this.dayPillar = dayPillar;
        updateBaZiString();
    }

    public Pillar getHourPillar() {
        return hourPillar;
    }

    public void setHourPillar(Pillar hourPillar) {
        this.hourPillar = hourPillar;
        updateBaZiString();
    }

    public String getSolarDate() {
        return solarDate;
    }

    public void setSolarDate(String solarDate) {
        this.solarDate = solarDate;
    }

    public String getLunarDate() {
        return lunarDate;
    }

    public void setLunarDate(String lunarDate) {
        this.lunarDate = lunarDate;
    }

    public String getBaZiString() {
        return baZiString;
    }

    /**
     * 更新八字字符串
     */
    private void updateBaZiString() {
        this.baZiString = String.format("%s %s %s %s",
                yearPillar.getGanZhi(),
                monthPillar.getGanZhi(),
                dayPillar.getGanZhi(),
                hourPillar.getGanZhi());
    }

    @Override
    public String toString() {
        return baZiString;
    }
}


