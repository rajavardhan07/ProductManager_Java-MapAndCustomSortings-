package org.example;

import java.util.*;
import java.util.stream.Stream;

public class ProductManager {
    HashMap<Integer,Product> products = new HashMap<>();

    public void addProduct(Product p)
    {
        products.put(p.getPid(),p);
    }

    public void removeProduct(int pid) {
        products.remove(pid);
    }
    public void printProducts()
    {
        for(Map.Entry<Integer,Product> entry:products.entrySet())
        {
            Product p=entry.getValue();
            System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getRating()+" "+p.getDiscount());
        }
    }

    //sorting by price using comparable interface in descending order
    public void mapToListSortByPriceComparable()
    {
        List<Product> list=new ArrayList<>(products.values());
        System.out.println("Before sorting by price:");
        for(Product p:list)
        {
            System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getRating()+" "+p.getDiscount());
        }
        Collections.sort(list);
        System.out.println("After sorting by price:");
        for(Product p:list)
        {
            System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
        }
    }


    public void mapToListSortByPriceAsc()
    {
        //        List<Product> list=new ArrayList<>(products.values());
        //        System.out.println("Before sorting by price:");
        //        for(Product p:list)
        //        {
        //            System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getRating()+" "+p.getDiscount());
        //        }
        //        Collections.sort(list,(p1,p2)->Double.compare(p1.getPrice(),p2.getPrice()));
        //        System.out.println("After sorting by price:");
        //        for(Product p:list)
        //        {
        //            System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
        //        }
        products.values().stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .forEach(p -> System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount()));
    }

    public void mapToListSortByRatingAsc()
    {
        List<Product> list=new ArrayList<>(products.values());
        System.out.println("Before sorting by rating:");
        for(Product p:list){
            System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getRating()+" "+p.getDiscount());
        }
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getRating(),o2.getRating());
            }
        });
        System.out.println("After sorting by rating:");
        for(Product p:list) {
            System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
        }
    }

    public void mapToListSortByDiscountAsc()
    {
        List<Product> list=new ArrayList<>(products.values());
        System.out.println("Before sorting by discount:");
        for(Product p:list){
            System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getRating()+" "+p.getDiscount());
        }
        Collections.sort(list,(p1,p2)->Integer.compare(p1.getDiscount(),p2.getDiscount()));

        System.out.println("After sorting by discount:");
        for(Product p:list) {
            System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
        }
    }

    public Stream<Map.Entry<Integer, Product>> sortByDiscountDescIdAsc(){
        return products.entrySet().stream()
                .sorted((e1,e2)->{;
                    int discountCompare=Integer.compare(e2.getValue().getDiscount(),e1.getValue().getDiscount());
                    if(discountCompare!=0){
                        return discountCompare;
                    }else{
                        return Integer.compare(e1.getKey(),e2.getKey());
                    }
                });
    }

    public List<Product> filterByBrand(String Brand){
        List<Product> list = new ArrayList<>(products.values());
        //        System.out.println("Products of brand "+Brand+" are:");
        //        for(Product p:list){
        //            if(p.getBrand().equals(Brand)){
        //                System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
        //            }
        //        }
        return products.values().stream()
                .filter(p -> p.getBrand().equals(Brand))
                .toList();

    }

    public List<Product> filterByCategory(String cat){
        //        List<Product> list=new ArrayList<>(products.values());
        //        System.out.println("Products of category "+cat+" are:");
        //        for(Product p:list){
        //            if(p.getCategory().equalsIgnoreCase(cat)){
        //                System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
        //            }
        //        }
        return products.values().stream()
                .filter(p->p.getCategory().equals(cat))
                .toList();
    }
    public List<Product> filterByPriceRange(double minPrice,double maxPrice){
        //        List<Product> list=new ArrayList<>(products.values());
        //        System.out.println("Products in price range "+minPrice+" to "+maxPrice+" are:");
        //        for(Product p:list)
        //        {
        //            if(p.getPrice()>=minPrice && p.getPrice()<=maxPrice)
        //            {
        //                System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
        //            }
        //        }
        return products.values().stream()
                .filter(p->p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .toList();
    }


    public void minPrice(){
        List<Product> list=new ArrayList<>(products.values());
        double minPrice=Double.MAX_VALUE;
        for(Product p:list)
        {
            if(p.getPrice()<=minPrice )
            {
                minPrice=p.getPrice();
            }
        }
        for(Product p:list)
        {
            if(p.getPrice()==minPrice)
            {
                System.out.println("Product with minimum price is:"); System.out.println(p.getPid() + " " + p.getPname() + " " + p.getPrice() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getRating() + " " + p.getDiscount());
            }
        }
    }
}