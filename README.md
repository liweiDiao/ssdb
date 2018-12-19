# ssdbDemo   java实现连接ssdb demo    待完善

# centos安装ssdb中碰到了错误，以下是解决办法。    

1、centos安装ssdb，依次执行以下命令：

    1.1: wget --no-check-certificate https://github.com/ideawu/ssdb/archive/master.zip
    1.2: unzip master
    1.3: cd ssdb-master
    1.4: make
    如果报以下错误：
    ERROR! autoconf required! install autoconf first

    Makefile:4: build_config.mk: No such file or directory
    make: *** No rule to make target `build_config.mk'.  Stop.
    
    1.5: 需要安装 autoconf
    yum update
    yum install -y  autoconf
    
    安装autoconf成功后，继续make。报错：
    make[1]: Entering directory `/root/ssdb-master/deps/leveldb-1.18'
    g++ -I. -I./include -fno-builtin-memcmp -pthread -DOS_LINUX -DLEVELDB_PLATFORM_POSIX -DSNAPPY -I../snappy-1.1.0 -O2 -DNDEBUG -c        
    db/builder.cc -o db/builder.o
    make[1]: g++: Command not found
    make[1]: *** [db/builder.o] Error 127
    make[1]: Leaving directory `/root/ssdb-master/deps/leveldb-1.18'
    make: *** [all] Error 2
    
    1.6：需要安装g++
    yum -y install gcc+ gcc-c++
    安装g++成功后，继续make。报错：（有的情况不报错。不报错代表可以跳过1.7  ）
    g++: error: /root/ssdb-master/deps/snappy-1.1.0/.libs/libsnappy.a: No such file or directory
    make[1]: *** [all] Error 1
    make[1]: Leaving directory `/root/ssdb-master/src'
    make: *** [all] Error 2
    
    1.7： snappy 没有编译成功，因为你的系统时钟有问题，解决如下：（可参考官网介绍的这个错误的解决方案）
    cd deps/snappy-1.1.0;
    ./configure
    make
    
    1.8： 安装Snappy成功后，返回到ssdb-master目录
    make
    #默认将安装在 /usr/local/ssdb 目录下
    make install
    
    如果想安装在其他目录下：
    sudo make install PREFIX=/your/direcotry
    
    安装成功。
    
    启动和停止等操作可参考官网说明。
    
    
    
    
