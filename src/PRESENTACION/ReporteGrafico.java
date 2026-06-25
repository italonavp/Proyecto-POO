package PRESENTACION;

import ALGORITMO.ArbolDecision;
import MODELO.Registro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Dashboard de Business Intelligence para visualización de predicciones.
 */
public class ReporteGrafico extends javax.swing.JInternalFrame {

    private final List<Registro> todosLosDatos;
    private final ArbolDecision miArbol;
    private JComboBox<String> comboPaises;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
        
    public ReporteGrafico(int vn, int fp, int fn, int vp, double accuracy, List<Registro> todosLosDatos, ArbolDecision miArbol) {
        this.todosLosDatos = todosLosDatos;
        this.miArbol = miArbol;

        setTitle("Business Intelligence Dashboard - Northwind Predictivo");
        setSize(1000, 600);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);

        JTabbedPane pestañas = new JTabbedPane();

        // Pestaña 1: Gráficos estadísticos
        JPanel panelRendimiento = new JPanel(new GridLayout(1, 3));
        panelRendimiento.add(crearPanelMatriz(vn, fp, fn, vp));
        panelRendimiento.add(crearPanelAccuracy(accuracy));
        panelRendimiento.add(crearPanelPaisesDemanda());
        pestañas.addTab("Métricas del Modelo", panelRendimiento);

        // Pestaña 2: Tabla interactiva
        pestañas.addTab("Explorador por País (Clientes Recomendados)", crearPanelExploradorPaises());
        
        add(pestañas);
    }
    
    // Gráfico de Barras - Matriz de Confusión
    private JPanel crearPanelMatriz(int vn, int fp, int fn, int vp) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(vn, "Acierto", "Real: NO / Pred: NO");
        dataset.addValue(vp, "Acierto", "Real: SÍ / Pred: SÍ");
        dataset.addValue(fp, "Error", "Real: NO / Pred: SÍ");
        dataset.addValue(fn, "Error", "Real: SÍ / Pred: NO");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Evaluación de Predicciones", "Escenario", "Clientes",
                dataset, org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true, false
        );
        return new ChartPanel(barChart);
    }

    // Gráfico de Pastel - Accuracy
    private JPanel crearPanelAccuracy(double accuracy) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Correctas (" + String.format("%.2f", accuracy) + "%)", Double.valueOf(accuracy));
        dataset.setValue("Error (" + String.format("%.2f", 100 - accuracy) + "%)", Double.valueOf(100 - accuracy));

        JFreeChart pieChart = ChartFactory.createPieChart("Precisión General", dataset, true, true, false);
        return new ChartPanel(pieChart);
    }
    
    // Gráfico de Pastel - Demanda Geográfica
    private JPanel crearPanelPaisesDemanda() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Integer> conteoPaises = new HashMap<>();

        for (Registro r : todosLosDatos) {
            if (miArbol.predict(r) == 1) {
                conteoPaises.put(r.getPaisCliente(), conteoPaises.getOrDefault(r.getPaisCliente(), 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : conteoPaises.entrySet()) {
            dataset.setValue(entry.getKey() + " (" + entry.getValue() + ")", Double.valueOf(entry.getValue()));
        }

        JFreeChart pieChart = ChartFactory.createPieChart("Origen de Clientes Potenciales", dataset, true, true, false);
        return new ChartPanel(pieChart);
    }

    // Panel de filtro por país con JComboBox
    private JPanel crearPanelExploradorPaises() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelControl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelControl.add(new JLabel("Seleccione un País para ver clientes con alta probabilidad de recompra: "));
        
        comboPaises = new JComboBox<>();
        List<String> listaPaises = new ArrayList<>();
        
        for (Registro r : todosLosDatos) {
            if (miArbol.predict(r) == 1 && !listaPaises.contains(r.getPaisCliente())) {
                listaPaises.add(r.getPaisCliente());
            }
        }
        Collections.sort(listaPaises);
        for (String pais : listaPaises) {
            comboPaises.addItem(pais);
        }
        panelControl.add(comboPaises);
        panelPrincipal.add(panelControl, BorderLayout.NORTH);

        // Configuración de tabla (solo lectura)
        modeloTabla = new DefaultTableModel(new Object[]{"ID CLIENTE", "PAÍS", "CATEGORÍA INTERÉS", "PREDICCIÓN"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tablaClientes = new JTable(modeloTabla);

        // Renderizador para separar visualmente a los clientes por bloques
        tablaClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    c.setBackground(table.getBackground());
                }

                // Detectar si la fila actual es el final del bloque de un cliente
                boolean esFinDeBloque = false;
                if (row == table.getRowCount() - 1) {
                    esFinDeBloque = true;
                } else {
                    String clienteActual = table.getValueAt(row, 0).toString();
                    String clienteSiguiente = table.getValueAt(row + 1, 0).toString();
                    if (!clienteActual.equals(clienteSiguiente)) {
                        esFinDeBloque = true;
                    }
                }

                // Aplicar una línea divisoria gris más marcada al terminar un cliente
                if (esFinDeBloque) {
                    ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(170, 170, 170)));
                } else {
                    ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
                }

                return c;
            }
        });
        
        panelPrincipal.add(new JScrollPane(tablaClientes), BorderLayout.CENTER);
        
        comboPaises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTablaPorPais();
            }
        });

        if (comboPaises.getItemCount() > 0) {
            actualizarTablaPorPais();
        }

        return panelPrincipal;
    }

    // Filtra, ordena alfabéticamente y recarga la tabla según el país seleccionado
    private void actualizarTablaPorPais() {
        modeloTabla.setRowCount(0); 
        String paisSeleccionado = (String) comboPaises.getSelectedItem();

        if (paisSeleccionado == null) return;

        List<Registro> registrosFiltrados = new ArrayList<>();
        for (Registro r : todosLosDatos) {
            if (r.getPaisCliente().equals(paisSeleccionado) && miArbol.predict(r) == 1) {
                registrosFiltrados.add(r);
            }
        }

        Collections.sort(registrosFiltrados, (r1, r2) -> r1.getIdCliente().compareTo(r2.getIdCliente()));

        for (Registro r : registrosFiltrados) {
            modeloTabla.addRow(new Object[]{
                r.getIdCliente(), 
                r.getPaisCliente(), 
                r.getNombreCategoria(), 
                "🔥 ALTA RECOMPRA"
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
