package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShenqingtuizuDao;
import com.cl.entity.ShenqingtuizuEntity;
import com.cl.service.ShenqingtuizuService;
import com.cl.entity.view.ShenqingtuizuView;

@Service("shenqingtuizuService")
public class ShenqingtuizuServiceImpl extends ServiceImpl<ShenqingtuizuDao, ShenqingtuizuEntity> implements ShenqingtuizuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingtuizuEntity> page = this.selectPage(
                new Query<ShenqingtuizuEntity>(params).getPage(),
                new EntityWrapper<ShenqingtuizuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingtuizuEntity> wrapper) {
		  Page<ShenqingtuizuView> page =new Query<ShenqingtuizuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShenqingtuizuView> selectListView(Wrapper<ShenqingtuizuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingtuizuView selectView(Wrapper<ShenqingtuizuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
