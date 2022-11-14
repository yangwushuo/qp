## 文档

### 微服务模块

- qingpu-auth 认证授权模块
- qingpu-gateway 网关模块
- qingpu-common 通用模块
- qingpu-common-service 通用服务模块
- qingpu-user 用户模块
- qingpu-exchange 交易所模块
- qingpu-elasticsearch 搜索引擎模块

### 接口划分

- 认证授权模块接口
  - 获取token
  - 刷新token
  - 获取令牌
  - 手机验证码
  - 邮箱验证码
- 用户模块接口
  - 用户信息
  - 更新用户信息
  - 更新头像
  - 创建账户
  - 关注用户
  - 获取关注列表
  - 取消关注
  - 更新手机号
  - 更新邮箱
- 通用服务模块
  - 发送手机验证码
  - 发送邮箱验证码

### 业务逻辑

- 更新手机/邮箱

  ![](https://i.postimg.cc/qRCnWPxh/Snipaste-2022-11-14-16-22-20.png)