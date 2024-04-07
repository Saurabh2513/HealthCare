import 'package:flutter/material.dart';

class SettingPage extends StatelessWidget {
  const SettingPage({super.key});

  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar: AppBar(
        title: Text(
          "Setting Page",
          textAlign: TextAlign.center,
        ),
      ),
      body: Center(
        child: Text("Setting"),
      ),
    );
  }
}
