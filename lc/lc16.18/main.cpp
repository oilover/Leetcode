#include <iostream>
#include <bits/stdc++.h>
#define prt(k) cout<<#k" = "<<k<<endl
typedef long long LL;
using namespace std;
class Solution {
public:
    bool patternMatching(string p, string s) {
        int a=0,b=0;
        int n = s.size(), m= p.size();

        if (p[0]=='b') {
            for (char &c: p) {
                c= c=='a' ? 'b' : 'a';
            }
        }
        for (char c: p) {
            if(c=='a')a++; else b++;
        } // a>0
        for (int la=0;la<=n/a;la++) {
            if (b>0 && (n-la*a)%b != 0) continue;
            int lb = b==0 ? 0 : (n-la*a)/b;
            int cnt = 0;
            string sa = s.substr(0,la);
            string sb = s.substr(la, lb);
            if (b!=0 && sa==sb) continue;
            bool ok = true;
            for (int i=0;i<m;cnt+=p[i]=='a'?la:lb,i++) {
                if (i>=1) {
                    if (p[i]=='a' && s.substr(cnt,la)==sa) {
                        continue;
                    }
                    if (p[i]=='b' && s.substr(cnt,lb)==sb) {
                        continue;
                    }
                    ok = false; break;
                }
            }
            if (ok&&cnt==n) return true;
        }
        return false;
    }
};
int main() {
    std::cout << (new Solution())->patternMatching("aaaa",
                                                   "dogcatcatdog") << std::endl;
    return 0;
}
