package view.test.screens;

import classes.models.Clients;
import classes.shared.client.MethodsUtil;
import view.test.panels.panelsClient.AlterClient;
import view.test.panels.panelsClient.RegisterClient;
import view.test.panels.panelsClient.painelEmployee.AlterEmployee;
import view.test.panels.panelsClient.painelEmployee.BonusEmployee;
import view.test.panels.panelsClient.painelEmployee.RegisterEmployee;
import view.test.panels.panelsClient.painelsAbout.GenereteRelatory;
import view.test.panels.panelsClient.painelsAbout.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                getContentPane().add(client);
                getContentPane().validate();//
                repaint(); // atualiza a tela
            }
        });
        jmiCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                RegisterEmployee employee = new RegisterEmployee();
                getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                getContentPane().add(employee);
                getContentPane().validate();//
                repaint(); // atualiza a tela
            }
        });
        jmiAlterarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nomeDoCliente = JOptionPane.showInputDialog("DIGITE O NOME DO CLIENTE");
                    AlterClient clientt = new AlterClient(MethodsUtil.searchClient(nomeDoCliente));
                    getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                    getContentPane().add(clientt);
                    getContentPane().validate();//
                    repaint(); // atualiza a tela
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null,"Cliente inexistente, confira os dados");
                    System.out.println(ex.getMessage()+" exception ao procurar nome inexistente");
                }
            }
        });
        jmiAlterarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlterEmployee employee = new AlterEmployee();
                getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                getContentPane().add(employee);
                getContentPane().validate();//
                repaint(); // atualiza a tela
            }
        });
        jmiGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenereteRelatory realatory = new GenereteRelatory();
                getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                getContentPane().add(realatory);
                getContentPane().validate();//
                repaint(); // atualiza a tela
            }
        });
        jmiPesquisarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search search = new Search();
                getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                getContentPane().add(search);
                getContentPane().validate();//
                repaint(); // atualiza a tela
            }
        });
        jmiPesquisarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search search = new Search();
                getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                getContentPane().add(search);
                getContentPane().validate();//
                repaint(); // atualiza a tela
            }
        });
        jmiBonusFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BonusEmployee bonus = new BonusEmployee();
                getContentPane().removeAll(); //REMOVE TODOS OS COMPONENTES
                getContentPane().add(bonus);
                getContentPane().validate();//
                repaint(); // atualiza a tela
            }
        });
    }
}
