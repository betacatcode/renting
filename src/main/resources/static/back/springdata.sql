/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : springdata

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-11-23 12:16:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pubTime` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `pub_time` date DEFAULT NULL,
  `comment_news_id` int(11) DEFAULT NULL,
  `comment_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKagg4bwu5dqm4t8xw27hcas9h0` (`comment_news_id`),
  KEY `FKo089eaimyrr5e0u94qjgsvxs7` (`comment_user_id`),
  CONSTRAINT `FKagg4bwu5dqm4t8xw27hcas9h0` FOREIGN KEY (`comment_news_id`) REFERENCES `tb_news` (`id`),
  CONSTRAINT `FKo089eaimyrr5e0u94qjgsvxs7` FOREIGN KEY (`comment_user_id`) REFERENCES `tb_sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_house`
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `profile` text,
  `video` varchar(255) DEFAULT NULL,
  `apartment` varchar(255) DEFAULT NULL,
  `size` float DEFAULT NULL,
  `subwayline` varchar(255) DEFAULT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `orientation` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `term` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('2', '龙华三居loft春影', '  整租三居室春影，户型方正，通风采光好。落地窗，超大客厅和餐厅，配套品牌家具家电。独立厨房，开启精致生活。深圳龙华筑梦紧临地铁站，22分钟直通福田CBD。50-81m²超大复式楼居住空间，3种户型，任你选择； 400㎡共享公区，6大分区，宜动宜静；配备24小时安保门禁、前台管家及专业保洁维修服务，安全省心。聚会轰趴、达人沙龙、插画烘焙等每周定期的社群活动。', 'no', '2室1厅', '10', '1', '整租', '南', '离地铁近', '月租', '2300');
INSERT INTO `tb_house` VALUES ('3', '泰和花园·4居室', '优化间朝南，带阳台，装修风格清新脱俗，配备品如风格的家私家电，为你打造舒适方便的独处空间，适合喜欢安静，享受生活的你。', '泰和花园·4居室.mp4', '4室1厅', '8.6', '2', '合租', '南', '独立卫生间', '月租', '1860');
INSERT INTO `tb_house` VALUES ('4', '友家·阳光第五季·3居室', '温馨次卧带阳台。小区环境优美，绿树成荫。业主用心维护的房源，附带自如家具，一个人居住是不错的选择。', '友家·阳光第五季·3居室.mp4', '3室1厅', '7.9', '1', '整租', '南', '有阳台', '年租', '2200');
INSERT INTO `tb_house` VALUES ('5', '东方明珠城·5居室', '主卧，带独立卫生间，楼层高，朝向好，配备自如的空调、书桌、大床，搭配拿铁的装修风格，适合热爱生活的你，是年轻白领和情侣的不错选择，小区安保较好，安静，生活便利。\r\n主卧，带独立卫生间，楼层高，朝向好，配备自如的空调、书桌、大床，搭配拿铁的装修风格，适合热爱生活的你，是年轻白领和情侣的不错选择，小区安保较好，安静，生活便利。\r\n主卧，带独立卫生间，楼层高，朝向好，配备自如的空调、书桌、大床，搭配拿铁的装修风格，适合热爱生活的你，是年轻白领和情侣的不错选择，小区安保较好，安静，生活便利。\r\n主卧，带独立卫生间，楼层高，朝向好，配备自如的空调、书桌、大床，搭配拿铁的装修风格，适合热爱生活的你，是年轻白领和情侣的不错选择，小区安保较好，安静，生活便利。\r\n，带独立卫生间，楼层高，朝向好，配备自如的空调、书桌、大床，搭配拿铁的装修风格，适合热爱生活的你，是年轻白领和情侣的不错选择，小区安保较好，安静，生活便利。\r\n', 'no', '5室1厅', '10.8', '3', '合租', '南', '离地铁近', '年租', '1840');
INSERT INTO `tb_house` VALUES ('6', '万科四季花城一期·4居室', '距离五和地铁A出口很近，房间南北朝向很通风的。小区绿化面很高，周边的配套设置成熟。周边有海达和成购物广场，天虹购物广场，八号仓购物广场，小区内有游泳池、食堂、健身房，非常的宜居。\r\n', 'no', '4室1厅', '12', '2', '整租', '南', '有阳台', '月租', '1890');
INSERT INTO `tb_house` VALUES ('7', '香蜜新村·3居室', '房间采光通透，视野开阔，可以沐浴在阳光中享受美好的一天。配置自如品牌家具家电，起居方便，好生活就现在！', '香蜜新村·3居室.mp4', '3室1厅', '10.02', '3', '合租', '南', '首次出租', '月租', '2390');
INSERT INTO `tb_house` VALUES ('8', '两居loft秋韵', '■上层卧室、下层起居，待客、休息互不打扰\r\n■全景落地窗、独立衣帽间\r\n■封闭式厨房，开放式书房，功能区齐全 \r\n\r\n深圳龙华筑梦自如寓是自如深圳首栋自如寓，紧临地铁站，22分钟直通福田CBD。50-81m²超大复式楼居住空间，3种户型，任你选择； 400㎡共享公区，6大分区，宜动宜静；配备24小时安保门禁、前台管家及专业保洁维修服务，安全省心。聚会轰趴、达人沙龙、插画烘焙等每周定期的社群活动，这里将成为自如客线下欢聚的打卡地之一。', 'no', '2室2厅2卫', '78', '1', '整租', '南', '独立卫生间', '年租', '5809');
INSERT INTO `tb_house` VALUES ('9', '桃源村二期·4居室', '四居室中的优化卧，适合两个人居住，光线好，自然舒适，业主精心维护，房间配备自如家私，公区配置品牌家电，适合热爱生活的你。', '桃源村二期·4居室.mp4', '4室1厅', '9.7', '2', '合租', '南', '免物业费', '月租', '2560');
INSERT INTO `tb_house` VALUES ('10', '珠江旭景佳园·4居室', '大次卧，采光棒，通风好，业主用心维护的房源，附带自如家具，自己的房间，自己的世界，适合一个人住的清新地带。热爱生活你的，可以住得更好。', '珠江旭景佳园·4居室.mp4', '4室1厅', '11.5', '2', '合租', '南', '免物业费', '年租', '1990');

-- ----------------------------
-- Table structure for `tb_house_imgs`
-- ----------------------------
DROP TABLE IF EXISTS `tb_house_imgs`;
CREATE TABLE `tb_house_imgs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `img_house_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfd0h31s1qd4mxkku83escl6rd` (`img_house_id`),
  CONSTRAINT `FKfd0h31s1qd4mxkku83escl6rd` FOREIGN KEY (`img_house_id`) REFERENCES `tb_house` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_house_imgs
