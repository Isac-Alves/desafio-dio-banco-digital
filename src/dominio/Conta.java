package dominio;

import exceptions.ValorDeSaqueDepositoInvalidoExecption;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract  class Conta {

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0;
        this.cliente = cliente;
    }

    private int agencia;

    private int numero;

    private double saldo;


    public  void sacar(double valorSaque) throws ValorDeSaqueDepositoInvalidoExecption {
        if (valorSaque > saldo || valorSaque < 1){
            throw new ValorDeSaqueDepositoInvalidoExecption("Não é possivel sacar valores menores que 1 ou que sejam maiores que o saldo na conta");
        }
        this.saldo -= valorSaque;
    }

    public  void depositar(double valorDeposito) throws ValorDeSaqueDepositoInvalidoExecption {
        if (valorDeposito < 1){
            throw new ValorDeSaqueDepositoInvalidoExecption("Não é possivel fazer depositos menores que 1 real");
        }
        this.saldo += valorDeposito;
    }

    public  void transferir(double valorTranferir, Conta contaDestino) {
        try {
            this.sacar(valorTranferir);
            contaDestino.depositar(valorTranferir);
        } catch (ValorDeSaqueDepositoInvalidoExecption e) {
            System.out.println("Não é possivel fazer uma tranferencia de valor acima do saldo ou que seja menor que 1");
        }
    }

    public abstract void imprimirExtrato();

    protected void imprimirInfosComuns(){
        System.out.printf("Titular: %s\nAgencia: %d\nNumero: %d\nSaldo: %.2f\n", this.cliente.getNome(), this.agencia, this.numero, this.saldo);
    }

}
