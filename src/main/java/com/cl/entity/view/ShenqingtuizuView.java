package com.cl.entity.view;

import com.cl.entity.ShenqingtuizuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 申请退租
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 21:41:38
 */
@TableName("shenqingtuizu")
public class ShenqingtuizuView  extends ShenqingtuizuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingtuizuView(){
	}
 
 	public ShenqingtuizuView(ShenqingtuizuEntity shenqingtuizuEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingtuizuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
