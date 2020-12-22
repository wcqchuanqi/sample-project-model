-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `user_name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名称',
  `role_id` varchar(32) NOT NULL DEFAULT '' COMMENT '角色id',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `modify_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_logic` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ;

-- ----------------------------
--  Table structure for `vm_extend_info`
-- ----------------------------
DROP TABLE IF EXISTS `vm_extend_info`;
CREATE TABLE `vm_extend_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `vm_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'vm id',
  `extend_info_01` varchar(64) NOT NULL DEFAULT '' COMMENT 'vm扩展信息01',
  `extend_info_02` varchar(64) NOT NULL DEFAULT '' COMMENT 'vm扩展信息02',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `modify_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_logic` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
)  ;

-- ----------------------------
--  Table structure for `vm_info`
-- ----------------------------
DROP TABLE IF EXISTS `vm_info`;
CREATE TABLE `vm_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `vm_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'vm id',
  `vm_name` varchar(64) NOT NULL DEFAULT '' COMMENT 'vm名称',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `modify_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_logic` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
)  ;