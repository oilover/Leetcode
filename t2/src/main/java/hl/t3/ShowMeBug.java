package hl.t3;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface IA {
    String getHelloName();
}

public class ShowMeBug {
    public static void main(String[] arges) throws Exception{
        IA ia = (IA) createObject(IA.class.getName()+"$getHelloName=Abc");
        System.out.println(ia.getHelloName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName()+"$getTest=Bcd");
        System.out.println(ia.getHelloName()); //方法名不匹配的时候，输出null
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断

    public static Object createObject(String str) throws Exception {
        String[] words = str.split("\\$");
        String className = words[0];
        Map<String,String> map = new HashMap<>();
        for (int i=1;i<words.length;i++) {

        }
        throw new Exception("还没有实现的方法");
    }
}
