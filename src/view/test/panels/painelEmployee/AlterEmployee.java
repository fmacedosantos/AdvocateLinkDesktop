package view.test.panels.painelEmployee;

import classes.exceptions.LackOfInformationException;
import classes.models.Employee;
import classes.shared.client.employee.EmployeeService;
import classes.shared.client.https.HttpsConnections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AlterEmployee extends JPanel {

    private JTextArea jtfSalario, jtfFoto;
    private JButton jbAlterar, jbApagar;
    private JLabel jlFundoAlterar;
    private JCheckBox jcbEmail, jcbTelefone;
    private JComboBox <String> combo = new JComboBox<>();
    private long tel = 0;
    private String email = null;

    private Employee employee;
    public AlterEmployee(Employee employee) {
        super();
        this.employee=employee;
        setSize(812, 535);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jlFundoAlterar = new JLabel();
        jlFundoAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/backgroundAlterEmployee.png")));

        Font fonte = new Font("Arial", Font.PLAIN, 18);

        combo.addItem("menssagem normal");
        add(combo);
        combo.setBounds(396, 56, 253, 38);
        combo.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        UIManager.put("CheckBox.background", new Color(0, 0, 0, 0)); // Define o fundo como transparente
        UIManager.put("CheckBox.focus", new Color(0, 0, 0, 0)); // Remove o foco

        jtfSalario = new JTextArea();
        jtfSalario.setFont(fonte);
        add(jtfSalario);
        jtfSalario.setText(String.valueOf(employee.getSalary()));
        jtfSalario.setBounds(409, 163, 230, 33);
        jtfSalario.setOpaque(false);
        jtfSalario.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        jtfFoto = new JTextArea();
        jtfFoto.setFont(fonte);
        add(jtfFoto);
        jtfFoto.setText(employee.getUrlfoto());
        jtfFoto.setBounds(409, 263, 230, 33);
        jtfFoto.setOpaque(false);
        jtfFoto.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        jbAlterar = new JButton();
        add(jbAlterar);
        jbAlterar.setBounds(710, 447, 70, 33);
        jbAlterar.setOpaque(false);
        jbAlterar.setBackground(new Color(0,0,0,0));
        jbAlterar.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jbAlterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbAlterar.setContentAreaFilled(false);
        jbAlterar.setBorderPainted(false);

        jbApagar = new JButton();
        add(jbApagar);
        jbApagar.setBounds(610, 447, 65, 33);
        jbApagar.setOpaque(false);
        jbApagar.setBackground(new Color(0,0,0,0));
        jbApagar.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jbApagar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbApagar.setContentAreaFilled(false);
        jbApagar.setBorderPainted(false);

        jcbEmail = new JCheckBox();
        add(jcbEmail);
        jcbEmail.setBounds(449, 368, 20 ,20);
        jcbEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jcbEmail.setOpaque(false);
        jcbEmail.setBorder(null);

        jcbTelefone = new JCheckBox();
        add(jcbTelefone);
        jcbTelefone.setBounds(578, 368, 20 ,20);
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
                EmployeeService.employeeslList.remove(EmployeeService.employee.show().indexOf(employee));
            }
        });
        jcbTelefone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jcbTelefone.isSelected()) {
                    try {
                        tel = Integer.parseInt(JOptionPane.showInputDialog("DIGITE O TELEFONE"));
                    } catch (NumberFormatException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });
        jcbEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jcbEmail.isSelected()) {
                    try {
                        email = JOptionPane.showInputDialog("DIGITE O EMAIL");
                    } catch (NullPointerException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });
        jbAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (email == null || tel == 0) {
                        throw new LackOfInformationException("Falta de informacao, verifique todos os campos");
                    }
                    String itemSelect = combo.getSelectedItem().toString();
                    employee.setUrlfoto(jtfFoto.getText());
                    employee.setRole(itemSelect);
                    employee.setSalary(Double.parseDouble(jtfSalario.getText()));
                    employee.getContato().setEmail(email);
                    employee.getContato().setTelefone(tel);
                }catch (LackOfInformationException ex){
                    JOptionPane.showMessageDialog(null, " VERIFIQUE SE PREENCHEU TODAS AS INFORMACOES");
                    ex.getMessage();
                }
            }
        });
        
    }

}