-- ----------------------------
INSERT INTO `tb_house_imgs` VALUES ('9', '龙华三居loft春影_0.jpg', '2');
INSERT INTO `tb_house_imgs` VALUES ('10', '龙华三居loft春影_1.jpg', '2');
INSERT INTO `tb_house_imgs` VALUES ('11', '龙华三居loft春影_2.jpg', '2');
INSERT INTO `tb_house_imgs` VALUES ('12', '龙华三居loft春影_3.jpg', '2');
INSERT INTO `tb_house_imgs` VALUES ('13', '泰和花园·4居室_0.jpg', '3');
INSERT INTO `tb_house_imgs` VALUES ('14', '泰和花园·4居室_1.jpg', '3');
INSERT INTO `tb_house_imgs` VALUES ('15', '泰和花园·4居室_2.jpg', '3');
INSERT INTO `tb_house_imgs` VALUES ('16', '泰和花园·4居室_3.jpg', '3');
INSERT INTO `tb_house_imgs` VALUES ('17', '友家·阳光第五季·3居室_0.jpg', '4');
INSERT INTO `tb_house_imgs` VALUES ('18', '友家·阳光第五季·3居室_1.jpg', '4');
INSERT INTO `tb_house_imgs` VALUES ('19', '友家·阳光第五季·3居室_3.jpg', '4');
INSERT INTO `tb_house_imgs` VALUES ('20', '友家·阳光第五季·3居室_2.jpg', '4');
INSERT INTO `tb_house_imgs` VALUES ('21', '东方明珠城·5居室_0.jpg', '5');
INSERT INTO `tb_house_imgs` VALUES ('22', '东方明珠城·5居室_1.jpg', '5');
INSERT INTO `tb_house_imgs` VALUES ('23', '东方明珠城·5居室_2.jpg', '5');
INSERT INTO `tb_house_imgs` VALUES ('24', '东方明珠城·5居室_3.jpg', '5');
INSERT INTO `tb_house_imgs` VALUES ('25', '万科四季花城一期·4居室_0.jpg', '6');
INSERT INTO `tb_house_imgs` VALUES ('26', '万科四季花城一期·4居室_1.jpg', '6');
INSERT INTO `tb_house_imgs` VALUES ('27', '万科四季花城一期·4居室_2.jpg', '6');
INSERT INTO `tb_house_imgs` VALUES ('28', '万科四季花城一期·4居室_3.jpg', '6');
INSERT INTO `tb_house_imgs` VALUES ('29', '香蜜新村·3居室_0.jpg', '7');
INSERT INTO `tb_house_imgs` VALUES ('30', '香蜜新村·3居室_1.jpg', '7');
INSERT INTO `tb_house_imgs` VALUES ('31', '香蜜新村·3居室_2.jpg', '7');
INSERT INTO `tb_house_imgs` VALUES ('32', '香蜜新村·3居室_3.jpg', '7');
INSERT INTO `tb_house_imgs` VALUES ('33', '两居loft秋韵_0.jpg', '8');
INSERT INTO `tb_house_imgs` VALUES ('34', '两居loft秋韵_1.jpg', '8');
INSERT INTO `tb_house_imgs` VALUES ('35', '两居loft秋韵_2.jpg', '8');
INSERT INTO `tb_house_imgs` VALUES ('36', '两居loft秋韵_3.jpg', '8');
INSERT INTO `tb_house_imgs` VALUES ('37', '桃源村二期·4居室_0.jpg', '9');
INSERT INTO `tb_house_imgs` VALUES ('38', '桃源村二期·4居室_1.jpg', '9');
INSERT INTO `tb_house_imgs` VALUES ('39', '桃源村二期·4居室_2.jpg', '9');
INSERT INTO `tb_house_imgs` VALUES ('40', '桃源村二期·4居室_3.jpg', '9');
INSERT INTO `tb_house_imgs` VALUES ('41', '珠江旭景佳园·4居室_0.jpg', '10');
INSERT INTO `tb_house_imgs` VALUES ('42', '珠江旭景佳园·4居室_1.jpg', '10');
INSERT INTO `tb_house_imgs` VALUES ('43', '珠江旭景佳园·4居室_2.jpg', '10');
INSERT INTO `tb_house_imgs` VALUES ('44', '珠江旭景佳园·4居室_3.jpg', '10');

