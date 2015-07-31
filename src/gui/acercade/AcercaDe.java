/**
 * UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * ESCUELA DE CIENCIAS Y SISTEMAS
 * COMPILADORES 1
 * PROYECTO 1
 * Creado el 23 de septiembre 2011, 07:57AM
 * Credito para el blog
 * http://jajatips.blogspot.com/2009/04/create-hyperlink-with-desktop.html
 */
package gui.acercade;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Despliega informacion sobre el creador(es)
 * de cierta aplicacion en especial
 * @(#)AcercaDe.java
 * Proyecto1_200819312 application
 * @author David Y. Gonzalez
 */
public class AcercaDe extends JDialog {
    private String dirLogo;
    private String nombrePrograma;
    private String descripcion;
    private String version;
    private String autor;
    private String blog;
    private String nombreblog;
    private Font tipoLetra;

    /**Inicializa todos los datos que se veran en el dialogo**/
    public AcercaDe() {
        super();
        tipoLetra = new Font("Dialog", Font.PLAIN, 12);
        dirLogo = "gui/acercade/Circle_Blue.png";
        nombrePrograma = "JBadMeth";
        descripcion = "<HTML>"
                + "Aplicaci&oacute;n JBadMeth."
                + "<BR>"
                + "Hecho en Java"
                + "<BR>"
                + "Marvel Inc. Ciudad de Guatemala, Guatemala"
                + "</HTML>";
        version = "v.1.05";
        autor = "David Yzaguirre Gonzalez";
        blog = "http://www.metalvegetarianoprogresivo.blogspot.com";
        nombreblog = "MetalVegetarianoProgresivo.Blogspot.com";
        this.setTitle("Acerca De: " + nombrePrograma + " " + version);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setBounds(200, 30, 550, 250);
        this.setLayout(null);

        jbCerrar = new JButton("Cerrar");
        jbCerrar.setBounds(27, 175, 100, 30);
        jbCerrar.setFocusable(false);
        jbCerrar.setMnemonic(KeyEvent.VK_C);
        this.add(jbCerrar);
        jbCerrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AcercaDe.this.setVisible(false);
            }
        });
        getRootPane().setDefaultButton(jbCerrar);

        logo = new PanelLogo(dirLogo,128);
        logo.setLocation(10,10);
        add(logo);

        jlAplicacion = new JLabel(nombrePrograma);
        jlAplicacion.setFont(new Font("Dialog", Font.BOLD, 20));
        jlAplicacion.setBounds(10, 0, 125, 25);

        jlDescripcion = new JLabel(descripcion);
        jlDescripcion.setFont(tipoLetra);
        jlDescripcion.setBounds(10, 30, 305, 50);

        jlVersionTitulo = new JLabel("Version:");
        jlVersionTitulo.setBounds(10, 90, 60, 15);

        jlVersion = new JLabel(version);
        jlVersion.setFont(tipoLetra);
        jlVersion.setBounds(75, 90, 190, 15);

        jlAutorTitulo = new JLabel("Autor:");
        jlAutorTitulo.setBounds(10, 120, 60, 15);

        jlAutor = new JLabel(autor);
        jlAutor.setFont(tipoLetra);
        jlAutor.setBounds(75, 120, 190, 15);

        jlBlogTitulo = new JLabel("Blog:");
        jlBlogTitulo.setBounds(10, 155, 50, 15);

        hlBlog = new HyperlinkLabel(nombreblog, blog);
        hlBlog.setBounds(55, 155, 305, 15);

        labels = new JPanel();
        labels.setLayout(null);
        labels.setBounds(155, 10, 385, 200);
        labels.add(jlAplicacion);
        labels.add(jlDescripcion);
        labels.add(jlVersionTitulo);
        labels.add(jlVersion);
        labels.add(jlAutorTitulo);
        labels.add(jlAutor);
        labels.add(jlBlogTitulo);
        labels.add(hlBlog);

        add(labels);
    }          

    private JButton jbCerrar;
    private PanelLogo logo;
    private JPanel labels;
    private JLabel jlAplicacion;
    private JLabel jlDescripcion;
    private JLabel jlVersionTitulo;
    private JLabel jlVersion;
    private JLabel jlAutorTitulo;
    private JLabel jlAutor;
    private JLabel jlBlogTitulo;
    private HyperlinkLabel hlBlog;
}
