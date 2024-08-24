package com.cl.entity.view;

import com.cl.entity.FangwuweixiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 房屋维修
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 21:41:37
 */
@TableName("fangwuweixiu")
public class FangwuweixiuView  extends FangwuweixiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FangwuweixiuView(){
	}
 
 	public FangwuweixiuView(FangwuweixiuEntity fangwuweixiuEntity){
 	try {
			BeanUtils.copyProperties(this, fangwuweixiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
