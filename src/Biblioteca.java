import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // Adicionar livro
    public void adicionarLivro(Livro l) {
        livros.add(l);
    }

    // Adicionar usuário
    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }

    // Buscar usuário por id
    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // Buscar livro por código
    public Livro buscarLivro(String codigo) {
        for (Livro l : livros) {
            if (l.getCodigoLivro().equals(codigo)) return l;
        }
        return null;
    }

    // Emprestar livro (com objeto usuário)
    public void emprestarLivro(Usuario u, String codigo) {
        Livro livro = buscarLivro(codigo);

        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        if (livro.getStatus().equals("EMPRESTADO")) {
            System.out.println("Livro já emprestado!");
            return;
        }

        // Contar quantos livros esse usuário já pegou
        int qtd = 0;
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(u)) {
                qtd++;
            }
        }

        if (qtd >= u.getLimiteEmprestimos()) {
            System.out.println("Usuário " + u.getNome() + " já atingiu o limite!");
            return;
        }

        // Se passou em todas as verificações → empresta
        livro.emprestar();
        Emprestimo novo = new Emprestimo(livro, u);
        emprestimos.add(novo);
        System.out.println("Livro emprestado para " + u.getNome() + ": " + livro.getTitulo());
    }

    // Emprestar livro (com id do usuário)
    public void emprestarLivro(int idUsuario, String codigo) {
        Usuario u = buscarUsuario(idUsuario);
        if (u != null) {
            emprestarLivro(u, codigo);
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    // Devolver livro
    public void devolverLivro(Usuario u, String codigo) {
        for (Emprestimo e : new ArrayList<>(emprestimos)) {
            if (e.getUsuario().equals(u) && e.getLivro().getCodigoLivro().equals(codigo)) {
                e.getLivro().devolver();
                emprestimos.remove(e);
                System.out.println("Livro devolvido: " + e.getLivro().getTitulo());
                return;
            }
        }
        System.out.println("Devolução inválida!");
    }

    // Listar livros
    public void listarLivros() {
        System.out.println("\nLivros na biblioteca:");
        for (Livro l : livros) {
            System.out.println(l);
        }
    }
}
