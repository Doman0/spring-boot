package com.doman.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/15 User
 */
@NoArgsConstructor //生成一个无参数的构造器
@AllArgsConstructor //生成一个包括所有成员的构造器
@ToString(exclude = {"name","password"}) //设置不包含字段,of包含
@EqualsAndHashCode(of = {"name","password"}) //生成equals(Object other)和hashCode()方法，exclude排除属性，of包含属性
@Data //相当于@Getter、@Setter、@RequiredArgsConstructor、@ToString和@EqualsAndHashCode
public class User {
    private  String name;

    @JsonIgnore //返回前端忽略该属性
    private  String password;

    //日期格式化
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a",locale = "zh",timezone = "GMT+8")
    private  Date birthday;

    private  int  age;

    //为null(不包括“”)时，忽略该属性
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    //为empty(包括“”)时，忽略该属性
    /*
    * 属性为null时，返回“”字符串
    * fastjson针对返回处理，查看SerializerFeature属性
    * jsonObject.toJSONString(apiResData, SerializerFeature.WriteMapNullValue);
    * WriteNullStringAsEmpty    字符类型字段如果为null,输出为”“,而非null
    */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private  String desc;

    @JsonProperty("yAxis") //取消返回前端自动转为小写
    private  String yAix;
}
