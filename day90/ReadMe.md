오후 1:34 2023-09-18

오늘 연결
예제 설명
	-80 ~100
	: 회원 테이블 + 게시판 테이블
	: 각 테이블당 CR(one OR ALL) 기본
	: RUD 추가할때마다 추가 점수
	: 모든 유효성은 null 체크만! 
	60 ~ 79
	: 회원 테이블
	

예제 프로젝트 제작
내일 시연
내일 간단한 풀이

오라클 유료라 오류
빌드패스 하던지 직접 자르 넣던지


회원
회원가입
로그인
비밀번호 변경
회원탈퇴

보드
글 작성
글 수정
글 전체 출력
글 삭제


메인
회원가입 / 로그인
글목록

보드
글 수정 삭제

마이페이지
회원정보 수정 / 탈퇴

CREATE TABLE MEMBER(
	MID VARCHAR(15) PRIMARY KEY,
	MPW VARCHAR(15) NOT NULL
);

CREATE TABLE BOARD(
	BID INT PRIMARY KEY AUTO_INCREMENT,
	MID VARCHAR(15),
	CONTENT VARCHAR(200) NOT NULL
);

INSERT INTO MEMBER (MID, MPW) VALUES('admin','1234');

INSERT INTO BOARD (MID, CONTENT) VALUES('admin','관리자 공지');




