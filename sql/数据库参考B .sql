-- 科室基础表(系统管理)
drop table if exists sys_depts;
CREATE TABLE `sys_depts` (
  `depts_id` int(11) NOT NULL COMMENT '科室编号---deptsId',
  `depts_name` varchar(255) NOT NULL COMMENT '科室名称---deptsName',
  `depts_code` varchar(255) NOT NULL COMMENT '科室编码---deptsCode',
  `depts_num` int(11) NOT NULL DEFAULT '0' COMMENT '科室挂号量 ----deptsNum',
  `depts_leader` varchar(255) DEFAULT NULL COMMENT '科室领导---deptsLeader',
  `depts_phone` varchar(255) DEFAULT NULL COMMENT '科室电话---deptsPhone',
  `status` int(11) NOT NULL COMMENT '科室状态---status',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者---createBy',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间--createTime',
  `update_by` varbinary(255) DEFAULT NULL COMMENT '更新者----updateBy',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间--updateTime'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT into sys_depts values
(101,"内科","HIS-Nk",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(102,"外科","HIS-WK",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(103,"儿科","HIS-EK",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(104,"妇科","HIS-FK",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(105,"眼科","HIS-YK",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(106,"耳鼻喉科","HIS-EBHK",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(107,"口腔科","HIS-KQK",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(108,"皮肤科","HIS-PFK",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW()),
(109,"其他","HIS-OTHER",0,"雷哥","17512344321",1,"admin",NOW(),"admin",NOW());



-- 检查费用表(系统管理)
drop table if exists sys_exam_cost;
CREATE TABLE `sys_exam_cost` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目费用ID---examId',
  `exam_name` varchar(255) NOT NULL COMMENT '项目名称------examName',
  `exam_key` varchar(255) NOT NULL COMMENT '项目关键字----examKey',
  `exam_one_price` double(10,2) NOT NULL COMMENT '项目单价------examOnePrice',
  `exam_cost` double(10,2) NOT NULL COMMENT '项目成本------examCost',
  `exam_unit` varchar(255) NOT NULL COMMENT '单位 examUnit',
  `exam_type` int(11) NOT NULL COMMENT '类别 examType 1、化验类  2、拍片类',
  `status` int(1) NOT NULL COMMENT '状态 status',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者---createBy',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间--createTime',
  `update_by` varbinary(255) DEFAULT NULL COMMENT '更新者----updateBy',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间--updateTime',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注------remark',
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT into sys_exam_cost values
(default,"乙肝五项","YGWX",30.00,10.00,"次",1,1,"admin",NOW(),"admin",NOW(),"乙肝五项检查"),
(default,"血常规","XCG",5.00,1.00,"次",1,1,"admin",NOW(),"admin",NOW(),"血液化验"),
(default,"CT","CT",50.00,10.00,"次",2,1,"admin",NOW(),"admin",NOW(),"乙肝五项检查"),
(default,"X光","XG",20.00,5.00,"次",2,1,"admin",NOW(),"admin",NOW(),"乙肝五项检查");

-- 医生信息表(系统管理)
drop table if exists sys_docters;
CREATE TABLE `sys_docters` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生编号 dId',
  `d_name` varchar(255) NOT NULL COMMENT '医生姓名 dName',
	d_password VARCHAR(300) not null COMMENT '医生密码 dPassword',
  `depts_id` int(11) DEFAULT NULL COMMENT '所属部门 deptId',
  `d_phone` varchar(255) DEFAULT NULL COMMENT '医生手机号 dPhone',
  `d_sex` varchar(10) DEFAULT NULL COMMENT '医生性别    dSex',
  `d_age` int(3) DEFAULT NULL COMMENT '医生年龄    dAge',
  `d_level` varchar(255) DEFAULT NULL COMMENT '医生级别   dLevel',
  `orderwork` int(11) DEFAULT NULL COMMENT '是否排班 1、是  2 、否  orderWork',
  `d_education_bg` varchar(255) DEFAULT NULL COMMENT '学历背景   dEducationBg',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into sys_docters values
(default,"扁鹊","$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2",101,"14212345678",1,20,"医师",1,"专科","admin",NOW(),"admin",NOW(),"医生");


-- 医生-部门表(系统管理)
drop table if exists sys_docters_depts;
CREATE TABLE `sys_docters_depts` (
  `d_id` int(11) DEFAULT NULL COMMENT '医生序号',
  `depts_id` int(11) DEFAULT NULL COMMENT '部门序号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 挂号费用表(系统管理)
drop table if exists sys_registration_cost;
CREATE TABLE sys_registration_cost (
  `reg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '挂号费用ID---regId',
  `reg_name` varchar(255) NOT NULL COMMENT '挂号费名称------regName',
  `reg_price` double(10,2) NOT NULL COMMENT '挂号费------regPrice',
  `status` int(1) NOT NULL COMMENT '状态 status',
`create_by` 	varchar(255) DEFAULT NULL 		COMMENT '创建者---createBy',
`create_time` 	datetime DEFAULT NULL 			COMMENT '创建时间--createTime',
`update_by` 	varbinary(255) DEFAULT NULL 	COMMENT '更新者----updateBy',
`update_time` 	datetime DEFAULT NULL 			COMMENT '更新时间--updateTime',
`remark` 		varchar(255) DEFAULT NULL 		COMMENT '备注------remark',
  PRIMARY KEY (`reg_id`)
);

insert into sys_registration_cost values
(default,"门诊",6.00,1,"admin",NOW(),"admin",NOW(),"门诊费用"),
(default,"门诊+病历本",7.00,1,"admin",NOW(),"admin",NOW(),"门诊+病历本费用"),
(default,"急诊",12.00,1,"admin",NOW(),"admin",NOW(),"急诊费用"),
(default,"急诊+病历本",13.00,1,"admin",NOW(),"admin",NOW(),"急诊+病历本费用");









-- 建立生产厂表格(药品进销存管理)
drop table if exists factory;
create table factory(
fac_id int primary key auto_increment  comment '厂家ID',
fac_name varchar(50) not null  comment '厂家名称',
fac_code varchar(20) comment '厂家编码',
fac_contact varchar(50)  comment '联系人',
fac_tel varchar(20) not null  comment '电话',
fac_key varchar(20) not null  comment '关键字',
fac_address varchar(50) not null  comment '地址',
status int  comment '状态',
`create_by` 	varchar(255) DEFAULT NULL 		COMMENT '创建者---createBy',
`create_time` 	datetime DEFAULT NULL 			COMMENT '创建时间--createTime',
`update_by` 	varbinary(255) DEFAULT NULL 	COMMENT '更新者----updateBy',
`update_time` 	datetime DEFAULT NULL 			COMMENT '更新时间--updateTime',
`remark` 		varchar(255) DEFAULT NULL 		COMMENT '备注------remark'
);

insert into factory values
(default,'云南白药集团股份有限公司','000538','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'上海医药(集团)有限公司','1812538','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'中国医药集团总公司','1238571','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'广州医药集团有限公司','1031377','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'哈药集团有限公司','727719','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'华北制药集团有限公司','700869','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'太极集团有限公司','589700','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'北京同仁堂集团有限公司','224882','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'湖南九芝堂股份有限公司','101857','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'新疆新特药民族药业有限责任公司','85191','雷大哥','0871-66350538','ynby','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家");

-- 建立供应商表格(药品进销存管理)
drop table if exists supplier;
create table supplier(
sup_id int primary key auto_increment  comment '供应商ID',
sup_name varchar(50) not null  comment '供应商名称',
sup_contact varchar(20) not null  comment '联系人',
sup_mobile varchar(20) not null  comment '联系人手机',
sup_tel varchar(20)  comment '联系人电话',
sup_account varchar(50)  comment '银行账号',
sup_address varchar(50)  comment '地址',
status int  comment '状态',
`create_by` 	varchar(255) DEFAULT NULL 		COMMENT '创建者---createBy',
`create_time` 	datetime DEFAULT NULL 			COMMENT '创建时间--createTime',
`update_by` 	varbinary(255) DEFAULT NULL 	COMMENT '更新者----updateBy',
`update_time` 	datetime DEFAULT NULL 			COMMENT '更新时间--updateTime',
`remark` 		varchar(255) DEFAULT NULL 		COMMENT '备注------remark'
);

insert into supplier values
(101,'云南英才贸易有限公司','雷华','15902738715','0278989765','6379865245129741669','云南',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(102,'武汉英才贸易有限公司','雷华','15902738715','0278989765','6379865245129741669','武汉',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(103,'深圳英才贸易有限公司','雷华','15902738715','0278989765','6379865245129741669','深圳',0,"admin",NOW(),"admin",NOW(),"生产厂家"),
(104,'北京英才贸易有限公司','雷华','15902738715','0278989765','6379865245129741669','北京',0,"admin",NOW(),"admin",NOW(),"生产厂家");

-- 建立药品信息表(药品进销存管理)
drop table if exists drug;
create table drug(
drug_id int primary key auto_increment  comment '药品ID',
drug_name varchar(50) not null  comment '药品名称',
drug_number varchar(20) not null  comment '药品编码',
drug_key varchar(20) comment '药品关键字',
drug_type varchar(20)  comment '药品类型',
drug_Rx_type varchar(20)  comment '处方类型',
drug_unit varchar(5)  comment '单位',
drug_Rx_price double(10,2)  comment '处方价格',
drug_stocks int  comment '库存量',
drug_warning int  comment '预警值',
drug_matrixing int  comment '换算值',
drug_status int  comment '状态',
fac_id int  comment '厂家ID',
`create_by` 	varchar(255) DEFAULT NULL 		COMMENT '创建者---createBy',
`create_time` 	datetime DEFAULT NULL 			COMMENT '创建时间--createTime',
`update_by` 	varbinary(255) DEFAULT NULL 	COMMENT '更新者----updateBy',
`update_time` 	datetime DEFAULT NULL 			COMMENT '更新时间--updateTime',
`remark` 		varchar(255) DEFAULT NULL 		COMMENT '备注------remark'
);
insert into drug values 
(default,'阿胶珠','sxt0001','AJJ','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"null"),
(default,'醋艾炭','sxt0002','CAT','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'制巴戟天','sxt0003','ZBJT','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'白莲','sxt0004','BL','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'白果','sxt0005','BG','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'白芷','sxt0006','BZ','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'白芍','sxt0007','BS','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'白英','sxt0008','BY','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'阿胶','sxt0009','AJ','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
(default,'铁皮石斛','sxt0010','TPSH','中草药','中药处方','g',2,200,100,1,0,2,"admin",NOW(),"admin",NOW(),"生产厂家");

-- 订单表(药品进销存管理)
drop table if exists purchase;
create table purchase(
pur_order_ID varchar(50)  comment '订单编号',
pur_count Double(10,2)  comment '订单总额',
pur_verify int  comment '审核状态',
sup_id int  comment '供应商ID',
`create_by` 	varchar(255) DEFAULT NULL 		COMMENT '创建者---createBy',
`create_time` 	datetime DEFAULT NULL 			COMMENT '创建时间--createTime',
`update_by` 	varbinary(255) DEFAULT NULL 	COMMENT '更新者----updateBy',
`update_time` 	datetime DEFAULT NULL 			COMMENT '更新时间--updateTime',
`remark` 		varchar(255) DEFAULT NULL 		COMMENT '备注------remark'
);

insert into purchase values 
('CG1271358119477379072',1000,0,1,"admin",NOW(),"admin",NOW(),"生产厂家"),
('CG1271358325345435072',1000,0,2,"admin",NOW(),"admin",NOW(),"生产厂家"),
('CG1271358119234239072',1000,0,3,"admin",NOW(),"admin",NOW(),"生产厂家");

-- 订单--药品关联表
drop table if exists purchase_drug;
CREATE TABLE `purchase_drug` (
  `pur_order_ID` varchar(50) not null  comment '订单编号',
  `drug_id` int(11) NOT NULL COMMENT '药品ID',
  `pur_numbers` int(11) DEFAULT NULL COMMENT '采购数量',
  `pur_id` int(11) DEFAULT NULL COMMENT '批次号',
  `pur_price` double(10,2) DEFAULT NULL COMMENT '药品批发单价',
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pur_order_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;










-- 患者库(看病就诊)
drop table if exists med_pati;
CREATE TABLE `med_pati` (
  `pati_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '患者编号----patiId',
  `pati_name` varchar(255) NOT NULL COMMENT '患者名称----patiName',
  `pati_code` varchar(255) DEFAULT NULL COMMENT '患者身份证--patiCode',
  `pati_phone` varchar(255) DEFAULT NULL COMMENT '患者电话----patiPhone',
  `pati_birthday` datetime DEFAULT NULL COMMENT '患者生日----patiBirthday',
  `pati_age` varchar(255) DEFAULT NULL COMMENT '患者年龄----patiAge',
  `pati_sex` varchar(1) DEFAULT NULL COMMENT '患者性别----patiSex',
  `pati_address` varchar(255) DEFAULT NULL COMMENT '患者住址----patiAddress',
  `pati_allergy` varchar(255) DEFAULT NULL COMMENT '患者过敏史--patiAllergy',
  `status` varchar(255) DEFAULT NULL COMMENT '信息状态  status',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者---createBy',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间--createTime',
  `update_by` varbinary(255) DEFAULT NULL COMMENT '更新者----updateBy',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间--updateTime',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注------remark',
  PRIMARY KEY (`pati_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into med_pati values ()

-- 挂号表（看病就诊）
drop table if exists med_reg;
CREATE table med_reg(
  reg_id      VARCHAR(20)               COMMENT '挂单号ID----regId',
  pati_name    VARCHAR(55)    not null   COMMENT '患者姓名----patiName',
	reg_depts   VARCHAR(55)    not null   COMMENT '挂号科室----regDepts',
  reg_docter  VARCHAR(55)               COMMENT '接诊医生-----regDocter',
	reg_price   DOUBLE(10,3)   not null   COMMENT '挂号费用----regPrice',
	reg_num     int(10)        not null   COMMENT'流水编号（当前号数+1）----regNum',
  reg_status  VARCHAR(55)    not null   COMMENT '状态----regStatus',
	reg_sdate   date                      COMMENT '就诊日期---- regSdate',
	reg_type    VARCHAR(55)    not null   COMMENT '挂号类型----regType',
	reg_time    VARCHAR(55)    not null   COMMENT '挂号时段----regTime',
	reg_rdate   date           not null   COMMENT '挂号时间----regRdate',
	create_by   varchar(255)   DEFAULT NULL 		COMMENT '创建者---createBy',
  create_time datetime       DEFAULT NULL 		COMMENT '创建时间--createTime',
  update_by 	varbinary(255) DEFAULT NULL    	COMMENT '更新者----updateBy',
  update_time	datetime       DEFAULT NULL 		COMMENT '更新时间--updateTime'
);

-- 病例表（看病就诊）
drop table if exists med_case;
create table med_case(
case_id         VARCHAR(20)            COMMENT '病例单号----caseId',
reg_id          VARCHAR(20)            COMMENT '挂单号ID----regId',
case_date       date         not null  COMMENT '发病日期----caseDate',
pati_code        VARCHAR(55)  not null  COMMENT '患者身份证号----patiCode',
case_type       VARCHAR(55)  not null  COMMENT '接诊类型----caseType',
case_contagion  VARCHAR(2)   not null  COMMENT '是否传染----caseContagion',
case_complaint  VARCHAR(255)           COMMENT '主诉-----caseComplaint',
case_daig_info  VARCHAR(255)            COMMENT '诊断信息----caseDaigInfo',
case_advise     VARCHAR(255)           COMMENT '医生建议----caseAdvise',
case_remarks    VARCHAR(255)           COMMENT '备注----caseRemarks',
create_by   varchar(255)   DEFAULT NULL 		COMMENT '创建者---createBy',
create_time datetime       DEFAULT NULL 		COMMENT '创建时间--createTime',
update_by 	varbinary(255) DEFAULT NULL    	COMMENT '更新者----updateBy',
update_time	datetime       DEFAULT NULL 		COMMENT '更新时间--updateTime'
);

-- 病例-检查处方表（看病就诊）
drop table if exists med_case_check;
create table med_case_check(
 case_id         VARCHAR(20)            COMMENT '病例单号----caseId',
 reg_id          VARCHAR(20)            COMMENT '挂单号ID----regId',
 pati_code        VARCHAR(55)  not null  COMMENT '患者身份证号----patiCode',
 check_id      int(10)   not null    AUTO_INCREMENT COMMENT '检查序号----checkId',
 exam_id int(11) NOT NULL COMMENT '检查项目ID---examId',
 check_remark  VARCHAR(255) COMMENT '检查备注-----checkRemark',
 create_by   varchar(255)   DEFAULT NULL 		COMMENT '创建者---createBy',
 create_time datetime       DEFAULT NULL 		COMMENT '创建时间--createTime',
 update_by 	varbinary(255) DEFAULT NULL    	COMMENT '更新者----updateBy',
 update_time	datetime       DEFAULT NULL 		COMMENT '更新时间--updateTime',
 PRIMARY KEY (check_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 病例-药用处方表（看病就诊）
drop table if exists med_case_medical;
create table med_case_medical(
 case_id         VARCHAR(20)            COMMENT '病例单号----caseId',
 reg_id          VARCHAR(20)            COMMENT '挂单号ID----regId',
 pati_code        VARCHAR(55)    COMMENT '患者身份证号----patiCode',
 medical_id      int(10)     AUTO_INCREMENT COMMENT '药用序号----medicalId',
 drug_id         int (10)   not null  COMMENT'药品Id----drugId',
 medical_num     int(10)      COMMENT '数量---medicalNum',
 medical_price   DOUBLE(10,3)   COMMENT '金额-----medicalPrice',
 medical_remark VARCHAR(255) COMMENT '服用备注---medicalRemark',
 `pay_status` int(255) NULL DEFAULT NULL COMMENT '支付状态',
 create_by   varchar(255)   DEFAULT NULL 		COMMENT '创建者---createBy',
create_time datetime       DEFAULT NULL 		COMMENT '创建时间--createTime',
update_by 	varbinary(255) DEFAULT NULL    	COMMENT '更新者----updateBy',
update_time	datetime       DEFAULT NULL 		COMMENT '更新时间--updateTime',
PRIMARY KEY (medical_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;









-- 退费表(支付系统)
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50)  NULL DEFAULT NULL COMMENT '订单号',
  `Registration_id` varchar(50)  NOT NULL COMMENT '挂号单号',
  `charge_id` varchar(20)  NOT NULL COMMENT '收费单号',
  `Patient_name` varchar(20)  NOT NULL COMMENT '患者姓名',
  `Refund_amount` varchar(20)  NOT NULL COMMENT '退费总金额',
  `Refund_method` varchar(50)  NOT NULL COMMENT '退费方式',
  `Order_status` varchar(50)  NOT NULL COMMENT '订单状态',
  `sup_build_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
);

-- 收费表(支付系统)
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50)  NULL DEFAULT NULL COMMENT '订单号',
  `Registration_id` varchar(50)  NOT NULL COMMENT '挂号单号',
  `Patient_name` varchar(50)  NOT NULL COMMENT '患者姓名',
  `Total_amount` int(11) NOT NULL COMMENT '总金额',
  `Payment_method` varchar(20)  NOT NULL COMMENT '支付类型',
  `Order_status` int(11) NOT NULL COMMENT '订单状态',
  `Creation_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
);

-- 收费详情表
DROP TABLE IF EXISTS `chargedetail`;
CREATE TABLE `chargedetail`  (
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单ID',
  `drug_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `drug_id` int(11) NULL DEFAULT NULL COMMENT '药品ID',
  `drug_Rx_price` double(10, 2) NULL DEFAULT NULL COMMENT '药品单价',
  `drug_price` double(10, 2) NULL DEFAULT NULL COMMENT '药品价格',
  `drug_amount` int(255) NULL DEFAULT NULL COMMENT '药品数量',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型（1：项目，0：药品）',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(1：已支付，0：未支付)',
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT
) ;

-- ----------------------------
-- Records of chargedetail
-- ----------------------------
INSERT INTO `chargedetail` VALUES ('23288c476c6b4db4a154fac8fe718b42', '麦丽素', 1, NULL, 2000.00, 10, '0', '1', 46);
INSERT INTO `chargedetail` VALUES ('23288c476c6b4db4a154fac8fe718b42', '混元丹', 2, NULL, 2000.00, 10, '0', '1', 47);
INSERT INTO `chargedetail` VALUES ('23288c476c6b4db4a154fac8fe718b42', '血常规', 1, NULL, 5000.00, 1, '1', '1', 48);
INSERT INTO `chargedetail` VALUES ('23288c476c6b4db4a154fac8fe718b42', 'CT', 2, NULL, 5000.00, 1, '1', '1', 49);
INSERT INTO `chargedetail` VALUES ('95b8dbf353894379869b078500c13b16', '麦丽素', 1, 200.00, 2000.00, 10, '0', '1', 50);
INSERT INTO `chargedetail` VALUES ('95b8dbf353894379869b078500c13b16', '混元丹', 2, 200.00, 2000.00, 10, '0', '1', 51);
INSERT INTO `chargedetail` VALUES ('0ee3cbfaa2c449c9a6af9bb8a710cc4b', '麦丽素', 1, 200.00, 2000.00, 10, '0', '1', 52);
INSERT INTO `chargedetail` VALUES ('0ee3cbfaa2c449c9a6af9bb8a710cc4b', '混元丹', 2, 200.00, 2000.00, 10, '0', '1', 53);
INSERT INTO `chargedetail` VALUES ('0ee3cbfaa2c449c9a6af9bb8a710cc4b', '血常规', 1, 200.00, 5000.00, 1, '1', '1', 54);
INSERT INTO `chargedetail` VALUES ('0ee3cbfaa2c449c9a6af9bb8a710cc4b', 'CT', 2, 200.00, 5000.00, 1, '1', '1', 55);
INSERT INTO `chargedetail` VALUES ('3c23704920504930a53a2668a1e755e8', '麦丽素', 1, 200.00, 2000.00, 10, '0', '2', 56);
INSERT INTO `chargedetail` VALUES ('3c23704920504930a53a2668a1e755e8', '混元丹', 2, 200.00, 2000.00, 10, '0', '2', 57);
INSERT INTO `chargedetail` VALUES ('3c23704920504930a53a2668a1e755e8', '血常规', 1, 5000.00, 5000.00, 1, '1', '2', 58);
INSERT INTO `chargedetail` VALUES ('3c23704920504930a53a2668a1e755e8', 'CT', 2, 5000.00, 5000.00, 1, '1', '2', 59);






-- 患者检查表(检查管理)
drop table if exists check_mode;
CREATE TABLE `check_mode` (
  `case_id` varchar(55) NOT NULL COMMENT '病例单号--caseId',
  `check_code` varchar(55) NOT NULL COMMENT '检查单号--checkCode',
  `pati_id` varchar(55) NOT NULL COMMENT '患者ID--patiID',
  `exam_name` varchar(55) NOT NULL COMMENT '检查项目--examName',
  `pati_name` varchar(10) NOT NULL COMMENT '患者姓名--patiName',
  `checkresult` varchar(125) DEFAULT NULL COMMENT '检查结果--checkResult',
  `checkstatus` int(11) DEFAULT NULL COMMENT '检查状态--checkStatus 添加默认值为0',
  `pay_status` int(255) NULL DEFAULT NULL COMMENT '支付状态',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者---createBy',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间--createTime',
  `update_by` varbinary(255) DEFAULT NULL COMMENT '更新者----updateBy',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间--updateTime',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注------remark',
  `filename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统自动生成的图片名称-----fileName',
  `filesite` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片地址-----filesite'
);








-- 药品销售记录表(统计)_
drop table if exists drug_sales_records;
create table drug_sales_records(
  drug_id           int             not null            comment '药品ID drogId',
  drug_name         varchar(50)     not null            comment '药品名字 drogName',
  drug_price        double(10,2)    not null            comment '药品价格 drogPrice',
  sales_num         int             not null            comment '销售数量 salesNum',
  sales_allmoney    double(10,2)    not null            comment '总价格 salesAllmoney',
  create_by         varchar(64)                         comment '创建者 createBy',
  create_time       datetime                            comment '创建时间 createTime',
  remark            varchar(500)    default null        comment '备注 remark'
);
-- 工作量统计表(统计)
drop table if exists doctor_work_records;
create table doctor_work_records(
  reg_form_id       int             not null            comment '挂号单ID regFormId',
  d_id         int             not null            comment '医生ID dId',
  d_name       varchar(64)     not null            comment '医生名字 dName',
  reg_form_price     double(10,2)    not null            comment '挂号花费 regFormPrice',
  pati_name         varchar(64)     not null            comment '患者名字 patiName',
  create_by         varchar(64)                         comment '创建者 createBy',
  create_time       datetime                            comment '创建时间 createTime',
  remark            varchar(500)    default null        comment '备注 remark'
);