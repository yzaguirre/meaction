/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 03 de septiembre 2011, 5:48PM
 */

/*
 * TableroEdit_GUI.java
 *
 * Created on 3/09/2011, 05:48:38 PM
 */
package gui;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
import gameworld.actors.*;
import analisis.*;
/*
 * Es el tablero a editar
 * @(#)TableroEdit_GUI.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */

public class TableroEdit_GUI extends javax.swing.JFrame {
    private final static String DOCLAYOUT = "<escenarios background=%s;>\n<personajes>\n<heroes>\n%s</heroes>\n<villanos>\n%s</villanos>\n</personajes>\n<paredes>\n%s</paredes>\n<extras>\n<armas>\n%s</armas>\n<bonus>\n%s</bonus>\n</extras>\n<meta>\n%s</meta>\n</escenario>";
    private final static String POSICION = "\t%s(%d,%d);\n";
    private gameworld.Box currentSelectedActor;
    /**Listas que guardaran objetos de la tabla de simbolos por tipo**/
    private HashMap<String, gameworld.Box> tablasimbolos;
    
    private ArrayList<Heroe> heroes;
    private ArrayList<Villano> villanos;
    private ArrayList<Arma> armas;
    private ArrayList<Bloque> bloques;
    private ArrayList<Bonus> bonusses;
    private ArrayList<Bomba> bombas;
    private ArrayList<Meta> metas;
    private ArrayList<Background> backgrounds;
    
    private ArrayList<String> XNombreheroes, XNombrevillanos, XNombrearmas, XNombrebloques, XNombrebonusses, XNombrebombas, XNombremetas, XNombrebackgrounds;
    
    private AbstractListModel almHeroes, almVillanos, almArmas, almBloques, almBonusses, almBombas, almMetas, almBackgrounds;
    private static final AbstractListModel nothing = new AbstractListModel(){

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public Object getElementAt(int index) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    };
    /**Esta sera la estructura que garantiza que solo un actor Box se podra guardar en determinada posicion**/
    gameworld.Box[][] actoresMat;
    
    public TableroEdit_GUI() {
        initComponents();
        addKeyListener(tableroMatriz1);
        heroes = new ArrayList<>();
        villanos = new ArrayList<>();
        armas = new ArrayList<>();
        bloques = new ArrayList<>();
        bonusses = new ArrayList<>();
        bombas = new ArrayList<>();
        metas = new ArrayList<>();
        backgrounds = new ArrayList<>();
        
        XNombreheroes = new ArrayList<>();
        XNombrevillanos = new ArrayList<>();
        XNombrearmas = new ArrayList<>();
        XNombrebloques = new ArrayList<>();
        XNombrebonusses = new ArrayList<>();
        XNombrebombas = new ArrayList<>();
        XNombremetas = new ArrayList<>();
        XNombrebackgrounds = new ArrayList<>();
    }
    /**
     * Primer paso es guardar la tabla de simbolos
     * a partir de él guardamos las listas
     * @param 
     **/
    public void setTabla(TablaSimbolos ts){
        tablasimbolos = ts.getTabla();
    }
    
    /**
     * Inicializa las listas (o borra informacion previamente guardadas)
     ***/
    public void clearLists(){
        heroes.clear();
        villanos.clear();
        armas.clear();
        bloques.clear();
        bonusses.clear();
        bombas.clear();
        metas.clear();
        backgrounds.clear();
        
        XNombreheroes.clear();
        XNombrevillanos.clear();
        XNombrearmas.clear();
        XNombrebloques.clear();
        XNombrebonusses.clear();
        XNombrebombas.clear();
        XNombremetas.clear();
        XNombrebackgrounds.clear();
        actoresMat = new gameworld.Box[20][20];
    }

