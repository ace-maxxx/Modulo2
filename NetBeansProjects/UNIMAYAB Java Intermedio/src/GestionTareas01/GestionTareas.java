package GestionTareas01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GestionTareas extends JFrame implements ActionListener {

    // Creacion de variables para cada componenente
    private JList<String> listaTareas;
    private DefaultListModel<String> modeloLista;
    private JTable tablaAreas;
    private DefaultTableModel modeloTabla;
    private JTree arbolCategorias;
    private DefaultMutableTreeNode raizArbol;
    private JMenuBar barraMenu;
    private JMenu menuArchivo, menuTarea;
    private JMenuItem menuItemAgregar, menuItemEditar, menuItemEliminar, menuItemCompletar;
    private JToolBar barraHerramientas;
    private JButton botonAgregar, botonEditar, botonEliminar, botonCompletar;

    private List<Tarea> tareas;
    private Map<String, Lista<Tarea>> tareasPorCategoria;

    // Crear constructor de la clase GestionTareas
    public GestionTareas() {
        setTitle("Gestion de tareas");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar la lista de tareas
        tareas = new ArrayList<>();

        // Inicializar el mapa de tareas por categoria
        tareasPorCategoria = new HashMap<>();

        // Crear la JList
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        JScrollPane scrollPaneLista = new JScrollPane(listaTareas);
        add(scrollPaneLista, BorderLayout.WEST);

        // Crear la JTable
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Prioridad");
        modeloTabla.addColumn("Estado");
        tablaAreas = new JTable(modeloTabla);
        JScrollPane scrollPaneTabla = new JScrollPane(tablaAreas);
        add(scrollPaneTabla, BorderLayout.CENTER);

        // Crear el JTree
        raizArbol = new DefaultMutableTreeNode("Categorias");
        arbolCategorias = new JTree(raizArbol);
        JScrollPane scrollPaneArbol = new JScrollPane(arbolCategorias);
        add(scrollPaneArbol, BorderLayout.EAST);

        // Agregar un listener para el JTree
        arbolCategorias.addTreeSelectionListener(e ->{
            DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) arbolCategorias.getLastSelectedPathComponent();
            if (nodoSeleccionado != null && nodoSeleccionado.isLeaf()) {
                String categoria = nodoSeleccionado.getUserObject().toString();
                mostrarTareasPorCategoria(categoria);
            } else {
                mostrarTodasLasTareas();
            }
        });

        // Crear el JMenuBar
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        menuArchivo = new JMenu("Archivo");
        barraMenu.add(menuArchivo);

        menuTarea = new JMenu("Tarea");
        barraMenu.add(menuTarea);

        menuItemAgregar = new JMenuItem("Agregar");
        menuItemAgregar.addActionListener(this::agregarTarea);
        menuTarea.add(menuItemAgregar);

        menuItemEditar = new JMenuItem("Editar");
        menuItemEditar.addActionListener(this::editarTarea);
        menuTarea.add(menuItemEditar);

        menuItemEliminar = new JMenuItem("Eliminar");
        menuItemEliminar.addActionListener(this::eliminarTarea);
        menuTarea.add(menuItemEliminar);

        menuItemCompletar = new JMenuItem("Completar");
        menuItemCompletar.addActionListener(this::completarTarea);
        menuTarea.add(menuItemCompletar);

        // Crear la JToolbar
        barraHerramientas = new JToolBar();
        add(barraHerramientas, BorderLayout.NORTH);

        botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(this::agregarTarea);
        barraHerramientas.add(botonAgregar);

        botonEditar = new JButton("Editar");
        botonEditar.addActionListener(this::editarTarea);
        barraHerramientas.add(botonEditar);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(this::eliminarTarea);
        barraHerramientas.add(botonEliminar);

        botonCompletar = new JButton("Completar");
        botonCompletar.addActionListener(this::completarTarea);
        barraHerramientas.add(botonCompletar);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    // Metodos para agregar, editar, eliminar y completar tareas:
    private void agregarTarea(ActionEvent e) {
        JTextField nombreField = new JTextField();
        JTextArea descripcionArea = new JTextArea();
        JComboBox<String> prioridadCombo = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});
        JComboBox<String> categoriaCombo = new JComboBox<>(new String[]{"Trabajo", "Personal", "Estudios"});
        Object[] message = {
                "Nombre:", nombreField,
                "Descripcion:", descripcionArea,
                "Prioridad:", prioridadCombo,
                "Categoria:", categoriaCombo
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Agregar tarea", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText();
            String descripcion = descripcionArea.getText();
            String prioridad = (String) prioridadCombo.getSelectedItem();
            String categoria = (String) categoriaCombo.getSelectedItem();

            // Agregar la categoria a la lista de categorias si no existe
            if (!tareasPorCategoria.containsKey(categoria)) {
                tareasPorCategoria.put(categoria, new ArrayList<>());
                DefaultMutableTreeNode nodoCategoria = new DefaultMutableTreeNode(categoria);
                raizArbol.add(nodoCategoria);
                ((DefaultTreeModel) arbolCategorias.getModel()).reload();
            }

            Tarea nuevaTarea = new Tarea(nombre, descripcion, prioridad, categoria);
            tareas.add(nuevaTarea);
            tareasPorCategoria.get(categoria).add(nuevaTarea);

            actualizarListaTareas();
            actualizarTablaTareas();
        }
    }

    // Codigo para editar tareas

    private void editarTarea(ActionEvent e) {
        int indiceSeleccionado = listaTareas.getSelectedIndex();
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para editar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Tarea tareaSeleccionada = tareas.get(indiceSeleccionado);
        JTextField nombreField = new JTextField(tareaSeleccionada.getNombre());
        JTextArea descripcionArea = new JTextArea(tareaSeleccionada.getDescripcion());
        JComboBox<String> prioridadCombo = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});
        prioridadCombo.setSelectedItem(tareaSeleccionada.getPrioridad());
        JComboBox<String> categoriaCombo = new JComboBox<>(new String[]{"Trabajo", "Personal", "Estudios"});
        categoriaCombo.setSelectedItem(tareaSeleccionada.getCategoria());
        Object[] message = {
                "Nombre:", nombreField,
                "Descripcion:", descripcionArea,
                "Prioridad", prioridadCombo,
                "Categoria", categoriaCombo
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Editar tarea", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Actualizar la categoria de la tarea si es necesario
            String categoriaAnterior = tareaSeleccionada.getCategoria();
            String nuevaCategoria = (String) categoriaCombo.getSelectedItem();
            if (!categoriaAnterior.equals(nuevaCategoria)) {
                tareasPorCategoria.get(categoriaAnterior).remove(tareaSeleccionada);
                if (!tareasPorCategoria.containsKey(nuevaCategoria)) {
                    tareasPorCategoria.put(nuevaCategoria, new ArrayList<>());
                    DefaultMutableTreeNode nodoCategoria = new DefaultMutableTreeNode(nuevaCategoria);
                    raizArbol.add(nodoCategoria);
                    ((DefaultTreeModel) arbolCategorias.getModel()).reload();
                }
                tareasPorCategoria.get(nuevaCategoria).add(tareaSeleccionada);
                tareaSeleccionada.setCategoria(nuevaCategoria);
            }

            tareaSeleccionada.setNombre(nombreField.getText());
            tareaSeleccionada.setDescripcion(descripcionArea.getText());
            tareaSeleccionada.setPrioridad((String)prioridadCombo.getSelectedItem());
            actualizarListaTareas();
        }
    }
    // Codigo para eliminar tareas
    private void eliminarTarea(ActionEvent e) {
        int indiceSeleccionado = listaTareas.getSelectedIndex();
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecccione una tarea para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la tarea?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            Tarea tareaSeleccionada = tareas.get(indiceSeleccionado);
            tareas.remove(tareaSeleccionada);
            tareasPorCategoria.get(tareaSeleccionada.getCategoria()).remove(tareaSeleccionada);
            actualizarListaTareas();
            actualizarTablaTareas();
        }
    }

    // Codigo para completar tareas
    private void completarTarea(ActionEvent e) {
        int indiceSeleccionado = listaTareas.getSelectedIndex();
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para completar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Tarea tareaSeleccionada = tareas.get(indiceSeleccionado);
        tareaSeleccionada.setEstado("Completada");
        actualizarListaTareas();
        actualizarTablaTareas();

    }

    // Main
    public static void main(String[] args) {
        new GestionTareas();
    }


}

class Tarea {
    private String nombre;
    private String descripcion;
    private String prioridad;
    private String estado;
    private String categoria;

    // Constructor
    public Tarea(String nombre, String descripcion, String prioridad, String estado, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.categoria = categoria;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}


