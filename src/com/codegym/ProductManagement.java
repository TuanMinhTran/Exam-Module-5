package com.codegym;

import java.util.*;

public class ProductManagement {
    private static Scanner sc = new Scanner(System.in);

    private static List<Product> products = new ArrayList<>();

    public static boolean running = true;

    public static void listProduct() {

        products.add(new Product(1, "Iphone X", "Chưa", 500.0, "IPHONE", 8));
        products.add(new Product(2, "Iphone 15", "Chưa", 1500.0, "IPHONE", 4));
        products.add(new Product(3, "RealMe", "Chưa", 200.0, "ANDROID", 5));
        products.add(new Product(4, "SS 22 Ultra", "Chưa", 700.0, "ANDROID", 9));

        for (Product product : products) {
            System.out.println(product);
            System.out.println();
        }

    }

    public static void addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập DANH MỤC sản phẩm: ");
        String category = sc.nextLine();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        products.add(new Product(id, name, description, price, category, quantity));
        System.out.println("Product added");
    }

    public static void updateProduct(long id) {
        Product productToUpdate = null;
        for (Product product : products) {
            if (product.getId() == id) {
                productToUpdate = product;
                break;
            }
        }

        if (productToUpdate != null) {
            System.out.print("Nhập mới mã sản phẩm: ");
            long productId = sc.nextLong();
            sc.nextLine();
            System.out.print("Nhập mới tên sản phẩm: ");
            String productName = sc.nextLine();
            System.out.print("Sửa mới mô tả: ");
            String productDescription = sc.nextLine();
            System.out.print("Giá mới: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();
            System.out.print("DANH MỤC mới: ");
            String productCategory = sc.nextLine();
            System.out.print("Thay đổi số lượng: ");
            int productQuantity = sc.nextInt();
            sc.nextLine();
            System.out.println("Product updated successfully");

            productToUpdate.setId(productId);
            productToUpdate.setName(productName);
            productToUpdate.setDescription(productDescription);
            productToUpdate.setPrice(productPrice);
            productToUpdate.setCategory(productCategory);
            productToUpdate.setQuantity(productQuantity);
        } else {
            System.out.println("Product not found");
        }
    }

    public static void deleteProduct(long id) {
        Product productToDelete = null;
        for (Product product : products) {
            if (product.getId() == id) {
                productToDelete = product;
                break;
            }
        }

        if (productToDelete != null) {
            System.out.println("Bạn có chắc chắn muốn xóa sản phẩm này không (y/n) ? ");
            String answer = sc.nextLine();
            if (answer.equals("y")) {
                products.remove(productToDelete);
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product deletion canceled");
            }
        } else {
            System.out.println("Product not found");
        }
    }

    public static void sortProductsByPrice(List<Product> products) {
        Collections.sort(products, Comparator.comparing(p -> p.getPrice()));
        System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần.");
    }

    public static void displaySortMenu(List<Product> products) {
        while (true) {
            System.out.println("1. Hiển thị danh sách sản phẩm đã sắp xếp");
            System.out.println("2. Quay về Menu chính");
            System.out.print("Vui lòng chọn (1) hoặc (2): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    listProduct();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }

    public static void handleFunction(int choose) {
        switch (choose) {
            case 1:
                System.out.println("\nDanh sách sản phẩm: ");
                listProduct();
                break;
            case 2:
                System.out.println("\nThêm mới sản phẩm: ");
                addProduct();
                break;
            case 3:
                System.out.print("\nNhập mã sản phẩm để cập nhật: ");
                long id = sc.nextLong();
                sc.nextLine();
                updateProduct(id);
                break;
            case 4:
                System.out.print("\nNhập mã sản phẩm bạn muốn xóa: ");
                id = sc.nextLong();
                sc.nextLine();
                deleteProduct(id);
                break;
            case 5:
                System.out.println("\nSắp xếp sản phẩm: ");
                sortProductsByPrice(products);
                displaySortMenu(products);
                break;
            case 6:
                System.out.println("\nSản phẩm có giá đắt nhất: ");
                break;
            case 7:
                System.out.println("\nThực hiện đọc file: ");
                break;
            case 8:
                System.out.println("\nThực hiện ghi file: ");
                break;
            case 9:
                System.out.println("\nCảm ơn bạn đã tin dùng !");
                running = false;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
        }
    }

    public static void displayMenu() {
        System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẤM ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("9. Thoát");
        System.out.print("Chọn chức năng: ");

        int choose = sc.nextInt();

        handleFunction(choose);

        do {
            System.out.print("Chọn chức năng: ");

            choose = sc.nextInt();
            handleFunction(choose);
            System.out.println();

        } while (running);
        sc.close();
    }
}
