#include <bits/stdc++.h>
using namespace std;
typedef long long LL;

bool validate(string str) {
    int n = str.size();
    stack<char> S;
    map<char, int> order;
    order['{'] = -1; order['}'] = 1;
    order['['] = -2; order[']'] = 2;
    order['('] = -3; order[')'] = 3;
    int last = 4; //  order[')'] + 1
    for (char ch: str) {
        if (order.find(ch)==order.end()) continue;
        if (order[ch]<0) {
            if (!S.empty() && abs(order[ch]) < abs(order[S.top()])) { // example: [{}]
                return false;
            }
            if (ch=='(' || ch=='[') {
                if (!S.empty() && S.top()==ch) {  // (( ))
                    return false;
                }
            }
            S.push(ch);
        } else {
            if (S.empty()) return false;
            if (order[S.top()] + order[ch] == 0) {
                if (order[ch] == last-1 || ch=='}') { // } should be popped after ], )  
                    S.pop();
                    last = order[ch];
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    return S.empty();
}
int main(int argc, char const *argv[])
{
    string s;
    while (cin>>s) {
        cout<<validate(s)<<endl;
    }
    return 0;
}
