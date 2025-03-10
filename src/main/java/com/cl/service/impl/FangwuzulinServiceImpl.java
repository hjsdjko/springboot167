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


import com.cl.dao.FangwuzulinDao;
import com.cl.entity.FangwuzulinEntity;
import com.cl.service.FangwuzulinService;
import com.cl.entity.view.FangwuzulinView;

@Service("fangwuzulinService")
public class FangwuzulinServiceImpl extends ServiceImpl<FangwuzulinDao, FangwuzulinEntity> implements FangwuzulinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwuzulinEntity> page = this.selectPage(
                new Query<FangwuzulinEntity>(params).getPage(),
                new EntityWrapper<FangwuzulinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwuzulinEntity> wrapper) {
		  Page<FangwuzulinView> page =new Query<FangwuzulinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FangwuzulinView> selectListView(Wrapper<FangwuzulinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwuzulinView selectView(Wrapper<FangwuzulinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
