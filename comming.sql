-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2022 at 03:54 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `comming`
--

-- --------------------------------------------------------

--
-- Table structure for table `additional_mentor`
--

CREATE TABLE `additional_mentor` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `tarif` int(11) NOT NULL,
  `kategori` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `additional_mentor`
--

INSERT INTO `additional_mentor` (`id`, `user_id`, `tarif`, `kategori`) VALUES
(1, 10, 50000, 'A,B,C,D'),
(2, 2, 200000, 'AC');

-- --------------------------------------------------------

--
-- Table structure for table `balance_tracker`
--

CREATE TABLE `balance_tracker` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `type` enum('in','out') NOT NULL DEFAULT 'out',
  `amount` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `balance_tracker`
--

INSERT INTO `balance_tracker` (`id`, `user_id`, `type`, `amount`, `created_at`) VALUES
(1, 1, 'in', 25000, '2022-12-18 13:52:40'),
(2, 1, 'out', 10000, '2022-12-18 14:25:14'),
(3, 1, 'out', 60000, '2022-12-18 23:55:36'),
(4, 2, 'in', 1200000, '2022-12-19 01:03:55'),
(5, 1, 'out', 80000, '2022-12-19 02:43:43'),
(6, 1, 'in', 200000, '2022-12-19 02:51:46');

-- --------------------------------------------------------

--
-- Table structure for table `bid_project`
--

CREATE TABLE `bid_project` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `freelancer` int(11) NOT NULL,
  `offer` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bid_project`
--

INSERT INTO `bid_project` (`id`, `project_id`, `freelancer`, `offer`, `created_at`) VALUES
(1, 1, 2, 1000000, '2022-12-16 13:30:18'),
(2, 1, 2, 1200000, '2022-12-16 13:30:40');

-- --------------------------------------------------------

--
-- Table structure for table `mentoring`
--

CREATE TABLE `mentoring` (
  `id` int(11) NOT NULL,
  `topik` varchar(60) NOT NULL,
  `pengguna` int(11) NOT NULL,
  `mentor` int(11) NOT NULL,
  `sesi` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `promo` int(11) NOT NULL,
  `total_price` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mentoring`
--

INSERT INTO `mentoring` (`id`, `topik`, `pengguna`, `mentor`, `sesi`, `price`, `promo`, `total_price`, `status`, `created_at`) VALUES
(1, 'Java dasar dan OOP', 1, 2, 1, 25000, 5000, 20000, 0, '2022-12-16 15:26:21'),
(2, 'Test', 1, 10, 1, 50000, 20000, 30000, 0, '2022-12-19 02:41:22'),
(3, 'Belajar PHP', 1, 10, 2, 100000, 20000, 80000, 0, '2022-12-19 02:43:43');

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `id` int(11) NOT NULL,
  `author` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `description` varchar(60) NOT NULL,
  `price_start` int(11) NOT NULL,
  `price_end` int(11) NOT NULL,
  `taken_by` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id`, `author`, `nama`, `description`, `price_start`, `price_end`, `taken_by`, `status`, `created_at`) VALUES
(1, 1, 'Membuat Tugas UAS', 'Lorem Ipsum Dolor Sit Amet', 850000, 1350000, 2, 1, '2022-12-15 14:21:43'),
(2, 1, 'Lorem Ipsum', 'Dolor Sit Amet', 100000, 100000, NULL, 0, '2022-12-18 19:12:33'),
(3, 1, 'ss', 'ss', 2, 1, NULL, 0, '2022-12-18 19:47:17'),
(4, 1, 'Test', 'Tis', 200000, 300000, NULL, 0, '2022-12-18 19:55:27'),
(5, 1, 'Joki TP PBO', 'Modul 11', 60000, 60000, NULL, 0, '2022-12-18 23:45:01'),
(6, 1, 'test', 'test', 60000, 60000, NULL, 0, '2022-12-18 23:55:36');

-- --------------------------------------------------------

--
-- Table structure for table `promo`
--

CREATE TABLE `promo` (
  `id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL,
  `cut` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `promo`
--

INSERT INTO `promo` (`id`, `code`, `cut`, `created_at`) VALUES
(1, 'TEST', 20000, '2022-12-19 02:22:08');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` varchar(60) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `saldo` int(11) NOT NULL,
  `role` int(1) NOT NULL DEFAULT 1,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `username`, `password`, `saldo`, `role`, `created_at`) VALUES
(1, 'Akmal Muhamad Firdaus', 'amf007', '123', 220000, 1, '2022-12-15 12:32:27'),
(2, 'Ujang Suerya', 'ujang', '123', 1200000, 2, '2022-12-16 12:50:06'),
(7, 'amf', 'amf', 'amf', 0, 1, '2022-12-18 12:04:01'),
(8, 'Ini Freelancer', 'freelancer', '123', 0, 3, '2022-12-18 12:08:20'),
(10, 'mentor', 'mentor', 'mentor', 0, 2, '2022-12-18 13:03:39');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `additional_mentor`
--
ALTER TABLE `additional_mentor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `balance_tracker`
--
ALTER TABLE `balance_tracker`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `bid_project`
--
ALTER TABLE `bid_project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `project_id` (`project_id`),
  ADD KEY `freelancer` (`freelancer`);

--
-- Indexes for table `mentoring`
--
ALTER TABLE `mentoring`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mentor` (`mentor`),
  ADD KEY `pengguna` (`pengguna`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `author` (`author`),
  ADD KEY `taken_by` (`taken_by`);

--
-- Indexes for table `promo`
--
ALTER TABLE `promo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `additional_mentor`
--
ALTER TABLE `additional_mentor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `balance_tracker`
--
ALTER TABLE `balance_tracker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `bid_project`
--
ALTER TABLE `bid_project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `mentoring`
--
ALTER TABLE `mentoring`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `promo`
--
ALTER TABLE `promo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `additional_mentor`
--
ALTER TABLE `additional_mentor`
  ADD CONSTRAINT `additional_mentor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `balance_tracker`
--
ALTER TABLE `balance_tracker`
  ADD CONSTRAINT `balance_tracker_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `bid_project`
--
ALTER TABLE `bid_project`
  ADD CONSTRAINT `bid_project_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `bid_project_ibfk_2` FOREIGN KEY (`freelancer`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `mentoring`
--
ALTER TABLE `mentoring`
  ADD CONSTRAINT `mentoring_ibfk_1` FOREIGN KEY (`mentor`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `mentoring_ibfk_2` FOREIGN KEY (`pengguna`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`author`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `projects_ibfk_2` FOREIGN KEY (`taken_by`) REFERENCES `bid_project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
