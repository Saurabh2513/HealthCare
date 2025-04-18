import 'package:flutter/material.dart';
import 'package:student_mark_api/view/add_edit_sudent_page.dart';
import 'package:student_mark_api/view/student_list_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
    debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home:  StudentListPage(),
      routes: {
        '/add': (context) => AddEditStudentPage(),
        '/edit': (context) => AddEditStudentPage(),
      },
    );
  }
}

