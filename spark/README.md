# запуск из docker
python
1. Создать рабочий каталог spark-docker
2. из созданного каталога запускаем 

docker run -d -p 8888:8888 -v $PWD:/home/user/work --name spark jupyter/pyspark-notebook

-d - запускает в фоновом режиме 
-p - проброс портов из контейнера в локальную машину 
-v $PWD:/home/user/work - позволяет сопоставить папку из которой вызывается контейнер с
с рабочим каталогом контейнера /home/user/work
в этом каталоге будут сохраняться файлы python и доступны все файлы на локальной машине в каталоге запуска
--name spark - имя контейнера

jupyter/pyspark-notebook - образ docker 

http://localhost:8888 -- проверка работы 

docker stop spark
docker start spark
docker rm spark