package week0501.spring01;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/2 23:50
 * @Version: 1.0
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,3,5,1,2,2,7,6);
        print(list);

        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first.map( i -> i * 100).orElse(100));

        int sum = list.stream().filter( i -> i < 4).distinct().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        Map<Integer, Integer> map = list.parallelStream().collect(Collectors.toMap( a -> a, a -> (a + 1), (a,b) -> a, HashMap::new));
        print(map);

        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        List<Integer> list1 = map.entrySet().parallelStream().map( e -> e.getKey() + e.getValue()).collect(Collectors.toList());
        print(list1);
    }
    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }

}
