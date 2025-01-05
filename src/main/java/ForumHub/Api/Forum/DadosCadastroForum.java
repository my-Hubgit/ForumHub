package ForumHub.Api.Forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroForum(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String data_Criacao,
        @NotNull Status status,
        @NotBlank String autor,
        @NotBlank String curso) {
}
