package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YuyuexinxiEntity;
import com.cl.entity.view.YuyuexinxiView;

import com.cl.service.YuyuexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 21:41:37
 */
@RestController
@RequestMapping("/yuyuexinxi")
public class YuyuexinxiController {
    @Autowired
    private YuyuexinxiService yuyuexinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuexinxiEntity yuyuexinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			yuyuexinxi.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			yuyuexinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuexinxiEntity> ew = new EntityWrapper<YuyuexinxiEntity>();

		PageUtils page = yuyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuexinxiEntity yuyuexinxi, 
		HttpServletRequest request){
        EntityWrapper<YuyuexinxiEntity> ew = new EntityWrapper<YuyuexinxiEntity>();

		PageUtils page = yuyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuexinxiEntity yuyuexinxi){
       	EntityWrapper<YuyuexinxiEntity> ew = new EntityWrapper<YuyuexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuexinxi, "yuyuexinxi")); 
        return R.ok().put("data", yuyuexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuexinxiEntity yuyuexinxi){
        EntityWrapper< YuyuexinxiEntity> ew = new EntityWrapper< YuyuexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuexinxi, "yuyuexinxi")); 
		YuyuexinxiView yuyuexinxiView =  yuyuexinxiService.selectView(ew);
		return R.ok("查询预约信息成功").put("data", yuyuexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuexinxiEntity yuyuexinxi = yuyuexinxiService.selectById(id);
		yuyuexinxi = yuyuexinxiService.selectView(new EntityWrapper<YuyuexinxiEntity>().eq("id", id));
        return R.ok().put("data", yuyuexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuexinxiEntity yuyuexinxi = yuyuexinxiService.selectById(id);
		yuyuexinxi = yuyuexinxiService.selectView(new EntityWrapper<YuyuexinxiEntity>().eq("id", id));
        return R.ok().put("data", yuyuexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuexinxiEntity yuyuexinxi, HttpServletRequest request){
    	yuyuexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuexinxi);
        yuyuexinxiService.insert(yuyuexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuexinxiEntity yuyuexinxi, HttpServletRequest request){
    	yuyuexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuexinxi);
        yuyuexinxiService.insert(yuyuexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuexinxiEntity yuyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuexinxi);
        yuyuexinxiService.updateById(yuyuexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
