package ch07;

public class DemoClass {
    private String privateFiled;
    String field;
    protected  String protectedFiled;
    public String publicFiled;

    public DemoClass(){}
    public DemoClass(String arg){}

    public void publicMehod()throws java.io.IOException,Exception{}
    public String publicMethod(String s,int i){
        return "s="+s+" i="+i;
    }

    protected void protectedMehtod(){}
    private void privateMethod(){}
    void method(){}

    public String publicRetMethod(){return null;}
    public InnerClass getInnerClass(){
        return new InnerClass();
    }

    public class InnerClass{}

}
