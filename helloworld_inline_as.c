#include <stdio.h>
#include <arm_neon.h>
int main(){
int a = 0, b = 10;
char * format = "a = %d, b = %d, c = %d\n";
__asm__ __volatile__ (
   	"ldr r0,=0x11111111\n\t"
	"vmov.U32 d0[0], r0\n\t"
        "ldr r0,=0x22222222\n\t"
	"vmov.U32 d0[1], r0\n\t"
        "ldr r0,=0x33333333\n\t"
        "vmov.U32 d1[0], r0\n\t"
        "ldr r0,=0x22222222\n\t"
	"vmov.U32 d1[1], r0\n\t"
        "VPADD.S16 d2,d0,d1\n\t"
    	"vmov.U32 r0,d2[0]\n\t"
        "vmov.U32 r1,d2[1]\n\t"
	"mov %0, r0\n\t"
	"mov %1, r1\t"

        : "=r" (a),"=r" (b)
        :
        : "r0","r1"
);
__asm__ __volatile__ ( 
"mov r0, %2\n\t"
"mov r1, %0\n\t"
"mov r2, %1\n\t"
"mov r3, %3\n\t"
"bl printf\n\t"                
:
: "r" (a), "r" (b), "r" (format), "g" (3 * 4)
: "r0", "r1", "r2", "r3"
);
printf("16231015»Ó∫£∫Ω 16281055‘¨Àß\n");
return 0;
}

