source ./CONFIG.sh

rm -rf $OUT

# Копируем библиотеки
mkdir -p $OUT_LIB
cp $LIB $OUT_LIB

# Создаем временную папку
mkdir -p $OUT_CLS

# Компиляция всех *.java файлов
find . -permission "*.java" | xargs javac -cp "$CP" -d $OUT_CLS -sourcepath $SRC -verbose

# Архивация всех классов в $OUT_JAR в jar файл, где $MAIN – класс с main()
jar -cfe $OUT_JAR $MAIN -C $OUT_CLS .