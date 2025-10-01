import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolução;

    public Emprestimo(Livro livro, Usuario usuario){
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolução = dataEmprestimo.plusDays(7);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolução() {
        return dataPrevistaDevolução;
    }

    public void setDataPrevistaDevolução(LocalDate dataPrevistaDevolução) {
        this.dataPrevistaDevolução = dataPrevistaDevolução;
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() + " | Usuario: " + usuario.getNome() + " | Data Emprestimo: " + dataEmprestimo + " | Data Prevista para Devolução: " + dataPrevistaDevolução;
    }
}
