# 中国玄学系统

基于Spring Boot的中国传统玄学系统，提供六爻占卜和生辰八字计算等功能。

## 项目简介

本项目实现了中国古代传统的命理功能，包括：

### 六爻占卜模块
- 自动生成卦象（使用三枚铜钱法）
- **可视化卦象图**（文本图形展示）
- 解析卦象信息
- 提供详细的卦辞、象辞解释
- 支持变卦分析
- 动爻标识和变卦对比

### 生辰八字模块 🆕
- 根据公历日期时间计算生辰八字
- 自动计算年柱、月柱、日柱、时柱
- 提供天干地支详细信息
- 五行属性分析
- 支持历史和当前时间计算

## 技术栈

- JDK 1.8
- Spring Boot 2.3.12.RELEASE
- Maven

## 项目结构

```
chinese-xuanxue/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/xuanxue/system/      # Java包名已更新
│   │   │       ├── controller/          # 控制层
│   │   │       ├── service/             # 服务层
│   │   │       ├── model/               # 实体类
│   │   │       ├── enums/               # 枚举类
│   │   │       ├── dto/                 # 数据传输对象
│   │   │       ├── constant/            # 常量类
│   │   │       └── ChineseXuanxueApplication.java
│   │   └── resources/
│   │       └── application.yml          # 配置文件
│   └── test/
│       └── java/
├── pom.xml
├── README.md
├── API_TEST_EXAMPLES.md         # 六爻API测试示例
├── BAZI_API_TEST_EXAMPLES.md    # 八字API测试示例 🆕
└── HEXAGRAM_DIAGRAM_GUIDE.md    # 卦象图说明文档
```

## 快速开始

### 1. 环境要求

- JDK 1.8+
- Maven 3.x+

### 2. 编译项目

```cmd
mvn clean package
```

### 3. 运行项目

```cmd
mvn spring-boot:run
```

或者运行编译后的jar包：

```cmd
java -jar target/chinese-xuanxue-1.0.0.jar
```

### 4. 访问应用

应用启动后，默认访问地址为：
- 基础路径：http://localhost:8080/xuanxue
- 六爻占卜健康检查：http://localhost:8080/xuanxue/api/divination/health
- 八字服务健康检查：http://localhost:8080/xuanxue/api/bazi/health 🆕

## API接口文档

## 一、六爻占卜接口

### 1. 生成卦象（随机）

**接口地址：** `GET /api/divination/generate`

**描述：** 使用当前时间戳作为种子，随机生成一个六爻卦象。

**响应示例：**
```json
{
  "code": 200,
  "message": "卦象生成成功",
  "data": {
    "timestamp": "2025-11-27T08:00:00.000+00:00",
    "originalHexagram": {
      "name": "乾为天",
      "upperTrigram": "乾",
      "lowerTrigram": "乾",
      "judgement": "元亨，利贞。",
      "image": "天行健，君子以自强不息。"
    },
    "changedHexagram": null,
    "changingPositions": [],
    "interpretation": "【本卦】乾为天\n...",
    "originalHexagramDiagram": "┌─────────────────────────┐\n│   乾为天   │\n├─────────────────────────┤\n│ ━━━━━  第6爻：少阳 │\n│ ━━━━━  第5爻：少阳 │\n│ ━━━━━  第4爻：少阳 │\n├─ 上卦：☰ 乾（天） ─┤\n│ ━━━━━  第3爻：少阳 │\n│ ━━━━━  第2爻：少阳 │\n│ ━━━━━  第1爻：少阳 │\n├─ 下卦：☰ 乾（天） ─┤\n└─────────────────────────┘",
    "changedHexagramDiagram": null
  }
}
```

**卦象图展示：**
```
┌─────────────────────────┐
│   乾为天   │
├─────────────────────────┤
│ ━━━━━  第6爻：少阳 │
│ ━━━━━  第5爻：少阳 │
│ ━━━━━  第4爻：少阳 │
├─ 上卦：☰ 乾（天） ─┤
│ ━━━━━  第3爻：少阳 │
│ ━━━━━  第2爻：少阳 │
│ ━━━━━  第1爻：少阳 │
├─ 下卦：☰ 乾（天） ─┤
└─────────────────────────┘
```

> 📊 **新功能**：现在API会返回美观的卦象图，清晰展示每一爻的状态和动爻标记（★）。详见 [卦象图说明文档](HEXAGRAM_DIAGRAM_GUIDE.md)

