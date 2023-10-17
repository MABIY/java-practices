### annotation processor debug
1. test-annotaion-processor 
   ```text
    implementation project(':java-base:annotation-processing:annotation')
    annotationProcessor project(':java-base:annotation-processing:annotation-processor')
   ```
2. ![annotation-processor.png](..%2F..%2Fasserts%2Fannotation-processor%2Fannotation-processor.png)
2. config gradle build
    ```shell
    :java-base:annotation-processing:test-annotation-processor:clean annotation-processing:test-annotation-processor:build --stacktrace
    ```
   ![gradle-debug-annotation-processor.png](..%2F..%2Fasserts%2Fannotation-processor%2Fgradle-debug-annotation-processor.png)
3. set breakpoin
   ![breakPoint.png](..%2F..%2Fasserts%2Fannotation-processor%2FbreakPoint.png)