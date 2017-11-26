-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2017 at 06:27 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bangiay`
--

-- --------------------------------------------------------

--
-- Table structure for table `accessories`
--

CREATE TABLE `accessories` (
  `AccessoriesId` int(11) NOT NULL,
  `AccessoriesName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Price` bigint(11) NOT NULL,
  `Size` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Image` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Color` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description` text COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `accessories`
--

INSERT INTO `accessories` (`AccessoriesId`, `AccessoriesName`, `Price`, `Size`, `Quantity`, `Image`, `Color`, `Description`) VALUES
(1, 'Oc chó', 150000, 20, 10, 'access.jpg', 'Xanh Chuối', 'tặng xong xanh cỏ luôn'),
(2, 'Oc chó 2', 150000, 10, 5, 'access.jpg', 'Xanh Lá', 'tặng xong xanh cỏ luôn');

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `UserName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Type` int(11) NOT NULL,
  `Status` bit(1) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`UserName`, `Password`, `Type`, `Status`) VALUES
('admin', 'BB6vfbZXDiMAckye9C6ezQ==', 2, b'1111111111111111111111111111111'),
('dungnv', 'tXFqyKae5bg6DwE0k1nDTA==', 0, b'1111111111111111111111111111111'),
('guest', 'tXFqyKae5bg6DwE0k1nDTA==', 0, b'1111111111111111111111111111111'),
('khachhang', 'tXFqyKae5bg6DwE0k1nDTA==', 0, b'1111111111111111111111111111111'),
('nhat', 'tXFqyKae5bg6DwE0k1nDTA==', 0, b'1111111111111111111111111111111'),
('Nhat Nguyen', 'LkijV7llsyrTRXAbmjDlJw==', 0, b'1111111111111111111111111111111'),
('nhat2', 'BB6vfbZXDiMAckye9C6ezQ==', 1, b'1111111111111111111111111111111');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CategoryId` int(11) NOT NULL,
  `CategoryName` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CategoryParent` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CategoryId`, `CategoryName`, `CategoryParent`) VALUES
(1, 'Nam', 'ADIDAS'),
(2, 'Nữ', 'TKIDOR'),
(3, 'Thể Thao', NULL),
(4, 'Trẻ Em', NULL),
(5, 'Nam', 'Nike');

-- --------------------------------------------------------

--
-- Table structure for table `commentproduct`
--

CREATE TABLE `commentproduct` (
  `CommentId` int(11) NOT NULL,
  `CommentIdParent` int(11) DEFAULT NULL,
  `LevelCmt` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `UserName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ContentComment` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Createdday` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `commentproduct`
--

