--
-- Database: `database`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `no` int(11) NOT NULL,
  `pertanyaan` varchar(200) NOT NULL,
  `jawaban` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`no`, `pertanyaan`, `jawaban`) VALUES
(1, 'Berapa jumlah provinsi di Indonesia?', '34'),
(3, 'Apa nama kerajaan Hindu tertua di Indonesia?', 'Kutai'),
(5, 'Berasal dari provinsi manakah alat musik angklung?', 'Jawa Barat'),
(6, 'Monumen terkenal yang terletak di kota Jakarta adalah', 'Monas'),
(7, 'Mata uang negara Indonesia yaitu', 'Rupiah'),
(8, 'Ibukota negara Indonesia adalah', 'Jakarta'),
(9, 'Satpol PP merupakan singkatan dari', 'Satuan Polisi Pamong Praja'),
(10, 'Pakaian tradisional khas Indonesia yang bernilai seni tinggi adalah', 'Batik'),
(11, 'Tari Kecak adalah tari yang berasal dari daerah', 'Bali'),
(12, 'Senjata yang dipakai Indonesia pada masa penjajahan adalah', 'Bambu runcing'),
(13, 'Burung yang menjadi lambang kantor pos Indonesia adalah burung', 'Walet'),
(14, 'Indonesia dijajah oleh Jepang selama', '3,5 tahun'),
(15, 'Pencipta lagu "Hari Merdeka" adalah', 'H. Mutahar'),
(16, 'Pencipta lagu "Indonesia Raya" adalah', 'W.R. Supratman'),
(17, 'Kata bahasa Indonesia yang baku dan benar untuk "idjin" adalah', 'Izin'),
(18, 'Istilah Bhinneka Tunggal Ika terdapat di dalam Kitab', 'Sutasoma'),
(19, 'Rumah adat khas Papua adalah rumah', 'Honai'),
(20, 'Kapten Pattimura merupakan pahlawan Nasional Indonesia yang berasal dari daerah', 'Ambon'),
(21, 'Kota Bogor mendapatkan julukan sebagai', 'Kota Hujan'),
(22, 'Siapakah presiden pertama Republik Indonesia?', 'Ir. Soekarno'),
(23, 'Pada tanggal berapakah Indonesia memproklamasikan kemerdekaannya?', '17 Agustus 1945'),
(24, 'Lagu kebangsaan Indonesia adalah', 'Indonesia Raya'),
(25, 'Gunung tertinggi di Indonesia adalah', 'Puncak Jaya'),
(26, 'Salah satu peninggalan khas Indonesia yang masuk dalam 7 keajaiban dunia adalah', 'Candi Borobudur'),
(27, 'Hewan yang terdapat di Indonesia dan masuk dalam final 7 keajaiban alam di dunia adalah', 'Komodo'),
(28, 'Kerjaan Majapahit mencapai masa kejayaannya di bawah pemerintahan Raja', 'Hayam Wuruk'),
(29, 'Tari Saman berasal dari daerah', 'Aceh'),
(31, 'Dasar negara Indonesia adalah', 'Pancasila'),
(32, 'Kota di Indonesia yang dilewati garis khatulistiwa adalah', 'Pontianak'),
(33, 'Selat yang memisahkan pulau Jawa dengan pulau Sumatera adalah', 'Selat Sunda'),
(34, 'Presiden Indonesia yang pertama kali dipilih melalui pemilihan langsung adalah', 'Susilo Bambang Yudhoyono'),
(35, 'Setiap tanggal 14 Agustus diperingati sebagai', 'Hari Pramuka'),
(36, 'Bunga nasional negara Indonesia adalah', 'Melati'),
(37, 'Museum Satria Mandala terletak di kota', 'Jakarta'),
(38, 'Pemerintah darurat Republik Indonesia pernah memindahkan ibukota Indonesia menjadi kota', 'Yogyakarta'),
(39, 'Provinsi di Indonesia yang memiliki status istimewa adalah', 'Daerah Istimewa Yogyakarta'),
(40, 'Tokoh yang berhasil menyatukan Nusantara untuk pertama kali menurut sejarah Bangsa Indonesia adalah', 'Gajah Mada'),
(41, 'Ibukota Maluku Utara adalah', 'Ternate'),
(42, 'Tokoh nasional yang juga dikenal sebagai Bapak Koperasi Indonesia adalah', 'Mohammad Hatta'),
(43, 'Kota Batavia adalah nama lain dari kota', 'Jakarta'),
(44, 'Pahlawan dari Aceh yang memiliki istri bernama Cut Nyak Dien adalah', 'Teuku Umar'),
(45, 'Naskah proklamasi diketik oleh', 'Sayuti Melik'),
(46, 'Setiap tanggal 28 Oktober diperingati sebagai hari', 'Sumpah Pemuda'),
(47, 'Nomor kendaraan untuk wilayah Bandung adalah', 'D'),
(48, 'Nomor kendaraan untuk wilayah Jakarta adalah', 'B'),
(49, 'Lambang sila pertama Pancasila adalah', 'Bintang'),
(50, 'Pemilu pertama di Indonesia digelar pada tahun', '1955'),
(51, 'Provinsi termuda di Indonesia adalah', 'Kalimantan Utara'),
(52, 'Pengarang dari Kitab Sutasoma adalah', 'Mpu Tantular'),
(53, 'Rumah adat suku Minangkabau disebut', 'Rumah Gadang'),
(54, 'Indonesia adalah negara dengan populasi terpadat di dunia urutan ke', '4'),
(55, 'Candi Borobudur terletak di provinsi', 'Jawa Tengah'),
(56, 'Bung Karno dan Bung Hatta mendapat julukan sebagai Bapak', 'Proklamator'),
(57, 'Warna bendera Indonesia adalah', 'Merah Putih'),
(58, 'Malin Kundang adalah cerita rakyat yang berasal dari', 'Sumatera Barat'),
(59, 'Danau terbesar di Indonesia adalah', 'Danau Toba'),
(60, 'Indonesia dijajah oleh Belanda selama', '350 tahun'),
(61, 'Apa bunyi pasal ke-5 Pancasila?', 'Keadilan Bagi Seluruh Rakyat Indonesia'),
(62, 'Bendera Pusaka Merah Putih dijahit oleh', 'Fatmawati'),
(63, 'Mayoritas penduduk Indonesia memeluk agama', 'Islam'),
(64, 'Lambang negara Indonesia adalah burung', 'Garuda'),
(65, 'Daerah paling barat dari Indonesia adalah', 'Sabang'),
(66, 'Daerah paling timur dari Indonesia adalah', 'Merauke'),
(67, 'Pahlawan pendidikan Indonesia yang semboyan "Tut Wuri Handayani" adalah', 'Ki Hadjar Dewantara'),
(69, 'Bencana tsunami pernah melanda Aceh pada tahun', '2004'),
(70, 'Pulau dengan populasi terpadat di Indonesia adalah', 'Jawa'),
(71, 'Pulau dengan pemeluk agama Hindu terbanyak di Indonesia adalah', 'Bali'),
(72, 'Ada berapa banyak zona waktu di Indonesia?', '3'),
(73, 'Berapa presiden wanita yang Indonesia miliki?', '1'),
(75, 'Bentuk negara Indonesia adalah', 'Republik'),
(76, 'Kendaraan roda tiga yang hanya terdapat di Jakarta adalah', 'Bajaj'),
(77, 'Pada tahun berapa Jepang mulai menjajah Indonesia?', '1942'),
(78, 'Nama lain dari Pulau Sulawesi adalah', 'Celebes'),
(79, 'Nama lain dari Pulau Kalimantan adalah', 'Borneo'),
(80, 'Hari Kebangkitan Indonesia jatuh pada tanggal', '20 Mei'),
(81, 'Ulang tahun kota Jakarta jatuh pada tanggal', '22 Juni'),
(82, 'Sungai terpanjang di Indonesia adalah', 'Kapuas'),
(83, 'Bendera negara Indonesia sama dengan negara', 'Monaco'),
(84, 'Ir.Soekarno lahir di', 'Blitar'),
(85, 'Nama bandara yang terletak di Bali adalah', 'Ngurah Rai'),
(86, 'Jembatan terpanjang di Indonesia adalah jembatan', 'Suramadu'),
(87, 'Tari Piring berasal dari provinsi', 'Sumatera Barat'),
(88, 'Provinsi di Indonesia yang masih memiliki sistem kerajaan adalah', 'Yogyakarta'),
(89, 'Saluran televisi nasional Indonesia adalah', 'TVRI'),
(90, 'Kode telepon negara Indonesia adalah', '+62'),
(91, 'Provinsi terkecil di Indonesia adalah provinsi', 'DKI Jakarta'),
(92, 'Tokoh emansipasi wanita Indonesia adalah', 'R.A. Kartini'),
(93, 'Buku populer yang diterbitkan oleh R.A. Kartini berjudul', 'Habis Gelap Terbitlah Terang'),
(94, 'Kadal terbesar di dunia yang terdapat di Indonesia adalah', 'Komodo'),
(95, 'Kota yang disebut sebagai kota pelajar adalah', 'Yogyakarta'),
(96, 'Penangkaran badak bercula satu di Indonesia terletak di', 'Ujung Kulon'),
(97, 'Penulis novel "Laskar Pelangi" adalah', 'Andrea Hirata'),
(98, 'Kata dasar dari kata "menyontek" adalah', 'Sontek'),
(99, 'Soekarno-Hatta pernah diasingkan untuk menghindari pengaruh Jepang ke', 'Rengasdengklok'),
(100, 'Warna seragam murid sekolah dasar di Indonesia adalah', 'Putih Merah'),
(101, 'Mie instan yang paling populer di Indonesia adalah', 'Indomie'),
(102, 'Satelit telekomunikasi Indonesia adalah satelit', 'Palapa'),
(103, 'Motto negara Indonesia adalah', 'Bhinneka Tunggal Ika'),
(104, 'Maskapai penerbangan nasional Indonesia adalah', 'Garuda Indonesia'),
(105, 'PT yang menyediakan jasa telekomunikasi di Indonesia adalah', 'Telkom'),
(106, 'Pahlawan yang terdapat di uang kertas 5000 adalah', 'Imam Bonjol'),
(107, 'Tahun berapakah masa Orde Baru berakhir?', '1998'),
(108, 'Ada berapakah provinsi di Pulau Jawa?', '6');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `nama` varchar(100) NOT NULL,
  `ip_address` varchar(50) NOT NULL,
  `tanggal_waktu` varchar(50) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`nama`, `ip_address`, `tanggal_waktu`, `score`) VALUES
('Vero', '/192.168.1.105:14984', '2016/12/08 18:03:52', 100),
('Elisa', '/192.168.1.105:14989', '2016/12/08 18:04:21', 300),
('Sherry', '/192.168.1.105:14995', '2016/12/08 18:05:36', 400),
('Vero', '/192.168.1.105:15000', '2016/12/08 18:05:55', 200),
('Vero', '/192.168.1.105:15005', '2016/12/08 18:06:43', 500),
('abc', '/192.168.1.105:15008', '2016/12/08 18:07:42', 100),
('Vero', '/192.168.1.105:17168', '2016/12/08 19:09:56', 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
