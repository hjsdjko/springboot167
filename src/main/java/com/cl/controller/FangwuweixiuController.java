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

import com.cl.entity.FangwuweixiuEntity;
import com.cl.entity.view.FangwuweixiuView;

import com.cl.service.FangwuweixiuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房屋维修
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 21:41:37
 */
@RestController
@RequestMapping("/fangwuweixiu")
public class FangwuweixiuController {
    @Autowired
    private FangwuweixiuService fangwuweixiuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuweixiuEntity fangwuweixiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			fangwuweixiu.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			fangwuweixiu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangwuweixiuEntity> ew = new EntityWrapper<FangwuweixiuEntity>();

		PageUtils page = fangwuweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuweixiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuweixiuEntity fangwuweixiu, 
		HttpServletRequest request){
        EntityWrapper<FangwuweixiuEntity> ew = new EntityWrapper<FangwuweixiuEntity>();

		PageUtils page = fangwuweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuweixiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuweixiuEntity fangwuweixiu){
       	EntityWrapper<FangwuweixiuEntity> ew = new EntityWrapper<FangwuweixiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuweixiu, "fangwuweixiu")); 
        return R.ok().put("data", fangwuweixiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuweixiuEntity fangwuweixiu){
        EntityWrapper< FangwuweixiuEntity> ew = new EntityWrapper< FangwuweixiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuweixiu, "fangwuweixiu")); 
		FangwuweixiuView fangwuweixiuView =  fangwuweixiuService.selectView(ew);
		return R.ok("查询房屋维修成功").put("data", fangwuweixiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuweixiuEntity fangwuweixiu = fangwuweixiuService.selectById(id);
		fangwuweixiu = fangwuweixiuService.selectView(new EntityWrapper<FangwuweixiuEntity>().eq("id", id));
        return R.ok().put("data", fangwuweixiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuweixiuEntity fangwuweixiu = fangwuweixiuService.selectById(id);
		fangwuweixiu = fangwuweixiuService.selectView(new EntityWrapper<FangwuweixiuEntity>().eq("id", id));
        return R.ok().put("data", fangwuweixiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuweixiuEntity fangwuweixiu, HttpServletRequest request){
    	fangwuweixiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuweixiu);
        fangwuweixiuService.insert(fangwuweixiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuweixiuEntity fangwuweixiu, HttpServletRequest request){
    	fangwuweixiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuweixiu);
        fangwuweixiuService.insert(fangwuweixiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangwuweixiuEntity fangwuweixiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuweixiu);
        fangwuweixiuService.updateById(fangwuweixiu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<FangwuweixiuEntity> list = new ArrayList<FangwuweixiuEntity>();
        for(Long id : ids) {
            FangwuweixiuEntity fangwuweixiu = fangwuweixiuService.selectById(id);
            fangwuweixiu.setSfsh(sfsh);
            fangwuweixiu.setShhf(shhf);
            list.add(fangwuweixiu);
        }
        fangwuweixiuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangwuweixiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
