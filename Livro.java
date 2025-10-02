public class Livro implements Emprestavel {

    private String codigoLivro;
    private String titulo;
    private String autor;
    private StatusLivro status;
    private Usuario usuarioEmprestimo;

    public Livro(String codigoLivro, String titulo, String autor){
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.status = StatusLivro.Disponivel;
        this.usuarioEmprestimo = null;
    }

    public String getCodigoLivro() { return codigoLivro; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public StatusLivro getStatus() { return status; }
    public Usuario getUsuarioEmprestimo() { return usuarioEmprestimo; }

    private void mudarStatusEmprestado() { this.status = StatusLivro.Emprestado; }
    private void mudarStatusDisponivel() { this.status = StatusLivro.Disponivel; }

    @Override
    public boolean emprestar(Usuario u) {
        if (status == StatusLivro.Disponivel) {
            this.usuarioEmprestimo = u;
            mudarStatusEmprestado();
            return true;
        }
        return false;
    }

    @Override
    public void devolver() {
        this.usuarioEmprestimo = null;
        mudarStatusDisponivel();
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " [" + codigoLivro + "] - " + status;
    }
}
