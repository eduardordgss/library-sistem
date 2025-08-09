import java.time.LocalDate;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNasc;

    public Autor(int id, String nome, LocalDate dataNasc){
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " +
                "Nome: " + nome + " | " +
                "Data de nascimento: " + dataNasc +
                "\n";
    }
}
