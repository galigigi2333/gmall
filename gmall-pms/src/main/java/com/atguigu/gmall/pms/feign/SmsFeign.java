package com.atguigu.gmall.pms.feign;


import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.api.GmallApi;
import com.atguigu.gmall.vo.SkuSaleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("sms-service")
public interface SmsFeign extends GmallApi {

}
