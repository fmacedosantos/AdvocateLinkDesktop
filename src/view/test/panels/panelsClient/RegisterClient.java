package view.test.panels.panelsClient;

import classes.exceptions.LackOfInformationException;
import classes.exceptions.NegativeNumberException;
import classes.models.Address;
import classes.models.Clients;
import classes.models.Contact;
import classes.shared.client.MethodsUtil;
import classes.shared.client.https.HttpsConnections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static classes.shared.client.MethodsUtil.validatesInput;
import static classes.shared.client.MethodsUtil.validatesNumber;

public class RegisterClient extends JPanel {

    private JLabel jlFundoCadastro;
    private JTextField jtfNome;
    private JTextField jtfCPF;
    private JTextField jtfBairro;
    private JTextField jtfRua;
    private JTextField jtfNumero;
    private JTextField jtfCodigo;
    private ImageIcon img;
    private JButton jbContinuar;
    private int tel = 0;
    private String email = null;

    public RegisterClient() {
        super();
        setSize(800, 500);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
        HttpsConnections.getHttps();
    }

    private void iniciarComponentes() {
        // Imagem de fundo
        img = new ImageIcon(getClass().getResource("/imagens/backgroundRegister.png"));
        jlFundoCadastro = new JLabel(img);
        jlFundoCadastro.setBounds(2, 2, 800, 500);
        jtfCPF = new JTextField();
        //Objetos dos componentes
        jtfNome = new JTextField();
        jtfBairro = new JTextField();
        jtfRua = new JTextField();
        jtfNumero = new JTextField();
        jtfCodigo = new JTextField();
        jbContinuar = new JButton();
        //Estilizar os fonte
        Font font = jtfNome.getFont();
        jtfNome.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
        jtfCPF.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
        jtfBairro.setFont(new Font(font.getName(), Font.PLAIN, 18));
        jtfRua.setFont(new Font(font.getName(), Font.PLAIN, 18));
        jtfNumero.setFont(new Font(font.getName(), Font.PLAIN, 18));
        jtfCodigo.setFont(new Font(font.getName(), Font.PLAIN, 18));
        //Deixar os componentes transparente
        jtfNome.setOpaque(false);
        jtfNome.setBorder(null);
        jtfCPF.setOpaque(false);
        jtfCPF.setBorder(null);
        jtfBairro.setOpaque(false);
        jtfBairro.setBorder(null);
        jtfRua.setOpaque(false);
        jtfRua.setBorder(null);
        jtfNumero.setOpaque(false);
        jtfNumero.setBorder(null);
        jtfCodigo.setOpaque(false);
        jtfCodigo.setBorder(null);
        jbContinuar.setContentAreaFilled(false); // Remover preenchimento
        jbContinuar.setBorderPainted(false); // Remover borda
        jbContinuar.setOpaque(false); // Tornar o botão transparente
        //Posicionando os elemnetos
        jtfNome.setBounds(410, 62, 240, 35);
        jtfCPF.setBounds(410, 132, 240, 35);
        jtfBairro.setBounds(410, 200, 240, 35);
        jtfRua.setBounds(410, 273, 145, 35);
        jtfNumero.setBounds(570, 273, 70, 35);
        jtfCodigo.setBounds(410, 350, 240, 35);
        jbContinuar.setBounds(687, 448, 95, 35);
        jbContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Adicionar os componentes
        add(jtfNome);
        add(jtfCPF);
        add(jtfBairro);
        add(jtfRua);
        add(jtfNumero);
        add(jtfCodigo);
        add(jbContinuar);
        add(jlFundoCadastro);
    }

