-- DDL语句
-- ================== DDL-数据库操作 ================== 
-- 1. 查询所有数据库
show databases ; 

-- 2. 查询当前数据库
select database() ;

-- 3. 创建数据库
create database [if not exists] 数据库名 [default charset 字符集] [collate 排序规则] ;
create database [if not exists] 数据库名

-- 4. 删除数据库
drop database [if exists] 数据库名 ;

-- 5. 使用数据库
use  数据库名;


-- ================== DDL-表操作-查询 ================== 
-- 1. 查询当前数据库所有表
show tables;

-- 2. 查看指定表结构
desc 表名;

-- 3. 查询指定表的建表语句
show create table 表名 ; 

-- 4. 创建表结构
create table 表名(
   字段1 字段1类型 [comment 字段1注释 ],
   字段2 字段2类型 [comment 字段2注释 ],
   字段3 字段3类型 [comment 字段3注释 ],
   ......
   字段n 字段n类型 [comment 字段n注释 ]
) [comment 表注释 ] ;


================== DDL-表操作-数据类型 ================== 
-- 常用数据类型
-- int, tinyint(unsigned)
-- char(长度), varchar(长度)
-- datatime
   
================== DDL-表操作-修改 ================== 
-- 1. 添加字段
alter 表名 字段名 类型 (长度) [comment 注释] [约束]; 

-- 2. 修改数据类型
alter table 表名 modify 字段名 新数据类型 (长度); 1
alter table 表名 change 旧字段名 新字段名 类型 (长度) [comment 注释] [约束];

-- 3. 删除字段
alter 表名 drop 字段名;

-- 4. 修改表名
alter table 表名 rename to 新表名;

-- 5. 删除表
drop table [ if exists ] 表名; 

-- 6. 删除指定表 并重新创建表
truncate table 表名;
