package dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {

    private String nome;

    private List<Conta> contas;

    public Banco(String nome) {
        this.contas = new ArrayList<>();
        this.nome = nome;
    }

    public List<Cliente> listarClientes(){
        return this.contas.stream().map(conta -> conta.getCliente()).toList();

    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public void removeConta(Conta conta){
        this.contas.remove(conta);
    }
}
