# 특정 웹 페이지를 포함하고 있는 웹 서버 이미지를 생성

http://localhost:8080/hello.html 요청하면 hello docker 메시지를 반환하는 웹 서비스를 제공하는 이미지를 생성



## **방법1. 우분투 이미지를 이용해서 컨테이너를 실행하고 컨테이너 내부를 변경한 후 이미지를 생성**

**#1 작업 디렉터리 생성**

```
vagrant@xenial64:~/chap02$ mkdir ~/webserver && cd ~/webserver
```



**#2 hello.html 파일을 생성**

```
vagrant@xenial64:~/webserver$ echo "hello docker" > hello.html
vagrant@xenial64:~/webserver$ cat hello.html
hello docker
```



**#3 우분투 이미지를 이용해서 컨테이너를 실행**

```
 vagrant@xenial64:~/webserver$ docker container rm -f myweb
 myweb
 
vagrant@xenial64:~/webserver$ docker container run -dit -p 8080:80 --name myweb ubuntu:14.04
d8337bf2c8199d9227db7bb77986aa51c2457151d63c2311ee27e968136c6393

vagrant@xenial64:~/webserver$ docker container ls
CONTAINER ID    IMAGE        COMMAND         CREATED       STATUS       PORTS                            NAMES
d8337bf2c819    ubuntu:14.04    "/bin/bash"     15 seconds ago   Up 14 seconds    0.0.0.0:8080->80/tcp  myweb
```



**#4 컨테이너 내부의 쉘로 접속**

```
vagrant@xenial64:~/webserver$ docker container exec -it myweb /bin/bash
root@d8337bf2c819:/# exit
exit
```



**#5 컨테이너 내부에 아파치 웹 서버를 설치 및 실행**

```
root@d8337bf2c819:/# apt-get update
root@d8337bf2c819:/# apt-get install apache2 -y

root@d8337bf2c819:/# service apache2 status 
* apache2 is not running

root@d8337bf2c819:/# service apache2 start 
* Starting web server apache2                                      AH00558: apache2: Could not reliably determine the server's fully qualified domain name, using 172.17.0.2. 
Set the 'ServerName' directive globally to suppress this message *

root@d8337bf2c819:/# service apache2 status 
* apache2 is running

root@d8337bf2c819:/# ls /var/www/html
index.html

root@d8337bf2c819:/# exit
exit
```



**#6 아파치 웹 서버의 웹 루트에 hello.html 파일을 복사**

```
vagrant@xenial64:~/webserver$ docker container cp ./hello.html myweb:/var/www/html/

vagrant@xenial64:~/webserver$ docker container exec myweb cat /var/www/html/hello.html
hello docker
```



**#7 컨테이너로 웹 서비스를 요청**

```
vagrant@xenial64:~/webserver$ curl http://localhost:8080/hello.html
hello docker
```



**#8 이미지를 생성**

```
vagrant@xenial64:~/webserver$ docker commit myweb myanjini/myweb:latest
sha256:4d477e6f42d06c2e08db4d9f8902a3c89a2beace68291273fc43d7524f5b998c

vagrant@xenial64:~/webserver$ docker image ls
REPOSITORY     TAG         IMAGE ID      CREATED       SIZE
myanjini/myweb   latest     4d477e6f42d0    6 seconds ago 221MB
example/echo    latest       16a4c3b0f222    4 hours ago  750MB
example/echo    old         16a4c3b0f222    4 hours ago   750MB
recommand      latest       6a667c9fadb5    5 hours ago   73.9MB
falloc_100m     latest       cb419b52df77    5 hours ago  179MB
busybox       latest       6858809bf669    6 days ago     1.23MB
ubuntu       latest       4e2eef94cd6b    3 weeks ago     73.9MB
alpine       latest       a24bb4013296    3 months ago    5.57MB
ubuntu       14.04        6e4f1fe62ff1    9 months ago    197MB
jenkins       latest       cd14cecfdb3a    2 years ago    696MB
golang       1.9         ef89ef5c42a9    2 years ago      750MB
```



## 방법2. Dockerfile을 작성해서 이미지를 생성



**#1 Dockerfile 정의**

```
vagrant@xenial64:~/webserver$ vi Dockerfile
```

```
FROM  ubuntu:14.04

RUN  apt-get update
RUN  apt-get install -y apache2
ADD  hello.html /var/www/html/
EXPOSE 80
CMD  apachectl  -DFOREGROUND
```



**#2 Dockerfile을 빌드해서 이미지 생성**

```
vagrant@xenial64:~/webserver$ docker image build -t myanjini/myweb:dockerfile .

vagrant@xenial64:~/webserver$ docker image ls
REPOSITORY     TAG         IMAGE ID      CREATED       SIZE
myanjini/myweb   dockerfile  30e168051d24   16 seconds ago   221MB
myanjini/myweb   latest      4d477e6f42d0   11 minutes ago   221MB
example/echo    latest       16a4c3b0f222    4 hours ago     750MB
```



**#3 생성한 이미지로 컨테이너를 실행**

```
vagrant@xenial64:~/webserver$ docker container run -d -p 9090:80 --name mywebdockerfile myanjini/myweb:dockerfile
d2acd021ff6464bb1c518652a9a5555886b3531dd730e1cede97efc92e78c68a

vagrant@xenial64:~/webserver$ curl http://localhost:9090/hello.html
hello docker
```



**#4 생성한 이미지로 컨테이너를 실행 (호스트 포트를 랜덤하게 지정)**

