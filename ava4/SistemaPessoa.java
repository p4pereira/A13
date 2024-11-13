import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Classe principal que contém o método main
public class SistemaPessoa {
    public static void main(String[] args) {
        String nomeUsuario = "denys.silva";
        String versaoSistema = "12.1.2024";
        
        // Cria a janela principal do sistema
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);
        
        // Cria instâncias das outras classes para adicionar os componentes à janela
        Menu menu = new Menu(principal);
        Rodape rodape = new Rodape(versaoSistema, nomeUsuario);
        
        // Área de trabalho (central)
        JTextArea areaTrabalho = new JTextArea();
        
        // Adiciona componentes ao frame principal
        principal.getContentPane().add(BorderLayout.NORTH, menu.getMenuPrincipal());
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, rodape.getPainelRodape());

        principal.setLocationRelativeTo(null); // Centraliza a janela
        principal.setVisible(true); // Torna a janela visível
    }
}

// Classe Menu, responsável por criar e configurar o menu do sistema
class Menu {
    private JMenuBar menuPrincipal;

    public Menu(JFrame principal) {
        menuPrincipal = new JMenuBar();
        
        // Criação dos menus
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        // Opções de Cadastro
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        // Opções de Visualização
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        // Adiciona evento de sair no menu Sair
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) { }

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        // Adiciona menus à barra de menu
        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);
    }

    public JMenuBar getMenuPrincipal() {
        return menuPrincipal;
    }
}

// Classe Rodape, responsável por criar o painel de rodapé do sistema
class Rodape {
    private JPanel painelRodape;
    private JLabel labelRodape;

    public Rodape(String versaoSistema, String nomeUsuario) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());
        
        painelRodape = new JPanel();
        labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);
    }

    public JPanel getPainelRodape() {
        return painelRodape;
    }
}