    private void criarEventos() {
        jbContinuar.addActionListener(new ActionListener() {
            private JLabel jlFundoCadastro01;
            private JTextField jtfOAB;
            private JTextField jtfFoto;
            private JComboBox jcbAreaAtuaçao;
            private JCheckBox jcEmail;
            private JCheckBox jcTelefone;
            private JButton jbFinalizar;
            private ImageIcon img;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (MethodsUtil.validatesInput(jtfNome, jtfRua, jtfRua, jtfBairro, jtfCodigo, jtfCPF)) {
                    removeAll();
                    img = new ImageIcon(getClass().getResource("/imagens/backgroundRegister01.png"));
                    jlFundoCadastro = new JLabel(img);
                    jtfOAB = new JTextField();
                    jtfFoto = new JTextField();
                    jcbAreaAtuaçao = new JComboBox();
                    jcEmail = new JCheckBox();
                    jcTelefone = new JCheckBox();
                    jbFinalizar = new JButton();
                    add(jcbAreaAtuaçao);
                    add(jtfOAB);
                    add(jtfFoto);
                    add(jcEmail);
                    add(jcTelefone);
                    add(jbFinalizar);
                    add(jlFundoCadastro);
                    //Posicionamento dos componentes
                    jlFundoCadastro.setBounds(2, 2, 800, 500);
                    jtfOAB.setBounds(410, 50, 240, 35);
                    jcbAreaAtuaçao.setBounds(400, 153, 250, 35);
                    jtfFoto.setBounds(410, 257, 240, 35);
                    jcEmail.setBounds(450, 350, 50, 50);
                    jcTelefone.setBounds(580, 350, 50, 50);
                    jbFinalizar.setBounds(685, 455, 100, 35);
                    //Estilizar fonte
                    Font font = jtfNome.getFont();
                    jtfOAB.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
                    jtfFoto.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
                    jcbAreaAtuaçao.setFont(new Font(font.getName(), Font.PLAIN, 18));
                    //Deixar os componentes transparente
                    jtfOAB.setOpaque(false);
                    jtfOAB.setBorder(null);
                    jtfFoto.setOpaque(false);
                    jtfFoto.setBorder(null);
                    jcEmail.setOpaque(false);
                    jcEmail.setBorder(null);
                    jcTelefone.setOpaque(false);
                    jcTelefone.setBorder(null);
                    jbFinalizar.setContentAreaFilled(false); // Remover preenchimento
                    jbFinalizar.setBorderPainted(false); // Remover borda
                    jbFinalizar.setOpaque(false); // Tornar o botão transparente
                    jbFinalizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    jcbAreaAtuaçao.addItem("Criminalista");
                    jcbAreaAtuaçao.addItem("Previdenciário");
                    jcbAreaAtuaçao.addItem("Comercial");
                    jcTelefone.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (jcTelefone.isSelected()) {
                                try {
                                    tel = Integer.parseInt(JOptionPane.showInputDialog("DIGITE O TELEFONE"));
                                } catch (NumberFormatException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                        }
                    });
                    jcEmail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (jcEmail.isSelected()) {
                                try {
                                    email = JOptionPane.showInputDialog("DIGITE O EMAIL");
                                } catch (NullPointerException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                        }
                    });
                    jbFinalizar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) throws LackOfInformationException, NegativeNumberException {
                            try {
                                if (email == null || tel == 0) {
                                    throw new LackOfInformationException("Falta de informacao, verifique todos os campos");
                                }
                                int numero =(int) validatesNumber(Integer.parseInt(jtfNumero.getText()));
                                if (numero<0){
                                    throw new NegativeNumberException("Numero negativo em campos");
                                }
                                String nome = jtfNome.getText();
                                String cpf = jtfCPF.getText();
                                String rua = jtfRua.getText();
                                String bairro = jtfBairro.getText();
                                String urlfoto = jtfFoto.getText();
                                String oab = jtfOAB.getText();
                                String itemSelecionado = jcbAreaAtuaçao.getSelectedItem().toString();
                                JOptionPane.showMessageDialog(null,"Cliente cadastrado com Sucesso");
                                HttpsConnections.postHttps(new Clients(0, nome, cpf, new Address(rua, numero, bairro),
                                        new Contact(tel, email), urlfoto, oab, itemSelecionado));
                            } catch (IOException | InterruptedException ex) {
                                System.err.println("Erro ao enviar a solicitação: " + ex.getMessage());
                            } catch (NumberFormatException | NegativeNumberException ex) {
                                JOptionPane.showMessageDialog(null, " VERIFIQUE AS INFORMACOES");
                                System.err.println("Erro ao enviar a solicitação: " + ex.getMessage());
                            } catch (LackOfInformationException ex) {
                                JOptionPane.showMessageDialog(null, " VERIFIQUE SE PREENCHEU TODAS AS INFORMACOES");
                                System.err.println("Erro ao enviar a solicitação: " + ex.getMessage());
                            }
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
                }
            }
        });
    }
}
