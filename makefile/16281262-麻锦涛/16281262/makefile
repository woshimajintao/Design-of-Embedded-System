CC = gcc
hello:hello.o
	$(CC) hello.o -o hello
	
hello.o:hello.c
	$(CC) -c hello.c -o hello.o

clean:
	rm -rf hello *.o