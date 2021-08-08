package week0501.spring01;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/3 0:07
 * @Version: 1.0
 */
public class GuavaDemo {
    static EventBus bus = new EventBus();
    static {
        bus.register(new GuavaDemo());
    }


    public static void main(String[] args) {
        List<String> lists = Lists.newArrayList("a","b","g","8","9");
        String result = Joiner.on(",").join(lists);
        System.out.println(result);


        String test = "34344,34,34,哈哈";
        lists = Splitter.on(",").splitToList(test);
        System.out.println(lists);

        List<Integer> list = Lists.newArrayList(4,2,3,5,1,2,2,7,6);

        List<List<Integer>> list1 = Lists.partition(list, 3);
        print(list1);


        Multimap<Integer, Integer> bMultimap = ArrayListMultimap.create();
        list.forEach(
                a -> bMultimap.put(a, a + 1)
        );
        print(bMultimap);

        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);

        System.out.println(words.get("Second").intValue());
        System.out.println(words.inverse().get(3));

        Map<String, String> map1 = Maps.toMap(lists.listIterator(), a -> a + "-value");
        print(map1);


        Student student2 = Student.create();
        System.out.println("I want " + student2 + " run now.");
        bus.post(new AEvent(student2));
    }



    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }

    @Data
    @AllArgsConstructor
    public static class AEvent{
        private Student student;
    }

    @Subscribe
    public void handle(AEvent ae){
        System.out.println(ae.student + " is  running.");
    }
}
