#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 1100100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
struct Node {
    int val;
    Node *left, *right;
    Node(int x) : val(x), left(NULL), right(NULL) {}
};
P p[N];
int a[N], dp[N];
int n;
int lengthOfLIS() {
    int len = 0;
    dp[len++] = a[0];
    for (int i=1;i<n;i++) {
        if (a[i] >= dp[len-1]) {
            dp[len++] = a[i];
        } else {
            int p = upper_bound(dp, dp+len, a[i])-dp;
            dp[p] = a[i];
        }
    }
    // for (int num : a) {
        
    //     int i = lower_bound(dp, dp+len+1, num) - dp;
    //     if (i < 0 ) {
    //         i = -(i + 1);
    //     }
    //     dp[i] = num;
    //     if (i == len) {
    //         len++;
    //     }
    // }
    return len;
}

int main(int argc, char const *argv[])
{
    cin>>n;
    for (int i=0;i<n;i++) {
        read(p[i].first); read(p[i].second);
    }
    sort(p,p+n);
    for (int i=0;i<n;i++) {
        a[i]=p[i].second;
    }
    int ans = lengthOfLIS();
    cout<<ans<<endl;
    return 0;
}
