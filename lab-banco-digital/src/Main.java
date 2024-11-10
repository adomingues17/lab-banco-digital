import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String opcao = null;		
		String ccOuCp = null;
		String entrada = "x";
		
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);
		
		cc.depositar(1000);
		poupanca.depositar(500);
		
		do {
			System.out.println("Selecione a opção desejada." + "\n" + "1 - Depositar." + "\n" + "2 - Transferir." + "\n" + "3 - Extrato.");						
			opcao = scan.nextLine();
			System.out.println(" Selecione 1 para conta corrente ou 2 para conta poupança." );
			ccOuCp = scan.nextLine();
			
			if(opcao.equals("1") && ccOuCp.equals("1")) {
				System.out.println("Digite o valor a ser depositado." );
				double deposito = scan.nextInt();
				cc.depositar(deposito);
				System.out.println("Deseja imprimir o extrato? 1 - sim. 2 - não" );
				deposito = scan.nextInt();
				if(deposito == 1) {
					cc.imprimirExtrato();
				}
			}
			else if(opcao.equals("1") && ccOuCp.equals("2")) {
				System.out.println("Digite o valor a ser depositado." );
				double deposito = scan.nextInt();
				poupanca.depositar(deposito);
				System.out.println("Deseja imprimir o extrato? 1 - sim. 2 - não" );
				deposito = scan.nextInt();
				if(deposito == 1) {
					poupanca.imprimirExtrato();	
				}
			}
			else if(opcao.equals("2") && ccOuCp.equals("1")) {
				System.out.println("Digite o valor a ser transferido." );
				double transferencia = scan.nextInt();
				cc.transferir(transferencia, poupanca);				
				System.out.println("Deseja imprimir o extrato? 1 - sim. 2 - não" );
				transferencia = scan.nextInt();
				if(transferencia == 1) {
					cc.imprimirExtrato();
				}
			}
			else if(opcao.equals("2") && ccOuCp.equals("2")) {
				System.out.println("Digite o valor a ser transferido." );
				double transferencia = scan.nextInt();
				poupanca.transferir(transferencia, cc);
				System.out.println("Deseja imprimir o extrato? 1 - sim. 2 - não" );
				transferencia = scan.nextInt();
				if(transferencia == 1) {
					poupanca.imprimirExtrato();	
				}
			}
			else if(opcao.equals("3") && ccOuCp.equals("1")) {
				cc.imprimirExtrato();
			}
			else if(opcao.equals("3") && ccOuCp.equals("2")) {
				poupanca.imprimirExtrato();
			}			
			
		}while(!(entrada.equals("x")));
		
		System.out.println("Tchau.");
						
		scan.close();
	}
}