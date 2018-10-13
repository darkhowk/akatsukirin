CREATE TABLE 
	MENU (
		  SEQ VARCHAR2(200) PRIMARY KEY
		, MENUNAME VARCHAR2(100) NOT NULL
		, MENULEVEL NUMBER(1) NOT NULL 
		, MENUCATEGORY VARCHAR2(100) NOT NULL
		, MENULINK VARCHAR2(100)
		, MENUAUTH CHAR(1) NOT NULL
		, USEYN CHAR(1) NOT NULL
		, CREATEDATE TIMESTAMP NOT NULL
		, CREATEUSER VARCHAR2(100) NOT NULL
		, UPDATEDATE TIMESTAMP NOT NULL
		, UPDATEUSER VARCHAR2(100) NOT NULL
		)
;

INSERT INTO 
	MENU (
		  SEQ
		, MENUNAME
		, MENULEVEL
		, MENUCATEGORY
		, MENULINK
		, MENUAUTH
		, USEYN
		, CREATEDATE
		, CREATEUSER
		, UPDATEDATE
		, UPDATEUSER
		) VALUES (
		  '1'
		, '包府磊 汲沥'
		, '0'
		, 'Admin Setting'
		, ''
		, '0'
		, 'Y'
		, SYSDATE
		, 'darkhowk'
		, SYSDATE
		, 'darkhowk'
		)
;

INSERT INTO 
	MENU (
		  SEQ
		, MENUNAME
		, MENULEVEL
		, MENUCATEGORY
		, MENULINK
		, MENUAUTH
		, USEYN
		, CREATEDATE
		, CREATEUSER
		, UPDATEDATE
		, UPDATEUSER
		) VALUES (
		  '1'
		, '皋春包府'
		, '1'
		, 'Admin Setting'
		, ''
		, '0'
		, 'Y'
		, SYSDATE
		, 'darkhowk'
		, SYSDATE
		, 'darkhowk'
		)
;

INSERT INTO 
	MENU (
		  SEQ
		, MENUNAME
		, MENULEVEL
		, MENUCATEGORY
		, MENULINK
		, MENUAUTH
		, USEYN
		, CREATEDATE
		, CREATEUSER
		, UPDATEDATE
		, UPDATEUSER
		) VALUES (
		  '2'
		, '包府磊 包府'
		, '1'
		, 'Admin Setting'
		, ''
		, '0'
		, 'Y'
		, SYSDATE
		, 'darkhowk'
		, SYSDATE
		, 'darkhowk'
		)
;				

INSERT INTO 
	MENU (
		  SEQ
		, MENUNAME
		, MENULEVEL
		, MENUCATEGORY
		, MENULINK
		, MENUAUTH
		, USEYN
		, CREATEDATE
		, CREATEUSER
		, UPDATEDATE
		, UPDATEUSER
		) VALUES (
		  '3'
		, '荤侩磊 包府'
		, '1'
		, 'Admin Setting'
		, ''
		, '0'
		, 'Y'
		, SYSDATE
		, 'darkhowk'
		, SYSDATE
		, 'darkhowk'
		)
;	
---------------------------------------------------------------
SELECT
	  SEQ
	, MENUNAME
	, MENULEVEL
	, MENUCATEGORY
	, MENULINK
	, MENUAUTH
	, USEYN
FROM 
	akatsukirin.MENU
WHERE 1=1
	AND USEYN = 'Y'
	;
	
	
	
	COMMIT;
	
