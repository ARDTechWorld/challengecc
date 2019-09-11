-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 04, 2019 at 05:29 PM
-- Server version: 5.6.43
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `firstdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `datagroup`
--

CREATE TABLE `datagroup` (
  `id` int(11) NOT NULL,
  `email` varchar(150) COLLATE utf16_bin NOT NULL,
  `name` varchar(150) COLLATE utf16_bin NOT NULL,
  `groupname` varchar(150) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `datagroup`
--

INSERT INTO `datagroup` (`id`, `email`, `name`, `groupname`) VALUES
(7, 'sharmaabhishek098@gmail.com', 'Abhishek', 'CG');

-- --------------------------------------------------------

--
-- Table structure for table `facinfo`
--

CREATE TABLE `facinfo` (
  `acctype` varchar(150) COLLATE utf16_bin NOT NULL,
  `fid` varchar(150) COLLATE utf16_bin NOT NULL,
  `fsub` varchar(150) COLLATE utf16_bin NOT NULL,
  `fattn` varchar(150) COLLATE utf16_bin NOT NULL,
  `fsal` varchar(150) COLLATE utf16_bin NOT NULL,
  `fname` varchar(150) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `facinfo`
--

INSERT INTO `facinfo` (`acctype`, `fid`, `fsub`, `fattn`, `fsal`, `fname`) VALUES
('Faculty', '1', 'COA', '85%', 'Pending', 'Abhishek');

-- --------------------------------------------------------

--
-- Table structure for table `group`
--

CREATE TABLE `group` (
  `groupid` int(11) NOT NULL,
  `groupname` varchar(150) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

-- --------------------------------------------------------

--
-- Table structure for table `ipconfig`
--

CREATE TABLE `ipconfig` (
  `ipa` varchar(150) COLLATE utf16_bin NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `ipconfig`
--

INSERT INTO `ipconfig` (`ipa`, `status`) VALUES
('http://192.168.1.13/IMS', 1),
('http://192.168.1.3/IMS', 0),
('http://192.168.1.2/IMS', 0),
('http://192.168.1.15/IMS', 0);

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `n_id` int(11) NOT NULL,
  `heading` varchar(150) COLLATE utf16_bin NOT NULL,
  `description` varchar(2000) COLLATE utf16_bin NOT NULL,
  `sign` varchar(50) COLLATE utf16_bin NOT NULL,
  `n_date` varchar(20) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`n_id`, `heading`, `description`, `sign`, `n_date`) VALUES
(1, 'Fest', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu', 'Abhi', '30-6-12'),
(2, 'test', 'Surprisingly, there is a very vocal faction of the design community that wants to see filler text banished to the original sources from whence it came. Perhaps not surprisingly, in an era of endless quibbling, there is an equally vocal contingent of designers leaping to defend the use of the time-honored tradition of greeking.', 'ashu', '3-3-2018'),
(3, 'Holiday', 'College will remain Off tommorrow', 'kang', '5-12-18'),
(4, 'MST', 'MST\'s are postphoned', 'Abhishek_Kumar', '1-1-18');

-- --------------------------------------------------------

--
-- Table structure for table `stgroup`
--

CREATE TABLE `stgroup` (
  `id` int(11) NOT NULL,
  `groupname` varchar(150) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `stgroup`
--

INSERT INTO `stgroup` (`id`, `groupname`) VALUES
(1, 'CG'),
(2, 'CSE'),
(3, 'EME'),
(4, 'ss'),
(5, 'xyz'),
(6, 'rttrt'),
(7, 'rttrt'),
(8, 'kkkk'),
(9, 'op'),
(10, 'll'),
(11, 'nnb'),
(12, 'testing'),
(13, 'yyuu'),
(14, 'test2'),
(15, 'test3'),
(16, 'Friends');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf16_bin NOT NULL,
  `batch` varchar(150) COLLATE utf16_bin NOT NULL,
  `password` varchar(150) COLLATE utf16_bin NOT NULL,
  `phone` varchar(15) COLLATE utf16_bin NOT NULL,
  `email` varchar(150) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `batch`, `password`, `phone`, `email`) VALUES
(1, 'kunal', 'CSE-2014', '1234', '66559874', 'kunal@gmail.com'),
(2, 'karan', 'ME-12', '5689', '3366225', 'karan@gmail.com'),
(3, 'ravish', 'ME', '22554', '558846', 'ravish@gmail.com'),
(6, 'harsh', 'ECE', '000011', '577885', 'harsh@gmail.com'),
(7, 'kuwar', 'ME-14', '2356', '33265', 'kwr@gmail.com'),
(8, 'tt', 'jj', '545', '55', '55555'),
(9, 'test gn', 'll', '55', '77', 'kook');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fish`
--

CREATE TABLE `tbl_fish` (
  `fish_id` int(11) NOT NULL,
  `fish_name` varchar(255) COLLATE utf16_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `tbl_fish`
--

INSERT INTO `tbl_fish` (`fish_id`, `fish_name`) VALUES
(1, 'Indian Mackerel'),
(2, 'Manthal Repti'),
(3, 'Baby Sole Fish'),
(4, 'Clam Meat'),
(5, 'Indian Prawn'),
(6, 'Lamp'),
(7, 'Kandike');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(40) NOT NULL,
  `username` varchar(70) COLLATE utf16_bin NOT NULL,
  `password` varchar(40) COLLATE utf16_bin NOT NULL,
  `email` varchar(50) COLLATE utf16_bin NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `pic` varchar(30) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `created_at`, `updated_at`, `pic`) VALUES
(1, 'Abhishek', '1234', 'abhishek@gmail.com', '2018-06-28 11:30:18', '2018-06-28 11:30:18', 'abhy.jpg'),
(2, 'noni', '1234', 'noni@gmail.com', '2018-06-29 15:43:58', '2018-06-29 15:43:58', 'noni.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datagroup`
--
ALTER TABLE `datagroup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `facinfo`
--
ALTER TABLE `facinfo`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `group`
--
ALTER TABLE `group`
  ADD PRIMARY KEY (`groupid`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`n_id`);

--
-- Indexes for table `stgroup`
--
ALTER TABLE `stgroup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_fish`
--
ALTER TABLE `tbl_fish`
  ADD PRIMARY KEY (`fish_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datagroup`
--
ALTER TABLE `datagroup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `group`
--
ALTER TABLE `group`
  MODIFY `groupid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `n_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `stgroup`
--
ALTER TABLE `stgroup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_fish`
--
ALTER TABLE `tbl_fish`
  MODIFY `fish_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
