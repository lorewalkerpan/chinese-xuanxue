package com.xuanxue.system.model;

import com.xuanxue.system.enums.Trigram;
import com.xuanxue.system.enums.YaoType;

import java.util.ArrayList;
import java.util.List;

/**
 * 六十四卦实体类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class Hexagram {
    
    /**
     * 六个爻（从下到上）
     */
    private List<Yao> yaos;
    
    /**
     * 卦名
     */
    private String name;
    
    /**
     * 上卦（外卦）
     */
    private Trigram upperTrigram;
    
    /**
     * 下卦（内卦）
     */
    private Trigram lowerTrigram;
    
    /**
     * 卦辞
     */
    private String judgement;
    
    /**
     * 卦象
     */
    private String image;

    public Hexagram() {
        this.yaos = new ArrayList<>();
    }

    /**
     * 构造函数
     * 
     * @param yaos 六个爻的列表
     */
    public Hexagram(List<Yao> yaos) {
        this.yaos = yaos;
        analyzeTrigrams();
    }

    /**
     * 分析上下卦
     */
    private void analyzeTrigrams() {
        if (yaos == null || yaos.size() != 6) {
            return;
        }
        
        StringBuilder lowerBinary = new StringBuilder();
        StringBuilder upperBinary = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            lowerBinary.append(yaos.get(i).getType().isYang() ? "1" : "0");
        }
        
        for (int i = 3; i < 6; i++) {
            upperBinary.append(yaos.get(i).getType().isYang() ? "1" : "0");
        }
        
        this.lowerTrigram = Trigram.fromBinary(lowerBinary.toString());
        this.upperTrigram = Trigram.fromBinary(upperBinary.toString());
    }

    /**
     * 获取变卦
     * 
     * @return 变卦，如果没有变爻则返回null
     */
    public Hexagram getChangedHexagram() {
        boolean hasChanging = yaos.stream().anyMatch(yao -> yao.getType().isChanging());
        if (!hasChanging) {
            return null;
        }
        
        List<Yao> changedYaos = new ArrayList<>();
        for (int i = 0; i < yaos.size(); i++) {
            Yao originalYao = yaos.get(i);
            YaoType changedType = originalYao.getChangedType();
            changedYaos.add(new Yao(i + 1, changedType));
        }
        
        return new Hexagram(changedYaos);
    }

    /**
     * 获取变爻列表
     * 
     * @return 变爻位置列表
     */
    public List<Integer> getChangingPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Yao yao : yaos) {
            if (yao.getType().isChanging()) {
                positions.add(yao.getPosition());
            }
        }
        return positions;
    }

    public List<Yao> getYaos() {
        return yaos;
    }

    public void setYaos(List<Yao> yaos) {
        this.yaos = yaos;
        analyzeTrigrams();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trigram getUpperTrigram() {
        return upperTrigram;
    }

    public void setUpperTrigram(Trigram upperTrigram) {
        this.upperTrigram = upperTrigram;
    }

    public Trigram getLowerTrigram() {
        return lowerTrigram;
    }

    public void setLowerTrigram(Trigram lowerTrigram) {
        this.lowerTrigram = lowerTrigram;
    }

    public String getJudgement() {
        return judgement;
    }

    public void setJudgement(String judgement) {
        this.judgement = judgement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 生成卦象图（文本可视化）
     * 
     * @return 卦象图形字符串
     */
    public String generateHexagramDiagram() {
        if (yaos == null || yaos.size() != 6) {
            return "";
        }
        
        StringBuilder diagram = new StringBuilder();
        
        diagram.append("┌─────────────────────────┐\n");
        diagram.append("│   ").append(name != null ? name : "未知卦")
               .append("   │\n");
        diagram.append("├─────────────────────────┤\n");
        
        for (int i = yaos.size() - 1; i >= 0; i--) {
            Yao yao = yaos.get(i);
            
            if (i == 2) {
                diagram.append("├─ 上卦：")
                       .append(upperTrigram.getSymbol()).append(" ")
                       .append(upperTrigram.getName()).append("（")
                       .append(upperTrigram.getNature()).append("）")
                       .append(" ─┤\n");
            }
            
            diagram.append("│ ");
            
            String yaoLine;
            if (yao.getType().isYang()) {
                yaoLine = "━━━━━";
            } else {
                yaoLine = "━  ━";
            }
            
            diagram.append(yaoLine).append("  ");
            
            String position = "第" + yao.getPosition() + "爻";
            diagram.append(position).append("：");
            diagram.append(yao.getType().getName());
            
            if (yao.getType().isChanging()) {
                diagram.append(" ★动爻");
            }
            
            diagram.append(" │\n");
            
            if (i == 3) {
                diagram.append("├─ 下卦：")
                       .append(lowerTrigram.getSymbol()).append(" ")
                       .append(lowerTrigram.getName()).append("（")
                       .append(lowerTrigram.getNature()).append("）")
                       .append(" ─┤\n");
            }
        }
        
        diagram.append("└─────────────────────────┘");
        
        return diagram.toString();
    }

    /**
     * 生成简化卦象图
     * 
     * @return 简化的卦象图形
     */
    public String generateSimpleDiagram() {
        if (yaos == null || yaos.size() != 6) {
            return "";
        }
        
        StringBuilder diagram = new StringBuilder();
        
        for (int i = yaos.size() - 1; i >= 0; i--) {
            Yao yao = yaos.get(i);
            
            String yaoLine;
            if (yao.getType().isYang()) {
                yaoLine = "━━━━━";
            } else {
                yaoLine = "━  ━";
            }
            
            diagram.append(yaoLine);
            
            if (yao.getType().isChanging()) {
                diagram.append(" ○");
            }
            
            diagram.append("\n");
        }
        
        return diagram.toString().trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("卦名: ").append(name).append("\n");
        sb.append("上卦: ").append(upperTrigram.getName()).append("(").append(upperTrigram.getNature()).append(")\n");
        sb.append("下卦: ").append(lowerTrigram.getName()).append("(").append(lowerTrigram.getNature()).append(")\n");
        sb.append("卦象: \n");
        for (int i = yaos.size() - 1; i >= 0; i--) {
            Yao yao = yaos.get(i);
            sb.append("  ").append(yao.getType().getSymbol()).append(" ");
            sb.append(yao.getType().getName());
            if (yao.getType().isChanging()) {
                sb.append(" (变)");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


