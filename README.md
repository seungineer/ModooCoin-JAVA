# ModooCoin

실제 코인 가격 _(Upbit 기준)_ 이 반영되는 코인 모의 투자 서비스입니다.
Long, Short 포지션 모두 취할 수 있기에 현물, 선물 트레이딩 모두 모의 투자가 가능합니다.

```
  __  __           _                ____      _         _ _
|  \/  | ___   __| | ___   ___    / ___|___ (_)_ __   | | |
| |\/| |/ _ \ / _` |/ _ \ / _ \  | |   / _ \| | '_ \  | | |
| |  | | (_) | (_| | (_) | (_) | | |__| (_) | | | | | |_|_|
|_|  |_|\___/ \__, _|\___/ \___/  \____\___/|_|_| |_| (_|_)
```

## 주요 기능

- 트레이딩
    - Long: 선택한 코인의 롱 포지션 진입
    - Short: 선택한 코인의 숏 포지션 진입
    - 청산 하기: 보유 포지션 청산
- 사용자 정보
    - 내 정보: 사용자 이름 / 잔고 확인 / 수익 확인
        - 계정 삭제: 현재 사용자 정보 지우기
    - 내 포지션: 현재 보유 포지션 확인
    - 거래 기록: 트레이딩 거래 기록 확인

## 실행 방법

1. 해당 Repository의 main branch clone
2. `src/server/Main.java` 실행
    - Upbit WebSocket 연결
3. `/display/DisplayClient.java` 실행
    - 실시간 코인별 Upbit 가격 정보 출력
4. `/client/UpbitClient.java` 실행
    - 서비스 Client
5. UpbitClient CLI 조작

## 시연 영상

![Image](https://github.com/user-attachments/assets/08506c5d-e847-4516-9004-32c13389b9c3)

> `Long` → Long 포지션 진입(BTC, 3개) → `내 포지션` → `청산하기` → 해당 포지션 청산 → `내 포지션`

### 메인 메뉴

<img width="412" alt="Image" src="https://github.com/user-attachments/assets/5e630fc2-25f9-4fbe-a007-e62caf4951a7" />

- `Long` | `Short` | `청산하기` | `내 포지션` | `내 정보` | `거래 기록` | `종료하기`

### 트레이딩

<img width="575" alt="Image" src="https://github.com/user-attachments/assets/57b92582-ebd6-456f-b1c7-56a24aeb413e" />

### 실시간 코인 가격 정보

![Image](https://github.com/user-attachments/assets/287a4320-999e-4d4d-b876-89fb94c08a2b)

### 거래 History 확인

<img width="826" alt="image" src="https://github.com/user-attachments/assets/09dc2e50-5e13-43ea-b6ed-8ce22cc60788" />

### 현재 보유 포지션 확인

<img width="831" alt="image" src="https://github.com/user-attachments/assets/86704994-28fd-49bf-a364-329d60001f2e" />
