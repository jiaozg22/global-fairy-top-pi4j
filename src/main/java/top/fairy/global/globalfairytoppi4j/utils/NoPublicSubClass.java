package top.fairy.global.globalfairytoppi4j.utils;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/4/19 10:29
 */
public class NoPublicSubClass extends NoPublicClass {
    int ssa = a;
    int ssb = b;
    public static void main(String[] args) {
        NoPublicSubClass noPublicSubClass = new NoPublicSubClass();
        System.out.println(noPublicSubClass.ssa);
        System.out.println(noPublicSubClass.a);
    }
}
