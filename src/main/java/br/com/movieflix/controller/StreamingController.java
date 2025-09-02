package br.com.movieflix.controller;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Streaming", description = "Recurso responsável pelo gerenciamento dos streamings")
public interface StreamingController {

    @Operation(summary = "Buscar streamings", description = "Método responsável por retornar todos os streamings cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os streamings cadastrados",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class))))
    ResponseEntity<List<StreamingResponse>> getAllStreamings();

    @Operation(summary = "Salvar streaming", description = "Método responsável por salvar um novo streaming.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Streaming salvo com sucesso",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request);

    @Operation(summary = "Buscar streaming por id", description = "Método responsável por buscar streaming por id.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado", content = @Content())
    ResponseEntity<StreamingResponse> getByStreamingId(@PathVariable Long id);

    @Operation(summary = "Deletar streaming por id", description = "Método responsável por deletar um streaming.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Streaming deletado com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado", content = @Content())
    ResponseEntity<Void> deleteByStreamingId(@PathVariable Long id);
}
