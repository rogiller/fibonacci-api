# Fibonacci Api Project

### Running the Fibonacci Api

To use a pre-compiled JAR go to `build/libs`

run: `java -Xmx256m -jar fibonacci.jar`

From Repo Root: `./gradlew bootRun`

Fibonacci Endpoints are available at
- http://localhost:8090/current
- http://localhost:8090/next
- http://localhost:8090/previous

### Important Note on Spring Boot Performance

Using a `t2.nano` machine on AWS EC2 with `0.5GB` of memory and `1 vCPU`, 
Spring Boot is unable to sustain much more than 200 reqs/per second over 30 seconds 
against the `/current` endpoint (which does nothing but return an `long` from memory).
If you go much higher than the 200 reqs per second, Spring Boot will fall over.

**Moral:** The Fibonacci function in the `FibonacciController` is NOT the bottle neck. 
If you check the `FibonacciControllerTest` timing tests, you will see that it can do
10000+ Fibonacci computes in less than 100 millisecons.



