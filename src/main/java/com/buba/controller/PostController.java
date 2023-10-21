package com.buba.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.buba.pojo.Post;
import com.buba.pojo.PostDto;
import com.buba.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController extends ApiController {
    @Autowired
    private PostService postService;
    @RequestMapping("/save")
    public R<Object> savePost(@RequestBody Post post) {
        int res = postService.savePost(post);
        if (res>0){
            return R.ok("保存成功");
        }else {
            return R.ok("保存失败");
        }
    }

    @RequestMapping("/page")
    public R<Object> getPost(PostDto postDto){
        IPage<Post> iPage= postService.getPost(postDto);
        return R.ok(iPage);
    }

    @RequestMapping("/getId")
    public R<Object> getId(int id){
        Post post = postService.getPostId(id);
        return R.ok(post);
    }

    @RequestMapping("/update")
    public R<Object> update(@RequestBody Post post){
        int res = postService.update(post);
        if (res>0){
            return R.ok("保存成功");
        }else {
            return R.ok("保存失败");
        }
    }

    @RequestMapping("/delete")
    public R<Object> delete(int id){
        int res = postService.delete(id);
        if (res>0){
            return R.ok("保存成功");
        }else {
            return R.ok("保存失败");
        }
    }
}
