#!/usr/bin/expect -d

set timeout 1
spawn ./go.sh
#expect -re {.*Enter password:.*}
#send "222test\r"
expect -re {.*mysql\>.*}
send [exec bash -c "cat test"]\r
expect -re {.*asdasd\>.*}
exit
