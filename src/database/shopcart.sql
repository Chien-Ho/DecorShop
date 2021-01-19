-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: shopcart
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `billdetail`
--

DROP TABLE IF EXISTS `billdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `billdetail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `bills_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6deiwiymyq28qt7hg9ps5pvgo` (`bills_id`),
  KEY `FK4qfx5r9dc1mpjx2aqwk1xxq93` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetail`
--

LOCK TABLES `billdetail` WRITE;
/*!40000 ALTER TABLE `billdetail` DISABLE KEYS */;
INSERT INTO `billdetail` VALUES (1,NULL,NULL,NULL,NULL,_binary '',10.5,1,1,2),(2,NULL,NULL,NULL,NULL,_binary '',50,1,5,3),(3,NULL,NULL,NULL,NULL,_binary '',50,1,6,3),(4,NULL,NULL,NULL,NULL,_binary '',10.5,1,8,2);
/*!40000 ALTER TABLE `billdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bills` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `address` text,
  `date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `note` text,
  `phone` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:01:54','tungnguyendn99@gmail.com','tung beo','chu y',762036427),(2,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:07:26','tungnguyendn99@gmail.com','tung beo','ch',762036427),(3,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:10:35','chienho12799@gmail.com','tuu','kgon co',762036427),(4,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:11:19','chienho12799@gmail.com','tuu','kgon co',762036427),(5,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:16:19','tungnguyendn99@gmail.com','tung beo','ma',762036427),(6,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:18:43','tungnguyendn99@gmail.com','tung beo','2',762036427),(7,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:23:49','chienho12799@gmail.com','tuu','jj',762036427),(8,NULL,NULL,NULL,NULL,_binary '','da nang','2021-01-18 18:24:19','tungnguyendn99@gmail.com','tung beo','jj',762036427);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2y94svpmqttx80mshyny85wqr` (`parent_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (10,NULL,NULL,NULL,NULL,_binary '','Trang Trí Phòng Ngủ',2),(2,NULL,NULL,NULL,NULL,_binary '','Đồ Trang Trí Phòng ',NULL),(9,NULL,NULL,NULL,NULL,_binary '','Đồ Trang Trí Nhà',NULL),(4,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Tân Gia',NULL),(5,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Khai Trương',NULL),(6,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Cặp Đôi Mới Cưới',NULL),(7,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Đối Tác',NULL),(8,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Sếp',NULL),(11,NULL,NULL,NULL,NULL,_binary '','Đồ Trang Trí Kệ TV',2),(12,NULL,NULL,NULL,NULL,_binary '','Đồ Trang Trí  Tường',2),(13,NULL,NULL,NULL,NULL,_binary '','Đồ Trang Trí Vintage-Hiện đại',2),(14,NULL,NULL,NULL,NULL,_binary '','Đồ Trang Trí Phong thủy',2),(15,NULL,NULL,NULL,NULL,_binary '','Đồ Trang Trí Nội Thất',2),(16,NULL,NULL,NULL,NULL,_binary '','Tượng Phong Thủy',9),(17,NULL,NULL,NULL,NULL,_binary '','Tượng Vintage-Hiện Đại',9),(18,NULL,NULL,NULL,NULL,_binary '','Bình Gốm  Sứ',9),(19,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Kệ Rượu Vang',4),(20,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Ý Nghĩa',4),(21,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Bình Gốm Sứ',4),(22,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Ý Nghĩa',5),(23,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Ý Nghĩa',6),(24,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Bình Gốm Sứ',7),(25,NULL,NULL,NULL,NULL,_binary '','Quà Tặng Kệ Rượu Vang- Ly Rượu',7),(26,NULL,NULL,NULL,NULL,_binary '','Quà Tết ',8),(27,NULL,NULL,NULL,NULL,_binary '','Sinh Nhật Sếp',8),(28,NULL,NULL,NULL,NULL,_binary '','Sếp Lên Chức',8);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `main` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8hs00tlacip0319kutudailre` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (1,NULL,NULL,NULL,NULL,_binary '',_binary '','Do-trang-tri-nha-hien-dai-KTV063-View-1.jpg',1),(3,NULL,NULL,NULL,NULL,_binary '',_binary '','Cap-thien-nga-dia-ngoc-ks062-view1.jpg',2),(4,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Binh-tai-loc-phu-the-gom-chu-dau-bg210a1-view3.jpg',3),(5,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Phu-dieu-dia-cau-view1.jpg',4),(6,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Decor-gia-dinh-chim-ks038-view2.jpg',5),(7,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Ke-ruou-trau-phong-thuy-da-nang-ma-vang-View2-1.jpg',6),(8,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Do-decor-trang-tri-nha-dep-view1.jpg',7),(9,NULL,NULL,NULL,NULL,_binary '',_binary '','Den-dau-huou-treo-tuong-View.jpg',8),(10,NULL,NULL,NULL,NULL,_binary '',_binary '','Do-decor-dep-tan-gia-nha-moi-cap-huou-den-va-hoa-mat-troi-trang-view1.jpg',9),(11,NULL,NULL,NULL,NULL,_binary '',_binary '','Ngua-tai-loc-thuy-tinh-ngu-sac-cao-cap-view.jpg',10),(12,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Tuong-bida-decor-trang-tri-nha-hien-dai-view1.jpg',11),(13,NULL,NULL,NULL,NULL,_binary '',_binary '','Qua-tang-de-ban-lam-viec-ma-dao-thanh-cong-view-1.jpg',12),(14,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Hiep-si-bong-dem-View.jpg',13),(15,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Binh-gom-trang-tri-M016-View.jpg',14),(16,NULL,NULL,NULL,NULL,_binary '',_binary '\0','Bo-ly-ruou-vang-thuy-tinh-7-mau-A1.jpg',15);
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `content` text,
  `description` text,
  `featured` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,NULL,NULL,NULL,NULL,_binary '','Đồ trang trí nhà là những món đồ gốm sứ mạ vàng hiện đại sẽ kiến tạo không gian đơn giản mà sang trọng. Bạn và các vị khách ghé thăm sẽ cảm nhận được nét tinh tế và thời thượng khi thiết kế nội thất được tạo điểm nhấn bằng các món đồ decor này.','Chất liệu: Gốm sứ\r\n\r\nKích thước: Như hình\r\n\r\nPhong cách: Đơn giản, hiện đại',_binary '','ĐỒ TRANG TRÍ NHÀ HIỆN ĐẠI GỐM SỨ MẠ VÀNG KTV063',8.1,1,10),(2,NULL,NULL,NULL,NULL,_binary '','Nếu như cặp hươu là hiện thân của chữ Lộc, của trường thọ an khang thì đĩa ngọc được ví như nguồn năng lượng ấm áp của mặt trời. Nhờ vẻ ngoài sang trọng cùng ý nghĩa sâu sắc, KS066 là món đồ decor đẹp trang trí nhà cửa, văn phòng và là quà tân gia “vạn người mê”.','Chất liệu: Bột đá, nhựa tự nhiên\r\n\r\nKích thước: Như hình',_binary '','ĐỒ DECOR TRANG TRÍ THIÊN NGA VÀ ĐĨA NGỌC KS066-A2',10.5,1,10),(3,NULL,NULL,NULL,NULL,_binary '','Bình âm dương gốm Chu Đậu tượng trưng cho tình cảm vợ chồng thủy chung son sắt. Đặc biệt, bộ sản phẩm bình gốm Chu Đậu này còn thể hiện sự hài hòa về mặt âm dương, cân bằng ngũ hành, dễ dàng hỗ trợ vận khí cho gia đình thăng tiến.','Xuất xứ         : Gốm Chu Đậu Hải Dương vẽ vàng\r\n\r\nTỳ Bà S3      : Đ.k 18 x Cao 32cm (Cao cả đế 36cm)\r\n\r\nHoa Lam S3 : Đ.k 20 x Cao 25cm (Cao cả đế 31cm)',_binary '','BÌNH ÂM DƯƠNG GỐM CHU ĐẬU VẼ VÀNG H32CM BGCD1',50,1,10),(4,NULL,NULL,NULL,NULL,_binary '','ĐỊA CẦU HỢP KIM CAO CẤPtượng trưng cho tình cảm vợ chồng thủy chung son sắt. Đặc biệt, bộ sản phẩm bình gốm Chu Đậu này còn thể hiện sự hài hòa về mặt âm dương, cân bằng ngũ hành, dễ dàng hỗ trợ vận khí cho gia đình thăng tiến.','Chất liệu: Hợp kim mạ PVD\r\n\r\nKích thước: Rộng 30 x Sâu 12 x Cao 43cm\r\n\r\nTrọng lượng: 3Kg\r\n\r\nTỳ Bà S3      : Đ.k 18 x Cao 32cm (Cao cả đế 36cm)\r\n\r\nHoa Lam S3 : Đ.k 20 x Cao 25cm (Cao cả đế 31cm)',_binary '','ĐỒ DECOR ĐỊA CẦU HỢP KIM CAO CẤP KS035-A8',50,1,10),(5,NULL,NULL,NULL,NULL,_binary '','','Chất liệu: Bột đá + Hợp kim\r\n\r\nKích thước: Như hình',_binary '','ĐỒ DECOR TRỪU TƯỢNG GIA ĐÌNH CHIM KS038-A2',15,10,10),(6,NULL,NULL,NULL,NULL,_binary '','','Chất liệu     : Gốm sứ Bát Tràng cao cấp\r\n\r\nKích thước  : Dài 33 x Sâu 16 x Cao 36cm\r\n\r\nTrọng lượng: 5Kg',_binary '','TRÂU PHONG THỦY ĐA NĂNG GỐM BÁT TRÀNG QTV031',5.8,7,11),(7,NULL,NULL,NULL,NULL,_binary '','Hãy cùng khám phá bộ sản phẩm đang được nhiều khách hàng lựa chọn làm quà tặng tân gia và đồ trang trí cho gia đình.\r\n\r\n8 biểu tượng kì quan thế giới tại Cửa hàng bán đồ trang trí và quà tặng Decopro\r\n8 biểu tượng kỳ quan thế giới làm từ chất liệu hợp kim mạ kẽm. Mỗi sản phẩm là phác họa lại hình ảnh chân thực các biểu tượng kỳ quan trên thế giới.\r\n\r\nBiểu tượng Kỳ quan của cả Thế giới','Chất liệu    : Hợp kim mạ kẽm\r\n\r\nKích thước : Như hình',_binary '','BIỂU TƯỢNG KỲ QUAN THẾ GIỚI KS012',70,8,11),(8,NULL,NULL,NULL,NULL,_binary '','Đèn đầu hươu treo tường là món đồ trang trí tường phòng khách sang trọng và ý nghĩa. Nó có khả năng hô biến những bức tường lạnh lẽo trở nên ấm áp, sống động dưới ánh sáng vàng dịu êm.','Chất liệu      : Bột đá đúc\r\n\r\nKthước        : Cao 71 x Rộng 61 x Dày 20 cm\r\n\r\nTrọng lượng: 3Kg',_binary '','ĐÈN ĐẦU HƯƠU TREO TƯỜNG TRANG TRÍ TTT007',8.5,10,12),(9,NULL,NULL,NULL,NULL,_binary '','Sự tương phản sắc nét của cặp hươu đen huyền bí cùng màu hoa mặt trời bạch kim tạo nên sức hấp dẫn đầy lôi cuốn cho không gian phòng khách mang “hơi thở” Châu Âu. Đây cũng là món đồ decor đẹp trang trí mang sự quân bình âm dương, giúp bạn lấy lại sự cân bằng trong cuộc sống.','Chất liệu: Bột đá, nhựa tự nhiên\r\n\r\nHoa mặt trời: Đkính 30 x Cao 38 x Sâu 10cm\r\n\r\nHươu đứng: Dài 18 x Cao 34 x Sâu 7cm\r\n\r\nHươu nằm : Dài 19 x Cao 24 x Sâu 7cm',_binary '','CẶP HƯƠU ĐEN VÀ HOA MẶT TRỜI TRẮNG DECOR KS044',8.5,10,13),(10,NULL,NULL,NULL,NULL,_binary '','Như Hình','Chất liệu: Thủy tinh ngũ sắc cao cấp\r\n\r\nKích thước: Dài 34 x Sâu 12 x Cao 18cm\r\n\r\nÝ nghĩa: Mã đáo thành công',_binary '','NGỰA TÀI LỘC THỦY TINH PHONG THỦY CAO CẤP QTV001',8.9,50,14),(11,NULL,NULL,NULL,NULL,_binary '','Với những ai ưa thích bộ môn bida đầy phóng khoáng, thể trí thông minh, óc phán đoán, khả năng tính toán chiến thuật đường bóng… thì đây chắc chắn là món đồ decor trang trí nhà đẹp hiện đại không thể bỏ qua. ','Chất liệu      : Bột đá đúc\r\n\r\nKích thước   : Như hình\r\n\r\nTrọng lượng : 2.5kg',_binary '','BỘ TƯỢNG BIDA DECOR TRANG TRÍ KS045',8.5,5,15),(12,NULL,NULL,NULL,NULL,_binary '','Tượng mã đáo thành công bóng loáng, sống động, sang trọng làm quà tặng sếp tiếp thêm động lực để sếp tiến nhanh, tiến xa và dễ dàng gặt hái nhiều thành công chinh phục đỉnh cao danh vọng.','Chất liệu : Composite, Polyresen\r\n\r\nKthước   : D35 cm x R13 cm x C35 cm\r\n\r\nTrọng lượng: 3.1 Kg',_binary '','TƯỢNG MÃ ĐÁO THÀNH CÔNG QT004',9.2,20,16),(13,NULL,NULL,NULL,NULL,_binary '','Tượng hiệp sĩ bóng đêm là một trong những đồ trang trí phòng khách mang phong cách rất riêng. Tạo nên điểm nhấn độc đáo và cảm giác mới lạ cho không gian trưng bày.','Chất liệu: Composite tổng hợp\r\n\r\nKích thước: Dài 27 x Rộng 10 x Cao 28cm',_binary '','TƯỢNG HIỆP SĨ BÓNG ĐÊM KS027',9.8,8,17),(14,NULL,NULL,NULL,NULL,_binary '','Bình gốm trang trí là món quà tặng tân gia sang trọng và mang nhiều ý nghĩa tốt đẹp mừng tân gia. Một trong những món quà thay lời chúc hạnh phúc sum vầy, nhiều ý nghĩa tài lộc cho gia đình gia chủ.','Chất liệu   : Gốm sứ (Không kèm hoa)\r\n\r\nKích thước: Dài 26 x Sâu 20 x Cao 40 cm',_binary '','BÌNH GỐM TRANG TRÍ BG016',50,20,18),(15,NULL,NULL,NULL,NULL,_binary '','','Chất liệu    : Thủy tinh 7 màu cường lực\r\n\r\nKích thước: Như hình\r\n\r\nBộ sản phẩm: 6 ly 370/ 570ml ',_binary '','BỘ 6 LY RƯỢU VANG THỦY TINH 7 MÀU LR005',29,20,19);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,NULL,NULL,_binary '','ADMIN','ADMIN'),(2,NULL,NULL,NULL,NULL,_binary '','USER','USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,_binary '','admin','$2a$04$C.vjtUxZZWmDwXr.eRrTHee6MD4OYzU7U/l95JiNR8Tt4.aesG9LO','admin'),(2,NULL,NULL,NULL,NULL,_binary '','chien','$2a$04$vSdxsg9TZL2FySAfs1WnMuafbS8UaT6Re9SyII/3yPxLblQgIaIgq','chien');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 13:54:09
