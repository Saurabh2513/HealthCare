import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class UserDataPage extends StatefulWidget {
  @override
  _UserDataPageState createState() => _UserDataPageState();
}

class _UserDataPageState extends State<UserDataPage> {
  final _formKey = GlobalKey<FormState>();
  String name = '';
  String email = '';
  String dob = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Blog App'), backgroundColor: Colors.blue),
      body: Padding(
        padding: EdgeInsets.all(20),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              Icon(Icons.account_circle, size: 100, color: Colors.blue),
              SizedBox(height: 20),
              Text("Get User Data", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
              SizedBox(height: 20),
              TextFormField(
                decoration: InputDecoration(labelText: 'Name', border: OutlineInputBorder()),
                onSaved: (value) => name = value!,
              ),
              SizedBox(height: 12),
              TextFormField(
                decoration: InputDecoration(labelText: 'Email', border: OutlineInputBorder()),
                onSaved: (value) => email = value!,
              ),
              SizedBox(height: 12),
              TextFormField(
                decoration: InputDecoration(labelText: 'Date of Birth', hintText: 'MM/DD/YYYY', border: OutlineInputBorder()),
                onSaved: (value) => dob = value!,
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () {
                  _formKey.currentState!.save();
                  Navigator.pushReplacement(
                    context,
                    MaterialPageRoute(
                      builder: (_) => BlogHomePage(userName: name),
                    ),
                  );
                },
                style: ElevatedButton.styleFrom(backgroundColor: Colors.blue),
                child: Text('SUBMIT'),
              )
            ],
          ),
        ),
      ),
    );
  }
}

// Page 2: Show All Blogs
class BlogHomePage extends StatelessWidget {
  final String userName;
  BlogHomePage({required this.userName});

  final List<Map<String, String>> blogPosts = [
    {
      'title': 'Flutter 3.10 Released',
      'date': 'Apr 20, 2024',
      'description': 'The latest version of Flutter has been released. Check out the new features and improvements.',
      'image': 'https://via.placeholder.com/150/000000/FFFFFF/?text=Laptop',
    },
    {
      'title': '10 Tips for a Healthy Life',
      'date': 'Apr 18, 2024',
      'description': 'Living a healthy life doesn\'t have to be hard. Here are 10 tips to help you get started.',
      'image': 'https://via.placeholder.com/150/000000/FFFFFF/?text=Health',
    },
    {
      'title': 'How to Start a Business',
      'date': 'Apr 10, 2024',
      'description': 'Starting a business involves planning, making key financial decisions, and more.',
      'image': 'https://via.placeholder.com/150/000000/FFFFFF/?text=Business',
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Welcome, $userName!'),
        backgroundColor: Colors.blue,
      ),
      body: ListView.builder(
        padding: EdgeInsets.all(16),
        itemCount: blogPosts.length,
        itemBuilder: (context, index) {
          final blog = blogPosts[index];
          return Card(
            margin: EdgeInsets.only(bottom: 16),
            child: Padding(
              padding: const EdgeInsets.all(12.0),
              child: Row(
                children: [
                  Image.network(blog['image']!, width: 80, height: 80, fit: BoxFit.cover),
                  SizedBox(width: 12),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(blog['title']!, style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
                        Text(blog['date']!, style: TextStyle(color: Colors.grey[600])),
                        SizedBox(height: 4),
                        Text(blog['description']!, maxLines: 2, overflow: TextOverflow.ellipsis),
                      ],
                    ),
                  )
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
