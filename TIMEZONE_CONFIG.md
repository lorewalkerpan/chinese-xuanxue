# 时区配置说明

## 概述

本项目已配置为使用**东八区（Asia/Shanghai）**作为默认时区，确保所有时间相关的接口响应都使用北京时间。

## 配置内容

### 1. 应用启动时设置时区

**文件**: `ChineseXuanxueApplication.java`

```java
@PostConstruct
public void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
}

public static void main(String[] args) {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    SpringApplication.run(ChineseXuanxueApplication.class, args);
}
```

**作用**: 
- 设置JVM的默认时区为东八区
- 确保所有 `new Date()` 创建的时间对象都使用北京时间

### 2. Spring Jackson时区配置

**文件**: `application.yml`

```yaml
spring:
  jackson:
    time-zone: Asia/Shanghai
    date-format: yyyy-MM-dd HH:mm:ss
```

**作用**:
- 配置Jackson序列化时使用东八区时间
- 设置日期格式为 `yyyy-MM-dd HH:mm:ss`

### 3. Jackson配置类

**文件**: `JacksonConfig.java`

```java
@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
}
```

**作用**:
- 全局配置ObjectMapper使用东八区
- 日期序列化为可读字符串格式，而非时间戳

### 4. 字段级注解

**文件**: `DivinationResult.java`

```java
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
private Date timestamp;
```

**作用**:
- 在字段级别指定时区和格式
- 双重保险，确保该字段始终使用东八区

## 时区生效范围

### ✅ 已配置时区的地方

1. **DivinationResult.timestamp** - 占卜结果时间戳
   - 响应格式: `"timestamp": "2025-11-27 14:30:00"`
   - 时区: Asia/Shanghai

2. **所有Date类型字段** - 通过全局配置
   - 任何返回Date类型的字段都会使用东八区
   - 格式统一为: `yyyy-MM-dd HH:mm:ss`

3. **BaZiService中的时间计算** - 使用系统时区
   - `LocalDateTime.now()` 会使用JVM默认时区（东八区）
   - 八字计算时的节气判断等会使用正确的北京时间

## 验证方法

### 1. 启动应用后调用接口

```bash
# 生成卦象
curl http://localhost:8080/xuanxue/api/divination/generate

# 响应示例
{
  "code": 200,
  "message": "卦象生成成功",
  "data": {
    "timestamp": "2025-11-27 14:30:00",  # 东八区时间
    "originalHexagram": {...},
    ...
  }
}
```

### 2. 对比系统时间

- 确保响应中的 `timestamp` 与北京时间一致
- 可以与手机、电脑的时钟对比

### 3. 跨时区测试

如果服务器部署在其他时区（如UTC），接口响应仍会显示东八区时间：

```
服务器时区: UTC (2025-11-27 06:30:00)
响应时间: Asia/Shanghai (2025-11-27 14:30:00)  ✅ 正确
```

## 常见问题

### Q1: 为什么要配置多处时区？

**A**: 多层配置确保时区设置的完整性：
- **JVM层**: 影响所有Java时间API
- **Spring层**: 影响Spring MVC的时间处理
- **Jackson层**: 影响JSON序列化
- **字段层**: 特定字段的精确控制

### Q2: 如果需要其他时区怎么办？

**A**: 修改以下位置的 `Asia/Shanghai` 为目标时区：
1. `ChineseXuanxueApplication.java` - JVM时区
2. `application.yml` - Spring Jackson时区
3. `JacksonConfig.java` - ObjectMapper时区
4. `DivinationResult.java` - 字段注解时区

常用时区：
- 东八区（北京）: `Asia/Shanghai`
- UTC: `UTC`
- 东京: `Asia/Tokyo`
- 纽约: `America/New_York`

### Q3: 时区配置会影响数据库吗？

**A**: 本配置主要影响应用层和API响应：
- ✅ 影响: JSON序列化、API响应格式
- ❌ 不影响: 数据库存储（如果使用数据库，需单独配置）

### Q4: LocalDateTime 和 Date 有什么区别？

**A**: 
- **Date**: 包含时区信息，受JVM时区影响
- **LocalDateTime**: 不包含时区信息，是"本地"时间

本项目主要使用 `Date` 和 `LocalDateTime`：
- 时间戳响应使用 `Date`（会序列化为指定时区）
- 八字计算使用 `LocalDateTime`（内部逻辑计算）

## 测试建议

### 1. 单元测试

```java
@Test
public void testTimezone() {
    DivinationResult result = new DivinationResult();
    Date timestamp = result.getTimestamp();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    
    String formattedTime = sdf.format(timestamp);
    System.out.println("东八区时间: " + formattedTime);
}
```

### 2. 集成测试

```bash
# 调用接口并验证时间格式
curl http://localhost:8080/xuanxue/api/divination/generate | jq '.data.timestamp'

# 期望输出格式: "2025-11-27 14:30:00"
```

## 注意事项

1. **服务器时区**: 即使服务器使用其他时区，API响应仍会返回东八区时间
2. **客户端显示**: 客户端接收到的是格式化的字符串，不需要做时区转换
3. **日志时间**: 应用日志也会使用东八区时间
4. **定时任务**: 如使用定时任务，也会按东八区执行

## 相关文件

- `ChineseXuanxueApplication.java` - 应用启动类
- `JacksonConfig.java` - Jackson配置类
- `DivinationResult.java` - 占卜结果实体
- `application.yml` - Spring配置文件

---

**配置人**: wbguan2  
**配置日期**: 2025-11-27  
**时区**: Asia/Shanghai (UTC+8)

