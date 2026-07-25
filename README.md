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

## Run in STS

1. Import the folder as an **Existing Maven Project**.
2. Right-click `FunFit Dev Server.launch` and choose **Run As > FunFit Dev Server**.
3. Open `http://localhost:8080/FunFit/`.

Alternatively, add the project to an STS **Tomcat 9** server. The project is configured for Java 17 and Servlet 4.0, with the context root `FunFit`.

To deploy to an external Servlet 4-compatible container such as Tomcat 9, package the application with Maven:

```powershell
mvn clean package
```

Deploy `target/FunFit.war` to the container.
