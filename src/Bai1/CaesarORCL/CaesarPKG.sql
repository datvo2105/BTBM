CREATE OR REPLACE PACKAGE caesarCrypt 
IS
    FUNCTION Func_encryptChar (c CHAR, k INT) RETURN CHAR;
    FUNCTION Func_decryptChar (c CHAR, k INT) RETURN CHAR;
    FUNCTION Func_encryptMessage (msg VARCHAR, k INT) RETURN VARCHAR;
    FUNCTION Func_decryptMessage (msg VARCHAR, k INT) RETURN VARCHAR;
    PROCEDURE Proc_encryptMessage (msg IN VARCHAR, k IN INT, output OUT VARCHAR);
    PROCEDURE Proc_decryptMessage (msg IN VARCHAR, k IN INT, output OUT VARCHAR);
END caesarCrypt;

CREATE OR REPLACE PACKAGE BODY caesarCrypt IS

        charIndex NUMBER(2);
    FUNCTION Func_encryptChar (c CHAR, k INT) RETURN CHAR IS
    BEGIN 
        charindex := ASCII('A');
        IF REGEXP_LIKE(c,'[a-zA-Z]') THEN
            RETURN CHR(charIndex + (ASCII(c) - charIndex + k) MOD 26);
        ELSE
            RETURN NULL;
        END IF;
    END Func_encryptChar;
    FUNCTION Func_decryptChar (c CHAR, k INT) RETURN CHAR IS
    BEGIN 
        charindex := ASCII('A');
        IF REGEXP_LIKE(c,'[a-zA-Z]') THEN
            RETURN CHR(charIndex + (ASCII(c) - charIndex - k) MOD 26);
        ELSE
            RETURN NULL;
        END IF;
    END Func_decryptChar;
    FUNCTION Func_encryptMessage (msg VARCHAR, k INT) RETURN VARCHAR 
    IS
        output VARCHAR(100) := '';    
    BEGIN 
        FOR i IN 1..LENGTH(msg)
        LOOP
            output  := output || Func_encryptChar(SUBSTR(UPPER(msg), i, 1), k);
        END LOOP;
        RETURN output;
    END Func_encryptMessage;
    FUNCTION Func_decryptMessage (msg VARCHAR, k INT) RETURN VARCHAR 
    IS
        output VARCHAR(100) := '';    
    BEGIN 
        FOR i IN 1..LENGTH(msg)
        LOOP
            output  := output || Func_decryptChar(SUBSTR(UPPER(msg), i, 1), k);
        END LOOP;
        RETURN output;
    END Func_decryptMessage;
    PROCEDURE Proc_encryptMessage (msg IN VARCHAR, k IN INT, output OUT VARCHAR) IS
    BEGIN
        charindex := ASCII('A');
        FOR i in 1..LENGTH(msg)
        LOOP
            output := output || Func_encryptChar(SUBSTR(UPPER(msg), i, 1), k);
        END LOOP;
    END Proc_encryptMessage;
    PROCEDURE Proc_decryptMessage (msg IN VARCHAR, k IN INT, output OUT VARCHAR) IS
    BEGIN
        charindex := ASCII('A');
        FOR i in 1..LENGTH(msg)
        LOOP
            output := output || Func_decryptChar(SUBSTR(UPPER(msg), i, 1), k);
        END LOOP;
    END Proc_decryptMessage;
END caesarCrypt;

SELECT caesarCrypt.Func_encryptMessage('HELLO', 3) "EncryptMSG" FROM DUAL;
SELECT caesarCrypt.Func_decryptMessage('KHOOR', 3) "DecryptMSG" FROM DUAL;
/