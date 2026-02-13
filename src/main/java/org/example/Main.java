package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct(new Product(1, "Laptop", 999.99, "Dell", "Electronics", 4, 10));
        pm.addProduct(new Product(2, "Smartphone", 499.99, "Samsung", "Electronics", 5, 15));
        pm.addProduct(new Product(3, "Headphones", 199.99, "Sony", "Audio", 4, 20));

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Sort by Price Desc(Comparable)\n2. Sort by Price (Asc)\n3. Sort by Rating\n4. Sort by Discount\n5. Filter by Brand\n6. Filter by Category\n7. Filter by Cost Range\nEnter choice:");
        int choice = sc.nextInt();
        
        switch(choice) {
            case 1:
                pm.mapToListSortByPriceComparable();
                break;
            case 2:
                pm.mapToListSortByPriceAsc();
                break;
            case 3:
                pm.mapToListSortByRatingAsc();
                break;
            case 4:
                pm.mapToListSortByDiscountAsc();
                break;
            case 5:
                System.out.println("Enter brand:");
                sc.nextLine();
                String brand = sc.nextLine();
                pm.filterByBrand(brand);
                break;
            case 6:
                System.out.println("Enter category:");
                sc.nextLine();
                String category = sc.nextLine();
                pm.filterByCategory(category);
                break;
            case 7:
                System.out.println("Enter price range (min max):");
                double minPrice = sc.nextDouble();
                double maxPrice = sc.nextDouble();
                pm.filterByPriceRange(minPrice, maxPrice);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}