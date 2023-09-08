package view.test.screens;

import classes.models.Administration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static classes.shared.MethodsUtil.validaCampos;

public class Login extends JFrame {

    private  JLabel jlFundoLogin;

    private JTextField jtflogin,jpsSenha;
    private JButton jbLogar;

    public Login(String title) throws HeadlessException {
        super(title);
        setLayout(null);
        //Atributos da tela
        setSize(800,520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarComponentes();
        criarEventos();

    }

    private void iniciarComponentes() {

        jtflogin = new JTextField();
        jtflogin.setBounds(490, 196, 250, 37);
        jtflogin.setOpaque(false); //Deixa transparente
        jtflogin.setBorder(null); //Remove borda

        //Estilizaçao da fonte
        Font font = jtflogin.getFont();
        jtflogin.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte


        jpsSenha = new JTextField();
        jpsSenha.setBounds(490,299,240,37);
        jpsSenha.setOpaque(false); //deixa transparente
        jpsSenha.setBorder(null);//remove borda

        //Estilizaçao da fonte
        jpsSenha.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
        jpsSenha.setForeground(Color.black); //  Muda a cor da fonte

        jbLogar = new JButton();
        jbLogar.setBounds(545,405,105,35);
        jbLogar.setOpaque(false); // Remove a cor de fundo do botao
        jbLogar.setContentAreaFilled(false); // Remover preenchimento
        jbLogar.setBorderPainted(false); // Remover borda

        //Adicionar na tela

        add(jtflogin);
        add(jpsSenha);
        add(jbLogar);

        //Imagem de fundo
        jlFundoLogin = new JLabel();
        jlFundoLogin.setIcon(new ImageIcon(getClass().getResource("/imagens/backgroundLogin.png")));
        jlFundoLogin.setBounds(0,0,800,500);
        add(jlFundoLogin);

    }

    private void criarEventos() {
        jbLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (validaCampos(jtflogin,jpsSenha)){
                    if (jtflogin.getText().equals(Administration.getLogin())&&jpsSenha.getText().equals(Administration.getPassword())){
                        Mainscreen tela = new Mainscreen("Advocate-Link");
                        tela.setVisible(true);
                        setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS");
                }
            }
        });

    }
}
