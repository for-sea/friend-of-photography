package com.forsea.config;

import javax.validation.groups.Default;

/**
 * @program: friend-of-photography
 * @description: 分组校验接口
 * @author: 肖四海
 * @create: 2022-05-18 14:23
 **/
public interface ValidGroup extends Default {
    interface Crud extends ValidGroup{
        interface Create extends Crud{}

        interface Update extends Crud{}

        interface Query extends Crud{}

        interface Delete extends Crud{}
    }
}
