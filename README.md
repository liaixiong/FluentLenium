# What is FluentLenium ?

[![Travis](https://travis-ci.com/FluentLenium/FluentLenium.svg?branch=develop)](https://travis-ci.com/FluentLenium/FluentLenium)
[![Coveralls](https://coveralls.io/repos/github/FluentLenium/FluentLenium/badge.svg?branch=develop)](https://coveralls.io/github/FluentLenium/FluentLenium?branch=develop)
[![Maintainability](https://api.codeclimate.com/v1/badges/27aabb596e9d9eee7182/maintainability)](https://codeclimate.com/github/FluentLenium/FluentLenium/maintainability)
[![Maven Central](https://img.shields.io/maven-central/v/org.fluentlenium/fluentlenium-parent.svg)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.fluentlenium%22%20AND%20a%3A%22fluentlenium-parent%22)
[![Website](https://img.shields.io/website-up-down-green-red/http/fluentlenium.com.svg)](https://fluentlenium.com)

FluentLenium helps you writing readable, reusable, reliable and resilient UI functional tests for the browser.

FluentLenium provides a Java [fluent interface](http://en.wikipedia.org/wiki/Fluent_interface) to
[Selenium](http://www.seleniumhq.org/), and brings some [extra features](https://fluentlenium.com/docs/key_features/)
 to avoid common issues faced by Selenium users.

FluentLenium is shipped with adapters for [JUnit4](https://junit.org/junit4/), [JUnit5](https://junit.org/junit5/), [TestNG](http://testng.org/doc/index.html), [Spock](http://spockframework.org/) and [Cucumber](https://cucumber.io), but it can also be used [standalone](https://fluentlenium.com/docs/test-runners/#standalone-mode).

FluentLenium best integrates with [AssertJ](http://joel-costigliola.github.io/assertj/), but you can also choose to use
the [assertion framework](https://fluentlenium.com/docs/assertion-libraries/) you want.

FluentLenium gives you [multiple methods](https://fluentlenium.com/docs/test-methods/) which help you write tests quicker. All those methods are tested daily by commercial regression test suites maintained by project developers.

## Documentation

Detailed documentation is available on [fluentlenium.com](https://fluentlenium.com).

# Quickstart with JUnit and AssertJ

Quickstart steps are described in detail in our [separate documentation section](https://fluentlenium.com/quickstart/).

Short summary:

- Add dependencies to your `pom.xml`.

```xml
<properties>
    <!-- Configure this property to latest available version -->
    <fluentlenium.version>4.2.2</fluentlenium.version>
    <!-- Make sure the selenium.version won't be overridden by another pom.xml -->
    <selenium.version>3.141.59</selenium.version>
</properties>

<dependency>
    <groupId>org.fluentlenium</groupId>
    <artifactId>fluentlenium-junit</artifactId>
    <version>4.2.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.fluentlenium</groupId>
    <artifactId>fluentlenium-assertj</artifactId>
    <version>4.2.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

- Add basic FluentLenium test

```java
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Wait
public class DuckDuckGoTest extends FluentTest {
    @Test
    public void titleOfDuckDuckGoShouldContainSearchQueryName() {
        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        assertThat(window().title()).contains("FluentLenium");
    }
}
```

- Run as a JUnit test.

More detailed FluentLenium examples are available in [examples section](https://github.com/FluentLenium/FluentLenium/tree/develop/examples).
Examples include `headless` Chrome and Firefox, [Spring](https://spring.io/)-based framework supporting multiple browsers and [much more](https://fluentlenium.com/quickstart/#more-examples).

# Modules summary

To help you navigate through FluentLenium, here's a short summary about its modules and what support they provide.

- **fluentlenium-core**: Contains core functionality of FluentLenium, including webdriver configuration, page object support and injection logic.
- **fluentlenium-junit**: Provides support for integration with [JUnit 4](https://junit.org/junit4/).
- **fluentlenium-junit-jupiter**: Provides support for integration with [JUnit 5](https://junit.org/junit5/).
- **fluentlenium-testng**: Provides support for integration with [TestNG](https://testng.org/doc/index.html).
- **fluentlenium-spock**: Provides support for integration with [Spock](http://spockframework.org).
- **fluentlenium-cucumber**: Provides support for integration with [Cucumber](https://cucumber.io). This may be combined with any of the modules above that are also supported by Cucumber.
- **fluentlenium-assertj**: Provides [AssertJ](http://joel-costigliola.github.io/assertj/) assertions for FluentLenium specific objects like `FluentWebElement`, `FluentList` and `FluentPage`.
- **fluentlenium-integration-tests**: Integration tests for validating the correctness of FluentLenium features internally.
- **fluentlenium-coverage-report**: Creates jacoco test coverage report.
- **fluentlenium-ide-support**: Though not an actual Maven module, it contains resources to make working with FluentLenium in the IDE easier.

# Contact Us
If you have any comment, remark or issue, please open an issue on
[FluentLenium Issue Tracker](https://github.com/FluentLenium/FluentLenium/issues)