    /**
     * Agrupo los elementos de la tabla de simbolos en Listas por tipo actor
     **/
    public void sortLists(){
        Collection<gameworld.Box> coll = tablasimbolos.values();
        for (gameworld.Box b : coll){
            if (b instanceof Heroe) {
                heroes.add((Heroe)b);
                XNombreheroes.add(b.getX_nombre());
            } else if (b instanceof Villano) {
                villanos.add((Villano)b);
                XNombrevillanos.add(b.getX_nombre());
            } else if (b instanceof Arma) {
                armas.add((Arma)b);
                XNombrearmas.add(b.getX_nombre());
            } else if (b instanceof Bloque) {
                bloques.add((Bloque)b);
                XNombrebloques.add(b.getX_nombre());
            } else if (b instanceof Bonus) {
                bonusses.add((Bonus)b);
                XNombrebonusses.add(b.getX_nombre());
            } else if (b instanceof Bomba) {
                bombas.add((Bomba)b);
                XNombrebombas.add(b.getX_nombre());
            } else if (b instanceof Meta) {
                metas.add((Meta)b);
                XNombremetas.add(b.getX_nombre());
            } else if (b instanceof Background) {
                backgrounds.add((Background)b);
                XNombrebackgrounds.add(b.getX_nombre());
            }
        }
        almHeroes = initListModel(XNombreheroes);
        almVillanos = initListModel(XNombrevillanos);
        almArmas = initListModel(XNombrearmas);
        almBloques = initListModel(XNombrebloques);
        almBonusses = initListModel(XNombrebonusses);
        almBombas = initListModel(XNombrebombas);
        almMetas = initListModel(XNombremetas);
        almBackgrounds = initListModel(XNombrebackgrounds);
        
    }
    /**Utilizado para inicializar JList con x-nombre
     * @param nombres Array de nombres de un mismo x-tipo
     * @return la ListModel para un JList
     **/
    private AbstractListModel initListModel(final ArrayList<String> nombres){
        return new AbstractListModel(){
            final int max = nombres.size();
            public int getSize(){
                return max;
            }
            public Object getElementAt(int i){
                return nombres.get(i);
            }
        };
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tableroMatriz1 = new gameworld.TableroMatriz();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfXImagen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfXNombre = new javax.swing.JTextField();
        jlXImagen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfXDescripcion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbTipos = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jbAsignar = new javax.swing.JButton();
        jtfXDestruir = new javax.swing.JTextField();
        jtfXVida = new javax.swing.JTextField();
        jtfXAlcance = new javax.swing.JTextField();
        jtfXCreditos = new javax.swing.JTextField();
        jtfXUso = new javax.swing.JTextField();
        jtfXColor = new javax.swing.JTextField();
        jsPosI = new javax.swing.JSpinner();
        jsPosJ = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlListaTipo = new javax.swing.JList();
        Remover = new javax.swing.JButton();
        jbVolverAComenzar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();
        jcbDrawCuadricula = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JBadMeth - Scene Edit");
        setBounds(new java.awt.Rectangle(70, 15, 1200, 720));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("gui/acercade/Circle_Blue.png")).getImage() );
        setMinimumSize(new java.awt.Dimension(1200, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tableroMatriz1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableroMatriz1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tableroMatriz1Layout = new javax.swing.GroupLayout(tableroMatriz1);
        tableroMatriz1.setLayout(tableroMatriz1Layout);
        tableroMatriz1Layout.setHorizontalGroup(
            tableroMatriz1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        tableroMatriz1Layout.setVerticalGroup(
            tableroMatriz1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Datos Actor");
        jLabel1.setFocusable(false);
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 23, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("x-imagen");
        jLabel2.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 10);
        jPanel1.add(jLabel2, gridBagConstraints);

        jtfXImagen.setEditable(false);
        jtfXImagen.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 10);
        jPanel1.add(jtfXImagen, gridBagConstraints);

        jLabel3.setText("x-nombre");
        jLabel3.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 10);
        jPanel1.add(jLabel3, gridBagConstraints);

        jtfXNombre.setEditable(false);
        jtfXNombre.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 10);
        jPanel1.add(jtfXNombre, gridBagConstraints);

        jlXImagen.setFocusable(false);
        jlXImagen.setMaximumSize(new java.awt.Dimension(50, 50));
        jlXImagen.setMinimumSize(new java.awt.Dimension(32, 32));
        jlXImagen.setOpaque(true);
        jlXImagen.setPreferredSize(new java.awt.Dimension(32, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 10);
        jPanel1.add(jlXImagen, gridBagConstraints);

        jLabel4.setText("x-descripción");
        jLabel4.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 10);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("x-destruir");
        jLabel5.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 0, 15);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setText("x-vida");
        jLabel6.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 1, 10);
        jPanel1.add(jLabel6, gridBagConstraints);

        jtfXDescripcion.setEditable(false);
        jtfXDescripcion.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 10);
        jPanel1.add(jtfXDescripcion, gridBagConstraints);

        jLabel12.setText("x-alcance");
        jLabel12.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 15);
        jPanel1.add(jLabel12, gridBagConstraints);

        jLabel13.setText("x-uso");
        jLabel13.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 15);
        jPanel1.add(jLabel13, gridBagConstraints);

        jLabel7.setText("x-creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 1, 10);
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel8.setText("x-color");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 1, 10);
        jPanel1.add(jLabel8, gridBagConstraints);

        jcbTipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "x-arma", "x-background", "x-bloque", "x-bonus", "x-bomba", "x-heroe", "x-meta", "x-villano" }));
        jcbTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTiposActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jcbTipos, gridBagConstraints);

        jLabel9.setBackground(new java.awt.Color(255, 255, 153));
        jLabel9.setText(" Posición I ");
        jLabel9.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 1, 10);
        jPanel1.add(jLabel9, gridBagConstraints);

        jLabel10.setBackground(new java.awt.Color(255, 255, 153));
        jLabel10.setText(" Posición J ");
        jLabel10.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 1, 10);
        jPanel1.add(jLabel10, gridBagConstraints);

        jbAsignar.setText("Asignar");
        jbAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAsignarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        jPanel1.add(jbAsignar, gridBagConstraints);

        jtfXDestruir.setEditable(false);
        jtfXDestruir.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 10, 10);
        jPanel1.add(jtfXDestruir, gridBagConstraints);

        jtfXVida.setEditable(false);
        jtfXVida.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 10, 10);
        jPanel1.add(jtfXVida, gridBagConstraints);

        jtfXAlcance.setEditable(false);
        jtfXAlcance.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 10, 10);
        jPanel1.add(jtfXAlcance, gridBagConstraints);

        jtfXCreditos.setEditable(false);
        jtfXCreditos.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 10, 10);
        jPanel1.add(jtfXCreditos, gridBagConstraints);

        jtfXUso.setEditable(false);
        jtfXUso.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 10, 10);
        jPanel1.add(jtfXUso, gridBagConstraints);

        jtfXColor.setEditable(false);
        jtfXColor.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 10, 10);
        jPanel1.add(jtfXColor, gridBagConstraints);

        jsPosI.setModel(new javax.swing.SpinnerNumberModel(0, 0, 19, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        jPanel1.add(jsPosI, gridBagConstraints);

        jsPosJ.setModel(new javax.swing.SpinnerNumberModel(0, 0, 19, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        jPanel1.add(jsPosJ, gridBagConstraints);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(75, 60));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(75, 60));

        jlListaTipo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlListaTipo.setMaximumSize(new java.awt.Dimension(150, 25));
        jlListaTipo.setMinimumSize(new java.awt.Dimension(150, 25));
        jlListaTipo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlListaTipoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlListaTipo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        Remover.setText("Quitar");
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(Remover, gridBagConstraints);

        jbVolverAComenzar.setText("Volver a comenzar");
        jbVolverAComenzar.setToolTipText("Borra todo dentro de la matriz");
        jbVolverAComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAComenzarActionPerformed(evt);
            }
        });

        jbExportar.setText("Exportar Escenario");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        jcbDrawCuadricula.setText("Dibujar Cuadrícula");
        jcbDrawCuadricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDrawCuadriculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbExportar)
                        .addGap(299, 299, 299)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcbDrawCuadricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbVolverAComenzar)
                        .addContainerGap())
                    .addComponent(tableroMatriz1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tableroMatriz1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVolverAComenzar)
                    .addComponent(jbExportar)
                    .addComponent(jcbDrawCuadricula))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTiposActionPerformed
        String tipo = (String) jcbTipos.getSelectedItem();
        switch(tipo){
            case "x-heroe":
                jlListaTipo.setModel(almHeroes);
                break;
            case "x-villano":
                jlListaTipo.setModel(almVillanos);
                break;
            case "x-arma":
                jlListaTipo.setModel(almArmas);
                break;
            case "x-bloque":
                jlListaTipo.setModel(almBloques);
                break;
            case "x-bonus":
                jlListaTipo.setModel(almBonusses);
                break;
            case "x-bomba":
                jlListaTipo.setModel(almBombas);
                break;
            case "x-meta":
                jlListaTipo.setModel(almMetas);
                break;
            case "x-background":
                jlListaTipo.setModel(almBackgrounds);
                break;
        }
        vaciarDatosActor();
    }//GEN-LAST:event_jcbTiposActionPerformed

    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Fichero de entrada (*.xconf, *.txt)", "txt", "xconf");
        jfc.setFileFilter(fnef);
        jfc.setDialogTitle("Exportar Escenario");
        int aws = jfc.showSaveDialog(this);
        if (aws != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "No se ha exportado el escenario!", "Ojo!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        java.io.File saveFile = jfc.getSelectedFile();
        
        if (!fileops.FileRW.write(export(), saveFile)){
            JOptionPane.showMessageDialog(this, "Fallo en la escritura!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbExportarActionPerformed

    private void jbVolverAComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAComenzarActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, 
                "¿Seguro de vaciar el tablero?", 
                "Cierre", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION){
            tableroMatriz1.botarStage();
            tableroMatriz1.paint();
        }
    }//GEN-LAST:event_jbVolverAComenzarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int ans = JOptionPane.showConfirmDialog(this, 
                "¿Desea exportar antes de cerrar ventana?", 
                "Cierre", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION)
            export();
        tableroMatriz1.botarStage();
        jlListaTipo.setModel(nothing);
        vaciarDatosActor();
        
    }//GEN-LAST:event_formWindowClosing

    private void jbAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAsignarActionPerformed
        if (currentSelectedActor == null){return;}
        
        gameworld.Box actor = currentSelectedActor.clone();
        actor.setCoordenate((Integer)jsPosI.getValue(), (Integer)jsPosJ.getValue());
        java.awt.Point pIJ = actor.getPointsIJ();
        
        if (!(currentSelectedActor instanceof Background) && actoresMat[pIJ.x][pIJ.y] != null){
            int ans = JOptionPane.showConfirmDialog(this, 
                    "Desea sobreescribir el espacio?", 
                    "Cuadrito ocupado", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE);
            if (ans != JOptionPane.YES_OPTION) return;
            actoresMat[pIJ.x][pIJ.y].remove();
        }
        if (actor instanceof Background){
            actor.setCoordenate(0, 0);
            tableroMatriz1.setBackground((Background)actor);
            tableroMatriz1.paint();
            return;
        }
        actoresMat[pIJ.x][pIJ.y] = actor;
        switch((String)jcbTipos.getSelectedItem()){
            case "x-heroe":
                tableroMatriz1.setHeroe((Heroe) actor);
                break;
            case "x-villano":
                tableroMatriz1.addVillano((Villano) actor);
                break;
            case "x-arma":
                tableroMatriz1.addArma((Arma) actor);
                break;
            case "x-bloque":
                tableroMatriz1.addMuro((Bloque) actor);
                break;
            case "x-bonus":
                tableroMatriz1.addBonus((Bonus) actor);
                break;
            case "x-bomba":
                tableroMatriz1.addBomba((Bomba) actor);
                break;
            case "x-meta":
                tableroMatriz1.setMeta((Meta) actor);
                break;
        }
        tableroMatriz1.paint();
    }//GEN-LAST:event_jbAsignarActionPerformed

    private void jlListaTipoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlListaTipoValueChanged
        int indice = jlListaTipo.getSelectedIndex();
        if (indice < 0) return;
        String opt = (String)jcbTipos.getSelectedItem();
        switch(opt){
            case "x-heroe":
                llenarHeroe(heroes.get(indice));
                break;
            case "x-villano":
                llenarVillano(villanos.get(indice));
                break;
            case "x-arma":
                llenarArma(armas.get(indice));
                break;
            case "x-bloque":
                llenarBloque(bloques.get(indice));
                break;
            case "x-bonus":
                llenarBonus(bonusses.get(indice));
                break;
            case "x-bomba":
                llenarBomba(bombas.get(indice));
                break;
            case "x-meta":
                llenarMeta(metas.get(indice));
                break;
            case "x-background":
                llenarBackground(backgrounds.get(indice));
                break;
        }
    }//GEN-LAST:event_jlListaTipoValueChanged

    private void jcbDrawCuadriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDrawCuadriculaActionPerformed
        tableroMatriz1.setDrawCuadricula(jcbDrawCuadricula.isSelected());
    }//GEN-LAST:event_jcbDrawCuadriculaActionPerformed

    private void tableroMatriz1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableroMatriz1MouseClicked
        int i = evt.getY()/gameworld.Box.LENGTH, j = evt.getX()/gameworld.Box.LENGTH;
        jsPosI.setValue(i);
        jsPosJ.setValue(j);
    }//GEN-LAST:event_tableroMatriz1MouseClicked

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        int i = (Integer)jsPosI.getValue(), j = (Integer)jsPosJ.getValue();
        actoresMat[i][j].remove();
        actoresMat[i][j] = null;
        tableroMatriz1.paint();
    }//GEN-LAST:event_RemoverActionPerformed

    private void llenarHeroe(Heroe heroe){
        heroe.setStage(tableroMatriz1);
        Heroe h = (Heroe)heroe.clone();
        heroe.setStage(null);
        jtfXImagen.setText(h.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(h.getX_imagen())));
        jtfXNombre.setText(h.getX_nombre());
        jtfXDescripcion.setText(h.getX_descripcion());
        jtfXDestruir.setText(String.valueOf(h.getX_destruir()));
        jtfXVida.setText(String.valueOf(h.getX_vida()));
        jtfXAlcance.setText("NA");
        jtfXUso.setText("NA");
        jtfXCreditos.setText("NA");
        jtfXColor.setText("NA");
        currentSelectedActor = h;
    }
    private void llenarVillano(Villano villano){
        villano.setStage(tableroMatriz1);
        Villano v = (Villano)villano.clone();
        villano.setStage(null);
        jtfXImagen.setText(v.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(v.getX_imagen())));
        jtfXNombre.setText(v.getX_nombre());
        jtfXDescripcion.setText(v.getX_descripcion());
        jtfXDestruir.setText(String.valueOf(v.getX_destruir()));
        jtfXVida.setText(String.valueOf(v.getX_vida()));
        jtfXAlcance.setText("NA");
        jtfXUso.setText("NA");
        jtfXCreditos.setText("NA");
        jtfXColor.setText("NA");
        currentSelectedActor = v;
    }
    private void llenarArma(Arma arma){
        arma.setStage(tableroMatriz1);
        Arma a = (Arma)arma.clone();
        arma.setStage(null);
        jtfXImagen.setText(a.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(a.getX_imagen())));
        jtfXNombre.setText(a.getX_nombre());
        jtfXDescripcion.setText(a.getX_descripcion());
        jtfXDestruir.setText(String.valueOf(a.getX_destruir()));
        jtfXVida.setText("NA");
        jtfXAlcance.setText(String.valueOf(a.getX_alcance()));
        jtfXUso.setText(String.valueOf(a.getX_uso()));
        jtfXCreditos.setText("NA");
        jtfXColor.setText("NA");
        currentSelectedActor = a;
    }
    private void llenarBloque(Bloque bloque){
        bloque.setStage(tableroMatriz1);
        Bloque b = (Bloque)bloque.clone();
        bloque.setStage(null);
        jtfXImagen.setText(b.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(b.getX_imagen())));
        jlXImagen.setBackground(b.getX_color().getColor());
        jtfXNombre.setText(b.getX_nombre());
        jtfXDescripcion.setText(b.getX_descripcion());
        jtfXDestruir.setText("NA");
        jtfXVida.setText("NA");
        jtfXAlcance.setText("NA");
        jtfXUso.setText("NA");
        jtfXCreditos.setText("NA");
        jtfXColor.setText(b.getX_color().getDescripcion());
        currentSelectedActor = b;
    }
    private void llenarBonus(Bonus bonus){
        bonus.setStage(tableroMatriz1);
        Bonus b = (Bonus)bonus.clone();
        bonus.setStage(null);
        jtfXImagen.setText(b.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(b.getX_imagen())));
        jtfXNombre.setText(b.getX_nombre());
        jtfXDescripcion.setText(b.getX_descripcion());
        jtfXDestruir.setText("NA");
        jtfXVida.setText("NA");
        jtfXAlcance.setText("NA");
        jtfXUso.setText("NA");
        jtfXCreditos.setText(String.valueOf(b.getX_creditos()));
        jtfXColor.setText("NA");
        currentSelectedActor = b;
    }
    private void llenarBomba(Bomba bomba){
        bomba.setStage(tableroMatriz1);
        Bomba b = (Bomba)bomba.clone();
        bomba.setStage(null);
        jtfXImagen.setText(b.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(b.getX_imagen())));
        jtfXNombre.setText(b.getX_nombre());
        jtfXDescripcion.setText(b.getX_descripcion());
        jtfXDestruir.setText(String.valueOf(b.getX_destruir()));
        jtfXVida.setText("NA");
        jtfXAlcance.setText("NA");
        jtfXUso.setText("NA");
        jtfXCreditos.setText("NA");
        jtfXColor.setText("NA");
        currentSelectedActor = b;
    }
    private void llenarMeta(Meta meta){
        meta.setStage(tableroMatriz1);
        Meta m = (Meta)meta.clone();
        meta.setStage(null);
        jtfXImagen.setText(m.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(m.getX_imagen())));
        jtfXNombre.setText(m.getX_nombre());
        jtfXDescripcion.setText(m.getX_descripcion());
        jtfXDestruir.setText("NA");
        jtfXVida.setText("NA");
        jtfXAlcance.setText("NA");
        jtfXUso.setText("NA");
        jtfXCreditos.setText("NA");
        jtfXColor.setText("NA");
        currentSelectedActor = m;
    }
    private void llenarBackground(Background background){
        background.setStage(tableroMatriz1);
        Background b = (Background)background.clone();
        background.setStage(null);
        jtfXImagen.setText(b.getX_imagen());
        jlXImagen.setIcon(new ImageIcon(tableroMatriz1.imageCache.getSprite(b.getX_imagen())));
        jtfXNombre.setText(b.getX_nombre());
        jtfXDescripcion.setText(b.getX_descripcion());
        jtfXDestruir.setText("NA");
        jtfXVida.setText("NA");
        jtfXAlcance.setText("NA");
        jtfXUso.setText("NA");
        jtfXCreditos.setText("NA");
        jtfXColor.setText("NA");
        currentSelectedActor = b;
    }
    /***Limpia las casillas de los propiedades de un actor Box**/
    private void vaciarDatosActor(){
        jtfXImagen.setText("");
        jlXImagen.setIcon(null);
        jtfXNombre.setText("");
        jtfXDescripcion.setText("");
        jtfXDestruir.setText("0");
        jtfXVida.setText("0");
        jtfXAlcance.setText("0");
        jtfXUso.setText("0");
        jtfXCreditos.setText("0");
        jtfXColor.setText("");
        currentSelectedActor = null;
    }
    /**
     * Devuelve una cadena que representa la estructura actual del escenario
     * @return Estructura cualificada para un fichero de entrada Escenario
     **/
    public String export(){
        Background bg = tableroMatriz1.getBground();
        Heroe h = tableroMatriz1.getHeroe();
        Meta m = tableroMatriz1.getMeta();
        ArrayList<Arma> temparmas = tableroMatriz1.getArmas();
        ArrayList<Bomba> tempbombas = tableroMatriz1.getBombas();
        ArrayList<Bonus> tempbonusses = tableroMatriz1.getBonusses();
        ArrayList<Bloque> tempmuros = tableroMatriz1.getMuros();
        ArrayList<Villano> tempvillanos = tableroMatriz1.getVillanos();
        
        java.awt.Point pIJ;
        pIJ = h.getPointsIJ();
        String s_heroes = String.format(POSICION, h.getX_nombre(), pIJ.x, pIJ.y);
        
        StringBuilder s_villanos = new StringBuilder();
        for (Villano v: tempvillanos){
            pIJ = v.getPointsIJ();
            s_villanos.append(String.format(POSICION, v.getX_nombre(), pIJ.x, pIJ.y));
        }
        
        StringBuilder s_bloques = new StringBuilder();
        for (Bloque b: tempmuros){
            pIJ = b.getPointsIJ();
            s_bloques.append(String.format(POSICION, b.getX_nombre(), pIJ.x, pIJ.y));
        }
        
        StringBuilder s_armas = new StringBuilder();
        for (Arma a: temparmas){
            pIJ = a.getPointsIJ();
            s_armas.append(String.format(POSICION, a.getX_nombre(), pIJ.x, pIJ.y));
        }
        for (Bomba b: tempbombas){
            pIJ = b.getPointsIJ();
            s_armas.append(String.format(POSICION, b.getX_nombre(), pIJ.x, pIJ.y));
        }
        
        StringBuilder s_bonus = new StringBuilder();
        for (Bonus b: tempbonusses){
            pIJ = b.getPointsIJ();
            s_bonus.append(String.format(POSICION, b.getX_nombre(), pIJ.x, pIJ.y));
        }
        pIJ = m.getPointsIJ();
        String s_meta = String.format(POSICION, m.getX_nombre(), pIJ.x, pIJ.y);
        
        return String.format(DOCLAYOUT, bg.getX_nombre(), s_heroes, s_villanos.toString(), s_bloques.toString(), s_armas.toString(), s_bonus.toString(), s_meta);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Remover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAsignar;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbVolverAComenzar;
    private javax.swing.JCheckBox jcbDrawCuadricula;
    private javax.swing.JComboBox jcbTipos;
    private javax.swing.JList jlListaTipo;
    private javax.swing.JLabel jlXImagen;
    private javax.swing.JSpinner jsPosI;
    private javax.swing.JSpinner jsPosJ;
    private javax.swing.JTextField jtfXAlcance;
    private javax.swing.JTextField jtfXColor;
    private javax.swing.JTextField jtfXCreditos;
    private javax.swing.JTextField jtfXDescripcion;
    private javax.swing.JTextField jtfXDestruir;
    private javax.swing.JTextField jtfXImagen;
    private javax.swing.JTextField jtfXNombre;
    private javax.swing.JTextField jtfXUso;
    private javax.swing.JTextField jtfXVida;
    private gameworld.TableroMatriz tableroMatriz1;
    // End of variables declaration//GEN-END:variables

}
