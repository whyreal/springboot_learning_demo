package com.example.demo.utils;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;

/**
 * 介绍 org.springframework.beans.BeanUtils 的使用
 */
public class SpringBeanUtilsUsage {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ObjA implements Mask {

        public String prop1;
        public String prop2;
        public String prop3;
        public String prop4;
        
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ObjB {

        public String prop1;
        public String prop2;
        
    }

    public interface Mask {

        final public String prop2 = null;
    }

    public static void copyPropertiesUsage() {
        
        System.out.println("拷贝全部属性, null 也被复制了, 目标对象的属性被覆盖了");
        var a1 = new ObjA("prop1", null, "prop3", "prop4");
        var a2 = new ObjA(null, "prop2", null, null);
        BeanUtils.copyProperties(a1, a2);
        System.out.println(a2);
        // output: ObjA(prop1=prop1, prop2=null, prop3=prop3, prop4=prop4)


        System.out.println("屏蔽部分属性");
        a1 = new ObjA("prop1", "prop2", "prop3", "prop4");
        a2 = new ObjA();
        BeanUtils.copyProperties(a1, a2, "prop2", "prop3");
        System.out.println(a2);
        // output: ObjA(prop1=prop1, prop2=null, prop3=null, prop4=prop4)

        System.out.println("指定需要复制的属性");
        a2 = new ObjA();
        BeanUtils.copyProperties(a1, a2, Mask.class);
        System.out.println(a2);
        // ObjA(prop1=null, prop2=prop2, prop3=null, prop4=null)

        System.out.println("不同类型间拷贝属性");
        a1 = new ObjA("prop1", "prop2", "prop3", "prop4");
        var b1 = new ObjB();
        BeanUtils.copyProperties(a1, b1);
        System.out.println(b1);
        // output: ObjB(prop1=prop1, prop2=prop2)
    }

    public static void main(String[] args) {
        copyPropertiesUsage();
    }

}