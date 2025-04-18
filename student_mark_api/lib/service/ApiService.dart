// api_service.dart
import 'dart:convert';
import 'package:http/http.dart' as http;

import '../model/Student.dart';


class ApiService {
  static const String baseUrl = 'https://student-records-1ukt.onrender.com';

  // Get all students
  static Future<List<Student>> getStudents() async {
    final response = await http.get(Uri.parse('$baseUrl/students'));
    if (response.statusCode == 200) {
      List jsonResponse = json.decode(response.body);
      return jsonResponse.map((student) => Student.fromJson(student)).toList();
    } else {
      throw Exception('Failed to load students: ${response.statusCode}');
    }
  }

  // Add new student
  static Future<Student> addStudent(Student student) async {
    final response = await http.post(
      Uri.parse('$baseUrl/add-student'),
      headers: {'Content-Type': 'application/json'},
      body: json.encode(student.toJson()),
    );
    if (response.statusCode == 201) {
      return Student.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to add student: ${response.statusCode}');
    }
  }

  // Update student
  static Future<Student> updateStudent(Student student) async {
    final response = await http.put(
      Uri.parse('$baseUrl/students/${student.id}'),
      headers: {'Content-Type': 'application/json'},
      body: json.encode(student.toJson()),
    );
    if (response.statusCode == 200) {
      return Student.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to update student: ${response.statusCode}');
    }
  }

  // Delete student
  static Future<void> deleteStudent(int id) async {
    final response = await http.delete(
      Uri.parse('$baseUrl/students/$id'),
    );
    if (response.statusCode != 200) {
      throw Exception('Failed to delete student: ${response.statusCode}');
    }
  }
}