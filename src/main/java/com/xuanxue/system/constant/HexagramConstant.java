package com.xuanxue.system.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 六十四卦常量类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
public class HexagramConstant {
    
    /**
     * 六十四卦信息映射表
     * key为上卦和下卦的组合（上卦名_下卦名）
     */
    public static final Map<String, HexagramInfo> HEXAGRAM_MAP = new HashMap<>();

    static {
        HEXAGRAM_MAP.put("乾_乾", new HexagramInfo("乾为天", "元亨，利贞。", "天行健，君子以自强不息。"));
        HEXAGRAM_MAP.put("乾_兑", new HexagramInfo("天泽履", "履虎尾，不咥人，亨。", "上天下泽，履；君子以辨上下，定民志。"));
        HEXAGRAM_MAP.put("乾_离", new HexagramInfo("天火同人", "同人于野，亨。利涉大川，利君子贞。", "天与火，同人；君子以类族辨物。"));
        HEXAGRAM_MAP.put("乾_震", new HexagramInfo("天雷无妄", "无妄，元亨利贞。其匪正有眚，不利有攸往。", "天下雷行，物与无妄；先王以茂对时，育万物。"));
        HEXAGRAM_MAP.put("乾_巽", new HexagramInfo("天风姤", "姤，女壮，勿用取女。", "天下有风，姤；后以施命诰四方。"));
        HEXAGRAM_MAP.put("乾_坎", new HexagramInfo("天水讼", "讼，有孚，窒惕，中吉，终凶。利见大人，不利涉大川。", "天与水违行，讼；君子以作事谋始。"));
        HEXAGRAM_MAP.put("乾_艮", new HexagramInfo("天山遁", "遁，亨，小利贞。", "天下有山，遁；君子以远小人，不恶而严。"));
        HEXAGRAM_MAP.put("乾_坤", new HexagramInfo("天地否", "否之匪人，不利君子贞，大往小来。", "天地不交，否；君子以俭德辟难，不可荣以禄。"));
        
        HEXAGRAM_MAP.put("兑_乾", new HexagramInfo("泽天夬", "夬，扬于王庭，孚号有厉。告自邑，不利即戎，利有攸往。", "泽上于天，夬；君子以施禄及下，居德则忌。"));
        HEXAGRAM_MAP.put("兑_兑", new HexagramInfo("兑为泽", "兑，亨，利贞。", "丽泽，兑；君子以朋友讲习。"));
        HEXAGRAM_MAP.put("兑_离", new HexagramInfo("泽火革", "革，己日乃孚，元亨利贞，悔亡。", "泽中有火，革；君子以治历明时。"));
        HEXAGRAM_MAP.put("兑_震", new HexagramInfo("泽雷随", "随，元亨利贞，无咎。", "泽中有雷，随；君子以向晦入宴息。"));
        HEXAGRAM_MAP.put("兑_巽", new HexagramInfo("泽风大过", "大过，栋桡，利有攸往，亨。", "泽灭木，大过；君子以独立不惧，遁世无闷。"));
        HEXAGRAM_MAP.put("兑_坎", new HexagramInfo("泽水困", "困，亨，贞，大人吉，无咎，有言不信。", "泽无水，困；君子以致命遂志。"));
        HEXAGRAM_MAP.put("兑_艮", new HexagramInfo("泽山咸", "咸，亨，利贞，取女吉。", "山上有泽，咸；君子以虚受人。"));
        HEXAGRAM_MAP.put("兑_坤", new HexagramInfo("泽地萃", "萃，亨。王假有庙，利见大人，亨，利贞。用大牲吉，利有攸往。", "泽上于地，萃；君子以除戎器，戒不虞。"));
        
        HEXAGRAM_MAP.put("离_乾", new HexagramInfo("火天大有", "大有，元亨。", "火在天上，大有；君子以遏恶扬善，顺天休命。"));
        HEXAGRAM_MAP.put("离_兑", new HexagramInfo("火泽睽", "睽，小事吉。", "上火下泽，睽；君子以同而异。"));
        HEXAGRAM_MAP.put("离_离", new HexagramInfo("离为火", "离，利贞，亨。畜牝牛，吉。", "明两作，离；大人以继明照于四方。"));
        HEXAGRAM_MAP.put("离_震", new HexagramInfo("火雷噬嗑", "噬嗑，亨。利用狱。", "雷电，噬嗑；先王以明罚敕法。"));
        HEXAGRAM_MAP.put("离_巽", new HexagramInfo("火风鼎", "鼎，元吉，亨。", "木上有火，鼎；君子以正位凝命。"));
        HEXAGRAM_MAP.put("离_坎", new HexagramInfo("火水未济", "未济，亨，小狐汔济，濡其尾，无攸利。", "火在水上，未济；君子以慎辨物居方。"));
        HEXAGRAM_MAP.put("离_艮", new HexagramInfo("火山旅", "旅，小亨，旅贞吉。", "山上有火，旅；君子以明慎用刑，而不留狱。"));
        HEXAGRAM_MAP.put("离_坤", new HexagramInfo("火地晋", "晋，康侯用锡马蕃庶，昼日三接。", "明出地上，晋；君子以自昭明德。"));
        
        HEXAGRAM_MAP.put("震_乾", new HexagramInfo("雷天大壮", "大壮，利贞。", "雷在天上，大壮；君子以非礼弗履。"));
        HEXAGRAM_MAP.put("震_兑", new HexagramInfo("雷泽归妹", "归妹，征凶，无攸利。", "泽上有雷，归妹；君子以永终知敝。"));
        HEXAGRAM_MAP.put("震_离", new HexagramInfo("雷火丰", "丰，亨。王假之，勿忧，宜日中。", "雷电皆至，丰；君子以折狱致刑。"));
        HEXAGRAM_MAP.put("震_震", new HexagramInfo("震为雷", "震，亨。震来虩虩，笑言哑哑，震惊百里，不丧匕鬯。", "洊雷，震；君子以恐惧修省。"));
        HEXAGRAM_MAP.put("震_巽", new HexagramInfo("雷风恒", "恒，亨，无咎，利贞，利有攸往。", "雷风，恒；君子以立不易方。"));
        HEXAGRAM_MAP.put("震_坎", new HexagramInfo("雷水解", "解，利西南，无所往，其来复吉。有攸往，夙吉。", "雷雨作，解；君子以赦过宥罪。"));
        HEXAGRAM_MAP.put("震_艮", new HexagramInfo("雷山小过", "小过，亨，利贞，可小事，不可大事。飞鸟遗之音，不宜上，宜下，大吉。", "山上有雷，小过；君子以行过乎恭，丧过乎哀，用过乎俭。"));
        HEXAGRAM_MAP.put("震_坤", new HexagramInfo("雷地豫", "豫，利建侯行师。", "雷出地奋，豫；先王以作乐崇德，殷荐之上帝，以配祖考。"));
        
        HEXAGRAM_MAP.put("巽_乾", new HexagramInfo("风天小畜", "小畜，亨。密云不雨，自我西郊。", "风行天上，小畜；君子以懿文德。"));
        HEXAGRAM_MAP.put("巽_兑", new HexagramInfo("风泽中孚", "中孚，豚鱼吉，利涉大川，利贞。", "泽上有风，中孚；君子以议狱缓死。"));
        HEXAGRAM_MAP.put("巽_离", new HexagramInfo("风火家人", "家人，利女贞。", "风自火出，家人；君子以言有物而行有恒。"));
        HEXAGRAM_MAP.put("巽_震", new HexagramInfo("风雷益", "益，利有攸往，利涉大川。", "风雷，益；君子以见善则迁，有过则改。"));
        HEXAGRAM_MAP.put("巽_巽", new HexagramInfo("巽为风", "巽，小亨，利有攸往，利见大人。", "随风，巽；君子以申命行事。"));
        HEXAGRAM_MAP.put("巽_坎", new HexagramInfo("风水涣", "涣，亨。王假有庙，利涉大川，利贞。", "风行水上，涣；先王以享于帝立庙。"));
        HEXAGRAM_MAP.put("巽_艮", new HexagramInfo("风山渐", "渐，女归吉，利贞。", "山上有木，渐；君子以居贤德善俗。"));
        HEXAGRAM_MAP.put("巽_坤", new HexagramInfo("风地观", "观，盥而不荐，有孚颙若。", "风行地上，观；先王以省方观民设教。"));
        
        HEXAGRAM_MAP.put("坎_乾", new HexagramInfo("水天需", "需，有孚，光亨，贞吉。利涉大川。", "云上于天，需；君子以饮食宴乐。"));
        HEXAGRAM_MAP.put("坎_兑", new HexagramInfo("水泽节", "节，亨。苦节不可贞。", "泽上有水，节；君子以制数度，议德行。"));
        HEXAGRAM_MAP.put("坎_离", new HexagramInfo("水火既济", "既济，亨，小利贞，初吉终乱。", "水在火上，既济；君子以思患而豫防之。"));
        HEXAGRAM_MAP.put("坎_震", new HexagramInfo("水雷屯", "屯，元亨利贞。勿用有攸往，利建侯。", "云雷，屯；君子以经纶。"));
        HEXAGRAM_MAP.put("坎_巽", new HexagramInfo("水风井", "井，改邑不改井，无丧无得，往来井井。汔至，亦未繘井，羸其瓶，凶。", "木上有水，井；君子以劳民劝相。"));
        HEXAGRAM_MAP.put("坎_坎", new HexagramInfo("坎为水", "习坎，有孚，维心亨，行有尚。", "水洊至，习坎；君子以常德行，习教事。"));
        HEXAGRAM_MAP.put("坎_艮", new HexagramInfo("水山蹇", "蹇，利西南，不利东北；利见大人，贞吉。", "山上有水，蹇；君子以反身修德。"));
        HEXAGRAM_MAP.put("坎_坤", new HexagramInfo("水地比", "比，吉。原筮，元永贞，无咎。不宁方来，后夫凶。", "地上有水，比；先王以建万国，亲诸侯。"));
        
        HEXAGRAM_MAP.put("艮_乾", new HexagramInfo("山天大畜", "大畜，利贞，不家食吉，利涉大川。", "天在山中，大畜；君子以多识前言往行，以畜其德。"));
        HEXAGRAM_MAP.put("艮_兑", new HexagramInfo("山泽损", "损，有孚，元吉，无咎，可贞，利有攸往。曷之用？二簋可用享。", "山下有泽，损；君子以惩忿窒欲。"));
        HEXAGRAM_MAP.put("艮_离", new HexagramInfo("山火贲", "贲，亨。小利有攸往。", "山下有火，贲；君子以明庶政，无敢折狱。"));
        HEXAGRAM_MAP.put("艮_震", new HexagramInfo("山雷颐", "颐，贞吉。观颐，自求口实。", "山下有雷，颐；君子以慎言语，节饮食。"));
        HEXAGRAM_MAP.put("艮_巽", new HexagramInfo("山风蛊", "蛊，元亨，利涉大川。先甲三日，后甲三日。", "山下有风，蛊；君子以振民育德。"));
        HEXAGRAM_MAP.put("艮_坎", new HexagramInfo("山水蒙", "蒙，亨。匪我求童蒙，童蒙求我。初筮告，再三渎，渎则不告。利贞。", "山下出泉，蒙；君子以果行育德。"));
        HEXAGRAM_MAP.put("艮_艮", new HexagramInfo("艮为山", "艮，艮其背，不获其身，行其庭，不见其人，无咎。", "兼山，艮；君子以思不出其位。"));
        HEXAGRAM_MAP.put("艮_坤", new HexagramInfo("山地剥", "剥，不利有攸往。", "山附于地，剥；上以厚下安宅。"));
        
        HEXAGRAM_MAP.put("坤_乾", new HexagramInfo("地天泰", "泰，小往大来，吉亨。", "天地交，泰；后以财成天地之道，辅相天地之宜，以左右民。"));
        HEXAGRAM_MAP.put("坤_兑", new HexagramInfo("地泽临", "临，元亨利贞。至于八月有凶。", "泽上有地，临；君子以教思无穷，容保民无疆。"));
        HEXAGRAM_MAP.put("坤_离", new HexagramInfo("地火明夷", "明夷，利艰贞。", "明入地中，明夷；君子以莅众，用晦而明。"));
        HEXAGRAM_MAP.put("坤_震", new HexagramInfo("地雷复", "复，亨。出入无疾，朋来无咎。反复其道，七日来复，利有攸往。", "雷在地中，复；先王以至日闭关，商旅不行，后不省方。"));
        HEXAGRAM_MAP.put("坤_巽", new HexagramInfo("地风升", "升，元亨，用见大人，勿恤，南征吉。", "地中生木，升；君子以顺德，积小以高大。"));
        HEXAGRAM_MAP.put("坤_坎", new HexagramInfo("地水师", "师，贞，丈人吉，无咎。", "地中有水，师；君子以容民畜众。"));
        HEXAGRAM_MAP.put("坤_艮", new HexagramInfo("地山谦", "谦，亨，君子有终。", "地中有山，谦；君子以裒多益寡，称物平施。"));
        HEXAGRAM_MAP.put("坤_坤", new HexagramInfo("坤为地", "坤，元亨，利牝马之贞。君子有攸往，先迷后得主，利西南得朋，东北丧朋。安贞吉。", "地势坤，君子以厚德载物。"));
    }

    /**
     * 六十四卦信息内部类
     */
    public static class HexagramInfo {
        private String name;
        private String judgement;
        private String image;

        /**
         * 构造函数
         * 
         * @param name 卦名
         * @param judgement 卦辞
         * @param image 象辞
         */
        public HexagramInfo(String name, String judgement, String image) {
            this.name = name;
            this.judgement = judgement;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getJudgement() {
            return judgement;
        }

        public String getImage() {
            return image;
        }
    }

    /**
     * 根据上下卦获取卦象信息
     * 
     * @param upperTrigramName 上卦名称
     * @param lowerTrigramName 下卦名称
     * @return 卦象信息
     */
    public static HexagramInfo getHexagramInfo(String upperTrigramName, String lowerTrigramName) {
        String key = upperTrigramName + "_" + lowerTrigramName;
        return HEXAGRAM_MAP.get(key);
    }
}

