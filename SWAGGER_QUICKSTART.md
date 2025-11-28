# Swagger API文档 - 快速上手

## 🚀 最快方式（推荐）

### Windows 批处理脚本

双击运行：
```
generate-swagger.bat
```

等待30秒后，项目根目录会生成 `swagger.json` 文件。

### PowerShell 脚本

右键以PowerShell运行：
```powershell
.\generate-swagger.ps1
```

---

## 📖 在线查看文档

### 1. 启动应用

```bash
mvn spring-boot:run
```

### 2. 访问Swagger UI

打开浏览器访问：
```
http://localhost:8080/xuanxue/swagger-ui.html
```

![Swagger UI界面](https://via.placeholder.com/800x400?text=Swagger+UI)

---

## 📥 导出API文档

### JSON格式
```
http://localhost:8080/xuanxue/v3/api-docs
```

### YAML格式
```
http://localhost:8080/xuanxue/v3/api-docs.yaml
```

### 使用浏览器下载
1. 访问上述URL
2. 右键 -> 另存为
3. 保存为 `swagger.json` 或 `swagger.yaml`

### 使用curl下载
```bash
# JSON格式
curl http://localhost:8080/xuanxue/v3/api-docs > swagger.json

# YAML格式
curl http://localhost:8080/xuanxue/v3/api-docs.yaml > swagger.yaml
```

---

## 🧪 在Swagger UI中测试API

### 示例：测试八字计算接口

1. 访问 Swagger UI
2. 找到 **"八字计算"** 标签
3. 点击 **"POST /api/bazi/calculate"**
4. 点击 **"Try it out"** 按钮
5. 输入测试数据：

```json
{
  "year": 1990,
  "month": 5,
  "day": 15,
  "hour": 12,
  "minute": 30,
  "second": 0
}
```

6. 点击 **"Execute"** 执行
7. 查看返回结果

---

## 📦 导入到API工具

### Postman

1. 打开 Postman
2. 点击 **"Import"**
3. 选择 **"Link"** 标签
4. 输入：`http://localhost:8080/xuanxue/v3/api-docs`
5. 点击 **"Continue"**

### Apifox

1. 打开 Apifox
2. 项目设置 -> **导入数据**
3. 选择 **"URL导入"**
4. 输入：`http://localhost:8080/xuanxue/v3/api-docs`
5. 点击 **导入**

---

## ❓ 常见问题

### Q: 访问Swagger UI显示404？

**A**: 确保访问地址包含 `/xuanxue` 前缀：
```
✅ http://localhost:8080/xuanxue/swagger-ui.html
❌ http://localhost:8080/swagger-ui.html
```

### Q: 如何关闭Swagger？

**A**: 在 `application.yml` 中添加：
```yaml
springdoc:
  swagger-ui:
    enabled: false
  api-docs:
    enabled: false
```

### Q: 端口被占用怎么办？

**A**: 修改 `application.yml` 中的端口：
```yaml
server:
  port: 8081  # 改为其他端口
```

---

## 📚 完整文档

详细使用说明请查看：[SWAGGER_GUIDE.md](SWAGGER_GUIDE.md)

---

**提示**: 首次使用请先运行 `mvn clean package` 编译项目。

