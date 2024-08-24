package com.cl.dao;

import com.cl.entity.FangwuweixiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuweixiuView;


/**
 * 房屋维修
 * 
 * @author 
 * @email 
 * @date 2024-03-13 21:41:37
 */
public interface FangwuweixiuDao extends BaseMapper<FangwuweixiuEntity> {
	
	List<FangwuweixiuView> selectListView(@Param("ew") Wrapper<FangwuweixiuEntity> wrapper);

	List<FangwuweixiuView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuweixiuEntity> wrapper);
	
	FangwuweixiuView selectView(@Param("ew") Wrapper<FangwuweixiuEntity> wrapper);
	

}
