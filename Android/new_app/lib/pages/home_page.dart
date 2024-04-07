import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "Home Page",
          textAlign: TextAlign.center,
            style: TextStyle(color: Colors.black)
        ),
      ),
      body: Center(
        child: Text("Home"),
      ),
    );
  }
}
