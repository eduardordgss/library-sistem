import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private static int contadorId = 1;
    private Livro livro;
    private String cliente;
    private boolean ativo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, String cliente){
        this.id = contadorId++;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolverLivro(){
        this.dataDevolucao = LocalDate.now();
        this.ativo = false;
        this.livro.setDisponivel(true);
    }

    @Override
    public String toString() {
        return  "id: " + id + " | " +
                "Livro: " + livro + " | " +
                "Cliente: " + cliente + " | " +
                "Data do empréstimo: " + dataEmprestimo + " | " +
                "Data da devolução: " + dataDevolucao;
    }
}
