.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-help:
	./build/install/app/bin/app -h

run-diff:
	./build/install/app/bin/app ./src/test/resources/file1.json ./src/test/resources/file2.json

run-complex:
	./build/install/app/bin/app ./src/test/resources/fileComplex1.json ./src/test/resources/fileComplex2.json

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build