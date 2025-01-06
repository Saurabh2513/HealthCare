import 'package:flutter/material.dart';

class my_drawer extends StatelessWidget {
  const my_drawer({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer:  Drawer(
        shadowColor: Colors.black87,
        backgroundColor: Colors.cyan,
        elevation: 0.7,
        width: 350,
        child: ListView(
          children: const [
           ListTile(
             leading: CircleAvatar(),
           )
          ],
        ),
      ),
      appBar: AppBar(
        centerTitle: true,
        title: const Text(
          "Health Care",
          style: TextStyle(color: Colors.black87),
        ),
        backgroundColor: Colors.cyanAccent,
      ),
    );
  }
}
