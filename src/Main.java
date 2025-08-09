import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Autor autor1 = new Autor(1,"Charles Duhigg", LocalDate.of(1974,1,1));
        Autor autor2 = new Autor(2, "Robert Cecil Martin", LocalDate.of(1952,2,2));
        Autor autor3 = new Autor(3, "Marcelo Rubens Paiva", LocalDate.of(1959, 5, 1));
        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);
        biblioteca.adicionarAutor(autor3);

        Livro livro1 = new Livro(1,"O Poder do Habito", autor1);
        Livro livro2 = new Livro(2,"Codigo Limpo", autor2);
        Livro livro3 = new Livro(3, "Ainda Estou Aqui", autor3);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        while(true){
            System.out.println("-------------------------------------------------------");
            System.out.println("*****   LIVRARIA NA CAPA DA GAITA!   *****");
            System.out.println("1· Empréstimo de livros\n2· Devolução de empréstimo\n3· Listar livros\n4· Listar autores\n0· Sair");

            System.out.print("Selecione a opção desejada: ");
            int opcao = scanner.nextInt();
            System.out.println("-------------------------------------------------------");

            if(opcao == 1) {
                List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Nao há livros disponiveis para emprestimo no momento. Recomendamos que volte em breve!");
                    System.out.println("-------------------------------------------------------");
                } else {
                    System.out.println("Livros disponives para emprestimo: ");
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println(livro.getId() + "· " + livro.getTitulo());
                    }
                    System.out.println("-------------------------------------------------------");

                    System.out.print("Selecione o ID do livro que deseja por emprestimo: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Livro livroSelecionado = biblioteca.buscarLivrosPorID(id);
                    if(livroSelecionado != null && livroSelecionado.isDisponivel()){
                        System.out.print("Por gentileza, informe seu nome: ");
                        String nomeCliente = scanner.nextLine();
                        biblioteca.emprestarLivros(livroSelecionado, nomeCliente);
                        System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para o cliente " + nomeCliente);
                    } else {
                        System.out.println("O livro não foi encontrado ou não está disponível para empréstimo.");
                    }
                }

            } else if(opcao == 2){
                biblioteca.listarEmprestimos();
                if(!biblioteca.getEmprestimos().isEmpty()){
                    System.out.print("Informe o ID do empréstimo que deseja devolver: ");
                    int idEmprestimo = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.devolverLivros(idEmprestimo);
                }

            } else if(opcao == 3){
                System.out.println("Lista de livros cadastrados:");
                biblioteca.listarLivros();

            } else if(opcao == 4){
                System.out.println("Lista de autores cadastrados:");
                biblioteca.listarAutores();

            } else if(opcao == 0){
                System.out.println("A Livraria Na Capa da Gaita agradece a sua visita! Volte sempre! :D");
                System.out.println("-------------------------------------------------------");
                break;

            } else {
                System.out.println("Opcao invalida! Tente novamente. (sim/nao)");
            }
        }

        scanner.close();
    }
}
