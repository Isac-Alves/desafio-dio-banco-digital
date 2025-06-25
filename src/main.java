import dominio.Banco;
import dominio.Cliente;
import dominio.Conta;
import dominio.ContaCorrente;
import dominio.ContaPoupanca;
import exceptions.ValorDeSaqueDepositoInvalidoExecption;

public class main {

    public static void main(String[] args) {
        //criando banco
        Banco banco = new Banco("PeladoBank");

        //criando clientes
        Cliente cliente1 = new Cliente("José");
        Cliente cliente2 = new Cliente("Maria");

        //criando contas
        Conta contaCorrente = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente2);

        //adicionando contas ao banco
        banco.addConta(contaCorrente);
        banco.addConta(poupanca);

        //listanto clientes do banco
        System.out.println("Lista de todos os clientes do " + banco.getNome() + ": ");
        System.out.println(banco.listarClientes());

        try {
            System.out.println("======================================");
            contaCorrente.depositar(100);
            System.out.println("Conta de " + contaCorrente.getCliente().getNome() + " com deposito de 100");
            contaCorrente.imprimirExtrato();
            System.out.println("======================================");

            contaCorrente.transferir(50,poupanca);
            System.out.println("Conta de " + contaCorrente.getCliente().getNome() + " depois de tranferir 50 para " + poupanca.getCliente().getNome());
            contaCorrente.imprimirExtrato();
            System.out.println("======================================");

            System.out.println("Conta de " + poupanca.getCliente().getNome() + " depois de receber uma tranferencia de " + contaCorrente.getCliente().getNome());
            poupanca.imprimirExtrato();
            System.out.println("======================================");

            System.out.println("Conta de " + poupanca.getCliente().getNome() + " depois de sacar 2");
            poupanca.sacar(2);
            poupanca.imprimirExtrato();
            System.out.println("======================================");

        } catch (ValorDeSaqueDepositoInvalidoExecption e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lista de clientes apos a remoçao da conta de " + poupanca.getCliente().getNome());
        banco.removeConta(poupanca);
        System.out.println(banco.listarClientes());
        System.out.println("======================================");

    }
}
