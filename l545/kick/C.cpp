#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int N = 1001;
int A[N], B[N], n;
typedef pair<int,int> P;
int main(int argc, char const *argv[])
{
    int _,ca=1; cin>>_;
    while (_--) {
        cin>>n; int nn=3*n;
        for (int i=0;i<3*n;i++) cin>>A[i];
        for (int i=0;i<3*n;i++) cin>>B[i];
        sort(A, A+n*3); reverse(A, A+nn);
        sort(B, B+nn);
        vector<vector<int> > b;
        do {
            b.push_back(vector<int>{B[0]+B[1]+B[2], B[3]+B[4]+B[5], B[6]+B[7]+B[8]});
        } while (next_permutation(B,B+9));
        int ans = 0;
        int Alast = A[6]+A[7]+A[8];
        for (int mask=0;mask<(1<<6);mask++) if (__builtin_popcount(mask)==3) {

            int s[3] = {0,0,Alast};
            for (int i=0;i<6;i++) if (mask>>i&1) {
                s[0] += A[i];
            } else s[1] += A[i];
            int cnt = 0;
            for (auto p: b) {
                int tmp = 0;
                for (int i=0;i<3;i++) if (s[i]>p[i]) tmp++;
                if (tmp>=2) cnt++;
            }
            ans=max(ans, cnt);
        }
     //  prt(ans);     prt(b.size());
        printf("Case #%d: %.10f\n", ca++, ans*1.0/double(b.size())); 
    }
    return 0;
}
