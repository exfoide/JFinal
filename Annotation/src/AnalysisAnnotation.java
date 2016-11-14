import java.lang.reflect.Method;

/**
 * Created by Jasper on 2016/9/29.
 */
public class AnalysisAnnotation {
    /**
     * 在运行时分析处理annotation类型的信息
     * **/

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("Utility");
        Method[] methods = clazz.getMethods();

        boolean flag = clazz.isAnnotationPresent(Description.class);
        if (flag){
            Description description = (Description) clazz.getAnnotation(Description.class);
            System.out.println("Utility's Description--->" + description.value());

            for (Method method : methods){
                if (method.isAnnotationPresent(Author.class)){
                    Author author = method.getAnnotation(Author.class);
                    System.out.println("Utility's author " + author.name() + " from " + author.group());
                }
            }
        }
    }
}
