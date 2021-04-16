package com.psk.book.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    /*
    나중에 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면
    이때, Entity 클래스와 기본 Repository는 함께 움직여야하므로
    도메인 패키지에서 함께 관리합니다.
     */

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    //Spring JPA에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해야한다.


}
