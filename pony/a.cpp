#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int n,m;
LL a[66];
bool OK(LL a[], int n) {
    if (n<=2) return true;
    LL b = a[1] - a[0];
    for (int i=1;i<n;i++) {
        if (a[i]!=a[0]+i*b) return false;
    }
    return true;
}
bool OK(LL a[], int n, int a0, int b) {
    if (n<=2) return true;
    for (int i=1;i<n;i++) {
        LL expect = a0+ i*b;
        if (expect % a[i] == 0) {
            LL t = expect / a[i];
            if (t==0) return false;
            if (t&(t-1)) return false;
            a[i] = expect;
        }
        else return false;
    }
    return true;
}
void print(LL a[], LL n) {
    for (int i=0;i<n;i++) cout<<a[i]<<endl;
}

void recover(LL &x) {
    while (x%2==0) x/=2;
}
void recover(LL a[], int n) {
    for (int i=0;i<n;i++) recover(a[i]);
}
int main(int argc, char const *argv[])
{
    cin>>n;
    for (int i=0;i<n;i++)read(a[i]);
    if (OK(a,n)) {
        print(a,n); return 0;
    }
    int t = a[2] - a[0];
    int b = t/2;
    if (t%2==0) {
        if (OK(a,n, a[0], b)){
            print(a,n); return 0;
        } 
    }
    if ((a[3]-a[1])%2==0) {
        b = (a[3]-a[1])/2;
        if (OK(a,n, a[1]-b, b)){
            print(a,n); return 0;
        } 
    }
    // for (int i=)
    LL a0 = a[0], a1 = a[1];
    for (int i=0;i<30;i++) {
        a1 = a[1];
        for (int j=0;j<30;j++) {
            if (OK(a,n, a0, a1-a0)) {
                print(a,n); return 0;
            }
            a1*=2;
            recover(a,n);
        }
          recover(a,n);
         a0*=2; 
    }
    return 0;
}
