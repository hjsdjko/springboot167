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


import com.cl.dao.YuyuexinxiDao;
import com.cl.entity.YuyuexinxiEntity;
import com.cl.service.YuyuexinxiService;
import com.cl.entity.view.YuyuexinxiView;

@Service("yuyuexinxiService")
public class YuyuexinxiServiceImpl extends ServiceImpl<YuyuexinxiDao, YuyuexinxiEntity> implements YuyuexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuexinxiEntity> page = this.selectPage(
                new Query<YuyuexinxiEntity>(params).getPage(),
                new EntityWrapper<YuyuexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuexinxiEntity> wrapper) {
		  Page<YuyuexinxiView> page =new Query<YuyuexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuyuexinxiView> selectListView(Wrapper<YuyuexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuexinxiView selectView(Wrapper<YuyuexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
