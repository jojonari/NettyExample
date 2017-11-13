# 자바 네트워크 소녀 Netty

> * book : http://www.hanbit.co.kr/store/books/look.php?p_code=B2683487348
> * github : https://github.com/krisjey/netty.book.kor

실습예졔

* 1장
	- 톰캣이 아닌 java appication으로 실행해야한다.
	- 네티는 이벤트를 인바운드이벤트와 아웃바운드 이벤트로 구분한 추상화 모델을 제공한다.
	* 에코서버 : 간단하게 클라이언트가 요청을 보내면 적당한 응답을 보내주는 서버

* 2장
	- 동기와 비동기의 정의
		* sync(동기) / Async(비동기)
		* 동기적 처리 : 순차적으로 일을 스스로 끝내 나가는 방식
		* 비동기적 처리 : 해야 할 일을 위임하고 기다리는 방식
	- 블로킹과 논블로킹 소켓
		* 블러킹 : 함수를 호출하고, 그 결과가 나올때까지 함수를 반환하지 않는다는 뜻이다.
		* 넌블러킹 : 블러킹과 반대로 결과가 나올 때까지 기다리지 않고(블러킹 되지 않고) 함수를 바로 반환된다.	
	- 이벤트 기반 프로그래밍
		* 사건 기반 프로그래밍(영어: Event-driven programming; EDP)은 비주얼 베이직과 같이, 사용자의 명령·마우스 클릭·다른 프로그램의 메시지·키보드 글쇠 입력 등의 ‘사건’에 따라, 제어 흐름이 결정되어 일을 하도록 하게끔 만들어진 프로그래밍 언어 방식을 뜻한다.

* 3장 
	- 부트스트랩의 논리적 구조
		* 전송계층(소켓 모드 및 I/O 종류)
		* 이벤트 루프(단일 스레드, 다중 스레드)
		* 채널 파이프라인 설정
		* 소켓 주소와 포트
		* 소켓 옵션
	- TCP와 SCTP
		* TCP  : 3 way handshake(SYN-ACK 구조)
		* SCTP : 4 way handshake(INIT-ACK, COOKIE-ECHO 구조)를 사용, 연결 정보에 쿠키를 삽입하여 DoS와 같은 네트워크 공격을 보호, 반닫힘 상태를 지원하지 않음

* 4장
	- 파이프라인 : 이벤트 전달
	- 이벤트 핸들러 : 이벤트 처리
	- 코덱 : 이벤트 핸들러 구현체
	- 네티 내부에서는 모든 데이터가 ByteBuf로 관리된다.
	- 인바운드 이벤트 발생 순서	
		1. 이벤트 루프에 채널 등록(channelRegistered)
		2. 채널 활성화(channelActive)
		3. 데이터 수신(channelRead)
		4. 데이터 수신 완료(channelReadComplete)
		5. 채널 비활성화(channellnactive)
		6. 이벤트 루프에서 채널 제거(channelUnregistered)
			