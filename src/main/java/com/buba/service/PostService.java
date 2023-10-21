package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.Post;
import com.buba.pojo.PostDto;

public interface PostService {
    public int savePost(Post post);
    public IPage<Post> getPost(PostDto postDto);
    public Post getPostId(int id);
    public int update(Post post);
    public int delete(int id);
}
