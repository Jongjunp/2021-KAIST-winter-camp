# 2021-KAIST-winter-camp week 1 - 박종준, 조민서

# 1. '무비로그'란 어떤 앱인가
 '무비로그'란 세 개의 탭으로 구성되어 감상한 영화의 리뷰를 블로그 형식으로 기록하고 이를 통해 나의 영화 취향을 알 수 있는 통계를 제공하는 앱이다.
 작성된 리뷰를 토대로 나의 영화 장르별 선호도를 파악하고 다음번 영화 관람시에 보다 도움이 되는 정보를 제공한다.
 
 # 2. 탭구성 소개
 ## Tab1: 연락처
 - json 파일로 저장된 연락처 목록을 탭화면에 불러옴 
 - 연락처 클릭 시, 통화 다이얼로 연결됨

|연락처 목록|연락처 다이얼 연결|
|:-:|:-:|
|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122426.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122452_Phone.jpg)|
 
 
 ## Tab2: 갤러리
 ---------------------------
 - 감상한 영화의 포스터를 평점, 제목과 함께 갤러리 형태로 보여준다. 
 - 화면에서 추가 버튼을 누르면 새로운 창으로 이동해 새로운 영화의 포스터와 제목, 리뷰, 장르 그리고 평점을 입력할 수 있다. 
 - 저장된 데이터는 메인 화면에서 보여지게 된다.
 - 갤러리의 사진 클릭 시, 해당 영화의 리뷰, 장르 그리고 평점을 수정하거나 해당 리뷰를 삭제할 수 있다.


|갤러리|새 항목 추가|항목 수정|
|:-:|:-:|:-:|
|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122500.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122508.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122519.jpg)|
 
## Tab3: 평점 정보
----------------------------
- 두번째 탭에서 등록한 영화의 장르별 평점 정보를 볼 수 있음
- 특정 장르 클릭 시, 해당 장르에 대해 사용자가 입력한 평점 정보를 파이 차트로 시각화함
- 장르별로 구체적인 평점 정보도 별도로 제공함



|장르 목록|평점 차트|
|:-:|:-:|
|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122529.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122540.jpg)|
