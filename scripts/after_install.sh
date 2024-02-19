#!/bin/bash
set -e

PROJECT_ROOT="/home/ubuntu"
JAR_FILE="$PROJECT_ROOT/NiceTest-0.0.1-SNAPSHOT.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# 기존 JAR 파일이 존재하면 삭제
if [ -f "$JAR_FILE" ]; then
    echo "$TIME_NOW > 기존 $JAR_FILE 파일 삭제" >> $DEPLOY_LOG
    rm "$JAR_FILE"
fi

# build 파일 복사
echo "$TIME_NOW > $JAR_FILE 파일 복사" >> $DEPLOY_LOG
cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE

# jar 파일 실행
echo "$TIME_NOW > $JAR_FILE 파일 실행" >> $DEPLOY_LOG
nohup java -jar $JAR_FILE > $APP_LOG 2> $ERROR_LOG &

CURRENT_PID=$(pgrep -f $JAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG
