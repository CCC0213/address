import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testIo {

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("stream1");
        list.add("stream22");
        list.add("stream333");
//使用length方法把String类型的流转换为Integer的流
        Stream<Integer>  stream=list.stream().map(String::length);
        stream.forEach(System.out :: println);
*/
        /*Stream<Integer> aa = Stream.of(10,20,30);
        aa.filter(f -> f==10).forEach(System.out::print);*/
        //Stream<String> stream = Stream.of("Im","a","stream");
        //stream.forEach(System.out::print); //print不会换行
        //stream.forEach(System.out::println); //print不会换行
       /* Stream<Integer> stream = Stream.of(10,20,30,40,50,10,20,30,90);
        //stream.skip(2).forEach(System.out::println);
        stream.distinct().forEach(System.out::println);*/
        /*Stream<String> stream=Stream.of("as","dc","fd","ascasc");
        //stream.limit(2).forEach(System.out::println);
        stream.count();*/

        /*Stream<String> stream1 = Stream.of("stream01");
        Stream<String> stream2 = Stream.of("stream02");
        Stream<String> concat = Stream.concat(stream1, stream2);
//只调用stream1进行遍历
        concat.forEach(System.out :: println);*/
        /*Stream<Integer> stream = Stream.of(10,30);
//需要用get方法取出对应流中泛型的对象
        Integer get = stream.reduce((K,V) -> K - V).get();
        System.out.println(get); //输出为40*/
        /*Stream<String> stream = Stream.of("anyMatch","b","c");
//调用String类的contains方法判断是否包含指定元素，用==和Object的equals也可以判断
        System.out.println(stream.anyMatch(k -> k.contains("a")));*/
        /*Stream<String> stream = Stream.of("allMatch","ab","ac");
//a不是一个单独的元素，对应此方法返回的是false
        System.out.println(stream.allMatch(a -> a.contains("a")));*/
        /*List<String> list = new ArrayList<>();
        list.add("collect01");
        list.add("collect02");
        list.add("collect03");
        Stream<String> stream = list.stream();
//转换为List集合
        //List<String> list1 = stream.collect(Collectors.toList());
//转换为Set集合
        Set<String> set = stream.collect(Collectors.toSet());
//使用Collectors类调用字符串拼接方法，使用过逗号分割
        //String collect = stream.collect(Collectors.joining(","));
//输出为：collect = collect--01,collect--02,collect--03
        System.out.println("collect = " + set);*/

    }

}
