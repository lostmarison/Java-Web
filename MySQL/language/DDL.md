# DDL -表结构-查询、修改、删除
|   功能    |     语法    | 
|   :---:   |    :----:   | 
| 查询当前数据库所有表|<font color=blue>show tables<font>;|
| 查询表结构   |desc 表名;|
| 添加字段  |alter table 表名 字段名 类型（长度）[comment 注释][约束];|
| 修改字段类型|alter table 表名 modify 字段名 新数据类型（长度;|
|修改字段名与字段类型|alter table 表名 change 旧字段名 新字段名 类型（长度）[comment 注释][约束];|
|删除字段|alter table 表名 drop coluumn 字段名|
|修改表名|alter table 表名 rename to 新表名|
|删除表|drop table [if exists] 表名|
