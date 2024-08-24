package com.cl.dao;

import com.cl.entity.DiscussfangwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangwuxinxiView;


/**
 * 房屋信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-13 21:41:38
 */
public interface DiscussfangwuxinxiDao extends BaseMapper<DiscussfangwuxinxiEntity> {
	
	List<DiscussfangwuxinxiView> selectListView(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);

	List<DiscussfangwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
	
	DiscussfangwuxinxiView selectView(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
	

}
