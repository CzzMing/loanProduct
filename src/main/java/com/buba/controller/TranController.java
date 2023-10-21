package com.buba.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.buba.pojo.Tran;
import com.buba.pojo.TranDto;
import com.buba.service.TranAndAccountService;
import com.buba.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tran")
@CrossOrigin
public class TranController extends ApiController {
    @Autowired
    private TranService tranService;
    @Autowired
    private TranAndAccountService tranAndAccountService;

    @RequestMapping("/tranPage")
    public R<Object> tranPage(TranDto tranDto,String accountId){
        IPage<Tran> iPage = tranAndAccountService.tranAndAccountPage(tranDto,accountId);
        return R.ok(iPage);
    }

    @RequestMapping("/page")
    public R<Object> page(TranDto tranDto){
        IPage<Tran> page = tranService.tranPage(tranDto);
        return R.ok(page);
    }
    @RequestMapping("/add")
    public R<Object> add(@RequestBody Tran tran){
        int res = tranService.tranAdd(tran);
        if (res>0){
            return R.ok("成功");
        }else {
            return R.ok("失败");
        }
    }

    @RequestMapping("/selectId/")
    public R<Object> selectId(int tranId){
        Tran tran = tranService.updById(tranId);
        return R.ok(tran);
    }

    @RequestMapping("/update")
    public R<Object> update(@RequestBody Tran tran){
        int res = tranService.tranUpdate(tran);
        return R.ok("成功");
    }

    @RequestMapping("/delete")
    public R<Object> delete(int accountId){
        int res = tranService.tranDel(accountId);
        return R.ok("成功");
    }
}
