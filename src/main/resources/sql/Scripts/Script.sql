DROP TABLE MENU;
CREATE TABLE 
	MENU (
		  SEQ VARCHAR2(200) PRIMARY KEY
		, MENUNAME VARCHAR2(100) NOT NULL
		, MENULEVEL NUMBER(1) NOT NULL 
		, MENUCATEGORY VARCHAR2(100) NOT NULL
		, MENULINK VARCHAR2(100)
		, MENUAUTH CHAR(1) NOT NULL
		, MENUGBN char(1) NOT NULL 
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
		, MENUGBN
		, USEYN
		, CREATEDATE
		, CREATEUSER
		, UPDATEDATE
		, UPDATEUSER
		) VALUES (
		  '1'
		, '메뉴 관리'
		, '0'
		, 'MENU MANEGE'
		, ''
		, '0'
		, 'A'
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
		, MENUGBN
		, USEYN
		, CREATEDATE
		, CREATEUSER
		, UPDATEDATE
		, UPDATEUSER
		) VALUES (
		  '2'
		, '관리자 메뉴'
		, '1'
		, 'MENU MANEGE'
		, '/admin/adminMenuMng'
		, '0'
		, 'A'
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
		, MENUGBN
		, USEYN
		, CREATEDATE
		, CREATEUSER
		, UPDATEDATE
		, UPDATEUSER
		) VALUES (
		  '3'
		, '사용자 메뉴'
		, '1'
		, 'MENU MANEGE'
		, '/admin/userMenuMng'
		, '0'
		, 'A'
		, 'Y'
		, SYSDATE
		, 'darkhowk'
		, SYSDATE
		, 'darkhowk'
		)
;	
---------------------------------------------------------------
SELECT
	*
FROM 
	akatsukirin.MENU
WHERE 1=1
	AND USEYN = 'Y'
	;
	
	
	
	COMMIT;
	
