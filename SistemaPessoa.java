import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaPessoa extends JFrame {
    
    public SistemaPessoa() {
        // Configuração da janela principal
        setTitle("Sistema de Pessoa");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Criação do layout principal
        setLayout(new BorderLayout());

        // Adiciona o menu dinâmico na janela
        JMenuBar menuBar = criarMenu();
        setJMenuBar(menuBar);

        // Adiciona o rodapé
        JPanel rodape = criarRodape();
        add(rodape, BorderLayout.SOUTH);
    }

    // Método para criar o menu dinâmico
    private JMenuBar criarMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem menuSair = new JMenuItem("Sair");

        // Subitens do menu "Cadastro"
        JMenuItem usuariosItem = new JMenuItem("Usuários");
        JMenuItem pessoasItem = new JMenuItem("Pessoas");
        menuCadastro.add(usuariosItem);
        menuCadastro.add(pessoasItem);

        // Subitens do menu "Visualização"
        JMenuItem listaUsuariosItem = new JMenuItem("Lista de usuário");
        JMenuItem listaPessoasItem = new JMenuItem("Lista de Pessoas");
        menuVisualizacao.add(listaUsuariosItem);
        menuVisualizacao.add(listaPessoasItem);

        // Ação do item "Sair"
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra o programa ao clicar em "Sair"
            }
        });

        // Adiciona menus ao menuBar
        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);

        return menuBar;
    }

    // Método para criar o rodapé
    private JPanel criarRodape() {
        JPanel rodape = new JPanel();
        rodape.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel mensagemRodape = new JLabel("Avaliação 3 Parcial – GUI Principal");
        rodape.add(mensagemRodape);

        return rodape;
    }

    public static void main(String[] args) {
        // Inicia a aplicação
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaPessoa().setVisible(true);
            }
        });
    }
}
