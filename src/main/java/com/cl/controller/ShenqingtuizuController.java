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

import com.cl.entity.ShenqingtuizuEntity;
import com.cl.entity.view.ShenqingtuizuView;

import com.cl.service.ShenqingtuizuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 申请退租
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 21:41:38
 */
@RestController
@RequestMapping("/shenqingtuizu")
public class ShenqingtuizuController {
    @Autowired
    private ShenqingtuizuService shenqingtuizuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingtuizuEntity shenqingtuizu,
                @RequestParam(required = false) Double zulinyajinstart,
                @RequestParam(required = false) Double zulinyajinend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			shenqingtuizu.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			shenqingtuizu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingtuizuEntity> ew = new EntityWrapper<ShenqingtuizuEntity>();
                if(zulinyajinstart!=null) ew.ge("zulinyajin", zulinyajinstart);
                if(zulinyajinend!=null) ew.le("zulinyajin", zulinyajinend);

		PageUtils page = shenqingtuizuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingtuizu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingtuizuEntity shenqingtuizu, 
                @RequestParam(required = false) Double zulinyajinstart,
                @RequestParam(required = false) Double zulinyajinend,
		HttpServletRequest request){
        EntityWrapper<ShenqingtuizuEntity> ew = new EntityWrapper<ShenqingtuizuEntity>();
                if(zulinyajinstart!=null) ew.ge("zulinyajin", zulinyajinstart);
                if(zulinyajinend!=null) ew.le("zulinyajin", zulinyajinend);

		PageUtils page = shenqingtuizuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingtuizu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingtuizuEntity shenqingtuizu){
       	EntityWrapper<ShenqingtuizuEntity> ew = new EntityWrapper<ShenqingtuizuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingtuizu, "shenqingtuizu")); 
        return R.ok().put("data", shenqingtuizuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingtuizuEntity shenqingtuizu){
        EntityWrapper< ShenqingtuizuEntity> ew = new EntityWrapper< ShenqingtuizuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingtuizu, "shenqingtuizu")); 
		ShenqingtuizuView shenqingtuizuView =  shenqingtuizuService.selectView(ew);
		return R.ok("查询申请退租成功").put("data", shenqingtuizuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingtuizuEntity shenqingtuizu = shenqingtuizuService.selectById(id);
		shenqingtuizu = shenqingtuizuService.selectView(new EntityWrapper<ShenqingtuizuEntity>().eq("id", id));
        return R.ok().put("data", shenqingtuizu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingtuizuEntity shenqingtuizu = shenqingtuizuService.selectById(id);
		shenqingtuizu = shenqingtuizuService.selectView(new EntityWrapper<ShenqingtuizuEntity>().eq("id", id));
        return R.ok().put("data", shenqingtuizu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingtuizuEntity shenqingtuizu, HttpServletRequest request){
    	shenqingtuizu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingtuizu);
        shenqingtuizuService.insert(shenqingtuizu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingtuizuEntity shenqingtuizu, HttpServletRequest request){
    	shenqingtuizu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingtuizu);
        shenqingtuizuService.insert(shenqingtuizu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShenqingtuizuEntity shenqingtuizu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingtuizu);
        shenqingtuizuService.updateById(shenqingtuizu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShenqingtuizuEntity> list = new ArrayList<ShenqingtuizuEntity>();
        for(Long id : ids) {
            ShenqingtuizuEntity shenqingtuizu = shenqingtuizuService.selectById(id);
            shenqingtuizu.setSfsh(sfsh);
            shenqingtuizu.setShhf(shhf);
            list.add(shenqingtuizu);
        }
        shenqingtuizuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenqingtuizuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
