package view.panels.painelEmployee;

import classes.exceptions.NegativeNumberException;
import classes.shared.MethodsUtil;
import classes.shared.employee.EmployeeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BonusEmployee extends JPanel {

    private JTextField jtfCodigo, jtfValorBonus;
    private JButton jbFinalizar;
    private JLabel jlFundoBonificacao;

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
                        EmployeeService.employee.sendBonus(EmployeeService.employee.search(jtfCodigo.getText()),
                                Double.parseDouble(jtfValorBonus.getText()));
                        JOptionPane.showMessageDialog(null,"Bonus adicionado com sucesso");
                    }catch (NegativeNumberException ex){
                        JOptionPane.showMessageDialog(null,"Valor negativo em campo");
                    }catch (NullPointerException ex){
                        JOptionPane.showMessageDialog(null,"Cliente inexistente ou incorreto");
                    }

                }
            }
        });

    }


}
