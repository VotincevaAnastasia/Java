#!/usr/bin/env bash
result=0 # number of failed tests

test(){
    let "tests += 1"
    ./run.sh $1
    if [ $? == $2 ] ; then
        echo "Test OK - $tests $1"
        let "testsOk += 1"
    else
        echo "Test Fail - $tests $1"
    fi
}

./BUILD.sh


test " " 0
test "-h" 0

test "-l QQQQ -p QQQQ" 1
test "-l jdoe -p QQQQ" 2
test "-l jdoe -p sup3rpaZZ" 0

test "-l jdoe -p sup3rpaZZ -ro READ -re a" 0
test "-l jdoe -p sup3rpaZZ -ro READ -re a.b" 0
test "-l jdoe -p sup3rpaZZ -ro QQQQ -re a.b" 3
test "-l jdoe -p sup3rpaZZ -ro READ -re QQQQ" 4
test "-l jdoe -p sup3rpaZZ -ro WRITE -re a" 4
test "-l jdoe -p sup3rpaZZ -ro WRITE -re a.bc" 4

test "-l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol 100" 0
test "-l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 01-01-2015 -de 2015-12-31 -vol 100" 5
test "-l jdoe -p sup3rpaZZ -ro READ -re a.b -ds 2015-01-01 -de 2015-12-31 -vol QQQQ" 5

test "-l QQQQ -p QQQQ -ro READ -re QQQQ -ds 2015-01-01 -de 2015-12-31 -vol QQQQ" 1
test "-l QQQQ -p QQQQ -ro READ -re QQQQ" 1


if [ $testsOk == $tests ] ; then
    echo "Completed"
    exit 0
else
    echo "Fail"
    exit 1
fi