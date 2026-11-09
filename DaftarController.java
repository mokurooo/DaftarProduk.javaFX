package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {

    @FXML
    private TableView<Produk> tabel;

    @FXML
    private TableColumn<Produk, String> kodeCol;

    @FXML
    private TableColumn<Produk, String> namaCol;

    @FXML
    private TableColumn<Produk, String> kategoriCol;

    @FXML
    private TableColumn<Produk, Double> hargaCol;

    @FXML
    private TextField cariField;

    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;

    private final ObservableList<Produk> dataTampilan
            = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        PropertyValueFactory<Produk, String> sumberKode
                = new PropertyValueFactory<>("kode");

        kodeCol.setCellValueFactory(sumberKode);

        PropertyValueFactory<Produk, String> sumberNama
                = new PropertyValueFactory<>("nama");

        namaCol.setCellValueFactory(sumberNama);

        PropertyValueFactory<Produk, String> sumberKategori
                = new PropertyValueFactory<>("kategori");

        kategoriCol.setCellValueFactory(sumberKategori);

        PropertyValueFactory<Produk, Double> sumberHarga
                = new PropertyValueFactory<>("harga");

        hargaCol.setCellValueFactory(sumberHarga);

        hargaCol.setCellFactory(column -> new TableCell<Produk, Double>() {
            @Override
            protected void updateItem(Double harga, boolean empty) {
                super.updateItem(harga, empty);

                if (empty || harga == null) {
                    setText(null);
                } else {
                    setText(NumberFormat.getCurrencyInstance(
                            Locale.forLanguageTag("id-ID")
                    ).format(harga));
                }
            }
        });

        tabel.setItems(dataTampilan);
        tabel.setPlaceholder(new Label("Belum ada data produk."));

    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
        cari();
    }

    @FXML
    private void cari() {

        if (data == null) {
            return;
        }

        dataTampilan.clear();

        String kata = cariField.getText().trim().toLowerCase(Locale.ROOT);

        for (Produk produk : data.getDaftar()) {

            String nama = produk.getNama().toLowerCase(Locale.ROOT);

            if (nama.contains(kata)) {
                dataTampilan.add(produk);
            }
        }

        pesanLabel.setText(
                "Jumlah produk yang tampil: " + dataTampilan.size()
        );
    }

    @FXML
    private void tambah() {

        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Form gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void detail() {

        Produk produk = tabel.getSelectionModel().getSelectedItem();

        if (produk == null) {
            pesanLabel.setText("Pilih satu produk dahulu.");
            return;
        }

        try {
            navigator.bukaDetail(produk);
        } catch (IOException e) {
            pesanLabel.setText("Detail gagal dibuka.");
            e.printStackTrace();
        }
    }
}