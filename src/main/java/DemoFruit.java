import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DemoFruit {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File("fruitList.xml"));
            Element root  = document.getRootElement();
            List<Fruit> fruits = new ArrayList<>();
            List<Element> elements = root.elements("fruit");
            for (Element item : elements){
                Integer id = Integer.parseInt(item.attributeValue("id"));
                String name = item.elementTextTrim("name");
                double price = Double.parseDouble(item.elementTextTrim("price"));
                Fruit fruit = new Fruit(id, name, price);
                fruits.add(fruit);
            }
            System.out.println(fruits.size());
            for(Fruit item : fruits){
                System.out.println(item);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
