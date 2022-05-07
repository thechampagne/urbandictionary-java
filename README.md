# Urban Dictionary

[![](https://img.shields.io/github/v/tag/thechampagne/urbandictionary-java?label=version)](https://github.com/thechampagne/urbandictionary-java/releases/latest) [![](https://img.shields.io/github/license/thechampagne/urbandictionary-java)](https://github.com/thechampagne/urbandictionary-java/blob/main/LICENSE)

Urban Dictionary API client for **Java**.

### Download

Replace the **VERSION** key below with the version shown above.

**Gradle**
```gradle
dependencies {
    implementation 'io.github.thexxiv:urbandictionary:VERSION'
}
```

**Maven**
```xml
<dependency>
    <groupId>io.github.thexxiv</groupId>
    <artifactId>urbandictionary</artifactId>
    <version>VERSION</version>
</dependency>
```

### Example

```java
public static void main(String[] args) {
    System.out.println(UrbanDictionary.search("Java", 1));
}
```

### License

Urban Dictionary is released under the [MIT License](https://github.com/thechampagne/urbandictionary-java/blob/main/LICENSE).