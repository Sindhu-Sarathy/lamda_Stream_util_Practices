package se.lexicon;

import se.lexicon.lamdaExcercises.Action;
import se.lexicon.lamdaExcercises.Conditional;
import se.lexicon.lamdaExcercises.Product;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        List<Product> productList= new ArrayList<>();
        productList.add(new Product("Bread",40,0));
        productList.add(new Product("Butter",120,5));
        productList.add(new Product("Nutella",80,0));
        productList.add(new Product("Banana",30,10));
        productList.add(new Product("Cheese",140,20));


        //All products with stock value 0
        List<Product> list= processMethod(productList, p-> p.getStock()==0, p-> {});
        System.out.println("The Zero Stock products are:" +  list);

        System.out.println("----------------------------------------------------------------");

        //Print product name that start with 'B'
        List<Product> productsStartsWithB= processMethod(productList, p-> p.getProductName().startsWith("B"), p-> {});
        System.out.println("The products that start with B: ");
        for(Product p :productsStartsWithB){
            System.out.println(p.getProductName());
        }

        System.out.println("----------------------------------------------------------------");
        //print products that have price above 100 and lower than 150
        List<Product> productsPrice= processMethod(productList, p-> p.getPrice()>100 && p.getPrice()<150, p-> {});
        System.out.println("The products that have price above 100 and lower than 150: ");
        for(Product p :productsPrice){
            System.out.println(p);
        }

        System.out.println("----------------------------------------------------------------");

        //Print Products that have a stock value of less than 10 AND above 0 by 50%
        List<Product> productStockIncrease= processMethod(productList, p-> p.getStock()<10  && p.getStock()>0, p-> p.setPrice(p.getPrice()*1.5));
        System.out.println("Below products price has been increased by 50% ");
        for(Product p :productsPrice){
            System.out.println(p);
        }




    }

    public static List<Product> processMethod(List<Product> products, Conditional condition, Action action){
        List<Product> list=new ArrayList<>();
        for(Product p :products){
            if(condition.test(p)){
                action.execute(p);
                list.add(p);
            }
        }
        return list;
    }

}