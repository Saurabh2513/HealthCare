import 'package:flutter/material.dart';
import 'package:new_app/pages/home_page.dart';
import 'package:new_app/pages/profile_page.dart';
import 'package:new_app/pages/setting_page.dart';

class PageOne extends StatefulWidget {
  PageOne({super.key});

  @override
  State<PageOne> createState() => _PageOneState();
}

class _PageOneState extends State<PageOne> {
  int _selectedIndex = 0;

  void navigateBottomBar(int index) {
    setState(() {
      _selectedIndex = index;

    });
  }

  final List _pages = [
    // Home page
    HomePage(),
    // Profile Page
    ProfilePage(),
    // setting page
    SettingPage(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Page One"),
        elevation: 0,
      ),
      drawer: Drawer(
        backgroundColor: Colors.deepPurple[100],
        child: Column(
          children: [
            // common to place drawer header here
            DrawerHeader(
              child: Icon(
                Icons.favorite,
                size: 60,
                color: Colors.white,
              ),
            ),
            //Home page list
            ListTile(
              leading: Icon(Icons.home, color: Colors.white),
              title: Text(
                "Home",
                style: TextStyle(color: Colors.white),
              ),
              onTap: () {
                Navigator.pop(context);
                // Go Home Page
                Navigator.pushNamed(context, '/homepage');
              },
            ),
            // setting page list
            ListTile(
              leading: Icon(Icons.settings, color: Colors.white),
              title: Text(
                "Setting",
                style: TextStyle(color: Colors.white),
              ),
              onTap: () {
                Navigator.pop(context);
                // Go Setting Page
                Navigator.pushNamed(context, '/setting-page');
              },
            ),
            // profile page list
            ListTile(
              leading: Icon(Icons.person, color: Colors.white),
              title: Text(
                "Profile",
                style: TextStyle(color: Colors.white),
              ),
              onTap: () {
                Navigator.pop(context);
                // Go Setting Page
                Navigator.pushNamed(context, '/profile-page');
              },
            ),
          ],
        ),
      ),
      body: _pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: navigateBottomBar,
        items: [
          // Home
          BottomNavigationBarItem(
            backgroundColor: Colors.deepPurple[200],
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          // Profile
          BottomNavigationBarItem(
            backgroundColor: Colors.deepPurple[200],
            icon: Icon(Icons.person),
            label: 'Profile',
          ),
          // setting
          BottomNavigationBarItem(
            backgroundColor: Colors.deepPurple[200],
            icon: Icon(Icons.settings),
            label: 'Settings',
          ),
        ],
      ),
    );
  }
}
