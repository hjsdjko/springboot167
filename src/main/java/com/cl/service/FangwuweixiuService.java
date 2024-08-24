package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangwuweixiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuweixiuView;


/**
 * 房屋维修
 *
 * @author 
 * @email 
 * @date 2024-03-13 21:41:37
 */
public interface FangwuweixiuService extends IService<FangwuweixiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuweixiuView> selectListView(Wrapper<FangwuweixiuEntity> wrapper);
   	
   	FangwuweixiuView selectView(@Param("ew") Wrapper<FangwuweixiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwuweixiuEntity> wrapper);
   	

}

