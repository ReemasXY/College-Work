#include <stdio.h>

int wellorder (int a[], int size) {

int i, least=a[0];
for(i=1; i<=size-1; i++) {

if(a[i]<least) {

least=a[i];

}

}

return least;
}

void main() {

int a[]= {1,2,3,4,5,6,0};

int size= sizeof(a)/sizeof(a[0]);

int least =wellorder(a,size);

printf("Smallest element= %d", least);

}


