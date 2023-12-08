package br.com.advocateLink.view.screens;

import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.service.ClientService;
import br.com.advocateLink.view.panels.panelsClient.AlterClient;
import br.com.advocateLink.view.panels.panelsClient.RegisterClient;
import br.com.advocateLink.view.panels.panelsClient.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaClientes extends JFrame {

    private JButton jbCadastrar, jbPesquisar, jbAlterar, jbHome, jbCliente, jbFuncionario, jbArquivo, jbSistemas;
    private JLabel jlFundo;
    ClientService service;

    public TelaClientes() throws HeadlessException {

        setSize(800, 555);
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
        jbHome = new JButton();
        jbCliente = new JButton();
        jbFuncionario = new JButton();
        jbArquivo = new JButton();
        jbSistemas = new JButton();

        add(jbCadastrar);
        jbCadastrar.setBounds(360,170,200,38);
        jbCadastrar.setOpaque(false); // Tornar o botão transparente
        jbCadastrar.setContentAreaFilled(false); // Remover preenchimento
        jbCadastrar.setBorderPainted(false); // Remover borda

        add(jbPesquisar);
        jbPesquisar.setBounds(360,238,200,38);
        jbPesquisar.setOpaque(false); // Tornar o botão transparente
        jbPesquisar.setContentAreaFilled(false); // Remover preenchimento
        jbPesquisar.setBorderPainted(false); // Remover bord

        add(jbAlterar);
        jbAlterar.setBounds(360,310,200,38);
        jbAlterar.setOpaque(false); // Tornar o botão transparente
        jbAlterar.setContentAreaFilled(false); // Remover preenchimento
        jbAlterar.setBorderPainted(false); // Remover borda


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

        jlFundo = new JLabel();
        jlFundo.setIcon(new ImageIcon(getClass().getResource("/imagens/TelaCliente.png")));
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
                RegisterClient registerClient = new RegisterClient();
                RegisterClient client = new RegisterClient();
                getContentPane().removeAll();
                getContentPane().add(client);
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
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client c = service.search(Long.parseLong(JOptionPane.showInputDialog("DIGITE O ID DO CLIENTE")));
                    AlterClient clientt = new AlterClient(c);
                    getContentPane().removeAll();
                    getContentPane().add(clientt);
                    getContentPane().validate();
                    repaint();
                } catch (RuntimeException ex) {
                }
            }
        });
    }
}
