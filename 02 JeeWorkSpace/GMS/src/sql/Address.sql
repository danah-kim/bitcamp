-- TAB : address
-- addr_seq (DECIMAL, PRIMARY KEY)
-- zipcode
-- province 경기도
-- city 서울시, 안양시
-- gugun 강남구, 가평군
-- doro 백범로 15길


-- 전체 테이블 조회
SELECT * FROM TAB;

-- 테이블 삭제
DROP TABLE address;

-- 전체 시퀀스 조회
SELECT * FROM user_sequences;

-- 시퀀스 생성
CREATE SEQUENCE addr_seq START WITH 1000;

-- 시퀀스 삭제
DROP SEQUENCE addr_seq;


-- 데이터베이스 테이블 생성
CREATE TABLE address(
	addr_seq DECIMAL PRIMARY KEY,
	zip_code VARCHAR2(20),
	province VARCHAR2(20),
	city VARCHAR2(20),
	gugun VARCHAR2(20),
	doro VARCHAR2(20)
);

-- 데이터베이스 객체 생성
INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '123456', '', '서울시', '강남구', '백범로 15길'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '212121', '', '인천시', '남동구', '구월말로 4번길'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '111111', '경기도', '안양시', '가평구', '가양로 12길'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '456453', '충청남도', '천안시', '서북구', '샛별5길'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '981275', '경상남도', '진해시', '도림동', '벚꽃로 67길'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '787632', '강원도', '춘천시', '도화동', '소양댐길 17길 4'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '369724', '경기도', '부천시', '역곡동', '부천대로 87'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '878832', '전라북도', '전주시', '개화동', '이순신대로 2'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '465433', '', '제주시', '애월읍', '제주해안로 2'
);

INSERT INTO address
(
	addr_seq, zip_code, province, city, gugun, doro
)
VALUES
(
	addr_seq.nextval, '827362', '', '부산시', '해운동', '해운대로 99길'
);

-- 데이타베이스 객체 조회
SELECT * FROM address;

