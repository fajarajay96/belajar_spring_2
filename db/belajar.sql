-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2019 at 06:13 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `belajar`
--

-- --------------------------------------------------------

--
-- Table structure for table `table_krs`
--

CREATE TABLE `table_krs` (
  `id` int(10) NOT NULL,
  `id_mahasiswa` int(10) NOT NULL,
  `id_matakuliah` int(11) NOT NULL,
  `sks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `table_mahasiswa`
--

CREATE TABLE `table_mahasiswa` (
  `id` int(10) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `alamat` text NOT NULL,
  `no_telepon` int(15) NOT NULL,
  `sks` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_mahasiswa`
--

INSERT INTO `table_mahasiswa` (`id`, `nama`, `alamat`, `no_telepon`, `sks`) VALUES
(2, 'Fajar', 'Jakarta', 99, 21),
(3, 'ngolo kante', 'Bandung', 778, 22);

-- --------------------------------------------------------

--
-- Table structure for table `table_makul`
--

CREATE TABLE `table_makul` (
  `id` int(11) NOT NULL,
  `mataKuliah` varchar(30) DEFAULT NULL,
  `sks` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_makul`
--

INSERT INTO `table_makul` (`id`, `mataKuliah`, `sks`) VALUES
(1, 'Pemrograman Web 1', 3),
(3, 'Basis Data 1', 2),
(4, 'Basis Data 2', 3);

-- --------------------------------------------------------

--
-- Table structure for table `table_profile`
--

CREATE TABLE `table_profile` (
  `id` int(11) NOT NULL,
  `namaLengkap` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `umur` tinyint(3) NOT NULL,
  `jk` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_profile`
--

INSERT INTO `table_profile` (`id`, `namaLengkap`, `alamat`, `umur`, `jk`) VALUES
(1, 'Fajar Ardiansyah', 'Jakarta', 20, 'Pria'),
(3, 'Complete Name 1', 'Alamat 1', 20, 'Pria'),
(4, 'Complete Name 2', 'Alamat 2', 20, 'Pria');

-- --------------------------------------------------------

--
-- Table structure for table `table_students`
--

CREATE TABLE `table_students` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `sks` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_students`
--

INSERT INTO `table_students` (`id`, `name`, `address`, `sks`) VALUES
(5, 'namej', 'alamatj', 0),
(6, 'namaui', 'alamatui', 0),
(7, 'namax', 'alamatx', 0),
(8, 'namau', 'alamatu', 0),
(9, 'namahj', 'alamathj', 0),
(10, 'namaa', 'alamata', 0),
(11, 'namad', 'alamatd', 0);

-- --------------------------------------------------------

--
-- Table structure for table `table_user`
--

CREATE TABLE `table_user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_user`
--

INSERT INTO `table_user` (`id`, `username`, `password`) VALUES
(3, 'user3', 'pass3'),
(5, 'bukan', 'pass'),
(6, 'userTest', 'pass'),
(9, 'apaansihh', 'bukanitu'),
(11, 'testusername', 'testpass'),
(15, 'name', 'pass');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_krs`
--
ALTER TABLE `table_krs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_mahasiswa`
--
ALTER TABLE `table_mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_makul`
--
ALTER TABLE `table_makul`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_profile`
--
ALTER TABLE `table_profile`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_students`
--
ALTER TABLE `table_students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_user`
--
ALTER TABLE `table_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_krs`
--
ALTER TABLE `table_krs`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `table_mahasiswa`
--
ALTER TABLE `table_mahasiswa`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `table_makul`
--
ALTER TABLE `table_makul`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `table_profile`
--
ALTER TABLE `table_profile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `table_students`
--
ALTER TABLE `table_students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `table_user`
--
ALTER TABLE `table_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
