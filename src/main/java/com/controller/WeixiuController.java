package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
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

import com.entity.WeixiuEntity;

import com.service.WeixiuService;
import com.entity.view.WeixiuView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.service.ZichanService;
import com.entity.ZichanEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 资产维修
 * 后端接口
 * @author
 * @email
 * @date 2021-04-06
*/
@RestController
@Controller
@RequestMapping("/weixiu")
public class WeixiuController {
    private static final Logger logger = LoggerFactory.getLogger(WeixiuController.class);

    @Autowired
    private WeixiuService weixiuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZichanService zichanService;


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
        PageUtils page = weixiuService.queryPage(params);

        //字典表数据转换
        List<WeixiuView> list =(List<WeixiuView>)page.getList();
        for(WeixiuView c:list){
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
        WeixiuEntity weixiu = weixiuService.selectById(id);
        if(weixiu !=null){
            //entity转view
            WeixiuView view = new WeixiuView();
            BeanUtils.copyProperties( weixiu , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(weixiu.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //级联表
            ZichanEntity zichan = zichanService.selectById(weixiu.getZichanId());
            if(zichan != null){
                BeanUtils.copyProperties( zichan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setZichanId(zichan.getId());
            }
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
    public R save(@RequestBody WeixiuEntity weixiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weixiu:{}",this.getClass().getName(),weixiu.toString());
        Wrapper<WeixiuEntity> queryWrapper = new EntityWrapper<WeixiuEntity>()
            .eq("zichan_id", weixiu.getZichanId())
            .eq("yonghu_id", weixiu.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuEntity weixiuEntity = weixiuService.selectOne(queryWrapper);
        if(weixiuEntity==null){
            weixiu.setInsertTime(new Date());
            weixiu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      weixiu.set
        //  }
            weixiuService.insert(weixiu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiuEntity weixiu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,weixiu:{}",this.getClass().getName(),weixiu.toString());
        //根据字段查询是否有相同数据
        Wrapper<WeixiuEntity> queryWrapper = new EntityWrapper<WeixiuEntity>()
            .notIn("id",weixiu.getId())
            .andNew()
            .eq("zichan_id", weixiu.getZichanId())
            .eq("yonghu_id", weixiu.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuEntity weixiuEntity = weixiuService.selectOne(queryWrapper);
        if(weixiuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      weixiu.set
            //  }
            weixiuService.updateById(weixiu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        weixiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}

