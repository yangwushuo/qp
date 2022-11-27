## 文档

### 微服务模块

- qingpu-auth 认证授权模块
- qingpu-gateway 网关模块
- qingpu-common 通用模块
- qingpu-common-service 通用服务模块
- qingpu-user 用户模块
- qingpu-exchange 交易所模块
- qingpu-elasticsearch 搜索引擎模块
- qingpu-binance 币安交易所模块

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
  - 更新手机
  - 更新邮箱
  - 发送验证码到已绑定的邮箱
  - 发送验证码到已绑定的手机
  - 校验密码
  - 用户交易所账号信息
- 通用服务模块
  - 发送手机验证码
  - 发送邮箱验证码
- 交易所模块接口
  - 获取支持的数字货币交易所
  - 获取数字货币交易所账号信息
  - 添加数字货币交易所账号信息
  - 更新数字货币交易所账号信息
  - 删除数字货币交易所账号信息
- 币安模块
  - 订单测试


### 业务逻辑

- 更新手机/邮箱

<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/qRCnWPxh/Snipaste-2022-11-14-16-22-20.png' border='0' alt='image'/></a>

- 绑定手机/邮箱

<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/RVKhghcd/image.png' border='0' alt='image'/></a>