-- 전체 테이블 조회
SELECT * FROM TAB;

-- 테이블 삭제
DROP TABLE account;

-- 시퀀스 생성
CREATE SEQUENCE account_seq START WITH 1000;

-- 테이블 생성
CREATE TABLE account(
	account_seq DECIMAL PRIMARY KEY,
	money DECIMAL,
	account_num VARCHAR2(20),
	account_type VARCHAR2(20),
	create_date DATE,
	limit DECIMAL
);

-- 데이타베이스 객체 생성
INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES(
	account_seq.nextval, 0, '123-456-111', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 1000, '123-456-999', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 5000000, '123-456-234', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 100, '123-432-943', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 45000, '123-996-342', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 10000002, '123-456-555', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 64375000, '123-765-377', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 11235000, '943-456-555', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 546000, '123-717-342', '일반통장', SYSDATE, 0
);

INSERT INTO account
(
	account_seq, money, account_num, account_type, create_date, limit
)
VALUES
(
	account_seq.nextval, 5000000, '193-456-662', '일반통장', SYSDATE, 0
);

-- 데이타베이스 객체 조회
SELECT * FROM account;


-- JOIN
SELECT userid, name, account_num, city
FROM member m, account ac, address ad
WHERE m.account_seq = ac.account_seq
AND m.addr_seq = ad.addr_seq
AND m.userid = 'kim'
;

