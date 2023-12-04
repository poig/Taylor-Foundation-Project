#include <iostream>
using namespace std;

// Formula : n! = n * (n - 1)!

int iFact(int n) {
	int fac = 1;
	for (int k = 1; k <=n; k++) 
		fac = k * fac;
	return fac;
}


int rFact(int n) {
	if (n <= 1)
		return 1;
	else
		return n * rFact(n - 1);
}


//Formula : F(n) = F(n-1) + F(n-2)

int iFibo(int n) {
	if (n <= 1)
		return n;
	int a = 0; // (n-2)
	int b = 1; // (n-1)
	for (int k = 2; k <= n; k++) {
		int c = b + a;
		a = b;			// new n-2
		b = c;			// new n-1
	}
	return b;
}


int rFibo(int n) {
	if (n <= 1)
		return n;
	else
		return rFibo(n-1) + rFibo(n-2);
}


int main() {
	int num;
	cout << "Enter a positive integer number ? ";
	cin >> num;
	cout << "Iterative  factorial = " << iFact(num) << endl;
	cout << "Recursive  factorial = " << rFact(num) << endl;
	cout << "Iterative  fibonacci = " << iFibo(num) << endl;
	cout << "Recursive  fibonacci = " << rFibo(num) << endl;
	return 0;
}
