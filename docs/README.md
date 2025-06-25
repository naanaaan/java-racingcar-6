# 🚗 자동차 경주 게임 - 기능 정의서

---

## 입력 처리

### 🚘 자동차 이름 입력
- [ ] 쉼표(`,`)로 구분된 이름들을 입력받는다.
- [ ] 각 이름은 **1자 이상, 5자 이하**이어야 한다.
  - [ ] 빈 문자열 또는 공백일 경우 → `IllegalArgumentException`가 발생한다.
  - [ ] 5자 초과시 → `IllegalArgumentException`가 발생한다.
- [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 🔢 시도 횟수 입력
- [x] 경주 시도 횟수를 정수로 입력받는다.
  - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [x] 입력 값은 **1 이상의 정수**여야 한다.
  - [x] 0 이하 또는 숫자가 아닐 경우 → `IllegalArgumentException`가 발생한다.

---

##  게임 라운드 실행
- [ ] 사용자가 입력한 시도 횟수만큼 라운드를 반복한다.
- [ ] 매 라운드마다 각 자동차에 대해 이동 여부를 판단한다.
  - [x] 전진 조건이 '참'이면 전진한다.
  - [x] 무작위 값이 **4 이상**일 경우 자동차는 전진한다.
     - [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - [x] 전진 시 자동차의 위치는 `1` 증가한다.
  - [x] 그렇지 않으면 이동하지 않는다.
- [x] 최종 우승자를 구한다.
  - [x] 최대 거리와 동일한 자동차가 여러 명이면 **공동 우승자** 처리한다.

---

##  출력 처리

### 📍 라운드 결과 출력
- [ ] 자동차 이름과 이동 거리(`-`)를 함께 출력한다.
  - [ ] 출력 형식: `이름 : ---`
  - [ ] 각 자동차 정보는 한 줄에 하나씩 출력한다.

### 🏁 최종 우승자 출력
- [ ] 경주 종료 후 우승자를 출력한다.
  - [ ] 공동 우승자가 있을 경우 쉼표(`,`)로 구분하여 출력한다.
  - [ ] 출력 형식
  - 단독: `최종 우승자 : pobi`
  - 공동: `최종 우승자 : pobi, jun`

---

## 📁 클래스 설계
	
```
src/
├── main/java/racingcar/
│   ├── Application.java            
│   ├── controller/
│   │   └── RaceGameController.java  
│   ├── domain/
│   │   ├── Car.java                 
│   │   ├── Race.java             
│   │   ├── MoveStrategy.java       
│   │   └── RandomMoveStrategy.java   
│   └── view/
│       ├── InputView.java           
│       └── OutputView.java           


```

---
