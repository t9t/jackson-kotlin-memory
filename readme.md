# jackson-module-kotlin memory issue

This repository shows a potential memory issue with `jackson-module-kotlin`, or
more specifically the `KotlinModule`.

When running `Main.kt`, I get output similar to:

```
Using kotlinObjectMapper
    Reading KRepository
      -> Before: 2.97MiB; After: 400.03MiB; Allocated: 397.06MiB
    Reading JRepository
      -> Before: 5.31MiB; After: 206.31MiB; Allocated: 201.0MiB
Using plainObjectMapper
    Reading KRepository
      -> Before: 5.49MiB; After: 206.49MiB; Allocated: 201.0MiB
    Reading JRepository
      -> Before: 5.56MiB; After: 206.56MiB; Allocated: 201.0MiB
```

This shows me that using the `KotlinModule` with a Kotlin `data class` causes
approximately twice the memory overhead than when using a Java `record` or
when not using the `KotlinModule` at all.


## Running
With JDK17 or higher and Maven:

```
MAVEN_OPTS="-Xms2G -Xmx2G" mvn clean verify exec:java
```

The `-Xms` and `-Xmx` are useful to try and avoid garbage collections while
the test loop is running.
