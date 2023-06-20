package com.beside.mamgwanboo.relationship.handler;

import com.beside.mamgwanboo.common.handler.AbstractSignedHandler;
import com.beside.mamgwanboo.relationship.repository.RelationshipRepository;
import com.beside.mamgwanboo.relationship.service.RelationshipService;
import com.beside.mamgwanboo.relationship.util.RelationshipDtoUtil;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component

public class RelationshipGetBySequenceHandler extends AbstractSignedHandler {
  private final RelationshipRepository relationshipRepository;

  public RelationshipGetBySequenceHandler(
      @Value("${sign.cookieName}") String cookieName,
      RelationshipRepository relationshipRepository
  ) {
    super(cookieName);
    this.relationshipRepository = relationshipRepository;
  }

  @Override
  protected Mono<ServerResponse> signedHandle(ServerRequest serverRequest) {
    String sequence = serverRequest.pathVariable("sequence");

    return RelationshipService
        .getBySequence(UUID.fromString(sequence))
        .execute(relationshipRepository)
        .map(RelationshipDtoUtil::toRelationshipDto)
        .flatMap(relationshipDto ->
            ServerResponse
                .ok()
                .bodyValue(relationshipDto)
        );
  }
}