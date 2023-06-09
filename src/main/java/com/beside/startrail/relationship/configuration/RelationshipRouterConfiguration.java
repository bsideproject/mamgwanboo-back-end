package com.beside.startrail.relationship.configuration;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.beside.startrail.relationship.handler.RelationshipCountHandler;
import com.beside.startrail.relationship.handler.RelationshipDeleteHandler;
import com.beside.startrail.relationship.handler.RelationshipGetByFriendSequencehandler;
import com.beside.startrail.relationship.handler.RelationshipGetBySequenceHandler;
import com.beside.startrail.relationship.handler.RelationshipPostHandler;
import com.beside.startrail.relationship.handler.RelationshipPutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class RelationshipRouterConfiguration {
  @Bean
  public RouterFunction<?> routeRelationship(
      RelationshipCountHandler relationshipCountHandler,
      RelationshipGetByFriendSequencehandler relationshipGetByFriendSequencehandler,
      RelationshipGetBySequenceHandler relationshipGetBySequenceHandler,
      RelationshipPostHandler relationshipPostHandler,
      RelationshipPutHandler relationshipPutHandler,
      RelationshipDeleteHandler relationshipDeleteHandler
  ) {
    return route()
        .GET("/api/relationships/count", relationshipCountHandler)
        .GET("/api/relationships", relationshipGetByFriendSequencehandler)
        .GET("/api/relationships/{sequence}", relationshipGetBySequenceHandler)
        .POST("/api/relationships", relationshipPostHandler)
        .PUT("/api/relationships", relationshipPutHandler)
        .DELETE("/api/relationships/{sequence}", relationshipDeleteHandler)
        .build();
  }
}
