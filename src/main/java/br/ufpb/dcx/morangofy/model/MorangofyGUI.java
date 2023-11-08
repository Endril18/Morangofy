package br.ufpb.dcx.morangofy.model;

import br.ufpb.dcx.morangofy.model.Controllers.*;

import javax.swing.*;
import java.awt.*;

public class MorangofyGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon img = new ImageIcon("./imgs/morangofy.png");
    Morangofy morangofy = new Morangofy();
    JMenuBar barraDeMenu = new JMenuBar();

    public MorangofyGUI() {
        setTitle("Morangofy");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);

        ImageIcon backgroundImage = new ImageIcon("./imgs/morangofy.png");
        JLabel backgraunfLabel = new JLabel(backgroundImage);
        setContentPane(backgraunfLabel);

        linha1 = new JLabel("", JLabel.CENTER);
        linha1.setForeground(Color.white);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));


        setLayout(new BorderLayout());

        add(linha1, BorderLayout.NORTH);  // Adiciona linha1 no topo
        add(new JLabel(), BorderLayout.CENTER);  // Preenche o centro

        JMenu menuAdicionar = new JMenu("Adicionar");
        JMenuItem menuAdicionarMusica = new JMenuItem("Adicionar Música");
        menuAdicionar.add(menuAdicionarMusica);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarMusica = new JMenuItem("Pesquisar Música");
        menuPesquisar.add(menuPesquisarMusica);

        JMenu menuRemover = new JMenu("Apagar");
        JMenuItem menuRemoverMusica = new JMenuItem("Apagar Música");
        menuRemover.add(menuRemoverMusica);

        JMenu menuListar = new JMenu("Músicas");
        JMenuItem menuListarMusicas = new JMenuItem("Músicas Adicionadas");
        menuListar.add(menuListarMusicas);

        JMenu menuAtualizar = new JMenu("Editar");
        JMenuItem menuUpdateMusicas = new JMenuItem("Editar Músicas");
        menuAtualizar.add(menuUpdateMusicas);

        JMenu menuSobreNos = new JMenu("Sobre");
        JMenuItem menuSobre = new JMenuItem("Sobre Nós");
        menuSobreNos.add(menuSobre);

        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new LeaveController(morangofy, this));


        menuPesquisarMusica.addActionListener(new SearchController(morangofy, this));
        menuRemoverMusica.addActionListener(new RemoveController(morangofy, this));
        menuListarMusicas.addActionListener(new AllMusicController(morangofy, this));
        menuUpdateMusicas.addActionListener(new UpdateController(morangofy, this));
        menuSobre.addActionListener(new AboutUsController(morangofy, this));
        menuAdicionarMusica.addActionListener(ae -> {
            Long idMusica = Long.valueOf(morangofy.musicasAdicionadas().size() + 1);

            String nome = JOptionPane.showInputDialog(this, "Qual é o nome da música?");
            String criacaoStr = JOptionPane.showInputDialog(this, "[1] Banda\n[2] Artista");

            int criacao = 0;
            if (criacaoStr != null && !criacaoStr.isEmpty()) {
                criacao = Integer.parseInt(criacaoStr);
            }
            String banda = "";
            String nomeArtista = "";

            if (criacao == 1) {
                banda = JOptionPane.showInputDialog(this, "Qual é o nome da banda?");
            } else if (criacao == 2) {
                nomeArtista = JOptionPane.showInputDialog(this, "Qual é o nome do(s) artista(s)?");
            } else {
                JOptionPane.showMessageDialog(this, "Informe uma opção válida");
            }

            String album = JOptionPane.showInputDialog(this, "Qual é o nome do álbum?");

            if (!nome.isEmpty()) {
                if (banda == null || banda.isEmpty()) {
                    banda = "S/D";
                }
                if (nomeArtista == null || nomeArtista.isEmpty()) {
                    nomeArtista = "S/D";
                }
                if (album == null || album.isEmpty()) {
                    album = "S/D";
                }

                Musica musica = new Musica(idMusica, nome, banda, nomeArtista, album);
                boolean cadastrou = morangofy.adicionarMusica(musica);

                if (cadastrou) {
                    JOptionPane.showMessageDialog(this, "Música adicionada");
                } else {
                    JOptionPane.showMessageDialog(this, "Música não foi adicionada. Verifique se já não existe");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Preencha os campos corretamente");
            }
        });
        barraDeMenu.add(menuAdicionar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuListar);
        barraDeMenu.add(menuAtualizar);
        barraDeMenu.add(menuSobreNos);
        barraDeMenu.add(botaoSair);
        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        JFrame janela = new MorangofyGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
