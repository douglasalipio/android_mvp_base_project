#Code challange interview
==================================

### FakeMarket App <br/>

<img src ="https://github.com/douglasalipio/base_android_project/blob/interview/app/main_screen.png"  width="360"/>&nbsp;&nbsp;
<img src ="https://github.com/douglasalipio/base_android_project/blob/interview/app/detail_screen.png" width="360" />&nbsp;&nbsp;

### Requirements achieved

Fetching all required data from the folowing API endpoints:

- GET https://my-json-server.typicode.com/ocadotechnology/mobile-challenge/products
- GET https://my-json-server.typicode.com/ocadotechnology/mobile-challenge/product?product_id=91500011

Extras

- Products view
- Allow Rotation
- Product detail view
- Unit tests
- Language (Kotlin)

### Relevant 3rd party libraries

- Retrofit2
- RxJava
- Dagger2
- Groupie
- Gson
- Espresso
- Mockito
- Junit4 
- Glid 
- Afollestad 

### Architecture

The MPV design pattern has been implemented to make views reusable and to isolate business rules from the Presenter layer, which makes it easier to test.
The application is divided into three layers, namely View, Presenter, and Data. In addition, there is an interactor responsible to fetch products and their info.

### Installation

- Android Studio 3.5
- Gradle 5.4.1

