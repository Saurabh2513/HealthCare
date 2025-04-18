// add_edit_student_page.dart
import 'package:flutter/material.dart';

import '../model/Student.dart';
import '../service/ApiService.dart';


class AddEditStudentPage extends StatefulWidget {
  final Student? student;

  AddEditStudentPage({this.student});

  @override
  _AddEditStudentPageState createState() => _AddEditStudentPageState();
}

class _AddEditStudentPageState extends State<AddEditStudentPage> {
  final _formKey = GlobalKey<FormState>();
  late TextEditingController _nameController;
  late TextEditingController _marksController;

  @override
  void initState() {
    super.initState();
    _nameController = TextEditingController(text: widget.student?.name ?? '');
    _marksController = TextEditingController(
        text: widget.student?.marks.toString() ?? '');
  }

  @override
  void dispose() {
    _nameController.dispose();
    _marksController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.student == null ? 'Add Student' : 'Edit Student'),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                controller: _nameController,
                decoration: InputDecoration(labelText: 'Student Name'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter student name';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              TextFormField(
                controller: _marksController,
                decoration: InputDecoration(labelText: 'Marks (out of 100)'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter marks';
                  }
                  final marks = int.tryParse(value);
                  if (marks == null || marks < 0 || marks > 100) {
                    return 'Please enter valid marks (0-100)';
                  }
                  return null;
                },
              ),
              SizedBox(height: 32),
              ElevatedButton(
                onPressed: _submitForm,
                child: Text('Submit'),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Future<void> _submitForm() async {
    if (_formKey.currentState!.validate()) {
      try {
        final name = _nameController.text;
        final marks = int.parse(_marksController.text);

        if (widget.student == null) {
          // Add new student
          await ApiService.addStudent(Student(name: name, marks: marks, id: null));
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(content: Text('Student added successfully')),
          );
        } else {
          // Update existing student
          await ApiService.updateStudent(Student(
            id: widget.student!.id,
            name: name,
            marks: marks,
          ));
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(content: Text('Student updated successfully')),
          );
        }
        Navigator.pop(context);
      } catch (e) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Error: $e')),
        );
      }
    }
  }
}
