import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca b = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n -----Menu da Biblioteca -----");
            System.out.println("1 - Cadastrar um Livro");
            System.out.println("2 - Cadastrar Novo Usuário (Aluno)");
            System.out.println("3 - Cadastrar Novo Usuario (Professor)");
            System.out.println("4 - Listar os Livros");
            System.out.println("5 - Emprestar o Livro");
            System.out.println("6 - Devolver o livro");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Código: ");
                    String cod = sc.nextLine();
                    System.out.print("Título: ");
                    String tit = sc.nextLine();
                    System.out.print("Autor: ");
                    String aut = sc.nextLine();
                    Livro l = new Livro(cod, tit, aut);
                    b.adicionarLivro(l);
                    System.out.println("Novo Livro cadastrado!");
                    break;

                case 2:
                    System.out.println("ID: ");
                    int idA = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome: ");
                    String nomeA = sc.nextLine();
                    System.out.println("Email: ");
                    String emailA = sc.nextLine();
                    Usuario aluno = new Aluno(idA, nomeA, emailA);
                    b.adicionarUsuario(aluno);
                    System.out.println("Novo Aluno Cadastrado!");
                    break;

                case 3:
                    System.out.println("ID: ");
                    int idP = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome: ");
                    String nomeP = sc.nextLine();
                    System.out.println("Email: ");
                    String emailP = sc.nextLine();
                    Usuario prof = new Aluno(idP, nomeP, emailP);
                    b.adicionarUsuario(prof);
                    System.out.println("Novo Professor Cadastrado!");
                    break;

                case 4:
                    b.listarLivros();
                    break;

                case 5:
                    System.out.println("ID do Usuário: ");
                    int idU = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Código do Livro: ");
                    String codE = sc.nextLine();
                    b.emprestarLivro(idU, codE);
                    break;

                case 6:
                    System.out.println("ID do Usuário: ");
                    int idU2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Código do Livro: ");
                    String codD = sc.nextLine();
                    Usuario u = b.buscarUsuario(idU2);
                    if(u !=null){
                        b.devolverLivro(u, codD);
                    } else {
                        System.out.println("Usúario não Encontrado!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo.");
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}