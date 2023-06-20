package com.beside.mamgwanboo.relationship.command;

import com.beside.mamgwanboo.common.type.YnType;
import com.beside.mamgwanboo.relationship.document.Relationship;
import com.beside.mamgwanboo.relationship.repository.RelationshipRepository;
import reactor.core.publisher.Mono;

public class RelationshipDeleteCommand {
  private final String sequence;
  private Mono<Relationship> result;

  public RelationshipDeleteCommand(String sequence) {
    this.sequence = sequence;
  }

  public Mono<Relationship> execute(RelationshipRepository relationshipRepository) {
    result = relationshipRepository.deleteBySequenceAndUseYn(sequence, YnType.Y);

    return result;
  }
}
