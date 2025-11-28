package com.xuanxue.system.service;

import com.xuanxue.system.constant.HexagramConstant;
import com.xuanxue.system.enums.YaoType;
import com.xuanxue.system.model.DivinationResult;
import com.xuanxue.system.model.Hexagram;
import com.xuanxue.system.model.Yao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 六爻占卜服务类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
@Service
public class DivinationService {
    
    private final Random random = new Random();

    /**
     * 生成卦象（使用时间戳作为随机种子）
     * 
     * @return 占卜结果
     */
    public DivinationResult generateHexagram() {
        long timestamp = System.currentTimeMillis();
        return generateHexagram(timestamp);
    }

    /**
     * 生成卦象（使用指定种子）
     * 
     * @param seed 随机种子
     * @return 占卜结果
     */
    public DivinationResult generateHexagram(long seed) {
        Random seededRandom = new Random(seed);
        
        List<Yao> yaos = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            YaoType type = generateYao(seededRandom);
            yaos.add(new Yao(i, type));
        }
        
        Hexagram originalHexagram = new Hexagram(yaos);
        enrichHexagramInfo(originalHexagram);
        
        Hexagram changedHexagram = originalHexagram.getChangedHexagram();
        if (changedHexagram != null) {
            enrichHexagramInfo(changedHexagram);
        }
        
        List<Integer> changingPositions = originalHexagram.getChangingPositions();
        
        DivinationResult result = new DivinationResult(
            originalHexagram, 
            changedHexagram, 
            changingPositions
        );
        
        result.setInterpretation(generateInterpretation(result));
        result.setOriginalHexagramDiagram(originalHexagram.generateHexagramDiagram());
        
        if (changedHexagram != null) {
            result.setChangedHexagramDiagram(changedHexagram.generateHexagramDiagram());
        }
        
        return result;
    }

    /**
     * 使用三枚铜钱法生成一个爻
     * 
     * @param rand 随机数生成器
     * @return 爻的类型
     */
    private YaoType generateYao(Random rand) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += rand.nextBoolean() ? 3 : 2;
        }
        return YaoType.fromValue(sum);
    }

    /**
     * 补充卦象的详细信息
     * 
     * @param hexagram 卦象
     */
    private void enrichHexagramInfo(Hexagram hexagram) {
        if (hexagram == null) {
            return;
        }
        
        String upperName = hexagram.getUpperTrigram().getName();
        String lowerName = hexagram.getLowerTrigram().getName();
        
        HexagramConstant.HexagramInfo info = 
            HexagramConstant.getHexagramInfo(upperName, lowerName);
        
        if (info != null) {
            hexagram.setName(info.getName());
            hexagram.setJudgement(info.getJudgement());
            hexagram.setImage(info.getImage());
        }
    }

    /**
     * 生成占卜解析
     * 
     * @param result 占卜结果
     * @return 解析文本
     */
    private String generateInterpretation(DivinationResult result) {
        StringBuilder interpretation = new StringBuilder();
        
        Hexagram original = result.getOriginalHexagram();
        interpretation.append("【本卦】").append(original.getName()).append("\n");
        interpretation.append("上卦：").append(original.getUpperTrigram().getName());
        interpretation.append("（").append(original.getUpperTrigram().getNature()).append("）\n");
        interpretation.append("下卦：").append(original.getLowerTrigram().getName());
        interpretation.append("（").append(original.getLowerTrigram().getNature()).append("）\n\n");
        
        interpretation.append("【卦辞】\n");
        interpretation.append(original.getJudgement()).append("\n\n");
        
        interpretation.append("【象辞】\n");
        interpretation.append(original.getImage()).append("\n\n");
        
        List<Integer> changingPos = result.getChangingPositions();
        if (!changingPos.isEmpty()) {
            interpretation.append("【变爻】\n");
            for (Integer pos : changingPos) {
                interpretation.append("第").append(pos).append("爻动变\n");
            }
            interpretation.append("\n");
            
            Hexagram changed = result.getChangedHexagram();
            if (changed != null) {
                interpretation.append("【变卦】").append(changed.getName()).append("\n");
                interpretation.append("卦辞：").append(changed.getJudgement()).append("\n");
            }
        } else {
            interpretation.append("【无变爻】\n");
            interpretation.append("此卦静止，以本卦卦辞断之。\n");
        }
        
        return interpretation.toString();
    }

    /**
     * 解析卦象（根据爻的类型列表）
     * 
     * @param yaoValues 爻的数值列表（6,7,8,9）
     * @return 占卜结果
     */
    public DivinationResult parseHexagram(List<Integer> yaoValues) {
        if (yaoValues == null || yaoValues.size() != 6) {
            throw new IllegalArgumentException("必须提供6个爻的数值");
        }
        
        List<Yao> yaos = new ArrayList<>();
        for (int i = 0; i < yaoValues.size(); i++) {
            Integer value = yaoValues.get(i);
            if (value < 6 || value > 9) {
                throw new IllegalArgumentException("爻的数值必须在6-9之间");
            }
            YaoType type = YaoType.fromValue(value);
            yaos.add(new Yao(i + 1, type));
        }
        
        Hexagram originalHexagram = new Hexagram(yaos);
        enrichHexagramInfo(originalHexagram);
        
        Hexagram changedHexagram = originalHexagram.getChangedHexagram();
        if (changedHexagram != null) {
            enrichHexagramInfo(changedHexagram);
        }
        
        List<Integer> changingPositions = originalHexagram.getChangingPositions();
        
        DivinationResult result = new DivinationResult(
            originalHexagram, 
            changedHexagram, 
            changingPositions
        );
        
        result.setInterpretation(generateInterpretation(result));
        result.setOriginalHexagramDiagram(originalHexagram.generateHexagramDiagram());
        
        if (changedHexagram != null) {
            result.setChangedHexagramDiagram(changedHexagram.generateHexagramDiagram());
        }
        
        return result;
    }
}


