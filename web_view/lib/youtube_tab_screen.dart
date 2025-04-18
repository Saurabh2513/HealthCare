import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';
import 'package:web_view/youtube_tab.dart';
import 'package:webview_flutter/webview_flutter.dart';

import 'main.dart';

class YouTubeTabsScreen extends StatefulWidget {
  const YouTubeTabsScreen({super.key});

  @override
  State<YouTubeTabsScreen> createState() => _YouTubeTabsScreenState();
}

class _YouTubeTabsScreenState extends State<YouTubeTabsScreen> {
  @override
  Widget build(BuildContext context) {
    final model = Provider.of<YouTubeTabsModel>(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text('YouTube 20-Tab Viewer'),
        actions: [
          IconButton(
            icon: const Icon(Icons.refresh),
            onPressed: () => model.reloadTab(model.currentIndex),
          ),
        ],
      ),
      body: Column(
        children: [
          // URL Input Field
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              decoration: InputDecoration(
                labelText: 'Enter YouTube URL for Tab ${model.currentIndex + 1}',
                border: const OutlineInputBorder(),
                suffixIcon: IconButton(
                  icon: const Icon(Icons.paste),
                  onPressed: () async {
                    final clipboardData = await Clipboard.getData('text/plain');
                    if (clipboardData != null && clipboardData.text != null) {
                      model.updateUrl(model.currentIndex, clipboardData.text!);
                    }
                  },
                ),
              ),
              onSubmitted: (value) {
                model.updateUrl(model.currentIndex, value);
              },
            ),
          ),

          // Tab Bar
          SizedBox(
            height: 50,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: 20,
              itemBuilder: (context, index) {
                return GestureDetector(
                  onTap: () => model.setCurrentIndex(index),
                  child: Container(
                    width: 40,
                    margin: const EdgeInsets.all(4),
                    decoration: BoxDecoration(
                      color: model.currentIndex == index
                          ? Colors.red
                          : Colors.grey,
                      borderRadius: BorderRadius.circular(8),
                    ),
                    child: Center(
                      child: Text(
                        '${index + 1}',
                        style: TextStyle(
                          color: model.currentIndex == index
                              ? Colors.white
                              : Colors.black,
                        ),
                      ),
                    ),
                  ),
                );
              },
            ),
          ),

          // WebView
          Expanded(
            child: WebView(
              initialUrl: model.tabs[model.currentIndex].url.isEmpty
                  ? 'https://youtube.com'
                  : model.tabs[model.currentIndex].url,
              javascriptMode: JavascriptMode.unrestricted,
              onWebViewCreated: (controller) {
                model.tabs[model.currentIndex].controller = controller;
              },
            ),
          ),
        ],
      ),
    );
  }
}