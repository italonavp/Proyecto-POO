package Markov;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.Locale;

public class FormMarkov extends JInternalFrame {

    private JComboBox<String> cmbProducto;
    private JTable tblResultados;
    private DefaultTableModel modeloTabla;
    private JButton btnAnalizar;
    private JLabel lblTitulo, lblInfo;
    private MarkovChain cadenaMarkov;
    private MarkovDAO dao;

    public FormMarkov() {
        dao = new MarkovDAO();
        initComponents();
        cargarDatos();
    }

    private void initComponents() {
        setTitle("Análisis de Cadena de Markov - Northwind");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ── Panel Norte ──
        JPanel pnlNorte = new JPanel(new BorderLayout());
        lblTitulo = new JLabel("Cadena de Markov - Predicción de Compras", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        lblInfo = new JLabel("Selecciona un producto para ver qué se compra después", JLabel.CENTER);
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblInfo.setForeground(Color.GRAY);

        pnlNorte.add(lblTitulo, BorderLayout.NORTH);
        pnlNorte.add(lblInfo, BorderLayout.SOUTH);

        // ── Panel Control ──
        JPanel pnlControl = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        pnlControl.setBorder(BorderFactory.createTitledBorder("Producto de origen"));

        cmbProducto = new JComboBox<>();
        cmbProducto.setPreferredSize(new Dimension(280, 30));
        cmbProducto.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        btnAnalizar = new JButton("Analizar");
        btnAnalizar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAnalizar.setBackground(new Color(52, 152, 219));
        btnAnalizar.setForeground(Color.WHITE);
        btnAnalizar.setFocusPainted(false);
        btnAnalizar.addActionListener(e -> analizarTransiciones());

        pnlControl.add(new JLabel("Producto:"));
        pnlControl.add(cmbProducto);
        pnlControl.add(btnAnalizar);

        // ── Tabla de resultados ──
        String[] columnas = {"Producto Origen", "Producto Siguiente", "Probabilidad", "Barra Visual"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };

        tblResultados = new JTable(modeloTabla);
        tblResultados.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tblResultados.setRowHeight(28);
        tblResultados.getColumnModel().getColumn(3).setCellRenderer(new BarraRenderer());

        JScrollPane scroll = new JScrollPane(tblResultados);
        scroll.setBorder(BorderFactory.createTitledBorder("Probabilidades de transición"));

        // ── Ensamblar ──
        JPanel pnlCentro = new JPanel(new BorderLayout());
        pnlCentro.add(pnlControl, BorderLayout.NORTH);
        pnlCentro.add(scroll, BorderLayout.CENTER);

        add(pnlNorte, BorderLayout.NORTH);
        add(pnlCentro, BorderLayout.CENTER);
    }

    private void cargarDatos() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            cadenaMarkov = dao.construirCadenaMarkov();
            List<String> productos = dao.obtenerProductos();
            for (String p : productos) {
                cmbProducto.addItem(p);
            }
            lblInfo.setText("Modelo cargado con " + productos.size() + " productos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando datos: " + e.getMessage());
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    private void analizarTransiciones() {
        String productoSeleccionado = (String) cmbProducto.getSelectedItem();
        if (productoSeleccionado == null) return;

        modeloTabla.setRowCount(0);
        List<String[]> recomendaciones = cadenaMarkov.obtenerRecomendaciones(productoSeleccionado, 10);

        if (recomendaciones.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No hay datos de transición para: " + productoSeleccionado);
            return;
        }

        for (String[] rec : recomendaciones) {
            double valor = Double.parseDouble(rec[1].replace("%", "").replace(",", "."));
            modeloTabla.addRow(new Object[]{productoSeleccionado, rec[0], rec[1], valor});
        }
    }

    // ── Renderer barra de progreso ──
    static class BarraRenderer extends JProgressBar implements TableCellRenderer {
        public BarraRenderer() {
            setMinimum(0);
            setMaximum(100);
            setStringPainted(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable t, Object val,
                boolean sel, boolean foc, int row, int col) {
            int v = val instanceof Double ? ((Double) val).intValue() : 0;
            setValue(v);
            setString(v + "%");
            setForeground(v > 50 ? new Color(39, 174, 96) : new Color(52, 152, 219));
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormMarkov().setVisible(true));
    }
}