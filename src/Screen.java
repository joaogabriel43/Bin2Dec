import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Screen extends JFrame{
	 
	 	private String numeroBinario = ""; // Variável para armazenar o número binário inserido pelos botões
	    private JLabel binarioLabel; // Label para exibir o número binário na interface gráfica

	    public Screen() {
	    	
	    	setTitle("Bin2Dec"); // Define o título da janela como "Bin2Dec"
	        setSize(800, 500); // Define o tamanho da janela para 800x500 pixels
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao clicar no botão de fechar (X)
	        setResizable(false); // Define que a janela não pode ser redimensionada
	        setLocationRelativeTo(null); // Centraliza a janela na tela
	        setLayout(new GridBagLayout()); // Usando GridBagLayout para layout flexível

	      // Usando GridBagLayout para posicionar os componentes de maneira organizada
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10); // Define o espaçamento entre os componentes
	        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes na tela

	     // Cria o JLabel para exibir o texto "Número Binário:"
	        JLabel numeroBinarioLabel = new JLabel("Número Binário: "); 
	        numeroBinarioLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte do texto
	        gbc.gridy = 0; // Primeira linha do layout
	        gbc.gridx = 0; // Primeira coluna
	        gbc.gridwidth = 2; // O label ocupa duas colunas
	        add(numeroBinarioLabel, gbc); // Adiciona o label à janela

	     // Cria o JLabel para exibir o número binário digitado dentro de uma caixa
	        binarioLabel = new JLabel(" "); // Inicialmente vazio
	        binarioLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte do texto
	        binarioLabel.setPreferredSize(new Dimension(300, 50)); // Tamanho fixo
	        binarioLabel.setHorizontalAlignment(JLabel.CENTER); // Centralizar o texto dentro do JLabel
	        binarioLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adiciona uma borda para parecer uma caixa
	        gbc.gridy = 1; // Segunda linha do layout
	        gbc.gridx = 0; // Primeira coluna
	        gbc.gridwidth = 2; // O label ocupa duas colunas
	        add(binarioLabel, gbc); // Adiciona o binarioLabel à janela

	     // Botão "1" para inserir o número binário "1"
	        JButton button1 = new JButton("1");
	        button1.setPreferredSize(new Dimension(100, 50)); // Define o tamanho fixo do botão
	        button1.setFont(new Font("Arial", Font.BOLD, 17)); // Define o estilo da fonte do botão
	        button1.setForeground(new Color(192, 192, 192)); // Define a cor do texto
	        button1.setBackground(new Color(0, 0, 0)); // Define a cor de fundo do botão
	        gbc.gridy = 2; // Terceira linha do layout
	        gbc.gridx = 0; // Primeira coluna
	        gbc.gridwidth = 1; // O botão ocupa apenas uma coluna
	        add(button1, gbc); // Adiciona o botão "1" à janela

	     // Botão "0" para inserir o número binário "0"
	        JButton button0 = new JButton("0");
	        button0.setPreferredSize(new Dimension(100, 50)); // Define o tamanho fixo do botão
	        button0.setFont(new Font("Arial", Font.BOLD, 17)); // Define o estilo da fonte do botão
	        button0.setForeground(new Color(192, 192, 192)); // Define a cor do texto
	        button0.setBackground(new Color(0, 0, 0)); // Define a cor de fundo do botão
	        gbc.gridx = 1; // Segunda coluna do layout
	        add(button0, gbc); // Adiciona o botão "0" à janela
	        
	     // Botão para calcular o valor decimal do número binário inserido
	        JButton calcButton = new JButton("Calcular Decimal");
	        calcButton.setFont(new Font("Arial", Font.BOLD, 17)); // Define o estilo da fonte do botão
	        gbc.gridy = 3; // Quarta linha do layout
	        gbc.gridx = 0; // Primeira coluna
	        gbc.gridwidth = 2; // O botão de calcular ocupa duas colunas
	        add(calcButton, gbc); // Adiciona o botão de calcular à janela

	     // Ação para o botão "1" - adiciona o dígito "1" ao número binário
	        button1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                adicionaDigito("1"); // Chama o método que adiciona "1" ao número binário
	            }
	        });

	        // Ação para o botão "0" - adiciona o dígito "0" ao número binário
	        button0.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                adicionaDigito("0"); // Chama o método que adiciona "0" ao número binário
	            }
	        });

	        // Ação para o botão "Calcular Decimal" - converte o número binário em decimal
	        calcButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calculaDecimal(); // Chama o método que calcula e exibe o número decimal
	            }
	        });

	        setVisible(true); // Torna a janela visível
	    }

	    // Método para adicionar os dígitos ao número binário, um de cada vez
	    private void adicionaDigito(String digito) {
	        if (numeroBinario.length() < 8) { // Limita a entrada a 8 dígitos binários
	            numeroBinario += digito; // Adiciona o dígito "0" ou "1" ao número binário
	            binarioLabel.setText(numeroBinario); // Atualiza o label com o número binário atual
	        } else {
	            // Exibe uma mensagem informando que o número binário já está completo
	            JOptionPane.showMessageDialog(this, "Número binário completo! Calcule o decimal.", "Atenção", JOptionPane.WARNING_MESSAGE);
	        }
	    }

	    // Método para converter o número binário em decimal e exibir o resultado
	    private void calculaDecimal() {
	        if (numeroBinario.isEmpty()) { // Verifica se o número binário está vazio
	            // Exibe uma mensagem de erro se nenhum número binário foi inserido
	            JOptionPane.showMessageDialog(this, "Insira um número binário antes de calcular.", "Erro", JOptionPane.ERROR_MESSAGE);
	        } else {
	            // Converte o número binário em um número decimal
	            int decimal = Integer.parseInt(numeroBinario, 2);
	            // Exibe o número decimal em uma janela de diálogo
	            JOptionPane.showMessageDialog(this, "Seu número decimal é: " + decimal, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	            numeroBinario = ""; // Reseta a variável para permitir uma nova inserção
	            binarioLabel.setText(" "); // Reseta o label para o estado inicial
	        }
	    }
}