package br.com.advocateLink.view.panels.painelEmployee;

import br.com.advocateLink.classes.exceptions.LackOfInformationException;
import br.com.advocateLink.classes.models.Address;
import br.com.advocateLink.classes.models.Contact;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.service.EmployeeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterEmployee extends JPanel {

    private JLabel jlFundoCadastro;
    private JTextField jtfNome;
    private JTextField jtfCPF;
    private JTextField jtfBairro;
    private JTextField jtfRua;
    private JTextField jtfNumero;
    private JTextField jtfCodigo;
    private ImageIcon img;
    private JButton jbContinuar;
    private JComboBox<String> combo = new JComboBox<>();
    private int tel = 0;
    private String email = null;
    private EmployeeService employeeService = new EmployeeService();

    public RegisterEmployee() {
        super();
        setSize(800, 500);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        // Imagem de fundo
        img = new ImageIcon(getClass().getResource("/imagens/backgroundEmployee.png"));
        jlFundoCadastro = new JLabel(img);
        jlFundoCadastro.setBounds(2, 2, 800, 500);
        //Objetos dos componentes
        jtfNome = new JTextField();
        jtfCPF = new JTextField();
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
        jbContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Posicionando os elemnetos
        jtfNome.setBounds(410, 62, 240, 35);
        jtfCPF.setBounds(410, 132, 240, 35);
        jtfBairro.setBounds(410, 200, 240, 35);
        jtfRua.setBounds(410, 273, 145, 35);
        jtfNumero.setBounds(570, 273, 70, 35);
        jtfCodigo.setBounds(410, 350, 240, 35);
        jbContinuar.setBounds(687, 448, 95, 35);
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
            private JTextField jtfFoto;
            private JTextField jtfSalario;
            private JCheckBox jcEmail;
            private JCheckBox jcTelefone;
            private JButton jbFinalizar;
            private ImageIcon img;

            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                img = new ImageIcon(getClass().getResource("/imagens/backgroundEmployee01.png"));
                jlFundoCadastro = new JLabel(img);
                jtfFoto = new JTextField();
                jtfSalario = new JTextField();
                jcEmail = new JCheckBox();
                jcTelefone = new JCheckBox();
                jbFinalizar = new JButton();
                combo.addItem("menssagem normal");
                add(combo);
                combo.setBounds(396, 56, 253, 38);
                combo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                add(jtfFoto);
                add(jtfSalario);
                add(jcEmail);
                add(jcTelefone);
                add(jbFinalizar);
                add(jlFundoCadastro);
                //Posicionamento dos componentes
                jlFundoCadastro.setBounds(2, 2, 800, 500);
                jtfSalario.setBounds(410, 160, 240, 35);
                jtfFoto.setBounds(410, 264, 240, 35);
                jcEmail.setBounds(448, 353, 50, 50);
                jcTelefone.setBounds(580, 353, 50, 50);
                jbFinalizar.setBounds(685, 455, 100, 35);
                //Estilizar fonte
                Font font = jtfNome.getFont();
                jtfFoto.setFont(new Font(font.getName(), Font.PLAIN, 18)); // Tamanho da fonte
                jtfSalario.setFont(new Font(font.getName(), Font.PLAIN, 18));
                //Deixar os componentes transparente
                jtfFoto.setOpaque(false);
                jtfFoto.setBorder(null);
                jtfSalario.setOpaque(false);
                jtfSalario.setBorder(null);
                jcEmail.setOpaque(false);
                jcEmail.setBorder(null);
                jcTelefone.setOpaque(false);
                jcTelefone.setBorder(null);
                jbFinalizar.setContentAreaFilled(false); // Remover preenchimento
                jbFinalizar.setBorderPainted(false); // Remover borda
                jbFinalizar.setOpaque(false); // Tornar o botão transparente
                jbFinalizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
                    public void actionPerformed(ActionEvent e) throws LackOfInformationException {
                        if (MethodsUtil.validatesInput(jtfCPF, jtfRua, jtfBairro, jtfSalario, jtfNumero, jtfCodigo, jtfFoto)) {
                            try {
                                if (email == null || tel == 0) {
                                    throw new LackOfInformationException("Falta de informacao, verifique todos os campos");
                                }
                                MethodsUtil.validatesNumber(Integer.parseInt(jtfNumero.getText()));
                                MethodsUtil.validatesNumber(Integer.parseInt(jtfSalario.getText()));
                                String itemSelect = combo.getSelectedItem().toString();
                                employeeService.register(new Employee(0, jtfNome.getText(), jtfCPF.getText(), new Address(jtfRua.getText(), Integer.parseInt(jtfNumero.getText()), jtfBairro.getText()),
                                        new Contact(tel, email), jtfFoto.getText(), 0, itemSelect, Integer.parseInt(jtfSalario.getText())));
                                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
                            } catch (NumberFormatException | LackOfInformationException ex) {
                                JOptionPane.showMessageDialog(null, "VERIFIQUE AS INFORMACOES");
                                System.out.println(" " + ex.getMessage());
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "sem conexao");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
                        }
                    }
                });
            }
        });
    }
}
