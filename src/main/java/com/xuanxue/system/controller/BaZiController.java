package com.xuanxue.system.controller;

import com.xuanxue.system.dto.ApiResponse;
import com.xuanxue.system.dto.BaZiRequest;
import com.xuanxue.system.dto.BaZiResponse;
import com.xuanxue.system.service.BaZiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 八字控制器
 * 提供生辰八字计算相关接口
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
@Tag(name = "八字计算", description = "生辰八字计算相关接口")
@RestController
@RequestMapping("/api/bazi")
public class BaZiController {

    @Autowired
    private BaZiService baZiService;

    /**
     * 根据公历日期时间计算八字
     * 
     * @param request 请求参数，包含年月日时分秒
     * @return 八字计算结果
     */
    @Operation(summary = "计算八字（POST）", description = "根据公历日期时间计算生辰八字，支持完整的年月日时分秒")
    @PostMapping("/calculate")
    public ApiResponse<BaZiResponse> calculateBaZi(
            @Parameter(description = "八字计算请求参数") @RequestBody BaZiRequest request) {
        try {
            if (request.getYear() == null || request.getMonth() == null 
                || request.getDay() == null) {
                return ApiResponse.error(400, "年月日参数不能为空");
            }

            int hour = request.getHour() != null ? request.getHour() : 0;
            int minute = request.getMinute() != null ? request.getMinute() : 0;
            int second = request.getSecond() != null ? request.getSecond() : 0;

            BaZiResponse response = baZiService.calculateBaZi(
                    request.getYear(), request.getMonth(), request.getDay(),
                    hour, minute, second);

            return ApiResponse.success("八字计算成功", response);
        } catch (IllegalArgumentException e) {
            return ApiResponse.error(400, e.getMessage());
        } catch (Exception e) {
            return ApiResponse.error("八字计算失败：" + e.getMessage());
        }
    }

    /**
     * 根据URL参数计算八字
     * 
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时（可选，默认0）
     * @param minute 分（可选，默认0）
     * @param second 秒（可选，默认0）
     * @return 八字计算结果
     */
    @Operation(summary = "计算八字（GET）", description = "通过URL参数计算生辰八字")
    @GetMapping("/calculate")
    public ApiResponse<BaZiResponse> calculateBaZiByParams(
            @Parameter(description = "年份（1900-2100）", required = true, example = "1990") @RequestParam Integer year,
            @Parameter(description = "月份（1-12）", required = true, example = "5") @RequestParam Integer month,
            @Parameter(description = "日期（1-31）", required = true, example = "15") @RequestParam Integer day,
            @Parameter(description = "小时（0-23）", example = "12") @RequestParam(required = false, defaultValue = "0") Integer hour,
            @Parameter(description = "分钟（0-59）", example = "30") @RequestParam(required = false, defaultValue = "0") Integer minute,
            @Parameter(description = "秒（0-59）", example = "0") @RequestParam(required = false, defaultValue = "0") Integer second) {
        try {
            BaZiResponse response = baZiService.calculateBaZi(
                    year, month, day, hour, minute, second);
            return ApiResponse.success("八字计算成功", response);
        } catch (IllegalArgumentException e) {
            return ApiResponse.error(400, e.getMessage());
        } catch (Exception e) {
            return ApiResponse.error("八字计算失败：" + e.getMessage());
        }
    }

    /**
     * 计算当前时间的八字
     * 
     * @return 八字计算结果
     */
    @Operation(summary = "计算当前时间八字", description = "获取当前系统时间的生辰八字")
    @GetMapping("/now")
    public ApiResponse<BaZiResponse> calculateCurrentBaZi() {
        try {
            LocalDateTime now = LocalDateTime.now();
            BaZiResponse response = baZiService.calculateBaZi(
                    now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                    now.getHour(), now.getMinute(), now.getSecond());
            return ApiResponse.success("当前时间八字计算成功", response);
        } catch (Exception e) {
            return ApiResponse.error("八字计算失败：" + e.getMessage());
        }
    }

    /**
     * 健康检查接口
     * 
     * @return 健康状态
     */
    @Operation(summary = "健康检查", description = "检查八字服务是否正常运行")
    @GetMapping("/health")
    public ApiResponse<String> health() {
        return ApiResponse.success("中国玄学-八字服务运行正常");
    }
}


