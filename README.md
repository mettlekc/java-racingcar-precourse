# 자동차 경주 게임
## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇번의 이동을 할 것인지 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지 알려준다. 우승자는 한 명 이상일 수 있다.

## 설계
![racingcar design](https://github.com/mettlekc/woocamp-resources/blob/main/woocamp-racingcar-precourse-design.png)

## 기능 목록
* 자동차 생성
* 차량 이동 조건
  * random 처리
  * 전진, 멈춤 상태
* 차량 이동
* 횟수 관리
  * 횟수 입력
  * 횟수 차감
* 레이싱 결과
  * 우승자 선정 (중복 가능)

## 용어
* Car : 레이싱 참가 차량
* Round : 레이싱 시도 회수
* Rank : 레이싱 결과 관리(Winner 리스트 관리) 
  
## Error Code
* MAX_ROUND_COUNT_EXCEEDED : 라운드 시도 회수 미만인 경우
* NO_LEFT_ROUND : 더 이상 남은 라운드가 없는 경우
* CAR_NAME_LENGTH_EXCEEDED : 자동차 이름 길이 초과
* CAR_NAME_EMPTY : 자동차 이름이 비어 있는 경우
* EMPTY_CAR : 자동차 입력이 없은 경우
* CANNOT_CREATE_THIS_INSTANCE : 객체 생성이 불가능한 경우

## Exception
* CarNameEmptyStringException : 비어 있는 자동차 이름
* CarNameOutOfLengthException : 자동차 이름 길이 제한 초과
* EmptyCarException : 차가 비어 있을 경우
* RoundOutOfBoundsException : 제한 회수 미만인 경우

## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

