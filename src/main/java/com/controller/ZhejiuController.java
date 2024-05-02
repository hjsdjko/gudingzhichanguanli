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

import com.entity.ZhejiuEntity;

import com.service.ZhejiuService;
import com.entity.view.ZhejiuView;
import com.service.ZichanService;
import com.entity.ZichanEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 资产折旧
 * 后端接口
 * @author
 * @email
 * @date 2021-04-06
*/
@RestController
@Controller
@RequestMapping("/zhejiu")
public class ZhejiuController {
    private static final Logger logger = LoggerFactory.getLogger(ZhejiuController.class);

    @Autowired
    private ZhejiuService zhejiuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
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
        PageUtils page = zhejiuService.queryPage(params);

        //字典表数据转换
        List<ZhejiuView> list =(List<ZhejiuView>)page.getList();
        for(ZhejiuView c:list){
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
        ZhejiuEntity zhejiu = zhejiuService.selectById(id);
        if(zhejiu !=null){
            //entity转view
            ZhejiuView view = new ZhejiuView();
            BeanUtils.copyProperties( zhejiu , view );//把实体数据重构到view中

            //级联表
            ZichanEntity zichan = zichanService.selectById(zhejiu.getZichanId());
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
    public R save(@RequestBody ZhejiuEntity zhejiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhejiu:{}",this.getClass().getName(),zhejiu.toString());
        Wrapper<ZhejiuEntity> queryWrapper = new EntityWrapper<ZhejiuEntity>()
            .eq("zichan_id", zhejiu.getZichanId())
            .eq("weixiu_zhejiu", zhejiu.getWeixiuZhejiu())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhejiuEntity zhejiuEntity = zhejiuService.selectOne(queryWrapper);
        if(zhejiuEntity==null){
            zhejiu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zhejiu.set
        //  }
            zhejiuService.insert(zhejiu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhejiuEntity zhejiu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhejiu:{}",this.getClass().getName(),zhejiu.toString());
        //根据字段查询是否有相同数据
        Wrapper<ZhejiuEntity> queryWrapper = new EntityWrapper<ZhejiuEntity>()
            .notIn("id",zhejiu.getId())
            .andNew()
            .eq("zichan_id", zhejiu.getZichanId())
            .eq("weixiu_zhejiu", zhejiu.getWeixiuZhejiu())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhejiuEntity zhejiuEntity = zhejiuService.selectOne(queryWrapper);
        if(zhejiuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zhejiu.set
            //  }
            zhejiuService.updateById(zhejiu);//根据id更新
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
        zhejiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}

