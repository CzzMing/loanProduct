//package com.buba.service.Impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.buba.mapper.MenuMapper;
//import com.buba.pojo.Menu;
//import com.buba.service.MenuService;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
//    @Resource
//    private MenuMapper menuMapper;
//
//    public List<Menu> getMenuList(Menu menu){
//        QueryWrapper w = new QueryWrapper();
//        List<Menu>list = menuMapper.selectList(w);
//        return list;
//    }
//
//    public List<Menu> buildTree(List<Menu>menus){
//        List<Long> tempId = new ArrayList<>();
//        List<Integer> tempList = menus.stream();
//
//        for (int i=0;i<list.size();i++){
//            tempId.add(list.get(i).getMenuId());
//        }
//        for (int i=0;i<list.size();i++){
//            tempId.add(list.get(i).getParentId());
//        }
//    }
//}