-- ----------------------------
-- Table structure for `tb_news`
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `pub_time` date DEFAULT NULL,
  `like` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `comment_num` int(11) DEFAULT NULL,
  `news_partition_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jec2a35ycwbyk5kqrwm2nerd` (`news_partition_id`),
  CONSTRAINT `FK4jec2a35ycwbyk5kqrwm2nerd` FOREIGN KEY (`news_partition_id`) REFERENCES `tb_partition` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES ('1', '钜惠11亿 品如重新定义11.11', '萌芽于淘宝的促销活动，11.11在走过了10个年头之后，早已发展成了全国性的购物狂欢。每年中国超过三分之一的消费者参与其中，希望得到低价带来的实惠，但越来越多的消费者却发现：我只是想捡点便宜，你却想把我当韭菜割掉？\r\n\r\n有的人发现平台优惠计算方式太过复杂，不建立方程式都算不清楚。\r\n\r\n有的人为了红包“盖遍了全中国的楼”，甚至催生了一门新的生意。\r\n\r\n转发，砍价，助力等链接纷纷覆盖了各大微信群，人民群众不禁开始思考：耗费如此多的精力，还不一定能够得到奖励，还滥用社交人脉的“优惠”，真的值得吗？\r\n\r\n所幸，今年的11.11，品如为业界提供了一种新的模式，也为大家提供了一种新的选择。\r\n\r\n全网底价基础上再打折，直接让利购房者，品如携手各大知名房企直连用户，在100个城市准备了近2000个优惠楼盘，优惠金额超过110000万元。\r\n\r\n以消费者为核心，聚焦用户体验，品如的11.11购房狂欢节特价房源、直播探盘等方式，让消费者享有更优惠的价格的同时，也享受更优质的服务。\r\n\r\n直连房企，购房节价格破冰\r\n\r\n品如以购房者核心需求为原点，携手行业龙头房企直连用户，实现了用户“价格”、“品质”、“服务”多维需求的最优解。\r\n\r\n汇聚恒大、万科、碧桂园、融创、龙湖、富力、保利、中海等300余家主流房企近2000个项目，此次购房狂欢节已吸引超200万购房者参与其中，用户享受优惠总计超过11亿元。\r\n\r\n落地北京、广州、天津、武汉、长沙、太原等过百个重磅城市，单个城市看房团线上线下参与人数超过10万，项目为购房节提供的价格对比市价低至85折，更有免费车位等多样化优惠配套。\r\n\r\n通过拼团购房和优惠券的福利渠道，仅新房领域就有超过17000个购房者在全国范围1500个项目享受到了最低五位数的优惠金额。\r\n\r\n除新房以外，意在购买二手房的客户，也在购房节享受到佣金折扣与特价房源的复合优惠，不到一天的时间内成交的优惠房源超过200套，单套优惠最高达99万。\r\n\r\n在家居领域，品如联合苏宁，九牧，索菲亚，欧派等行业知名品牌，为购房者提供多款保证全网底价的专属拍品，击穿价格冰点，为装修的用户打造出品如的专属钜惠。\r\n\r\n多重优惠，全方位提升购房体验\r\n\r\n有没有价格优势，到底能给用户多少实惠，无疑是11.11最大的焦点。但不可否认的是，用户在购买过程的体验如何，也是消费者越来越关心的一个点。\r\n\r\n此次11.11购房狂欢节，品如在新房、二手房、家居等领域为购房者提供了多种崭新玩法，为购房者打造多维度的完备购房场景，也给予了消费者充分的自主选择权。\r\n\r\n除预购优惠、定金膨胀等常规方式以外，品如还通过直播购房的方式，一改探盘必须亲身前往费时费力的惯例，让专业经纪人把线下的踩盘体验带到了线上，用VR全景看房为缺乏时间精力的购房者提供了崭新的渠道。11.11一天时间内，270场购房直播向消费者呈现了近200个独家特惠项目，活动期间撒出现金及优惠红包多达5亿元。\r\n\r\n与此同时，品如还发起“房聊有礼”活动，鼓励购房者与经纪人的线上直接交流，随时明确房源信息及用户需求。购房者只要在品如APP与经纪人发起会话，就有机会获得品如发放的随机现金红包，仅红包奖励金额就超过100万元。在购房过程中，品如还联合了数十家中介机构，推出大量专属特价房源的同时减免佣金，最低折扣低至5折，为购房者提供更为实惠的服务。\r\n\r\n此外，品如还开展了空调、电视等家居建材0元拍活动，并诚邀业内知名装饰公司和材料商为消费者提供低至底价的优惠，再加上涵盖设计、施工、材料等所有装修流程的大额抵用券，对于家居装修的客户，也可谓是赚得盆满钵溢。\r\n\r\n用户为王，品如重新定义11.11\r\n\r\n到底什么是11.11？\r\n\r\n对于品如来说，11.11就是以购房者的需求为核心，覆盖购房过程的每一个环节、每一个细节，为购房者打造出最舒适的购房场景。\r\n\r\n这个场景是“简单”的，简单到你不用绞尽脑汁去计算，也可以尽享品如高达11亿的巨额优惠。\r\n\r\n这个场景也是“复杂”的，复杂到只要涉及买房的任何一个流程，你都可以在品如找到实现它的功能。\r\n\r\n场景的背后，是品如实现了从流量中心向用户中心的跃迁。肩负千万购房者的信赖，品如始终砥砺前行，为实现购房者的幸福筑家梦想而不懈努力。\r\n\r\n在11.11购房狂欢节，品如用整整11亿补贴实现了购房者的期许，而在即将到来的12.12，品如仍将秉持这个不变的理念，继续为购房者带来品类更多、力度更大的福利，让我们拭目以待。', '2019-11-11', '0', 'news_1.jpg', '0', '1');
