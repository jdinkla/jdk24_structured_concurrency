# print this help
help:
  @just --list

# run all
all: listing1 listing5 listing7

check:
    @java --version

listing1:
    @./gradlew --quiet listing1

listing5:
    @./gradlew --quiet listing5

listing7:
    @./gradlew --quiet listing7

