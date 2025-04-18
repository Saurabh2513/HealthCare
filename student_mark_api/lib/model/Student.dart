// student_model.dart
class Student {
  final int? id;
  final String name;
  final int marks;
  final double percentage;

  Student({
    required this.id,
    required this.name,
    required this.marks,
  }) : percentage = (marks / 100) * 100;

  factory Student.fromJson(Map<String, dynamic> json) {
    return Student(
      id: json['id'],
      name: json['name'],
      marks: json['marks'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'marks': marks,
    };
  }
}