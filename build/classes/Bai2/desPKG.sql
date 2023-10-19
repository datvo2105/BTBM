CREATE OR REPLACE PACKAGE desCipher
IS
    FUNCTION Func_encryptMessage (message VARCHAR2, sercetKey VARCHAR2) RETURN RAW DETERMINISTIC;
    FUNCTION Func_decryptMessage (msgEncrypted RAW, sercetKey VARCHAR2) RETURN VARCHAR2 DETERMINISTIC;
END desCipher;

CREATE OR REPLACE PACKAGE BODY desCipher 
AS 
    desType PLS_INTEGER := DBMS_CRYPTO.ENCRYPT_DES
                        +  DBMS_CRYPTO.CHAIN_CBC
                        +  DBMS_CRYPTO.PAD_PKCS5;
    FUNCTION Func_encryptMessage (message VARCHAR2, sercetKey VARCHAR2) RETURN RAW DETERMINISTIC
    IS 
        k RAW(200) := UTL_RAW.CAST_TO_RAW(sercetKey); -- Đổi thành độ dài 200 để chứa đủ key tự tạo
        msgEncrypted RAW(2000);
    BEGIN
        msgEncrypted := DBMS_CRYPTO.ENCRYPT( src => UTL_RAW.CAST_TO_RAW(message),
                                             typ => desType,
                                             key => k);
        RETURN msgEncrypted;
    END Func_encryptMessage;
    FUNCTION Func_decryptMessage (msgEncrypted RAW, sercetKey VARCHAR2) RETURN VARCHAR2 DETERMINISTIC
    IS
        k RAW(200) := UTL_RAW.CAST_TO_RAW(sercetKey);-- Đổi thành độ dài 200 để chứa đủ key tự tạo
        message RAW(2000);
    BEGIN 
        message := DBMS_CRYPTO.DECRYPT( src => msgEncrypted,
                                    typ => desType,
                                    key => k);
        RETURN UTL_RAW.CAST_TO_VARCHAR2(message);
    END Func_decryptMessage;
END desCipher;
/
SET SERVEROUTPUT ON;

DECLARE 
    message VARCHAR2(200) := 'HELLO ORACLE';
    cipherText RAW(2000);
BEGIN
    cipherText := desCipher.Func_encryptMessage(message, 'KEY');
    DBMS_OUTPUT.PUT_LINE('ENCRYPT: ' || cipherText);
    DBMS_OUTPUT.PUT_LINE('DECRYPT: ' || desCipher.Func_decryptMessage(cipherText, 'KEY'));    
END;