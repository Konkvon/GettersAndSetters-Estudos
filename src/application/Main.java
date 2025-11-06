package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Account;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account conta;
		Double money;

		System.out.print("Informe o número da conta: ");
		String id_account = sc.next();
		System.out.print("Informe o nome do dono da conta: ");
		String name = sc.next();
		System.out.print("Há um primeiro depósito (y/n)? ");
		String resp = sc.next();

		if (resp.equals("y")) {
			System.out.print("Valor depósito inicial: ");
			Double initialDeposit = sc.nextDouble();
			conta = new Account(id_account, name, initialDeposit);
		} else {
			conta = new Account(id_account, name);
		}
		
		System.out.println("Dados da conta:");
		System.out.println(conta);

		while (!resp.equals("0")) {
			System.out.println();
			System.out.println("Escolha uma opção:");
			System.out.println("Depositar (1), Sacar (2), Alterar Nome(3), Sair (0)");
			System.out.print("Opção: ");
			resp = sc.next();

			if (resp.equals("1")) {
				System.out.print("Valor para depositar: ");
				money = sc.nextDouble();
				conta.addMoney(money);
				System.out.println("Depósito realizado com sucesso!");

			} else if (resp.equals("2")) {
				System.out.print("Valor para sacar: ");
				money = sc.nextDouble();
				String saque = conta.removeMoney(money) ? "\nSaque realizado com sucesso!\n" : "\nSaldo insuficiente!\n";
				System.out.println(saque);
				
			} else if(resp.equals("3")) {
				System.out.printf("Nome atual da conta: " + conta.getName());
				System.out.print("\nDeseja alterar o nome (y/n): ");
				resp = sc.next();
				if (resp.equals("y")) {
					System.out.print("Digite novo nome: ");
					String newname = sc.next();
					conta.setName(newname);
				}
			}
			
			System.out.println("Dados da conta atualizados:");
			System.out.println(conta);
		}
		System.out.println("\nObrigado!");
		sc.close();
	}
}
