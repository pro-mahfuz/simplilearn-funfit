package com.funfit.dao;


import java.sql.*;


public class DBConnection {


public static Connection getConnection()
throws Exception{


Class.forName(
"com.mysql.cj.jdbc.Driver"
);


return DriverManager.getConnection(

getSetting("funfit.db.url", "FUNFIT_DB_URL", "jdbc:mysql://localhost:3306/funfit"),
getSetting("funfit.db.user", "FUNFIT_DB_USER", "root"),
getRequiredSetting("funfit.db.password", "Dbpass@123456")

);


}


private static String getSetting(
String propertyName,
String environmentName,
String defaultValue
){


String value = System.getProperty(propertyName);


if(value == null || value.isBlank()){


value = System.getenv(environmentName);


}


return value == null || value.isBlank()
? defaultValue
: value;


}


private static String getRequiredSetting(
String propertyName,
String environmentName
){


String password = getSetting(
propertyName,
environmentName,
null
);


if(password == null){


throw new IllegalStateException(
"Configure the database password with " +
environmentName + " or -D" + propertyName
);


}


return password;


}

}
