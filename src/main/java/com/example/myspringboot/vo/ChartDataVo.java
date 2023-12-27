package com.example.myspringboot.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChartDataVo {

    private List<String> days = new ArrayList<>();

    private List<Long> nums = new ArrayList<>();

}
