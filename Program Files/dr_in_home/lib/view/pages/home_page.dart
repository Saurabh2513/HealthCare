import 'package:dr_in_home/view/tools/my_drawer.dart';
import 'package:flutter/material.dart';

class HomePageApp extends StatefulWidget {
  const HomePageApp({super.key});

  @override
  State<HomePageApp> createState() => _HomePageAppState();
}

class _HomePageAppState extends State<HomePageApp> {
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
        debugShowCheckedModeBanner: false, home: my_drawer());
  }
}
