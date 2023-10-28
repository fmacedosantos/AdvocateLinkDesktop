package br.com.advocateLink.view.screens;

import br.com.advocateLink.classes.exceptions.UserNotFound;
import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.MethodsUtil;
import br.com.advocateLink.service.ClientService;
import br.com.advocateLink.service.EmployeeService;
import br.com.advocateLink.view.panels.painelEmployee.AlterEmployee;
import br.com.advocateLink.view.panels.painelEmployee.BonusEmployee;
import br.com.advocateLink.view.panels.painelEmployee.RegisterEmployee;
import br.com.advocateLink.view.panels.painelsAbout.GenereteRelatory;
import br.com.advocateLink.view.panels.panelsClient.RegisterClient;
import br.com.advocateLink.view.panels.panelsClient.Search;
import br.com.advocateLink.view.Main;
import br.com.advocateLink.view.panels.panelsClient.AlterClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Mainscreen extends JFrame {
    //Background
    private JLabel jlFundo;
    private JButton jbSair;
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
    //Gerenciador de Status
    public enum AppSearchState {
        NONE,
        OFF,
        CLIENT,
        EMPLOYEE,;
    }
    public static AppSearchState currentAppSearchState = AppSearchState.NONE;
    public Mainscreen(String title) throws HeadlessException {
        super(title);
        //Atributos da tela
        setSize(812, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarComponentes();
        criarEventos();
    }
    private void iniciarComponentes() {
        jmbBarra = new JMenuBar();
        jmCliente = new JMenu("Cliente");
        jmFuncionario = new JMenu("Funcionario");
        jmSistema = new JMenu("Sistema");
        jmSobre = new JMenu("Sobre");
        jmiCadastrarCliente = new JMenuItem("Cadastrar");
        jmiPesquisarCliente = new JMenuItem("Pesquisar");
        jmiAlterarCliente = new JMenuItem("Alterar");
        jmiCadastrarFuncionario = new JMenuItem("Cadastrar");
        jmiPesquisarFuncionario = new JMenuItem("Pesquisar");
        jmiAlterarFuncionario = new JMenuItem("Alterar");
        jmiBonusFuncionario = new JMenuItem("Bônus");
        jmiSistema = new JMenuItem("Sistema");
        jmiGerarRelatorio = new JMenuItem("Relatório");
        //Adicionar na tela
        setJMenuBar(jmbBarra);
        jmbBarra.add(jmCliente);
        jmbBarra.add(jmFuncionario);
        jmbBarra.add(jmSistema);
        jmbBarra.add(jmSobre);
        jmCliente.add(jmiCadastrarCliente);
        jmCliente.add(jmiPesquisarCliente);
        jmCliente.add(jmiAlterarCliente);
        jmFuncionario.add(jmiCadastrarFuncionario);
        jmFuncionario.add(jmiPesquisarFuncionario);
        jmFuncionario.add(jmiAlterarFuncionario);
        jmFuncionario.add(jmiBonusFuncionario);
        jmSistema.add(jmiSistema);
        jmSistema.add(jmiGerarRelatorio);
        jbSair = new JButton();
        jbSair.setBounds(350, 450, 110, 35);
        jbSair.setOpaque(false); // Tornar o botão transparente
        jbSair.setContentAreaFilled(false); // Remover preenchimento
        jbSair.setBorderPainted(false); // Remover borda
        add(jbSair);
        jlFundo = new JLabel();
        jlFundo.setIcon(new ImageIcon(getClass().getResource("/imagens/backgroundMain.png")));
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
        jmiCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                RegisterClient client = new RegisterClient();
                getContentPane().removeAll();
                getContentPane().add(client);
                getContentPane().validate();
                repaint();
            }
        });
        jmiCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                RegisterEmployee employee = new RegisterEmployee();
                getContentPane().removeAll();
                getContentPane().add(employee);
                getContentPane().validate();
                repaint();
            }
        });
        jmiAlterarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client c = service.search(Long.parseLong(JOptionPane.showInputDialog("DIGITE O ID DO CLIENTE")));
                    if (c.getOab()==null){
                        throw new NullPointerException("Cliente nao encontrado");
                    }
                    AlterClient clientt = new AlterClient(c);
                    getContentPane().removeAll();
                    getContentPane().add(clientt);
                    getContentPane().validate();
                    repaint();
                    } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                    }catch (NullPointerException  ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                    }catch (UserNotFound ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        jmiAlterarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Employee employeTemp = employeeService.search(Long.parseLong(JOptionPane.showInputDialog("DIGITE O ID DO CLIENTE")));
                    if (employeTemp.getSalary()==0){
                        throw new UserNotFound("Cliente nao encontrado");
                    }
                    AlterEmployee employeee = new AlterEmployee(employeTemp);
                    getContentPane().removeAll();
                    getContentPane().add(employeee);
                    getContentPane().validate();
                    repaint();
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Digite um Id valido");
                } catch (UserNotFound ex) {
                    JOptionPane.showMessageDialog(null,"Usuario nao encontrado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Sem conexao");
                }
            }
        });
        jmiGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenereteRelatory realatory = new GenereteRelatory();
                getContentPane().removeAll();
                getContentPane().add(realatory);
                getContentPane().validate();
                repaint();
            }
        });
        jmiPesquisarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainscreen.currentAppSearchState = Mainscreen.AppSearchState.CLIENT;
                Search search = new Search();
                getContentPane().removeAll();
                getContentPane().add(search);
                getContentPane().validate();
                repaint();
            }
        });
        jmiPesquisarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainscreen.currentAppSearchState = Mainscreen.AppSearchState.EMPLOYEE;
                Search search = new Search();
                getContentPane().removeAll();
                getContentPane().add(search);
                getContentPane().validate();
                repaint();
            }
        });
        jmiBonusFuncionario.addActionListener(new ActionListener() {
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
