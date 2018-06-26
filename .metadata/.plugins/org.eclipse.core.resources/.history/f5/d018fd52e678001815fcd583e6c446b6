--userid, password, name, ssn, regidate, phone, email, profile, access_num, credit_rating, addr_seq, account_seq


-- 전체 테이블 조회
SELECT * FROM TAB;

-- 테이블 삭제
DROP TABLE member;

-- 데이터베이스 테이블 생성
CREATE TABLE member(
	userid VARCHAR2(20) PRIMARY KEY,
	password VARCHAR2(20),
	name VARCHAR2(20),
	ssn VARCHAR2(8),
	regidate DATE,
	phone VARCHAR2(13),
	email VARCHAR2(20),
	profile VARCHAR2(20),
	access_num VARCHAR2(8),
	credit_rating DECIMAL,
	addr_seq DECIMAL,
	account_seq DECIMAL
);


-- 데이터베이스 객체 생성
INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'kim', '1523', '김유신', '900101-1', SYSDATE, '010-1234-1234',
	'kim@test.com', 'kim.jpg', '', 5, 1020, 1009
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'lee', '1', '이순신', '890301-1', SYSDATE, '010-1234-4444',
	'lee@test.com', 'lee.jpg', '', 5, 1021, 1008
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'kang', '1234', '강형욱', '870112-1', SYSDATE, '010-9912-3842',
	'kang@test.com', 'kang.jpg', '', 5, 1022, 1007
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'hong', '1348', '홍길동', '980130-1', SYSDATE, '010-3434-8482',
	'hong@test.com', 'hong.jpg', '', 5, 1023, 1006
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'park', '0284', '박보검', '890524-1', SYSDATE, '010-2587-4421',
	'park@test.com', 'park.jpg', '', 5, 1024, 1005
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'joe', '111', '조성모', '670923-1', SYSDATE, '010-9876-1004',
	'joe@test.com', 'joe.jpg', '', 5, 1025, 1004
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'back', '1283', '백범', '250601-1', SYSDATE, '010-0202-3847',
	'back@test.com', 'back.jpg', '', 5, 1026, 1003
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'jeong', '1983', '정해인', '870701-1', SYSDATE, '010-1234-8743',
	'jeong@test.com', 'jeong.jpg', '', 5, 1028, 1002
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'han', '1092', '한지민', '850319-2', SYSDATE, '010-4421-9876',
	'han@test.com', 'han.jpg', '', 5, 1029, 1001
);

INSERT INTO member
(
	userid, password, name, ssn, regidate, phone, 
	email, profile, access_num, credit_rating, addr_seq, account_seq
) 

VALUES
(
	'jang', '1919', '장나라', '880114-2', SYSDATE, '010-1919-1323',
	'jang@test.com', 'jang.jpg', '', 5, 1030, 1000
);

-- 데이타베이스 객체 조회
SELECT * FROM member;

-- JOIN
SELECT * FROM member, account
WHERE member.account_seq = account.account_seq
AND member.userid = 'kim'
;
