# Quick start with Servlet in a .war archive

Random notes self:

* For quick auto deploy to a local WildFly instance when packaging, add to `pom.xml/build/plugins`:

    ```xml
    <plugin>
        <groupId>org.wildfly.plugins</groupId>
        <artifactId>wildfly-maven-plugin</artifactId>
        <version>1.2.2.Final</version>
        <executions>
            <execution>
                <id>deploy</id>
                <phase>package</phase>
                <goals>
                    <goal>deploy</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
    ```

* To enable remote debugging, launch server instance with with jvn options:
    ```
    -agentlib:jdwp=transport=dt_socket,address=<SOME IP>:8787,server=y,suspend=n
    ```

* In WildFly, REST with multipart config doesn't work. Workaround is to have a depedency of:

    ```xml
    <dependency>
		<groupId>org.jboss.resteasy</groupId>
		<artifactId>resteasy-multipart-provider</artifactId>
		<version>2.2.0.GA</version>
	</dependency>
    ```

    or delegate requests to support servlet.

    Otherwise, config `web.xml` may look like for a `GlassFish` server:

    ```xml
    <servlet>
        <servlet-name>com.webarity.main.configuration.RestApplication</servlet-name>
        <multipart-config>
            <max-file-size>11120848820</max-file-size>
        </multipart-config>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>com.webarity.main.configuration.RestApplication</servlet-name>
        <url-pattern>/api/*</url-pattern>
    </servlet-mapping>
    ```

* For auto local deployment to wildfly, in `pom.xml` add to `build/plugins`:

    ```xml
    <plugin>
        <groupId>org.wildfly.plugins</groupId>
        <artifactId>wildfly-maven-plugin</artifactId>
        <version>1.2.2.Final</version>
        <executions>
            <execution>
                <id>deploy</id>
                <phase>package</phase>
                <goals>
                    <goal>deploy</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
    ```
* Files in the `src/main/resources/` folder are accessed using:

    ```java
    //java 8:
    OutputStream os = rs.getOutputStream();
    InputStream is = getClass().getResourceAsStream("/notes.txt");

    byte[] b = new byte[20];

    int length = 0;
    while ((length = is.read(b, 0, b.length)) > 0) {
        os.write(b, 0, length);
    }
    os.flush();

    //java 9:
    try (
        java.io.OutputStream os = rs.getOutputStream();
        java.io.InputStream is = getClass().getResourceAsStream("/notes.txt");
    ) {
        os.write(is.readAllBytes());
        os.flush();
    } catch (Exception ex) {

    }
    ```

---

## Prerequisites:
* JDK >= 9
* Maven >= 3.5.x

## Running:
* `mvn clean package`
* `then deploy somehow`

---

https://www.webarity.com