package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.PostMapper;
import com.buba.pojo.Post;
import com.buba.pojo.PostDto;
import com.buba.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;
    @Override
    public int savePost(Post post){
        return postMapper.insert(post);
    }

    @Override
    public IPage getPost(PostDto postDto){
        Page page = new Page(postDto.getPageNow(), postDto.getPageSize());
        QueryWrapper<Post> w = new QueryWrapper<>();
        IPage iPage = postMapper.selectPage(page,w);
        return iPage;
    }
    @Override
    public Post getPostId(int id){
        return postMapper.selectById(id);
    }
    @Override
    public int update(Post post){
        return postMapper.updateById(post);
    }
    @Override
    public int delete(int id){
        return postMapper.deleteById(id);
    }
}
