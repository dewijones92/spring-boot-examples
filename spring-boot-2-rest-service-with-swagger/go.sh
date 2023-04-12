(set -x; ./gradlew  clean build  --debug &&  ./gradlew bootRun   --debug) |& tee log
