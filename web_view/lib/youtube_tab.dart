import 'package:flutter/cupertino.dart';
import 'package:webview_flutter/webview_flutter.dart';

class YouTubeTab {
  String url;
  WebViewController? controller;

  YouTubeTab({required this.url, this.controller});
}

class YouTubeTabsModel with ChangeNotifier {
  List<YouTubeTab> tabs = List.generate(20, (index) => YouTubeTab(url: ''));
  int _currentIndex = 0;

  int get currentIndex => _currentIndex;

  void setCurrentIndex(int index) {
    _currentIndex = index;
    notifyListeners();
  }

  void updateUrl(int index, String url) {
    // Ensure URL is in correct format
    String formattedUrl = url;
    if (!url.startsWith('http')) {
      formattedUrl = 'https://$url';
    }
    if (!url.contains('youtube.com') && !url.contains('youtu.be')) {
      formattedUrl = 'https://youtube.com';
    }

    tabs[index].url = formattedUrl;
    notifyListeners();
  }

  void reloadTab(int index) {
    if (tabs[index].controller != null) {
      tabs[index].controller!.reload();
    }
  }
}