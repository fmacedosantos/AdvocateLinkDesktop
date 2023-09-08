package view.test.panels.panelsClient;

import classes.models.Clients;
import classes.shared.client.MethodsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AlterClient extends JPanel{
    private JTextArea jtfSalario, jtfFoto,jtfOAB;
    private JButton jbAlterar, jbApagar;
    private JLabel jlFundoAlterar;
    private JCheckBox jcbEmail, jcbTelefone;
    private Clients client;

    public AlterClient(Clients client) {
        super();
        this.client=client;
        setSize(812, 535);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }
    private void iniciarComponentes() {
        jlFundoAlterar = new JLabel();
        jlFundoAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/backgroundAlterClient.png")));

        Font fonte = new Font("Arial", Font.PLAIN, 18);

        jtfOAB = new JTextArea();
        add(jtfOAB);
        jtfOAB.setFont(fonte);
        jtfOAB.setBounds(400, 50, 230, 38);
        jtfOAB.setOpaque(false);
        jtfOAB.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jtfOAB.setText(client.getOab());
        jtfSalario = new JTextArea();
        jtfSalario.setFont(fonte);
        add(jtfSalario);
        jtfSalario.setBounds(409, 155, 230, 33);
        jtfSalario.setOpaque(false);
        jtfSalario.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jtfSalario.setText("0");
        jtfFoto = new JTextArea();
        jtfFoto.setFont(fonte);
        add(jtfFoto);
        jtfFoto.setBounds(409, 257, 230, 33);
        jtfFoto.setOpaque(false);
        jtfFoto.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jtfFoto.setText(client.getUrlfoto());
        jbAlterar = new JButton();
        add(jbAlterar);
        jbAlterar.setBounds(710, 455, 70, 33);
        jbAlterar.setOpaque(false);
        jbAlterar.setBackground(new Color(0,0,0,0));
        jbAlterar.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jbAlterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
      jbAlterar.setContentAreaFilled(false);
        jbAlterar.setBorderPainted(false);
        jbApagar = new JButton();
        add(jbApagar);
        jbApagar.setBounds(610, 450, 65, 33);
        jbApagar.setOpaque(false);
        jbApagar.setBackground(new Color(0,0,0,0));
        jbApagar.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jbApagar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbApagar.setContentAreaFilled(false);
        jbApagar.setBorderPainted(false);
        jcbEmail = new JCheckBox();
        add(jcbEmail);
        jcbEmail.setBounds(449, 365, 20 ,20);
        jcbEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jcbEmail.setOpaque(false);
        jcbEmail.setBorder(null);
        jcbTelefone = new JCheckBox();
        add(jcbTelefone);
        jcbTelefone.setBounds(578, 365, 20 ,20);
        jcbTelefone.setOpaque(false);
        jcbTelefone.setCursor(new Cursor(Cursor.HAND_CURSOR));//deixa o cursor com a maozinha do click
        jcbTelefone.setBorder(null);
        jlFundoAlterar.setBounds(0, 0, 800, 500);
        add(jlFundoAlterar);
    }
    private void criarEventos() {
        jbApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MethodsUtil.deleteHttps(client.getId());
                    JOptionPane.showMessageDialog(null,"Client removido com Sucesso!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
