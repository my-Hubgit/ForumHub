package ForumHub.Api.Controller;

import ForumHub.Api.Forum.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class ForumController {

    @Autowired
    private ForumRepository repository;

//-----------------------------------------------------------
//------------------------ CADASTRAR ------------------------
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroForum dados) {
        repository.save(new Forum(dados));
    }


//--------------------------------------------------------
//--------------------- LISTAR TODOS ------------------------

@GetMapping
public List<DadosListagemTopicos> listar() {
    return repository.findAll().stream()
            .map(forum -> new DadosListagemTopicos(
                    forum.getId(),
                    forum.getAutor(),
                    forum.getTitulo(),
                    forum.getMensagem(),
                    forum.getDataCriacao(),
                    forum.getCurso(),
                    forum.getStatus(),
                    forum.getResposta(),
                    forum.getData_resposta()

            ))
            .toList();
}



//--------------------------------------------------------
//--------------------- LISTAR UM TOPICO ------------------------

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopicos> listarPorId(@PathVariable Long id) {
        // Buscar o tópico pelo ID no repositório
        return repository.findById(id)
                .map(forum -> new DadosListagemTopicos(
                        forum.getId(),
                        forum.getAutor(),
                        forum.getTitulo(),
                        forum.getMensagem(),
                        forum.getDataCriacao(),
                        forum.getCurso(),
                        forum.getStatus(),
                        forum.getResposta(),
                        forum.getData_resposta()
                ))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



//--------------------------------------------------------
//--------------------- ATUALIZAR ------------------------
    @PutMapping
    @Transactional
public void atualizar(@RequestBody @Valid DadosAtualizarForum dados){
var topico = repository.getReferenceById(dados.id());
topico.atualizarTopico(dados);
    }


//--------------------------------------------------------
//--------------------- DELETAR  ------------------------
@DeleteMapping("/{id}")
@Transactional
    public void delatar (@PathVariable long id){
    repository.deleteById(id);

}


}