INSERT INTO `commentproduct` (`CommentId`, `CommentIdParent`, `LevelCmt`, `ProductId`, `UserName`, `ContentComment`, `Createdday`) VALUES
(2, 0, 1, 6, 'dungnv', 'Shop giao hàng nhanh. Hàng đẹp lắm. Thanks shop', '2017-10-29 00:00:00'),
(3, 0, 1, 1, 'dungnv', 'Ngoài các loại dành cho người lớn , shop còn bán các mẫu dành cho trẻ em rất dễ thương nữa đấy.', '2017-10-29 00:00:00'),
(4, 0, 1, 4, 'dungnv', 'Ngoài các loại dành cho người lớn , shop còn bán các mẫu dành cho trẻ em rất dễ thương nữa đấy.', '2017-10-29 00:00:00'),
(5, 0, 1, 2, 'dungnv', 'Ngoài các loại dành cho người lớn , shop còn bán các mẫu dành cho trẻ em rất dễ thương nữa đấy.', '2017-10-29 00:00:00'),
(8, 0, 1, 5, 'Nhat Nguyen', 'ahihi? đồ ngốc', '2017-10-29 00:00:00'),
(9, 0, 1, 5, 'Nhat Nguyen', 'ahii!', '2017-10-29 00:00:00'),
(10, 8, 2, 5, 'Nhat Nguyen', 'ahihi @', '2017-10-29 00:00:00'),
(11, 10, 3, 5, 'Nhat Nguyen', 'bjsdjsj $', '2017-10-29 00:00:00'),
(12, 0, 1, 4, 'dungnv', 'nhật', '2017-10-29 00:00:00'),
(13, 12, 2, 4, 'dungnv', 'nhật 2', '2017-10-29 00:00:00'),
(14, 0, 1, 1, 'guest', 'ádasd', '2017-11-14 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `favorites`
--

CREATE TABLE `favorites` (
  `UserName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ProductId` int(11) NOT NULL,
  `Createdday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `favorites`
--

INSERT INTO `favorites` (`UserName`, `ProductId`, `Createdday`) VALUES
('dungnv', 4, '2017-10-29'),
('dungnv', 6, '2017-10-29');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `FeedBackId` int(11) NOT NULL,
  `ContentFeedBack` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Createdday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`FeedBackId`, `ContentFeedBack`, `Name`, `Email`, `Createdday`) VALUES
(1, 'Nguyễn Văn DŨng Nhật', 'Nguyễn Văn DŨng Nhật', 'Hehe Trang ch? hay l?m', '2017-10-29'),
(2, 'Hehe Trang chủ hay lắm', 'Nguyễn Văn DŨng Nhật', 'vandungk4cntt@gmail.com', '2017-10-29'),
(3, 'Hehe Trang chủ hay lắm', 'Nguyễn Văn DŨng Nhật', 'vandungk4cntt@gmail.com', '2017-10-29'),
(4, 'Hehe Trang chủ hay lắm', 'Nguyễn Văn DŨng', 'volam2271461@gmail.com', '2017-10-29'),
(5, 'Nhật Hay Lắm em ơi', 'Nguyễn Văn DŨng Nhật', 'volam2271461@gmail.com', '2017-10-29'),
(6, 'nghấ', 'võ ngọc nhật', 'volam@gmail.com', '2017-10-29'),
(7, '123123', '123123', '123123@gmail.com', '2017-10-29'),
(8, '123123', '123123', 'vandungk4cntt@gmail.com', '2017-10-29'),
(9, '123', '123', '123123@gmail.com', '2017-10-29');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `OrderId` int(11) NOT NULL,
  `UserName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FullName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Phone` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Address` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Gender` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Birthday` date DEFAULT NULL,
  `Method` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TotalQuantity` int(11) NOT NULL,
  `TotalPrice` bigint(11) NOT NULL,
  `Status` bit(1) NOT NULL,
  `Confirm` bit(1) NOT NULL DEFAULT b'0',
  `Createdday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`OrderId`, `UserName`, `FullName`, `Email`, `Phone`, `Address`, `Gender`, `Birthday`, `Method`, `TotalQuantity`, `TotalPrice`, `Status`, `Confirm`, `Createdday`) VALUES
(2, 'Nhat Nguyen', 'Nguyễn Quang Nhật', 'nhatnguyen@gmail.com', '5465656', 'Sơn Trà - Đà Nẵng', 'Nam', '2017-10-29', 'Ofline', 1134, 22680000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2016-10-29'),
(3, 'guest', 'Nguyễn Văn Dũng', 'volam2271461@gmail.com', '123123', '1123213', 'Nam', '2017-10-29', 'Ofline', 2, 40000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2016-10-29'),
(4, 'guest', '123123', 'volam2271461@gmail.com', '123123', '123123', 'Nam', '2017-10-29', 'Ofline', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2016-11-29'),
(5, 'guest', '123123', 'volam2271461@gmail.com', '123213', '123123', 'Nam', '2017-10-29', 'Ofline', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-29'),
(6, 'guest', '123123', '123123@gmail.com', '123123', '123123', 'Nam', '2017-10-29', 'Ofline', 3, 60000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-29'),
(7, 'dungnv', 'Nguyễn Văn Dũng', 'vandungk4cntt@gmail.com', '0123654789', 'Hà Tĩnh', 'Nam', '2017-10-29', 'Ofline', 1, 50000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-29'),
(9, 'dungnv', 'Nguyễn Văn Dũng', 'vandungk4cntt@gmail.com', '0123654789', 'Hà Tĩnh', 'Nam', '2017-10-29', 'Ofline', 0, 10000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-29'),
(10, 'dungnv', 'Nguyễn Văn Dũng', 'vandungk4cntt@gmail.com', '0123654789', 'Hà Tĩnh', 'Nam', '2017-10-29', 'Ofline', 0, 10000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-29'),
(27, 'guest', 'ngat', '31231312@gmail.com', '21321', 'adsda', 'Nam', '2017-10-20', 'Ofline', 1, 50000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-31'),
(29, 'guest', 'ngat', '31231312@gmail.com', '21321', 'adsda', 'Nam', '2017-10-20', 'Ofline', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-31'),
(30, 'guest', 'ngat', '31231312@gmail.com', '21321', 'adsda', 'Nam', '2017-10-20', 'Ofline', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-10-31'),
(32, 'guest', 'ten', 'em@gmail.com', '0123', 'dc', 'Nữ', '2017-11-15', 'Online', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-01'),
(33, 'guest', '123123', '123123123@gmail.com', '123123', '12312', 'Nam', '2017-11-10', 'Online', 1, 50000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-01'),
(34, 'guest', 'ngat', '31231312@gmail.com', '21321', 'adsda', 'Nam', '2017-10-20', 'Online', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-01'),
(39, 'admin', 'Võ Ngọc Nhật', '3@gmail.com', '2', '1', 'Nam', '2017-10-29', 'Bảo Kim', 3, 60000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-03'),
(40, 'guest', 't', '789@gmail.com', '012', 'd', 'Nữ', '2017-11-10', 'Bảo Kim', 2, 100000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-03'),
(41, 'admin', 'Võ Ngọc Nhật', '3@gmail.com', '2', '1', 'Nam', '2017-10-29', 'Offline', 0, 0, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-04'),
(42, 'admin', 'Võ Ngọc Nhật', '3@gmail.com', '2', '1', 'Nam', '2017-10-29', 'Offline', 0, 0, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-04'),
(43, 'admin', 'Võ Ngọc Nhật', '3@gmail.com', '2', '1', 'Nam', '2017-10-29', 'Offline', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-04'),
(44, 'admin', 'Võ Ngọc Nhật', '3@gmail.com', '2', '1', 'Nam', '2017-10-29', 'Ngân Lượng', 1, 50000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-04'),
(45, 'admin', 'Võ Ngọc Nhật', '3@gmail.com', '2', '1', 'Nam', '2017-10-29', 'Bảo Kim', 1, 20000, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-04'),
(46, 'guest', 'ngat', '31231312@gmail.com', '21321', 'adsda', 'Nam', '2017-10-20', 'Bảo Kim', 1, 15048, b'1111111111111111111111111111111', b'1111111111111111111111111111111', '2017-11-14');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `OrderDetailId` int(11) NOT NULL,
  `OrderId` int(11) NOT NULL,
  `ProductDetailSQId` int(11) NOT NULL,
  `Price` bigint(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`OrderDetailId`, `OrderId`, `ProductDetailSQId`, `Price`, `Quantity`) VALUES
(3, 2, 13, 20000, 1134),
(4, 3, 11, 20000, 2),
(5, 4, 11, 20000, 1),
(6, 5, 11, 20000, 1),
(7, 6, 11, 20000, 3),
(8, 7, 17, 50000, 3),
(10, 9, 11, 20000, 7),
(11, 9, 5, 50000, 1),
(12, 9, 14, 20000, 1),
(13, 9, 13, 20000, 1),
(14, 10, 11, 20000, 1),
(15, 10, 11, 20000, 2),
(16, 10, 11, 20000, 1),
(18, 30, 13, 20000, 1),
(19, 30, 11, 20000, 1),
(20, 32, 11, 20000, 1),
(21, 33, 5, 50000, 1),
(22, 34, 13, 20000, 1),
(28, 34, 0, 20000, 2),
(29, 34, 13, 20000, 1),
(33, 39, 11, 20000, 1),
(34, 39, 13, 20000, 2),
(35, 40, 0, 50000, 2),
(36, 42, 11, 20000, 1),
(37, 43, 14, 20000, 1),
(38, 44, 5, 50000, 1),
(39, 45, 11, 20000, 1),
(40, 46, 1, 15048, 1);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `UserName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FullName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Gender` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Birthday` date DEFAULT NULL,
  `Address` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Phone` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Createdday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`UserName`, `FullName`, `Gender`, `Birthday`, `Address`, `Phone`, `Email`, `Createdday`) VALUES
('admin', 'Võ Ngọc Nhật', 'Nam', '2017-10-29', '1', '2', '3@gmail.com', '2017-10-29'),
('dungnv', '123123', 'Nam', '2017-10-29', '123123', '1231231', '123123@gmail.com', '2017-10-29'),
('guest', 'ngat', 'Nam', '2017-10-20', 'adsda', '21321', '31231312@gmail.com', '2017-10-31'),
('khachhang', 'vo ngocnhat', 'Nam', '2017-11-07', 'ko', '013', 'khachhang@gmail.com', '2017-11-14'),
('nhat', '123123', 'Nam', '2017-10-29', '3213123123', '1231231', 'vandungk4cntt@gmail.com', '2017-10-29'),
('Nhat Nguyen', 'Nguyễn Quang Nhật', 'Nam', '2017-10-29', 'Sơn Trà - Đà Nẵng', '5465656', 'nhatnguyen@gmail.com', '2017-10-29');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductId` int(11) NOT NULL,
  `CategoryId` int(11) NOT NULL,
  `ProductName` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NumberViewed` bigint(11) DEFAULT NULL,
  `NumberSeller` bigint(11) DEFAULT NULL,
  `Description` text COLLATE utf8mb4_unicode_ci,
  `Price` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductId`, `CategoryId`, `ProductName`, `NumberViewed`, `NumberSeller`, `Description`, `Price`) VALUES
(1, 1, ' sneakers Biti’s Hunter', 1405, 150, 'Nhờ hiệu ứng Soobin Hoàng Sơn và Sơn Tùng TMP, đôi sneakers Biti’s Hunter “made in Việt Nam” đã chính thức trở thành item hot nhất, được giới trẻ săn đón nhất hiện nay. Mẫu mã hợp thời, màu sắc đa dạng, tạo sự thoải mái tối đa cho đôi chân, độ bền đã thành thương hiệu cùng một mức giá \"bình dân\" là loạt lý do khiến dân tình đổ xô đi mua Biti’s Hunter. Hơn hết thảy, đôi giày này khá dễ để mix&match với trang phục street style.', 15048),
(2, 2, 'Sp  thoi trang đẹp nhất lớp', 1504, 10, 'Judy là một trong những shop giày nổi tiếng ở Đà Nẵng với hơn 42k fan trên trang cá nhân Facebook. Không chỉ được lòng khách hàng với muôn thể loại giày dép vnxk đẹp – độc – chất lượng mà shop còn ghi điểm mạnh đối với người mua ở thái độ phục vụ của nhân viên rất chuyên nghiệp và nhiệt tình.', 12000),
(3, 1, 'SP thể thao chạy nhanh nhất', 1505, 20, 'Nằm trên đường Hoàng Diệu, Naa Accesssories là shop chuyên bán giày dép vnxk với nhiều mẫu mã chất lượng, hợp thời trang đến từ nhiều thương hiệu nổi tiếng như zara, louboutin, san marcos, s.oliver…', 20000),
(4, 2, 'SP thoi trang loại 1', 2026, 50, 'Nằm trên đường Phan Châu Trinh, đây là shop không thể bỏ qua đối với những cô nàng mê giày. Với mẫu mã đa dạng, phong phú được cập nhật liên tục đến từ các thương hiệu zara, mango, aldo, cewra… sẽ làm thỏa lòng các chị em phụ nữ khi đến với shop giày Moka này.', 50000),
(5, 3, 'Giày hu ra che co', 4120, 20, 'Nếu bạn là fan của những đôi sneakers, Coach Lacey, với thiết kế đơn giản, tinh tế nhưng cũng không kém phần thời trang, đây là sự lựa chọn tuyệt vời dành cho bạn nếu muốn sở hữu 1 đôi giày vnxk thật sự chất lượng!', 20000),
(6, 4, 'Gày đẹp nhất thế giới T1', 2010, 50, 'Shop chuyên bán chủ đạo với các loại giày vnxk của các thương hiệu đình đám thế giới với mức giá khá cạnh tranh, phần lớn dao động trong khoảng từ 400 đến 800 nghìn. Shop giày này có nhiều sản phẩm giày búp bê, giày bệt, cao gót... Nhanh chân đến shop thử liền một đôi đi nha mấy nàng.', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `productdetail`
--

CREATE TABLE `productdetail` (
  `ProductDetailId` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `Image` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Image2` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Image3` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Color` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `productdetail`
--

INSERT INTO `productdetail` (`ProductDetailId`, `ProductId`, `Image`, `Image2`, `Image3`, `Color`) VALUES
(1, 1, 'AIRJORDAN4RETRO.PNG', 'AIRJORDAN4RETRO1.PNG', 'AIRJORDAN4RETRO2.PNG', 'Đen'),
(2, 2, 'AIRJORDAN4RETROT.PNG', 'AIRJORDAN4RETROT1.PNG', 'AIRJORDAN4RETROT2.PNG', 'Trắng'),
(3, 3, 'AIRJORDAN4RETROTX.PNG', 'AIRJORDAN4RETROTX1.PNG', 'AIRJORDAN4RETROTX2.PNG', 'Xanh'),
(4, 4, 'AIRJORDAN5RETRO.PNG', 'AIRJORDAN5RETRO1.PNG', 'AIRJORDAN5RETRO2.PNG', 'Đỏ'),
(5, 4, 'AIRJORDAN4RETROTX.PNG', 'AIRJORDAN4RETROTX1.PNG', 'AIRJORDAN4RETROTX2.PNG', 'Xanh Biển'),
(6, 4, 'AIRJORDAN4RETROTX.PNG', 'AIRJORDAN4RETROTX1.PNG', 'AIRJORDAN4RETROTX2.PNG', 'Xanh Lá'),
(7, 1, 'AIRJORDAN4RETROT.PNG', 'AIRJORDAN4RETROT1.PNG', 'AIRJORDAN4RETROT2.PNG', 'Trắng'),
(10, 5, 'AirJordan5RetroT.PNG', 'AirJordan5RetroT1.PNG', 'AirJordan5RetroT2.PNG', 'Nâu'),
(11, 5, 'AIRJORDAN4RETROT.PNG', 'AIRJORDAN4RETROT.PNG', 'AIRJORDAN4RETROT.PNG', 'Xám'),
(12, 6, 'AIRJORDAN4RETROTX2.PNG', 'AIRJORDAN4RETROTX1.PNG', 'AIRJORDAN4RETROTX.PNG', 'Xanh');

-- --------------------------------------------------------

--
-- Table structure for table `productdetailsq`
--

CREATE TABLE `productdetailsq` (
  `ProductDetailSQId` int(11) NOT NULL,
  `ProductDetailId` int(11) NOT NULL,
  `Size` float NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `productdetailsq`
--

INSERT INTO `productdetailsq` (`ProductDetailSQId`, `ProductDetailId`, `Size`, `Quantity`) VALUES
(1, 1, 40, 9),
(2, 1, 38, 15),
(3, 1, 39, 40),
(4, 2, 32, 10),
(5, 4, 35, 7),
(6, 5, 37, 10),
(7, 5, 2, 3),
(11, 10, 30, 24),
(13, 10, 31, -19),
(14, 10, 32, 29),
(15, 11, 25, 56),
(16, 11, 26, 25),
(17, 12, 25, 17),
(18, 12, 35, 56),
(20, 12, 36, 17);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `PromotionId` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `AccessoriesId` int(11) DEFAULT NULL,
  `Discount` int(11) DEFAULT NULL,
  `MfgDate` date NOT NULL,
  `ExpDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`PromotionId`, `ProductId`, `AccessoriesId`, `Discount`, `MfgDate`, `ExpDate`) VALUES
(1, 5, 1, 50, '2017-10-29', '2017-10-29'),
(2, 5, 2, NULL, '2017-10-29', '2017-10-29');

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

CREATE TABLE `rate` (
  `ProductId` int(11) NOT NULL,
  `UserName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Star` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `Id` int(11) NOT NULL,
  `Date` date NOT NULL,
  `TotalQuantity` int(11) NOT NULL,
  `TotalPrice` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accessories`
--
ALTER TABLE `accessories`
  ADD PRIMARY KEY (`AccessoriesId`) USING BTREE;

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`UserName`) USING BTREE;

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryId`) USING BTREE;

--
-- Indexes for table `commentproduct`
--
ALTER TABLE `commentproduct`
  ADD PRIMARY KEY (`CommentId`) USING BTREE,
  ADD KEY `ProductId` (`ProductId`),
  ADD KEY `UserName` (`UserName`);

--
-- Indexes for table `favorites`
--
ALTER TABLE `favorites`
  ADD KEY `ProductId` (`ProductId`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`FeedBackId`) USING BTREE;

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`OrderId`) USING BTREE,
  ADD KEY `UserName` (`UserName`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`OrderDetailId`) USING BTREE,
  ADD KEY `OrderId` (`OrderId`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`UserName`) USING BTREE;

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductId`) USING BTREE,
  ADD KEY `CategoryId` (`CategoryId`);

--
-- Indexes for table `productdetail`
--
ALTER TABLE `productdetail`
  ADD PRIMARY KEY (`ProductDetailId`) USING BTREE,
  ADD KEY `ProductId` (`ProductId`);

--
-- Indexes for table `productdetailsq`
--
ALTER TABLE `productdetailsq`
  ADD PRIMARY KEY (`ProductDetailSQId`) USING BTREE,
  ADD KEY `ProductDetailId` (`ProductDetailId`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`PromotionId`) USING BTREE,
  ADD KEY `ProductId` (`ProductId`);

--
-- Indexes for table `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`ProductId`) USING BTREE;

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accessories`
--
ALTER TABLE `accessories`
  MODIFY `AccessoriesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `commentproduct`
--
ALTER TABLE `commentproduct`
  MODIFY `CommentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `FeedBackId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `OrderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `OrderDetailId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ProductId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `productdetail`
--
ALTER TABLE `productdetail`
  MODIFY `ProductDetailId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `productdetailsq`
--
ALTER TABLE `productdetailsq`
  MODIFY `ProductDetailSQId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `PromotionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commentproduct`
--
ALTER TABLE `commentproduct`
  ADD CONSTRAINT `commentproduct_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commentproduct_ibfk_2` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`OrderId`) REFERENCES `order` (`OrderId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`CategoryId`);

--
-- Constraints for table `productdetail`
--
ALTER TABLE `productdetail`
  ADD CONSTRAINT `productdetail_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productdetailsq`
--
ALTER TABLE `productdetailsq`
  ADD CONSTRAINT `productdetailsq_ibfk_1` FOREIGN KEY (`ProductDetailId`) REFERENCES `productdetail` (`ProductDetailId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `promotion_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rate`
--
ALTER TABLE `rate`
  ADD CONSTRAINT `rate_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
