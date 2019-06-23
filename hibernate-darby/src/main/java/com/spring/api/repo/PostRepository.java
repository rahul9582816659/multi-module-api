package com.spring.api.repo;

import com.spring.api.entity.onetomanyunidirectional.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
