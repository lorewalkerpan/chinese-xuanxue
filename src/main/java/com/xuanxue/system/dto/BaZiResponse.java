package com.xuanxue.system.dto;

import com.xuanxue.system.model.BaZi;

/**
 * 八字计算响应
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class BaZiResponse {
    
    private BaZi baZi;
    private String yearPillar;
    private String monthPillar;
    private String dayPillar;
    private String hourPillar;
    private String baZiString;
    private String solarDate;
    private String lunarDate;
    private WuXingInfo wuXingInfo;

    /**
     * 五行信息
     */
    public static class WuXingInfo {
        private String yearGanWuXing;
        private String yearZhiWuXing;
        private String monthGanWuXing;
        private String monthZhiWuXing;
        private String dayGanWuXing;
        private String dayZhiWuXing;
        private String hourGanWuXing;
        private String hourZhiWuXing;

        public String getYearGanWuXing() {
            return yearGanWuXing;
        }

        public void setYearGanWuXing(String yearGanWuXing) {
            this.yearGanWuXing = yearGanWuXing;
        }

        public String getYearZhiWuXing() {
            return yearZhiWuXing;
        }

        public void setYearZhiWuXing(String yearZhiWuXing) {
            this.yearZhiWuXing = yearZhiWuXing;
        }

        public String getMonthGanWuXing() {
            return monthGanWuXing;
        }

        public void setMonthGanWuXing(String monthGanWuXing) {
            this.monthGanWuXing = monthGanWuXing;
        }

        public String getMonthZhiWuXing() {
            return monthZhiWuXing;
        }

        public void setMonthZhiWuXing(String monthZhiWuXing) {
            this.monthZhiWuXing = monthZhiWuXing;
        }

        public String getDayGanWuXing() {
            return dayGanWuXing;
        }

        public void setDayGanWuXing(String dayGanWuXing) {
            this.dayGanWuXing = dayGanWuXing;
        }

        public String getDayZhiWuXing() {
            return dayZhiWuXing;
        }

        public void setDayZhiWuXing(String dayZhiWuXing) {
            this.dayZhiWuXing = dayZhiWuXing;
        }

        public String getHourGanWuXing() {
            return hourGanWuXing;
        }

        public void setHourGanWuXing(String hourGanWuXing) {
            this.hourGanWuXing = hourGanWuXing;
        }

        public String getHourZhiWuXing() {
            return hourZhiWuXing;
        }

        public void setHourZhiWuXing(String hourZhiWuXing) {
            this.hourZhiWuXing = hourZhiWuXing;
        }
    }

    public BaZi getBaZi() {
        return baZi;
    }

    public void setBaZi(BaZi baZi) {
        this.baZi = baZi;
    }

    public String getYearPillar() {
        return yearPillar;
    }

    public void setYearPillar(String yearPillar) {
        this.yearPillar = yearPillar;
    }

    public String getMonthPillar() {
        return monthPillar;
    }

    public void setMonthPillar(String monthPillar) {
        this.monthPillar = monthPillar;
    }

    public String getDayPillar() {
        return dayPillar;
    }

    public void setDayPillar(String dayPillar) {
        this.dayPillar = dayPillar;
    }

    public String getHourPillar() {
        return hourPillar;
    }

    public void setHourPillar(String hourPillar) {
        this.hourPillar = hourPillar;
    }

    public String getBaZiString() {
        return baZiString;
    }

    public void setBaZiString(String baZiString) {
        this.baZiString = baZiString;
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

    public WuXingInfo getWuXingInfo() {
        return wuXingInfo;
    }

    public void setWuXingInfo(WuXingInfo wuXingInfo) {
        this.wuXingInfo = wuXingInfo;
    }
}


