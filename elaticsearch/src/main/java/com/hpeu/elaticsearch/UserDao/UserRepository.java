package com.hpeu.elaticsearch.UserDao;

import com.hpeu.elaticsearch.Entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends ElasticsearchRepository<User,Integer> {

}
