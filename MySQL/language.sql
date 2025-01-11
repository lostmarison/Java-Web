-- 查询所有数据库
show databases;

-- 切换数据库
use db01;

-- 查询当前正在使用的数据库
select database();

-- 创建数据库
create database db02;

-- 删除数据库
drop database db02;


-- ======================================== DDL操作 ========================================

-- 创建表
create table user
(
    id       int comment 'ID,唯一标识',
    username varchar(50) comment '用户名',
    name     varchar(10) comment '姓名',
    age      int comment '年龄',
    gender   char(1) comment '性别'
) comment '用户信息表';

-- 创建表（约束）
create table user
(
    id       int primary key comment 'ID,唯一标识',        -- 主键约束
    username varchar(50) not null unique comment '用户名', -- 非空 唯一
    name     varchar(10) not null comment '姓名',          -- 非空
    age      int comment '年龄',
    gender   char(1) default '男' comment '性别'           -- 默认约束
) comment '用户信息表';

-- 案例：设计员工表
-- 基础字段: id 主键; create_time 创建时间; update_time 修改时间.
create table staff
(
    id          int unsigned primary key auto_increment comment 'ID,主键', -- 自增
    username    varchar(20)      not null unique comment '用户名',         -- 输入框
    name        varchar(10)      not null comment '名字',                  -- 输入框
    password    varchar(32) default 123456 comment '密码',                 -- 密码默认为123456
    gender      tinyint unsigned not null comment '性别, 1 男;2 女',       -- 下拉框
    salary      int unsigned     not null comment '薪资',                  -- 输入框
    entry_data  date comment '入职日期',                                   -- 选填
    image       varchar(255) comment '图像',                               -- 选填，存图像地址
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';

-- 查询当前数据库所有表
show tables;

-- 查看表结构
desc staff;

-- 查询建表语句
show create table staff;

-- 字段: 添加字段 qq varchar(13)
alter table staff
    add qq varchar(13) comment 'QQ号码';

-- 字段: 修改字段类型 qq varchar(15)
alter table staff
    modify qq varchar(15) comment 'QQ号码';

-- 字段: 修改字段名 qq -> qq_number varchar(15)
alter table staff
    change qq qq_number varchar(15) comment 'QQ号码';

-- 字段: 删除字段名 qq_number
alter table staff
    drop column qq_number;

-- 字段: 修改表面
alter table staff rename to employee;


-- ======================================== DML操作 ========================================

-- ===================== 插入数据 - insert =====================

-- 1. 为 staff 表的 username, password, name, gender, phone 字段插入值
-- insert into staff(username, password, name, gender, phone) values ();

-- 2. 为 staff 表的所有字段插入值
insert into staff
values (null, 'zhangsan', '张三','12345678', 1, 6000, '2020-01-01', '1.png', now(), now());

-- 3. 批量为 staff 表的所有字段插入值
insert into staff
values (null, 'lisi', '李四','1234567', 2, 5000, '2020-01-02', '2.png', now(), now()),
       (null, 'wangwu', '王五','123456789', 1, 3000, '2020-01-03', '3.png', now(), now());

-- 更新数据 - update
-- 1. 将 staff 表中 ID 为 1 的员工用户名改为 'ZhangSan',密码改为 '12345'
update staff
set username = 'ZhangSan',
    password = '12345'
where id = 1;

-- 2. 将 staff 表中 ID 所有员工入职日期更新为 '2010-01-02'
-- update staff set entry_data = '2010-01-02';

-- 删除数据 - delete
-- 1. 删除 staff 表中 ID 为 1 的员工
delete
from staff
where id = 1;

-- 2. 删除 staff 表中所有员工信息
-- delete from staff;


-- ======================================== DQL操作 ========================================

-- ===================== 基本查询 =====================

-- 1. 查询指定字段 username, entry-date
select username, entry_data from staff;

-- 2. 查询所有返回字段
-- 方式 1
select id,
       username,
       password,
       gender,
       salary,
       entry_data,
       image,
       create_time,
       update_time
from staff;

-- 方式 2（项目开发中不常用）
select * from staff;

-- 3. 查询所有员工的 username, entry_date, 并起别名（用户名，入职日期）
select username as '用户名', entry_data as '入职日期' from staff; -- as 可以省略

-- 4. 查询已有的员工关联了几种性别（不要重复） - distinct
select distinct gender from staff;

-- ===================== 条件查询 =====================

-- 1. 查询用户名为 lisi 的员工
select * from staff where username = 'lisi';

-- 2. 查询薪资小于等于 5000 的员工
select * from staff where salary <= 5000;

-- 3. 查询用户名为六个字符的员工信息（_ 单个字符; % 任意个字符）
select * from staff where username like '______';

-- 4. 查询姓李的员工
select * from staff where name like '李%';

-- 5. 查询姓名中包含'三'的员工信息
select * from staff where name like '%三%';

-- ===================== 分组查询 =====================

-- 1. 统计该企业员工数量 - count
-- count(字段)
select count(id) from staff;

-- count(*) : 推荐
select count(*) from staff;

-- count(常量) : 推荐
select count(1) from staff;

-- 2. 统计该企业员工的平均薪资 - avg
select avg(salary) from staff;

-- 3. 统计该企业员工的最高薪资 - max
select max(salary) from staff;

-- 4. 统计该企业员工的最低薪资 - min
select min(salary) from staff;

-- 5 统计该企业每月要给员工发放的薪资总数 - sum
select sum(salary) from staff;

-- ===================== 分组 =====================

-- 分组之后,select后的字段表不能随便写,能写的一般是 分组字段 + 聚合函数
-- 1. 根据性别分组。统计男性和女性员工数量
select gender,count(*) from staff group by gender;

-- 2. 先查询入职日期在 '2020-01-02' (包含) 以前的员工，并对结果根据职位分组，获取员工数量大于 2 的职位
-- select job, count(*) from staff where entry_date <= '2020-01-02' group by job having count(*) >= 2;

-- ===================== 排序查询 =====================

-- 1. 根据入职日期，对员工进行升序排序 - asc
select * from staff order by entry_data; -- asc 为默认可以不加

-- 2. 根据入职日期，对员工进行降序排序 - desc
select * from staff order by entry_data desc;

-- 3. 根据入职时间对该企业员工进行升序排序，入职时间相同，再按更新时间降序排序
select * from staff order by entry_data, update_time desc;

-- ===================== 分页查询 limit 起始索引,查询记录数 =====================
    
-- 1. 从起始索引 0 开始查询员工数据，每页展示 5 条记录
select * from staff limit 0,5;

-- 2. 查询第 2 页员工数据，每页展示 5 条记录
select * from staff limit 5,5;

-- 3. 计算页码
-- 每页起始索引 = (页码 - 1) * 每页展示记录数
