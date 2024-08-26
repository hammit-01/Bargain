# Bargain
### 안드로이드 어플리케이션 Bargain 


## 대진대학교 컴퓨터공학과 졸업 프로젝트
- **20212143 김채희**
- **김민형**
- **20201495 김혜미**


[노션 사이트](https://www.notion.so/e987a059f26149d2847a41562b74916f)
[Github 로그 및 변경사항](https://www.notion.so/Github-Log-c3f8b059da804e0b9e21bea5ef6449e0)
[Todo](https://www.notion.so/7a67f6c6d20d4ce8a790990bc612f08e?v=e0e5730b84624b8dae3cfc84be455223)
2024.07.29 11:12 AM Upload by 김혜미

! 프로젝트 생성 전 미리 안드로이드 스튜디오 세팅을 마쳐주세요

! 프로젝트 생성 이름은 Auction(대소문자구분)으로 지정해주세요

! 프로젝트 생성 시 처음 나타나는 레이아웃은 Empty Activity로 지정해주세요

! API 레벨은 API 34입니다

build.gradle.kts 파일: 안드로이드 스튜디오 왼쪽 하단 Gradle Scripts의 build.gradle.kts(Module :app)에 복사

auction 파일: 다운로드 후 파일 속 7개의 항목들을 안드로이드 스튜디오 왼쪽 상단 app > java > com.example.auction에 복사

res 파일: 다운로드 후 res 속 모든 파일을 안드로이드 스튜디오의 res 파일에 복사

AndroidManifest 파일: 다운로드 후 안드로이드스튜디오의 app > manifests 파일에 복사

----------------------------------------------------------------------------------------------------------------

2024.08.06 2:06 AM Upload by 김채희
### master branch에 가서 다운 받아주세요 ###
Version History

로그인 페이지 구현해놨습니다

1.AndroidManifest 파일에 LoginActiviy 추가

2.LoginActivy.kt 코드 추가

3.login_page.xml 코드 추가

4.colors.xml 색상 추가

5.bottom_nav_menu.xml에 임시로 마이 추가, 누르면 로그인페이지로 이동 (다음에 편집 예정)

6.MainActivity.kt 에 my 메뉴 추가

! auction 파일, res파일, androidManifest 파일 다운로드 후 각 폴더, 파일에 복사

----------------------------------------------------------------------------------------------------------------

2024.08.07 01:38 AM Upload by 김혜미

Version History

- main branch에 프로젝트 전체 파일 업로드 했습니다

1. 메인 홈 - MainActivity.kt 구현

2. 상단, 하단 네비게이션 바 수정 및 추가 - DetailMenuBottom.kt, detail_menu_bottom.xml, top_navigation.xml, top_navigation_ver2.xml, bottom_nav_menu.xml, top_nav_menu.xml, top_nav_menu_ver2.xml

3. 테마 수정 - theme.xml

4. 각종 아이콘 추가

5. 어댑터 추가 - HorizontalAdapter.kt, PosterAdapter.kt

### main branch의 파일들을 압축파일로 다운로드 후 그대로 프로젝트 실행하시면 됩니다.
#### 프로젝트 실행이 안된다면 .gradle 파일을 다운받아 붙여넣으면 됩니다.
#### 이후에 발생할 수 있는 문제 중 안드로이드 스튜디오에 에뮬레이터 앱이 안뜰 수 있는데 이때 상단의 file - invalidate cache ... - 세가지 옵션 선택 하지 않고 그대로 파란 버튼 클릭 하면 작동 되실겁니다.
#### .gradle 파일은 추후에 올려놓겠습니다.

----------------------------------------------------------------------------------------------------------------

2024.08.26 21:25 PM Upload By 김혜미

- 민형님이 올려주신 파일 develop-branch-h에 적용 후 수정했습니다. (main Branch는 건들이지 않았습니다.)
- 전반적인 틀이 완성되면 main에 merge하도록 하겠습니다.

! 앞으로의 프로젝트 변경사항은 main branch는 업데이트하지 마시고 각자의 branch에 업데이트 해주시길 바랍니다.
(혹시 모를 상황을 대비한 원본파일 유지를 위함입니다.)
! 각자의 branch 업데이트 시에도 branch Readme에 수정사항 적어주세요.
! Github Log는 노션 페이지에 기록할 예정입니다. 노션의 Todo 페이지도 확인 바랍니다.