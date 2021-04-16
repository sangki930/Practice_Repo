package com.psk.book.service.posts;

import com.psk.book.domain.posts.Posts;
import com.psk.book.domain.posts.PostsRepository;
import com.psk.book.web.dto.PostsListResponseDto;
import com.psk.book.web.dto.PostsResponseDto;
import com.psk.book.web.dto.PostsSaveRequestDto;
import com.psk.book.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
       return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    //트랜잭션의 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선된다.
    //하지만, 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 구현한다.
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                //.map(posts->new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다." +
                        "id="+id));
        /*존재하는 지 확인 후 삭제한다.
        * */
        postsRepository.delete(posts);

    }

}

