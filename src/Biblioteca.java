import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro l) { livros.add(l); }
    public void adicionarUsuario(Usuario u) { usuarios.add(u); }

    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public Livro buscarLivro(String codigo) {
        for (Livro l : livros) {
            if (l.getCodigoLivro().equals(codigo)) return l;
        }
        return null;
    }

    public void emprestarLivro(Usuario u, String codigo) {
        Livro livro = buscarLivro(codigo);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }
        if (livro.getStatus() == StatusLivro.Emprestado) {
            System.out.println("Livro já emprestado!");
            return;
        }

        int qtd = 0;
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(u)) qtd++;
        }

        if (qtd >= u.getLimiteEmprestimos()) {
            System.out.println("Usuário " + u.getNome() + " já atingiu o limite!");
            return;
        }

        livro.emprestar(u);
        emprestimos.add(new Emprestimo(livro, u));
        System.out.println("Livro emprestado para " + u.getNome() + ": " + livro.getTitulo());
    }

    public void emprestarLivro(int idUsuario, String codigo) {
        Usuario u = buscarUsuario(idUsuario);
        if (u != null) emprestarLivro(u, codigo);
        else System.out.println("Usuário não encontrado!");
    }

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

    public void listarLivros() {
        System.out.println("\nLivros na biblioteca:");
        for (Livro l : livros) {
            System.out.println(l);
        }
    }
}
