package com.xuanxue.system.controller;

import com.xuanxue.system.dto.ApiResponse;
import com.xuanxue.system.dto.ParseHexagramRequest;
import com.xuanxue.system.model.DivinationResult;
import com.xuanxue.system.service.DivinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 六爻占卜控制器
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
@Tag(name = "六爻占卜", description = "六爻卦象生成和解析接口")
@RestController
@RequestMapping("/api/divination")
public class DivinationController {
    
    @Autowired
    private DivinationService divinationService;

    /**
     * 生成卦象（随机）
     * 
     * @return 占卜结果
     */
    @Operation(summary = "随机生成卦象", description = "使用当前时间戳作为种子随机生成六爻卦象")
    @GetMapping("/generate")
    public ApiResponse<DivinationResult> generateHexagram() {
        try {
            DivinationResult result = divinationService.generateHexagram();
            return ApiResponse.success("卦象生成成功", result);
        } catch (Exception e) {
            return ApiResponse.error("生成卦象失败：" + e.getMessage());
        }
    }

    /**
     * 生成卦象（指定种子）
     * 
     * @param seed 随机种子
     * @return 占卜结果
     */
    @Operation(summary = "指定种子生成卦象", description = "使用指定的随机种子生成六爻卦象，相同种子生成相同卦象")
    @GetMapping("/generate/{seed}")
    public ApiResponse<DivinationResult> generateHexagramWithSeed(
            @Parameter(description = "随机种子", required = true, example = "123456789") @PathVariable Long seed) {
        try {
            DivinationResult result = divinationService.generateHexagram(seed);
            return ApiResponse.success("卦象生成成功", result);
        } catch (Exception e) {
            return ApiResponse.error("生成卦象失败：" + e.getMessage());
        }
    }

    /**
     * 解析卦象
     * 
     * @param request 解析请求（包含爻的数值列表）
     * @return 占卜结果
     */
    @Operation(summary = "解析卦象", description = "根据提供的爻值列表解析卦象，爻值范围6-9（6=老阴,7=少阳,8=少阴,9=老阳）")
    @PostMapping("/parse")
    public ApiResponse<DivinationResult> parseHexagram(
            @Parameter(description = "解析卦象请求，包含6个爻的数值") @RequestBody ParseHexagramRequest request) {
        try {
            DivinationResult result = 
                divinationService.parseHexagram(request.getYaoValues());
            return ApiResponse.success("卦象解析成功", result);
        } catch (IllegalArgumentException e) {
            return ApiResponse.error(400, e.getMessage());
        } catch (Exception e) {
            return ApiResponse.error("解析卦象失败：" + e.getMessage());
        }
    }

    /**
     * 获取卦象详细信息
     * 
     * @param seed 随机种子
     * @return 占卜结果及解析
     */
    @Operation(summary = "获取卦象详情", description = "根据种子获取卦象的详细信息和解析")
    @GetMapping("/details/{seed}")
    public ApiResponse<DivinationResult> getHexagramDetails(
            @Parameter(description = "随机种子", required = true, example = "987654321") @PathVariable Long seed) {
        try {
            DivinationResult result = divinationService.generateHexagram(seed);
            return ApiResponse.success("获取卦象详情成功", result);
        } catch (Exception e) {
            return ApiResponse.error("获取卦象详情失败：" + e.getMessage());
        }
    }

    /**
     * 健康检查接口
     * 
     * @return 健康状态
     */
    @Operation(summary = "健康检查", description = "检查六爻占卜服务是否正常运行")
    @GetMapping("/health")
    public ApiResponse<String> health() {
        return ApiResponse.success("中国玄学-六爻占卜服务运行正常");
    }
}


