import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public List<Livro> listarLivros(){
        for(Livro livro: livros){
            System.out.printf("id: %-3d | Título: %-20s | Autor: %-20s | Disponível: %-8b%n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome(), livro.isDisponivel());
        }
        return livros;
    }

    public List<Livro> listarLivrosDisponiveis(){
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for(Livro livro : livros){
            if(livro.isDisponivel()){
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public Livro buscarLivrosPorID(int id){
        for(Livro livro: livros){
            if(livro.getId() == id){
                return livro;
            }
        }
        return null;
    }

    public void atualizarLivro(int id, String novoTitulo){
        for(Livro livro: livros){
            if(livro.getId() == id){
                livro.setTitulo(novoTitulo);
                break;
            }
        }
    }

    public void removerLivro(int id){
        livros.removeIf(livro -> livro.getId() == id);
    }

    public void adicionarAutor(Autor autor){
        autores.add(autor);
    }

    public List<Autor> listarAutores(){
        for(Autor autor: autores){
            System.out.printf("id: %-3d | Nome: %-20s | Data de nascimento: %s%n", autor.getId(), autor.getNome(), autor.getDataNasc());
        }
        return autores;
    }

    public Autor buscarAutorPorID(int id){
        for(Autor autor: autores){
            if(autor.getId() == id){
                return autor;
            }
        }
        return null;
    }

    public void atualizarAutor(int id, String novoNome){
        for(Autor autor: autores){
            if(autor.getId() == id){
                autor.setNome(novoNome);
                break;
            }
        }
    }

    public void removerAutor(int id){
        autores.removeIf(autor -> autor.getId() == id);
    }

    public void emprestarLivros(Livro livro, String cliente){
        if(livro.isDisponivel()){
            Emprestimo emprestimo = new Emprestimo(livro, cliente);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        } else {
            System.out.println("O livro não está disponível para empréstimo.");
        }
    }

    public void devolverLivros(int idEmprestimo){
        for(Emprestimo emprestimo : emprestimos){
            if(emprestimo.getId() == idEmprestimo && emprestimo.isAtivo()){
                emprestimo.devolverLivro();
                break;
            }
        }
    }

    public List<Emprestimo> getEmprestimos(){
        return emprestimos;
    }

    public void listarEmprestimos(){
        List<Emprestimo> listarEmprestimos = getEmprestimos();
        if(listarEmprestimos.isEmpty()){
            System.out.println("Não há nenhum empréstimo ativo para ser devolvido.");
            return;
        }
        System.out.println("Lista de empréstimos em atividade:");
        for(Emprestimo emprestimo: emprestimos){
            System.out.printf("Id empréstimo: %-3d| Livro: %-20s | Emprestado para o cliente: %-20s | Data do empréstimo: %s%n", emprestimo.getId(), emprestimo.getLivro().getTitulo(), emprestimo.getCliente(), emprestimo.getDataEmprestimo());
        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                ", autores=" + autores +
                ", emprestimos=" + emprestimos +
                '}';
    }
}
