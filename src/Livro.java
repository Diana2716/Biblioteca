public class Livro implements Emprestavel {

    private String codigoLivro;
    private String titulo;
    private String autor;
    private String status;
    private Usuario usuarioEmprestimo;

    public Livro(String codigoLivro, String titulo, String autor){
        this.codigoLivro = codigoLivro;
        this.status = "Disponivel";
        this.titulo = titulo;
        this.autor = autor;
        this.usuarioEmprestimo = null;
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(String codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public void setUsuarioEmprestimo(Usuario usuarioEmprestimo) {
        this.usuarioEmprestimo = usuarioEmprestimo;
    }

    public void emprestar() {
        this.status = "EMPRESTADO";
    }

    public void devolver() {
        this.status = "DISPONÍVEL";
    }

    @Override
    public boolean emprestar(Usuario u) {
        if (status.equals("DISPONÍVEL")) {
            emprestar();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " [" + codigoLivro + "] - " + status;
    }
}
