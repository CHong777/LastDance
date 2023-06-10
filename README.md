프로젝트 VM 한글 깨짐  해결방법 (1번 2번 중 되는 방법으로 진행)
1. Help > Edit Custom VM OPtions > encoding 설정 2개 추가
- -Dfile.encoding=UTF-8
- -Dconsole.encoding=UTF-8
  <img src="/src/main/resources/img/vm1.png"  width="700" height="370">
  <img src="/src/main/resources/img/vm2.png"  width="700" height="370">

2. File -> Settings
- (1). Gradle 검색
- Build and run using : IntelliJ IDEA
- Run tests using : IntelliJ IDEA 변경
  <img src="/src/main/resources/img/gradleSettings1.png"  width="700" height="370">
- (2). encoding 검색 후, Editor -> File Encodings 클릭
- Global Encoding : UTF-8
- Project Encoding : UTF-8
  <img src="/src/main/resources/img/fileencoding.png"  width="700" height="370">