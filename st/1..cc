#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;

char lower(char ch) {
    return ch<='Z' ? ch+'a'-'A' : ch;
}
vector<string> split(string s) {
    vector<string> ret;
    string cur = "";
    for (char ch: s) {
        if (isalpha(ch)) {
            cur += string(1, lower(ch));
        } else {
            ret.push_back(cur);
            cur = "";
        }
    }
    return ret;
}
// struct cmp {
//     bool operator()(pair<int, string> a, pair<int, string> b) const{
//         if (a.first-b.first) return a.first>b.first;
//         return a.second < b.second;
//     }
// };
int main(int argc, char const *argv[])
{
    string s;
    cin >> s;
    vector<string> vs = split(s);
    map<string, int> count;
    for (auto str: vs) {
        count[str]++;
    }
    vector<pair<int, string> > ans;
    for (auto p: count) {
        ans.push_back(make_pair(p.second, p.first));
    }   
    sort(ans.begin(), ans.end(), [](pair<int, string> a, pair<int, string> b){
        if (a.first-b.first) return a.first>b.first;
        return a.second < b.second;
    });
    int i=0;
    for (; i<ans.size() && ans[i].first==ans[0].first; i++) cout<<ans[i].second<<endl;
    return 0;
}
