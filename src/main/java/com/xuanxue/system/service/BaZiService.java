package com.xuanxue.system.service;

import com.xuanxue.system.dto.BaZiResponse;
import com.xuanxue.system.enums.DiZhi;
import com.xuanxue.system.enums.TianGan;
import com.xuanxue.system.model.BaZi;
import com.xuanxue.system.model.Pillar;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 八字服务类
 * 负责根据公历日期时间计算生辰八字
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
@Service
public class BaZiService {

    private static final LocalDateTime BASE_DATE = 
        LocalDateTime.of(1900, 1, 31, 0, 0, 0);
    private static final int BASE_YEAR_GAN_ZHI = 16;

    /**
     * 根据公历日期时间计算八字
     * 
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @param minute 分
     * @param second 秒
     * @return 八字响应对象
     */
    public BaZiResponse calculateBaZi(int year, int month, int day,
                                      int hour, int minute, int second) {
        validateDateTime(year, month, day, hour, minute, second);

        LocalDateTime dateTime = 
            LocalDateTime.of(year, month, day, hour, minute, second);

        Pillar yearPillar = calculateYearPillar(year, month);
        Pillar monthPillar = calculateMonthPillar(year, month);
        Pillar dayPillar = calculateDayPillar(dateTime);
        Pillar hourPillar = calculateHourPillar(dayPillar, hour);

        String solarDate = formatSolarDate(year, month, day, hour, minute, second);
        String lunarDate = calculateLunarDate(year, month, day);

        BaZi baZi = new BaZi(yearPillar, monthPillar, dayPillar, 
                             hourPillar, solarDate, lunarDate);

        return buildBaZiResponse(baZi);
    }

    /**
     * 校验日期时间参数
     * 
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @param minute 分
     * @param second 秒
     */
    private void validateDateTime(int year, int month, int day,
                                   int hour, int minute, int second) {
        if (year < 1900 || year > 2100) {
            throw new IllegalArgumentException("年份必须在1900-2100之间");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("月份必须在1-12之间");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("日期必须在1-31之间");
        }
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("小时必须在0-23之间");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("分钟必须在0-59之间");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("秒必须在0-59之间");
        }
    }

    /**
     * 计算年柱
     * 注：立春为界，立春前为上一年
     * 
     * @param year 年
     * @param month 月
     * @return 年柱
     */
    private Pillar calculateYearPillar(int year, int month) {
        int adjustedYear = year;
        if (month <= 2) {
            adjustedYear = year - 1;
        }

        int ganIndex = (adjustedYear - 4) % 10;
        int zhiIndex = (adjustedYear - 4) % 12;

        TianGan gan = TianGan.fromIndex(ganIndex);
        DiZhi zhi = DiZhi.fromIndex(zhiIndex);

        return new Pillar(gan, zhi);
    }

    /**
     * 计算月柱
     * 根据年干和月份计算月柱
     * 
     * @param year 年
     * @param month 月
     * @return 月柱
     */
    private Pillar calculateMonthPillar(int year, int month) {
        int adjustedYear = year;
        if (month <= 2) {
            adjustedYear = year - 1;
        }

        int yearGanIndex = (adjustedYear - 4) % 10;
        int monthZhiIndex = (month + 1) % 12;

        int monthGanIndex = (yearGanIndex * 2 + month) % 10;

        TianGan gan = TianGan.fromIndex(monthGanIndex);
        DiZhi zhi = DiZhi.fromIndex(monthZhiIndex);

        return new Pillar(gan, zhi);
    }

    /**
     * 计算日柱
     * 使用公历基准日期计算
     * 
     * @param dateTime 日期时间
     * @return 日柱
     */
    private Pillar calculateDayPillar(LocalDateTime dateTime) {
        long daysBetween = ChronoUnit.DAYS.between(BASE_DATE, dateTime);

        int ganIndex = (int) ((BASE_YEAR_GAN_ZHI + daysBetween) % 10);
        int zhiIndex = (int) ((BASE_YEAR_GAN_ZHI + daysBetween) % 12);

        if (ganIndex < 0) {
            ganIndex += 10;
        }
        if (zhiIndex < 0) {
            zhiIndex += 12;
        }

        TianGan gan = TianGan.fromIndex(ganIndex);
        DiZhi zhi = DiZhi.fromIndex(zhiIndex);

        return new Pillar(gan, zhi);
    }

    /**
     * 计算时柱
     * 根据日干和时辰计算时柱
     * 
     * @param dayPillar 日柱
     * @param hour 时
     * @return 时柱
     */
    private Pillar calculateHourPillar(Pillar dayPillar, int hour) {
        DiZhi hourZhi = DiZhi.fromHour(hour);

        int dayGanIndex = dayPillar.getTianGan().ordinal();
        int hourZhiIndex = hourZhi.ordinal();

        int hourGanIndex = ((dayGanIndex % 5) * 2 + hourZhiIndex) % 10;

        TianGan gan = TianGan.fromIndex(hourGanIndex);

        return new Pillar(gan, hourZhi);
    }

    /**
     * 格式化公历日期
     * 
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @param minute 分
     * @param second 秒
     * @return 格式化后的日期字符串
     */
    private String formatSolarDate(int year, int month, int day,
                                    int hour, int minute, int second) {
        return String.format("%04d年%02d月%02d日 %02d时%02d分%02d秒",
                year, month, day, hour, minute, second);
    }

    /**
     * 计算农历日期（简化版本）
     * 注：此处返回简化的农历信息，实际应用需要完整的农历转换算法
     * 
     * @param year 年
     * @param month 月
     * @param day 日
     * @return 农历日期字符串
     */
    private String calculateLunarDate(int year, int month, int day) {
        return String.format("农历 %d年", year);
    }

    /**
     * 构建八字响应对象
     * 
     * @param baZi 八字对象
     * @return 八字响应对象
     */
    private BaZiResponse buildBaZiResponse(BaZi baZi) {
        BaZiResponse response = new BaZiResponse();
        response.setBaZi(baZi);
        response.setYearPillar(baZi.getYearPillar().getGanZhi());
        response.setMonthPillar(baZi.getMonthPillar().getGanZhi());
        response.setDayPillar(baZi.getDayPillar().getGanZhi());
        response.setHourPillar(baZi.getHourPillar().getGanZhi());
        response.setBaZiString(baZi.getBaZiString());
        response.setSolarDate(baZi.getSolarDate());
        response.setLunarDate(baZi.getLunarDate());

        BaZiResponse.WuXingInfo wuXingInfo = new BaZiResponse.WuXingInfo();
        wuXingInfo.setYearGanWuXing(
            baZi.getYearPillar().getTianGan().getWuXing());
        wuXingInfo.setYearZhiWuXing(
            baZi.getYearPillar().getDiZhi().getWuXing());
        wuXingInfo.setMonthGanWuXing(
            baZi.getMonthPillar().getTianGan().getWuXing());
        wuXingInfo.setMonthZhiWuXing(
            baZi.getMonthPillar().getDiZhi().getWuXing());
        wuXingInfo.setDayGanWuXing(
            baZi.getDayPillar().getTianGan().getWuXing());
        wuXingInfo.setDayZhiWuXing(
            baZi.getDayPillar().getDiZhi().getWuXing());
        wuXingInfo.setHourGanWuXing(
            baZi.getHourPillar().getTianGan().getWuXing());
        wuXingInfo.setHourZhiWuXing(
            baZi.getHourPillar().getDiZhi().getWuXing());
        response.setWuXingInfo(wuXingInfo);

        return response;
    }
}


