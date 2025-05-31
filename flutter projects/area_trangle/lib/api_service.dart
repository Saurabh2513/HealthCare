import 'dart:convert';
import 'package:area_trangle/post.dart';
import 'package:http/http.dart' as http;

class ApiService {
  static final instance = ApiService._();
  ApiService._();

  Future<List<Post>> fetchPosts() async {
    final url = Uri.parse('https://jsonplaceholder.typicode.com/posts');
    final response = await http.get(url);

    if (response.statusCode == 200) {
      final jsonData = jsonDecode(response.body);
      final list = jsonData.map((json) => Post.fromJson(json)).toList();
      return list.cast<Post>();
    } else {
      return [];
    }
  }
}