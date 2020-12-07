package top.fairy.global.globalfairytoppi4j.desige;

public class StaticFactoryDemo {
    public static StaticFactoryDemo factory = null;
    public Object creat(String clzName) throws Exception {
        Object result = Class.forName(clzName).newInstance();
//        System.out.println("预备生产"+className);
//        Object producter = null;
//        if(Oriange.class.getName().equals(className)){
//
//            new Oriange();
//        }
//        if(Apple.class.getName().equals(className)){
//            new Apple();
//        }else{
//            throw new Exception();
//        }
        System.out.println("生产"+clzName+"对象实例成功");
        return result;
    }

    private StaticFactoryDemo(){}

    public static StaticFactoryDemo getInstance(){
        if (factory == null){
            factory = new StaticFactoryDemo();
        }
        return factory;
    }

    public static void main(String[] args){
        try {
            Apple apple = (Apple) StaticFactoryDemo.getInstance().creat(Apple.class.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
