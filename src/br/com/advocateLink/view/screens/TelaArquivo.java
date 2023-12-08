package br.com.advocateLink.view.screens;

import br.com.advocateLink.service.ClientService;
import br.com.advocateLink.view.panels.panelsClient.RegisterClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaArquivo extends JFrame {

    private JButton jbClientePesquisar, jbFuncionarioPesquisar, jbHome, jbCliente, jbFuncionario, jbArquivo, jbSistemas;
    private JLabel jlFundo;
    ClientService service;

    public TelaArquivo() throws HeadlessException {

        setSize(800, 555);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

        jbClientePesquisar = new JButton();
        jbFuncionarioPesquisar = new JButton();
        jbHome = new JButton();
        jbCliente = new JButton();
        jbFuncionario = new JButton();
        jbArquivo = new JButton();
        jbSistemas = new JButton();

        add(jbClientePesquisar);
        jbClientePesquisar.setBounds(360,170,200,38);
        jbClientePesquisar.setOpaque(false); // Tornar o botão transparente
        jbClientePesquisar.setContentAreaFilled(false); // Remover preenchimento
        jbClientePesquisar.setBorderPainted(false); // Remover borda

        add(jbFuncionarioPesquisar);
        jbFuncionarioPesquisar.setBounds(360,238,200,38);
        jbFuncionarioPesquisar.setOpaque(false); // Tornar o botão transparente
        jbFuncionarioPesquisar.setContentAreaFilled(false); // Remover preenchimento
        jbFuncionarioPesquisar.setBorderPainted(false); // Remover bord


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
        jlFundo.setIcon(new ImageIcon(getClass().getResource("/imagens/TelaArquivo.png")));
        add(jlFundo);
        jlFundo.setBounds(0, 0, 800, 500);


    }

    private void criarEventos() {

        //INICIO MENU
        jbCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaClientes  telaClientes = new TelaClientes();
                telaClientes.setVisible(true);
                TelaArquivo telaArquivo = new TelaArquivo();
                telaArquivo.setVisible(false);
            }
        });
        jbFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
                telaFuncionarios.setVisible(true);
                TelaArquivo telaArquivo = new TelaArquivo();
                telaArquivo.setVisible(false);
            }
        });
        jbArquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TelaArquivo telaArquivo = new TelaArquivo();
                telaArquivo.setVisible(true);
            }
        });
        jbSistemas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "TELA EM PROCESSO DE CRIAÇÃO" );
            }
        });
        //FIM MENU
        jbClientePesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPesquisa telaPesquisa = new TelaPesquisa();
                telaPesquisa.setVisible(true);
                setVisible(false);
            }
        });
        jbFuncionarioPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPesquisa telaPesquisa = new TelaPesquisa();
                telaPesquisa.setVisible(true);
                setVisible(false);
            }
        });

    }
}
