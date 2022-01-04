# 2021-KAIST-winter-camp week 1

# 1. '무비로그'란 어떤 앱인가
 '무비로그'란 세 개의 탭으로 구성되어 감상한 영화의 리뷰를 블로그 형식으로 기록하고 이를 통해 나의 영화 취향을 알 수 있는 통계를 제공하는 앱입니다. 작성된 리뷰를 토대로 나의 영화 장르별 선호도를 파악하고 다음번 영화 관람시에 보다 도움이 되는 정보를 제공합니다.



앱 사용 글씨체: [엘리스 디지털 배움체](https://font.elice.io/)
|앱 아이콘 - Designed by 박종준(Jongjunp)|
|:-:|
|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshot_20220104-140801_One%20UI%20Home1.jpg)|



|앱 시작 Splash - Animation From [LottieFiles](https://lottiefiles.com/34441-movie-clapboard)|
|:-:|
|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshot_20220104-163726.jpg)|


 
# 2. 앱 소개
 > ## Tab1: 연락처
   - JSON 파일로 저장된 연락처 목록을 탭 화면에 불러오는 탭입니다. 
     
     
     
     목록은 RecyclerView를 활용하여 구현하였고, 각 아이템은 CardView로 구현하여 이름과 연락처 정보가 표시됩니다. 특정 연락처 클릭 시, 기기의 기본 통화 다이얼로 연결됩니다. 

   |연락처 목록|연락처 다이얼 연결|
   |:-:|:-:|
   |![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshot_20220104-162235.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122452_Phone.jpg)|
 
  ---------------------------
 > ## Tab2: 갤러리
  - 감상한 영화의 포스터를 평점, 제목과 함께 갤러리 형태로 보여주는 탭입니다.
  
  
  
    갤러리 탭은 RecyclerView로 list를 구현했고, 각 아이템은 영화 포스터, 제목, 그리고 별점을 LinearLayout으로 구성했습니다. 화면에서 FloatingButton으로 구현된 추가 버튼을 누르면 새로운 Activity로 이동해 영화의 포스터와 제목, 리뷰, 장르 그리고 평점을 입력할 수 있습니다. 입력한 데이터는 SharedPreference를 이용하여 내부 저장소에 저장될 수 있도록 했습니다. 저장된 데이터는 메인 갤러리 화면에서 보여지게 됩니다. 갤러리의 사진 클릭 시, 해당 영화의 리뷰, 장르 그리고 평점을 수정하거나 해당 리뷰를 삭제할 수 있는 기능을 구현했습니다.


   |갤러리|새 항목 추가|항목 수정|
   |:-:|:-:|:-:|
   |![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122500.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122508.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122519.jpg)|
----------------------------
>## Tab3: 평점 정보
 - 내가 등록한 영화의 장르별 평점 정보를 볼 수 있는 탭입니다.
 
 
 
   Chart 탭은 RecyclerView를 이용하여 영화 장르 리스트를 구현했습니다. 특정 장르 클릭 시, 새로운 Activity로 연결되어 해당 장르에 대해 사용자가 입력한 평점 정보를 파이 차트로 시각화한 화면을 볼 수 있습니다. 파이 차트는 'MPandroidchart' (https://github.com/PhilJay/MPAndroidChart) 라는 오픈소스를 활용하여 구현했습니다. Tab2에서 내부 저장소에 저장된 장르와 평점 정보를 차트 데이터로 활용했습니다. 차트에서는 별점 분포를 퍼센트 형태로 보여주고 그 아래에 list의 형태로 장르별로 구체적인 평점 정보도 제공합니다.



  |장르 목록|평점 차트|
  |:-:|:-:|
  |![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshot_20220104-162244.jpg)|![](https://github.com/Jongjunp/2021-KAIST-winter-camp/blob/main/Camera%20Roll/Screenshots/Screenshot_20220104-122540.jpg)|
----------------------------- 
# Credit
- 박종준 / [Jongjunp](https://github.com/Jongjunp)
- 조민서 / [jjminsuh](https://github.com/jjminsuh)
