package kelas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {

    @FXML
    private TextField namaField, hargaField;

    @FXML
    private ComboBox<String> kategoriBox;

    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;

    @FXML
    private void initialize() {

        kategoriBox.getItems().addAll("Makanan", "Minuman");
        kategoriBox.setValue("Makanan");

    }

    public void setKonteks(Navigator navigator, DataProduk data) {

        this.navigator = navigator;
        this.data = data;

    }

    @FXML
    private void simpan() {

        Produk p;

        try {

            String nama = namaField.getText();
            String kategori = kategoriBox.getValue();

            double harga = Double.parseDouble(
                    hargaField.getText().trim()
            );

            p = data.tambah(nama, kategori, harga);

        } catch (NumberFormatException e) {

            pesanLabel.setText("Harga harus berupa angka yang valid.");
            return;

        } catch (IllegalArgumentException e) {

            pesanLabel.setText(e.getMessage());
            return;

        }

        try {

            navigator.bukaDetail(p);

        } catch (IOException e) {

            data.hapus(p);

            pesanLabel.setText(
                    "Halaman detail gagal dibuka. Periksa FXML."
            );

            e.printStackTrace();

        }
    }

    @FXML
    private void bukaDaftar() {

        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar.");
            e.printStackTrace();
        }
    }
}