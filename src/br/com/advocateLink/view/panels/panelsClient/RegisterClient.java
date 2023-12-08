package br.com.advocateLink.view.panels.panelsClient;

import br.com.advocateLink.classes.exceptions.LackOfInformationException;
import br.com.advocateLink.classes.exceptions.NegativeNumberException;
import br.com.advocateLink.classes.models.Address;
import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.models.Contact;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.service.ClientService;
import br.com.advocateLink.view.screens.Mainscreen;
import br.com.advocateLink.view.screens.TelaFuncionarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.com.advocateLink.classes.shared.MethodsUtil.validatesNumber;

public class RegisterClient extends JPanel {

    private JLabel jlFundoCadastro;
    private JTextField jtfNome;
    private JTextField jtfCPF;
    private JTextField jtfBairro;
    private JTextField jtfRua;
    private JTextField jtfNumero;
    private ImageIcon img;
    private JButton jbContinuar;
    private int tel = 0;
    private String email = null;
    private JButton jbHome, jbCliente, jbFuncionario, jbArquivo, jbSistemas;
    private ClientService clientService = new ClientService();

    public RegisterClient() {
        super();
        setSize(800, 500);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        // Imagem de fundo
        img = new ImageIcon(getClass().getResource("/imagens/TelaCadastroCliente.png"));
        jlFundoCadastro = new JLabel(img);
        jlFundoCadastro.setBounds(2, 2, 800, 500);
        jtfCPF = new JTextField();
        //Objetos dos componentes
        jtfNome = new JTextField();
        jtfBairro = new JTextField();
        jtfRua = new JTextField();
        jtfNumero = new JTextField();
        jbContinuar = new JButton();
        jbHome = new JButton();
        jbCliente = new JButton();
        jbFuncionario = new JButton();
        jbArquivo = new JButton();
        jbSistemas = new JButton();
        //Estilizar os fonte
        Font font = jtfNome.getFont();
        jtfNome.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
        jtfCPF.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
        jtfBairro.setFont(new Font(font.getName(), Font.PLAIN, 18));
        jtfRua.setFont(new Font(font.getName(), Font.PLAIN, 18));
        jtfNumero.setFont(new Font(font.getName(), Font.PLAIN, 18));
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
        jbContinuar.setContentAreaFilled(false); // Remover preenchimento
        jbContinuar.setBorderPainted(false); // Remover borda
        jbContinuar.setOpaque(false); // Tornar o botão transparente
        //Posicionando os elemnetos
        jtfNome.setBounds(300, 65, 280, 35);
        jtfCPF.setBounds(300, 170, 280, 35);
        jtfBairro.setBounds(300, 273, 280, 35);
        jtfRua.setBounds(300, 379, 165, 35);
        jtfNumero.setBounds(500, 379, 90, 35);
        jbContinuar.setBounds(350, 450, 200, 35);
        jbContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Adicionar os componentes
        add(jtfNome);
        add(jtfCPF);
        add(jtfBairro);
        add(jtfRua);
        add(jtfNumero);
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
            private JButton jbHome, jbCliente, jbFuncionario, jbArquivo, jbSistemas;


            @Override
            public void actionPerformed(ActionEvent e) {
                if (MethodsUtil.validatesInput(jtfNome, jtfRua, jtfRua, jtfBairro,jtfRua, jtfCPF)) {
                    removeAll();
                    img = new ImageIcon(getClass().getResource("/imagens/TelaCadastroCliente2.png"));
                    jlFundoCadastro = new JLabel(img);
                    jtfOAB = new JTextField();
                    jtfFoto = new JTextField();
                    jcbAreaAtuaçao = new JComboBox();
                    jcEmail = new JCheckBox();
                    jcTelefone = new JCheckBox();
                    jbFinalizar = new JButton();
                    jbHome = new JButton();
                    jbCliente = new JButton();
                    jbFuncionario = new JButton();
                    jbArquivo = new JButton();
                    jbSistemas = new JButton();
                    add(jcbAreaAtuaçao);
                    add(jtfOAB);
                    add(jtfFoto);
                    add(jcEmail);
                    add(jcTelefone);
                    add(jbFinalizar);
                    add(jlFundoCadastro);

                    add(jbHome);
                    jbHome.setBounds(24,35,50,50);
                    jbHome.setOpaque(false); // Tornar o botão transparente
                    jbHome.setContentAreaFilled(false); // Remover preenchimento
                    jbHome.setBorderPainted(false); // Remover borda

                    add(jbCliente);
                    jbCliente.setBounds(24,127,50,50);
                    jbCliente.setOpaque(false); // Tornar o botão transparente
                    jbCliente.setContentAreaFilled(false); // Remover preenchimento
                    jbCliente.setBorderPainted(false); // Remover borda

                    add(jbFuncionario);
                    jbFuncionario.setBounds(25,218,50,50);
                    jbFuncionario.setOpaque(false); // Tornar o botão transparente
                    jbFuncionario.setContentAreaFilled(false); // Remover preenchimento
                    jbFuncionario.setBorderPainted(false); // Remover borda

                    add(jbArquivo);
                    jbArquivo.setBounds(25,306,50,50);
                    jbArquivo.setOpaque(false); // Tornar o botão transparente
                    jbArquivo.setContentAreaFilled(false); // Remover preenchimento
                    jbArquivo.setBorderPainted(false); // Remover borda

                    add(jbSistemas);
                    jbSistemas.setBounds(25,394,50,50);
                    jbSistemas.setOpaque(false); // Tornar o botão transparente
                    jbSistemas.setContentAreaFilled(false); // Remover preenchimento
                    jbSistemas.setBorderPainted(false); // Remover borda

                    //Posicionamento dos componentes
                    jlFundoCadastro.setBounds(2, 2, 800, 500);
                    jtfOAB.setBounds(300, 65, 280, 35);
                    jcbAreaAtuaçao.setBounds(300, 168, 280, 35);
                    jtfFoto.setBounds(300, 274, 280, 35);
                    jcEmail.setBounds(347, 370, 50, 50);
                    jcTelefone.setBounds(491, 370, 50, 50);
                    jbFinalizar.setBounds(340, 440, 210, 35);
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
                                int numero = (int) validatesNumber(Integer.parseInt(jtfNumero.getText()));
                                if (numero < 0) {
                                    throw new NegativeNumberException("Numero negativo em campos");
                                }
                                String nome = jtfNome.getText();
                                String cpf = jtfCPF.getText();
                                String rua = jtfRua.getText();
                                String bairro = jtfBairro.getText();
                                String urlfoto = jtfFoto.getText();
                                String oab = jtfOAB.getText();
                                String itemSelecionado = jcbAreaAtuaçao.getSelectedItem().toString();
                                JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso");
                                clientService.register((new Client(0, nome, cpf, new Address(rua, numero, bairro),
                                        new Contact(tel, email), urlfoto, oab, itemSelecionado)));
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
        jbFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
                telaFuncionarios.setVisible(true);
                RegisterClient registerClient = new RegisterClient();
                registerClient.setVisible(false);
            }
        });
    }
}
