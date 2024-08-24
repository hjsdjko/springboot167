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


import com.cl.dao.FangwuweixiuDao;
import com.cl.entity.FangwuweixiuEntity;
import com.cl.service.FangwuweixiuService;
import com.cl.entity.view.FangwuweixiuView;

@Service("fangwuweixiuService")
public class FangwuweixiuServiceImpl extends ServiceImpl<FangwuweixiuDao, FangwuweixiuEntity> implements FangwuweixiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwuweixiuEntity> page = this.selectPage(
                new Query<FangwuweixiuEntity>(params).getPage(),
                new EntityWrapper<FangwuweixiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwuweixiuEntity> wrapper) {
		  Page<FangwuweixiuView> page =new Query<FangwuweixiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FangwuweixiuView> selectListView(Wrapper<FangwuweixiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwuweixiuView selectView(Wrapper<FangwuweixiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
