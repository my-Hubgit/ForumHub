package ForumHub.Api.Forum;

public class DadosListagemTopicos {

    private final Long id;
    private final String autor;
    private final String titulo;
    private final String mensagem;
    private final String dataCriacao;
    private final String curso;
    private final Status status;
    private final String resposta;
    private final String data_resposta;


    // Construtor
    public DadosListagemTopicos(Long id, String autor, String titulo, String mensagem, String dataCriacao, String curso, Status status, String resposta, String data_resposta) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.curso = curso;
        this.status = status;
        this.resposta = resposta;
        this.data_resposta = data_resposta;

    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getCurso() {
        return curso;
    }

    public Status getStatus() {
        return status;
    }

    public String getResposta() {
        return resposta;
    }

    public String getData_resposta() {
        return data_resposta;
    }
}
