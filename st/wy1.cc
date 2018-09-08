#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 100100;
typedef pair<int,int> P;
template <class T>
void print(vector<T> v) {
    for (auto x: v) cout<<" "<<x; cout<<endl;
}

int main(int argc, char const *argv[])
{
    int _; cin>>_;
    int n,k;
    while (_--) {
        read(n); read(k);
        int mi,ma;
        int t = n/2+1;
        if (k>=n/2 + 1) {
            ma = n-  t - (k-t);
        } else {
            ma=  k-1;
        }
        if (k==0) ma=0;
        cout<<"0 "<<ma<<endl;
    }
    return 0;
}
