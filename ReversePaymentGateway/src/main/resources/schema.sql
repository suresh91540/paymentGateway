DROP TABLE IF EXISTS BENEFICIARY;  
CREATE TABLE BENEFICIARY (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
beneficiary_name VARCHAR(50) NOT NULL,  
beneficiary_account_number INT(8) NOT NULL,
beneficiary_balance INT(6) NOT NULL
); 

DROP TABLE IF EXISTS PAYEE;  
CREATE TABLE PAYEE (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
payee_name VARCHAR(50) NOT NULL,  
payee_account_number INT(8) NOT NULL,
payee_balance INT(6) NOT NULL
); 