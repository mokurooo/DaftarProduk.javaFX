# Aplikasi Daftar Produk Toko

Aplikasi desktop sederhana berbasis JavaFX yang digunakan untuk mengelola dan menampilkan daftar produk toko. Aplikasi ini dikembangkan dengan memodifikasi proyek praktikum sebelumnya, dengan mempertahankan struktur program dan pola kode yang telah dipelajari.
Aplikasi ini membantu pengguna mencatat informasi produk toko secara sederhana. Setiap produk memiliki kode produk, nama, kategori, dan harga.
Tampilan aplikasi menggunakan tema warna biru dengan antarmuka yang sederhana agar mudah digunakan.

## Fitur Utama

- **Tambah Produk** — Menambahkan produk baru melalui formulir.
- **Daftar Produk** — Menampilkan seluruh produk dalam tabel.
- **Pencarian Produk** — Mencari produk berdasarkan nama.
- **Detail Produk** — Melihat informasi lengkap dari produk yang dipilih.
- **Validasi Input** — Memastikan nama produk tidak kosong dan harga harus lebih dari nol.


## Teknologi

- Java
- JavaFX
- FXML
- CSS
- NetBeans IDE
- Scene Builder

## 📂 Struktur Proyek

```text
src/
└── kelas/
    ├── MainApp.java
    ├── Navigator.java
    ├── controller/
    │   ├── DaftarController.java
    │   ├── DetailController.java
    │   └── FormController.java
    ├── data/
    │   └── DataProduk.java
    ├── model/
    │   └── Produk.java
    ├── daftar.fxml
    ├── detail.fxml
    ├── form.fxml
    └── styles/
        └── app.css
```

##  Cara Menjalankan

1. Clone atau download repository ini.
2. Buka NetBeans IDE.
3. Pilih **File → Open Project**.
4. Cari dan buka folder proyek.
5. Pastikan konfigurasi JavaFX sudah tersedia.
6. Jalankan file MainApp.java.
7. Aplikasi akan menampilkan halaman utama untuk mengelola produk.

## Tampilan Aplikasi

Tambahkan screenshot aplikasi pada bagian berikut:

### Halaman Daftar Produk
<img width="674" height="527" alt="image" src="https://github.com/user-attachments/assets/8941bf39-fb5b-43b9-85c6-0247db23d687" />


### Halaman Form Produk
<img width="675" height="529" alt="image" src="https://github.com/user-attachments/assets/ac8c1720-fa27-4342-b5ba-c9d4d73f2333" />


### Halaman Detail Produk
<img width="674" height="400" alt="image" src="https://github.com/user-attachments/assets/217ea19a-75ac-4405-92ff-dd61df40c20a" />


---

**Dikembangkan untuk keperluan pembelajaran — Mekatronika dan Kecerdasan Buatan.**