### 2. 生成卦象（指定种子）

**接口地址：** `GET /api/divination/generate/{seed}`

**描述：** 使用指定的种子生成卦象，相同种子产生相同结果。

**路径参数：**
- `seed`：随机种子（Long类型）

**示例：** `GET /api/divination/generate/123456789`

### 3. 解析卦象

**接口地址：** `POST /api/divination/parse`

**描述：** 根据提供的爻值解析卦象。

**请求体：**
```json
{
  "yaoValues": [7, 8, 9, 6, 7, 8]
}
```

**参数说明：**
- `yaoValues`：6个爻的数值（从下到上），取值范围6-9
  - 6 = 老阴（阴爻，会变）
  - 7 = 少阳（阳爻，不变）
  - 8 = 少阴（阴爻，不变）
  - 9 = 老阳（阳爻，会变）

### 4. 获取卦象详情

**接口地址：** `GET /api/divination/details/{seed}`

**描述：** 根据种子获取卦象的详细信息和解析。

**路径参数：**
- `seed`：随机种子（Long类型）

### 5. 健康检查

**接口地址：** `GET /api/divination/health`

**描述：** 检查服务运行状态。

---

## 二、生辰八字接口 🆕

### 1. 计算指定日期时间的八字（POST方式）

**接口地址：** `POST /api/bazi/calculate`

**描述：** 根据公历日期时间计算生辰八字。

**请求体：**
```json
{
  "year": 1990,
  "month": 5,
  "day": 15,
  "hour": 14,
  "minute": 30,
  "second": 0
}
```

**响应示例：**
```json
{
  "code": 200,
  "message": "八字计算成功",
  "data": {
    "yearPillar": "庚午",
    "monthPillar": "辛巳",
    "dayPillar": "甲子",
    "hourPillar": "辛未",
    "baZiString": "庚午 辛巳 甲子 辛未",
    "solarDate": "1990年05月15日 14时30分00秒",
    "lunarDate": "农历 1990年",
    "wuXingInfo": {
      "yearGanWuXing": "金",
      "yearZhiWuXing": "火",
      "monthGanWuXing": "金",
      "monthZhiWuXing": "火",
      "dayGanWuXing": "木",
      "dayZhiWuXing": "水",
      "hourGanWuXing": "金",
      "hourZhiWuXing": "土"
    }
  }
}
```

### 2. 计算指定日期时间的八字（GET方式）

**接口地址：** `GET /api/bazi/calculate`

**描述：** 使用URL参数计算八字。

**请求参数：**
- `year`：年份（必填，1900-2100）
- `month`：月份（必填，1-12）
- `day`：日期（必填，1-31）
- `hour`：小时（可选，默认0，0-23）
- `minute`：分钟（可选，默认0，0-59）
- `second`：秒（可选，默认0，0-59）

**示例：** `GET /api/bazi/calculate?year=1990&month=5&day=15&hour=14&minute=30&second=0`

### 3. 计算当前时间的八字

**接口地址：** `GET /api/bazi/now`

**描述：** 自动使用服务器当前时间计算八字。

**示例：** `GET /api/bazi/now`

### 4. 健康检查

**接口地址：** `GET /api/bazi/health`

**描述：** 检查八字服务运行状态。

## 卦象图说明

### 🎨 可视化卦象图

系统自动生成的卦象图格式：

```
┌─────────────────────────┐
│   火雷噬嗑   │          ← 卦名
├─────────────────────────┤
│ ━  ━  第6爻：老阳 ★动爻 │  ← 动爻标记
│ ━  ━  第5爻：少阴 │
│ ━━━━━  第4爻：少阳 │
├─ 上卦：☲ 离（火） ─┤    ← 上卦信息
│ ━━━━━  第3爻：少阳 │
│ ━  ━  第2爻：少阴 │
│ ━  ━  第1爻：老阴 ★动爻 │
├─ 下卦：☳ 震（雷） ─┤    ← 下卦信息
└─────────────────────────┘
```

**图形说明**：
- `━━━━━` = 阳爻（实线）
- `━  ━` = 阴爻（断线）
- `★动爻` = 会发生变化的爻（老阳或老阴）
- 从下往上读（第1爻在最底部）

> 📖 详细说明请查看：[卦象图说明文档](HEXAGRAM_DIAGRAM_GUIDE.md)

---

## 八字基础知识 🆕

