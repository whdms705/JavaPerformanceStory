package ch07;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DemoTest {
    public static void main(String[] args) {
        DemoClass dc = new DemoClass();//점검 대상 클래스 객체

        DemoTest dt = new DemoTest();
        dt.getClassInfos(dc);
    }

    public void getClassInfos(Object clazz){
        Class demoClass = clazz.getClass();
        getClassInfo(demoClass);
        getFiledInfo(demoClass);
        getMethodInfo(demoClass);

    }

    public void getClassInfo(Class demoClass){
        String className = demoClass.getName();
        System.out.format("Class name : %s\n",className);

        String classCanonicalName = demoClass.getCanonicalName();
        System.out.format("CanonicalName name : %s\n",classCanonicalName);

        String classSimpleName = demoClass.getSimpleName();
        System.out.format("classSimpleName name : %s\n",classSimpleName);

        String packageName = demoClass.getPackage().getName();
        System.out.format("packageName name : %s\n",packageName);

        String toString = demoClass.toString();
        System.out.format("toString name : %s\n",toString);
    }

    public void getFiledInfo(Class demoClass){
        System.out.println("====================  filedInfo  =======================");

        Field[] filed1 = demoClass.getDeclaredFields();
        Field[] filed2 = demoClass.getFields();

       // System.out.format("Declared Filed : %d , Filed : d%\n",filed1.length,filed2.length);

        for(Field field: filed1){
            String fieldname = field.getName();
            int modifier = field.getModifiers();
            String modifierStr = Modifier.toString(modifier);
            String type = field.getType().getSimpleName();
            System.out.format("%s %s %s\n",modifierStr,type,fieldname);
        }

    }

    public void getMethodInfo(Class demoClass){
        System.out.println("====================  getMethodInfo  =======================");
        Method[] method1 = demoClass.getDeclaredMethods();
        Method[] method2 = demoClass.getMethods();
        System.out.format("Declared methods : %d, Methods : %d\n",method1.length,method2.length);


    }

}
