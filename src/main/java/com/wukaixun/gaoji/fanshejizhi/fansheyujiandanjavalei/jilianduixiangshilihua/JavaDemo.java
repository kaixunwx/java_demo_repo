package com.wukaixun.gaoji.fanshejizhi.fansheyujiandanjavalei.jilianduixiangshilihua;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 及联对象实例化
 * 如果给定的对象中存在有其他对象的引用的及联关系的情况下，称为多级设置。如一个雇员属于一个部门，一个部分属于一个公司
 *
 * @author wukaixun
 * @date 2020.11.26
 */
public class JavaDemo {
    public static void main(String[] args) {
        String value = "eid:12345|ename:wukaixun|ejob:engineer|esalary:14000|ehiredate:2020-01-05|dept.dname:AE|dept.company.cname:alibaba";
        Emp emp = ClassInstanceFactory.create(Emp.class, value);
        System.out.println("雇员ID:" + emp.getEid() + "\r\n姓名:" + emp.getEname() + "\r\n职业:" + emp.getEjob() + "\r\n薪水:" + emp.getEsalary() + "\r\n雇佣日期:" + emp.getEhiredate());
        System.out.println("dept:" + emp.getDept().getDname());
        System.out.println("company:" + emp.getDept().getCompany().getCname());
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
                if (attval[0].contains(".")) {
                    String[] temp = attval[0].split("\\.");
                    Object currentObject = obj;
                    for (int x = 0; x < temp.length - 1; x++) { // 最后一位肯定是指定类中的属性名称，不参与实例化操作过程
                        // 首先判断该对象有无被实例化
                        Method getMethod = currentObject.getClass().getDeclaredMethod("get" + StringUtils.initCap(temp[x]));  // 获取该对象的getter方法
                        Object tempObject = getMethod.invoke(currentObject);
                        if (tempObject == null) { // 如果getter方法获取到该对象为空则对象还未实例化
                            Field field = currentObject.getClass().getDeclaredField(temp[x]);  // 获取当前对象的Field对象
                            Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initCap(temp[x]), field.getType()); // 获取该对象的setter方法
                            Object newObject = field.getType().getDeclaredConstructor().newInstance(); // 实例化该对象
                            setMethod.invoke(currentObject, newObject);  // 把实例化出的新对象赋值给当前对象的对应属性
                            currentObject = newObject;
                        } else {  // 对象已经被实例化
                            currentObject = tempObject;
                        }
                    }
                    // 当循环完成后 currentObject就是要操作设置属性的对象
                    Field field = currentObject.getClass().getDeclaredField(temp[temp.length - 1]);
                    Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initCap(temp[temp.length - 1]), field.getType());
                    Object convertVal = convertAttributeType(field.getType().getName(), attval[1]);
                    setMethod.invoke(currentObject, convertVal);
                } else {
                    Field field = obj.getClass().getDeclaredField(attval[0]);
                    Method method = obj.getClass().getDeclaredMethod("set" + StringUtils.initCap(attval[0]), field.getType());
                    Object convertVal = convertAttributeType(field.getType().getName(), attval[1]);
                    method.invoke(obj, convertVal);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Object convertAttributeType(String type, String value) {
        if (type.equals("long") || type.equals("java.lang.Long")) {
            return Long.parseLong(value);
        } else if (type.equals("int") || type.equals("java.long.Integer")) {
            return Integer.parseInt(value);
        } else if (type.equals("double") || type.equals("java.lang.Double")) {
            return Double.parseDouble(value);
        } else if (type.equals("java.util.Date")) {
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}-\\d{2}-\\d{2}")) {
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

class Company {
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}

class Dept {
    private String dname;
    private Company company;

    public String getDname() {
        return dname;
    }

    public Company getCompany() {
        return company;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}


class Emp {
    private Long eid;
    private String ename;
    private String ejob;
    private Double esalary;
    private Date ehiredate;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

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