### 天干
- 甲（木阳）、乙（木阴）
- 丙（火阳）、丁（火阴）
- 戊（土阳）、己（土阴）
- 庚（金阳）、辛（金阴）
- 壬（水阳）、癸（水阴）

### 地支
- 子（鼠、水阳）、丑（牛、土阴）、寅（虎、木阳）、卯（兔、木阴）
- 辰（龙、土阳）、巳（蛇、火阴）、午（马、火阳）、未（羊、土阴）
- 申（猴、金阳）、酉（鸡、金阴）、戌（狗、土阳）、亥（猪、水阴）

### 四柱
- **年柱**：代表祖上、父母、长辈，以及命主的童年和少年运
- **月柱**：代表兄弟姐妹、父母，以及命主的青年运
- **日柱**：代表自己和配偶，是八字的核心，日干代表命主自己
- **时柱**：代表子女、下属，以及命主的晚年运

### 五行
- **木**：春天，东方，生发之气
- **火**：夏天，南方，炎热之气
- **土**：四季月，中央，稳重之气
- **金**：秋天，西方，收敛之气
- **水**：冬天，北方，寒冷之气

---

## 六爻基础知识

### 八卦

- 乾（☰）：天
- 兑（☱）：泽
- 离（☲）：火
- 震（☳）：雷
- 巽（☴）：风
- 坎（☵）：水
- 艮（☶）：山
- 坤（☷）：地

### 爻的类型

- 老阳（9）：阳爻，会变为阴爻
- 少阳（7）：阳爻，不变
- 老阴（6）：阴爻，会变为阳爻
- 少阴（8）：阴爻，不变

### 六十四卦

由两个八卦（上卦和下卦）组成，共有64种组合，每种组合对应一个卦象，配有卦辞和象辞。

## 测试示例

### 使用curl测试（六爻占卜）

```cmd
# 生成随机卦象
curl http://localhost:8080/xuanxue/api/divination/generate

# 使用指定种子生成
curl http://localhost:8080/xuanxue/api/divination/generate/12345

# 解析卦象
curl -X POST http://localhost:8080/xuanxue/api/divination/parse ^
  -H "Content-Type: application/json" ^
  -d "{\"yaoValues\":[7,8,9,6,7,8]}"
```

### 使用curl测试（生辰八字）🆕

```cmd
# 计算指定日期八字
curl -X POST http://localhost:8080/xuanxue/api/bazi/calculate ^
  -H "Content-Type: application/json" ^
  -d "{\"year\":1990,\"month\":5,\"day\":15,\"hour\":14,\"minute\":30,\"second\":0}"

# 使用GET方式计算
curl "http://localhost:8080/xuanxue/api/bazi/calculate?year=1990&month=5&day=15&hour=14"

# 计算当前时间八字
curl http://localhost:8080/xuanxue/api/bazi/now
```

### 使用Postman测试

1. 导入以下接口：
   - GET http://localhost:8080/xuanxue/api/divination/generate
   - GET http://localhost:8080/xuanxue/api/divination/generate/12345
   - POST http://localhost:8080/xuanxue/api/divination/parse

2. 对于POST请求，在Body中选择raw和JSON格式，输入：
```json
{
  "yaoValues": [7, 8, 9, 6, 7, 8]
}
```

## 详细文档

- [六爻API测试文档](API_TEST_EXAMPLES.md)
- [八字API测试文档](BAZI_API_TEST_EXAMPLES.md) 🆕
- [卦象图说明文档](HEXAGRAM_DIAGRAM_GUIDE.md)
- [项目名称变更说明](项目名称变更说明.md) ⚠️
- [快速参考-URL变更](快速参考-URL变更.md) 📌
- [包名重构完成说明](包名重构完成说明.md) ✅

## 项目命名说明

✅ **完整重构完成**: 
- 项目名称: **"中国玄学系统"** (chinese-xuanxue)
- URL上下文路径: `/xuanxue`
- Java包路径: `com.xuanxue.system` ✅ 已完成重构
- 启动类: `ChineseXuanxueApplication` ✅ 已重命名

详细的变更说明请查看: [项目名称变更说明.md](项目名称变更说明.md)

## 注意事项

1. 本项目仅用于学习和研究中国传统文化，不构成任何决策建议。
2. 占卜和八字结果仅供参考，请理性对待。
3. 项目中的卦辞和象辞来源于《周易》原文。
4. 八字计算基于公历转换，月柱计算以节气为准（简化算法）。

## 作者

wbguan2

## 许可证

本项目仅供学习交流使用。

