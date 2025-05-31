import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../model/Product.dart';

class CartPage extends StatelessWidget {
  final List<Product> cart;

  CartPage({required this.cart});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Cart")),
      body: cart.isEmpty
          ? Center(child: Text("No items in cart"))
          : ListView.builder(
        itemCount: cart.length,
        itemBuilder: (context, index) {
          final item = cart[index];
          return ListTile(
            leading: Image.asset(item.image, height: 40),
            title: Text(item.name),
            subtitle: Text("Quantity: ${item.quantity}"),
            trailing: Text("₹ ${(item.quantity * item.price).toStringAsFixed(2)}"),
          );
        },
      ),
    );
  }
}
