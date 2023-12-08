package br.com.advocateLink.view.screens;

import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.service.ClientService;
import br.com.advocateLink.service.EmployeeService;
import br.com.advocateLink.view.panels.painelEmployee.AlterEmployee;
import br.com.advocateLink.view.panels.painelEmployee.BonusEmployee;
import br.com.advocateLink.view.panels.painelEmployee.RegisterEmployee;
import br.com.advocateLink.view.panels.painelsAbout.GenereteRelatory;
import br.com.advocateLink.view.panels.panelsClient.AlterClient;
import br.com.advocateLink.view.panels.panelsClient.RegisterClient;
import br.com.advocateLink.view.panels.panelsClient.Search;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainscreen extends JFrame {
    public static AppSearchState currentAppSearchState = AppSearchState.NONE;
    //Background
    private JLabel jlFundo;
    private JButton jbSair;
    private JButton jbHome, jbCliente, jbFuncionario, jbArquivo, jbSistemas;
    //Bar
    private JMenuBar jmbBarra;
    //Menu
    private JMenu jmCliente;
    private JMenu jmFuncionario;
    private JMenu jmSistema;
    private JMenu jmSobre;
    //Items
    private JMenuItem jmiCadastrarFuncionario;
    private JMenuItem jmiPesquisarFuncionario;
    private JMenuItem jmiAlterarFuncionario;
    private JMenuItem jmiBonusFuncionario;
    private JMenuItem jmiCadastrarCliente;
    private JMenuItem jmiPesquisarCliente;
    private JMenuItem jmiAlterarCliente;
    private JMenuItem jmiGerarRelatorio;
    private JMenuItem jmiSistema;
    private EmployeeService employeeService = new EmployeeService();
    private ClientService service = new ClientService();

    public Mainscreen(String title) throws HeadlessException {
        super(title);
        //Atributos da tela
        setSize(800, 530);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jbHome = new JButton();
        jbCliente = new JButton();
        jbFuncionario = new JButton();
        jbArquivo = new JButton();
        jbSistemas = new JButton();
//        jmbBarra = new JMenuBar();
//        jmCliente = new JMenu("Cliente");
//        jmFuncionario = new JMenu("Funcionario");
//        jmSistema = new JMenu("Sistema");
//        jmSobre = new JMenu("Sobre");
//        jmiCadastrarCliente = new JMenuItem("Cadastrar");
//        jmiPesquisarCliente = new JMenuItem("Pesquisar");
//        jmiAlterarCliente = new JMenuItem("Alterar");
//        jmiCadastrarFuncionario = new JMenuItem("Cadastrar");
//        jmiPesquisarFuncionario = new JMenuItem("Pesquisar");
//        jmiAlterarFuncionario = new JMenuItem("Alterar");
//        jmiBonusFuncionario = new JMenuItem("Bônus");
//        jmiSistema = new JMenuItem("Sistema");
//        jmiGerarRelatorio = new JMenuItem("Relatório");
//        setJMenuBar(jmbBarra);
//        jmbBarra.add(jmCliente);
//        jmbBarra.add(jmFuncionario);
//        jmbBarra.add(jmSistema);
//        jmbBarra.add(jmSobre);
//        jmCliente.add(jmiCadastrarCliente);
//        jmCliente.add(jmiPesquisarCliente);
//        jmCliente.add(jmiAlterarCliente);
//        jmFuncionario.add(jmiCadastrarFuncionario);
//        jmFuncionario.add(jmiPesquisarFuncionario);
//        jmFuncionario.add(jmiAlterarFuncionario);
//        jmFuncionario.add(jmiBonusFuncionario);
//        jmSistema.add(jmiSistema);
//        jmSistema.add(jmiGerarRelatorio);
        jbSair = new JButton();
        jbSair.setBounds(374, 438, 100, 35);
        jbSair.setOpaque(false); // Tornar o botão transparente
        jbSair.setContentAreaFilled(false); // Remover preenchimento
        jbSair.setBorderPainted(false); // Remover borda

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

        add(jbSair);
        jlFundo = new JLabel();
        jlFundo.setIcon(new ImageIcon(getClass().getResource("/imagens/Main.png")));
        add(jlFundo);
        jlFundo.setBounds(0, 0, 800, 500);
    }

    private void criarEventos() {
        //CRIAR EVENTOS
        jbSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TelaClientes  telaClientes = new TelaClientes();
                telaClientes.setVisible(true);
            }
        });
        jbFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
                telaFuncionarios.setVisible(true);
            }
        });


//
//        jmiCadastrarCliente.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                RegisterClient client = new RegisterClient();
//                getContentPane().removeAll();
//                getContentPane().add(client);
//                getContentPane().validate();
//                repaint();
//            }
//        });
//        jmiCadastrarFuncionario.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                RegisterEmployee employee = new RegisterEmployee();
//                getContentPane().removeAll();
//                getContentPane().add(employee);
//                getContentPane().validate();
//                repaint();
//            }
//        });
//        jmiAlterarCliente.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Client c = service.search(Long.parseLong(JOptionPane.showInputDialog("DIGITE O ID DO CLIENTE")));
//                    AlterClient clientt = new AlterClient(c);
//                    getContentPane().removeAll();
//                    getContentPane().add(clientt);
//                    getContentPane().validate();
//                    repaint();
//                } catch (RuntimeException ex) {
//                }
//            }
//        });
//        jmiAlterarFuncionario.addActionListener(new ActionListener() {
//            @SneakyThrows
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Employee employeTemp = employeeService.search(Long.parseLong(JOptionPane.showInputDialog("DIGITE O ID DO CLIENTE")));
//                    AlterEmployee employeee = new AlterEmployee(employeTemp);
//                    getContentPane().removeAll();
//                    getContentPane().add(employeee);
//                    getContentPane().validate();
//                    repaint();
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(null, "verifique os campos");
//                } catch (RuntimeException ex) {
//                }
//            }
//        });
//        jmiGerarRelatorio.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GenereteRelatory realatory = new GenereteRelatory();
//                getContentPane().removeAll();
//                getContentPane().add(realatory);
//                getContentPane().validate();
//                repaint();
//            }
//        });
        jbArquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TelaPesquisa telaPesquisa = new TelaPesquisa();
                telaPesquisa.setVisible(true);
            }
        });

//        jmiPesquisarFuncionario.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Mainscreen.currentAppSearchState = Mainscreen.AppSearchState.EMPLOYEE;
//                Search search = new Search();
//                getContentPane().removeAll();
//                getContentPane().add(search);
//                getContentPane().validate();
//                repaint();
//            }
//        });
//        jmiBonusFuncionario.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                BonusEmployee bonus = new BonusEmployee();
//                getContentPane().removeAll();
//                getContentPane().add(bonus);
//                getContentPane().validate();
//                repaint();
//            }
//        });
    }

    //Gerenciador de Status
    public enum AppSearchState {
        NONE,
        CLIENT,
        EMPLOYEE,
    }
}
