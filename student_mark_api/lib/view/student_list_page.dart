// student_list_page.dart
import 'package:flutter/material.dart';

import '../model/Student.dart';
import '../service/ApiService.dart';
import 'add_edit_sudent_page.dart';


class StudentListPage extends StatefulWidget {
  @override
  _StudentListPageState createState() => _StudentListPageState();
}

class _StudentListPageState extends State<StudentListPage> {
  late Future<List<Student>> futureStudents;

  @override
  void initState() {
    super.initState();
    futureStudents = ApiService.getStudents();
  }

  void _refreshData() {
    setState(() {
      futureStudents = ApiService.getStudents();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Student Marks'),
        centerTitle: true,
      ),
      body: FutureBuilder<List<Student>>(
        future: futureStudents,
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return Center(child: Text('No students found'));
          } else {
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (context, index) {
                Student student = snapshot.data![index];
                return Card(
                  margin: EdgeInsets.all(8),
                  child: ListTile(
                    title: Text(student.name),
                    subtitle: Text('Marks: ${student.marks} | Percentage: ${student.percentage.toStringAsFixed(2)}%'),
                    trailing: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        IconButton(
                          icon: Icon(Icons.edit, color: Colors.blue),
                          onPressed: () async {
                            await Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) => AddEditStudentPage(student: student),
                              ),
                            );
                            _refreshData();
                          },
                        ),
                        IconButton(
                          icon: Icon(Icons.delete, color: Colors.red),
                          onPressed: () async {
                            await _deleteStudent(student.id!);
                            _refreshData();
                          },
                        ),
                      ],
                    ),
                  ),
                );
              },
            );
          }
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          await Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => AddEditStudentPage()),
          );
          _refreshData();
        },
        child: Icon(Icons.add),
      ),
    );
  }

  Future<void> _deleteStudent(int id) async {
    try {
      await ApiService.deleteStudent(id);
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Student deleted successfully')),
      );
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Failed to delete student: $e')),
      );
    }
  }
}