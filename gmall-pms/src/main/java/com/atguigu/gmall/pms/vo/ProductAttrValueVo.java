package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.ProductAttrValueEntity;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;


import java.util.List;

@Data
public class ProductAttrValueVo extends ProductAttrValueEntity {

     public void  setValueSelected(List<Object> valueSelected){

         if (CollectionUtils.isEmpty(valueSelected)){
             return;
         }
         setAttrValue(StringUtils.join(valueSelected,","));
     }

}
