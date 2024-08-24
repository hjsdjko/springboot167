package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfangwuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangwuxinxiView;


/**
 * 房屋信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-13 21:41:38
 */
public interface DiscussfangwuxinxiService extends IService<DiscussfangwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangwuxinxiView> selectListView(Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	
   	DiscussfangwuxinxiView selectView(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	

}

