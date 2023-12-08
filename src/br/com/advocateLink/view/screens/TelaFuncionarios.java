package br.com.advocateLink.view.screens;

import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.service.EmployeeService;
import br.com.advocateLink.view.panels.painelEmployee.AlterEmployee;
import br.com.advocateLink.view.panels.painelEmployee.BonusEmployee;
import br.com.advocateLink.view.panels.painelEmployee.RegisterEmployee;
import br.com.advocateLink.view.panels.panelsClient.AlterClient;
import br.com.advocateLink.view.panels.panelsClient.RegisterClient;
import br.com.advocateLink.view.panels.panelsClient.Search;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionarios extends JFrame {

    private JButton jbCadastrar, jbPesquisar, jbAlterar, jbBonus;
    private JButton jbHome, jbCliente, jbFuncionario, jbArquivo, jbSistemas;
    private JLabel jlFundo;
    EmployeeService employeeService;

    public TelaFuncionarios() throws HeadlessException {
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarComponentes();
        criarEventos();
    }
    private void iniciarComponentes() {

        jbCadastrar = new JButton();
        jbPesquisar = new JButton();
        jbAlterar = new JButton();
        jbBonus = new JButton();

        jbHome = new JButton();
        jbCliente = new JButton();
        jbFuncionario = new JButton();
        jbArquivo = new JButton();
        jbSistemas = new JButton();

        add(jbCadastrar);
        add(jbPesquisar);
        add(jbAlterar);
        add(jbBonus);
        add(jbHome);
        add(jbCliente);
        add(jbFuncionario);
        add(jbArquivo);
        add(jbSistemas);

        jbCadastrar.setBounds(350,170,200,38);
        jbCadastrar.setOpaque(false); // Tornar o botão transparente
        jbCadastrar.setContentAreaFilled(false); // Remover preenchimento
        jbCadastrar.setBorderPainted(false); // Remover borda

        jbPesquisar.setBounds(350,238,200,38);
        jbPesquisar.setOpaque(false); // Tornar o botão transparente
        jbPesquisar.setContentAreaFilled(false); // Remover preenchimento
        jbPesquisar.setBorderPainted(false); // Remover borda

        jbAlterar.setBounds(350,310,200,38);
        jbAlterar.setOpaque(false); // Tornar o botão transparente
        jbAlterar.setContentAreaFilled(false); // Remover preenchimento
        jbAlterar.setBorderPainted(false); // Remover borda

        jbBonus.setBounds(350,370,200,38);
        jbBonus.setOpaque(false); // Tornar o botão transparente
        jbBonus.setContentAreaFilled(false); // Remover preenchimento
        jbBonus.setBorderPainted(false); // Remover borda

        jbHome.setBounds(24,35,50,50);
        jbHome.setOpaque(false); // Tornar o botão transparente
        jbHome.setContentAreaFilled(false); // Remover preenchimento
        jbHome.setBorderPainted(false); // Remover borda

        jbCliente.setBounds(24,127,50,50);
        jbCliente.setOpaque(false); // Tornar o botão transparente
        jbCliente.setContentAreaFilled(false); // Remover preenchimento
        jbCliente.setBorderPainted(false); // Remover borda

        jbFuncionario.setBounds(25,218,50,50);
        jbFuncionario.setOpaque(false); // Tornar o botão transparente
        jbFuncionario.setContentAreaFilled(false); // Remover preenchimento
        jbFuncionario.setBorderPainted(false); // Remover borda

        jbArquivo.setBounds(25,306,50,50);
        jbArquivo.setOpaque(false); // Tornar o botão transparente
        jbArquivo.setContentAreaFilled(false); // Remover preenchimento
        jbArquivo.setBorderPainted(false); // Remover borda

        jbSistemas.setBounds(25,394,50,50);
        jbSistemas.setOpaque(false); // Tornar o botão transparente
        jbSistemas.setContentAreaFilled(false); // Remover preenchimento
        jbSistemas.setBorderPainted(false); // Remover borda

        jlFundo = new JLabel();
        jlFundo.setIcon(new ImageIcon(getClass().getResource("/imagens/TelaFuncionarios.png")));
        add(jlFundo);
        jlFundo.setBounds(0, 0, 800, 500);

    }

    private void criarEventos() {
        jbCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaClientes  telaClientes = new TelaClientes();
                telaClientes.setVisible(true);
                Mainscreen mainscreen = new Mainscreen("AdvocateLInk");
                mainscreen.setVisible(false);
            }
        });
        jbFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
                telaFuncionarios.setVisible(true);
                Mainscreen mainscreen = new Mainscreen("AdvocateLInk");
                mainscreen.setVisible(false);
            }
        });
        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterEmployee registerEmployee = new RegisterEmployee();
                RegisterEmployee employee = new RegisterEmployee();
                getContentPane().removeAll();
                getContentPane().add(employee);
                getContentPane().validate();
                repaint();
            }
        });
        jbPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainscreen.currentAppSearchState = Mainscreen.AppSearchState.CLIENT;
                setVisible(false);
                TelaPesquisa telaPesquisa = new TelaPesquisa();
                telaPesquisa.setVisible(true);
            }
        });
        jbAlterar.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Employee employeTemp = employeeService.search(Long.parseLong(JOptionPane.showInputDialog("DIGITE O ID DO CLIENTE")));
                    AlterEmployee employeee = new AlterEmployee(employeTemp);
                    getContentPane().removeAll();
                    getContentPane().add(employeee);
                    getContentPane().validate();
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "verifique os campos");
                } catch (RuntimeException ex) {
                }
            }
        });
        jbBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BonusEmployee bonus = new BonusEmployee();
                getContentPane().removeAll();
                getContentPane().add(bonus);
                getContentPane().validate();
                repaint();
            }
        });
    }
}
