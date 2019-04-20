-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES ('1', '莲池区', '5', '2019-04-12 11:27:30', '2019-04-12 11:27:33');
INSERT INTO `tb_area` VALUES ('2', '竞秀区', '4', '2019-04-12 11:27:36', '2019-04-12 11:27:39');
INSERT INTO `tb_area` VALUES ('3', '满城区', '3', '2019-04-14 19:14:41', '2019-04-14 19:14:43');
INSERT INTO `tb_area` VALUES ('4', '清苑区', '2', '2019-04-14 19:15:36', '2019-04-14 19:15:38');
INSERT INTO `tb_area` VALUES ('5', '徐水区', '1', '2019-04-14 19:15:56', '2019-04-14 19:15:59');
-- ----------------------------
-- Records of tb_head_line
-- ----------------------------
INSERT INTO `tb_head_line` VALUES ('1', 'demo1', '#', '\\upload\\headtitle\\2017061320315746624.jpg', '4', '1', '2019-04-12 10:43:29', '2019-04-12 10:43:33');
INSERT INTO `tb_head_line` VALUES ('2', 'demo2', '#', '\\upload\\headtitle\\2017061320371786788.jpg', '3', '1', '2019-04-12 11:10:54', '2019-04-12 11:10:56');
INSERT INTO `tb_head_line` VALUES ('3', 'demo3', '#', '\\upload\\headtitle\\2017061320393452772.jpg', '2', '1', '2019-04-12 11:11:50', '2019-04-12 11:11:53');
INSERT INTO `tb_head_line` VALUES ('4', 'demo4', '#', '\\upload\\headtitle\\2017061320400198256.jpg', '1', '1', '2019-04-12 11:12:27', '2019-04-12 11:12:29');
-- ----------------------------
-- Records of tb_person_info
-- ----------------------------
INSERT INTO `tb_person_info` VALUES ('2', '2', '1', '2019-04-12 13:13:50', '2019-04-12 13:13:53', '', '');
INSERT INTO `tb_person_info` VALUES ('3', '1', '2', '2019-04-15 13:13:52', '2019-04-15 13:26:15', 'xuyiqing', '2s0bb5qsye622b6lb5ele656ll0e2529');
-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('1', '斗破苍穹', '天蚕土豆写的', '\\upload\\item\\shop\\23\\2019041513352639198.jpg', '300', '66', '123', '2019-04-15 13:35:26', '2019-04-15 13:35:26', '1', '8', '23');
-- ----------------------------
-- Records of tb_product_category
-- ----------------------------
INSERT INTO `tb_product_category` VALUES ('7', '嘿嘿嘿', '1', null, null, '22');
INSERT INTO `tb_product_category` VALUES ('8', '玄幻', '123', null, null, '23');
-- ----------------------------
-- Records of tb_product_img
-- ----------------------------
INSERT INTO `tb_product_img` VALUES ('1', '\\upload\\item\\shop\\23\\2019041513352661417.jpg', null, null, '2019-04-15 13:35:26', '1');
-- ----------------------------
-- Records of tb_shop
-- ----------------------------
INSERT INTO `tb_shop` VALUES ('22', '2', '1', '39', '二手书籍', '哈哈哈，欢迎大家来噢', '华电十四舍', '18993610179', '\\upload\\item\\shop\\22\\2019041214404928913.png', '0', '2019-04-12 15:02:48', '2019-04-12 14:40:50', '1', '');
INSERT INTO `tb_shop` VALUES ('23', '3', '4', '39', '许少书店', '哈哈哈，欢迎大家', '信誉楼', '110', '\\upload\\item\\shop\\23\\2019041513310158617.jpg', null, '2019-04-15 13:31:01', '2019-04-15 13:31:01', '1', null);
-- ----------------------------
-- Records of tb_shop_category
-- ----------------------------
INSERT INTO `tb_shop_category` VALUES ('33', '二手市场', '二手商品交易', '\\upload\\shopcategory\\2017061223272255687.png', '6', null, null, null);
INSERT INTO `tb_shop_category` VALUES ('34', '美容美发', '美容美发', '\\upload\\shopcategory\\2017061223273314635.png', '5', null, null, null);
INSERT INTO `tb_shop_category` VALUES ('35', '美食饮品', '美食饮品', '\\upload\\shopcategory\\2017061223274213433.png', '4', null, null, null);
INSERT INTO `tb_shop_category` VALUES ('36', '休闲娱乐', '休闲娱乐', '\\upload\\shopcategory\\2017061223275121460.png', '3', null, null, null);
INSERT INTO `tb_shop_category` VALUES ('37', '培训教育', '培训教育', '\\upload\\shopcategory\\2017061223280082147.png', '2', null, null, null);
INSERT INTO `tb_shop_category` VALUES ('38', '租赁市场', '租赁市场', '\\upload\\shopcategory\\2017061223281361578.png', '1', null, null, null);
INSERT INTO `tb_shop_category` VALUES ('39', '书籍', '二手书籍', '\\upload\\shopcategory\\2017060420322333745.png', '100', null, null, '33');
INSERT INTO `tb_shop_category` VALUES ('40', '吉他', '二手吉他', '\\upload\\shopcategory\\2017060422114076152.png', '100', null, null, '33');
INSERT INTO `tb_shop_category` VALUES ('41', '汽车', '二手汽车', '\\upload\\shopcategory\\2017060422121144586.png', '100', null, null, '33');
INSERT INTO `tb_shop_category` VALUES ('42', '美发', '美发店', '\\upload\\shopcategory\\2017060420372391702.png', '100', null, null, '34');
INSERT INTO `tb_shop_category` VALUES ('43', '美容', '美容店', '\\upload\\shopcategory\\2017060420374775350.png', '100', null, null, '34');
INSERT INTO `tb_shop_category` VALUES ('44', '保健', '大保健', '\\upload\\shopcategory\\2017060421595843693.png', '100', null, null, '34');
INSERT INTO `tb_shop_category` VALUES ('45', '炒菜', '大排档', '\\upload\\shopcategory\\2017060420460491494.png', '100', null, null, '35');
INSERT INTO `tb_shop_category` VALUES ('46', '咖啡', '咖啡', '\\upload\\shopcategory\\2017060420464594520.png', '100', null, null, '35');
INSERT INTO `tb_shop_category` VALUES ('47', '奶茶', '奶茶', '\\upload\\shopcategory\\2017060420464594520.png', '100', null, null, '35');
INSERT INTO `tb_shop_category` VALUES ('48', 'KTV', 'KTV', '\\upload\\shopcategory\\2017060420505834244.png', '100', null, null, '36');
INSERT INTO `tb_shop_category` VALUES ('49', '网吧', '网吧', '\\upload\\shopcategory\\2017060421593496807.png', '100', null, null, '36');
INSERT INTO `tb_shop_category` VALUES ('50', '游戏', '游戏厅', '\\upload\\shopcategory\\2017060420315183203.png', '100', null, null, '36');
