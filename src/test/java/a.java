import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wj.dao.ProductDao;
import com.wj.dao.impl.ProductDaoImpl;
import com.wj.domain.Product;
import com.wj.domain.Student;

import java.util.List;

public class a {
    public static void main(String[] args) {
        ProductDao p = new ProductDaoImpl();
        /*List<Product> products = p.findProductByNameLike("迪奥");
        if (products.size()!=0) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("null");
        }*/
        /*List<Product> list = p.list();
        String s = JSON.toJSONString(list,SerializerFeature.PrettyFormat);
        System.out.println(s);*/

        Student s = new Student(1, "zs");
        Student s2 = new Student(2, "ls");
        s.setStudent(s2);
        s2.setStudent(s);
        String s1 = JSON.toJSONString(s, SerializerFeature.PrettyFormat);
        System.out.println(s1);
    }
}