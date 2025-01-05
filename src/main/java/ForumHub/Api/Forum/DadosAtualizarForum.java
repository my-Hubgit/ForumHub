package ForumHub.Api.Forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarForum(
        @NotNull
        Long id,
        @NotBlank
        String data_Resposta,
        String status,
        @NotBlank
        String resposta) {

}
