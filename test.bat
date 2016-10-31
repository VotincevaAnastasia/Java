@echo off
java -cp "out/production/IdeaProjects;lib/*" Main
echo %errorlevel% **0
java -cp "out/production/IdeaProjects;lib/*" Main -h
echo %errorlevel% **0

java -cp "out/production/IdeaProjects;lib/*" Main -login 'XXX' -pass 'XXX'
echo %errorlevel% **1
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'XXX'
echo %errorlevel% **2
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ'
echo %errorlevel% **0

java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a'
echo %errorlevel% **0
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b'
echo %errorlevel% **3
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'XXX' -res 'a.b'
echo %errorlevel% **3
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'XXX'
echo %errorlevel% **4
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'WRITE' -res 'a'
echo %errorlevel% **4
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'WRITE' -res 'a.bc'
echo %errorlevel% **4

java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol '100'
echo %errorlevel% **0
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b' -ds '01-01-2015' -de '2015-12-31' -vol '100'
echo %errorlevel% **5
java -cp "out/production/IdeaProjects;lib/*" Main -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
echo %errorlevel% **5

java -cp "out/production/IdeaProjects;lib/*" Main -login 'X' -pass 'X' -role 'READ' -res 'X' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
echo %errorlevel% **1
java -cp "out/production/IdeaProjects;lib/*" Main -login 'X' -pass 'X' -role 'READ' -res 'X'
echo %errorlevel% **1

