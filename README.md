# ModooCoin

실제 코인 가격 _(Upbit 기준)_ 이 반영되는 코인 모의 투자 서비스입니다.
Long, Short 포지션 모두 취할 수 있기에 현물, 선물 트레이딩 모두 모의 투자가 가능합니다.

```
  __  __           _                ____      _         _ _
|  \/  | ___   __| | ___   ___    / ___|___ (_)_ __   | | |
| |\/| |/ _ \ / _` |/ _ \ / _ \  | |   / _ \| | '_ \  | | |
| |  | | (_) | (_| | (_) | (_) | | |__| (_) | | | | | |_|_|
|_|  |_|\___/ \__, _|\___/ \___/   \____\___/|_|_| |_| (_|_)
```

## 주요 기능

- 트레이딩
    - Long: 선택한 코인의 롱 포지션 진입
    - Short: 선택한 코인의 숏 포지션 진입
    - Clear: 보유 포지션 청산
- 사용자 정보
    - Info: 사용자 이름 / 실현손익 / 자본금 확인
    - Position: 현재 포지션 확인
    - History: 트레이딩 거래 기록 확인
    - DeleteHistory: 트레이딩 거래 기록 지우기
    - DeleteAccount: 현재 사용자 정보 지우기

## 실행 방법

1. 해당 Repository의 main branch clone
2. /server/Main.java 실행
    - Upbit WebSocket 연결
3. /display/DisplayClient.java 실행
    - 실시간 코인별 Upbit 가격 정보 출력
4. /client/UpbitClient.java 실행
    - 서비스 Client
5. UpbitClient CLI 조작

## 시연 이미지

### 트레이딩

### 실시간 코인 가격 정보

![Image](https://github.com/user-attachments/assets/287a4320-999e-4d4d-b876-89fb94c08a2b)

### 거래 History 확인

![Image](https://github.com/user-attachments/assets/ed4028c6-b349-458f-bde1-5d726c684692)

### 현재 보유 포지션 확인