package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenqingtuizuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenqingtuizuView;


/**
 * 申请退租
 *
 * @author 
 * @email 
 * @date 2024-03-13 21:41:38
 */
public interface ShenqingtuizuService extends IService<ShenqingtuizuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingtuizuView> selectListView(Wrapper<ShenqingtuizuEntity> wrapper);
   	
   	ShenqingtuizuView selectView(@Param("ew") Wrapper<ShenqingtuizuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingtuizuEntity> wrapper);
   	

}

