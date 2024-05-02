package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.BaofeiEntity;
import com.service.BaofeiService;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ZichanEntity;

import com.service.ZichanService;
import com.entity.view.ZichanView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 资产
 * 后端接口
 * @author
 * @email
 * @date 2021-04-06
*/
@RestController
@Controller
@RequestMapping("/zichan")
public class ZichanController {
    private static final Logger logger = LoggerFactory.getLogger(ZichanController.class);

    @Autowired
    private ZichanService zichanService;

    @Autowired
    private BaofeiService baofeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = zichanService.queryPage(params);

        //字典表数据转换
        List<ZichanView> list =(List<ZichanView>)page.getList();
        for(ZichanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZichanEntity zichan = zichanService.selectById(id);
        if(zichan !=null){
            //entity转view
            ZichanView view = new ZichanView();
            BeanUtils.copyProperties( zichan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZichanEntity zichan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zichan:{}",this.getClass().getName(),zichan.toString());
        Wrapper<ZichanEntity> queryWrapper = new EntityWrapper<ZichanEntity>()
            .eq("zichan_name", zichan.getZichanName())
            .eq("zichan_types", zichan.getZichanTypes())
            .eq("bumen_types", zichan.getBumenTypes())
            .eq("zichan_guige", zichan.getZichanGuige())
            .eq("zichan_changjia", zichan.getZichanChangjia())
            .eq("zichan_baoyang", zichan.getZichanBaoyang())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZichanEntity zichanEntity = zichanService.selectOne(queryWrapper);
        if(zichanEntity==null){
            zichan.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zichan.set
        //  }
            zichanService.insert(zichan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZichanEntity zichan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zichan:{}",this.getClass().getName(),zichan.toString());
        //根据字段查询是否有相同数据
        Wrapper<ZichanEntity> queryWrapper = new EntityWrapper<ZichanEntity>()
            .notIn("id",zichan.getId())
            .andNew()
            .eq("zichan_name", zichan.getZichanName())
            .eq("zichan_types", zichan.getZichanTypes())
            .eq("bumen_types", zichan.getBumenTypes())
            .eq("zichan_guige", zichan.getZichanGuige())
            .eq("zichan_changjia", zichan.getZichanChangjia())
            .eq("zichan_baoyang", zichan.getZichanBaoyang())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZichanEntity zichanEntity = zichanService.selectOne(queryWrapper);
        if(zichanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zichan.set
            //  }
            zichanService.updateById(zichan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(Integer ids){
        ZichanEntity zichan = zichanService.selectById(ids);
        if(zichan == null){
            return R.error();
        }
        BaofeiEntity baofei = new BaofeiEntity();
        baofei.setCreateTime(new Date());
        baofei.setInsertTime(new Date());
        baofei.setZichanName(zichan.getZichanName());
        boolean insert = baofeiService.insert(baofei);
        if(insert){
            boolean b = zichanService.deleteBatchIds(Arrays.asList(ids));
            if(b){
                return R.ok();
            }
        }
        return R.error();
    }



}

