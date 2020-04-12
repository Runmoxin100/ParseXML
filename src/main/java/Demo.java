import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File("./emplist.xml"));
            Element root = document.getRootElement();
            List<Emp> emps = new ArrayList<>();
            List<Element> elements = root.elements("emp");
            for(Element item : elements){
                String name = item.elementTextTrim("name");
                String gender = item.elementTextTrim("gender");
                int salary = Integer.parseInt(item.elementTextTrim("salary"));
                int age = Integer.parseInt(item.elementTextTrim("age"));
                int id = Integer.parseInt(item.attributeValue("id"));
                Emp emp = new Emp(id,name, age, gender, salary);
                emps.add(emp);
            }
            System.out.println("解析完毕...");
            for(Emp emp : emps){
                System.out.println(emp);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
