package com.cl.dao;

import com.cl.entity.ShenqingtuizuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenqingtuizuView;


/**
 * 申请退租
 * 
 * @author 
 * @email 
 * @date 2024-03-13 21:41:38
 */
public interface ShenqingtuizuDao extends BaseMapper<ShenqingtuizuEntity> {
	
	List<ShenqingtuizuView> selectListView(@Param("ew") Wrapper<ShenqingtuizuEntity> wrapper);

	List<ShenqingtuizuView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingtuizuEntity> wrapper);
	
	ShenqingtuizuView selectView(@Param("ew") Wrapper<ShenqingtuizuEntity> wrapper);
	

}
