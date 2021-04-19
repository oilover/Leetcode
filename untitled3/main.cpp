#include <iostream>
#include <bits/stdc++.h>
using namespace std;

//class  Singleton {
//public:
//    static Singleton* getInstance() {
//        if (instance==NULL) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//private:
//    Singleton() {};
//    static Singleton *instance ;
//};
class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        map<char, int> op;
        op['{'] = 1;
        op['['] = 2;
        op['('] = 3;
        op[')'] = 4;
        op[']'] = 5;
        op['}'] = 6;
        for (char ch: s) {
            if (op[ch]>=4) { //右括号
                if (stk.empty()) {
                    return false;
                }
                if (op[stk.top()] != 7-op[ch]) { //不匹配
                    return false;
                }
                stk.pop();
            }else {
                if (!stk.empty() && op[stk.top()] > op[ch]) { // 外面必须优先级高 不能 ([
                    return false;
                }
                stk.push(ch);
            }

        }
        return stk.empty(); // 最后栈为空
    }
};
int main() {
//    Singleton *s = Singleton::getInstance();
//    std::cout << s << std::endl;
//    s = Singleton::getInstance();
//    std::cout << s << std::endl;
    Solution *solution = new Solution();
    cout << solution->isValid("[()]")<<endl;
    cout << solution->isValid("[()")<<endl;
    cout << solution->isValid("([])");
    return 0;
}
