# Requires
## Install
1. JDK 1.8
2. Gradle
3. mosqquitto-clients (Ubuntu: `apt install mosquitto-clients` )

# Build all inclusive Jar
gradle shadowJar

# Run the micro-service
## Linux

Note: Replace 192.168.1.17 with your own IP. Change port, if necessary.
```
export broker=tcp://192.168.1.17
java -jar build/libs/mdemo.jar
```

# Test
Use mosquitto_pub and mosquitto_sub to test

## Sample Steps:
### First subscribe:
`mosquitto_sub -h 192.168.1.17 -t 'squared/#'`

### Then publish:
`mosquitto_pub -h 192.168.1.17 -t 'square' -m '3'`


