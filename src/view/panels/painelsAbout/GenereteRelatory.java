package view.panels.painelsAbout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenereteRelatory extends JPanel {

     private JTextField jtfOAB;
    private JButton jbGerarRelatorio;
    private JLabel jlFundoGerarRelatorio;

    public GenereteRelatory() {
        super();
        setSize(815, 538);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

        jlFundoGerarRelatorio = new JLabel();
        jlFundoGerarRelatorio.setIcon(new ImageIcon(getClass().getResource("/imagens/backgroundRelatory.png")));

        Font fonte = new Font("Arial", Font.PLAIN, 18);

        jtfOAB = new JTextField();
        add(jtfOAB);
        jtfOAB.setFont(fonte);
        jtfOAB.setOpaque(false);
        jtfOAB.setBorder(null);
        jtfOAB.setBounds(420, 190, 243, 35);

        jbGerarRelatorio = new JButton();
        add(jbGerarRelatorio);
        jbGerarRelatorio.setBackground(new Color(0,0,0,0));
        jbGerarRelatorio.setOpaque(false);
        jbGerarRelatorio.setBorder(null);
        jbGerarRelatorio.setContentAreaFilled(false);
        jbGerarRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbGerarRelatorio.setBounds(415, 282, 243, 35);

        jlFundoGerarRelatorio.setBounds(0,0,800,500);
        add(jlFundoGerarRelatorio);


    }

    private void criarEventos() {

        jbGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }


}
