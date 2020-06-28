-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2020 at 04:59 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_buku`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory_buku_keluar`
--

CREATE TABLE `inventory_buku_keluar` (
  `Kd_Buku` int(10) NOT NULL,
  `Nama_Buku` varchar(25) NOT NULL,
  `Tanggal_Masuk` date NOT NULL,
  `Tanggal_Keluar` date NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Kondisi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory_buku_keluar`
--

INSERT INTO `inventory_buku_keluar` (`Kd_Buku`, `Nama_Buku`, `Tanggal_Masuk`, `Tanggal_Keluar`, `Jumlah`, `Kondisi`) VALUES
(115, 'Teluk Alaska', '2020-05-15', '2020-06-15', 5, 'Baik');

--
-- Triggers `inventory_buku_keluar`
--
DELIMITER $$
CREATE TRIGGER `Keluar` AFTER INSERT ON `inventory_buku_keluar` FOR EACH ROW BEGIN
UPDATE inventory_buku_masuk SET Jumlah=Jumlah-New.Jumlah
WHERE Kd_Buku=New.Kd_Buku;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `inventory_buku_masuk`
--

CREATE TABLE `inventory_buku_masuk` (
  `Kd_Buku` int(10) NOT NULL,
  `Nama_Buku` varchar(25) NOT NULL,
  `Tanggal_Masuk` date NOT NULL,
  `Jumlah` int(10) NOT NULL,
  `Kondisi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory_buku_masuk`
--

INSERT INTO `inventory_buku_masuk` (`Kd_Buku`, `Nama_Buku`, `Tanggal_Masuk`, `Jumlah`, `Kondisi`) VALUES
(123, 'Alaska', '2020-06-11', 5, 'Baik');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