INSERT INTO `tb_news` VALUES ('2', '多地人才政策升级 新一轮“人才争夺战”开启', '近月来，南京、郑州、长沙、三亚、苏州、南宁等多地密集发布人才新政，被外界称为新一轮“人才争夺战”。而在今年年初，西安、南京、常州、广州、海口、大连等多个城市发布落户新政，纷纷放宽落户条件“抢人”。\r\n\r\n南京指出，南京全市可售商品房均可作为供应房源，对人才关注度较高的商品房项目，可采取整体筹集、集中供应的方式。其他商品房项目按比例筹集，最高可达该批次项目申请上市销售量的30％。\r\n\r\n10月21日，三亚发布《进一步完善人才住房政策的通知》，指出全日制大专以及以上学历的人才，在三亚实际工作满一年，且缴纳满一年社保及个税，即可在海南省购买一套房产。山西省也发布《关于做好当前形势下高校毕业生就业创业工作的实施意见》，进一步做好高校毕业生就业创业工作，全面放开对高校毕业生、职业院校毕业生、留学归国人员的落户限制。\r\n\r\n自2019年5月16日起，对苏州工业园区范围内新取得预（销）售许可的商品住房，房地产开发企业应当将不少于预（销）售许可建筑面积60％的住房优先出售给在园区就业、创业并连续缴纳社保或个税12个月及以上，且个人及家庭（含未成年子女）在本市无自有住房的本科及以上人才，或园区人才办认定的其他高层次紧缺人才。\r\n自2019年5月16日起，对苏州工业园区范围内新取得预（销）售许可的商品住房，房地产开发企业应当将不少于预（销）售许可建筑面积60％的住房优先出售给在园区就业、创业并连续缴纳社保或个税12个月及以上，且个人及家庭（含未成年子女）在本市无自有住房的本科及以上人才，或园区人才办认定的其他高层次紧缺人才。除了放宽落户以及购房资格外，部分城市以购房、租房补贴吸引人才。11月1日，南宁市住房保障和房产管理局发布《关于开展南宁市高层次人才购房补贴发放有关工作的通知》，符合条件的高层次人才可申请购房补贴。\r\n\r\n济南表示，将对新就业职工进行补贴，根据学历不同划分为四个档次，全日制博士每月补贴1500元，全日制硕士每月1000元，全日制本科每月可领700元，不限学历的普通新就业职工每月500元。\r\n\r\n业内人士认为，人才政策频发已经是2019年楼市政策的最大特点，大部分城市的人才政策与住房政策都有关联。整体看，2019年全国已经有超过150城发布了各种人才政策，与2018年同期相比上涨超过40％。\r\n\r\n“但我们必须注意到，大部分城市没有做好吸引人才后如何留住人才的准备，简单的吸引只能导致房地产市场波动。”业内人士表示，目前全国大部分城市的人才政策，考虑到了用降低门槛吸引人来，但大部分城市都没有留住人才的措施。', '2019-11-14', '0', 'news_2.jpg', '0', '3');
INSERT INTO `tb_news` VALUES ('3', '报告：中国年轻人每月实质偿债收入比为12.52%', '临时提额、分期免息……今年“双十一”，分期消费大放异彩。有观点批评，年轻人负债过多，何必追求“伪精致”等。那么，中国年轻人的真实负债状况究竟如何呢？\r\n\r\n13日，尼尔森在京针对国内首份全景呈现中国年轻人消费信贷现状的报告——《中国消费年轻人负债状况报告》（下称“报告”）进行解读，称年轻人每月实质偿还债务收入比为12.52％。\r\n\r\n消费对中国经济增长的作用越来越重要。报告指出，目前，中国的“90后”“00后”约占总人口的24％，他们将主导未来5-10年的中国乃至全球消费格局。在中国的年轻人中，总体信贷产品的渗透率已达到86.6％。\r\n\r\n舆论对年轻人借钱消费的质疑主要在于其偿债能力。此前网上曾出现“中国90后人均负债12万，占月收入比重高达1850％”的言论。因此，弄清年轻人真实的负债状况，对于洞察并挖掘中国消费市场未来前景具有重要意义。\r\n\r\n此次调研没有采用传统的“总负债／总资产”的计算公式（报告提到，由于年轻人才刚开始资产的积累，该指标并不适合他们），而首次引用了“债务收入比”（债务偿付额／可支配收入）这一新指标，更能够反映这个阶段年轻人的负债和还款能力。报告通过每月待还款金额占月收入的比重（增量／增量）可测算，中国年轻人平均债务收入比（即负债率）为41.75％，其中13.4％的年轻人零负债。如果扣除掉消费信贷作为“支付工具”的部分，那么年轻人的每月实质偿还债务收入比将降为12.52％；在校大学生的实质债务收入比更低，只有7.5％。\r\n\r\n调研还发现，互联网分期消费产品凭借灵活便利等优势，渗透率和好感度最高，其使用率高达60.9％（信用卡为45.5％）。值得关注的是，62％的使用者会将互联网分期消费用于基本生活，而非追求“伪精致”。\r\n\r\n即便这种情况下，仍有23.5％的年轻人对信贷产品态度谨慎，通常在关键时刻才使用，尤其是学生，谨慎使用的比例超过40％，反映出年轻人分期行为相对理性。\r\n\r\n从调研结果来看，绝大多数年轻人没有被负债拖垮，反而还存下了不少钱。调研发现，32％的年轻人表示有明确的存款计划，且随着年龄和阅历的增长，每月新增存款比例也有明显提升，6成学生和近8成上班族每月能存下10％以上的收入。\r\n\r\n此次报告调研前后历时两个月，共在线访问3000余名各线级城市18至29岁消费者，力求还原真实的中国信用消费者，并洞察其消费心理和行为方式。', '2019-11-14', '0', 'news_3.jpg', '0', '3');
INSERT INTO `tb_news` VALUES ('4', '上周楼市成交稳中有降 库存总量小幅下滑', '来源：中国指数研究院\r\n\r\n一、新政要闻\r\n\r\n加快建立多主体供给、多渠道保障、租购并举的住房制度\r\n\r\n上周，国务院重申加快建立多主体供给、多渠道保障、租购并举的住房制度；深化农村集体产权制度改革，实施乡村振兴战略。香港公布16项普及惠民及便利香港专业界别到大湾区发展的政策措施，指出香港居民在粤港澳大湾区内地城市购房，获豁免所需的在本地居住、学习或工作年限证明，以及缴纳个人所得税及社保条件，使香港居民享有与当地居民同等的待遇；支持深港科技创新合作区建设，中央政府将会在便利人员、资金、货物、信息等要素流动方面制定配套支持政策。国台办、国家发改委联合发布若干措施，明确持台湾居民居住证的台湾同胞在购房资格方面与大陆居民享受同等待遇。\r\n\r\n瑞安：加强商品房预售资金监管\r\n\r\n近期，瑞安市住房和城乡建设局发布《关于加强商品房预售资金监管的通知》。通知指出，房地产企业应当在开盘现场和售楼处，公开商品房预售资金监管银行和资金账户账号，供购房人或贷款银行将购房款（包括首付款、分期付款、一次性付款和银行按揭贷款、住房公积金贷款等）直接存入资金账户。\r\n\r\n德州：职工首次住房公积金贷款结清即可再次申请贷款\r\n\r\n近日，德州住房公积金管理中心发布《关于调整住房公积金贷款政策的通知》。通知指出，将职工首次住房公积金贷款结清即可再次申请贷款，变更为首次住房公积金贷款结清一年后才能申请二次贷款。由借款人可申请两次住房公积金贷款，变更为借款人及共同申请人双方累计可申请两次住房公积金贷款。\r\n\r\n【中指观点】\r\n\r\n上周楼市成交稳中有降，各线城市成色不一。二线代表城市环比降幅高于三线代表城市，一线城市微幅上扬。同比来看，一线城市同比升幅显著高于三线代表城市。监测的11个主要城市库存总量有所下滑。\r\n\r\n二、市场概况\r\n\r\n成交情况：上周楼市成交稳中有降，各线城市分化明显\r\n\r\n上周：CREIS中指数据显示，重点监测的20个城市成交面积环比下降15.0%。其中15个城市成交环比下降，占监测城市的75%；与去年同期相比，21个代表城市成交量整体上升0.1%，其中10个城市成交同比上升。\r\n\r\n分城市来看，二三线代表城市环比下滑，一线城市同比升幅显著。环比来看，二线代表城市降幅高于三线代表城市，一线城市微幅上升。同比来看，一线城市同比升幅显著高于三线代表城市。', '2019-11-14', '0', 'news_4.jpg', '0', '2');
INSERT INTO `tb_news` VALUES ('5', '31省房地产投资占比小幅上升 上海北京逾五成', '作为全社会固定资产投资的重要组成部分，房地产投资的占比大小对当地的经济结构具有重要影响。\r\n\r\n近日，时代周报记者对全国31个省市自治区2019年前三季度固定资产投资和房地产开发投资情况整理发现，今年前三季度共有12个省市房地产开发投资占固投比重超过全国平均占比水平（19.5％），其中上海、北京、辽宁、海南四省市占比较大，分别为56.3％、50.9％、44.8％和42.4％。\r\n\r\n综合近两年数据来看，上述四个省市持续领先—2018年排名为上海、北京、海南、辽宁，占比分别为52.9％、49.0％、47.5％和46.5％。2017年则为上海、海南、北京、辽宁，占比分别为53.2％、49.8％、44.1％和35.5％。\r\n\r\n“从全国层面看，最近几年房地产投资占固投比重均为18％左右。如果考虑到房地产产业上下游所带动的水泥、家电、家装等行业投资，广义房地产领域投资占全社会固定资产投资比重会达1／3左右，与基建、工业各占1／3。但我们应该注意到，房地产投资占一个地方的固投比重越大，说明这个地方经济受房地产影响越大。”中国社科院城市发展与环境研究所土地经济与不动产研究室主任王业强对时代周报记者指出。\r\n\r\n上海、北京房地产开发投资占比较高有经济、人口、城镇化等多重因素支撑，但辽宁和海南则有些令人疑惑。近三年数据显示，上海的房地产开发投资额占固定资产投资额比重一直为全国31个省市自治区中最高，并在近三年呈现了“高―低―高”的波动。北京的比重则在近三年从44.1％上升到了50.9％，上升6.8个百分点。辽宁在近三年排名有所变化，从第四名升至第三名，但占比呈现了“低―高―低”的起伏变化，但目前44.8％的占比仍高于2017年全年的35.5％。海南作为近几年减轻房地产依赖的“排头兵”，虽目前占比仍较高，但排名从第二名降至了第四位，且占比在不断降低。\r\n\r\n“直辖”并不是上海、北京居前的解释。因为今年前三季度，另外两个直辖市—天津和重庆房地产开发投资占固投比例仅为22.3％和24.6％。经济发展程度和房地产市场情况的相关性更强—时代周报记者梳理北上广深四个一线城市，以及热点城市杭州今年前三季度房地产开发投资占固投比例的情况发现，四个一线城市及杭州的占比均超过40％。其中广州为45.5％，杭州为47.9％。深圳尚未查询到前三季度资料，但上半年资料显示，这个占比为41.3％。\r\n\r\n房地产开发投资力度与地区经济有明显关系。北京大学国民经济研究中心主任苏剑向时代周报记者指出：“经济发达地区的房价被认为有支撑，因此需求会大些，所以房地产开发投资力度更高。而经济落后地区的房地产则被认为需求较小、开发收益率较低，所以开发投资力度较低。”\r\n\r\n城市经济和发展水平是更加强有力的支撑。中国黄金集团首席经济学家万喆向时代周报记者指出：“北上广深以及杭州等城市，由于快速城镇化、经济活力强、人口集聚，自然需要更多房地产投资进而对居住需求进行支撑。”\r\n\r\n另外，万喆还表示：“我们在计算房地产开发投资额的时候，更多的是看房地产开发企业法人所在地，而不是标的所在地。在此基础上，北上广深等一线城市拥有更多大型房企注册，中小城市可能更多的是本地的房企。这可能也会对地方房地产开发投资额的计算产生一定的影响。”', '2019-11-12', '0', 'news_5.jpg', '0', '2');

