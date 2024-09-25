package com.atguigu.schedule.pojo;

import lombok.*;

/**
 *
 * 属性必须是私有的
 * 必须具有无参构造器
 * 应该实现序列化接口
 */

@AllArgsConstructor   //自动添加全参构造
@NoArgsConstructor    //
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data       //一个注解包含getter setter equals hashcode toString
public class SysUser {
    private Integer uid;
    private String username;
    private String userPwd;


}
