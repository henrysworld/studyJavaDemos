package week0501.spring01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/2 23:42
 * @Version: 1.0
 */
public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,3,5,1,2,2,7,6); //Arrays还可以包装stream
        print(list);
        Collections.sort(list);
        print(list);
        Collections.reverse(list);
        print(list);
        Collections.shuffle(list);
        print(list);

        System.out.println(Collections.frequency(list, 2));//重复数量
        System.out.println(Collections.max(list));

        Collections.fill(list, 8);
        print(list);

        list = Collections.singletonList(6);
        print(list);

    }

    private static void print(List<Integer> list){
        System.out.println(String.join(",", list.stream().map(i -> i.toString()).collect(Collectors.toList()).toArray(new String[]{})));
    }
}
