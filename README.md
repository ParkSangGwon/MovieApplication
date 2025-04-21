# Movie Application
이 코드는 [테드박의 안드로이드 앱 개발 : 확장성과 유지보수에 용이한 클린 아키텍처](https://bit.ly/ted-clean-architecture-blog) 강의에서 사용된 샘플 프로젝트입니다.
- Part 10. 샘플 프로젝트로 확인하는 클린 아키텍처

강의를 수강하시면서 이 프로젝트의 소스코드를 직접 살펴보시면 확실하게 이해가 되실겁니다.<br>
<br><br>

## 클린 아키텍처?
아키텍처를 몰라도 앱의 기능을 구현하는 것은 가능합니다.<br>
하지만 유지보수와 확장성을 고려한다면, 제대로 된 아키텍처를 적용할 수 있어야 합니다.
<br><br>
- **클린 아키텍처와 Google의 앱 아키텍처는 같은 아키텍처가 아닙니다.**
- 많은 안드로이드 개발자 분들이 앱 아키텍처를 클린 아키텍처로 잘못 알고 구현하고 계십니다.
- 클린 아키텍처로 만들어진 샘플 앱이 어떤 구조로 되어 있는지 명확하게 알려드리고자 이 샘플앱을 만들게 되었습니다.

[![Youtube 영상](https://img.youtube.com/vi/uR54RqjRflc/0.jpg)](https://www.youtube.com/watch?v=uR54RqjRflc)
<br><br>

## 스크린샷
|목록|상세|
|----| --- |
|<img src="screenshots/movie_list.png" width="200"/>| <img src="screenshots/movie_detail.png" width="200"/>| 


https://github.com/user-attachments/assets/e5f25ffb-e218-4e0b-b156-1be8fcd36873

<br><br>


## 아키텍처 구조
<img src="screenshots/architecture.jpeg" />

<br><br>
## 설정
### API KEY
이 영화 프로젝트 앱을 실행하기 위해서는 [TMDB API Key](https://developer.themoviedb.org/reference/intro/getting-started)를 발급받아서 설정해야 합니다.

<img width="700" alt="Image" src="https://github.com/user-attachments/assets/cb5c7c84-8cfc-4a1f-8725-2de19ce7a0be" />

> 주의 API 키가 아니라 API 읽기 엑세스 토큰을 사용해야 합니다.

- `local.properties` file에 발급받은 API Key를 입력해주세요
```properties
api_key=<발급받은 TMDB API KEY>
```
<br><br>
## TODO
이 샘플앱 프로젝트는 가장 기본의 클린 아키텍처 구조로 만들어서 구현되어 있습니다.<br>
여러분들이 클린 아키텍처 프로젝트를 더욱더 완벽한 모습이 될 수 있도록 함께 고민하고 작업하셔서 PR을 올려주세요.<br>
아래와 같은 개선이 이루어지길 기대하고 있습니다.<br>
- 각종 화면 추가
- 테스트 코드 추가
- Compose 변환
- UiState 사용
- 등등 개선이 필요하다고 생각되는 작업

<br><br>
## 클린 아키텍처 강의
이 프로젝트 코드를 살펴보시고 '클린 아키텍처'강의에 관심이 생기셨다면 지금 바로 강의를 수강해보세요.<br>
아래 쿠폰코드 입력하시면 2만원 할인된 가격으로 수강하실 수 있습니다.<br>
- 쿠폰코드: PRDTEA240919_b
- https://bit.ly/ted-clean-architecture-blog
