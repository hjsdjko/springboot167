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


import com.cl.dao.DiscussfangwuxinxiDao;
import com.cl.entity.DiscussfangwuxinxiEntity;
import com.cl.service.DiscussfangwuxinxiService;
import com.cl.entity.view.DiscussfangwuxinxiView;

@Service("discussfangwuxinxiService")
public class DiscussfangwuxinxiServiceImpl extends ServiceImpl<DiscussfangwuxinxiDao, DiscussfangwuxinxiEntity> implements DiscussfangwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfangwuxinxiEntity> page = this.selectPage(
                new Query<DiscussfangwuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussfangwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfangwuxinxiEntity> wrapper) {
		  Page<DiscussfangwuxinxiView> page =new Query<DiscussfangwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussfangwuxinxiView> selectListView(Wrapper<DiscussfangwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfangwuxinxiView selectView(Wrapper<DiscussfangwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
