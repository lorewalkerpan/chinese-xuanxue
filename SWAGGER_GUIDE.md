# Swagger API文档使用指南

## 概述

本项目已集成 SpringDoc OpenAPI 3.0，提供完整的 API 文档和在线测试功能。

## 快速开始

### 方式一：使用自动化脚本生成（推荐）

1. 运行脚本：
   ```bash
   generate-swagger.bat
   ```

2. 脚本会自动完成以下操作：
   - 编译项目
   - 启动应用
   - 下载 Swagger JSON 文档到项目根目录
   - 提示访问在线文档地址

3. 生成的文件：
   - `swagger.json` - OpenAPI 3.0 规范的 JSON 文件

### 方式二：手动启动应用访问

1. 启动应用：
   ```bash
   mvn spring-boot:run
   ```

2. 访问在线文档：
   - **Swagger UI**: http://localhost:8080/xuanxue/swagger-ui.html
   - **OpenAPI JSON**: http://localhost:8080/xuanxue/v3/api-docs
   - **OpenAPI YAML**: http://localhost:8080/xuanxue/v3/api-docs.yaml

### 方式三：使用Maven插件生成

1. 启动应用（在另一个终端）：
   ```bash
   mvn spring-boot:run
   ```

2. 在新终端运行Maven插件：
   ```bash
   mvn verify
   ```

3. 生成的文件位置：
   - `target/openapi.json`

## API文档说明

### 八字计算接口

**标签**: 八字计算

| 接口 | 方法 | 路径 | 说明 |
|------|------|------|------|
| 计算八字（POST） | POST | /api/bazi/calculate | 通过JSON请求体计算八字 |
| 计算八字（GET） | GET | /api/bazi/calculate | 通过URL参数计算八字 |
| 当前时间八字 | GET | /api/bazi/now | 获取当前时间的八字 |
| 健康检查 | GET | /api/bazi/health | 检查服务状态 |

**示例请求**:
```json
POST /xuanxue/api/bazi/calculate
{
  "year": 1990,
  "month": 5,
  "day": 15,
  "hour": 12,
  "minute": 30,
  "second": 0
}
```

### 六爻占卜接口

**标签**: 六爻占卜

| 接口 | 方法 | 路径 | 说明 |
|------|------|------|------|
| 随机生成卦象 | GET | /api/divination/generate | 使用时间戳生成随机卦象 |
| 指定种子生成 | GET | /api/divination/generate/{seed} | 使用指定种子生成卦象 |
| 解析卦象 | POST | /api/divination/parse | 根据爻值解析卦象 |
| 获取卦象详情 | GET | /api/divination/details/{seed} | 获取详细信息 |
| 健康检查 | GET | /api/divination/health | 检查服务状态 |

**示例请求**:
```json
POST /xuanxue/api/divination/parse
{
  "yaoValues": [6, 7, 8, 9, 7, 8]
}
```

## Swagger UI 功能

### 1. 查看API文档
- 浏览器访问 Swagger UI 地址
- 查看所有可用的 API 接口
- 查看请求参数、响应格式、状态码等详细信息

### 2. 在线测试
- 点击接口展开详情
- 点击 "Try it out" 按钮
- 输入参数
- 点击 "Execute" 执行请求
- 查看响应结果

### 3. 导出文档
- 通过访问 `/v3/api-docs` 获取 JSON 格式
- 通过访问 `/v3/api-docs.yaml` 获取 YAML 格式
- 将文档导入 Postman、Apifox 等工具

## 配置说明

### application.yml 配置

```yaml
springdoc:
  api-docs:
    enabled: true              # 启用API文档
    path: /v3/api-docs         # API文档路径
  swagger-ui:
    enabled: true              # 启用Swagger UI
    path: /swagger-ui.html     # Swagger UI路径
    operationsSorter: method   # 按方法排序
    tagsSorter: alpha          # 按标签字母排序
```

### 关键依赖

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.13</version>
</dependency>
```

## 常见问题

### Q1: 无法访问 Swagger UI？
**A**: 检查以下几点：
- 应用是否正常启动
- 端口 8080 是否被占用
- 访问地址是否包含 context-path: `/xuanxue`
- 正确地址: http://localhost:8080/xuanxue/swagger-ui.html

### Q2: 如何修改API文档信息？
**A**: 编辑 `OpenApiConfig.java` 文件：
```java
.info(new Info()
    .title("你的API标题")
    .description("你的API描述")
    .version("你的版本号")
    ...
)
```

### Q3: 如何添加接口认证？
**A**: 在 `OpenApiConfig.java` 中添加：
```java
.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
.components(new Components()
    .addSecuritySchemes("bearerAuth",
        new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")))
```

### Q4: 生成的swagger.json文件在哪里？
**A**: 
- 使用 `generate-swagger.bat` 脚本：项目根目录的 `swagger.json`
- 使用 Maven 插件：`target/openapi.json`
- 手动下载：访问 http://localhost:8080/xuanxue/v3/api-docs

## 扩展使用

### 导入到 Postman
1. 打开 Postman
2. 点击 "Import"
3. 选择 "Link" 标签
4. 输入: http://localhost:8080/xuanxue/v3/api-docs
5. 点击 "Continue" 完成导入

### 导入到 Apifox
1. 打开 Apifox
2. 选择项目 -> 导入数据
3. 选择 "OpenAPI/Swagger"
4. 导入方式选择 "URL导入"
5. 输入: http://localhost:8080/xuanxue/v3/api-docs
6. 点击导入

## 注意事项

1. **环境要求**：JDK 8+, Maven 3.5+
2. **端口占用**：确保 8080 端口未被占用
3. **Context Path**：访问路径需包含 `/xuanxue` 前缀
4. **生产环境**：建议在生产环境关闭 Swagger UI，通过配置 `springdoc.swagger-ui.enabled=false`

## 相关链接

- [SpringDoc 官方文档](https://springdoc.org/)
- [OpenAPI 规范](https://swagger.io/specification/)
- [Swagger UI 文档](https://swagger.io/tools/swagger-ui/)

---

**创建人**: wbguan2  
**创建日期**: 2025-11-27  
**版本**: 1.0.0

