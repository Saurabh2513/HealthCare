import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../model/Product.dart';
import 'cart_page.dart';

class ProductPage extends StatefulWidget {
  const ProductPage({super.key});

  @override
  State<ProductPage> createState() => _ProductPageState();
}

class _ProductPageState extends State<ProductPage> {
  List<Product> productList = [
    Product(id: 1,name: 'product 1', image: 'assets/product_1.png', price: 100.99),
    Product(id: 2,name: 'product 2', image: 'assets/product_2.png',price: 150.50),
    Product(id: 3,name: 'product 3', image: 'assets/product_3.png',price: 120.00),
    Product(id: 4,name: 'product 4', image: 'assets/product_4.png',price: 180.50),
  ];
  List<Product> cart = [];

  void addToCart(Product product) {
    setState(() {
      product.quantity = 1;
      cart.add(product);
    });
  }

  void updateQuantity(Product product, int change) {
    setState(() {
      product.quantity += change;
      if (product.quantity <= 0) {
        cart.removeWhere((item) => item.id == product.id);
        product.quantity = 0;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Product List"),
        actions: [
          IconButton(
            icon: Icon(Icons.shopping_cart),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (_) => CartPage(cart: cart)),
              );
            },
          )
        ],
      ),
      body: GridView.builder(
        padding: EdgeInsets.all(10),
        itemCount: productList.length,
        gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2,
            childAspectRatio: 0.7
        ),
        itemBuilder: (context, index) {
          Product product = productList[index];
          return Card(
            elevation: 10,
            child: Column(
              children: [
                Image.asset(product.image, height: 200),
                Text(product.name),
                Text("₹ ${product.price.toStringAsFixed(2)}"),
                product.quantity == 0
                    ? ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    minimumSize: Size(200, 50), // Width, Height
                    padding: EdgeInsets.symmetric(horizontal: 20, vertical: 20),
                    textStyle: TextStyle(fontSize: 16, fontWeight: FontWeight.bold,color: Colors.white),
                    backgroundColor: Colors.green.shade200, // Optional styling
                  ),
                  onPressed: () => addToCart(product),
                  child: Text("Add to Cart"),
                )
                    : Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    IconButton(
                      onPressed: () => updateQuantity(product, -1),
                      icon: Icon(Icons.remove),
                    ),
                    Text('${product.quantity}'),
                    IconButton(
                      onPressed: () => updateQuantity(product, 1),
                      icon: Icon(Icons.add),
                    ),
                  ],
                )
              ],
            ),
          );
        },
      ),
    );
  }
}
