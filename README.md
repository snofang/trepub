# trepub
** as a boilerplate consisting the followings: **
* Spring MVC
* OAuth2
* MySQL

** keyStore generation commands **
* keytool -genkeypair -alias jwt -keyalg RSA -keypass trepub123 -keystore jwt.jks -storepass trepub123
* keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12
* keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey

** db ** 
* trepub_db_schema.sql
* trepub_db_content.sql