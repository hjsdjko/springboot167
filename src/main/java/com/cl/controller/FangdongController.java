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

import com.cl.entity.FangdongEntity;
import com.cl.entity.view.FangdongView;

import com.cl.service.FangdongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房东
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 21:41:37
 */
@RestController
@RequestMapping("/fangdong")
public class FangdongController {
    @Autowired
    private FangdongService fangdongService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("fangdongzhanghao", username));
        if(u==null || !u.getFangdongmima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"fangdong",  "房东" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody FangdongEntity fangdong){
    	//ValidatorUtils.validateEntity(fangdong);
    	FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("fangdongzhanghao", fangdong.getFangdongzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		fangdong.setId(uId);
        fangdongService.insert(fangdong);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        FangdongEntity u = fangdongService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("fangdongzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setFangdongmima("123456");
        fangdongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangdongEntity fangdong,
		HttpServletRequest request){
        EntityWrapper<FangdongEntity> ew = new EntityWrapper<FangdongEntity>();

		PageUtils page = fangdongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangdong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangdongEntity fangdong, 
		HttpServletRequest request){
        EntityWrapper<FangdongEntity> ew = new EntityWrapper<FangdongEntity>();

		PageUtils page = fangdongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangdong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangdongEntity fangdong){
       	EntityWrapper<FangdongEntity> ew = new EntityWrapper<FangdongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangdong, "fangdong")); 
        return R.ok().put("data", fangdongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangdongEntity fangdong){
        EntityWrapper< FangdongEntity> ew = new EntityWrapper< FangdongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangdong, "fangdong")); 
		FangdongView fangdongView =  fangdongService.selectView(ew);
		return R.ok("查询房东成功").put("data", fangdongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangdongEntity fangdong = fangdongService.selectById(id);
		fangdong = fangdongService.selectView(new EntityWrapper<FangdongEntity>().eq("id", id));
        return R.ok().put("data", fangdong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangdongEntity fangdong = fangdongService.selectById(id);
		fangdong = fangdongService.selectView(new EntityWrapper<FangdongEntity>().eq("id", id));
        return R.ok().put("data", fangdong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
    	fangdong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangdong);
    	FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("fangdongzhanghao", fangdong.getFangdongzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		fangdong.setId(new Date().getTime());
        fangdongService.insert(fangdong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
    	fangdong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangdong);
    	FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("fangdongzhanghao", fangdong.getFangdongzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		fangdong.setId(new Date().getTime());
        fangdongService.insert(fangdong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangdong);
        fangdongService.updateById(fangdong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<FangdongEntity> list = new ArrayList<FangdongEntity>();
        for(Long id : ids) {
            FangdongEntity fangdong = fangdongService.selectById(id);
            fangdong.setSfsh(sfsh);
            fangdong.setShhf(shhf);
            list.add(fangdong);
        }
        fangdongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangdongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
