package br.com.advocateLink.classes.shared.employee;

import br.com.advocateLink.classes.models.Employee;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class EmployeeRenderer extends JPanel implements ListCellRenderer<Employee> {
    private JLabel lbIcon = new JLabel();
    private JLabel lbName = new JLabel();
    private JLabel lbcpf = new JLabel();
    private JLabel lbrua = new JLabel();
    private JLabel lbtel = new JLabel();
    private JLabel lbrole = new JLabel();
    private ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/defalt.png"));
    public EmployeeRenderer() {
        setLayout(new BorderLayout(5, 5));
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbName);
        panelText.add(lbcpf);
        panelText.add(lbrua);
        panelText.add(lbtel);
        panelText.add(lbrole);
        add(lbIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }
    private ImageIcon setfoto(Employee employee) throws IOException {
        URL url = new URL(employee.getUrlfoto());
        Image image = ImageIO.read(url);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends Employee> list, Employee value, int index, boolean isSelected, boolean cellHasFocus) {
        try {

            ImageIcon img = new ImageIcon(setfoto(value).getImage().getScaledInstance(100,150,1));
            lbIcon.setIcon(img);
        } catch (IOException e) {
            ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(100,150,1));
            lbIcon.setIcon(img);
        }
        lbName.setText("NOME: "+value.getNome());
        lbcpf.setText("CPF: "+value.getCpf());
        lbrua.setText("RUA: "+value.getEndereco().getRua()+", NUMERO: "+ value.getEndereco().getNumero()+", BAIRRO: "+value.getEndereco().getBairro());
        lbtel.setText("TELEFONE: "+ value.getContato().getTelefone()+ ", EMAIL: "+value.getContato().getEmail());
        lbrole.setText("CARGO: "+value.getRole()+", SALARIO: "+value.getSalary());
        return this;
    }
}