-- ----------------------------
-- Table structure for `tb_partition`
-- ----------------------------
DROP TABLE IF EXISTS `tb_partition`;
CREATE TABLE `tb_partition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_partition
-- ----------------------------
INSERT INTO `tb_partition` VALUES ('1', '今日头条', '1');
INSERT INTO `tb_partition` VALUES ('2', '房产要闻', '1');
INSERT INTO `tb_partition` VALUES ('3', '本地热点', '2');

-- ----------------------------
-- Table structure for `tb_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_role`;
CREATE TABLE `tb_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_sys_role
-- ----------------------------
INSERT INTO `tb_sys_role` VALUES ('4', 'ROLE_ADMIN');
INSERT INTO `tb_sys_role` VALUES ('5', 'ROLE_USER');
INSERT INTO `tb_sys_role` VALUES ('6', 'ROLE_OWNER');

-- ----------------------------
-- Table structure for `tb_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user`;
CREATE TABLE `tb_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_sys_user
-- ----------------------------
INSERT INTO `tb_sys_user` VALUES ('3', 'ad', '123', 'no', 'no', 'no', 'admin');
INSERT INTO `tb_sys_user` VALUES ('4', 'aa', '123', '123456', '123@qq.com', 'aa.jpg', '我是丸子');
INSERT INTO `tb_sys_user` VALUES ('5', 'bb', '123', '666666', '666@163.com', 'bb.jpg', '兔子兔子');

-- ----------------------------
-- Table structure for `tb_sys_user_houses`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user_houses`;
CREATE TABLE `tb_sys_user_houses` (
  `users_id` int(11) NOT NULL,
  `houses_id` int(11) NOT NULL,
  PRIMARY KEY (`users_id`,`houses_id`),
  KEY `FKtktx2j63grmvo4s6cvfcnws38` (`houses_id`),
  KEY `FKofx84x2qyrmgxblfs647qaf52` (`users_id`),
  CONSTRAINT `FKofx84x2qyrmgxblfs647qaf52` FOREIGN KEY (`users_id`) REFERENCES `tb_sys_user` (`id`),
  CONSTRAINT `FKtktx2j63grmvo4s6cvfcnws38` FOREIGN KEY (`houses_id`) REFERENCES `tb_house` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_sys_user_houses
-- ----------------------------
INSERT INTO `tb_sys_user_houses` VALUES ('4', '2');
INSERT INTO `tb_sys_user_houses` VALUES ('5', '3');
INSERT INTO `tb_sys_user_houses` VALUES ('4', '4');
INSERT INTO `tb_sys_user_houses` VALUES ('5', '5');
INSERT INTO `tb_sys_user_houses` VALUES ('4', '6');
INSERT INTO `tb_sys_user_houses` VALUES ('5', '7');
INSERT INTO `tb_sys_user_houses` VALUES ('5', '8');
INSERT INTO `tb_sys_user_houses` VALUES ('5', '9');
INSERT INTO `tb_sys_user_houses` VALUES ('4', '10');

-- ----------------------------
-- Table structure for `tb_sys_user_roles`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user_roles`;
CREATE TABLE `tb_sys_user_roles` (
  `sys_user_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  PRIMARY KEY (`sys_user_id`,`roles_id`),
  KEY `FKlxlitp7gs1osifm6erotjhjd6` (`roles_id`),
  KEY `FKfovb1rmxt1g7pr48xsqv7esvv` (`sys_user_id`),
  CONSTRAINT `FKfovb1rmxt1g7pr48xsqv7esvv` FOREIGN KEY (`sys_user_id`) REFERENCES `tb_sys_user` (`id`),
  CONSTRAINT `FKlxlitp7gs1osifm6erotjhjd6` FOREIGN KEY (`roles_id`) REFERENCES `tb_sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_sys_user_roles
-- ----------------------------
INSERT INTO `tb_sys_user_roles` VALUES ('3', '4');
INSERT INTO `tb_sys_user_roles` VALUES ('4', '6');
INSERT INTO `tb_sys_user_roles` VALUES ('5', '6');

-- ----------------------------
-- Table structure for `tb_tag`
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag` VALUES ('1', '市场', '0');
INSERT INTO `tb_tag` VALUES ('2', '11.11', '0');
INSERT INTO `tb_tag` VALUES ('3', '金融', '0');
INSERT INTO `tb_tag` VALUES ('4', '人才政策', '0');
INSERT INTO `tb_tag` VALUES ('5', '地区经济', '0');
INSERT INTO `tb_tag` VALUES ('6', '消费信贷', '0');
INSERT INTO `tb_tag` VALUES ('7', '年轻人', '0');
INSERT INTO `tb_tag` VALUES ('8', '落户条件', '0');

-- ----------------------------
-- Table structure for `tb_tag_news`
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag_news`;
CREATE TABLE `tb_tag_news` (
  `news_id` int(11) NOT NULL,
  `tags_id` int(11) NOT NULL,
  PRIMARY KEY (`news_id`,`tags_id`),
  KEY `FKnwuftn4by84gdhsydow5u7c8i` (`tags_id`),
  KEY `FKrdomby7ni7k7gpqei0lmj3alx` (`news_id`),
  CONSTRAINT `FKnwuftn4by84gdhsydow5u7c8i` FOREIGN KEY (`tags_id`) REFERENCES `tb_tag` (`id`),
  CONSTRAINT `FKrdomby7ni7k7gpqei0lmj3alx` FOREIGN KEY (`news_id`) REFERENCES `tb_news` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_tag_news
-- ----------------------------
INSERT INTO `tb_tag_news` VALUES ('4', '1');
INSERT INTO `tb_tag_news` VALUES ('1', '2');
INSERT INTO `tb_tag_news` VALUES ('2', '4');
INSERT INTO `tb_tag_news` VALUES ('5', '5');
INSERT INTO `tb_tag_news` VALUES ('3', '6');
INSERT INTO `tb_tag_news` VALUES ('3', '7');
INSERT INTO `tb_tag_news` VALUES ('2', '8');