```
vagrant@xenial64:~/webserver$ docker container run -d -P --name mywebrandport myanjini/myweb:dockerfile
c892aa35710c2656f1fe636850e62ab154086b26f897417bcc1fd602f9f41567
⇒ 호스트의 랜덤하게 할당된 포트와 컨테이너에서 EXPOSE된 포트를 자동으로 맵핑

vagrant@xenial64:~/webserver$ docker port mywebrandport
80/tcp -> 0.0.0.0:32770

vagrant@xenial64:~/webserver$ docker container ls
CONTAINER ID    IMAGE            COMMAND         CREATED       STATUS       PORTS          NAMES
c892aa35710c    myanjini/myweb:dockerfile  "/bin/sh -c 'apachec…"  2 minutes ago    Up 2 minutes    0.0.0.0:32770->80/tcp  mywebrandport   
d2acd021ff64    myanjini/myweb:dockerfile  "/bin/sh -c 'apachec…"  4 minutes ago    Up 4 minutes    0.0.0.0:9090->80/tcp  mywebdockerfile
d8337bf2c819    ubuntu:14.04        "/bin/bash"       24 minutes ago   Up 24 minutes    0.0.0.0:8080->80/tcp  myweb

vagrant@xenial64:~/webserver$ curl http://localhost:32770/hello.html
hello docker
```





---

---

---







# **wordpress와 mysql을 연동한 워드프로세스 기반 블로그 서비스**



**#1 작업 디렉터리 생성**

```
vagrant@xenial64:~/webserver$ mkdir ~/blog && cd ~/blog
vagrant@xenial64:~/blog$
```



**#2 mysql 서비스를 제공하는 컨테이너를 실행**

도커 허브를 검색 ⇒ https://hub.docker.com/_/mysql 

```
vagrant@xenial64:~/blog$ docker run -d --name wordpressdb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=wordpress mysql:5.7 
```

- ``-e`` : 컨테이너 내부의 환경변수 설정    ==> key=value

  

**#3 워드프레스 이미지를 이용한 웹 서버 컨테이너를 실행**

워드프레스에서 필요로 하는 값 (설정) ⇒ https://hub.docker.com/_/wordpress

```
vagrant@xenial64:~/blog$ docker run -d -e WORDPRESS_DB_PASSWORD=password --name wordpress --link wordpressdb:mysql -p 80 wordpress
```

-e : 환경변수 지정

--link wordpressdb:mysql:  wordpressdb라는 컨테이너를 mysql이라는 이름으로 사용하겠다

> wordpress 컨테이너 내부에서 mysql이라고 언급하는건 다 wordpressdb를 의미한다



**#4 컨테이너 실행 확인**

```
vagrant@xenial64:~/blog$ docker container ls
CONTAINER ID    IMAGE            COMMAND         CREATED       STATUS       PORTS          NAMES
7a26c2712474    wordpress          "docker-entrypoint.s…"  19 seconds ago   Up 18 seconds    0.0.0.0:32772->80/tcp  wordpress
d562bcfaa1b0    mysql:5.7          "docker-entrypoint.s…"  7 minutes ago    Up 7 minutes    3306/tcp, 33060/tcp   wordpressdb
```



**#5 워드프레스 컨테이너 내부에서 wordpressdb 이름의 컨테이너(mysql로 alias되어 있음)로 연결되는지 확인**

```
vagrant@xenial64:~/blog$ docker container exec -it wordpress /bin/bash
root@7a26c2712474:/var/www/html# ping mysql
bash: ping: command not found
root@7a26c2712474:/var/www/html# apt-get update
		:
root@7a26c2712474:/var/www/html# apt-get install -y iputils-ping
		:
root@7a26c2712474:/var/www/html# ping mysql
PING mysql (172.17.0.6) 56(84) bytes of data.
64 bytes from mysql (172.17.0.6): icmp_seq=1 ttl=64 time=0.100 ms
64 bytes from mysql (172.17.0.6): icmp_seq=2 ttl=64 time=0.039 ms
64 bytes from mysql (172.17.0.6): icmp_seq=3 ttl=64 time=0.054 ms
64 bytes from mysql (172.17.0.6): icmp_seq=4 ttl=64 time=0.041 ms
^C
--- mysql ping statistics ---
4 packets transmitted, 4 received, 0% packet loss, time 4ms
rtt min/avg/max/mdev = 0.039/0.058/0.100/0.025 ms
```



**#6 VirtualBox 관리자에서 포트 포워딩 설정**

## ![img](https://lh4.googleusercontent.com/FNwXCPKOY1zMneNvjJgJkOH7WhTUjf-rWRH1mMjnBQHsz9vHCjWSh9O417AMIVmejxR4bkMtPFd7DCrwkjWde-sT3kVh6KmDs9QmhRXcMgv-rime6K6bEV_oNi01o4wmyMSSK3qW)

![img](https://lh3.googleusercontent.com/-6Y0gcdQ2ulj4XthneKbn_Ri4_purfrL7eXHfvZgyE0ERikAawTAnSGG_aBewqcEJLltxw8g9Yu5PJstWexDuks7YdWZjwJc_ZEyonNGRDGxiYNovsRrraAbQqiBNMWF1z6pp_Cq)

- 호스트 포트, 게시트 포트 ⇒ docker container ls 했을 때 나오는 호스트의 포트
- 게스트 IP ⇒ Ubuntu 가상머신에서 ifconfig 했을 때 나오는 enp0s3 NIC의 IP 



**#7 내 PC에 브라우저에서 http://localhost:32772 로 접속**

![img](https://lh6.googleusercontent.com/90-a8tGDZ6prvVpXMPhvkIJmH__Y_pQ43Bb70wTji5kq05Q3vto3Li8lbe0UReE06ARb7Ijki03t30_J7JMojSz99KkcWiZDd8WbnpIvNUrnmSmX7lubsGrP2I5igzCtfazXcJb1)

