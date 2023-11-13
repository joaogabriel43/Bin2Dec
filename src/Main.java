import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);;
		System.out.println("Digite um numero binario(Digite um numero de cada vez): // Enter a binary number (Enter one number at a time):");
		String numeroBinario = "";
		
		for (int i = 0; i < 8; i++) {
			String temp = "";
			
			temp = sc.next();
			if(temp.equals("0") || temp.equals("1"))
				numeroBinario = numeroBinario+temp;
			else {
				i--;
				System.out.println("Numero diferente de 0 ou 1, Digite o numero novamente // Number other than 0 or 1, Enter the number again");
			}
			System.out.println("O numero binario atual é: // The current binary number is: " + numeroBinario);
			if(i == 7) {
				System.out.println("Voce deseja inserir mais numeros binarios? 1 para Continuar a sequencia - 2 para adicionar um numero diferente - 3 Nao // Do you want to enter more binary numbers? 1 for Continue the sequence - 2 for adding a different number - 3 No");
				int opt = sc.nextInt();
				if(opt == 1){
					i=0;
					System.out.println("Continue digitando o numero decimal // Continue typing the decimal number");
				}
				else if(opt == 2) {
					int decimal = Integer.parseInt(numeroBinario, 2);
					System.out.println("Seu numero decimal é: // Its decimal number is: "+ decimal);
					i =0;
					numeroBinario = "";
					System.out.println("Digite o novo numero decimal: // Enter the new decimal number: ");
				}
				else {
					break;
				}
			}
		}
		int decimal = Integer.parseInt(numeroBinario, 2);
		System.out.println("Seu numero decimal é: // Its decimal number is: "+ decimal);
	}

}
