package com.example.myspringboot.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckUserVo {
    public CheckUserVo(boolean isChecked,String resErrMsg){
        this.isChecked = isChecked;
        this.resErrMsg = resErrMsg;
    }
    private boolean isChecked;

    private String resErrMsg;

}
