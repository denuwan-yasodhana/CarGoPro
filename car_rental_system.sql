-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 03, 2022 at 08:03 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_rental_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `AdminID` varchar(11) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `Username`, `Password`) VALUES
('AD01', 'admin', 'abc123');

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `CarID` varchar(10) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Model` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Price` int(11) NOT NULL,
  PRIMARY KEY (`CarID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`CarID`, `Brand`, `Model`, `Status`, `Price`) VALUES
('CARID001', 'AUDI', 'AD4', 'Available', 4950),
('CARID002', 'MERCEDES', 'BERX', 'Available', 5050),
('CARID003', 'HONDA', 'VIZ', 'Available', 4850),
('CARID004', 'TOYOTA', 'PREMIO', 'Available', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `customerdata`
--

DROP TABLE IF EXISTS `customerdata`;
CREATE TABLE IF NOT EXISTS `customerdata` (
  `CustomerID` varchar(30) NOT NULL,
  `Name` varchar(225) NOT NULL,
  `Address` varchar(225) NOT NULL,
  `TelephoneNo` int(11) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerdata`
--

INSERT INTO `customerdata` (`CustomerID`, `Name`, `Address`, `TelephoneNo`) VALUES
('CID001', 'Kasun Perera', 'Gampaha', 714563258),
('CID002', 'Sunil Sadaken', 'Collombo', 781236547),
('CID003', 'Piyal Nishantha', 'Badulla', 761236547);

-- --------------------------------------------------------

--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
CREATE TABLE IF NOT EXISTS `drivers` (
  `DriverID` varchar(30) NOT NULL,
  `Name` varchar(225) NOT NULL,
  `Status` varchar(30) NOT NULL,
  `TelephoneNo` int(11) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  PRIMARY KEY (`DriverID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drivers`
--

INSERT INTO `drivers` (`DriverID`, `Name`, `Status`, `TelephoneNo`, `NIC`) VALUES
('DID001', 'Kamal Gunarathne', 'Available', 751236987, '985623145V'),
('DID002', 'Priyantha Perera', 'Available', 712356963, '975623145V'),
('DID003', 'Sunil Perera', 'Available', 785645123, '962145789V'),
('DID004', 'Pasan Kunchana', 'Available', 758963457, '958745632V');

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
CREATE TABLE IF NOT EXISTS `rent` (
  `RentID` varchar(20) NOT NULL,
  `CarID` varchar(20) NOT NULL,
  `Customer` varchar(225) NOT NULL,
  `RentDate` date NOT NULL,
  `ReturnDate` date NOT NULL,
  `Amount` int(11) NOT NULL,
  `DriverID` varchar(30) NOT NULL,
  PRIMARY KEY (`RentID`),
  KEY `fk_constraint` (`CarID`),
  KEY `fk_constraint3` (`DriverID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`RentID`, `CarID`, `Customer`, `RentDate`, `ReturnDate`, `Amount`, `DriverID`) VALUES
('RID001', 'CARID001', 'Kasun Perera', '2022-08-04', '2022-08-07', 14850, 'DID001');

-- --------------------------------------------------------

--
-- Table structure for table `returns`
--

DROP TABLE IF EXISTS `returns`;
CREATE TABLE IF NOT EXISTS `returns` (
  `ReturnID` varchar(20) NOT NULL,
  `RentID` varchar(20) NOT NULL,
  `CarReturnDate` date NOT NULL,
  `DelayDates` int(11) NOT NULL,
  `DelayAmount` int(11) NOT NULL,
  PRIMARY KEY (`ReturnID`),
  KEY `fk_constraint4` (`RentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returns`
--

INSERT INTO `returns` (`ReturnID`, `RentID`, `CarReturnDate`, `DelayDates`, `DelayAmount`) VALUES
('RTID001', 'RID001', '2022-08-11', 4, 5940);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rent`
--
ALTER TABLE `rent`
  ADD CONSTRAINT `fk_constraint` FOREIGN KEY (`CarID`) REFERENCES `cars` (`CarID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_constraint3` FOREIGN KEY (`DriverID`) REFERENCES `drivers` (`DriverID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `returns`
--
ALTER TABLE `returns`
  ADD CONSTRAINT `fk_constraint4` FOREIGN KEY (`RentID`) REFERENCES `rent` (`RentID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
