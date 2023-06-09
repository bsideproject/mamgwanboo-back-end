package com.beside.startrail.friend.repository;

import com.beside.startrail.friend.document.Friend;
import org.springframework.stereotype.Repository;
import protobuf.friend.FriendGetCriteriaProto;
import reactor.core.publisher.Flux;


@Repository
public interface CustomFriendRepository {

    Flux<Friend> findFriendsByCriteria(String userSequence, FriendGetCriteriaProto friendGetCriteriaProto);
}
