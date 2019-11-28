package com.jerry.springboot_exception.result;

import com.alibaba.fastjson.JSONObject;
import com.jerry.springboot_exception.enums.CommonEnum;
import com.jerry.springboot_exception.exception.BaseErrorInfoInterface;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultBody {
    private String code;
    private String message;
    private Object result;

    public ResultBody() {
    }

   public ResultBody(BaseErrorInfoInterface errorInfoInterface)
   {
       this.code=errorInfoInterface.getResultCode();
       this.message=errorInfoInterface.getResultMsg();
   }
    public static ResultBody success()
    {
        return success(null);
    }

    public static ResultBody success(Object data)
    {
        ResultBody b=new ResultBody();
        b.setCode(CommonEnum.SUCCESS.getResultCode());
        b.setMessage(CommonEnum.SUCCESS.getResultMsg());
        b.setResult(data);
        return b;
    }
    public static ResultBody error(BaseErrorInfoInterface errorInfoInterface)
    {
        ResultBody b=new ResultBody();

        b.setCode(errorInfoInterface.getResultCode());
        b.setMessage(errorInfoInterface.getResultMsg());
        b.setResult(null);
        return b;
    }
    public static ResultBody error(String code,String message)
    {
        ResultBody b=new ResultBody();
        b.setCode(code);
        b.setMessage(message);
        b.setResult(null);
        return b;
    }
    public static ResultBody error(String message)
    {
        ResultBody b=new ResultBody();
        b.setCode("-1");
        b.setMessage(message);
        b.setResult(null);
        return b;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
