import 'package:dr_in_home/view/pages/home_page.dart';
import 'package:flutter/material.dart';

//! BottomNavigationBar

class BottomNavBarApp extends StatefulWidget {
  const BottomNavBarApp({super.key});

  @override
  State<BottomNavBarApp> createState() => _Widget028State();
}

class _Widget028State extends State<BottomNavBarApp> {
  int _currentIndex = 0;
  List<Widget> body = const [
    HomePageApp(),
    Icon(Icons.menu),
    Icon(Icons.person),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: body[_currentIndex],
      ),
      bottomNavigationBar: BottomNavigationBar(
        backgroundColor: Colors.black45,
        selectedItemColor: Colors.white,
        unselectedItemColor: Colors.blue,
        currentIndex: _currentIndex,
        onTap: (int newIndex) {
          setState(() {
            _currentIndex = newIndex;
          });
        },
        items: const [
          BottomNavigationBarItem(
            label: 'Home',
            icon: Icon(Icons.home),
          ),
          BottomNavigationBarItem(
            label: 'Menu',
            icon: Icon(Icons.menu),
          ),
          BottomNavigationBarItem(
            label: 'Profile',
            icon: Icon(Icons.person),
          )
        ],
      ),
    );
  }
}
