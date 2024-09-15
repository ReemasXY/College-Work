
#include<stdio.h>

int sum (int n) {

return ((n*(n+1)*((2*n)+1))/6);

}

int iteration(int n) {

int sum1=0,i;

for(i=1; i<=n; i++) {

sum1+=i*i;

}
return sum1;
}

void main() {

int n;

printf("Enter a number: ");

scanf("%d",&n);

if(iteration(n)==sum(n)) {

printf("Induction is true");

} 
else {

printf("Induction is false");

}

}


