package com.atguigu.gmall.api;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.vo.SkuSaleVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface GmallApi {

    @PostMapping("sms/skubounds/skusale/save")
    public Resp<Object> saveSkuSaleInfo(@RequestBody SkuSaleVo skuSaleVo);
}
