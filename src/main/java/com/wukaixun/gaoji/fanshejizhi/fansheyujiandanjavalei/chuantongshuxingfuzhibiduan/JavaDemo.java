package com.wukaixun.gaoji.fanshejizhi.fansheyujiandanjavalei.chuantongshuxingfuzhibiduan;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 传统属性赋值弊端
 * 传统开发方式中，如果一个类有N多属性，那么就需要写N多的getter和setter方法。代码会存在有很大的重复问题，唯一解决方案就是采用反射机制。
 *
 * @author wukaixun
 * @date 2020.11.26
 */
public class JavaDemo {
    public static void main(String[] args) {
        String value = "eid:12345|ename:wukaixun|ejob:engineer|esalary:14000|ehiredate:2020-01-05";
        Emp emp = ClassInstanceFactory.create(Emp.class, value);
        System.out.println("雇员ID:" + emp.getEid() + "\r\n姓名:" + emp.getEname() + "\r\n职业:" + emp.getEjob() + "\r\n薪水:" + emp.getEsalary() + "\r\n雇佣日期:" + emp.getEhiredate());
    }

}

class ClassInstanceFactory {
    private ClassInstanceFactory() {
    }

    public static <T> T create(Class<T> clazz, String value) {
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj, value);
            return clazz.cast(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class StringUtils {
    private StringUtils() {
    }

    /**
     * 首字母大写
     *
     * @param str
     * @return
     */
    public static String initCap(String str) {
        if (str == null || str.equals("")) {
            return str;
        } else if (str.length() == 1) {
            return str.toUpperCase();
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}

class BeanUtils {
    private BeanUtils() {
    }

    ;

    public static void setValue(Object obj, String value) {
        String[] results = value.split("\\|");  // 按照"|"拆分属性内容
        for (String result : results) {  // 循环设置属性
            String attval[] = result.split(":");  // 获取属性名称和属性值
            try {
                Field field = obj.getClass().getDeclaredField(attval[0]);
                Method method = obj.getClass().getDeclaredMethod("set" + StringUtils.initCap(attval[0]), field.getType());
                Object convertVal = convertAttributeType(field.getType().getName(), attval[1]);
                method.invoke(obj, convertVal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Object convertAttributeType(String type, String value) {
        if(type.equals("long")|| type.equals("java.lang.Long")){
            return Long.parseLong(value);
        } else if(type.equals("int") || type.equals("java.long.Integer")){
            return Integer.parseInt(value);
        } else if(type.equals("double") || type.equals("java.lang.Double")){
            return Double.parseDouble(value);
        } else if(type.equals("java.util.Date")){
            SimpleDateFormat sdf = null;
            if(value.matches("\\d{4}-\\d{2}-\\d{2}")){
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if(value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}-\\d{2}-\\d{2}")){
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                return new Date();
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();
            }
        } else {
            return value;
        }
    }
}


class Emp {
    private Long eid;
    private String ename;
    private String ejob;
    private Double esalary;
    private Date ehiredate;

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public void setEsalary(Double esalary) {
        this.esalary = esalary;
    }

    public void setEhiredate(Date ehiredate) {
        this.ehiredate = ehiredate;
    }

    public long getEid() {
        return eid;
    }

    public double getEsalary() {
        return esalary;
    }

    public Date getEhiredate() {
        return ehiredate;
    }


    public String getEname() {
        return ename;
    }

    public String getEjob() {
        return ejob;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEjob(String ejob) {
        this.ejob = ejob;
    }
}
