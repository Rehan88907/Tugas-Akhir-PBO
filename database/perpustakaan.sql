CREATE DATABASE IF NOT EXISTS perpustakaan;
USE perpustakaan;

CREATE TABLE buku (
    id INT PRIMARY KEY AUTO_INCREMENT,
    judul VARCHAR(100),
    pengarang VARCHAR(100),
    tahun INT,
    stok INT
);

CREATE TABLE anggota (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(100),
    alamat VARCHAR(255),
    notelp VARCHAR(20)
);

CREATE TABLE petugas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(100),
    username VARCHAR(50),
    password VARCHAR(100)
);

CREATE TABLE peminjaman (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_anggota INT,
    id_buku INT,
    id_petugas INT,
    tgl_pinjam DATE,
    tgl_kembali DATE,
    FOREIGN KEY (id_anggota) REFERENCES anggota(id),
    FOREIGN KEY (id_buku) REFERENCES buku(id),
    FOREIGN KEY (id_petugas) REFERENCES petugas(id)
);
