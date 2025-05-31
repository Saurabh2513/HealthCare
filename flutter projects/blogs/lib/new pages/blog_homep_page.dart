import "package:flutter/cupertino.dart";
import 'package:flutter/material.dart';

class BlogHomePage extends StatelessWidget {
  final List<String> categories = ['All', 'Technology', 'Lifestyle', 'Business'];

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
        title: Text('Blog App'),
        backgroundColor: Colors.blue,
        actions: [Icon(Icons.account_circle,size: 20,)],
      ),
      drawer: Drawer(),
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: 0,
        items: [
          BottomNavigationBarItem(icon: Icon(Icons.menu), label: ''),
          BottomNavigationBarItem(icon: Icon(Icons.circle_outlined), label: ''),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('Categories', style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
            SizedBox(height: 10),
            SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              child: Row(
                children: categories.map((cat) {
                  final isSelected = cat == 'All';
                  return Padding(
                    padding: const EdgeInsets.only(right: 10),
                    child: Chip(
                      label: Text(cat),
                      backgroundColor: isSelected ? Colors.blue : Colors.grey[200],
                      labelStyle: TextStyle(
                        color: isSelected ? Colors.white : Colors.black,
                      ),
                    ),
                  );
                }).toList(),
              ),
            ),
            SizedBox(height: 20),
            Expanded(
              child: ListView.builder(
                itemCount: blogPosts.length,
                itemBuilder: (context, index) {
                  final blog = blogPosts[index];
                  return Card(
                    margin: EdgeInsets.only(bottom: 16),
                    child: Padding(
                      padding: const EdgeInsets.all(20.0),
                      child: Row(
                        children: [
                          ClipRRect(
                            borderRadius: BorderRadius.circular(8),
                            child: Image.network(
                              blog['image']!,
                              width: 80,
                              height: 80,
                              fit: BoxFit.cover,
                            ),
                          ),
                          SizedBox(width: 12),
                          Expanded(
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(blog['title']!, style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
                                SizedBox(height: 4),
                                Text(blog['date']!, style: TextStyle(color: Colors.grey[600])),
                                SizedBox(height: 6),
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
            )
          ],
        ),
      ),
    );
  }
}