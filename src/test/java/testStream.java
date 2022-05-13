import dao.perpson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testStream {
    public static void main(String[] args) {
        /*List<String> list3 = Arrays.asList("zhangSan", "liSi", "wangWu");
        list3.forEach(a ->System.out.print(a+","));*/

        /*List<String> list4 = list3.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("转换之后的数据:" + list4);


        List<String> list = Arrays.asList("1", "2", "3");
        List<Integer> list1 = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("转换之后的数据:" + list1);


        List<String> list22 = Arrays.asList("aoicwE","adadWDD","adcQWEFWCFRF") ;
        List<Integer> aaa = list22.stream().map(String::length).collect(Collectors.toList());
        System.out.println(aaa);*/
        perpson a =new perpson();
        a.setName("zhangsan");
        a.getAge(19);
        perpson b =new perpson();
        b.setName("lisi");
        b.getAge(20);

        List <perpson>  aa = new ArrayList<perpson>();
        aa.add(a);
        aa.add(b);

/*
        Stream personsOver18 = aa.stream().filter(perpson -> perpson.getAge());
*/

    }
}
