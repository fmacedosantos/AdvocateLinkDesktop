package br.com.advocateLink.view.panels.panelsClient;

import br.com.advocateLink.classes.models.Client;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.service.ClientService;
import br.com.advocateLink.service.EmployeeService;
import br.com.advocateLink.view.screens.Mainscreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

public class Search extends JPanel {

    private JTextField jtfPesquisar;
    private JButton jbPesquisar;
    private JLabel jlFundoPesquisar, lfotoUser, lnomeuser, lcpf, ltelefone, lemail, lOAB, lareaatuacao;
    private EmployeeService employeeService = new EmployeeService();
    private ClientService clientService = new ClientService();

    public Search() {
        super();
        setSize(815, 538);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jlFundoPesquisar = new JLabel();
        jlFundoPesquisar.setIcon(new ImageIcon(getClass().getResource("/imagens/backgroundSearch.png")));
        lfotoUser = new JLabel();
        add(lfotoUser);
        Font fonte = new Font("Arial", Font.PLAIN, 18);
        jtfPesquisar = new JTextField();
        add(jtfPesquisar);
        jtfPesquisar.setFont(fonte);
        jtfPesquisar.setBounds(80, 85, 300, 38);
        jtfPesquisar.setOpaque(false);
        jtfPesquisar.setBorder(null);
        jbPesquisar = new JButton();
        add(jbPesquisar);
        jbPesquisar.setBounds(400, 85, 38, 38);
//        jbPesquisar.setOpaque(false);
//        jbPesquisar.setBorder(null);
//        jbPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        jbPesquisar.setBackground(new Color(0, 0, 0, 0));
//        jbPesquisar.setContentAreaFilled(false);
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
        add(jlFundoPesquisar);
        jlFundoPesquisar.setBounds(0, 0, 800, 500);

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
        lnomeuser.setBounds(310, 170, 300, 30);
        lcpf.setText("CPF: " + client.getCpf());
        lcpf.setFont(font);
        lcpf.setBounds(310, 200, 250, 30);
        ltelefone.setText("Tel: " + client.getContato().getTelefone());
        ltelefone.setFont(font);
        ltelefone.setBounds(310, 230, 250, 30);
        lemail.setText("Email: " + client.getContato().getEmail());
        lemail.setFont(font);
        lemail.setBounds(310, 260, 400, 30);
        lOAB.setText("OAB: " + client.getOab());
        lOAB.setFont(font);
        lOAB.setBounds(310, 290, 200, 30);
        lareaatuacao.setText("Area atuacao: " + client.getAreaAtuacao());
        lareaatuacao.setFont(font);
        lareaatuacao.setBounds(310, 320, 350, 30);
        add(jlFundoPesquisar);
        jlFundoPesquisar.setBounds(0, 0, 800, 500);
    }

    private void setinfromacao(Employee employee) {
        Font font = new Font(Font.SERIF, Font.BOLD, 18);
        lnomeuser.setText("Nome: " + employee.getNome());
        lnomeuser.setFont(font);
        lnomeuser.setBounds(310, 170, 300, 30);
        lcpf.setText("CPF: " + employee.getCpf());
        lcpf.setFont(font);
        lcpf.setBounds(310, 200, 250, 30);
        ltelefone.setText("Tel: " + employee.getContato().getTelefone());
        ltelefone.setFont(font);
        ltelefone.setBounds(310, 230, 250, 30);
        lemail.setText("Email: " + employee.getContato().getEmail());
        lemail.setFont(font);
        lemail.setBounds(310, 260, 400, 30);
        lOAB.setText("Salario: " + employee.getSalary());
        lOAB.setFont(font);
        lOAB.setBounds(310, 290, 200, 30);
        lareaatuacao.setText("Cargo: " + employee.getRole());
        lareaatuacao.setFont(font);
        lareaatuacao.setBounds(310, 320, 350, 30);
        add(jlFundoPesquisar);
        jlFundoPesquisar.setBounds(0, 0, 800, 500);
    }

    private void criarEventos() throws NullPointerException {
        jbPesquisar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Mainscreen.currentAppSearchState == Mainscreen.AppSearchState.CLIENT) {
                    try {
                        // Pesquisa o Cliente a partir do nome
                        Client tempClint = clientService.search(Long.parseLong(jtfPesquisar.getText()));
                        lfotoUser.setIcon(setfoto(tempClint));
                        lfotoUser.setText("TEXTEEEEE");
                        lfotoUser.setBounds(100, 155, 200, 200);
                        setinfromacao(tempClint);
                    } catch (IOException ex) {
                        lfotoUser.setIcon(new ImageIcon(getClass().getResource("/imagens/defalt.png")));
                        lfotoUser.setBounds(100, 155, 200, 200);
                        // Pesquisa o Cliente a partir do nome
                        Client tempClint = clientService.search(Long.parseLong(jtfPesquisar.getText()));
                        lfotoUser.setBounds(100, 155, 200, 200);
                        setinfromacao(tempClint);
                        System.out.println(ex.getMessage());
                    } catch (RuntimeException ex) {
                    }
                } else if (Mainscreen.currentAppSearchState == Mainscreen.AppSearchState.EMPLOYEE) {
                    try {
                        Employee tempEmployee = employeeService.search(Long.parseLong(jtfPesquisar.getText()));
                        lfotoUser.setIcon(setfoto(tempEmployee));
                        lfotoUser.setBounds(100, 155, 200, 200);
                        setinfromacao(tempEmployee);
                    } catch (IOException ex) {
                        lfotoUser.setIcon(new ImageIcon(getClass().getResource("/imagens/defalt.png")));
                        lfotoUser.setBounds(100, 155, 200, 200);
                        Employee tempEmployee = null;
                        tempEmployee = employeeService.search(Long.parseLong(jtfPesquisar.getText()));
                        lfotoUser.setBounds(100, 155, 200, 200);
                        setinfromacao(tempEmployee);
                        System.out.println(ex.getMessage());
                    } catch (RuntimeException ex) {
                    }
                }
            }
        });
    }
}
