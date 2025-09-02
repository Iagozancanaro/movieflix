package br.com.movieflix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(@Schema(type = "string", description = "Nome do filme")
                           @NotEmpty(message = "Título do filme é obrigatório.")
                           String title,
                           @Schema(type = "string", description = "Descrição do filme")
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           @Schema(type = "date", description = "Data de lançamento do filme. ex: '19/10/1998'")
                           LocalDate releaseDate,
                           @Schema(type = "array", description = "Score do filme. ex: 7.8")
                           double rating,
                           @Schema(type = "array", description = "Lista de codigos de categoria")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de codigos de serviço de streaming")
                           List<Long> streamings
) {
}
