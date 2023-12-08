package br.com.advocateLink.view.screens;

import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.connections.database.ConnectionDataBase;
import br.com.advocateLink.service.ClientService;
import br.com.advocateLink.service.EmployeeService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaPesquisa extends JFrame {
    private JTextField jtfPesquisar;
    private JButton jbPesquisarCodigo;
    private JButton jbCadastrar, jbPesquisar, jbAlterar, jbHome, jbCliente, jbFuncionario, jbArquivo, jbSistemas;
    private JLabel jlFundo;
    private JLabel lfotoUser, lnomeuser, lcpf, ltelefone, lemail, lOAB, lareaatuacao;
    private EmployeeService employeeService = new EmployeeService();
    private ClientService clientService = new ClientService();
    public TelaPesquisa() throws HeadlessException {
        setSize(800, 530);
        setLayout(null);
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
        jbCadastrar.setBounds(360,270,200,38);
        jbCadastrar.setOpaque(false); // Tornar o botão transparente
        jbCadastrar.setContentAreaFilled(false); // Remover preenchimento
        jbCadastrar.setBorderPainted(false); // Remover borda
//
        add(jbPesquisar);
        jbPesquisar.setBounds(360,238,200,38);
        jbPesquisar.setOpaque(false); // Tornar o botão transparente
        jbPesquisar.setContentAreaFilled(false); // Remover preenchimento
        jbPesquisar.setBorderPainted(false); // Remover bord
//
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



        lfotoUser = new JLabel();
        add(lfotoUser);
        Font fonte = new Font("Arial", Font.PLAIN, 18);

        jtfPesquisar = new JTextField();
        add(jtfPesquisar);
        jtfPesquisar.setFont(fonte);
        jtfPesquisar.setBounds(210, 75, 470, 38);
        jtfPesquisar.setOpaque(false);
        jtfPesquisar.setBorder(null);

        jbPesquisarCodigo = new JButton();
        add(jbPesquisarCodigo);
        jbPesquisarCodigo.setBounds(685, 75, 38, 38);
        jbPesquisarCodigo.setOpaque(false);
        jbPesquisarCodigo.setBorder(null);
        jbPesquisarCodigo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbPesquisarCodigo.setBackground(new Color(0, 0, 0, 0));
        jbPesquisarCodigo.setContentAreaFilled(false);

        lnomeuser = new JLabel();
        add(lnomeuser);
        lcpf = new JLabel();
        add(lcpf);
        ltelefone = new JLabel();
        add(ltelefone);
        lemail = new JLabel();
        add(lemail);
        lOAB = new JLabel();
        add(lOAB);
        lareaatuacao = new JLabel();
        add(lareaatuacao);


        jlFundo = new JLabel();
        jlFundo.setIcon(new ImageIcon(getClass().getResource("/imagens/TelaPesquisa.png")));
        add(jlFundo);
        jlFundo.setBounds(0, 0, 800, 500);
    }

    private ImageIcon setfoto(Employee employee) throws IOException {
        URL url = new URL(employee.getUrlfoto());
        Image image = ImageIO.read(url);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    private ImageIcon setfoto(Client client) throws IOException {
        URL url = new URL(client.getUrlfoto());
        Image image = ImageIO.read(url);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    private void setinfromacao(Client client) {
        Font font = new Font(Font.SERIF, Font.BOLD, 18);
        lnomeuser.setText("Nome: " + client.getNome());
        lnomeuser.setFont(font);
        lnomeuser.setBounds(460, 170, 300, 30);
        lcpf.setText("CPF: " + client.getCpf());
        lcpf.setFont(font);
        lcpf.setBounds(460, 200, 250, 30);
        ltelefone.setText("Tel: " + client.getContato().getTelefone());
        ltelefone.setFont(font);
        ltelefone.setBounds(460, 230, 250, 30);
        lemail.setText("Email: " + client.getContato().getEmail());
        lemail.setFont(font);
        lemail.setBounds(460, 260, 400, 30);
        lOAB.setText("OAB: " + client.getOab());
        lOAB.setFont(font);
        lOAB.setBounds(460, 290, 200, 30);
        lareaatuacao.setText("Area atuacao: " + client.getAreaAtuacao());
        lareaatuacao.setFont(font);
        lareaatuacao.setBounds(460, 320, 350, 30);
        add(jlFundo);
        jlFundo.setBounds(0, 0, 800, 500);
    }

    private void setinfromacao(Employee employee) {
        Font font = new Font(Font.SERIF, Font.BOLD, 18);
        lnomeuser.setText("Nome: " + employee.getNome());
        lnomeuser.setFont(font);
        lnomeuser.setBounds(460, 170, 300, 30);
        lcpf.setText("CPF: " + employee.getCpf());
        lcpf.setFont(font);
        lcpf.setBounds(460, 200, 250, 30);
        ltelefone.setText("Tel: " + employee.getContato().getTelefone());
        ltelefone.setFont(font);
        ltelefone.setBounds(460, 230, 250, 30);
        lemail.setText("Email: " + employee.getContato().getEmail());
        lemail.setFont(font);
        lemail.setBounds(460, 260, 400, 30);
        lOAB.setText("Salario: " + employee.getSalary());
        lOAB.setFont(font);
        lOAB.setBounds(460, 290, 200, 30);
        lareaatuacao.setText("Cargo: " + employee.getRole());
        lareaatuacao.setFont(font);
        lareaatuacao.setBounds(460, 320, 350, 30);
        add(jlFundo);
        jlFundo.setBounds(0, 0, 800, 500);
    }

    private void criarEventos() {

        jbPesquisarCodigo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // processo que pega o id digitado e verifica se a coluna salary está nula
                String sql = "SELECT salary FROM advocatelink.Manageable WHERE id = ?";
                String sqlIdExiste = "SELECT * FROM advocatelink.Manageable WHERE id = ?";
                ConnectionDataBase conexao = new ConnectionDataBase();
                PreparedStatement statement, statement1;
                int id = Integer.parseInt(jtfPesquisar.getText());
                ResultSet resultado, resultado1;
                Double salario = null;
                int idExistente = 0;
                try {
                    statement = conexao.connectionDB().prepareStatement(sql);
                    statement1 = conexao.connectionDB().prepareStatement(sqlIdExiste);
                    statement.setInt(1, id);
                    statement1.setInt(1, id);
                    resultado = statement.executeQuery();
                    resultado1 = statement1.executeQuery();
                    if (resultado.next() && resultado1.next()) {
                        salario = resultado.getDouble("salary");
                        idExistente = resultado1.getInt("id");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


                // caso seja nula, é um cliente

                    if (!(idExistente == 0) && salario == null) {
                        try {
                            // Pesquisa o Cliente a partir do nome
                            Client tempClint = clientService.search(Long.parseLong(jtfPesquisar.getText()));
                            lfotoUser.setIcon(setfoto(tempClint));
                            lfotoUser.setText("TEXTEEEEE");
                            lfotoUser.setBounds(250, 155, 200, 200);
                            setinfromacao(tempClint);
                        } catch (IOException ex) {
                            lfotoUser.setIcon(new ImageIcon(getClass().getResource("/imagens/defalt.png")));
                            lfotoUser.setBounds(250, 155, 200, 200);
                            // Pesquisa o Cliente a partir do nome
                            Client tempClint = clientService.search(Long.parseLong(jtfPesquisar.getText()));
                            lfotoUser.setBounds(250, 155, 200, 200);
                            setinfromacao(tempClint);
                            System.out.println(ex.getMessage());
                        } catch (RuntimeException ex) {
                        }
                    } else if (!(idExistente == 0) && salario != null){
                        try {
                            Employee tempEmployee = employeeService.search(Long.parseLong(jtfPesquisar.getText()));
                            lfotoUser.setIcon(setfoto(tempEmployee));
                            lfotoUser.setBounds(250, 155, 200, 200);
                            setinfromacao(tempEmployee);
                        } catch (IOException ex) {
                            lfotoUser.setIcon(new ImageIcon(getClass().getResource("/imagens/defalt.png")));
                            lfotoUser.setBounds(250, 155, 200, 200);
                            Employee tempEmployee = null;
                            tempEmployee = employeeService.search(Long.parseLong(jtfPesquisar.getText()));
                            lfotoUser.setBounds(250, 155, 200, 200);
                            setinfromacao(tempEmployee);
                            System.out.println(ex.getMessage());
                        } catch (RuntimeException ex) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Código não existente.",
                                "Aviso:", JOptionPane.WARNING_MESSAGE);
                    }

            }
        });

        jbHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Mainscreen mainscreen = new Mainscreen("AdvocateLink");
                mainscreen.setVisible(true);
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

    }
}
