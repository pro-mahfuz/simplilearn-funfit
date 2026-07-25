# FunFit

FunFit is a Java 17 Servlet/JSP application backed by MySQL.

## Database configuration

The application reads database settings from Java system properties first, then environment variables:

| Setting | Environment variable | Default |
| --- | --- | --- |
| Database URL | `FUNFIT_DB_URL` | `jdbc:mysql://localhost:3306/funfit` |
| Database user | `FUNFIT_DB_USER` | `root` |
| Database password | `FUNFIT_DB_PASSWORD` | Required |

For PowerShell, configure the password before starting your servlet container:

```powershell
$env:FUNFIT_DB_PASSWORD = 'your-mysql-password'
```

To start locally without installing Tomcat, run:

```powershell
mvn -Pdev-server package exec:java
```

Open `http://localhost:8080/FunFit/` after the server starts.

To deploy to an external Servlet 4-compatible container such as Tomcat 9, package the application with Maven:

```powershell
mvn clean package
```

Deploy `target/FunFit.war` to the container.
