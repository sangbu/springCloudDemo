# spring-cloud-parent


数据库：

```sql
DROP TABLE  if EXISTS tb_user;
CREATE TABLE `tb_user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `username` varchar(100) DEFAULT NULL COMMENT '用户名',
 `password` varchar(100) DEFAULT NULL COMMENT '密码',
 `name` varchar(100) DEFAULT NULL COMMENT '姓名',
 `age` int(11) DEFAULT NULL COMMENT '年龄',
 `sex` int(11) DEFAULT NULL COMMENT '性别，1男，2女',
 `birthday` date DEFAULT NULL COMMENT '出生日期',
 `created` date DEFAULT NULL COMMENT '创建时间',
 `updated` date DEFAULT NULL COMMENT '更新时间',
 `note` varchar(1000) DEFAULT NULL COMMENT '备注',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zhangsan', '123456', '张三', '13', '1', '2006-08-01', '2019-05-16', '2019-05-16', '张三');
INSERT INTO `tb_user` VALUES ('2', 'lisi', '123456', '李四', '13', '1', '2006-08-01', '2019-05-16', '2019-05-16', '李四');
-- ----------------------------
-- select tb_user
-- ----------------------------
SELECT * FROM tb_user;
```

