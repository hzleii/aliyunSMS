> springboot + mybaits + oracle + reids

### 主要功能

1，用户登录，验证手机短信验证码

2，用户注册，验证手机短信验证码，

### 准备

1. 开发工具：idea
2. 数据库：oracle
3. 短信验证码服务：阿里云短信管理控制台
4. 托管平台：github



### 数据库的设计

#### 1. 员工表 staff

| 字段名        | 字段类型     | 说明              |
| ------------- | ------------ | ----------------- |
| id            | number       | 员工 id           |
| tel           | varchar2(11) | 员工手机号        |
| password      | varchar2(6)  | 员工密码          |
| department_id | number       | 员工对应部门的 id |



#### 2. 部门表 department

| 字段名 | 字段类型     | 说明     |
| ------ | ------------ | -------- |
| id     | number       | 部门 id  |
| name   | varchar2(20) | 部门名称 |

> 代码示例：

```mysql
# 创建员工表
create table staff(id number primary key, tel varchar2(11), password varchar2(6), department_id number);
# 创建部门表
create table department(id number, name varchar2(20));
# 创建序列
create sequence seq_staff_id increment by 1 start with 1 maxvalue 999999;
create sequence seq_department_id increment by 1 start with 1 maxvalue 999999;
# 添加默认数据
insert into staff values(seq_staff_id.nextval, '98765432111', '123456', 1);
insert into department values(seq_department_id.nextval, 'boss');
```




## 将验证码存入redis缓存中

```java
// 用到了一个操作redis数据的一个类
@Autowired
private StringRedisTemplate stringRedisTemplate
// 添加验证码,60秒后失效
stringRedisTemplate.opsForValue().set("code", "code", 60, TimeUnit.SECONDS);
// 根据key获取过期时间
System.out.println(stringRedisTemplate.getExpire("code"))
```

