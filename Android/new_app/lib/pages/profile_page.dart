import 'package:flutter/material.dart';

class ProfilePage extends StatelessWidget {
  const ProfilePage({super.key});

  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar: AppBar(
        title: Text(
          "Profile Page",
          textAlign: TextAlign.center,
        ),
      ),
      body: Center(
        child: Text("Profile"),
      ),
    );
  }
}