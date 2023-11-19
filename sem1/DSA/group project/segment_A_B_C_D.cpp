#include <iostream>
#include <math.h>
using namespace std;

// a) n^2 + 2 + 3n + n^3
int segment_A_a(int n) {
    // O(n^3)
    int num_op = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                // Some operation
                num_op++;
            }
        }
    }

    // O(n^2)
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            // Some operation
            num_op++;
        }
    }

    // O(3n)
    for(int i = 0; i < n; i++) {
        // Some operation
        num_op++;
        // Some operation
        num_op++;
        // Some operation
        num_op++;
    }

    // O(2)
    // Some operation
    num_op++;
    // Some operation
    num_op++;
    return num_op;

}

// b) log4 n + 3n
int segment_A_b(int n) {
    int num_op = 0;
    // O(log4 n)
    for(int i = 1; i < n; i *= 4) {
        // Some operation
        num_op++;
    }

    // O(3n)
    for(int i = 0; i < n; i++) {
        // Some operation
        num_op++;
        // Some operation
        num_op++;
        // Some operation
        num_op++;
    }
    return num_op;

}

// a) log5 n + 2n
int segment_B_a(int n) {
    int num_op = 0;
    // O(log5 n)
    for(int i = 1; i < n; i *= 5) {
        // Some operation
        num_op++;
    }

    // O(2n)
    for(int i = 0; i < n; i++) {
        // Some operation
        num_op++;
        // Some operation
        num_op++;
    }
    return num_op;

}

// b) 3n + n^3 + 2 + n^4
int segment_B_b(int n) {
    int num_op = 0;
    // O(n^4)
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                for(int l = 0; l < n; l++) {
                    // Some operation
                    num_op++;
                }
            }
        }
    }

    // O(n^3)
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                // Some operation
                num_op++;
            }
        }
    }

    // O(3n)
    for(int i = 0; i < n; i++) {
        // Some operation
        num_op++;
        // Some operation
        num_op++;
        // Some operation
        num_op++;
    }

    // O(2)
    // Some operation
    num_op++;
    // Some operation
    num_op++;
    return num_op;
}



// a) O(2n^3 + n + 2)
int segment_C_a(int n) {
    int num_op = 0;
    // O(2n^3)
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                // Some operation
                num_op++;
                num_op++;
            }
        }
    }

    // O(n)
    for(int i = 0; i < n; i++) {
        // Some operation
        num_op++;
    }

    // O(2)
    // Some operation
    num_op++;
    // Some operation
    num_op++;
    return num_op;
}

// b) O(n^4 + nlog3n)
int segment_C_b(int n) {
    // O(n^4)
    int num_op = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                for(int l = 0; l < n; l++) {
                    // Some operation
                    num_op++;
                }
            }
        }
    }

    // O(nlog3n)
    for(int i = 0; i < n; i++) {
        for(int j = 1; j < n; j *= 3) {
            // Some operation
            num_op++;
        }
    }
    return num_op;
}


// a) O(2n + n^2 + nlog2n)
int segment_D_a(int n) {
    // O(2n)
    int num_op = 0;
    for(int i = 0; i < n; i++) {
        // Some operation
        num_op++;
        // Some operation
        num_op++;
    }

    // O(n^2)
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            // Some operation
            num_op++;
        }
    }

    // O(nlog2n)
    for(int i = 0; i < n; i++) {
        for(int j = 1; j < n; j *= 2) {
            // Some operation
            num_op++;
        }
    }
    return num_op;
}

// b) O(3n^2 + n + 1)
int segment_D_b(int n) {
    // O(3n^2)
    int num_op = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            // Some operation
            num_op++;
            // Some operation
            num_op++;
            // Some operation
            num_op++;
        }
    }

    // O(n)
    for(int i = 0; i < n; i++) {
        // Some operation
        num_op++;
    }

    // O(1)
    // Some operation
    num_op++;

    return num_op;
}

double log_ab(int a, int b) {
    return std::log(b) / std::log(a);
}

int main() {
    int n = 3;
    //Segment C
    //a) O(2n^3 + n + 2)
    if (round(segment_C_a(n) - (2*pow(n,3)+n+2)) == 0){
     cout << "C_a True" << endl;
    }
    // b) O(n^4 + nlog3n)
    if (round(segment_C_b(n) - (pow(n,4) + (n * log_ab(3,n)))) == 0){
     cout << "C_b True" << endl;
    }

    //segment D
    // a) O(2n + n^2 + nlog2n)
    if (round(segment_D_a(n) - ((2*n) + pow(n,2) + (n * ceil(log_ab(2,n))))) == 0){
     cout << "D_a True" << endl;
    }
    //cout << segment_D_a(n) << endl; //21
    //cout << ((2*n) + pow(n,2) + (n * log_ab(2,n))) << endl; //18

    // b) O(3n^2 + n + 1)
    if (round(segment_D_b(n) - (3*pow(n,2) + n + 1)) == 0){
     cout << "D_b True" << endl;
    }
    
    return 0;
}
