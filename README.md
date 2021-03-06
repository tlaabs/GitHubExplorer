# GitHubExplorer
깃허브 사용자 정보와 리포지토리를 검색하는 안드로이드 앱입니다.

<img src = "https://user-images.githubusercontent.com/8165219/88750312-2b4a3200-d190-11ea-92a7-0fb2bc3995e4.gif" width="300px">

## Feature
- 검색필드 500ms 안에 변화가 없으면 검색
- 무한 스크롤 페이징
- 멀티 섹션
- 검색 필터

## Tech & Library
- Kotlin
- JetPack
  - LiveData
  - Lifecycle
  - ViewModel
- Architecture
  - MVVM
- [Baserecyclerviewadapter](https://github.com/skydoves/BaseRecyclerViewAdapter) : Multi-sectioned RecyclerView
- [Koin](https://github.com/InsertKoinIO/koin) : dependency injection
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) : REST API networking
- [Glide](https://github.com/bumptech/glide) : Image loading framework
- [RxJava2 & RxAndroid2](https://github.com/ReactiveX/RxJava) : For asynchronous
