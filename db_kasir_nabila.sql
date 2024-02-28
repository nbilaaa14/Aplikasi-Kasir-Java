-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 27 Feb 2024 pada 10.22
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kasir_nabila`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_detailpenjualan`
--

CREATE TABLE `tbl_detailpenjualan` (
  `kode_produk` int(20) NOT NULL,
  `id_detail` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `total_harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_detailpenjualan`
--

INSERT INTO `tbl_detailpenjualan` (`kode_produk`, `id_detail`, `qty`, `status`, `total_harga`) VALUES
(1, 5, 6, 'Belum lunas', 156000),
(6, 20, 8, 'Belum lunas', 100320);

--
-- Trigger `tbl_detailpenjualan`
--
DELIMITER $$
CREATE TRIGGER `kurangiStok` AFTER INSERT ON `tbl_detailpenjualan` FOR EACH ROW UPDATE tbl_produk SET stok=stok-new.qty WHERE kode_produk=new.kode_produk
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kategori`
--

CREATE TABLE `tbl_kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tbl_kategori`
--

INSERT INTO `tbl_kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Cincin'),
(2, 'Gelang'),
(3, 'Jam tangan'),
(4, 'Scrunchie'),
(5, 'Jepitan rambut'),
(6, 'Antingg'),
(7, 'Topi'),
(8, 'Tass'),
(9, 'Sabuk'),
(10, 'Sepatu'),
(11, 'Kalung'),
(12, 'Sarung Tangan'),
(13, 'Kacamata'),
(14, 'Bando'),
(15, 'Gantungan '),
(16, 'rudung'),
(17, 'alung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_penjualan`
--

CREATE TABLE `tbl_penjualan` (
  `id_penjualan` int(11) NOT NULL,
  `nama_pengguna` varchar(50) NOT NULL,
  `no_faktur` int(11) NOT NULL,
  `tgl_penjualan` date NOT NULL,
  `cash` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_penjualan`
--

INSERT INTO `tbl_penjualan` (`id_penjualan`, `nama_pengguna`, `no_faktur`, `tgl_penjualan`, `cash`) VALUES
(1, 'Iip Ifta Nia', 989, '2024-02-26', 1100000),
(2, 'Iip Ifta Nia', 989, '2024-02-26', 1100000),
(3, 'Iip Ifta Nia', 12323344, '2024-02-27', 1000000),
(4, 'Iip Ifta Nia', 12323344, '2024-02-27', 1000000),
(5, 'Iip Ifta Nia', 12323344, '2024-02-27', 1000000),
(6, 'Iip Ifta Nia', 12323344, '2024-02-27', 1000000),
(7, 'Iip Ifta Nia', 456667, '2024-02-27', 150000),
(8, 'Iip Ifta Nia', 6778, '2024-02-27', 160000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_produk`
--

CREATE TABLE `tbl_produk` (
  `kode_produk` int(20) NOT NULL,
  `nama_produk` varchar(255) NOT NULL,
  `harga_jual` int(20) NOT NULL,
  `harga_beli` int(20) NOT NULL,
  `stok` int(11) NOT NULL,
  `nama_satuan` varchar(50) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tbl_produk`
--

INSERT INTO `tbl_produk` (`kode_produk`, `nama_produk`, `harga_jual`, `harga_beli`, `stok`, `nama_satuan`, `nama_kategori`) VALUES
(1, 'Cincin Couple', 35000, 30000, 53, '1', '1'),
(2, 'Cincin Nadine Mutiara', 20000, 12000, 50, '1', '1'),
(3, 'Cincin Titanium', 60000, 55000, 118, '1', '1'),
(5, 'Cincin Kazia', 26000, 19000, 40, '1', '1'),
(6, 'Lanme Jewelry', 33500, 29800, 78, '2', '2'),
(7, 'Gelang Kristal Manik', 26240, 22000, 50, '2', '2'),
(8, 'Gelang Korea', 6000, 3000, 77, '2', '2'),
(9, 'Gelang Titanium', 40000, 35000, 60, '2', '2'),
(10, 'Gelang Minority Asimetris', 19340, 19000, 100, '2', '2'),
(11, 'Smartwatch', 150000, 145000, 20, '3', '3'),
(12, 'Jam tangan Quartz Analog', 95000, 93500, 30, '3', '3'),
(13, 'Scrunchie Tile Hijab', 129000, 11900, 110, '4', '4'),
(14, 'Hazel Korean Pearl Scrunchie', 18000, 16000, 45, '4', '4'),
(15, 'Korean Hair', 14000, 12000, 200, '5', '5'),
(16, 'Jepitam Mutiara', 30000, 11987, 120, '5', '5'),
(17, 'Jepitan KupuKupu', 59999, 56666, 54, '5', '5'),
(18, 'Anting Tamara', 23422, 20000, 36, '6', '6'),
(19, 'Anting Bunga Couple', 163657, 160000, 60, '6', '6'),
(20, 'Anting Stud Kristal', 12540, 12000, 28, 'Pcs', 'Antingg'),
(21, 'Topi Baseball Luca', 30000, 29000, 100, '7', '7'),
(22, 'Topi New York', 37000, 35000, 80, '7', '7'),
(23, 'Topi distro', 36000, 33000, 65, '7', '7'),
(24, 'Tas Sekolah', 250000, 230000, 20, '8', '8'),
(25, 'Tas Mossdoom', 149000, 145000, 25, '8', '8'),
(26, 'Belt Rantai', 20000, 17000, 70, '9', '9'),
(27, 'Ikat Pinggang Ring Belt Korea', 12000, 10000, 10, '9', '9'),
(28, 'Flatshoes', 55900, 53800, 30, '10', '10'),
(29, 'Sneaker Wanita ', 250000, 220500, 42, '10', '10'),
(30, 'Kalung Maritta Astrid', 38554, 37000, 33, '11', '11'),
(31, 'Jolley Kalung Liontin', 14020, 13000, 21, '11', '11'),
(32, 'Sarung Tangan Rajut', 15000, 12000, 10, '12', '123'),
(33, 'Sarung Tangan Anti UV', 16900, 15500, 10, '12', '12'),
(34, 'Kacamata Cat Eye', 114000, 111000, 20, '13', '13'),
(35, 'Kacamata Retro Vintage', 10000, 9000, 5, '13', '13'),
(36, 'Bando Include Jepit', 7500, 7000, 9, '14', '14'),
(37, 'Bando Lotso', 14000, 13799, 12, '14', '14'),
(38, 'Gantungan Lotso', 14800, 14000, -184, '15', '15'),
(40, 'Gantungan Tas', 7000, 6700, 11, '15', '15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_satuan`
--

CREATE TABLE `tbl_satuan` (
  `id_satuan` int(11) NOT NULL,
  `nama_satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tbl_satuan`
--

INSERT INTO `tbl_satuan` (`id_satuan`, `nama_satuan`) VALUES
(1, 'Pcs'),
(4, 'Unit'),
(5, 'Boks'),
(6, 'Dus'),
(7, 'Paket'),
(8, 'Palet'),
(9, 'Kilogram');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` int(11) NOT NULL,
  `nama_pengguna` varchar(50) NOT NULL,
  `email` char(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `level` enum('admin','kasir') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `nama_pengguna`, `email`, `password`, `level`) VALUES
(1, 'Nabila Hendriyani', 'hendriyaninabila12@gmail.com', '123', 'admin'),
(2, 'Iip Ifta Nia', 'iftania007@gmail.com', '111', 'kasir'),
(6, 'Mahesa', 'mahesa1@gmail.com', '222', 'kasir');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_detailpenjualan`
--
ALTER TABLE `tbl_detailpenjualan`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `kode_produk` (`kode_produk`);

--
-- Indeks untuk tabel `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  ADD PRIMARY KEY (`id_penjualan`),
  ADD KEY `nama_pengguna` (`nama_pengguna`);

--
-- Indeks untuk tabel `tbl_produk`
--
ALTER TABLE `tbl_produk`
  ADD PRIMARY KEY (`kode_produk`),
  ADD KEY `nama_kategori` (`nama_kategori`),
  ADD KEY `nama_satuan` (`nama_satuan`);

--
-- Indeks untuk tabel `tbl_satuan`
--
ALTER TABLE `tbl_satuan`
  ADD PRIMARY KEY (`id_satuan`);

--
-- Indeks untuk tabel `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT untuk tabel `tbl_satuan`
--
ALTER TABLE `tbl_satuan`
  MODIFY `id_satuan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
