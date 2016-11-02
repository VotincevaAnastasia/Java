@echo off
cls
echo 1.1
java -cp "out/production/java;lib/*" Main
set res=0
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 1.2
java -cp "out/production/java;lib/*" Main -h
set res=0
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%

echo 2.1
java -cp "out/production/java;lib/*" Main -login 'XXX' -pass 'XXX'
set res=1
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 2.2
java -cp "out/production/java;lib/*" Main -login jdoe -pass XXX
set res=2
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 2.3
java -cp "out/production/java;lib/*" Main -login jdoe -pass sup3rpaZZ
set res=0
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%

echo 3.1
java -cp "out/production/java;lib/*" Main -login jdoe -pass sup3rpaZZ -role Read -res a
set res=0
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 3.2
java -cp "out/production/java;lib/*" Main -login jdoe -pass sup3rpaZZ -role Write -res a.b
set res=0
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 3.3
java -cp "out/production/java;lib/*" Main -login jdoe -pass sup3rpaZZ -role XXX -res a.b
set res=3
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 3.4
java -cp "out/production/java;lib/*" Main -login jdoe -pass sup3rpaZZ -role Read -res XXX
set res=4
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 3.5
java -cp "out/production/java;lib/*" Main -login jdoe -pass sup3rpaZZ -role Write -res a
set res=4
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 3.6
java -cp "out/production/java;lib/*" Main -login jdoe -pass sup3rpaZZ -role Write -res a.bc
set res=4
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%

echo 4.1
java -cp "out/production/java;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'Read' -res 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol '100'
set res=0
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 4.2
java -cp "out/production/java;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'Read' -res 'a.b' -ds '01-01-2015' -de '2015-12-31' -vol '100'
set res=5
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 4.3
java -cp "out/production/java;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'Read' -res 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
set res=5
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%

echo 5.1
java -cp "out/production/java;lib/*" Main -login 'X' -pass 'X' -role 'Read' -res 'X' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
set res=1
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%
echo 5.2
java -cp "out/production/java;lib/*" Main -login 'X' -pass 'X' -role 'Read' -res 'X'
set res=1
if %errorlevel% equ %res% echo success %errorlevel% **%res%
if %errorlevel% neq %res% echo error %errorlevel% **%res%

