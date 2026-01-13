/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laporan;
import java.sql.Connection;
import configDB.koneksi;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author ACER
 */
public class LaporanTenagaKesehatan {
    public static void cetak() {
        try {
            Connection conn = koneksi.getConnection();

            String path = "src/laporan/LaporanTenagaKesehatan.jasper";

            HashMap<String, Object> parameter = new HashMap<>();

            JasperPrint jp = JasperFillManager.fillReport(
                    path,
                    parameter,
                    conn
            );

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Gagal mencetak laporan: " + e.getMessage()
            );
        }
    }
}
