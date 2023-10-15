package br.com.advocateLink.view.panels.painelEmployee;

import br.com.advocateLink.classes.exceptions.NegativeNumberException;
import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.classes.shared.employee.EmployeeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BonusEmployee extends JPanel {

    private JTextField jtfCodigo, jtfValorBonus;
    private JButton jbFinalizar;
    private JLabel jlFundoBonificacao;
    private EmployeeService employeeService = new EmployeeService();

    public BonusEmployee(){
        super();
        setSize(815,538);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jlFundoBonificacao = new JLabel();
        jlFundoBonificacao.setIcon(new ImageIcon(getClass().getResource("/imagens/backgroundBonus.png")));

        Font fonte = new Font("Arial", Font.PLAIN, 18);

        jtfCodigo = new JTextField();
        add(jtfCodigo);
        jtfCodigo.setOpaque(false);
        jtfCodigo.setBorder(null);
        jtfCodigo.setFont(fonte);
        jtfCodigo.setBounds(409, 152, 230 , 33);

        jtfValorBonus = new JTextField();
        add(jtfValorBonus);
        jtfValorBonus.setOpaque(false);
        jtfValorBonus.setBorder(null);
        jtfValorBonus.setFont(fonte);
        jtfValorBonus.setBounds(409, 265, 230, 33);

        jbFinalizar = new JButton();
        add(jbFinalizar);
        jbFinalizar.setOpaque(false);
        jbFinalizar.setBorder(null);
        jbFinalizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbFinalizar.setContentAreaFilled(false);
        jbFinalizar.setBackground(new Color(0,0,0,0));
        jbFinalizar.setBounds(695, 446, 75, 35);

        jlFundoBonificacao.setBounds(0,0,800,500);
        add(jlFundoBonificacao);


    }

    private void criarEventos() {
        jbFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MethodsUtil.validatesInput(jtfCodigo,jtfValorBonus)){
                    try{
                        employeeService.sendBonus(employeeService.search(Long.parseLong(jtfCodigo.getText())),
                                Double.parseDouble(jtfValorBonus.getText()));
                        JOptionPane.showMessageDialog(null,"Bonus adicionado com sucesso, Salario com bonus:"+ employeeService.search(Long.parseLong(jtfCodigo.getText())).getSalary()+ "R$");
                    }catch (NegativeNumberException ex){
                        JOptionPane.showMessageDialog(null,"Valor negativo em campo");
                    } catch (UserNotFound ex) {
                        JOptionPane.showMessageDialog(null,"Usuario nao encontrado");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Sem conexao");
                    }
                }
            }
        });
    }
}
