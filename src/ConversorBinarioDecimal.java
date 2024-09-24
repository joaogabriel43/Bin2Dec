import java.util.Scanner;

public class ConversorBinarioDecimal {

	public void converteBinario() {
		Scanner sc = new Scanner(System.in);
        
        // Solicita ao usuário que insira um número binário, um dígito de cada vez
        System.out.println("Digite um numero binario(Digite um numero de cada vez): // Enter a binary number (Enter one number at a time):");
        String numeroBinario = ""; // Variável que armazenará o número binário

        // Laço para coletar até 8 dígitos binários
        for (int i = 0; i < 8; i++) {
            String temp = "";

            // Lê o próximo valor inserido pelo usuário
            temp = sc.next();
            
            // Verifica se o valor é '0' ou '1', que são os únicos válidos em um número binário
            if(temp.equals("0") || temp.equals("1"))
                numeroBinario = numeroBinario + temp; // Adiciona o dígito à string do número binário
            else {
                i--; // Caso o valor seja inválido, decrementa o contador para repetir a inserção
                System.out.println("Numero diferente de 0 ou 1, Digite o numero novamente // Number other than 0 or 1, Enter the number again");
            }
            
            // Exibe o número binário atual conforme o usuário vai inserindo
            System.out.println("O numero binario atual é: // The current binary number is: " + numeroBinario);

            // Quando o oitavo dígito binário é inserido
            if(i == 7) {
                // Pergunta se o usuário deseja continuar inserindo mais dígitos binários
                System.out.println("Voce deseja inserir mais numeros binarios? \n- 1 para Continuar a sequencia \n- 2 para adicionar um numero diferente \n- 3 Nao \n// Do you want to enter more binary numbers? \n- 1 for Continue the sequence \n- 2 for adding a different number \n- 3 No");
                
                int opt = sc.nextInt(); // Lê a opção escolhida pelo usuário

                // Se o usuário escolher continuar (opção 1)
                if(opt == 1){
                    i = 0; // Reinicia o contador para permitir mais dígitos
                    System.out.println("Continue digitando o numero decimal // Continue typing the decimal number");
                }
                // Se o usuário quiser inserir um novo número binário (opção 2)
                else if(opt == 2) {
                    // Converte o número binário em decimal e exibe o resultado
                    int decimal = Integer.parseInt(numeroBinario, 2);
                    System.out.println("Seu numero decimal é: // Its decimal number is: " + decimal);
                    
                    // Reinicia o processo para um novo número binário
                    i = 0;
                    numeroBinario = "";
                    System.out.println("Digite o novo numero decimal: // Enter the new decimal number: ");
                }
                // Se o usuário escolher não continuar (opção 3), sai do laço
                else {
                    break;
                }
            }
        }

        // Após o laço, converte e exibe o número binário final em decimal
        int decimal = Integer.parseInt(numeroBinario, 2);
        System.out.println("Seu numero decimal é: // Its decimal number is: " + decimal);
    }
}