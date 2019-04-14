include C:/AndroXStudio/Tools/make_comm
all:
	$(CC) -mfpu=neon -mfloat-abi=softfp -save-temps -o helloworld_inline_as helloworld_inline_as.c $(CFLAGS) $(LDFLAGS)