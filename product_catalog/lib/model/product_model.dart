class Product {
  final int id;
  final String title;
  final String description;
  final double price;
  final double discountPercentage;
  final double rating;
  final int stock;
  final String? brand;
  final String? category;
  final String? thumbnail;
  final List<String> images;
  final String? sku;
  final double? weight;
  final Dimensions? dimensions;
  final String? warrantyInformation;
  final String? shippingInformation;
  final String? returnPolicy;

  Product({
    required this.id,
    required this.title,
    required this.description,
    required this.price,
    required this.discountPercentage,
    required this.rating,
    required this.stock,
    this.brand,
    this.category,
    this.thumbnail,
    required this.images,
    this.sku,
    this.weight,
    this.dimensions,
    this.warrantyInformation,
    this.shippingInformation,
    this.returnPolicy,
  });

  factory Product.fromJson(Map<String, dynamic> json) {
    return Product(
      id: json['id'],
      title: json['title'] ?? '',
      description: json['description'] ?? '',
      price: (json['price'] ?? 0).toDouble(),
      discountPercentage: (json['discountPercentage'] ?? 0).toDouble(),
      rating: (json['rating'] ?? 0).toDouble(),
      stock: json['stock'] ?? 0,
      brand: json['brand'],
      category: json['category'],
      thumbnail: json['thumbnail'],
      images: List<String>.from(json['images'] ?? []),
      sku: json['sku'],
      weight:
      (json['weight'] != null) ? (json['weight'] as num).toDouble() : null,
      dimensions:
      json['dimensions'] != null
          ? Dimensions.fromJson(json['dimensions'])
          : null,
      warrantyInformation: json['warrantyInformation'],
      shippingInformation: json['shippingInformation'],
      returnPolicy: json['returnPolicy'],
    );
  }


  double get originalPrice {
    if (discountPercentage == 0) return price;
    return price / (1 - discountPercentage / 100);
  }
}

class Dimensions {
  final double width;
  final double height;
  final double depth;

  Dimensions({required this.width, required this.height, required this.depth});

  factory Dimensions.fromJson(Map<String, dynamic> json) {
    return Dimensions(
      width: (json['width'] ?? 0).toDouble(),
      height: (json['height'] ?? 0).toDouble(),
      depth: (json['depth'] ?? 0).toDouble(),
    );
  }

  @override
  String toString() => '$width" x $height" x $depth"';
}
class Review {
  final String reviewerName;
  final int rating;
  final String comment;
  final DateTime date;

  Review({
    required this.reviewerName,
    required this.rating,
    required this.comment,
    required this.date,
  });
  factory Review.fromJson(Map<String, dynamic> json) {
    return Review(
      reviewerName: json['reviewerName'],
      rating: json['rating'] ?? 0,
      comment: json['comment'] ?? '',
      date: DateTime.now(),
    );
  }

}