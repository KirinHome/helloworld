package com.lxk.test;

import com.lxk.enumModel.GameEnum;

import java.util.List;

/**
 * Java枚举用法测试
 * <p>
 * Created by lxk on 2016/12/15
 */
public class EnumTest {
    public static void main(String[] args) {
        //forEnum();
        //useEnumInJava();
        //testNewEnum();
        testEnumEqual();
    }

    /**
     * 测试枚举比较,使用equal和==
     */
    private static void testEnumEqual() {
        GameEnum s1 = GameEnum.BIG;
        GameEnum s2 = GameEnum.BIG;
        GameEnum ss1 = GameEnum.SMALL;
        System.out.println("s1 == s2：" + (s1 == s2));
        System.out.println("s1.equals(s2)：" + (s1.equals(s2)));

        System.out.println("s1 == ss1：" + (s1 == ss1));
        System.out.println("s1.equals(ss1)：" + (s1.equals(ss1)));
    }

    /**
     * 测试新建某个枚举的枚举变量
     * @see GameEnum
     * @see com.lxk.collectionTest.GetDifferenceSet#getDifferenceSetByGuava(List, List)
     */
    private static void testNewEnum() {
        GameEnum s = GameEnum.BIG;
        GameEnum ss = GameEnum.SMALL;
        GameEnum sss = GameEnum.FATTER;
    }

    /**
     * 循环枚举,输出ordinal属性；若枚举有内部属性，则也输出。(说的就是我定义的TYPE类型的枚举的typeName属性)
     */
    private static void forEnum() {
        for (SimpleEnum simpleEnum : SimpleEnum.values()) {
            System.out.println(simpleEnum + "  ordinal  " + simpleEnum.ordinal());
        }
        System.out.println("------------------");
        for (TypeEnum typeEnum : TypeEnum.values()) {
            System.out.println("type = " + typeEnum + "    type.name = " + typeEnum.name() + "   typeName = " + typeEnum.getTypeName() + "   ordinal = " + typeEnum.ordinal());
        }
    }

    /**
     * 在Java代码使用枚举
     */
    private static void useEnumInJava() {
        String typeName = "f5";
        TypeEnum typeEnum = TypeEnum.fromTypeName(typeName);
        if (TypeEnum.BALANCE.equals(typeEnum)) {
            System.out.println("根据字符串获得的枚举类型实例跟枚举常量一致");
        } else {
            System.out.println("大师兄代码错误");
        }

    }

    /**
     * 季节枚举(不带参数的枚举常量)这个是最简单的枚举使用实例
     * Ordinal 属性，对应的就是排列顺序，从0开始。
     */
    private enum SimpleEnum {
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER
    }


    /**
     * 常用类型(带参数的枚举常量，这个只是在书上不常见，实际使用还是很多的，看懂这个，使用就不是问题啦。)
     */
    private enum TypeEnum {
        FIREWALL("firewall"),
        SECRET("secretMac"),
        BALANCE("f5");

        private String typeName;

        TypeEnum(String typeName) {
            this.typeName = typeName;
        }

        /**
         * 根据类型的名称，返回类型的枚举实例。
         *
         * @param typeName 类型名称
         */
        public static TypeEnum fromTypeName(String typeName) {
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.getTypeName().equals(typeName)) {
                    return typeEnum;
                }
            }
            return null;
        }

        public String getTypeName() {
            return this.typeName;
        }
    }
}
