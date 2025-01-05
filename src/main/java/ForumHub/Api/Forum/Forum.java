package ForumHub.Api.Forum;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "forumhub", schema = "forumHub")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensagem;
    private String dataCriacao;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private String curso;
    private String resposta;
    private String data_resposta;

//-----------------------------------------------------------
//    private @NotBlank String dataResposta;
//    private @NotBlank String resposta;
//-----------------------------------------------------------


    // Construtor padrão (obrigatório para JPA)
    public Forum() {
    }

    //---------------- Construtor utilizando DadosCadastroForum ------------------------------------------
    public Forum(@Valid DadosCadastroForum dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.data_Criacao();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.status = dados.status();
    }

    // Getters
    public long getId() {
        return id;
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

    public Status getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public String getResposta() {
        return resposta;
    }

    public String getData_resposta() {
        return data_resposta;

}

    public void atualizarTopico(@Valid DadosAtualizarForum dados) {
        this.id = dados.id();
        this.status = Status.valueOf(dados.status());
        this.resposta = dados.resposta();
        this.data_resposta = dados.data_Resposta();
    }
}
